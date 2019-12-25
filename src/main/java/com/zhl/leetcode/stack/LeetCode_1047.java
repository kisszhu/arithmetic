package com.zhl.leetcode.stack;

import java.util.Stack;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/25 21:18
 */
public class LeetCode_1047 {

    public String removeDuplicates(String S) {
        Stack stack = new Stack();
        for (char i : S.toCharArray()) {
            if (!stack.empty()) {
                char x = (char) stack.pop();
                if (x != i) {
                    stack.push(x);
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode_1047 test = new LeetCode_1047();
        String res = test.removeDuplicates("abbaca");
        System.out.println(res);
    }
}
