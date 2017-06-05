package top.wenjiewang.job.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jerry on 2017/4/28.
 */
public class Test4 {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return constructBT(pre, 0,pre.length,in,0,in.length);
    }

    public TreeNode constructBT(int[] pre, int s1, int len1, int[] in, int s2, int len2){
        if(len1==0||len2==0||len1!=len2)return null;
        TreeNode root = new TreeNode(pre[s1]);
        int pivot = search(in, s2, s2+len2-1, pre[s1]);
        int leftLen = pivot - s2;
        root.left = constructBT(pre, s1+1, leftLen, in, s2, leftLen);
        root.right = constructBT(pre, s1+leftLen+1, len1-leftLen -1, in, pivot+1, len2-leftLen-1);
        return root;
    }

    public int search(int[] a, int low ,int high, int target){
        while(low<=high&&a[low]!=target){
            low++;
        }
        return low;
    }

    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }else {
            System.out.print("# ");
        }
    }

    public ArrayList<String> Permutation(String str) {
        if(str==null||str.length()==0)return new ArrayList<String>();
        char[] c = str.toCharArray();
        Arrays.sort(c);
        ArrayList<String> list = new ArrayList<>();
        backtrack(c,0,list,new StringBuilder());
        return list;
    }
    private void backtrack(char[] c, int cur, ArrayList<String> list, StringBuilder sb){
        if(!list.contains(sb.toString())){
            list.add(sb.toString());
        }
        if(cur>=c.length)return;
        for(int j = cur;j<c.length;j++){
            //if(j!=0&&c[j]==c[j-1])
            sb.append(c[j]);
            backtrack(c,j+1,list,sb);
            sb = sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
//        int[] a = new int[]{1,2,4,3,5,6};
//        int[] b = new int[]{4,2,1,5,3,6};
        int[] a = new int[]{1,2,4,7,3,5,6,8};
        int[] b = new int[]{4,7,2,1,5,3,8,6};
//        TreeNode treeNode = test4.reConstructBinaryTree(a,b);
//        test4.postOrder(treeNode);
        System.out.println(test4.Permutation("a"));
    }
}
