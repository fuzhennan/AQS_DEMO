package AliTest;

import java.util.ArrayList;
import java.util.Scanner;

public class First {
    private static int edge;


    public static void main(String[] args){
        ArrayList edges = new ArrayList();

        Scanner s = new Scanner(System.in);
        edge = s.nextInt();
        if (edge < 4 || edge > 50000){
            return;
        }
        for (int i = 0; i < edge ; i++) {
            if (s.nextInt() > Math.pow(10,9)){
                return;
            }else {
                edges.add(s.nextInt());
            }
        }

        System.out.println(edge);
        System.out.println(edges);


    }
}
