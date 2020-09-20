package interview.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方式，实现callable接口
 *
 * 用callable接口的方式创建线程的特点
 *  1.有返回值
 *  2.可以抛出异常
 * @author fuzhennan
 */
public class TestCallable {
    public static void main(String[] args){
        CallableDemo callableDemo = new CallableDemo();
        //使用callable方式，需要FutureTask实现类的支持，用于接收运算返回的结果
        FutureTask<Integer> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask).start();
        try {
            //接收线程运算完的结果，FutureTask也可用于闭锁，因为他得等线程运行完他才能拿到运算结果
            int sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <=100 ; i++) {
            sum+=i;
        }
        return sum;
    }
}