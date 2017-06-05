package com.top.wenjiewang;

import java.util.Stack;

/**
 * Created by Jerry on 2017/4/24.
 */
public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()==0)return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int tmp = 0, ret = 0;
        for(int i = 0;i<s.length();i++){
            switch(s.charAt(i)){
                case '(':stack.push(i);break;
                case ')':
                    stack.pop();
                    if (stack.isEmpty()){
                        stack.push(i);
                    }else {
                        tmp=i-stack.peek();
                        ret=Math.max(tmp,ret);
                    }
                    break;
            }
        }
        return  ret;
    }
    public int longestValidParentheses1(String s){
        if(s==null||s.length()==0)return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int ret = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                dp[i] = 0;
            }else if(s.charAt(i-1)=='('){
                dp[i] = 2;
                if(i-2>=0){
                    dp[i]+=dp[i-2];
                }
                ret = Math.max(dp[i],ret);
            }else if(s.charAt(i-1)==')'){
                int t= i-dp[i-1];
                if(t>0&&s.charAt(t-1)=='(')
                    dp[i] = dp[i-1]+2;
                if(t-1>2)
                    dp[i]+=dp[t-2];
                ret = Math.max(dp[i],ret);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LongestValidParentheses_32 test = new LongestValidParentheses_32();
        String s = ")()())";
        System.out.println(test.longestValidParentheses(s));
        System.out.println(test.longestValidParentheses("()(()"));
        System.out.println(test.longestValidParentheses1(s));
    }
}
