package interview.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  synchronized ：隐式锁，可重入锁，非公平锁，同步代码块，同步方法
 *
 *  jdk1.5之后：
 *  同步锁：显示锁：lock，
 *                      reentrant lock 可重入锁，可实现公平锁
 *  需要通过lock（）方法上锁，必须通过unlock方法进行锁释放
 * @author fuzhennan
 */
public class TestReentrantLock {
    public static void main(String[] args){
        Ticket ticket = new Ticket();
        for (int i = 0; i < 10; i++) {
            new Thread(ticket,i+"号窗口售票").start();
        }
    }
}

class Ticket implements Runnable{
    Lock lock = new ReentrantLock();
    private int tick = 100;
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (tick>0){
                    try {
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName()+"售票完成，余票为："+ --tick);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}