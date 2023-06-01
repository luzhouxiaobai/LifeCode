package org.asmoc.algorithm;

public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[2][s.length()];
        if (s.length()==0) return 0;

        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1][0] = 1 - dp[0][0];

        for (int i=1; i<s.length(); i++) {
            System.out.println("s[" + i + "]=" + s.charAt(i) + " dp[0][" + (i-1) +"]=" + dp[0][i-1]);
            dp[0][i] = dp[0][i-1] + (s.charAt(i)=='0' ? 0 : 1);
            dp[1][i] = Math.min(dp[0][i-1], dp[1][i-1]) + (s.charAt(i)=='1' ? 0 : 1);
        }

        return Math.min(dp[0][s.length()-1], dp[1][s.length()-1]);

    }

    public static void main(String[] args) {
        MinFlipsMonoIncr mp = new MinFlipsMonoIncr();
        String s = "00011000";
        System.out.println(mp.minFlipsMonoIncr(s));
    }
}
