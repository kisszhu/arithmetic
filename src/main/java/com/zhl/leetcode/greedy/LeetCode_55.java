package com.zhl.leetcode.greedy;

import com.zhl.learn.algorithm.hash.map.level1.Map;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/17 09:19
 */
public class LeetCode_55 {


    /**
     * 正序贪心
     */

//    贪心算法，每个位置都计算自己能达到的最远距离，同时每个位置要判断自己是否可达，
//    也就是本位置需要在当前最远能到达的距离中。最终计算出来能到达的最远距离，与数组长度比较即可。


    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int maxDist = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 到不了该位置，结束
            if (maxDist < i) {
                return false;
            }
            // 可以到达末尾位置，结束
            if (maxDist >= n - 1) {
                return true;
            }
            maxDist = Math.max(maxDist, nums[i] + i);
        }
        return false;
    }

    /**
     * 逆向思维，从后向前跳
     */
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        // 要到达的位置
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 如果当前的位置 + 跳跃的长度>=要到达的位置，则表示可以
            if (i + nums[i] >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        LeetCode_55 test = new LeetCode_55();
        System.out.println(test.canJump(nums));
    }
}
