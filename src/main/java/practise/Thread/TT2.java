package practise.Thread;

/**
 * @author fuzhennan
 */
public class TT2 implements Runnable{
    int b=100;

    public synchronized void m1() throws Exception{
        b=1000;
        Thread.sleep(5000);
        System.out.println("b="+b);
    }
    public void m2() throws Exception {
        Thread.sleep(2500);
        b=2000;
    }

    @Override
    public void run() {
        try{
            m1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception{
        TT2 tt=new TT2();
        Thread t1=new Thread(tt);
        t1.start();

        tt.m2();
    }
}
