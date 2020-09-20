package interview.aqs;

import java.util.concurrent.locks.Lock;

/**
 * 自定义同步组件TwinsLock 测试类
 * @author fuzhennan
 */
public class TwinsLockTest {

    public static void main(String[] args){
        final Lock lock = new TwinsLock();

        class Worker extends Thread{

            @Override
            public void run(){
                while (true){
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        //启动十个线程
        for (int i = 0 ;i < 10; i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        //每个一秒换行
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
