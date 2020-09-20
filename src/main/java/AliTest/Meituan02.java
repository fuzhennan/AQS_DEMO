package AliTest;

import java.util.Scanner;

public class Meituan02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String targetLine = scanner.next();
        char[] targets ;
        targets = targetLine.toCharArray();
        if ((targets.length % 2) != 0){
            System.exit(0);
        }
        int dx = 0,xx = 0;
        for (int i = 0; i < targets.length ; i++) {
            if (targets[i] >= 'A' && targets[i] <= 'Z'){
                dx++;
            }else if (targets[i] >= 'a' && targets[i] <= 'z'){
                xx++;
            }else {
                System.out.println(0);
            }
        }
        System.out.println(Math.abs(dx-(targets.length/2)));
    }
}
