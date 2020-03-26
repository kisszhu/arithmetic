package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/26 09:20
 */
public class LeetCode_999 {

    /**
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），
     * 然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
     * <p>
     * 返回车能够在一次移动中捕获到的卒的数量。
     *
     * @param board
     * @return
     */

    public int numRookCaptures(char[][] board) {
        int length = board.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 先找到白色的车
                if (board[i][j] == 'R') {
                    // 向上移动
                    int temp_i = i;

                    // 棋盘的边缘
                    for (; temp_i > 0; temp_i--) {
                        // 选择停止 ignore
                        // 遇到白色的象
                        if (board[temp_i][j] == 'B') {
                            break;
                        }
                        if (board[temp_i][j] == 'p') {
                            num++;
                            break;
                        }
                    }
                    // 向下移动
                    temp_i = i;
                    // 棋盘的边缘
                    for (; temp_i < length; temp_i++) {
                        // 选择停止 ignore
                        // 遇到白色的象
                        if (board[temp_i][j] == 'B') {
                            break;
                        }
                        if (board[temp_i][j] == 'p') {
                            num++;
                            break;
                        }
                    }

                    // 向左移动
                    int temp_j = j;
                    // 棋盘的边缘
                    for (; temp_j > 0; temp_j--) {
                        // 选择停止 ignore
                        // 遇到白色的象
                        if (board[i][temp_j] == 'B') {
                            break;
                        }
                        if (board[i][temp_j] == 'p') {
                            num++;
                            break;
                        }
                    }

                    // 向右移动
                    temp_j = j;
                    // 棋盘的边缘
                    for (; temp_j < length; temp_j++) {
                        // 选择停止 ignore
                        // 遇到白色的象
                        if (board[i][temp_j] == 'B') {
                            break;
                        }
                        if (board[i][temp_j] == 'p') {
                            num++;
                            break;
                        }
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_999 test = new LeetCode_999();
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(test.numRookCaptures(board));
    }
}
