package com.zhl.leetcode.divide.conquer;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/01/22 12:05
 */
public class LeetCode_509 {
    public int fib(int N) {
        int[][] array = {{1, 1}, {1, 0}};
        int[][] b = matrixPower(array, N);
        return b[0][1];
    }

    /**
     * 两个矩阵相乘的代码
     *
     * @param x
     * @param y
     * @return
     */
    public static int[][] twoMatrixPlus(int x[][], int y[][]) {
        // (n*m) * (m*n) = n*n
        int ans[][] = new int[x.length][y[0].length];

        // 初始化数组
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = 0;
            }
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int p = 0; p < x[0].length; p++) {
                    ans[i][j] += x[i][p] * y[p][j];
                }
            }
        }
        return ans;
    }

    public static int[][] matrixPower(int a[][], int n) {
        // 初始化为单位矩阵
        int ans[][] = new int[a.length][a[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                if (i == j) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = 0;
                }
            }
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = twoMatrixPlus(ans, a);
            }
            a = twoMatrixPlus(a, a);
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_509 test = new LeetCode_509();
        int result = test.fib(2);
//        System.out.println(result);
    }
}



