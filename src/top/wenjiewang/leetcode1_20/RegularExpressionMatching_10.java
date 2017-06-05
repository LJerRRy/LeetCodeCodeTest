package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/9/26.
 */
public class RegularExpressionMatching_10 {
    public  boolean isMatch(String s, String p) {
        if(s.equals(p))return true;
        if(p.charAt(0)=='.'&&p.charAt(1)=='*')return true;
        int i=0,j=0;
        while(i<s.length()&&j<p.length()){
            switch (p.charAt(j)){
                case '.':
                    if (p.charAt(j+1)=='*')return true;
                    j++;
                    break;
                case '*':
                    if(s.charAt(i)!=s.charAt(i-1)){
                        i++;
                        j++;
                    }else{
                        while(s.charAt(i-1)!=s.charAt(i)&&i<s.length())i++;
                        j++;
                    }
                    break;
                default:
                    if(s.charAt(i)!=p.charAt(j))return false;
                    i++;j++;
                    break;
            }
        }
        return false;
    }

    public boolean isMatch2(String s, String p) {
        if(s==null||p==null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){

            }
        }
        return false;
    }
    public static void main(String[] args) {
        RegularExpressionMatching_10 rem = new RegularExpressionMatching_10();
        System.out.println(rem.isMatch("aab","c*a*b"));
    }
}
