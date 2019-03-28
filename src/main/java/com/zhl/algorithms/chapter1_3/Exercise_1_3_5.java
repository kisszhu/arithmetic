package com.zhl.algorithms.chapter1_3;

import java.util.Stack;

/**
 * 当N为50时下面这段代码会打印什么？从较高的层次描述给定正整数N时这段代码的行为
 * 答：求的是N的二进制表示
 */
public class Exercise_1_3_5 {

    public static void main(String[] args) {
        int N = 50;
        Stack<Integer> stack = new Stack<>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (Integer d : stack) {
            System.out.println(d);
        }
    }
}
