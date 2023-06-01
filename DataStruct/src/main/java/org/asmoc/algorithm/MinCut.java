package org.asmoc.algorithm;

public class MinCut {
    public int minCut(String s) {

        boolean[][] isPar = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<=i; j++) {
                if (s.charAt(i)==s.charAt(j) && (j+1>=i || isPar[j+1][i-1])) {
                    isPar[j][i] = true;
                }
            }
        }

        int[] dp = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            if (isPar[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j=0; j<i; j++) {
                    if (isPar[j+1][i]) {
                        dp[i] = Math.min(dp[i], dp[j]+1);
                    }
                }
            }
        }

        return dp[s.length()-1];
    }
}
