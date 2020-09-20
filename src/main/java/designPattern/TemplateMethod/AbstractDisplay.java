package designPattern.TemplateMethod;

/**
 * 抽象类AbstractDisplay
 * @author fuzhennan
 */
public abstract class AbstractDisplay {
    public abstract void open();//交给子类去实现的抽象方法（1）open
    public abstract void print();//交给子类去实现的抽象方法（2）print
    public abstract void close();//交给子类去实现的抽象方法（3）close

    /**
     * 本抽象类中实现的方法display
     */
    public final void display(){
        open();
        for (int i = 0; i <5 ; i++) {
            print();
        }
        close();
    }
}
