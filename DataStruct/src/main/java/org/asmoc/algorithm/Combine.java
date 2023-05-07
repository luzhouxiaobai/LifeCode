package org.asmoc.algorithm;

import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new LinkedList<>();

        dfs(n, 0, -1, k, new LinkedList<Integer>(), result);
        return result;

    }

    public void dfs(int n, int curr, int index, int k, LinkedList<Integer> l, List<List<Integer>> result) {
        if (index==k) {
            result.add(new LinkedList<>(l));
            return;
        }
        for (int i=curr; i<=n; i++) {
            l.add(i);
            dfs(n, i+1, index+1, k, l , result);
            l.removeLast();
        }
    }
}
