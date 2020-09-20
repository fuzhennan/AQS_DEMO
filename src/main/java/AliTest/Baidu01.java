package AliTest;

import java.util.Scanner;

public class Baidu01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1 || n > 1000){
            System.out.println(-1);
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < n ; i++) {
            s.append(scanner.nextInt());
        }
        Long value = Long.valueOf(s.toString());
        int c = 0;
        for (int j = 0; j < s.length(); j++){
            c = Integer.valueOf(s.substring(j,j+1));
            if (c != 0 )
            {
                if (c != 5){
                    System.out.println(-1);
                }else {
                    System.out.println(value);
                }
            }

        }
    }
}
