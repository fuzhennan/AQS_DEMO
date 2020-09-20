package practise.Thread;

/**
 * @author fuzhennan
 */
public class TestPrintNums implements Runnable{
    private int num =1;
    @Override
    public void run() {
        while (num <= 9){
            print();
        }
    }

    private synchronized void print() {
        if (num <= 9){
            System.out.println(Thread.currentThread().getName()+":" + num);
            num++;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        TestPrintNums testPrintNums = new TestPrintNums();
        Thread t1 = new Thread(testPrintNums);
        Thread t2 = new Thread(testPrintNums);
        Thread t3 = new Thread(testPrintNums);
        t1.setName("t1"); t2.setName("t2"); t3.setName("t3");
        t1.start(); t2.start(); t3.start();
    }
}
