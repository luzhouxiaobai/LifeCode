package org.asmoc.algorithm;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length==0 || grid[0].length==0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            dp[i][0] = i==0 ? grid[i][0]:dp[i-1][0] + grid[i][0]; 
        }
        for (int i=0; i<grid[0].length; i++) {
            dp[0][i] = i==0 ? grid[0][i] : dp[0][i-1] + grid[0][i];
        }
        for (int i=1; i<grid.length; i++) {
            for (int j=1; j<grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                ;
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
