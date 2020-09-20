package practise.Thread;

/**
 * @author fuzhennan
 */
public class TestYield {
    public static void main(String[] args){
        ThreadYield threadYield1=new ThreadYield("threadYield1");
        ThreadYield threadYield2=new ThreadYield("threadYield2");
        threadYield1.start();threadYield2.start();
    }
}

class ThreadYield extends Thread{
    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=1;i<=100;i++){
            System.out.println(getName()+":"+i);
            if (i%10==0){
                yield();
            }
        }
    }
}