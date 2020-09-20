package src.practise.Initial;

/*
 * copy from 《Thinking in Java》
 */
class Tag{
    Tag(int marker){
        System.out.println("Tag("+marker+")");
    }
}

class Card{
    Tag t1=new Tag(1);//Before constructor
    Card(){
        //in the constructor
        System.out.println("Card()");
        t3=new Tag(33); //Reinitialize t3
    }
    Tag t2=new Tag(2);//After constructor
    void f(){
        System.out.println("f()");
    }
    Tag t3=new Tag(3);//at the end
}

public class OrderOfInitialization{
    public static void main(String[] args){
        Card t=new Card();
        t.f();//shows that construction is done
    }
}