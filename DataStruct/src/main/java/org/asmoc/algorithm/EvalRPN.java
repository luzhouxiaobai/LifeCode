package org.asmoc.algorithm;

import java.util.Stack;

public class EvalRPN {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String tok: tokens) {
            switch (tok) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int r = stack.pop();
                    int l = stack.pop();
                    int tmp = getResult(l, r, tok);
                    stack.push(tmp);
                    break;
                default:
                    stack.push(Integer.parseInt(tok));
            }
        }

        return stack.pop();

    }

    public int getResult(int l, int r, String op) {
        switch (op) {
            case "+":
                return l+r;
            case "-":
                return l-r;
            case "*":
                return l * r;
            case "/":
                return l / r;
        }
        return -1;
    }

}
