package com.zhl.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        int idx = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                nums2[idx++] = nums2[i];
                set1.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(nums2, 0, idx);

    }

    //    public int[] intersection(int[] nums1, int[] nums2) {
//        // 暴力求解
//
//
//        // 插入排序
//        // nums1 = insertionSort(nums1);
//        // nums2 = insertionSort(nums2);
//
//        // 快速排序
//        // quickSort(nums1, 0, nums1.length - 1);
//        // quickSort(nums2, 0, nums2.length - 1);
//
////        int[] num = new int[Math.max(nums1.length, nums2.length)];
////        int i, j, k;
////        for (i = j = k = 0; i < nums1.length && j < nums2.length; ) {
////            if (nums1[i] == nums2[j]) {
////                if (i == 0 || nums1[i] != nums1[i - 1]) {
////                    num[k++] = nums1[i];
////                    i++;
////                    j++;
////                }
////            } else if (nums1[i] > nums2[j]) {
////                j++;
////            } else if (nums1[i] < nums2[j]) {
////                i++;
////            }
////
////        }
////        int[] result = Arrays.copyOfRange(num, 0, k);
//        return result;
//    }
    public void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    public static void main(String[] args) {
        LeetCode_349 test = new LeetCode_349();
        test.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }
}
