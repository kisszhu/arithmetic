package com.zhl.learn.algorithm.sort;

import java.util.Arrays;

/**
 * Created by zhuhailong-dc on 2018/6/11.
 * 希尔排序
 */
public class ShellSort {

    /**
     * 希尔排序是希尔（Donald Sheel）于1959年提出的一种排序算法。希尔排序也是一种插入排序，
     * 它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法时冲破O(n2)
     * 的第一批算法之一。
     */
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        sort1(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，
     * 每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     *
     * 简单插入排序很循规蹈矩，不管数组分布式怎么样的，依然一步一步的对元素进行比较，移动，插入。
     *
     * 例如[5,4,3,2,1,0]这种倒序序列，数组末端的0要回到首位置很是费劲，比较和移动元素均需n-1次。
     *
     * 而希尔排序在在数组中采用跳跃式分组的策略，通过某个增量将数组元素划分为若干组，然后分组进行
     * 插入排序，随后逐步缩小增量，继续按组进行插入排序操作，直至增量为1.
     *
     * 希尔排序通过这种策略使得整个数组在初始阶段达到从宏观上看基本有序，小的基本在前，大的基本在后。
     * 然后缩小增量，到增量为1时，其实多数情况下只需微调即可，不会涉及过多的数据移动。
     *
     * 我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，
     * 这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列
     *
     * 希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，
     * 称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。
     */


    /**
     * 希尔排序，针对有序序列在插入时采用交换法
     */
    public static void sort(int[] arr) {
        // 增量gap,并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素,逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    // 插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序，针对有序序列在插入时采用移动法
     */
    public static void sort1(int[] arr) {
        // 增量gap,并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素,逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
     * 介绍了希尔排序的基本思想及其代码实现，希尔排序中对于增量序列的选择十分重要，
     * 直接影响到希尔排序的性能。
     *
     * 我们上面选择的增量序列{n/2,(n/2)/2...1}(希尔增量)，其最坏时间复杂度依然为O(n2)，
     * 一些经过优化的增量序列如Hibbard经过复杂证明可使得最坏时间复杂度为O(n3/2)。
     */
}