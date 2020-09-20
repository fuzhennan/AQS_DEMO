package practise.Thread;

/**
 * @author fuzhennan
 */
public class TestDeadLock implements Runnable{
    public int flag=1;
    static Object o1=new Object(), o2=new Object();

    public static void main(String[] args){
        TestDeadLock t1=new TestDeadLock();
        TestDeadLock t2=new TestDeadLock();
        t1.flag=1;t2.flag=0;
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t2);
        thread1.start();thread2.start();
    }

    @Override
    public void run() {
        System.out.println("flag="+flag);
        if (flag==1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }

            }
        if (flag==0){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }

        }

        }
    }

