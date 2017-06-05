package top.wenjiewang.job.baidu;

import java.util.*;

/**
 * Created by Jerry on 2017/4/27.
 */
public class Test1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        Set<Integer> set = new HashSet<>();
//        if(N<3){
//            System.out.println(-1);
//            return;
//        }
//        for(int i =0;i<N;i++){
//            set.add(in.nextInt());
//        }
//        Object[] s = set.toArray();
//        Arrays.sort(s);
//        if(s.length>2) {
//            System.out.println(s[2]);
//        }else
//            System.out.println(-1);

        Scanner sc = new Scanner(System.in);
        //输入共有多少个数
        int n = sc.nextInt();
        //对输入的数进行保存
        int [] num = new int[n];
        //保存价格
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        int count = 0;
        int i =0;
        for(;i<num.length-1;i++){
            if(num[i] != num[i+1]) {
                count++;
                if(count == 3)
                    break;
                if(i+1==num.length-1) {
                    count++;
//                    i = i + 1;
                    //  break;
                }
            }

        }
        if(count==3)
            System.out.println(num[i]);
        else
            System.out.println(-1);
    }

}

