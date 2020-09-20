package practise.Thread;

/**
 * @author fuzhennan
 */
public class TestJoin {
    public static void main(String[] args){
        ThreadJoin threadJoin=new ThreadJoin("threadJoin");
        threadJoin.start();
        try{
            /*
             * 线程合并
             * t1执行完在执行主线程
             */
            threadJoin.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i=0;i<=10;i++){
            System.out.println("I am main thread"+i);
        }
    }
}

class ThreadJoin extends Thread{
    public ThreadJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<=10;i++){
            System.out.println("I am :"+getName());
            try{
                sleep(1000);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
