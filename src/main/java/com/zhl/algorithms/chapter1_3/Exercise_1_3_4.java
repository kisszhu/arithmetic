package com.zhl.algorithms.chapter1_3;

import java.util.Stack;

/**
 * 编写一个Stack的用例Parenthess.从标准输入中读取一个文本流并使用栈判定其中的括号是否完全匹配。
 * 例如，对于"[", "(", ")", "]", "{", "}", "{", "[", "(", ")", "(", ")", "]", "(", ")", "}"
 * 程序打印true，对于[(])则打印false
 */
public class Exercise_1_3_4 {

    public static void main(String[] args) {

        // 利用Dijkstra双栈的想法
        // String[] matching = {"[", "(", ")", "]", "{", "}", "{", "[", "(", ")", "(", ")", "]", "(", ")", "}"};
        String[] matching = {"[", "(", "]", ")"};

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < matching.length; i++) {
            String str = matching[i];
            if ("[".equals(str) || "(".equals(str) || "{".equals(str)) {
                stack.push(matching[i]);
            } else {
                String start = stack.pop();
                if (")".equals(str) && "(".equals(start)) {

                } else if ("]".equals(str) && "[".equals(start)) {

                } else if ("}".equals(str) && "{".equals(start)) {

                } else {
                    System.out.println("no match");
                }
            }
        }
    }
}
