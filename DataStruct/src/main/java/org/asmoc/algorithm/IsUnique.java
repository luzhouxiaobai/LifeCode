package org.asmoc.algorithm;

public class IsUnique {

    public boolean isUnique(String astr) {

        int[] record = new int[26];
        for (char ch: astr.toCharArray()) {
            int index = ch - 'a';
            if (record[index] == 0) record[index] += 1;
            else
                return false;

        }
        return true;

    }

    public boolean isUniqueBak(String str) {

        int tok = 1;
        int after = 0;
        for (char ch: str.toCharArray()) {
            int size = ch - 'a';
            tok = tok << size;

            if ((tok & after) !=0) {
                return false;
            }

            after = after | tok;

        }
        return true;

    }

}
