package com.hkllyx.solution.util;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流线程池工具
 *
 * @author hkllyx
 */
public class ConcurrencyThrottleTaskExecutor {
    /** 线程池 */
    private final ExecutorService pool;
    /** 线程池可承受最大任务数量 */
    private final int limit;
    /** 控制线程池队列大小，设定最大值 = limit + nThreads */
    private final AtomicInteger queueCtrl = new AtomicInteger();
    /** 线程池队列大小监视器 */
    private final Object monitor = new Object();


    /**
     * 初始化
     *
     * @param nThreads 线程池大小。必须 > 0
     * @param limit    线程池可承受最大任务数量。必须 >= nThreads，如果设定值 < nThreads，则 limit = nThreads
     * @param poolName 线程池名
     */
    public ConcurrencyThrottleTaskExecutor(int nThreads, int limit, String poolName) {
        if (nThreads <= 0) {
            throw new IllegalArgumentException("线程池大小必须 > 0，nThreads = " + nThreads);
        }
        if (limit < nThreads) {
            limit = nThreads;
        }
        this.limit = limit;
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger atomicCounter = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, poolName + "-pool-" + atomicCounter.getAndIncrement());
            }
        };
        pool = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(limit << 1), threadFactory);
    }

    public void execute(Runnable task) {
        beforeAccess();
        try {
            pool.execute(task);
        } finally {
            afterAccess();
        }
    }

    /**
     * 在执行任务前调用
     */
    private void beforeAccess() {
        // 如果线程池中任务数量达到 limit，则等待
        while (queueCtrl.get() >= limit) {
            synchronized (monitor) {
                try {
                    monitor.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        queueCtrl.incrementAndGet();
    }

    /**
     * 在执行任务完成后调用。放于 try-finally 的 finally 块中
     */
    private void afterAccess() {
        synchronized (monitor) {
            queueCtrl.decrementAndGet();
            monitor.notifyAll();
        }
    }

    /**
     * 关闭线程池，并在指定时间后终止线程
     *
     * @param timeout  超时时间
     * @param timeUnit 时间单位
     * @throws InterruptedException 强行中断等待异常
     */
    public boolean shutdownAndAwaitTerminate(Long timeout, TimeUnit timeUnit) throws InterruptedException {
        pool.shutdown();
        return pool.awaitTermination(timeout, timeUnit);
    }
}
