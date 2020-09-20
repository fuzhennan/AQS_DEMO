package interview.juc;

/**
 * volatile关键字
 *
 * 1.内存可见性：
 * 当多个线程同时操作共享数据时，彼此是不可见的
 *      例子：共享内存（主存）中有flag变量，main线程负责读，子线程负责写，每个线程有自己的本地内存，
 *      子线程拿到主存中的flag值，在自己的本地内存中把flag值改为true时，还没来的及更新到主存，
 *      main线程已经去读取flag值了，导致读取的值时更新前的值
 * 给主存中的变量添加volatile关键字便可使得内存可见，解决这个问题。
 * 相较于synchronized，是一种较为轻量级的同步策略。
 *
 * volatile特点:
 * 1.不具备互斥性
 * 2.不能保证变量的原子性
 * 3.禁止指令重排序
 *
 * @author fuzhennan
 */
public class TestVolatile {
    public static void main(String[] args){
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true){
            if (td.isFlag()){
                System.out.println("-----------");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable{

    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        flag=true;
        System.out.println("flag= "+isFlag());
    }
}