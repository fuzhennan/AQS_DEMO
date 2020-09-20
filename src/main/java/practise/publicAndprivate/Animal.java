package src.practise.publicAndprivate;

public class Animal{
    protected String name;//proteced
    private int legs;//private
    String color;//default
    public boolean fly;//public

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("My name is: "+name);
        System.out.println("I hava: "+legs+"legs");
        System.out.println("Can I fly?  "+fly);
        System.out.println("My color is: "+color);
    }

    public void eat() {
        System.out.println("I am eating!");
    }
}
