package src.dome;

public class CD extends Item{
    private String artists;
    private int numofTracks;

    public CD(String title, int playingTime, boolean gotIt, String comment, String artists, int numofTracks) {
        super(title, playingTime, gotIt, comment);
        this.artists = artists;
        this.numofTracks = numofTracks;
    }

    public void print() {
        System.out.println("CD:");
        super.print();
        System.out.println(artists);
        System.out.println(numofTracks);
    }

    public static void main(String[] args){
        CD cd=new CD("学猫叫",3,false,"垃圾歌","垃圾",0);
        cd.print();
    }
}
