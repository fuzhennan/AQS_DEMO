package interview.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程池调度
 *  ScheduledExecutorService  newScheduledThreadPool() :创建固定大小的线程池，可以延迟或定时的执行任务
 * @author fuzhennan
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        //给线程池中的线程添加任务
        for (int i = 0; i < 5 ; i++) {
            Future<Integer> future = pool.schedule(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception{
                    //生成随机数
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName()+" ："+num);
                    return num;
                }
            },1, TimeUnit.SECONDS);
            System.out.println(future.get());
        }
        //关闭线程池
        pool.shutdown();
    }
}

