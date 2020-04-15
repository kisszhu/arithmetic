package com.zhl.leetcode.bfs;


import java.util.*;


/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/15 09:07
 */
public class LeetCode_542 {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] res = new int[n][m];
        // 标记当前位置是否被访问过
        boolean[][] visited = new boolean[n][m];

        // 第一步：设置队列，添加初始结点
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 因为要统计到1到0的距离，最后在1上算出累计值，所以，我们需要从0开始，不断的累加到1
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 第二步：定义方向向量
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        // 第三步：判断队列是否为空
        while (!queue.isEmpty()) {

            // 第四步：弹出队列元素
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) {
                    continue;
                }
                // 逻辑处理
                res[newX][newY] = res[x][y] + 1;
                visited[newX][newY] = true;
                // 第五步：当前队列元素的下级元素，入队，重复步骤三四
                queue.offer(new int[]{newX, newY});
            }
        }
        return res;
    }

////
////    // 从陆地开始，进行遍历
////    boolean hasOcean = false;
////    int[] point = null;
////        while (!queue.isEmpty()) {
////        point = queue.poll();
////        int x = point[0];
////        int y = point[1];
////        for (int i = 0; i < 4; i++) {
////            int newX = x + dx[i];
////            int newY = y + dy[i];
////            if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
////                continue;
////            }
////            hasOcean = true;
////            // 设置成已访问，防止多次入列
////            grid[newX][newY] = grid[x][y] + 1;
////            queue.offer(new int[]{newX, newY});
////        }
////    }
////
////        if (point == null || !hasOcean) {
////        return -1;
////    }
////
////    // 返回最后遍历到海洋的距离
////
////        return grid[point[0]][point[1]] - 1;

    public static void main(String[] args) {
        LeetCode_542 test = new LeetCode_542();
        int[][] matrix = new int[3][3];
        matrix[0][0] = 0;
        matrix[0][1] = 0;
        matrix[0][2] = 0;

        matrix[1][0] = 0;
        matrix[1][1] = 1;
        matrix[1][2] = 0;

        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;

        int[][] res = test.updateMatrix(matrix);
        int length = res.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println("--------");
        }
    }
}
