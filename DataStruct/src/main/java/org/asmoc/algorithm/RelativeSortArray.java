package org.asmoc.algorithm;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num: arr1) {
            count[num]++;
        }
        int i = 0;
        for (int num: arr2) {
            while (count[num]>0) {
                arr1[i++] = num;
                count[num]--;
            }
        }
        for(int j=0; j<count.length; j++) {
            while (count[j]>0) {
                arr1[i++] = j;
                count[j]--;
            }
        }
        return arr1;
    }

}
