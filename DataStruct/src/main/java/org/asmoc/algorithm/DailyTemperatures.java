package org.asmoc.algorithm;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperature(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for (int i=0; i<temperatures.length; i++) {
            int tok = temperatures[i];
            while (!s.isEmpty() && tok > temperatures[s.peek()]) {
                int tmp = s.pop();
                result[tmp] = i - tmp;
            }
            s.push(i);
        }
        return result;
    }

}
