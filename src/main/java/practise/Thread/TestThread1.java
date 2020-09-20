package practise.Thread;

/**
 * @author fuzhennan
 * 创建新线程的两种方法
 * 1.继承Thread类，重写run（）方法
 * 2.实现runnable接口
 */

public class TestThread1 {
    public static void main(String[] args){
        Runner1 runner1=new Runner1();
        new Thread(runner1).start();
        for (int i=0;i<=100;i++){
            System.out.println("Main thread:------"+i);
        }
    }
}

class Runner1 implements Runnable{
    /**    class Runner1 extends Thread{}
     不推荐从类继承
     *
     */

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            System.out.println("Runner1:"+i);
        }
    }
}
