package org.asmoc.algorithm;

import java.util.Stack;

public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        TreeNode first = null;

        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (prev!=null) {
                prev.right = curr;
            } else {
                first = curr;
            }
            prev = curr;
            curr.left = null;
            curr = curr.right;

        }

        return first;

    }

}
