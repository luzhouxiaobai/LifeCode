package org.asmoc.algorithm;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {

        Map<Long, Integer> hmap = new HashMap<>();
        hmap.put(0L, 1);
        long path = 0;
        int result = dfs(root, path, targetSum, hmap);
        return result;

    }


    public int dfs(TreeNode root, long path, int sum, Map<Long, Integer> hmap) {

        if (root==null) {
            return 0;
        }

        path = path + root.val;
        int count = hmap.getOrDefault(path-sum, 0);
        hmap.put(path, hmap.getOrDefault(path, 0)+1);

        count += dfs(root.left, path, sum, hmap);
        count += dfs(root.right, path, sum, hmap);

        hmap.put(path, hmap.get(path)-1);

        return count;

    }

}
