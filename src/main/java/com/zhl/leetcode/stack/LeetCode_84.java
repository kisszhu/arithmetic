package com.zhl.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/04 13:21
 */
public class LeetCode_84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        heights = Arrays.copyOfRange(heights, 0, heights.length + 1);
        heights[heights.length - 1] = 0;

        /**
         * 左边沿是左边第一小于本柱子高的柱子的右边，右边沿也是同理
         * 从栈顶的角度看，这正好可以用单调栈，而LeetCode_42题，接雨水，则是从栈顶右侧看（看的V）
         * 这道题，看的是峰
         * 当第i个柱子进栈时，如果栈顶柱子（此时计作A）的高度低于或等于第i个柱子，则第i个柱子进栈；
         * 如果高于第i个柱子，则出栈，并计算此时的峰为A的矩形最大面积
         *
         * 高度：就是柱子A的高度
         * 右边沿：正好是i（由于单调栈的性质，第i个柱子就是右边第一个矮于A的柱子）
         * 左边沿：单调栈中紧邻A的柱子，（如果A已经出栈，那么左边沿就是A出栈后的栈顶）
         *
         */

        /**
         * 转换思维为，求每个柱状体的最大面积，有六个柱状体，就有六种形式
         */
        // 单调递增栈
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            // 单调栈 增
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int curIdx = stack.pop();
                while (!stack.isEmpty() && heights[stack.peek()] == heights[curIdx]) {
                    stack.pop();
                }
                ans = Math.max(ans, heights[curIdx] * (stack.empty() ? i : (i - stack.peek() - 1)));
            }
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_84 test = new LeetCode_84();
        System.out.println(test.largestRectangleArea(new int[]{4, 2, 3}));
    }
}
