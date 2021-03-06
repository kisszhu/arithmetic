package com.zhl.leetcode.bfs;

import java.util.*;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/29 10:08
 */
public class LeetCode_1162 {

    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // offer & add 容量问题
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        // 从陆地开始，进行遍历
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[x][y] != 0) {
                    continue;
                }
                hasOcean = true;
                // 设置成已访问，防止多次入列，曼哈顿距离
                grid[newX][newY] = grid[x][y] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }

        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后遍历到海洋的距离
        return grid[point[0]][point[1]] - 1;
    }

    class Point {
        int x;
        int y;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        LeetCode_1162 test = new LeetCode_1162();
        int[][] grid = new int[5][5];

        // [[0,0,1,1,1],[0,1,1,0,0],[0,0,1,1,0],[1,0,0,0,0],[1,1,0,0,1]]
        grid[0][0] = 0;
        grid[0][1] = 0;
        grid[0][2] = 1;
        grid[0][3] = 1;
        grid[0][4] = 1;


        grid[1][0] = 0;
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[1][3] = 0;
        grid[1][4] = 0;

        grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 1;
        grid[2][3] = 1;
        grid[2][4] = 0;

        grid[3][0] = 1;
        grid[3][1] = 0;
        grid[3][2] = 0;
        grid[3][3] = 0;
        grid[3][4] = 0;

        grid[4][0] = 1;
        grid[4][1] = 1;
        grid[4][2] = 0;
        grid[4][3] = 0;
        grid[4][4] = 1;


        int res = test.maxDistance(grid);
        System.out.println(res);
    }
}
