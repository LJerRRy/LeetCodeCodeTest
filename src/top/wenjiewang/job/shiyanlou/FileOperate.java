package top.wenjiewang.job.shiyanlou;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Jerry on 2017/5/20.
 */
public class FileOperate {
    public String readFile(String pathName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(pathName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader dis = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(dis);
        String s;
        StringBuilder res= new StringBuilder();
        try {
            while ((s= reader.readLine())!=null){
                res.append(" ");
                System.out.println(s);
                System.out.println(s.indexOf('\n'));
                res.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String te = res.toString().trim();
        System.out.println(te.charAt(te.length()-1));
        return res.toString().trim();
    }
    public void outFile(String pathName, String result) throws IOException {
//        OutputStreamWriter osw = new OutputStreamWriter()
        System.out.println(result);
        String[] s = result.trim().split(" ");
        ReverseList<String> reverseList = new ReverseList<>(Arrays.asList(s));
        System.out.println(reverseList);
        StringBuilder sb = new StringBuilder();
        Iterable<String> iterable = reverseList.reversed();
        for (String t : iterable){
            sb.append(t);
            sb.append(" ");
        }
        String res = sb.toString().trim();
        System.out.println(res);
        FileOutputStream o = new FileOutputStream(pathName);
        o.write(res.getBytes());
        o.close();
    }

    public static void main(String[] args) {
        FileOperate fo = new FileOperate();
        String s = fo.readFile("C:\\Users\\Jerry\\IdeaProjects" +
                "\\LeetCode\\src\\top\\wenjiewang\\job\\shiyanlou\\write.txt");
        try {
            fo.outFile("C:\\Users\\Jerry\\IdeaProjects\\LeetCode\\src\\top\\wenjiewang\\job\\shiyanlou\\write2.txt",s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
