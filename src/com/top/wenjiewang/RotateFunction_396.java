package com.top.wenjiewang;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by Jerry on 2016/9/12.
 */
public class RotateFunction_396 {
    public static int maxRotateFunction(int[] A) {
        int max = Integer.MIN_VALUE;
        int len = A.length;
        for(int i = 0;i<len;i++){
            int m = 0;
            for(int j=0;j<len;j++){
                int s = (len-i+j)%len;
                m = m + j * A[s];
            }
            System.out.println(m);
            if(m>max)max = m;
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        int b[] = {-2147483648,-2147483648};

        System.out.println(maxRotateFunction(b));
    }
}
