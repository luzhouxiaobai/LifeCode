package org.asmoc.algorithm;

public class NumDistinct {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[][] dp = new int[s.length()+1][t.length()+1];

        dp[0][0] = 1;
        for (int i=0; i<s.length(); i++) {
            dp[i+1][0] = 1;
            for (int j=0; j<t.length(); j++) {
                if (i<j) dp[i+1][j+1] = 0;
                char s1 = s.charAt(i);
                char s2 = t.charAt(j);
                if (s1==s2) {
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                } else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[s.length()][t.length()];

    }
}
