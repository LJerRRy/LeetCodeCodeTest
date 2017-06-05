package top.wenjiewang.leetcode1_20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jerry on 2017/5/17.
 */
public class Test_dp {
    public boolean isMatch_44(String s, String p) {
        // return true;
        // if(s==null)
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    for (int k = 0; k <= i; k++) {
                        dp[i][j] |= dp[k][j - 1];
                    }
//                    dp[i][j] = dp[i][j-1]||dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public int uniquePaths_62(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles_63(int[][] obstacleGrid) {
        //这里需要排除起始就是障碍物
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) return 0;
        int ro = obstacleGrid.length, co = obstacleGrid[0].length;
        int[][] dp = new int[ro][co];
        dp[0][0] = 1;
        for (int i = 0; i < ro; i++) {
            for (int j = 0; j < co; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i == 0 || j == 0) {
                    //这里需要判断是否当前i==0或者j==0时，是否有障碍物阻拦
                    if (i == 0) {
                        if (j > 0 && obstacleGrid[i][j - 1] == 1)
                            dp[i][j] = 0;
                        else if (j != 0)
                            dp[i][j] = dp[i][j - 1];
                    } else {
                        if (i > 0 && obstacleGrid[i - 1][j] == 1)
                            dp[i][j] = 0;
                        else
                            dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }

        }
        return dp[ro - 1][co - 1];
    }

    public int minPathSum_64(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[0][0];
                if (i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1];
                if (j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j];
                else {
                    dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j],
                            grid[i][j] + dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minDistance_72(String word1, String word2) {
        if (word1 == null) return word2 == null ? 0 : word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public int maximalRectangle(char[][] matrix) {
        return 0;
    }

    public int numDecodings_92(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }


    public List<TreeNode> generateTrees_95(int n) {
        if(n<=0)return new LinkedList<TreeNode>();
        List<TreeNode>[] dp = new List[n+1];
        dp[0].add(null);
        dp[1].add(new TreeNode(1));
        for (int i = 2; i <= n; i++) {
            dp[i] = new LinkedList<>();
            for (int j = 1; j <= i ; j++) {
                for(TreeNode nodeL : dp[j]){
                    for(TreeNode nodeR : dp[n-j]){
                        TreeNode node = new TreeNode(j);
                        node.left = nodeL;
                        node.right = cloneNode(nodeR, j);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode cloneNode(TreeNode r, int j) {
        if(r == null)return null;
        TreeNode node = new TreeNode(r.val+j);
        node.left = cloneNode(r.left, j);
        node.right = cloneNode(r.right,j);
        return node;
    }

    public TreeNode backtrack(List<TreeNode> list, TreeNode r, int val, int size, int target) {
        if (val == -1) return null;
        if (size == target) list.add(r);
        return null;
    }

    public int numTrees_96(int n) {
        // dp相对于G(n)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            //这里t相当于f函数
            int t = 0;
            for (int j = 1; j <= i; j++) {
                t += dp[j-1]*dp[i-j];
            }
            dp[i] = t;
        }
        return dp[n];
    }

    public List<TreeNode> backtrack(int start, int end){
        if(start>end)return new LinkedList<TreeNode>();
        List<TreeNode> res = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left, right;
            left = backtrack(start,i-1);
            right = backtrack(i+1, end);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0)return 0;
        int m = triangle.size(), n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        int k = 2;
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                min = j-1>=0?Math.min(min,dp[i-1][j-1]):min;
                min = j+1<k?Math.min(min,dp[i-1][j]):min;
//                min = j+2<k?Math.min(min,dp[i-1][j+1]):min;
                dp[i][j] = triangle.get(i).get(j) + min;
            }
            k++;
        }
        Arrays.sort(dp[m-1]);
        return dp[m-1][0];
    }

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==1||prices.length==0)return 0;
        int[] a = new int[prices.length-1];
        for (int i = 0; i < a.length; i++) {
            a[i]=prices[i+1]-prices[i];
        }
        System.out.println(Arrays.toString(a));
        int max = 0;
        int[] dp = new int[a.length];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            if(dp[i-1]<=0){
                dp[i] = a[i];
            }
            else {
                dp[i] = dp[i-1]+a[i];
            }
//            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        for (int i = 0; i < s.length(); i++) {

        }
        return false;
    }

    public int maxProfit3(int[] prices) {
        if(prices==null||prices.length<=1)return 0;
        else {
            int k = 2;
            int[][] dp = new int[k+1][prices.length];
            int res = 0;
            for (int i = 1; i <= k; i++) {
                int tmpMax = dp[i-1][0] - prices[0];
                for (int j = 1; j < prices.length; j++) {
                    dp[i][j] = Math.max(dp[i][j-1], prices[j] + tmpMax);
                    //i-1次交易的可能为最大值
                    tmpMax = Math.max(tmpMax, dp[i-1][j] - prices[j]);
                    System.out.println(dp[i - 1][j - 1] - prices[j] + " " +(dp[i - 1][j] - prices[j]));
                    res = Math.max(dp[i][j], res);
                }
            }
            return res;
        }
    }
    public int maxProfit4(int[] prices) {
        if (prices==null||prices.length<=1)return 0;
        int k = prices.length/2+1;
        int[][] dp = new int[k+1][prices.length];
        for (int i = 1; i < k + 1; i++) {
            int tmpMax = - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], tmpMax+prices[j]);
                if(j>1)
                    tmpMax = Math.max(tmpMax, dp[i-1][j-2]-prices[j]);
                else {
                    tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
                    System.out.println(dp[i - 1][j - 1] - prices[j] + " " +(dp[i - 1][j] - prices[j]));
                }
            }
        }
        return dp[k][prices.length-1];
    }
    public int maxProduct(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==0)continue;
            if(dp[i-1]==0){
                dp[i]=nums[i];
            }
            else if (dp[i-1]>0||(dp[i-1]<0&&nums[i]<0)){
                dp[i] = nums[i]*dp[i-1];
                tmp = 1;
            }else {
                dp[i] = nums[i]*dp[i-1];
                tmp = nums[i]*tmp;
            }
            res = Math.max(res,dp[i]);
            res = Math.max(res,tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Test_dp t = new Test_dp();
//        System.out.println(t.uniquePaths_62(3, 3));
        System.out.println(t.maxProduct(new int[]{-2,0}));
    }
}

  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }
