package com.zhl.leetcode.bit;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/28 16:26
 */
public class LeetCode_136 {

    public int singleNumber(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        return k;
    }

    public static void main(String[] args) {
        LeetCode_136 test = new LeetCode_136();
        System.out.println(test.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
