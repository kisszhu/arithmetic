package com.zhl.leetcode.math;

/**
 * @ClassName LeetCode_16_01
 * @Description
 * @Author yuguang
 * @Date 2021/4/13 7:35 下午
 * @Version 1.0
 **/
public class LeetCode_16_01 {

	public int[] swapNumbers(int[] numbers) {
		// 交换原则
		// 1 + 2 = 3
		numbers[0] = numbers[0] + numbers[1];
		// 3 - 2 = 1
		numbers[1] = numbers[0] - numbers[1];
		// 1 - 3 = -2
		numbers[0] = -(numbers[1] - numbers[0]);
		return numbers;
	}

	public static void main(String[] args) {
		LeetCode_16_01 test = new LeetCode_16_01();
		int[] nums = test.swapNumbers(new int[]{1, 2});
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		// 2 1
	}
}
