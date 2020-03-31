package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/31 08:24
 */
public class LeetCode_912 {

    /**
     * 复习下插入排序
     */
    public int[] sortArray(int[] nums) {
        int i, j, temp;
        for (i = 0; i < nums.length; i++) {
            temp = nums[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp > nums[j]) {
                    break;
                } else {
                    nums[j + 1] = nums[j];
                }
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode_912 test = new LeetCode_912();
        int[] nums = test.sortArray(new int[]{5,1,1,2,0,0});
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
