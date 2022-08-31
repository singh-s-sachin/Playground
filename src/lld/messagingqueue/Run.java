package lld.messagingqueue;

public class Run {
    public static void main(String args[]) throws Exception {
        for (int i = 0; i < 20; i++) {
            Producer.produce(i);
            Thread.sleep(200);
        }
        for (int i = 0; i < 20; i++) {
            Producer.produce("Mark : "+(i + 80));
            Thread.sleep(150);
        }
    }
}

/**
 * 1
 * / \
 * 4 2
 * / \ / \
 * 3 3 5 5
 * / \ / \
 * 6 7 6 7
 */