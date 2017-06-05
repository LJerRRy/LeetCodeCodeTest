package top.wenjiewang.leetcode400_500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Jerry on 2016/10/24.
 */
public class Queue_Reconstruction_by_Height_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int n = people.length;
        int[][] ret = new int[n][];
        for (int i = 0; i < n; i++) {
            for (int j = 0, ahead = 0; j < n; j++) {
                if (ahead < people[i][1]) {
                    ahead += (ret[j] == null || ret[j][0] >= people[i][0]) ? 1 : 0;
                } else if (ret[j] == null) {
                    ret[j] = people[i];
                    break;
                }
            }
        }
        return ret;
    }
}
