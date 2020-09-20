package src.practise.constructor;

/*
 *一：
 * 类的第三个成员：构造器（constructor）
 * 构造器的作用：①创建对象
 *
 * 1.设计类时，若不显示声明类的构造器的话，程序会默认提供一个空参的构造器
 * 2.一旦显示的定义了类的构造器，那么默认的构造器便不再提供
 * 3.如何声明类的构造器，格式：权限修饰符+类名+（参数（形参））
 * 4.类的多个构造器之间构成重载
 *
 * 二：类对象属性赋值的操作
 * 先后顺序：1.属性的默认初始化，2.属性的显示赋值  3.通过构造器给属性初始化，4.通过“对象.方法”的方式给属性赋值（setter）
 */
public class TestPerson {
    public static void main(String[] args){
        TestPerson testPerson=new TestPerson();
        Person p1=new Person();
        Person p2=new Person("hh");
        Person p3=new Person(5);
        Person p4=new Person("fff",5);
        System.out.println(p1);
        System.out.println(p2.getName());
        System.out.println(p3.getAge());
        System.out.println(p4.getName()+"     "+p4.getAge());
    }
}

class Person{
    //属性
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //空参构造器
    public Person(){


    }

    public Person(String name){
        this.name=name;
    }

    public Person(int age){
        this.age=age;
    }
    //方法
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
