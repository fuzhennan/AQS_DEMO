package practise.Thread;

import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * @author fuzhennan
 */
public class TestInterruptByRunnable {
    public static void main(String[] args){
    MyThread1 myThread1=new MyThread1();
    new Thread(myThread1).start();
    Thread thread=new Thread();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            thread.interrupt();
        }
    }
}

class MyThread1 implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("==="+new Date()+"===");
            try {
              sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}