package com.zhl.leetcode.sliding.window;

import java.util.ArrayList;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/21 10:15
 */
public class LeetCode_1248 {

    /**
     * 给你一个整数数组 nums 和一个整数k
     * 如果某个 连续 子数组中恰好有k个奇数数字，我们就认为这个子数组是【优美子数组】
     * 请返回这个数组中【优美子数组】的数目
     */
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        /*
          使用滑动窗口，根据[优美子数组]的特点，我们先设定满足K个奇数作为窗口
          找到窗口之后，需要知道窗口前面的个数和后面的个数
          如果使用一个数组来记录奇数的索引，对这个数组相邻元素做减法即可知道原数组两个奇数之间有几个元素
         */
        List<Integer> indices = new ArrayList<>();
        indices.add(-1);
        for (int i = 0; i < nums.length; i++) {
            // 通过位运算，判断是否为奇数
            if ((nums[i] & 1) == 1) {
                indices.add(i);
            }
        }
        // 为了方便计算，原数组前后都插入了假奇数
        indices.add(nums.length);

        /*
         * 使用滑动窗口，i，i+k
         * 保证窗口内有足够的奇数，即i<indices.size()-k
         * 当滑到一个窗口的时候，计算刚脱离窗口的前面的个数leftEvenCount,计算在窗口内的后面的个数rightEventCount
         * 则组合为leftEventCount * rightEventCount
         * 结果累加
         */
        int ans = 0;
        for (int i = 1; i < indices.size() - k; i++) {
            int leftEvenCount = indices.get(i) - indices.get(i - 1);
            int rightEventCount = indices.get(i + k) - indices.get(i + k - 1);
            ans += leftEvenCount * rightEventCount;
        }

        return ans;
    }

    public static void main(String[] args) {
        LeetCode_1248 test = new LeetCode_1248();
        System.out.println(test.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }
}
