package AliTest;

import java.util.Arrays;
import java.util.Scanner;

public class BLF3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String money = scanner.nextLine();
            String[] targetLine = scanner.nextLine().split(",");
            int[] items = new int[targetLine.length];
            for (int i = 0; i < targetLine.length; i++) {
                items[i] = Integer.parseInt(targetLine[i]);
            }
            BLF3 blf3 = new BLF3();
            System.out.println(blf3.buy(Integer.parseInt(money),items));
        }


    }
    public int buy(int money, int[] items){
        int[] dp = new int[money + 1];
        dp[0] = 1;
        for(int item : items){
            for (int i = item; i < money + 1; ++i) {
                dp[i] += dp[i - item];
            }
        }
        return dp[money];
    }

}
