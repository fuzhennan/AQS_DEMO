package AliTest;

import java.util.Scanner;

/**
 * @author fuzhennan
 */
public class BeiKe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1 || n > 16){
            n = 0;
        }
        int p = 0, q = 0, r = 1;
        for (int i =1 ;i <= n; ++i){
            p = q;
            q = r;
            r = p + q;
        }
        System.out.println(n);
        int[] j = {0,1,2,3,4,5};
        System.out.println(j.length);
    }
}
