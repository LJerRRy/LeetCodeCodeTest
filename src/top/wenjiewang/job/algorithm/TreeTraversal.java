package top.wenjiewang.job.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Jerry on 2017/6/5.
 */
public class TreeTraversal {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 输入字符串，构造二叉树，格式为完全二叉树的输入格式[root,left,right]，null代表该节点为空
     * @param s 输入的字符串
     * @return 返回根结点
     */
    public TreeNode createTree(String s){
        if(s==null)return null;
        String[] str = s.split(",");
        if (str.length<=1)return null;
        str[0] = str[0].substring(1,str[0].length()).trim();
        str[str.length-1] = str[str.length-1].substring(0,str[str.length-1].length()-1).trim();
        for (int i = 1; i < str.length-1; i++) {
            str[i] = str[i].trim();
        }
        System.out.println(Arrays.toString(str));
        return create(str, 0);
    }

    private TreeNode create(String[] str, int i) {
        if (i == 0 && str[i].equals("null")) throw new IllegalArgumentException();
        if (i >= str.length || str[i].equals("null")) return null;
        TreeNode t = new TreeNode(Integer.parseInt(str[i]));
        //注意下标并不是i+1和i+2，应该是按照完全二叉树的下标来计算出左右孩子的节点值
        t.left = create(str, 2*i+1);
        t.right = create(str, 2*i+2);
        return t;
    }

    /**
     * 非递归 先序遍历二叉树
     * @param root 根结点
     */
    public void preOrder(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null||!stack.isEmpty()){
            while(p!=null){
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            }
            //p为空说明已经到达最左端，接着判断栈中是否为空，进行出栈
            if(!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    /**
     * 非递归 先序遍历 2
     * @param root 根结点
     */
    public void preOrder2(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode p = stack.peek();
            if(!set.contains(p)) {
                System.out.println(p.val);
                set.add(p);
                //栈的特点：先进后出先被访问的根节点的右子树后被访问
                if(p.right!=null)stack.push(p.right);
                if(p.left!=null)stack.push(p.left);
            }
            //否则就是被访问过，直接出栈
            else {
                stack.pop();
            }
        }
    }

    /**
     * 非递归 中序遍历
     * @param root 根结点
     */
    public void inOrder(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null||!stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()) {
                p = stack.peek();
                System.out.println(p.val);
                stack.pop();
                p = p.right;
            }
        }
    }

    /**
     * 非递归 后序遍历 并不能利用一个额外数组实现非递归，
     * 因为我们需要的是判断该节点是遍历了左节点还是遍历右孩子还是说全都遍历过了
     * 这里用一个变量保存之前遍历的节点，遍历时只需要判断当前遍历的是否为之前遍历的节点
     * @param root
     */
    public void postOrder(TreeNode root){
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root, pLastVisited = null;
        while (p!=null||!stack.isEmpty()) {
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.peek();
            stack.pop();
            if(p.right==null||p.right==pLastVisited){
                System.out.println(p.val);
                pLastVisited = p;
                // 必须将p设为null 不然会死循环。因为当前节点以及访问完了。
                p = null;
            }else {
                stack.push(p);
                p = p.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeTraversal t = new TreeTraversal();
        TreeNode r = t.createTree("[1,2,3,null,4]");
        t.postOrder(r);
    }
}
