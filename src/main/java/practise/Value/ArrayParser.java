package src.practise.Value;

public class ArrayParser {
    public static void main(String[] args){
        double[][] d;
        String s="1,2;3,4,5;6,7,8";
        String[] sFirst=s.split(";");//sFirst[0]1,2   sFirst[1]3,4,5   sFirst[2]6,7,8
        d=new double[sFirst.length][];
        for (int i=0;i<sFirst.length;i++){
            String[] sSecond=sFirst[i].split(",");
            d[i]=new double[sSecond.length];
            for (int j=0;j<sSecond.length;j++){
                d[i][j]=Double.parseDouble(sSecond[j]);
            }
        }

        for (double[] aD : d) {
            for (double anAD : aD) {
                System.out.print(anAD + " ");
            }
            System.out.println();
        }
    }
}
