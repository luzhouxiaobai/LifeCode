package org.asmoc.algorithm;

public class IsAlienSorted {

    public boolean isAlienSorted(String[] words, String order) {

        int[] orderArray = new int[order.length()];
        for (int i=0; i<order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }

        for (int i=0; i<words.length-1; i++) {
            if (!isSorted(words[i], words[i+1], orderArray)) return false;
        }

        return true;
    }

    public boolean isSorted(String s, String t, int[] arr) {
        for (int i=0; i<s.length() && i<t.length(); i++) {
            if (arr[s.charAt(i)-'a'] < arr[t.charAt(i)-'a']) return true;
            else if (arr[s.charAt(i)-'a'] > arr[t.charAt(i)-'a']) return false;
        }
        return s.length() <= t.length();
    }

}
