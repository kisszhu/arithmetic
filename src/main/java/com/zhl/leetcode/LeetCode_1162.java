package com.zhl.leetcode;

import java.util.*;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/29 10:08
 */
public class LeetCode_1162 {

    public int maxDistance(int[][] grid) {
        int N = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 如果我们的地图上只有陆地或者海洋，请返回 -1。
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }

        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            // 这里一口气取出 n 个结点，以实现层序遍历
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                // 遍历上方单元格
                if (r - 1 >= 0 && grid[r - 1][c] == 0) {
                    grid[r - 1][c] = 2;
                    queue.add(new int[]{r - 1, c});
                }
                // 遍历下方单元格
                if (r + 1 < N && grid[r + 1][c] == 0) {
                    grid[r + 1][c] = 2;
                    queue.add(new int[]{r + 1, c});
                }
                // 遍历左边单元格
                if (c - 1 >= 0 && grid[r][c - 1] == 0) {
                    grid[r][c - 1] = 2;
                    queue.add(new int[]{r, c - 1});
                }
                // 遍历右边单元格
                if (c + 1 < N && grid[r][c + 1] == 0) {
                    grid[r][c + 1] = 2;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }
        return distance;
    }

//    public int maxDistance(int[][] grid) {
//        // 拿到这道题的第一个想法，是得到海洋的位置，在得到陆地的位置，然后比较陆地与海洋的位置
//        int length = grid.length;
//
//        List<Point> seaList = new ArrayList<>();
//        List<Point> landList = new ArrayList<>();
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                int area = grid[i][j];
//                if (area == 0) {
//                    // 海洋
//                    Point point = new Point(i, j);
//                    seaList.add(point);
//                } else {
//                    // 陆地
//                    Point point = new Point(i, j);
//                    landList.add(point);
//                }
//            }
//        }
//
//        // 只有陆地 或者 只有海洋
//        if (seaList.size() == 0 || landList.size() == 0) {
//            return -1;
//        }
//
//        // 通过海洋去遍历陆地
//        for (Point sea : seaList) {
//            for (Point land : landList) {
//                int distance = Math.abs(sea.x - land.x) + Math.abs(sea.y - land.y);
//                sea.minDistance = (distance > sea.minDistance) ? sea.minDistance : distance;
//            }
//        }
//
//        Collections.sort(seaList, (x, y) -> Integer.compare(y.minDistance, x.minDistance));
//        return seaList.get(0).minDistance;
//    }
//
//    class Point {
//        int x;
//        int y;
//        int minDistance = Integer.MAX_VALUE;
//        int maxDistance = Integer.MIN_VALUE;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }


    // land sea

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
