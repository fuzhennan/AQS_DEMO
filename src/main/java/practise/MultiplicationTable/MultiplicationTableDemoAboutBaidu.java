package src.practise.MultiplicationTable;

public class MultiplicationTableDemoAboutBaidu {
    public static void main(String[] args) {
        //倒三角
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
