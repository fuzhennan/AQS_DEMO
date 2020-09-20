package interview.juc;

/**
 * 生产者和消费者案例
 * @author fuzhennan
 */
public class TestProducerAndConsumer {
    public static void main(String[] args){
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer,"生产者A").start();
        new Thread(consumer,"消费者A").start();

        new Thread(producer,"生产者B").start();
        new Thread(consumer,"消费者B").start();
    }
}

/**
 * 店员
 */
class Clerk{
   private int product = 0;
    //进货
   public synchronized void get(){
       //用while不用if是为了避免虚假唤醒
        while(product >= 10){
            try {
                System.out.println("货柜已满，请先卖货！");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       System.out.println(Thread.currentThread().getName()+" ："+ ++product);
       this.notifyAll();
   }
    //卖货
   public synchronized void sale(){
        while(product==0){
            try {
                System.out.println("货柜空了，先去进货！");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       System.out.println(Thread.currentThread().getName()+"："+ --product);
       this.notifyAll();
   }
}

/**
 * 生产者
 */
class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
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
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
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