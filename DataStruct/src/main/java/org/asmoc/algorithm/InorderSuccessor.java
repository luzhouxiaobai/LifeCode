package org.asmoc.algorithm;

import java.util.Stack;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        boolean is = false;

        while (curr!=null || !stack.isEmpty()) {

            while (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (is) return curr;
            else {
                if (curr==p) {
                    is = true;
                }
            }
            curr = curr.right;

        }

        return null;

    }

}
