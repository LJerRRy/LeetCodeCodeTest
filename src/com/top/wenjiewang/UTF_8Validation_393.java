package com.top.wenjiewang;

/**
 * Created by Jerry on 2016/9/7.
 */
public class UTF_8Validation_393 {
    public static int getLen(int s){
        int mask = 0x80;
        if((s&mask)==0)return 0;
        mask>>=1;
        if((s&mask)==0)return -1;
        int len = 1;
        mask>>=1;
        while((mask!=0)&&(s&mask)==mask){
            mask>>=1;
            len++;
        }
        return len==7?-1:len;
    }
    public static boolean validUtf8(int[] data){
        if(data.length==0&&data ==null)return false;
        int  i =0;
        while(i<data.length){
            int s = getLen(data[i]);
            if(s<0||(i+s)>=data.length)return false;
            while (s>0){
                if(data[++i]>>6!=2)return false;
                s--;
            }
            if(s>0)return false;
            i++;
        }
        return true;
    }

    public boolean validUtf8_2(int[] data) {
        String[] s = new String[data.length];
        for(int i=0;i<data.length;i++){
            s[i]=Integer.toBinaryString(data[i]);
        }
        int count = 0;
        while(s[0].charAt(count)!='0'&&count<s[0].length()){
            count++;
        }
        int j = 1;
        int k = count;
        while(k>0){
            int i = 0;
            if(j>=data.length){
                return false;
            }
            while(s[j].charAt(i)!='0'&&i<s[j].length()){
                i++;
            }
            if(i!=count){
                return false;
            }else{
                k--;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a={197, 130, 130,2};
        int[] b={240,162,138,147,145};
        int[] c={0};
        System.out.println(validUtf8(a));
        System.out.println(validUtf8(c));
    }
}
