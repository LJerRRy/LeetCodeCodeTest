package com.top.wenjiewang;

import java.util.Stack;

/**
 * Created by Jerry on 2016/9/7.
 */
public class DecodeString_394 {
    public static String decodeString(String s) {
        if(s==""||s==null)return "";
        String repS = "";
        String aimS = "";
        int len = s.length();
        int i = 0,t = 0;
        while(i<len){
            char tmpS = s.charAt(i);
            if(tmpS<='9'&&tmpS>'0'){
                t=(tmpS-'0');
            }else if(tmpS=='['){
                repS="";
            }else if(tmpS==']'){
                for(int j = 0;j<t;j++){
                    aimS+=repS;
                }
                t=0;
            }else{
                repS+=tmpS;
            }
            i++;
        }
        return aimS;
    }
    public static String decodeString2(String s) {
        Stack<Character> str = new Stack<>();//栈用来存放字符
        for(char c:s.toCharArray()){
            if(c==']'){//当前c为]则要做出一次解码
                String repeat = "";
                while(str.peek()!='['){
                    repeat=str.peek()+repeat;//注意这里一定是str.peek()+repeat，不能写反,也不能用+=
                    str.pop();
                }
                str.pop();
                String num = "";//重复的数量，由于重复的值可能是多位数
                while(!str.isEmpty()){
                    char n = str.peek();
                    if(!Character.isDigit(n))break;
                    else {
                        num=n+num;//注意这里一定是n+num，不能写反，也不能用+=
                        str.pop();
                    }
                }
                int re;
                if(num=="")re=1;
                else{
                    re = Integer.parseInt(num);
                }
                while(re-->0){
                    for(char ch:repeat.toCharArray())
                        str.push(ch);
                }
            }else{
                str.push(c);
            }
        }
        String aimS="";
        while(!str.isEmpty()){
            aimS=str.pop()+aimS;//注意这里一定是str.pop()+aimS，不能写反，也不能用+=
        }
        return aimS;
    }
    private int idx;
    public  String decodeString3(String s) {
        idx = 0;
        return helper(s);
    }
    public  String helper(String s) {
        StringBuffer ans = new StringBuffer();
        for(int k=0;idx < s.length();++idx){
            char ch = s.charAt(idx);
            if(ch == '['){
                idx++;
                String str = helper(s);
                while (k > 0) {
                    ans.append(str);
                    --k;
                }
            }else if (ch == ']') {
                break;
            } else if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else ans.append(ch);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String b = "dfs10[a3[bc]]de";
        System.out.println(decodeString(s));
        System.out.println(s+"ab");
        System.out.println(decodeString2(b));
//        System.out.println(decodeString3(b));

    }
}
