package com.top.wenjiewang;

/**
 * Created by Jerry on 2016/9/7.
 */
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int ls=s.length();
        int lt=t.length();
        if(ls==0)return true;//空串肯定为t的子串
        int i,m=0;//m标识该从t中哪开始遍历
        for(i=0;i<ls;i++){
            char a = s.charAt(i);
            for(int j=m;j<lt;j++){
                if(a==t.charAt(j)){
                    m = j+1;//下次遍历从j+1开始
                    break;
                }
                m = j + 1;//记录当前遍历到哪了
            }
            if(m>=lt&&i<ls-1)return false;
        }
        return true;
    }

    public boolean isSubsequence2(String s, String t)
    {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }

        return true;
    }
}
