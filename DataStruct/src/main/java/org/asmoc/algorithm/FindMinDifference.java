package org.asmoc.algorithm;

import java.util.List;

public class FindMinDifference {

    public int findMinDifference(List<String> timePoints) {

        boolean[] minFlag = new boolean[24 * 60];
        for (String tok: timePoints) {
            String[] time_tok = tok.split(":");
            int tmp = Integer.parseInt(time_tok[0]) * 60 + Integer.parseInt(time_tok[1]);
            if (minFlag[tmp])
                return 0;
            minFlag[tmp] = true;
        }

        int min = Integer.MAX_VALUE;
        int prev = -1;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for (int i=0; i<24*60; i++) {
            if (minFlag[i]) {
                if (prev > -1) {
                    min = Math.min(i-prev, min);
                }
                prev = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }

        return Math.min(first+minFlag.length-last, min);

    }

}
