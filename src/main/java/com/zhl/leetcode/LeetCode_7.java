package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/14 08:31
 */
public class LeetCode_7 {

    /**
     * 这道题，一般有两种解法：
     * 1、通过数学公式去解决
     * 2、通过字符串的反转来解决
     * 在我看来，既然是数字的反转，所以，这里采用通过数学公式来解决
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) ? 0 : (int) result;
    }

    public static void main(String[] args) {
        LeetCode_7 leetCode = new LeetCode_7();
        System.out.println(leetCode.reverse(1230));
    }
}