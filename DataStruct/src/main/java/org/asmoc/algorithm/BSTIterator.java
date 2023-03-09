package org.asmoc.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {

    Queue<Integer> q = new LinkedList<>();

    public BSTIterator(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !s.isEmpty()) {
            while (curr!=null) {
                s.push(curr);
                curr=curr.left;
            }
            curr = s.pop();
            q.add(curr.val);
            curr = curr.right;
        }

    }

    public int next() {

        return q.poll();

    }

    public boolean hasNext() {

        return !q.isEmpty();

    }

}
