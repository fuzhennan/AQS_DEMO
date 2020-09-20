package interview.juc;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 《阿里巴巴Java开发手册》中强制线程池不允许使用Executors去创建
 * 而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则
 * 规避资源耗尽的风险
 * @author fuzhennan
 */
public class TestThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            Runnable worker = new ThreadPoolExecutorDemo("" + i);
            pool.execute(worker);
        }

        pool.shutdown();
        while (!pool.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}

class ThreadPoolExecutorDemo implements Runnable{
    private String command;

    public ThreadPoolExecutorDemo(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start time: "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+"end time: "+new Date());
    }

    public void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ThreadPoolExecutorDemo{" +
                "command='" + command + '\'' +
                '}';
    }
}
