package com.zhl.leetcode.math;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/18 09:17
 */
public class LeetCode_1281 {
	public int subtractProductAndSum(int n) {
		int multi = 1;
		int sum = 0;
		while (n != 0) {
			int num = n % 10;
			multi = multi * num;
			sum = sum + num;
			n = n / 10;
		}
		return multi - sum;
	}

	public static void main(String[] args) {
		LeetCode_1281 test = new LeetCode_1281();
		System.out.println(test.subtractProductAndSum(705));
	}
}