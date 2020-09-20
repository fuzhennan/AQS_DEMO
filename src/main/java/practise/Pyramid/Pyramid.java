package src.practise.Pyramid;

public class Pyramid {
    public void display(){
        for (int i=1;i<=8;i++){
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pyramid pyramid=new Pyramid();
        pyramid.display();
    }
}
