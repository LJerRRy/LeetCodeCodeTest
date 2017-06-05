package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/9/15.
 */
public class StringtoInteger_8 {
    public static boolean isNum(char s){
        if(s>='0'&&s<='9'){
            return true;
        }else{
            return false;
        }
    }
    public static int myAtoi(String str) {
        long s = 0;
        int flag = 1;
        boolean sf = false;
        for(int i = 0;i<str.length();i++){
            char sh = str.charAt(i);
            if(sh=='-'||sh=='+'||isNum(sh)){
                if((sh=='-'&&sf)||(sh=='+'&&sf)){
                    return (int)s;
                }
                if(sh=='-')
                    flag = -1;
                if(sh=='-'||sh=='+')
                    sf = true;
                if(sh == '-'&&i<str.length()-1&&isNum(str.charAt(i+1))){
                    flag = -1;
                }else if(isNum(sh)) {
                    if (i < str.length() - 1 && !isNum(str.charAt(i + 1)) || i == str.length() - 1) {
                        s = s * 10 + sh - '0';
                        s = flag * s;
                        if (s > Integer.MAX_VALUE|| s<Integer.MIN_VALUE)
                            return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                        else
                            return (int) s;
                    } else{
                        s = s * 10 + sh - '0';
                    }
                }
            }
            else if(sf){
                System.out.println("-1");
                return (int)s;
            }
        }
        return 0;
    }

    public static int myAtoi2(String str) {
        double s = 0;
        int flag = 1;//用来保存+，-，若为-，flag=-1
        int size =0;//记录+-符号的个数
        int j;
        for(j=0;j<str.length();++j)if(str.charAt(j)!=' ')break;//去除空格
        if(j<str.length()&&str.charAt(j)!='-'&&str.charAt(j)!='+'&&!isNum(str.charAt(j)))return 0;//不满足条件2直接返回0
        for(int i = j;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='-'||ch=='+'){
                size++;
                if(size>1){//符号的个数>1，则返回
                    break;
                }
                //判断符号后若不为数字或者该符号在字符串最后则返回0
                if(i<str.length()-1&&!isNum(str.charAt(i+1))||i==str.length()-1) {
                    return 0;
                }
                flag = ch=='-'?-1:1;
            }
            else {
                if(isNum(ch)) {
                    s = s * 10 + ch - '0';
                }
                else{
                    break;
                }
            }
        }
        s = flag*s;
        if(s>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(s<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)s;
    }
    public static int myAtoi3(String str) {
        double result = 0;
        int POrN = 1;
        int count = 0;
        char[] charArr = str.toCharArray();
        for(char c:charArr){
            count ++;
            if( c >='0' && c <='9' ){
                result *= 10;
                result += ( c - '0');
            }else if( c == '-' && count == 1){
                POrN = -1;
            }else if( c == '+' && count == 1){
                POrN =  1;
            }else if( c == ' ' && count == 1){
                count --;
            }else{
                break;
            }

        }
        if( result > Integer.MAX_VALUE ){
            if(POrN == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }else{
            return (int)(result * POrN);
        }
    }
    public static void main(String[] args) {
        System.out.println(myAtoi2(""));
        System.out.println(myAtoi3("-d9223372036854775809"));
        System.out.println('\t'==' ');
    }
}
