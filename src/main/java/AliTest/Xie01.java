package AliTest;

import java.util.Scanner;

public class Xie01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        String result = "";
        if (s2.contains(s1)){
            result = s2.replace(s1,s3);
        }
        System.out.println(result);
    }
}
