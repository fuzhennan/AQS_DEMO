package src.practise.MultiplicationTable;

public class MultiplicationTable {
    public void display(){
        int column=1;
        for (int row=1;row<=9;row++){
                    for (column = 1; column <= row; column++) {
                        if (column == row) {
                            System.out.println(column + "x" + row + "=" + column * row);
                        } else {
                            System.out.print(column + "x" + row + "=" + column * row);
                            System.out.print("  ");
                        }
                    }
        }
    }
    public static void main(String[] args){
        MultiplicationTable multiplicationTable=new MultiplicationTable();
        multiplicationTable.display();
    }
}
