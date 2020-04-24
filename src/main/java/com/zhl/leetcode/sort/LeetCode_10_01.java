package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/31 11:22
 */
public class LeetCode_10_01 {

    public void merge(int[] A, int m, int[] B, int n) {

        int index1, index2;
        for (index1 = 0, index2 = 0; index1 < A.length && index2 < n; ) {
            int num1 = A[index1];
            int num2 = B[index2];

            if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
            move(A, index1, num2);
        }

        for (int i : A) {
            System.out.println(i);
        }
    }

    private void move(int[] A, int index, int num) {
        int i = index;
        for (; i < A.length - 1; i++) {
            A[i + 1] = A[i];
        }
        A[index] = num;
    }

    public static void main(String[] args) {
        LeetCode_10_01 test = new LeetCode_10_01();
        test.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}

