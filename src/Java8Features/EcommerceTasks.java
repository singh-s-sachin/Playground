package Java8Features;

import java.time.Instant;
import java.util.UUID;

public class EcommerceTasks {
    String orderId;
    String prodRef;
    double total;
    boolean paymentStatus;

    long startTime;
    long timeElapsed;

    public EcommerceTasks acceptPayment() {
        try {
            Thread.sleep((long) (Math.random()*10000));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ":::: ACCEPTING PAYMENT ::::");
        this.paymentStatus = this.orderId.split("4").length > 3;
        System.out.println(Thread.currentThread().getName() + ":::: PAYMENT STATUS UPDATED ::::");
        this.timeElapsed = Instant.now().toEpochMilli() - this.startTime;
        return this;
    }

    public EcommerceTasks generateOrder(String prodRef, Double total){
        System.out.println(Thread.currentThread().getName() + ":::: GENERATING ORDER ::::");
        this.startTime = Instant.now().toEpochMilli();
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.orderId = UUID.randomUUID().toString();
        this.prodRef = prodRef;
        this.total = total;
        System.out.println(Thread.currentThread().getName() + ":::: ORDER GENERATED ::::");
        return this;
    }
}
