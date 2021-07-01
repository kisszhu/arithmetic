package com.zhl.leetcode.binarySearch;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/07 21:38
 */
public class LeetCode_1351 {

	/**
	 * 暴力解法
	 */
	public int countNegatives(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int m = grid.length, n = grid[0].length;
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] < 0) {
					ans++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LeetCode_1351 test = new LeetCode_1351();
		int[][] matrix = new int[2][2];
		matrix[0][0] = 3;
		matrix[0][1] = 2;

		matrix[1][0] = 1;
		matrix[1][1] = 0;

		System.out.println(test.countNegatives(matrix));
	}
}
