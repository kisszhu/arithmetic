package com.zhl.algorithms.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/25 17:05
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        // 递归到叶子节点，只有一个节点，还排什么序
        if (low == high) {
            return;
        }

        // 计算出中间值，这种算法保证不会溢出
        int mid = low + ((high - low) >> 1);

        // 左边排序
        mergeSort(arr, low, mid);
        // 右边排序
        mergeSort(arr, mid + 1, high);

        // 归并两个有序的子序列, merge不是递归操作，假设条件是左右两个数组已经排好序了
        merge(arr, low, mid, high);

        print(arr);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        // temp[]是临时数组，包左不包右，所以要额外 + 1。
        int[] temp = new int[high - low + 1];

        // 分配三个索引，分别表示前半段数组，后半段数组，以及temp数组
        // 左侧指针从low开始
        int left = low;

        // 右侧指针从mid+1开始
        int right = mid + 1;

        // 此索引用于temp[]
        int index = 0;

        // 当两个子序列还有元素时，从小到大放入temp[]中
        while (left <= mid && right <= high) {
            // 采用 <= 稳定性的考虑,是一个稳定算法
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        // 看前半段数据 & 后半段数组，看那个还剩下一小半
        // 要么左边没有元素
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        // 要么右边没有元素
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        // 重新赋值给arr对应的区间
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }

    public static void print(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};

        System.out.print("排序前:  ");
        print(arr);

        mergeSort(arr);

        System.out.print("排序后:  ");
        print(arr);
    }
}
