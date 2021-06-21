package com.zhl.leetcode.binarySearch;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/26 17:24
 */
public class LeetCode_34 {

	public int[] searchRange(int[] nums, int target) {
		int left = binarySearchLeft(nums, target);
		int right = binarySearchRight(nums, target) - 1;
		boolean check = left <= right && right <= nums.length - 1 && nums[left] == target && nums[right] == target;
		if (check) {
			return new int[]{left, right};
		} else {
			return new int[]{-1, -1};
		}
	}

	public int binarySearchLeft(int[] nums, int target) {
		int mid, left = 0;
		int right = nums.length - 1;
		int ans = nums.length;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	public int binarySearchRight(int[] nums, int target) {
		int mid, left = 0;
		int right = nums.length - 1;
		int ans = nums.length;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LeetCode_34 test = new LeetCode_34();
		int[] index = test.searchRange(new int[]{1}, 1);
		for (int i = 0; i < index.length; i++) {
			System.out.println(index[i]);
		}
	}
}
