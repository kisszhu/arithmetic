package com.zhl.leetcode.simple;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/20 09:03
 */
public class LeetCode_852 {

    /**
     * 山脉数组：
     * 主要的解法有两种：
     * 1、利用二分查找法
     * 2、利用循环，找寻最大值
     * <p>
     * 这里主要考察的是二分查找，所以这里使用二分查找来解决
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;

        int result;
        for (; true; ) {
            int mid = (left + right) / 2;
            int a = A[mid];
            int b = A[mid - 1];
            int c = A[mid + 1];

            // 向右侧移动
            if (a > b && a < c) {
                left = mid + 1;
            }

            // 向左侧移动
            if (a < b && a > c) {
                right = mid - 1;
            }

            if (a > b && a > c) {
                result = mid;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_852 test = new LeetCode_852();
        // 山脉数组
        test.peakIndexInMountainArray(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1});
    }
}
