/*
package src.practise.Value;
import java.util.*;
public class binarySearch {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            int[] a={1,2,5,6,8,9,12,15,16,89};
            System.out.println("请输入要查找的值！");
            int num=scanner.nextInt();
            int answer=binary(a,num);
            if (answer == -1) {
                System.out.println("你输入的数没找到，请重新输入！");
            }
            else {
                System.out.println("下标值为：" + answer);
                break;
            }
        }
    }

    public static int binary(int[] a, int num) {//不能从静态方法调用非静态方法，所以binary得static
        int startPos=0;
        int endPos=a.length - 1;
        if (a.length == 0) {
            System.out.println("empty array!");
        }
        while (startPos <= endPos) {//二分法查找
            int mid=(startPos + endPos) / 2;
            if (num == a[mid]) {
                return mid;
            }
            if (num < a[mid]) {
                endPos = mid - 1;
            }
            if (num > a[mid]) {
                startPos = mid + 1;
            }
        }
        return -1;
    }
}
*/
