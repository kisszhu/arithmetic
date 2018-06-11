package com.qihoo.zhuhailong.arithmetic.sort;

/**
 * Created by zhuhailong-dc on 2018/6/11.
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(new int[]{2, 5, 7, 9, 0, 1});
    }


    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            /**
             * 设定一个标记，若为true，则表示此处循环没有进行交换
             * 也就是待排序已经有序，排序已经完成
             */
            boolean flag = true;
            // 比较次数是递减的，因为只会向后比较，不会向前比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }


    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
     * 根据上面这种冒泡实现，若原数组本身就是有序（这是最好的情况），仅需n-1次比较就可完成；
     * 若是倒叙，比较次数为n-1+n-2+....+1=n(n-1)/2，交换次数和比较次数等值。所以，其
     * 时间复杂度依然为O(n2)。综合来看，冒泡排序性能还是稍差与上面那种选择排序的。
     */

}
