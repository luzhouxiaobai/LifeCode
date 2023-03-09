package org.asmoc.algorithm;

public class MaxPathSum {

    public int maxPathSum(TreeNode root) {

        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];

    }

    public int dfs(TreeNode root, int[] maxSum) {

        if (root==null) {
            return 0;
        }

        int[] maxLeftSum = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, maxLeftSum));

        int[] maxRightSum = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, maxRightSum));

        maxSum[0] = Math.max(maxLeftSum[0], maxRightSum[0]);
        maxSum[0] = Math.max(maxSum[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }

}
