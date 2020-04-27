package com.zhl.leetcode.binary.search;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/27 11:16
 */
public class LeetCode_153 {

    public int findMin(int[] nums) {
        /**
         * 寻找最小值的题目，可以用二分查找来解决：
         * 用二分法查找，需要始终将目标值（这里是最小值）套住，并不断收缩左边界或右边界。
         */
        int left = 0;
        int right = nums.length - 1;
        //
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 收缩左边界
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 收缩右边界
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        LeetCode_153 test = new LeetCode_153();
        // 3 4 5 1 2
        System.out.println(test.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
