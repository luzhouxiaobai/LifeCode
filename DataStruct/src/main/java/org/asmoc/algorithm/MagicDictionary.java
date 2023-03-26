package org.asmoc.algorithm;

public class MagicDictionary {

    static class TrieNode {
        TrieNode[] node;
        boolean isWord;
        public TrieNode() {
            node = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {

        root = new TrieNode();

    }

    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            TrieNode node = this.root;
            for (char ch: word.toCharArray()) {
                if (node.node[ch-'a']==null) {
                    node.node[ch-'a'] = new TrieNode();
                }
                node = node.node[ch-'a'];
            }
            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, 0, 0, root);
    }

    public boolean dfs(String searchWord, int index, int change, TrieNode node) {
        if (node==null) {
            return false;
        }
        if (index==searchWord.length() && change==1 && node.isWord) {
            return true;
        }

        if (index<searchWord.length() && change <=1) {
            boolean found = false;
            for (int j=0; j<26 &&!found; j++) {
                int next = j==searchWord.charAt(index)-'a' ? change: change+1;
                found = dfs(searchWord, index+1, next, node.node[j]);
            }
            return found;
        }
        return false;
    }

}
