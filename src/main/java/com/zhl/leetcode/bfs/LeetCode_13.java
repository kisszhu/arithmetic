package com.zhl.leetcode.bfs;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/08 08:53
 */
public class LeetCode_13 {

    public int movingCount(int m, int n, int k) {

        /*
         * BFS/DFS：两者目标都是遍历整个矩阵，不同点在于搜索顺序不同，DFS是朝一个方向走到底，在回溯，以此类推；
         * BFS则是按照"平推"的方式向前搜索
         *
         * BFS实现，通常利用队列实现广度优先遍历
         *
         * 算法解析：
         *      初始化：将机器人初始点(0,0) 假如队列queue
         *      迭代终止条件：queue为空，代表已遍历完所有可达解
         *      迭代工作：
         *          单元格出队：将队首单元格的索引、数位和弹出，作为当前搜索单元格
         *          判断是否跳过：若1、行列索引越界 或 2、数位和超出目标值，3、当前元素已访问过
         *          标记当前单元格：将单元格索引（i，j）存入set visited中，表示已被访问过
         *          单元格入队：将当前单元格的下方、右方单元格的索引、数位假如queue
         *      返回值：set visited的长度，即可达解的数量
         */

        // 初始化工作，初始化机器人的起步节点
        int[] init = new int[]{0, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(init);
        int res = 0;
        // 迭代终止条件，判断queue是否为空
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            int sum = cell[2];
            if (i < 0 || i >= m || j < 0 || j >= n || k < sum || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;
            int[] downCell = new int[]{i + 1, j, sums(i + 1) + sums(j)};
            int[] rightCell = new int[]{i, j + 1, sums(i) + sums(j + 1)};

            queue.offer(downCell);
            queue.offer(rightCell);
        }
        return res;
    }

    private int sums(int num) {
        int sums = 0;
        while (num != 0) {
            sums += num % 10;
            num = num / 10;
        }
        return sums;
    }


    public static void main(String[] args) {
        LeetCode_13 test = new LeetCode_13();
        System.out.println(test.movingCount(3, 1, 0));
    }
}
