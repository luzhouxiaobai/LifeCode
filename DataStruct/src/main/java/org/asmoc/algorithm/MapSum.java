package org.asmoc.algorithm;

public class MapSum {

    static class TrieNode {
        TrieNode[] node;
        int score;
        public TrieNode() {
            node = new TrieNode[26];
            score = 0;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (char ch: key.toCharArray()) {
            if (node.node[ch-'a']==null) {
                node.node[ch-'a'] = new TrieNode();
            }
            node = node.node[ch-'a'];
        }
        node.score = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char ch: prefix.toCharArray()) {
            if (node.node[ch-'a']!=null) {
                node = node.node[ch-'a'];
            } else {
                return 0;
            }
        }
        int[] score = {node.score};
        dfs(node, score);
        return score[0];

    }

    public void dfs(TrieNode root, int[] score) {
        for (TrieNode tmp: root.node) {
            if (tmp!=null) {
                score[0] += tmp.score;
                dfs(tmp, score);
            }
        }
    }

}
