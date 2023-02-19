package org.asmoc.algorithm;

import java.util.Stack;

public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {

        if (root==null) return null;

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);

        if (left==null && right==null && root.val==0) return null;

        return root;

    }

    public TreeNode pruneTree2(TreeNode root) {

        if (root==null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr!=null || !stack.isEmpty()) {

            while (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
            } else {

                stack.pop();
                if (curr.val == 0 && curr.left==null && curr.right==null) {
                    if (stack.isEmpty())
                        return null;
                    TreeNode tmp = stack.peek();
                    prev = null;
                    if (tmp.left==curr) {
                        tmp.left = null;
                        curr = tmp.right;
                    } else {
                        tmp.right = null;
                        curr = null;
                    }

                } else {
                    prev = curr;
                    curr = null;
                }

            }

        }

        return root;

    }

}
