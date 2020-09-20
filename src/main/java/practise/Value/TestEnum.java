package src.practise.Value;

public class TestEnum {
    public enum Mycolor{red,yellow,green};

    public static void main(String[] args){
        Mycolor m=Mycolor.red;
        switch (m){
            case red:
                System.out.println("red");
                break;
            case green:
                System.out.println("green");
                break;
            case yellow:
                System.out.println("yellow");
                break;
                default:
                    System.out.println("default");
        }
        System.out.println(m);
    }
}
