package practise.Thread;

import java.util.Date;

/**
 * @author fuzhennan
 */
public class TestInterrupt {
    public static void main(String[] args){
        MyThread myThread=new MyThread();
        myThread.start();
    try {
        Thread.sleep(1000);
    }catch (InterruptedException e){
        myThread.interrupt();
    }
    }
}

class MyThread extends Thread{

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
