package AliTest;

import java.util.Scanner;

public class Meituan04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if (n > 24){
                System.exit(0);
            }
            if (n < 3){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
    }
}
