package practise.Thread;

/**
 * @author fuzhennan
 */
public class TestPrintLetters implements Runnable {
    private char c ='a';
    @Override
    public void run() {
        while (c<='z'){
            print();
        }
    }

    private synchronized void print() {
        if (c<='z'){
            System.out.println(Thread.currentThread().getName()+":"+c);
            c++;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        TestPrintLetters testPrintLetters = new TestPrintLetters();
        Thread t1 = new Thread(testPrintLetters);
        Thread t2 = new Thread(testPrintLetters);
        t1.setName("t1"); t2.setName("t2");
        t1.start(); t2.start();
    }
}
