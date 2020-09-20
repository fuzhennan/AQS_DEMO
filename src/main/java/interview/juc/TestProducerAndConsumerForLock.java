package interview.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者案例
 * 使用Lock结合Condition实现
 * @author fuzhennan
 */
public class TestProducerAndConsumerForLock {
    public static void main(String[] args){
        ClerkForLock clerk = new ClerkForLock();
        ProducerForLock producer = new ProducerForLock(clerk);
        ConsumerForLock consumer = new ConsumerForLock(clerk);
        new Thread(producer,"生产者A").start();
        new Thread(consumer,"消费者A").start();

        new Thread(producer,"生产者B").start();
        new Thread(consumer,"消费者B").start();
    }
}

/**
 * 店员
 */
class ClerkForLock{
   private int product = 0;
   private Lock lock = new ReentrantLock();
   Condition condition = lock.newCondition();
    //进货
   public void get(){
       lock.lock();
       try{
           //用while不用if是为了避免虚假唤醒
           while(product >= 10){
               try {
                   System.out.println("货柜已满，请先卖货！");
                   condition.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           System.out.println(Thread.currentThread().getName()+" ："+ ++product);
           condition.signalAll();
       }finally {
           lock.unlock();
       }
   }
    //卖货
   public void sale(){
       lock.lock();
       try{
           while(product==0){
               try {
                   System.out.println("货柜空了，先去进货！");
                   condition.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           System.out.println(Thread.currentThread().getName()+"："+ --product);
           condition.signalAll();
       }finally {
           lock.unlock();
       }
   }
}

/**
 * 生产者
 */
class ProducerForLock implements Runnable{

    private ClerkForLock clerk;

    public ProducerForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

/**
 * 消费者
 */
class ConsumerForLock implements Runnable{
    private ClerkForLock clerk;

    public ConsumerForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sale();
        }
    }
}