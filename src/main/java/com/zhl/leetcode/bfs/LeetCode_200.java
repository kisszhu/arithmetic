package com.zhl.leetcode.bfs;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/20 09:22
 */
public class LeetCode_200 {

    /**
     * 广度优先遍历
     */

    private static final int[][] direstions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    /**
     * 标记数组，标记了grid的坐标对应的格子是否被访问过
     */
    private boolean[][] visted;

    /**
     * grid的行数
     */
    private int rows;

    /**
     * grid的列数
     */
    private int cols;

    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;

        visted = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过，就进行广度优先遍历
                if (!visted[i][j] && grid[i][j] == '1') {
                    count++;

                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    visted[i][j] = true;

                    while (!queue.isEmpty()) {
                        // 弹出队列元素
                        int[] point = queue.poll();
                        int x = point[0];
                        int y = point[1];
                        for (int k = 0; k < 4; k++) {
                            int newX = x + direstions[k][0];
                            int newY = y + direstions[k][1];
                            
                            // 如果不越界，没有被访问过、并且还要是陆地
                            boolean inArea = newX >= 0 && newX < rows && newY >= 0 && newY < cols;
                            if (inArea && grid[newX][newY] == '1' && !visted[newX][newY]) {
                                visted[newX][newY] = true;
                                queue.offer(new int[]{newX, newY});
                            }
                        }
                    }

                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode_200 test = new LeetCode_200();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = test.numIslands(grid1);
        System.out.println(numIslands1);
    }
}



