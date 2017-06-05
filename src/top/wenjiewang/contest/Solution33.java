package top.wenjiewang.contest;

import java.util.*;

/**
 * Created by Jerry on 2017/5/21.
 */
public class Solution33 {
    public int findLHS(int[] a) {
        if(a==null||a.length==0||a.length==1)return 0;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int i = 0, j = 1, max = 0;
        while(j<a.length){
            if(a[j]==a[i]){
                j++;
            }else if(a[j] == a[i]+1) {
                int t = j;
                while(j<a.length&&a[j]==a[i]+1)j++;
                max = Math.max(j-i,max);
                System.out.println(t+" "+j+" " +i);
                i = t;
            }else {
                int t = i;
                while(i<j&&a[i]==a[t])i++;
                j++;
            }
        }
        return max;
    }

    public int findLHS2(int[] a) {
        if(a==null||a.length==0)return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
//        for (int i = 0; i < a.length; i++) {
//            if(map.containsKey(a[i]+1)){
//                res = Math.max(res, map.get(a[i]+1)+map.get(a[i]));
//            }
//        }
        for(Integer i : map.keySet()){
            if(map.containsKey(i+1)) {
                res = Math.max(res, map.get(i + 1) + map.get(i));
            }
        }
        return res;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Double> list = new LinkedList<>();
        double t;
        t = distance(p1,p2);
        if(!list.contains(t))list.add(t);
        t = distance(p1,p3);
        if(!list.contains(t))list.add(t);
        t = distance(p1,p4);
        if(!list.contains(t))list.add(t);
        t = distance(p2,p3);
        if(!list.contains(t))list.add(t);
        t = distance(p2,p4);
        if(!list.contains(t))list.add(t);
        t = distance(p3,p4);
        if(!list.contains(t))list.add(t);
        if(list.size()==2){
            if(list.get(1)>list.get(0)){
                return list.get(0)*2 == list.get(1);
            }else {
                return list.get(0) == list.get(1)*2;
            }
        }
        return false;
    }
    private double distance(int[] p1, int[] p2){
        return Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2);
    }

    public String fractionAddition(String expression) {
        String[] fra = expression.split("[+-]");
        boolean flag = false;
        int offset = 0;
        if(expression.charAt(0)=='-'){
            flag = true;
            offset = 1;
        }
        List<Character> tag = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i)=='+'||expression.charAt(i)=='-')
                tag.add(expression.charAt(i));
        }
        String[] t = fra[offset].split("/");
        Cal first = new Cal(Integer.parseInt(t[0]),Integer.parseInt(t[1]));
        if(flag)first.setNumerator(-1*first.getNumerator());
        offset++;
        while (offset<fra.length){
            t = fra[offset].split("/");
            Cal second = new Cal(Integer.parseInt(t[0]),Integer.parseInt(t[1]));
            System.out.println(tag.get(offset-1));
            if(tag.get(offset-1)=='-'){
                first = first.sub(second);
            }else {
                first = first.add(second);
            }
            offset++;
        }
        return first.getNumerator()+"/"+first.getDenominator();
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.fractionAddition("1/2+3/4-4/5"));
    }
}

class Cal {
    private int numerator;
    private int denominator;

    Cal() {
    }

    /**
     * 分数的分子分母
     *
     * @param a 分子
     * @param b 分母
     */
    Cal(int a, int b) {
        if (a == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            setNumeratorAndDenominator(a, b);
        }
    }

    /**
     * 分数加法
     *
     * @param r 被加数
     * @return 新的Cal对象
     */
    public Cal add(Cal r) {
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNum = a * denominator + numerator * b;
        int newDen = denominator * b;
        return new Cal(newNum, newDen);
    }

    public Cal sub(Cal r) {
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNum = numerator * b - a * denominator ;
        int newDen = denominator * b;
        return new Cal(newNum, newDen);
    }

    private void setNumeratorAndDenominator(int a, int b) {
        int c = gcd(Math.abs(a), Math.abs(b));//求a和b的最大公约数
        a = a / c;
        b = b / c;
        if (a < 0 && b < 0) {
            a = -a;
            b = -b;
        }
        numerator = a;
        denominator = b;
    }

    /**
     * Greatest Common Divisor(GCD)最大公约数
     *
     * @param a a
     * @param b b
     * @return
     */
    private int gcd(int a, int b) {
        while (a % b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return b;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}

class FileSystem {

    private Map<String, String> map = new HashMap<>();

    public FileSystem() {

    }

    public List<String> ls(String path) {
        if(map.size()==0)return new LinkedList<>();
        //用set集合过滤重复路径或者文件
        Set<String> list = new HashSet<>();
        if(path.equals("/")){
            for(String s:map.keySet()){
                list.add(s.split("/")[0]);
            }
        }
        else {
            // 遍历的是一个文件路径
            if(map.containsKey(path)&&map.get(path)!=null){
                String[] t = path.split("/");
                list.add(t[t.length-1]);
            }else {
                for (String s : map.keySet()) {
                    int t = s.indexOf(path);
                    //当前s与路径不匹配或者路径里不包含文件或路径,或者当前匹配的不符合要求，比如/ab/c,如果匹配/a的话，不能匹配成功。
                    if (t < 0 || t + path.length() >= s.length()
                            ||s.charAt(t+path.length())!='/') continue;
                    String tmp = s.substring(t + path.length() + 1, s.length());
                    list.add(tmp.split("/")[0]);
                }
            }
        }
        List<String> res = new ArrayList<>();
        res.addAll(list);
        res.sort(String::compareTo);
        return res;
    }

    public void mkdir(String path) {
        map.put(path,null);
    }

    public void addContentToFile(String filePath, String content) {
        if(map.containsKey(filePath)){
            map.put(filePath, map.get(filePath)+content);
        }
        else {
            map.put(filePath, content);
        }
    }

    public String readContentFromFile(String filePath) {
        return map.get(filePath);
    }
}
