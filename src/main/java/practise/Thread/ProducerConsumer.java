package practise.Thread;


/**
 * @author fuzhennan
 */
public class ProducerConsumer {
    public static void main(String[] args){
        SyncStack syncStack=new SyncStack();
        Producer producer= new Producer(syncStack);
        Consumer consumer=new Consumer(syncStack);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class WoWoTou{
    int id;
    public WoWoTou(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WoWoTou{" +
                "id=" + id +
                '}';
    }
}

/**
 * 装窝窝头的篮子
 */
class SyncStack{
    int index=0;
    WoWoTou[] arrWWT = new WoWoTou[5];

    public synchronized void push(WoWoTou wwt){//入栈
        //如果满了，就不要生产了，wait等待，等着消费
        while (index==arrWWT.length){
            try {
                this.wait();//当前对象正在访问的线程wait，锁不归其所有
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        arrWWT[index]=wwt;
        index++;
    }

    public synchronized WoWoTou pop() {//出栈
        //如果为0，说明篮子没有馒头了，就要wait，等生产
        while (index==0){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return arrWWT[index];
    }
}

class Producer implements Runnable{
    SyncStack ss = null;

    public Producer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i=1;i<20;i++){
            WoWoTou woWoTou=new WoWoTou(i);
            ss.push(woWoTou);
            System.out.println("生产了:"+woWoTou);
            try{
                Thread.sleep((int) (Math.random()*2));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    SyncStack ss = null;

    public Consumer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {

            for (int i=1;i<20;i++) {
                    WoWoTou woWoTou = ss.pop();
                    System.out.println("消费了：" + woWoTou);
                    try {
                        Thread.sleep((int) (Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
    }
}