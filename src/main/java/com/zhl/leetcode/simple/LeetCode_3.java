package com.zhl.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/15 16:00
 */
public class LeetCode_3 {

    public int lengthOfLongestSubstring(String s) {

        // 有没有好的数据结构可以使用
        // 拷贝自柴俊杰的code,没想到更好的解决办法
        int l = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(l, i).indexOf(s.charAt(i)) != -1) {
                l = s.indexOf(s.charAt(i), l) + 1;
            }
            dp[i + 1] = Math.max(dp[i], i - l + 1);
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        LeetCode_3 leetCode = new LeetCode_3();
        leetCode.lengthOfLongestSubstring("abcabcdbb");
    }
}
