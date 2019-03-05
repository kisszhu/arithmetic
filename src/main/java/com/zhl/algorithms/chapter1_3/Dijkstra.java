package com.zhl.algorithms.chapter1_3;

import java.util.Stack;

/**
 * （1+（（2+3） * （4 * 5）））.
 */
public class Dijkstra {
    public static void main(String[] args) {
        String[] operates = {"(", "1", "+", "(", "(", "2", "+", "3", ")", "*", "(", "4", "*", "5", ")", ")", ")"};
        Stack<Double> num = new Stack<>();
        Stack<String> op = new Stack<>();
        for (String operate : operates) {
            if (operate.equals("(")) ;// ignore
            else if (operate.equals("+")) {
                op.push(operate);
            } else if (operate.equals("-")) {
                op.push(operate);
            } else if (operate.equals("*")) {
                op.push(operate);
            } else if (operate.equals("/")) {
                op.push(operate);
            } else if (operate.equals(")")) {
                String handle = op.pop();
                if (handle.equals("+")) {
                    num.push(num.pop() + num.pop());
                } else if (handle.equals("*")) {
                    num.push(num.pop() * num.pop());
                }
            } else {
                num.push(Double.parseDouble(operate));
            }
        }
        System.out.println("The result is " + num.pop());
    }
}
