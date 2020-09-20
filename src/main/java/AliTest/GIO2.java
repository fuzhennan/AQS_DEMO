package AliTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GIO2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Solution ans = new Solution();
        while (scanner.hasNextInt()){
            String[] targetLine = scanner.nextLine().split(" ");
            int[] targets = new int[targetLine.length];
            for (int i = 0; i < targetLine.length; i++) {
                targets[i] = Integer.parseInt(targetLine[i]);
            }
            int target = Integer.parseInt(scanner.nextLine());
            int out = ans.search(targets,target);
            System.out.println(out + "\n");
        }
    }

}

class Solution {
    public int search(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;

        if (target < nums[low] || target > nums[high] || low > high){
            return -1;
        }

        while (low <= high){
            middle = (low + high) / 2;
            if (nums[middle] > target){
                high = middle - 1;
            }else if (nums[middle] < target){
                low = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
