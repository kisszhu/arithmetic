package com.zhl.leetcode.array;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/18 10:05
 */
public class LeetCode_11 {
    public int maxArea(int[] height) {
        int ans = 0, first = 0, end = height.length - 1;
        while (first < end) {
            int area = Math.min(height[first], height[end]) * (end - first);
            ans = Math.max(ans, area);
            if (height[first] <= height[end]) {
                ++first;
            } else {
                --end;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_11 test = new LeetCode_11();
        System.out.println(test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
