package lld.messagingqueue;

public class Producer {
    public static void produce(Object data) throws InterruptedException {
        Consumer consumer=Consumer.getInstance();
        consumer.publish(data);
    }
}
