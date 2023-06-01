package org.asmoc.algorithm;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length()+s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;

        for (int i=0; i<s1.length(); i++) {
            dp[i+1][0] = (s1.charAt(i)==s3.charAt(i)) && dp[i][0];
        }

        for (int j=0; j<s2.length(); j++) {
            dp[0][j+1] = (s2.charAt(j)==s3.charAt(j)) && dp[0][j];
        }

        for (int i=0; i<s1.length(); i++) {
            for (int j=0; j<s2.length(); j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                char c3 = s3.charAt(i+j+1);
                dp[i+1][j+1] = (c1==c3 && dp[i][j+1]) || (c2==c3 && dp[i+1][j]);
            }
        }
        return dp[s1.length()][s2.length()];

    }
}
