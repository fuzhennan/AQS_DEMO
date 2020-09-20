package AliTest;

import java.util.Random;
import java.util.Scanner;

public class DiDi02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            boolean b = random.nextBoolean();
            if (b){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
