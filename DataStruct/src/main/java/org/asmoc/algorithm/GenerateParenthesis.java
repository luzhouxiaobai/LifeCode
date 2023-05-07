package org.asmoc.algorithm;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {

        int leftN = n, rightN = n;
        StringBuilder sb = new StringBuilder();
        List<String> s = new LinkedList<>();
        dfs(leftN, rightN, sb, s);
        return s;

    }

    public void dfs(int left, int right, StringBuilder sb, List<String> s) {
        if (left==0 && right==0) {
            s.add(sb.toString());
            return;
        }

        if (left>0) {
            left -= 1;
            sb.append('(');
            dfs(left, right, sb, s);
            sb.setLength(sb.length()-1);
            left += 1;
        }

        if (right>left) {
            right -= 1;
            sb.append(')');
            dfs(left, right, sb, s);
            sb.setLength(sb.length()-1);
            right += 1;
        }

    }
}
