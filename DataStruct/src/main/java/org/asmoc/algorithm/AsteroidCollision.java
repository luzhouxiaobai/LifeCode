package org.asmoc.algorithm;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int tok: asteroids) {

            while (!stack.isEmpty() && stack.peek()>0 && stack.peek() < -tok) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek()>0 && stack.peek()==-tok) {
                stack.pop();
            } else if (stack.isEmpty() || stack.peek()<0 || tok > 0) {
                stack.push(tok);
            }

        }

        return stack.stream().mapToInt(i-> i).toArray();

    }

    public static void main(String[] args) {
        int[] a =new int[] {5, 10, -5};
        int[] res = new AsteroidCollision().asteroidCollision(a);
    }

}
