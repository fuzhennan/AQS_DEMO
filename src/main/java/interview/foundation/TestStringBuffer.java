package interview.foundation;

/**
 * @author fuzhennan
 */
public class TestStringBuffer {

    public static void main(String[] args){
        TestStringBuffer tsb = new TestStringBuffer();
        tsb.concatString();
    }

    public String concatString(){
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        System.out.println(sb);
        return sb.toString();
    }
}
