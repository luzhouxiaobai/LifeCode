package org.asmoc.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {

        if (root==null)
            return -1;

        int current = 1;
        int next_= 0;
        int flagNum = current;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int result = -1;
        while (!queue.isEmpty()) {

            TreeNode tmp = queue.poll();
            if (next_ == 0 && current == flagNum) {
                result = tmp.val;
            }
            current -= 1;

            if (tmp.left != null) {
                next_ += 1;
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                next_ += 1;
                queue.offer(tmp.right);
            }

            if (current == 0) {
                current = next_;
                next_ = 0;
                flagNum = current;
            }

        }

        return result;

    }

}
