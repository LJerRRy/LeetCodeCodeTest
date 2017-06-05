package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/8/21.
 */
public class LongestSubstring3 {
    public static int lengthOfLongestSubstring(String s){
        if(s.length()==0)//小心
            return 0;
        int count=1;
        int i,j,t;
        for(i=1,j=0;i<s.length();i++){
            for(t=j;t<i;t++){
                if(s.charAt(t)==s.charAt(i)){
                    count=count>(i-j)?count:(i-j);//应该再这操作
                    j=t+1;
                    break;
                }
            }
        }
        count=count>(i-j)?count:(i-j);//最后应该再判断一次
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdfjegnsdahkgaiew"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("cd"));
    }
}
