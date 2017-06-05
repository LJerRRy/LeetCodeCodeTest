package top.wenjiewang.job.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jerry on 2017/5/4.
 */
public class Test1_10 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;

    }
    public void reOrderArray(int [] a) {
        if(a==null||a.length<2)return;
        int n = a.length;
        for(int i = 0;i<n;i++){
            for(int j = n-1;j>i;j--){
                if((a[j]&1)==1&&(a[j-1]&1)==0){
                    swap(a,i,j);
                }
            }
        }
    }
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private void print(int[] a){
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if(i!=a.length-1) System.out.print(" ");
        }
        System.out.print("]");
    }

    int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
    int count99 = 0;
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        return dfs(list, matrix, new boolean[matrix.length][matrix[0].length], 0, 0, 0);
    }
    private ArrayList<Integer> dfs(ArrayList<Integer> list, int[][] m, boolean[][] c, int i, int j, int flag) {
        int ro = m.length, co = m[0].length;
        if(count99==ro*co)return list;
//        if(c[i][j]&&c[i-1][j-1]&&c[i-1][j]&&)
        if (i>=0&&j>=0&&i < ro && j < co && !c[i][j]) {
            list.add(m[i][j]);
            c[i][j] = true;
            count99++;
            return dfs(list, m, c, i + d[flag][0], j + d[flag][1], flag);
        } else {
            i = i - d[flag][0];
            j = j - d[flag][1];
            flag++;
            flag = (flag > 3) ? 0 : flag;
            return dfs(list, m, c, i + d[flag][0], j + d[flag][1], flag);
        }
    }

    public boolean VerifySquenceOfBST(int [] s1) {
        if(s1==null||s1.length==0)return false;
        return fun(s1, 0,s1.length-1);
    }
    private boolean fun(int[]s, int l,int r){
        if(l>=r)return true;
        int i = r-1;
        while(i>=l&&s[i]>s[r])i--;
        for(int j = i-1;j>=l;j--)if(s[j]>s[r])return false;
        return fun(s,l,i-1)&&fun(s,i,r-1);
    }

    public static void main(String[] args) {
        Test1_10 t = new Test1_10();
//        int[][] a = {{1,2,3,4},{5,6,7,8}};
//        System.out.println(t.printMatrix(a));
        int[] a = {5,4,3,2,1};
        System.out.println(t.VerifySquenceOfBST(a));
    }
}

   class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
  }

