package interview.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启三个线程，这三个线程的id分别为A,B,C,每个线程分别在屏幕上将自己的id打印10遍
 * 要求输出的结果必须按顺序显示，比如ABCABCABCABC....依次递归
 * @author fuzhennan
 */
public class TestABCAlternate {
    public static void main(String[] args){
        ABCAlternate abc = new ABCAlternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=10 ; i++) {
                    abc.loopA(i);
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=10 ; i++) {
                    abc.loopB(i);
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=10 ; i++) {
                    abc.loopC(i);
                }
            }
        },"C").start();
    }
}

class ABCAlternate{
    private char id = 'A';
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop){
        lock.lock();
        try{
            if (id != 'A'){
                condition1.await();
            }
                System.out.println(Thread.currentThread().getName()+"\t"+totalLoop);
            id = 'B';
            condition2.signal();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop){
        lock.lock();
        try{
            if (id != 'B'){
                condition2.await();
            }
                System.out.println(Thread.currentThread().getName()+"\t"+totalLoop);
            id = 'C';
            condition3.signal();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop){
        lock.lock();
        try{
            if (id != 'C'){
                condition3.await();
            }
                System.out.println(Thread.currentThread().getName()+"\t"+totalLoop);
                System.out.println("-----------------------");
            id = 'A';
            condition1.signal();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}