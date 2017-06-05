package top.wenjiewang.leetcode100_200;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jerry on 2016/10/21.
 */
public class MaxDepthB_Tree_104 {
    private int[] array;
    public static List<TreeNode> treeNode = null;

    MaxDepthB_Tree_104(int[] a){
        array = a;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int lDepth = maxDepth(root.left) + 1;
        int rDepth = maxDepth(root.right) + 1;
        return lDepth>rDepth?lDepth:rDepth;
    }

    public void createBinTree(){
        treeNode = new LinkedList<>();
        //将一个数组的值依次转换为Node节点
        for(int nodeIndex =0;nodeIndex<array.length;nodeIndex++){
            treeNode.add(new TreeNode(array[nodeIndex]));
        }
        //对前lastParentIndex-1个父结点安装父结点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0;parentIndex<array.length/2-1;parentIndex++){
            //left child
            treeNode.get(parentIndex).left = treeNode.get(parentIndex*2+1);
            // right child
            treeNode.get(parentIndex).right = treeNode.get(parentIndex*2+2);
        }
        //最后一个父节点：因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length/2-1;
        //左孩子
        treeNode.get(lastParentIndex).left = treeNode.get(lastParentIndex*2+1);
        //右孩子可能有
        if(array.length %2 ==1){
            treeNode.get(lastParentIndex).right = treeNode.get(lastParentIndex*2+2);
        }
    }
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6};
        MaxDepthB_Tree_104 test = new MaxDepthB_Tree_104(a);
        test.createBinTree();

    }
}
