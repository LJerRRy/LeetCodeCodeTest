package top.wenjiewang.contest;

import java.util.*;

/**
 * Created by Jerry on 2017/5/28.
 */
public class Solution34 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        String[] t = new String[list1.length];
        int j = 0;
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])){
                map.put(list2[i],map.get(list2[i])+i);
                t[j++] = list2[i];
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = new LinkedList<>();
        for(int k = j-1;k>=0;k--){
            int c = map.get(t[k]);
            if(c<min){
                list.clear();
                list.add(k);
            }else if(c==min) {
                list.add(k);
            }
        }
        String[] res = new String[list.size()];
        int k = 0;
        for(int c : list){
            res[k++] = t[c];
        }
        return res;
    }
    public int maxCount(int m, int n, int[][] ops) {
        int[][] res  = new int[1][2];
        res[0][0] = ops[0][0];
        res[0][1] = ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            if(res[0][0]>ops[i][0]){
                res[0][0] = ops[i][0];
            }
            if(res[0][1]>ops[i][1]){
                res[0][1] = ops[i][1];
            }
        }
        return res[0][1]*res[0][0];
    }
    public int arrayNesting(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i,i);
        }
        int[] res = new int[1];
        backtrack(res, map, nums, 0, 0);
        return res[0];
    }

    private void backtrack(int[] res, Map<Integer, Integer> map,
                           int[] nums, int cur, int index) {

    }
}
