package org.asmoc.algorithm;

import java.util.HashMap;

public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int result = 2;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            hmap.put(arr[i], i);
        }

        for (int i=1; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                int k = hmap.getOrDefault(arr[i]-arr[j], -1);
                if (k>=0 && k<j) {
                    dp[i][j] = dp[j][k] + 1;
                } else {
                    dp[i][j] = 2;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result>2?result:0;
    }
}
