package com.zhl.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/21 08:59
 */
public class LeetCode_349 {

    /**
     * 求数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 插入排序
        nums1 = insertionSort(nums1);
        nums2 = insertionSort(nums2);

        int[] num = new int[Math.max(nums1.length, nums2.length)];
        int i, j, k;
        for (i = j = k = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                if (i == 0 || nums1[i] != nums1[i - 1]) {
                    num[k] = nums1[i];
                    k++;
                    i++;
                    j++;
                }
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }

        }
        int[] result = Arrays.copyOfRange(num, 0, k);
        return result;
    }

    public int[] insertionSort(int[] num) {
        int i, j, temp;
        // 从数组的第二个元素开始
        for (i = 1; i < num.length; i++) {
            // 取出第二个元素
            temp = num[i];
            // 用取出的元素，依次与左边的数值多比较
            for (j = i - 1; j >= 0; j--) {
                // 如果大于，则说明目前的顺序问题不大
                if (temp > num[j]) {
                    break;
                } else {
                    // 如果小于，则左元素右移动
                    num[j + 1] = num[j];
                }
            }
            num[j + 1] = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_349 test = new LeetCode_349();
        test.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }
}
