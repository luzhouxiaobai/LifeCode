package org.asmoc.algorithm;

import java.util.Random;

public class Solution {

    int[] sum;
    int s = 0;

    public Solution(int[] w) {

        sum = new int[w.length];
        
        for (int i=0; i<w.length; i++) {
            sum[i] = w[i] + s;
            s = s + w[i];
        }

    }

    public int pickIndex() {

        Random p = new Random();
        int res = p.nextInt(s);
        int left = 0, right = sum.length-1;
        while(left<=right) {
            int mid = (left + right) / 2;
            if (sum[mid]>res) {

                if (mid==0 || sum[mid-1]<=res) {
                    return mid;
                }
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] w = {1,2};
        Solution t = new Solution(w);
        System.out.println(t.pickIndex());
    }

}
