package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/25 09:28
 */
public class LeetCode_892 {

    /**
     * 诶嘛，读了半个多小时，猜明白题意
     * [[1,2],[3,4]] 的意思是坐标(0,0)放一个正方体，坐标(0,1)放两个正方体，坐标(1,0)放三个正方体，坐标(1,1)放四个正方体
     * <p>
     * 首先，一个柱体一个柱体的看，每个柱体是由：2个底面（上表面/下表面）+所有的正方体都贡献了4个测表面积
     * 然后，把柱体贴合在一起之后，我们需要把贴合的表面积给剪掉，两个柱体高的最小值*2
     *
     * @param grid
     * @return
     */

    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int level = grid[i][j];
                // 一个柱体中：所有正方体都贡献了4个侧表面积 + 两个底面
                area += (level << 2) + 2;
                // 减掉 i与i-1相贴的两份表面积
                area -= i > 0 ? Math.min(level, grid[i - 1][j]) << 1 : 0;
                area -= j > 0 ? Math.min(level, grid[i][j - 1]) << 1 : 0;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        LeetCode_892 test = new LeetCode_892();
        int[][] array = new int[2][2];
        array[0][0] = 1;
        array[0][1] = 2;
        array[1][0] = 3;
        array[1][1] = 4;
        test.surfaceArea(array);
    }
}