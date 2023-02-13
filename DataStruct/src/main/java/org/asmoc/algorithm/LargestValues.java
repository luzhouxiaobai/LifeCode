package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root==null) return result;

        int current = 0;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        current = 1;

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            max = Math.max(max, tmp.val);
            current -= 1;

            if (tmp.left != null) {
                next += 1;
                queue.offer(tmp.left);
            }

            if (tmp.right != null) {
                next += 1;
                queue.offer(tmp.right);
            }

            if (current == 0) {
                result.add(max);
                current = next;
                next = 0;
                max = Integer.MIN_VALUE;
            }
        }
        return result;

    }

}
