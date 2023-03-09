package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class FindTargetInTree {

    public boolean findTarget(TreeNode root, int k) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();

        while (curr!=null || !s.isEmpty()) {

            while (curr!=null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            int tmp = k - curr.val;
            if (hmap.containsKey(tmp)) return true;
            hmap.put(root.val, hmap.getOrDefault(root.val, 0)+1);

            curr = curr.right;

        }

        return false;

    }


}
