package src.dome;

public class DVD extends Item {
    private String director;

    public DVD(String title, int playingTime, boolean gotIt, String comment, String director) {
        super(title, playingTime, gotIt, comment);
//        setTitle("父类的title");
        this.director = director;
    }

    public void print() {
        System.out.println("DVD:");
        super.print();
        System.out.println(director);
    }

    public static void main(String[] args){
        DVD dvd=new DVD("金陵十三钗",2,false,"黄色，暴力","fzn");
        dvd.print();
    }
}
