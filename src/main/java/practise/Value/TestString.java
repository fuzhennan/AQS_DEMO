package src.practise.Value;

public class TestString {
    public static void main(String[] args){
        String s="sunjavahahajavadasdjavagoodjavalovejavalikejava";
        String sToFind="java";
        int count=0;
        int index;

        while((index = s.indexOf(sToFind))!=-1){
            s=s.substring(index+sToFind.length());
            count++;
        }
        System.out.println(count);
    }
}
