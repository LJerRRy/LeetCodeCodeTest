package com.top.wenjiewang;

/**
 * Created by Jerry on 2016/8/30.
 */
public class EliminationGame_390 {
    public static int lastRemaining(int n) {
        int[] a = new int[n];
        for (int i = 1; i <= n; i++)
            a[i - 1] = i;
        int t = n;
        while (t > 1) {
            int i = 0, k = 0;
            while (i != t && i != t - 1) {//正向删除
                a[k++] = a[i + 1];
                i += 2;
            }
            t = t / 2;//不论t是否为奇数或者偶数，剩余的数的个数始终为t/2
            i = t - 1;
        }
        return 0;
    }

    public static int lastRemaining2(int n) {
        int[] a = new int [n];
        int[] b = new int [n];
        for(int i = 0;i<n;i++)
            a[i]=i+1;
        int k = n;
        while(k>1){
            int i =0,j=0;
            while(i<k-1){//正向删除
                b[j++]=a[i+1];//复制
                i+=2;
            }
            k=k/2;
//            for(int m=0;m<k;m++)
//                System.out.print(b[m]+ " ");
//            System.out.println();
            if(k!=1){
            for(j=k-1,i=0;j>=0;j-=2){
                b[j]=0;
            }}
            for(i=0,j=0;i<k;i++){
                if(b[i]!=0){
                    a[j++]=b[i];
                }
            }
            k=k/2;
//            for(int m=0;m<k;m++)
//                System.out.print(a[m]+ " ");
//            System.out.println();
        }
        return a[0];
    }

    public static int lastRemaining3(int n) {
        int a=1,p=1,cnt=0;
        while (n>1){
            n/=2;
            cnt++;
            p*=2;
            if(cnt%2==1){
                a += p/2 + p*(n-1);
            }else {
                a -= p/2 + p*(n-1);
            }
        }
        return a;
    }
        public static void main(String[] args) {
        System.out.println(lastRemaining2(100000000));
            System.out.println(lastRemaining3(100000000));

        }
}