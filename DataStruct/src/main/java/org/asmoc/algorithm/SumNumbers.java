package org.asmoc.algorithm;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {

        if (root==null) return 0;
        int[] num = new int[1];
        sumTree(root, 0, num);
        return num[0];

    }

    public void sumTree(TreeNode root, int num, int[] nums) {

        num = num * 10 + root.val;
        if (root.left==null && root.right==null) {
            nums[0] += num;
        } else {

            if (root.left!=null)
                sumTree(root.left, num, nums);
            if (root.right!=null)
                sumTree(root.right, num, nums);
        }

    }

}
