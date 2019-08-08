package com.zhl.learn.arithmetic.sort;

/**
 * Created by zhuhailong-dc on 2018/6/11.
 * 直接插入排序
 */
public class InsertSort {

    /**
     * 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去
     * 直到插完所有元素为止。
     */

    public static void main(String[] args) {
        insertionSort(new int[]{2, 5, 7, 9, 0, 1});
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
     * 简单插入排序在最好情况下，需要比较n-1次，无需交换元素，时间复杂度为O(n)；
     * 在最坏情况下，时间复杂度依然为O(n2)。但是在数组元素随机排列的情况下，插入排序
     * 还是要由于简单选择排序和冒泡排序的。
     */
}


//        for (int i = 0; i < arr.length - 1; i++) {
//        System.out.println(arr[i]);
//        }