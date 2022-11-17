package lld.messagingqueue;

import java.util.ArrayList;
import java.util.List;

import static lld.messagingqueue.Consumer.PEEK_TIME;

public class Consumer {
    static final long PEEK_TIME = 1000;
    private static final Consumer consumer = new Consumer();


    private boolean isActive = false;

    //Stack
    List<Object> messages;
    private int top = 0;

    private Consumer() {
        messages = new ArrayList<>();
    }

    public static Consumer getInstance() {
        return consumer;
    }

    public void publish(Object k) {
        messages.add(k);
        if (!isActive) {
            Consumer.runConsumer(consumer);
            isActive = true;
        }
    }

    void peek() {
        int currentSize = messages.size();
        if (currentSize - 1 > top) {
            for (int i = top; i < currentSize; i++, top++) {
                System.out.println("Message : " + messages.get(i));
            }
        }
    }

    private static void runConsumer(Consumer consumer) {
        ConsumerThread consumerThread = new ConsumerThread(consumer);
        consumerThread.start();
    }

}

class ConsumerThread extends Thread {

    private final Consumer consumer;

    ConsumerThread(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.peek();
            try {
                Thread.sleep(PEEK_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
