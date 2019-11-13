package com.zhl.leetcode.simple;

import com.zhl.algorithms.chapter1_3.Stack;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/12 11:33
 */
public class LeetCode_20 {
    public boolean isValid(String s) {
        String[] operates = s.split("");
        Stack<String> op = new Stack<>();
        boolean flag = true;
        for (String operate : operates) {
            if (operate.equals("(")) {
                op.push(operate);
            } else if (operate.equals("{")) {
                op.push(operate);
            } else if (operate.equals("[")) {
                op.push(operate);
            } else if (operate.equals(")")) {
                if (op.isEmpty() || !op.pop().equals("(")) {
                    flag = false;
                }
            } else if (operate.equals("}")) {
                if (op.isEmpty() || !op.pop().equals("{")) {
                    flag = false;
                }
            } else if (operate.equals("]")) {
                if (op.isEmpty() || !op.pop().equals("[")) {
                    flag = false;
                }
            } else {
                // ignore 空字符串
            }
        }
        boolean result = op.isEmpty() && flag;
        return result;
    }

    public static void main(String[] args) {
        String operates = "() {}";
        LeetCode_20 leetCode = new LeetCode_20();
        leetCode.isValid(operates);
    }
}