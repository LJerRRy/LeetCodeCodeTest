package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/8/21.
 */
public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    int a[] = {i,j};
                    return a;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int[] b=twoSum(a,9);
        for(int i=0;i<b.length;i++)
        System.out.println(b[i]);
    }
}
