package org.asmoc.algorithm;

public class Trie {

    static class TrieNode {
        TrieNode[] node;
        boolean isWord;

        public TrieNode() {
            node = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;

        for (char ch: word.toCharArray()) {
            if (node.node[ch-'a'] == null) {
                node.node[ch-'a'] = new TrieNode();
            }
            node = node.node[ch-'a'];
        }

        node.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (node.node[ch-'a'] == null) return false;
            node = node.node[ch-'a'];
        }

        return node.isWord;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode node = root;
        for (char ch: prefix.toCharArray()) {
            if (node.node[ch-'a']==null) return false;
            node = node.node[ch-'a'];
        }
        return true;
    }
}
