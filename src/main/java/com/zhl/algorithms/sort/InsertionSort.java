package com.zhl.algorithms.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/25 16:28
 */
public class InsertionSort {

    public int[] insertionSort(int[] num) {
        int i, j, temp;
        // 从第二个元素开始
        for (i = 1; i < num.length; i++) {
            temp = num[i];
            // 比较当前元素之前的所有元素
            for (j = i - 1; j >= 0; j--) {

                if (temp > num[j]) {
                    break;
                } else {
                    // 元素右移动
                    num[j + 1] = num[j];
                }
            }
            num[j + 1] = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        InsertionSort test = new InsertionSort();
        int[] result = test.insertionSort(new int[]{9, 8, 4, 6, 0, -1});
        System.out.println(result);
    }
}
