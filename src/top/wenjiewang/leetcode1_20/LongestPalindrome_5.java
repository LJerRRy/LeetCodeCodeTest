package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/9/11.
 */
public class LongestPalindrome_5 {
    public String longestPalindrome(String s) {
        if(s==null|s.isEmpty())return "";
        int max = 0;
        int a = 0, b = 0;//保存最长的字符串数组下标
        for(int i = 0;i<s.length();i++){
            int beg = i,end = i;
            while(end+1<s.length()&&s.charAt(beg)==s.charAt(end+1)){//判断可能为回文字符串的中间
                end++;
            }
            while(end+1<s.length()&&beg-1>=0&&s.charAt(end+1)==s.charAt(beg-1)){//向中间向两边两边开始遍历
                beg--;
                end++;
            }
            if(end - beg + 1>max){//判断该回文字符串是不是最大的字符串
                a=beg;
                b=end;
                max = end - beg + 1;
            }
        }
        return s.substring(a,b+1);
    }
}
