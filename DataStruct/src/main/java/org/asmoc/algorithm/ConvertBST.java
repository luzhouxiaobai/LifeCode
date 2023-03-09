package org.asmoc.algorithm;

import java.util.Stack;

public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {

        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        int sum = 0;

        while (curr!=null || !s.isEmpty()) {

            while (curr!=null) {
                s.push(curr);
                curr = curr.right;
            }

            curr = s.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;

        }

        return root;

    }
}
