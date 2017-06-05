package top.wenjiewang.job.offer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Jerry on 2017/5/4.
 */
public class Test2 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        if(k>input.length||k<=0)return new ArrayList<Integer>();
        quickSort(input, 0, input.length - 1, k-1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private void quickSort(int[] a, int lo, int hi, int k){
        if(lo<hi){
            int l = lo, h = hi;
            int t = a[l];
            while(l<h){
                while(h>l&&a[h]>=t)h--;
                a[l] = a[h];
                while (l<h&&a[l]<=t)l++;
                a[h] = a[l];
            }
            a[h] = t;
            if(h+1>k){
                quickSort(a,lo,h,k);
            }else if (h+1<k) {
                quickSort(a, h + 2, hi, k);
            }
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length||k<=0)return new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] t;
        t = Arrays.copyOf(input,k);
        // 建堆
        for (int i = k / 2 - 1; i >= 0 ; i--) {
            adjustHeap(t, i, k);
        }
        for (int i = k; i < input.length; i++) {
            if(input[i]<t[0]){
                t[0]=input[i];
                adjustHeap(t, 0, k);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(t[i]);
        }
        return list;
    }

    private void adjustHeap(int[] a, int i, int size) {
        int max = i;
        while(i<size/2){
            int l = 2*i+1, r = 2*i+2;
            if(l<size&&a[l]>a[max]){
                max = l;
            }
            if(r<size&&a[r]>a[max]){
                max = r;
            }
            if(max==i)break;
            swap(a,i,max);
            i = max;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public int FindGreatestSumOfSubArray(int[] a) {
        if(a==null||a.length==0)return 0;
        int[] dp = new int[a.length];
        int max = a[0];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            if(dp[i-1]<0){
                dp[i] = a[i];
            }else {
                dp[i] = dp[i-1] + a[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0)return 0;
        return numberOf1(""+n);
    }

    private int numberOf1(String s){
        if(s==null||s.length()==0||s.charAt(0)<'0'||
                s.charAt(0)>'9')return 0;
        if(s.length()==1&&s.charAt(0)>='1')return 1;
        int numsOfFirst = 0;
        String low = s.substring(1,s.length());
        if(s.charAt(0)=='1'){
            numsOfFirst = Integer.parseInt(low)+1;
        }else if(s.charAt(0)>'1'){
            numsOfFirst = (int)Math.pow(10,s.length()-1);
        }
        int numsOfOther = Integer.parseInt(s.charAt(0)+"")*(s.length()-1)*(int)Math.pow(10, s.length()-2);
        return  numsOfFirst+numsOfOther+numberOf1(low);
    }

    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0)return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int[] c = new int[256];
        for (int i = 0; i < str.length(); i++) {
            ++c[str.charAt(i)];
            if(map.containsKey(str.charAt(i)))continue;
            map.put(str.charAt(i),i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if(c[i]==1){
                min = Math.min(min,map.get((char)i));
            }
        }
        return min;
    }

//    public int InversePairs(int [] array) {
//        if(array==null||array.length==0)return 0;
//        int[] dp = new int[array.length+1];
//        dp[0] = 0;
//        for (int i = 0; i < array.length; i++) {
//
//        }
//    }

    public static void main(String[] args) {
        int[] a= {6,-3,-2,7,-15,1,2,2};
        Test2 t = new Test2();
//        System.out.println(t.FindGreatestSumOfSubArray(a));
//        System.out.println(Arrays.toString(a));
        System.out.println(t.NumberOf1Between1AndN_Solution(101));
    }

}
