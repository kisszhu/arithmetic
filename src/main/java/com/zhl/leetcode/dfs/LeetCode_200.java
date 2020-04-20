package com.zhl.leetcode.dfs;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/20 09:21
 */
public class LeetCode_200 {

    /**
     * 深度优先遍历
     */
    //        x-1,y
    // x,y-1  x,y     x,y+1
    //        x+1,y
    /**
     * 方向数组，它表示了相对于当前位置的4个方向的横、纵坐标的偏移量，这是一个常见的技巧
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

    public int numIsLands(char[][] grid) {
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
                // 如果是岛屿中的一个点，并且没有被访问过，就进行深度优先遍历
                if (!visted[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    /**
     * 从坐标为(i,j)的点开始进行深度优先遍历
     */
    private void dfs(int i, int j) {
        visted[i][j] = true;
        // 得到四个方向的坐标
        for (int k = 0; k < 4; k++) {
            int newX = i + direstions[k][0];
            int newY = j + direstions[k][1];
            // 如果不越界，没有被访问过、并且还要是陆地
            boolean inArea = newX >= 0 && newX < rows && newY >= 0 && newY < cols;
            if (inArea && grid[newX][newY] == '1' && !visted[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_200 test = new LeetCode_200();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = test.numIsLands(grid1);
        System.out.println(numIslands1);
    }
}