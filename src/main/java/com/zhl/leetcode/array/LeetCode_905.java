package com.zhl.leetcode.array;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/26 15:48
 */
public class LeetCode_905 {

    public int[] sortArrayByParity(int[] A) {
        // 采用首尾指针
        int[] B = new int[A.length];
        int begin = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                B[begin] = A[i];
                begin++;
            } else {
                B[end] = A[i];
                end--;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        LeetCode_905 test = new LeetCode_905();
        int[] res = test.sortArrayByParity(new int[]{3, 1, 2, 4});

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
