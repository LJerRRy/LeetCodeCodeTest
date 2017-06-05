package top.wenjiewang.contest;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Jerry on 2017/6/4.
 */
public class Solution35 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed==null||flowerbed.length==0)return false;
        if(flowerbed.length==1&&flowerbed[0]==0)return true;
        if(flowerbed.length==1&&flowerbed[0]==1)return false;
        int res = 0;
        if(flowerbed[0]==0&&flowerbed[1]==0){
            flowerbed[0]=1;
            ++res;
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0){
                flowerbed[i] = 1;
                ++res;
            }
        }
        if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0)res++;
        return res>=n;
    }

    public String tree2str(TreeNode t) {
        if(t==null)return "";
        StringBuilder sb = new StringBuilder();
        preOrder(sb, t, false);
        return sb.substring(1,sb.length()-1);
    }

    private void preOrder(StringBuilder sb, TreeNode r, boolean f){
        if (r==null){
            if(f){
                sb.append("()");
            }
            return;
        }
        sb.append("(");
        sb.append(r.val);
        if(r.left!=null||r.right!=null) {
            preOrder(sb, r.left, true);
            preOrder(sb, r.right, false);
        }
        sb.append(")");
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        for(String s : paths){
            String[] t = s.split(" ");
            if (t.length <= 1)continue;
            for (int i = 1; i < t.length; i++) {
                String[] p = t[i].split("\\(");
                String fn = t[0] + "/" + p[0];
                String content = p[1].substring(0,p[1].length()-1);
                if(map.containsKey(content)){
                    map.get(content).add(fn);
                }else {
                    List<String> list = new LinkedList<>();
                    list.add(fn);
                    map.put(content, list);
                }
            }
        }
        for (String s:map.keySet()){
            if(map.get(s).size()>1){
                res.add(new LinkedList<>(map.get(s)));
            }
        }
        return res;
    }

    public boolean isValid(String code) {
        if (code == null||code.length()==0||code.charAt(0)!='<') {
            return false;
        }
        Stack<String> s = new Stack<>();
        int i = 0;
        boolean res = false;
        while (i<code.length()){
            if(code.charAt(i)=='<'&&i<code.length()-1&&code.charAt(i+1)=='!'){
                i++;
                int t = code.indexOf("[CDATA[",i);
                if(t==-1) {
                    res = false;
                    break;
                }
                t = code.indexOf("]]>", t);
                if(t==-1) {
                    res = false;
                    break;
                }
                i = t+3;
            }else if(code.charAt(i)=='<'&&i<code.length()-1&&code.charAt(i+1)=='/'){
                if(s.isEmpty()){
                    res = false;
                    break;
                }
                int t = code.indexOf(">",i+1);
                if(t==-1) {
                    res = false;
                    break;
                }
                if(!s.pop().equals(code.substring(i+2,t))){
                    res = false;
                    break;
                }
                i = t+1;
            }else if(code.charAt(i)=='<'&&i<code.length()-6){
                i++;
                int t = code.indexOf(">", i+1);
                String tmp = code.substring(i,t);
                if(!isVailidTag(tmp)){
                    res = false;
                    break;
                }
                s.push(tmp);
                i = t+1;
            }else if(code.charAt(i)=='<') {
                res = false;
                break;
            }else {
                while (i<code.length()&&code.charAt(i)!='<')i++;
            }
        }
        if(i==code.length()&&s.isEmpty())res = true;
        return res;
    }

    private boolean isVailidTag(String s){
        if(s==null||s.length()>9||s.length()<1)return false;
        for(char c:s.toCharArray()){
            if(c>='A'&&c<='Z')continue;
            return false;
        }
        return true;
    }

    public String tree2str2(TreeNode t) {
        if(t==null)return "";
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        stack.push(t);
        while (!stack.isEmpty()){
            TreeNode p = stack.peek();
            if(set.contains(p)){
                stack.pop();
                sb.append(")");
            }else {
                set.add(p);
                sb.append("(");
                sb.append(p.val);
                if(p.left==null&&p.right!=null){
                    sb.append("()");
                }
                if(p.right!=null){
                    stack.push(p.right);
                }
                if(p.left!=null){
                    stack.push(p.left);
                }
            }
        }
        return sb.substring(1,sb.length()-1);
    }
    public static void main(String[] args) {
        Solution35 t = new Solution35();
        System.out.println(t.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
