package org.asmoc.algorithm;

public class FindMaximumXOR {

    static class TrieNode {
        TrieNode[] node;
        public TrieNode() {
            this.node = new TrieNode[2];
        }
    }

    public TrieNode buildTree(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num: nums) {
            TrieNode node = root;
            for (int i=31; i>=0; i--) {
                int tok = (num>>i) & 1;
                if (node.node[tok]==null) {
                    node.node[tok] = new TrieNode();
                }
                node = node.node[tok];
            }
        }
        return root;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTree(nums);
        int maxSum = 0;
        for (int num: nums) {
            TrieNode node = root;
            int tmp = 0;
            for (int i=31; i>=0; i--) {
                int tok = (num>>i) & 1;
                if (node.node[1-tok]!=null) {
                    tmp = tmp * 2 + 1;
                    node = node.node[1-tok];
                } else {
                    tmp = tmp * 2;
                    node = node.node[tok];
                }
            }
            maxSum = Math.max(maxSum, tmp);
        }
        return maxSum;
    }
}
