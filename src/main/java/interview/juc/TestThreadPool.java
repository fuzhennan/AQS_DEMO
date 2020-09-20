package interview.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程，避免了创建于销毁的额外开销，提高了响应速度
 *
 * 二、线程池的体系结构
 *      java.util.concurrent.Executor：负责线程的使用与调度的根接口
 *          |--**ExecutorService 子接口：线程池的主要接口
 *              |--ThreadPoolExecutor 线程池的实现类
 *              |--ScheduledExecutorService 子接口：负责线程的调度
 *                  |--ScheduledThreadPoolExecutor ： 继承ThreadPoolExecutor，实现ScheduledExecutorService
 * @author fuzhennan
 */
public class TestThreadPool {
    public static void main(String[] args){
        ThreadPoolDemo td = new ThreadPoolDemo();

        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 5 ; i++) {
            //为线程池中的线程分配任务
            pool.submit(td);
        }

        //关闭线程池
        pool.shutdown();

        //callable方法实现
//        ExecutorService pool = Executors.newFixedThreadPool(5);
//        List<Future<Integer>> list = new ArrayList<>();
//
//        for (int i = 0; i <10 ; i++) {
//            Future<Integer> future = pool.submit(new Callable<Integer>() {
//
//                @Override
//                public Integer call() throws Exception {
//
//                    int sum = 0;
//                    for (int j = 0; j <= 100; j++) {
//                        sum += j;
//                    }
//                    return sum;
//                }
//            });
//            list.add(future);
//        }
//
//        pool.shutdown();
//        for(Future<Integer> future : list){
//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
    }
}

class ThreadPoolDemo implements Runnable{
    private int i =0;
    @Override
    public void run() {
        while (i<=100){
            System.out.println(Thread.currentThread().getName()+" ："+ i++);
        }
    }
}