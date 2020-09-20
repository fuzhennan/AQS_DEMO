package interview.juc;

/**
 * 模拟CAS算法
 * @author fuzhennan
 */
public class TestCAS {
    public static void main(String[] args){
        final CompareAndSwap cas = new CompareAndSwap();
        for (int i =0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean b = cas.compareAndSet(cas.get(), (int) (Math.random()*101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSwap{
    //内存值
    private int value;

    //获取内存值
    public synchronized int get(){
        return value;
    }

    //比较和交换
    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue=value;
        if (oldValue==expectedValue){
            this.value=newValue;
        }
        return oldValue;
    }

    //判断是否修改成功
    public synchronized boolean compareAndSet(int expectedValue, int newValue){
        return expectedValue == compareAndSwap(expectedValue,newValue);
    }
}