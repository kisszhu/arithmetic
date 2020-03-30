package com.zhl.leetcode.array;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/29 20:44
 */
public class LeetCode_26 {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        LeetCode_26 test = new LeetCode_26();
        int res = test.removeDuplicates(new int[]{1, 1, 2});

        System.out.println(res);
    }
}
