package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/9/11.
 */
public class ReverseInteger_7 {
    public static int reverse(int x) {
        if(x==0)return 0;
        boolean flag = false;
        if(x < 0){
            flag = true;
        }
        System.out.println(flag);
        int y = x;
        long res = 0;
        while(y!=0){
            res = res*10 + y%10;//负数对正数取余负号保留
            y/=10;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            res = 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(100));
    }
}

