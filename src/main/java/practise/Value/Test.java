package src.practise.Value;

public class Test {
    public static void main(String[] args){
        Test t=new Test();
        t.first();
    }

    class Value{
        int i=15;
    }
    private void first() {
        int i=5;
        Value v=new Value();
        v.i=25;
        second(v,i);
        System.out.println(v.i);
    }

    private void second(Value v, int i) {
        i=0;
        v.i=20;
        Value value=new Value();
        v=value;
        System.out.println(v.i+" "+i);
    }
}
