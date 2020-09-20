package src.dome;

import java.util.ArrayList;

public class DataBase extends Item{
    private ArrayList<Item> listItem =new ArrayList<Item>();

    public void add(Item item){
        listItem.add(item);
    }

    public void list(){
        for (Item item:listItem){
            item.print();
        }
    }

    public static  void main(String[] args){
        DataBase dataBase=new DataBase();
        dataBase.add(new CD("abc",6,false,"asdasdasd","fzb",5));
        dataBase.list();
    }

}
