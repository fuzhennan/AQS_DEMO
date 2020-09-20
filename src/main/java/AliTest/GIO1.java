package AliTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GIO1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList();
        while (scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int[] dp= new int[n];
        Arrays.fill(dp,1);
        int max =1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i]) {
                    dp[j]=Math.max(dp[j],dp[i]+1);
                    max =Math.max(dp[j],max);
                }
            }
        }
        return max;
    }
}
