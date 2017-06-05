package top.wenjiewang.contest;

import java.util.*;

/**
 * Created by Jerry on 2017/5/14.
 */
public class Solution32 {
    public int findUnsortedSubarray(int[] a) {
        int[] b = Arrays.copyOf(a,a.length);
        Arrays.sort(b);
        System.out.println(a==b);
        System.out.println(Arrays.toString(b));
        int i = 0, j = a.length - 1;
        for (; i < a.length;) {
            if(a[i]!=b[i])break;
            i++;
        }
        if(i>=a.length)return 0;
        for (;j>i;){
            if(a[j]!=b[j])break;
            j--;
        }
        return j-i+1;
    }
    public List<Integer> killProcess1(List<Integer> pid, List<Integer> ppid, int kill) {
        if(kill==0){
            return new LinkedList<>(pid);
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        res.add(kill);
        q.add(kill);
        while(!q.isEmpty()){
            int t = q.poll();
            if(!ppid.contains(t))continue;
            for (int i = 0; i < ppid.size(); i++) {
                if(ppid.get(i)==t){
                    int ch = pid.get(i);
                    res.add(ch);
                    q.add(ch);
                }
            }

        }
        return res;
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(kill==0){
            return new LinkedList<>(pid);
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if(ppid.get(i)!=0){
                int x = pid.get(i);
                int y = ppid.get(i);
                if(map.containsKey(y)){
                    List<Integer> t = map.get(y);
                    t.add(x);
                }else {
                    List<Integer> t = new LinkedList<>();
                    t.add(x);
                    map.put(y,t);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        res.add(kill);
        q.add(kill);
        while(!q.isEmpty()){
            int t = q.poll();
            List<Integer> list = map.get(t);
            if(list!=null){
                res.addAll(list);
                q.addAll(list);
            }
        }
        return res;
    }

    public int minDistance(String word1, String word2) {
        if (word1==null&&word2==null)return 0;
        if (word1==null||word2==null)return word1==null?word2.length():word1.length();
        if(word1.equals(word2))return 0;
        int a = word1.length(), b = word2.length();
        int[][] dp = new int[a+1][b+1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if(i==0||j==0)continue;
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return a+b-2*dp[a][b];
    }

    public static void main(String[] args) {
        Solution32 t = new Solution32();
//        int s = t.findUnsortedSubarray(new int[]{12,21,123,1221});
//        System.out.println(s);
        System.out.println(t.minDistance("sea","eat"));
    }
}
