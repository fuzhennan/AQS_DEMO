package src.practise.Value;

public class removetheKDigits {
    public static void main(String[] args){
        System.out.println(remove("1593212",3));
    }

    public static String remove(String num,int k){
        //删去k个字符后的整数的长度
        int newLength=num.length()-k;
        //创建一个栈
        char[] stack=new char[num.length()];
        int top=0;
        for (int i=0;i<newLength;++i){
            //遍历当前数组
            char c=num.charAt(i);
            while(top>0&&stack[top-1]>c&&k>0){
                top-=1;
                k-=1;
            }
            //把当前遍历的数压入栈
            stack[top++]=c;
        }
        //找到栈中第一个非零的元素，构成新的字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength? "0": new String(stack, offset, newLength - offset);
    }

}
