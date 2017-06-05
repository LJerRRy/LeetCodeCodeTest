package top.wenjiewang.job.baidu;

import java.util.Scanner;

/**
 * Created by Jerry on 2017/4/27.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        int[] z = new int[N];
        int[] color = new int[N];

        for (int i = 0; i < N; i++) {
            color[i] = sc.next().charAt(0);
            x[i] = Integer.parseInt(sc.next());
            y[i] = Integer.parseInt(sc.next());
            z[i] = Integer.parseInt(sc.next());
        }
        double ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if(isTrue(color[i],color[j],color[k])){
                        double a = calLen(x[i],y[i],z[i],x[j],y[j],z[j]);
                        double b = calLen(x[i],y[i],z[i],x[k],y[k],z[k]);
                        double c = calLen(x[k],y[k],z[k],x[j],y[j],z[j]);
                        if(!isTriangle(a,b,c))continue;
                        double t = (a+b+c)/2.0;
                        double s = Math.sqrt(t*(t-a)*(t-b)*(t-c));
                        ret = Math.max(s,ret);
                    }
                }
            }
        }
        System.out.printf("%.5f",ret);
    }

    static boolean isTrue(int i, int j, int k){
        return (i==j&&i==k)||(i!=j&&i!=k&&j!=k);
    }
    static boolean isTriangle(double a, double b, double c){
        return (a+b>c)&&(a+c>b)&&(b+c>a);
    }
    static double calLen(int a, int b, int c, int d, int e, int f){
        return Math.sqrt((d-a)*(d-a)+(e-b)*(e-b)+(f-c)*(f-c));
    }
}
