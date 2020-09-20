package src.practise.Value;

import java.io.File;

public class FileList {
    public static void main(String[] args){
        File f=new File("d:/A");
        System.out.println(f.getName());
        tree(f,1);
    }
    private static void tree(File f,int level){

        StringBuilder preStr= new StringBuilder();
        for (int i=0;i<level;i++){
            preStr.append("    ");
        }

        File[] childs=f.listFiles();
        for (File child : childs) {
            System.out.println(preStr.toString() + child.getName());
            if (child.isDirectory()) {
                tree(child, level + 1);
            }
        }
    }
}
