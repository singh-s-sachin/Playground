package Java8Features;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiThreading {

    private static final ExecutorService taskThreadPool;
    private static final ExecutorService paymentThreadPool;
    private static final ExecutorService ioPool;

    static {
        taskThreadPool = Executors.newFixedThreadPool(20, new DefinedThreadFactory("TaskThreadPool"));
        paymentThreadPool = Executors.newFixedThreadPool(10, new DefinedThreadFactory("PaymentThreadPool"));
        ioPool = Executors.newCachedThreadPool(new DefinedThreadFactory("IOThreadPool"));
    }

    private static final Function<EcommerceTasks, EcommerceTasks> conclude = ecommerceTasks -> {
        System.out.println(Thread.currentThread().getName() + ":::: TIME ELAPSED :::: " + ecommerceTasks.orderId
                + " ===> " + ecommerceTasks.timeElapsed);
        return ecommerceTasks;
    };
    private static final Function<EcommerceTasks, EcommerceTasks> populateResult = ecommerceTasks -> {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (ecommerceTasks.paymentStatus) {
            System.out.println(Thread.currentThread().getName() + ":::: ORDER ACCEPTED :::: " + ecommerceTasks.orderId);
        } else {
            System.out.println(Thread.currentThread().getName() + ":::: ORDER FAILED :::: " + ecommerceTasks.orderId);
        }
        return ecommerceTasks;
    };

    public static void main(String args[]) throws InterruptedException {
        //performEcomTaskOnCompletableFuture();
        //performEcomTaskOnFuture();
    }

    private static void performEcomTaskOnFuture() throws InterruptedException {

        Instant start = Instant.now();
        System.out.println("Task on performEcomTaskOnFuture started");

        Callable<EcommerceTasks> eComFuture = () -> {
            String prodRef = "Product_".concat(UUID.randomUUID().toString());
            Future<EcommerceTasks> ecommerceTasksFuture = taskThreadPool.submit(() -> new EcommerceTasks());
            Future<EcommerceTasks> generateOrderFuture = taskThreadPool.submit(() -> ecommerceTasksFuture.get().generateOrder(prodRef, 1000d));
            Future<EcommerceTasks> acceptedPaymentFuture = paymentThreadPool.submit(() -> generateOrderFuture.get().acceptPayment());
            Future<EcommerceTasks> generateResult = taskThreadPool.submit(() -> populateResult.apply(acceptedPaymentFuture.get()));
            return taskThreadPool.submit(() -> conclude.apply(generateResult.get())).get();
        };

        List<Callable<EcommerceTasks>> eComFutures = IntStream.range(0, 120).mapToObj(data -> eComFuture)
                .collect(Collectors.toList());

        eComFutures.parallelStream().forEach(future -> ioPool.submit(future));

        System.out.println("Task on performEcomTaskOnFuture triggered futures " + (Instant.now().toEpochMilli() - start.toEpochMilli()));
    }

    private static void performEcomTaskOnCompletableFuture() {
        Supplier<EcommerceTasks> ecommerceTasksSupplier = () -> new EcommerceTasks();
        List<CompletableFuture<EcommerceTasks>> orderFutures = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            String prodRef = "Product_".concat(String.valueOf(i));
            CompletableFuture<EcommerceTasks> orderFuture =
                    CompletableFuture.supplyAsync(ecommerceTasksSupplier, taskThreadPool)
                            .thenApplyAsync(ecommerceTasks -> ecommerceTasks.generateOrder(prodRef, 1000d), taskThreadPool)
                            .thenApplyAsync(EcommerceTasks::acceptPayment, paymentThreadPool)
                            .thenApplyAsync(populateResult, taskThreadPool)
                            .thenApplyAsync(conclude, taskThreadPool
                            );
            orderFutures.add(orderFuture);
        }
        CompletableFuture.allOf(orderFutures.toArray(new CompletableFuture[orderFutures.size()])).join();
    }
}
