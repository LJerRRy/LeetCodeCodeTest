package top.wenjiewang.job.nowcoder;

import java.util.Scanner;

/**
 * Created by Jerry on 2017/5/19.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[sc.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(findMinParti(a));
    }
    private static int findMinParti(int[] a){
        if(a==null||a.length==0)return 0;
        if(a.length<3)return 1;
        int cnt = 0;
        for (int i = 1; i < a.length-1; i++) {
            if(a[i]>a[i-1]&&a[i]>a[i+1]||(a[i]<a[i-1]&&a[i]<a[i+1])){
                cnt++;
                i++;
            }
        }
        return cnt+1;
    }
    private static int findMinParti2(int[] a){
        if(a==null||a.length==0)return 0;
        if(a.length<3)return 1;
        int[] dp = new int[a.length];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < a.length; i++) {
            if(a[i]==a[i-1])dp[i] = dp[i-1];
            else if(a[i]>a[i-1]){
                if(a[i-1]>=a[i-2])dp[i] = dp[i-1];
                else dp[i]=dp[i-1]+1;
            }else {
                if(a[i-1]<=a[i-2])dp[i]=dp[i-1];
                else dp[i]=dp[i-1]+1;
            }
            //System.out.println(dp[i]);
        }
        return dp[a.length-1];
    }
}
