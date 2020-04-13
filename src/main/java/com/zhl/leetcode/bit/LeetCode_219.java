package com.zhl.leetcode.bit;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/02 08:59
 */
public class LeetCode_219 {

    /**
     * 因为这道题目的输入是int[][]，而int是可以存储更多的比特位
     * 原有的最低位存储的是当前状态，那倒数第二位存储下一个状态就行了
     */

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] directionX = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] directionY = {1, -1, 0, 0, 1, -1, 1, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int live = 0;
                // 遍历上下左右 左上 右上 左下 右下
                for (int k = 0; k < 8; k++) {
                    int newX = i + directionX[k];
                    int newY = j + directionY[k];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                        continue;
                    }
                    if (board[newX][newY] % 10 == 1) {
                        live++;
                    }
                }

                if (board[i][j] == 1) {
                    // 101 111 110 百位的1是标识，10位的是0/1是下一状态，个位的0/1是当前状态
                    // 当前是活细胞
                    if (live < 2 || live > 3) {
                        // 下一个状态是死细胞
                        // 1 -> 0
                        board[i][j] = 101;
                    }
                    if (live >= 2 && live <= 3) {
                        // 下一个状态是活细胞
                        // 1 -> 1
                        board[i][j] = 111;
                    }
                } else {
                    // 当前是死细胞
                    if (live == 3) {
                        // 下一个状态是活细胞
                        // 0 -> 1
                        board[i][j] = 110;
                    }
                }
            }
        }
        // 个位是当前状态，十位是下一状态，这里取10位
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int value = board[i][j];
                board[i][j] = (value % 100) / 10;
            }
        }
    }

    public static void main(String[] args) {
        // 0 1 0
        // 0 0 1
        // 1 1 1
        // 0 0 0
        LeetCode_219 test = new LeetCode_219();
        int[][] board = new int[4][3];
        board[0][0] = 0;
        board[0][1] = 1;
        board[0][2] = 0;

        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 1;

        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;

        board[3][0] = 0;
        board[3][1] = 0;
        board[3][2] = 0;

        test.gameOfLife(board);
        System.out.println((110 % 100) / 10);
    }
}
