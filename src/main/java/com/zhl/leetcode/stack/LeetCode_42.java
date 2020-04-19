package com.zhl.leetcode.stack;


import java.util.Stack;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/04 11:22
 */
public class LeetCode_42 {

    public int trap(int[] height) {
        // 单调栈
        if (height.length == 0) {
            return 0;
        }
        /**
         * 我们可以用栈来跟踪可能储水的最长的条形块。使用栈就可以在一次遍历内完成计算
         * 我们在遍历数组时维护一个栈，如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定
         * 如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，
         * 因此我们可以栈顶元素并且累加答案到 ans中
         */

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全部pop出去
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            // 入栈
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_42 test = new LeetCode_42();
        System.out.println(test.trap(new int[]{}));
    }
}
