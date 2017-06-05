package com.top.wenjiewang;

/**
 * Created by Jerry on 2016/9/8.
 */
public class LongestSubstring_394 {
    public static int longestSubstring(String s, int k) {
        int[] a = new int[256];
        for(int i=0;i<256;i++){
            a[i]=0;
        }
        for(int i =0;i<s.length();i++){
            a[s.charAt(i)]++;
        }
        char[] ch = new char[10000];int j =0;
        for(int i = 0;i<256;i++){
            if(a[i]<k&&a[i]>0){
                ch[j++]=(char)i;
            }
        }
        int max=0,t=0;
        for(int i = 0;i<s.length();i++){
            int m;
            for( m=0;m<j;m++){
                if(s.charAt(i)==ch[j]){
                    max=max > t ? max:t;
                    t=0;
                    break;
                }
            }
            if(m==j){
                t++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aadddabb",3));
    }
}
