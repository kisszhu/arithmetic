package com.qihoo.zhuhailong.arithmetic.sort;

/**
 * Created by zhuhailong-dc on 2018/6/11.
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        selectSort(new int[]{2, 5, 7, 9, 0, 1});
    }


    /**
     * 简单选择排序：
     * 是最简单直观的一种算法，基本思想为每一趟从待排序的数组元素中选择最小（或最大）的元素作为首元素，
     * 直到所有元素排完为止，简单选择排序是不稳定排序。
     */

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            /**
             * 每一趟循环比较时，min用于存放较小元素的数组下标，
             * 这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，
             * 避免每次遇到较小元素都要进行交换。
             */
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr, min, i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
     * 简单选择排序通过上面优化之后，无论数组原始排列如何，比较次数是不变的；
     * 对于交换操作，在最好情况下也就是数组完全有序的时候，无需任何交换移动，
     * 在最差的情况下，也就是数组倒叙的时候，交换次数为n-1次。综合下来，时间复杂度为O(n2)
     */
}

