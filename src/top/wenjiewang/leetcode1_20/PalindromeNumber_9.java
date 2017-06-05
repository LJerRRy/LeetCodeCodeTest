package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/9/19.
 */
public class PalindromeNumber_9 {
    public static boolean isPalindrome(int x) {
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        if(x<10&&x>=0)return true;//0~9
        if(x<0)return false;//负数
        int y = x;
        int m = 1;
        int c = 0;//c来存储整数的位数
        while(y/10!=0){//计算整数x有几位
            y/=10;
            m*=10;
            c++;
        }
        c++;
        y=x;//x,y，分别代表从高位和从低位开始
        while(true){
            int t = x/m;//高位的值
            int p = y%10;//低位的值
            if(t!=p)return false;//若不相等则肯定不为回文
            if(c==0||c==1){
                long endMili=System.currentTimeMillis();
                System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
                return true;//若c=0或者c=1代表以及比较完毕，肯定为回文。
            }
            x=x%m;//去掉高位值
            m=m/10;
            y=y/10;//去掉低位
            c=c-2;//位数减2
        }
    }

    /**
     *1. 将整数x分为两部分，前半部分保存在x，后半部分逆序后保存在v中，
     *2. 其中x>v，即若x的位数为奇数时，x则比v多一位。若x>v，x=x/10
     *3. 然后再判断x是否和v相等
     *4. 这个方法效率z高
     */
    public static boolean isPalindrome2(int x) {
        //optimizations
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        if (x < 100 && x % 11 == 0) return true;
        if (x < 1000 && ((x / 100) * 10 + x % 10) % 11 == 0) return true;

        //actual logic
        int v = x % 10;
        x = x / 10;
        while (x - v > 0) {
            v = v * 10 + x % 10;
            x /= 10;
        }
        if (v > x) {
            v /= 10;
        }
        long endMili=System.currentTimeMillis();
        System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
        return v == x ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(2123443212));
        System.out.println(isPalindrome2(2123443212));
    }
}
