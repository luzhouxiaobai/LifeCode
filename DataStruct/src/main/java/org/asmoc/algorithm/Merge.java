package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i<intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int j = i + 1;
            while (j<intervals.length && intervals[j][0]<=right) {
                right = Math.max(right, intervals[j][1]);
                j += 1;
            }
            res.add(new int[]{left, right});
            i = j;
        }

        int[][] result = new int[res.size()][];
        return res.toArray(result);

    }

}
