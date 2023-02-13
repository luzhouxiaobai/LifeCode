package org.asmoc.algorithm;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        int[] h = new int[matrix[0].length()];
        for (String tok: matrix) {

            for (int i=0; i<tok.length(); i++) {

                if (tok.charAt(i) == '0') h[i] = 0;
                else h[i] += 1;

            }
            maxArea = Math.max(maxArea, maxVal(h));

        }
        return maxArea;
    }

    public int maxVal(int[] h) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for (int i=0; i<h.length; i++) {

            while (s.peek()!=-1 && h[s.peek()] > h[i]) {
                int he = h[s.pop()];
                int cl = i - s.peek() - 1;
                max = Math.max(max, he * cl );
            }

            s.push(i);

        }

        while (s.peek()!=-1) {
            int he = h[s.pop()];
            int cl = h.length - s.peek() - 1;
            max = Math.max(max, he * cl);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle mx = new MaximalRectangle();
        String[] t = {"01", "10"};
        int res = mx.maximalRectangle(t);
        System.out.println(res);
    }

}
