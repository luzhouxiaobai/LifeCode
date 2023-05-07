package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Partition {

    boolean[][] dj;
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> tmp = new LinkedList<>();
    int n;

    public String[][] partition(String s) {

        n = s.length();
        dj = new boolean[n][n];
        for (int i=0; i<n; i++) Arrays.fill(dj[i], true);
        for (int i=n-1; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                dj[i][j] = (s.charAt(i) == s.charAt(j)) && dj[i+1][j-1];
            }
        }
        helper(s, 0);
        int rows = res.size();
        String[][] ret = new String[rows][];
        for (int i = 0; i < rows; ++i) {
            int cols = res.get(i).size();
            ret[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = res.get(i).get(j);
            }
        }
        return ret;
    }

    public void helper(String s, int start) {
        if (start==n) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i=start; i<n; i++) {
            if (dj[start][i]) {
                tmp.add(s.substring(start, i+1));
                helper(s, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public boolean isPar(int start, int end, String s) {
        while (start<end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbbbb";
        Partition p = new Partition();
        String[][] t = p.partition(s);
        System.out.println(Arrays.asList(t));
    }
}
