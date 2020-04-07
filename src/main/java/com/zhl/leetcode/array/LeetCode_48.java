package com.zhl.leetcode.array;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/07 09:16
 */
public class LeetCode_48 {

    /**
     * 第一种解法，需要使用辅助数组
     */
    public void rotate1(int[][] matrix) {
        // 在矩阵90度翻转的时候，对于矩阵中第i行的第j个元素，在旋转后，它出现在倒数i列的第j个位置
        // 我们将其翻译成代码，由于矩阵中的行列从0开始计数，因此对于矩阵中的元素matrix[row][col],在旋转后，它的新位置为matrix[col][n-row-1]

        int n = matrix.length;
        int[][] dummy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dummy[j][n - i - 1] = matrix[i][j];
            }
        }
    }

    public void rotate(int[][] matrix) {
        // 对于水平翻转而言，我们只需要枚举矩阵上半部分的元素，和下半部分的元素进行交换，即
        // matrix[row][col] => 水平轴翻转 => matrix[n-row-1][col]

        // 对于主对角线翻转而言，我们只需要枚举对角线左侧的元素和右侧的元素进行交换,即
        // matrix[row][col] => 主对角线翻转 => matrix[col][row]

        // 将它们联立即可得到：
        // matrix[row][col] => 水平翻转 => matrix[n-row-1][col]
        //              => 主对角线翻转 => matrix[col][n-row-1]

        // 与第一种解法种的等式成立


        int n = matrix.length;
        // 先以对角线为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 在对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        LeetCode_48 test = new LeetCode_48();
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;


        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        test.rotate(matrix);
    }
}
