package com.zhl.leetcode.dp;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/24 08:50
 */
public class LeetCode_17_16 {
    public int massage(int[] nums) {
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
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

//    public int massage(int[] nums) {
//        int a = 0, b = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int c = Math.max(b, a + nums[i]);
//            a = b;
//            b = c;
//        }
//        return b;
//    }

    public static void main(String[] args) {
        LeetCode_17_16 test = new LeetCode_17_16();
        int res = test.massage(new int[]{2, 7, 9, 3, 1});
        System.out.println(res);
    }
}

//
//class Solution {
//    public int massage(int[] nums) {
//        int a = 0, b = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int c = Math.max(b, a + nums[i]);
//            a = b;
//            b = c;
//        }
//        return b;
//    }
//}


//    public int massage(int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return nums[0];
//        }
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//        return dp[n - 1];
//    }