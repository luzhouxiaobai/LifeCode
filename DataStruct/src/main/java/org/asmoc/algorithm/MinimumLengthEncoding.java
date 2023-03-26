package org.asmoc.algorithm;

public class MinimumLengthEncoding {

    static class TrieNode {
        TrieNode node[];
        public TrieNode() {

            node = new TrieNode[26];

        }
    }

    public int minimumLengthEncoding(String[] words) {

        TrieNode root = buildTree(words);
        int[] res = {0};
        dfs(root, 0, res);
        return res[0];

    }

    public TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (int i=word.length()-1; i>=0; i--) {
                char tok = word.charAt(i);
                if (node.node[tok-'a'] == null) {
                    node.node[tok-'a'] = new TrieNode();
                }
                node = node.node[tok-'a'];
            }
        }
        return root;
    }

    public void dfs(TrieNode root, int length, int[] res) {
        boolean isLeaf = true;
        for (TrieNode child: root.node) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length+1, res);
            }
        }

        if (isLeaf) {
            res[0] += length+1;
        }
    }



}
