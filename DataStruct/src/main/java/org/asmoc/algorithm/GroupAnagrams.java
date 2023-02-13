package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagramsI(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        int[] flag = new int[strs.length];
        for (int i=0; i<strs.length; i++) {
            if (flag[i] == 0) {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                flag[i] = 1;
                for (int j=i+1; j< strs.length; j++) {
                    if (flag[j] == 0) {
                        if (isAnagrams(strs[i], strs[j])) {
                            tmp.add(strs[j]);
                            flag[j] = 1;
                        }
                    }
                }
                result.add(tmp);
            }
        }
        return result;
    }

    public boolean isAnagrams(String s, String t) {

        if (s.equals(t) || s.length() != t.length()) return false;

        int[] tmp = new int[26];

        for (char tok: s.toCharArray()) {
            tmp[tok - 'a'] += 1;
        }

        for (char tok: t.toCharArray()) {
            if (tmp[tok - 'a'] == 0) return false;
            tmp[tok - 'a'] -= 1;
        }

        return true;

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str: strs) {

            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            hashMap.putIfAbsent(sorted, new ArrayList<String>());
            hashMap.get(sorted).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }
}
