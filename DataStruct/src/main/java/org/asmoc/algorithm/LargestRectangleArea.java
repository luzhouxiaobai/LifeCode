package org.asmoc.algorithm;

import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {

        int maxResult = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for (int i=0; i<heights.length; i++) {

            int tok = heights[i];
            while (s.peek()!=-1 && heights[s.peek()]>tok) {
                int h = heights[s.pop()];
                int c = i - s.peek()-1;
                maxResult = Math.max(maxResult, c * h);
            }
            s.push(i);
        }

        while (s.peek()!=-1) {
            int h = heights[s.pop()];
            int c = heights.length - s.peek()-1;
            maxResult = Math.max(maxResult, c * h);
        }
        return maxResult;
    }

}
