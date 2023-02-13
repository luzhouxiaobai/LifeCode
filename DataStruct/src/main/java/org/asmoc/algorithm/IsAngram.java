package org.asmoc.algorithm;

import java.util.HashMap;

public class IsAngram {

    public boolean isAnagram(String s, String t) {

        if (s.equals(t) || s.length() != t.length()) return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char tok: s.toCharArray()) {
            hashMap.put(tok, hashMap.getOrDefault(tok, 0) + 1);
        }

        for (char tok: t.toCharArray()) {
            if (hashMap.containsKey(tok)) {
                hashMap.put(tok, hashMap.get(tok)-1);
            } else {
                return false;
            }
        }

        for (char tok: hashMap.keySet()) {
            if (hashMap.get(tok) != 0)
                return false;
        }

        return true;

    }

}
