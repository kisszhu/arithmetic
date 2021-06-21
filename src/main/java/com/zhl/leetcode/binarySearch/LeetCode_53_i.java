package com.zhl.leetcode.binarySearch;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/26 16:36
 */
public class LeetCode_53_i {

    public int search(int[] nums, int target) {
        // 二分查找mid=(left+right)/2, left=mid+1
        int mid, left = 0;
        int right = nums.length - 1;

        int count = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                count++;
                if (mid > 0 && nums[mid - 1] == target) {
                    for (int i = mid - 1; i >= 0; i--) {
                        if (nums[i] == target) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
                if (mid <= nums.length - 2 && nums[mid + 1] == target) {
                    for (int i = mid + 1; i <= nums.length - 1; i++) {
                        if (nums[i] == target) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode_53_i test = new LeetCode_53_i();
        System.out.println(test.search(new int[]{1, 1, 2}, 1));
    }
}
