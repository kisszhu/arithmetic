package com.zhl.leetcode.dfs;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/08 10:13
 */
public class LeetCode_13 {

    boolean[][] visit;

    public int movingCount(int m, int n, int k) {
        /*
          这道题，是典型的矩阵搜索问题，此类问题通常可使用 深度优先搜索（DFS）或广度优先搜索(BFS)解决

          深度优先搜索：可以理解为暴力法模拟机器人在矩阵中的所有路径。DFS通过递归，先朝一个方法搜到底，在回溯至上个节点，沿另一个方法搜索，以此类推
          剪枝：在搜索中，遇到数位和超出目标值、此元素已访问，则应立即返回，称之为可行性剪枝

          算法分析：
            递归参数：当前元素在矩阵中的行列索引 i和j，两者的数位和si,sj
            终止条件：1、当行列索引越界，2、数位和超出目标值，3、当前元素已访问过时，返回00代表，代表不计入可达解
            递推工作：
                标记当前单元格：将索引（i，j）存入set visited中，代表此单元格已被访问过
                搜索下一单元格：计算当前元素的下、右两个方向元素的数位和，并开启下层递归
            回溯返回值：返回1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数
         */

        // 第一步：先明确递归参数
        // 第二步：明确递归终止条件

        visit = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int i, int j, int m, int n, int k) {
        // 第一步：先明确递归参数
        int a = sums(i);
        int b = sums(j);
        // 第二步：明确递归终止条件
        boolean flag = i < 0 || i >= m || j < 0 || j >= n || k < a + b || visit[i][j];
        if (flag) {
            return 0;
        }
        // 第三步：递推工作
        visit[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k) + dfs(i, j + 1, m, n, k);
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
