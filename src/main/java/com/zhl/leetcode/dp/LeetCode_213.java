package com.zhl.leetcode.dp;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/24 09:39
 */
public class LeetCode_213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int num1 = dp[n - 2];
        System.out.println(num1);


        int a = 0, b = 0;
        for (int i = 1; i < n; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        int num2 = b;
        return Math.max(num1, num2);
    }

    public static void main(String[] args) {
        LeetCode_213 test = new LeetCode_213();
        System.out.println(test.rob(new int[]{2, 3, 2}));
    }
}
