package com.zhl.leetcode.array;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/27 19:54
 */
public class LeetCode_1295 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_1295 test = new LeetCode_1295();
        int ans = test.findNumbers(new int[]{12, 345, 2, 6, 7896});
        System.out.println(ans);
    }
}
