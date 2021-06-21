package com.zhl.leetcode.binarySearch;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/27 10:02
 */
public class LeetCode_33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序，注意此处用小于等于（保持稳定性）
            if (nums[start] <= nums[mid]) {
                // target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_33 test = new LeetCode_33();
        System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}