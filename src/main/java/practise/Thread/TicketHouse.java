package practise.Thread;

/**
 * @author fuzhennan
 */
public class TicketHouse implements Runnable{

    private int fiveAmount=1,tenAmount=0,twentyAmount=0;

    public synchronized void buy(){
        String name=Thread.currentThread().getName();

        //zhangfei :20
        if ("zf".equals(name)){
            if (fiveAmount<3){
                try {
                    System.out.println("找不开钱，张飞必须等待。");
                    wait();
                    System.out.println("卖一张票给张飞，找零15.");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }else if ("gy".equals(name)){
            fiveAmount++;
            System.out.println("卖一张票给关羽,钱正好，现在售票员有"+fiveAmount+"张五块的");
        }else if ("lb".equals(name)){
            fiveAmount++;
            System.out.println("卖一张票给刘备，钱正好，现在售票员有"+fiveAmount+"张五块的");
        }
        if (fiveAmount==3){
            notifyAll();
        }
    }
    @Override
    public void run() {
        buy();
    }
    public static void main(String[] args){
        TicketHouse ticketHouse=new TicketHouse();
        Thread t1=new Thread(ticketHouse);
        t1.setName("zf");

        Thread t2=new Thread(ticketHouse);
        t2.setName("gy");

        Thread t3=new Thread(ticketHouse);
        t3.setName("lb");

        t1.start();t2.start();t3.start();

    }
}
