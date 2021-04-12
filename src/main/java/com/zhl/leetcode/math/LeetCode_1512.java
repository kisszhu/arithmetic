package com.zhl.leetcode.math;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode_1512
 * @Description
 * @Author yuguang
 * @Date 2021/4/12 8:27 下午
 * @Version 1.0
 **/
public class LeetCode_1512 {
	public int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
		}

		int ans = 0;
		for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
			// 组合模式
			ans += (entry.getValue() * (entry.getValue() - 1)) / 2;
		}
		return ans;

		// for循环暴力解法
/*		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					num++;
				}
			}
		}
		return num;*/
	}

	public static void main(String[] args) {
		LeetCode_1512 t_1512 = new LeetCode_1512();

		int[] nums = {1, 2, 3, 1, 1, 3};
		System.out.println(t_1512.numIdenticalPairs(nums));
	}
}
