package com.zhl.leetcode.binary.search;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/26 17:24
 */
public class LeetCode_34 {
    public int[] searchRange(int[] nums, int target) {
        return null;

        // 二分查找mid=(left+right)/2, left=mid+1
//        int mid, left = 0;
//        int right = nums.length - 1;
//
//        int[] index = new int[nums.length];
//        int
//        while (left <= right) {
//            mid = left + ((right - left) >> 1);
//            if (nums[mid] == target) {
//                index[mid] = mid;
//                if (mid > 0 && nums[mid - 1] == target) {
//                    for (int i = mid - 1; i >= 0; i--) {
//                        if (nums[i] == target) {
//                            index[i] = i;
//                        } else {
//                            break;
//                        }
//                    }
//                }
//                if (mid <= nums.length - 2 && nums[mid + 1] == target) {
//                    for (int i = mid + 1; i <= nums.length - 1; i++) {
//                        if (nums[i] == target) {
//                            index[i] = i;
//                        } else {
//                            break;
//                        }
//                    }
//                }
//                break;
//            }
//            if (nums[mid] > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return index;
    }

    public static void main(String[] args) {
        LeetCode_34 test = new LeetCode_34();
        int[] index = test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
    }
}
