package com.top.wenjiewang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerry on 2017/4/25.
 */
public class Test_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,0);
        }
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else {
                return "";
            }
        }
        int counter=t.length(), begin = 0, end = 0, d= Integer.MAX_VALUE, head=0;
        while(end<s.length()) {
            char c = s.charAt(end++);
            if (map.get(c) > 0) {
                counter--;
            }
            map.put(c, map.get(c) - 1);
            System.out.println(map);
            while (counter == 0) {
                if (end - begin < d) d = end - (head = begin);
                char c2 = s.charAt(begin);
                map.put(c2,map.get(c2)+1);
                if(map.get(c2)>0){
                    counter++;
                }
                begin++;
            }
        }
        return d==Integer.MAX_VALUE?"":s.substring(head,head+d);
    }

    public String minWindow2(String s, String t) {
        String result = "";
        if (s.equals("") || t.length() > s.length())
            return result;
        int[] map = new int[128];
        int start = 0;
        int minStart = 0;
        int end = 0;
        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        for (char temp : t.toCharArray()) {
            map[temp]++;
        }
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0)
                count--;
            map[s.charAt(end)]--;
            end++;
            while (count == 0) {
                if (end - start < minLength) {
                    minStart = start;
                    minLength = end - start;
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0)
                    count++;
                start++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLength);
    }

    int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)return 0;
        int[] map = new int[128];
        int begin = 0, end = 0, d
                = 0, counter = 0;
        while(end<s.length()){
            if(map[s.charAt(end++)]++>0)counter++;
            while(counter>0)if(map[s.charAt(begin++)]-->1)counter--;
            d=Math.max(d,end-begin);
        }
        return d;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Test_76 test = new Test_76();
        System.out.println(test.minWindow(s,t));
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
