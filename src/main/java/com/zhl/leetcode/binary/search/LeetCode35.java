package com.zhl.leetcode.binary.search;

import java.time.LocalDate;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/01/17 14:55
 */
public class LeetCode35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int mid, left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LeetCode35 test = new LeetCode35();
        int result = test.searchInsert(new int[]{1, 3, 5, 6, 10}, 7);
        System.out.println(result);
    }
}
