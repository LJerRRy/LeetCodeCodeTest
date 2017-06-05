package top.wenjiewang.leetcode100_200;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jerry on 2016/10/11.
 */
public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int len = 0;
        int k = beginWord.length();
        int[] t = new int[k];
        String s = "";
        for(int i = 0;i<k;i++){
            //如果当前不相等，说明要进行替换
            if(beginWord.charAt(i)!=endWord.charAt(i)){
                //前半部分为endWord的前半部分
                for(int j = 0;j<i;j++){
                    s+=endWord.charAt(j);
                }
                //后半部分为beginWord的后半部分（还未判断）
                for(int j = i;j<k;j++){
                    s+=beginWord.charAt(j);
                }
                //判断s是否在集合wordlist中，不在则返回0，否则len++
                if(wordList.contains(s)){
                    len++;
                }
                else {
                    return 0;
                }
            }
        }
        return len;
    }

    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        //双指针
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder_127 test = new WordLadder_127();
        Set<String> s = new HashSet<>();
        s.add("hot");
        s.add("dot");
        s.add("dog");
        s.add("lot");
        s.add("log");
//        s.add("hot");
        System.out.println(test.ladderLength2("hit","cog",s));
    }
}
