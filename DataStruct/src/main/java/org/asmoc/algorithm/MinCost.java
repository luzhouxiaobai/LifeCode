package org.asmoc.algorithm;

public class MinCost {

    public int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
        int dp[][] = new int[3][costs.length];
        for (int i=0; i<3; i++) {
            dp[i][0] = costs[0][i];
        }

        for (int i=1; i<costs.length; i++) {
            dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + costs[i][0];
            dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + costs[i][1];
            dp[2][i] = Math.min(dp[1][i-1], dp[0][i-1]) + costs[i][2];
        }

        return Math.min(dp[0][costs.length-1], Math.min(dp[1][costs.length-1], dp[2][costs.length-1]));

    }

}
