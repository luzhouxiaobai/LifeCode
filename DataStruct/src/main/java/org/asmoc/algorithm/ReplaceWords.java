package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

    static class TrieNode {
        TrieNode[] node;
        boolean isWord;
        public TrieNode() {
            node = new TrieNode[26];
            isWord = false;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        TrieNode root = new TrieNode();

        // 复杂的 O(nXm)
        for (String tok: dictionary) {
            TrieNode node = root;

            for (char ch: tok.toCharArray()) {
                if (node.node[ch-'a']==null) {
                    node.node[ch-'a'] = new TrieNode();
                }
                node = node.node[ch-'a'];
            }
            node.isWord = true;
        }

        // 匹配
        StringBuilder sb = new StringBuilder();
        for (String tok: sentence.split(" ")) {
            TrieNode node = root;
            StringBuilder ns = new StringBuilder();
            boolean f = true;
            for (char ch: tok.toCharArray()) {
                if (node.node[ch-'a'] != null) {
                    ns.append(ch);
                    node = node.node[ch-'a'];
                    if (node.isWord) {
                        sb.append(ns.toString());
                        f = false;
                        break;
                    }
                } else {
                    sb.append(tok);
                    f = false;
                    break;
                }
            }
            if (f) {
                sb.append(ns.toString());
            }
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();
        ls.add("so");
        ls.add("sad");
        ls.add("rat");

        String s = "s s sa ra cattle was rattled by the battery";
        ReplaceWords rw = new ReplaceWords();
        String sd = rw.replaceWords(ls, s);
        System.out.println(sd);
    }

}
