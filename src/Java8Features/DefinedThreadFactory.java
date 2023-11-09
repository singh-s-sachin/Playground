package Java8Features;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefinedThreadFactory implements ThreadFactory {

    private static final AtomicInteger THREAD_CREATED_COUNT = new AtomicInteger(0);

    private String threadName;

    public DefinedThreadFactory(String prefix) {
        this.threadName = prefix.concat(" - ");
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(false);
        thread.setName(threadName.concat(String.valueOf(THREAD_CREATED_COUNT.incrementAndGet())));
        return thread;
    }
}
