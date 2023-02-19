package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int current = 0;
        int next = 0;
        if (root==null)
            return result;

        queue.offer(root);
        current += 1;

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            current -= 1;

            if (tmp.left != null) {
                next += 1;
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                next += 1;
                queue.offer(tmp.right);
            }

            if (current==0) {
                result.add(tmp.val);
                current = next;
                next = 0;
            }

        }

        return result;

    }

}
