package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/16 09:12
 */
public class LeetCode_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][0];
        }
        int length = intervals.length;

        /*
         * 矩阵的每一行，想象成每一个元素，这样的话，就转变为数组的排序了
         */
        int merge = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null;
                    merge++;
                    break;
                }
            }
        }
        int[][] result = new int[length - merge][2];
        int index = 0;
        for (int[] pair : intervals) {
            if (pair != null) {
                result[index++] = pair;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_56 test = new LeetCode_56();
        int[][] intervals = new int[4][2];
        intervals[0][0] = 1;
        intervals[0][1] = 3;

        intervals[1][0] = 2;
        intervals[1][1] = 6;

        intervals[2][0] = 8;
        intervals[2][1] = 10;

        intervals[3][0] = 15;
        intervals[3][1] = 18;

        int[][] res = test.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i][0] + " " + res[i][1]);
            System.out.println("-----");
        }
    }
}

