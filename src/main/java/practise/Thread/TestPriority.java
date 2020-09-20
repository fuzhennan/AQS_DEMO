package practise.Thread;

/**
 * @author fuzhennan
 */
public class TestPriority {
    public static void main(String[] args){
        ThreadPriorityHigh high=new ThreadPriorityHigh();
        ThreadPriorityLow low=new ThreadPriorityLow();
        Thread t1=new Thread(high);
        Thread t2=new Thread(low);
        t1.setPriority(Thread.NORM_PRIORITY+3);
        t1.start();t2.start();
    }
}

class ThreadPriorityLow implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("low"+i);
        }
    }
}

class ThreadPriorityHigh implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("high"+i);
        }
    }
}