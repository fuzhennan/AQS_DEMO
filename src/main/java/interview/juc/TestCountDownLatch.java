package interview.juc;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch 闭锁:允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助。
 *      CountDownLatch用给定的计数初始化。
 *      await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，
 *      之后所有等待线程被释放，并且任何后续的await 调用立即返回。
 *
 * @author fuzhennan
 */
public class TestCountDownLatch {
    public static void main(String[] args){
        final CountDownLatch latch = new CountDownLatch(5);
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo(latch);
        //线程开始计时
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5 ; i++) {
            new Thread(countDownLatchDemo).start();
        }
        try {
            //等待5个线程全部结束，才开始结束计时
            //阻塞当前main线程，直到count值为0，也就是五个子线程执行完毕
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程结束计时
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为: " + (end-start));
    }
}

class CountDownLatchDemo implements Runnable{

    private CountDownLatch latch;

    public CountDownLatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this){
            try{
                for (int i = 0; i < 50000; i++) {
                    if (i%2 == 0){
                        System.out.println(i);
                    }
                }
            }finally {
                //每次使用完一个线程计数都要-1
                latch.countDown();
            }
        }
    }
}