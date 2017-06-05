package com.top.wenjiewang;

/**
 * Created by Jerry on 2016/8/30.
 */
public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        for(int i = 0; i<s.length();i++){
            hash1[s.charAt(i)]++;
        }
        for(int i =0; i<t.length();i++){
            hash2[t.charAt(i)]++;
        }
        for(int i=0;i<256;i++){
            if(hash1[i]!=hash2[i]){
                return (char) i;
            }
        }
        return '\0';
    }
    public char findTheDifference2(String s, String t) {
        long s1=0,t1=0;
        for(int i =0;i<s.length();i++)
            s1+=(int)s.charAt(i);
        for (int i=0;i<t.length();i++)
            t1+=(int)t.charAt(i);
        return (char) (t1-s1);
    }

    public static void main(String[] args) {

    }
}
