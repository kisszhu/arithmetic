package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/16 09:12
 */
public class LeetCode_56 {

//    给出一个区间的集合，请合并所有重叠的区间。
//    示例 1:
//    输入: [[1,3],[2,6],[8,10],[15,18]]
//    输出: [[1,6],[8,10],[15,18]]
//    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][0];
        }
        int n = intervals.length;

        // 找规律，"结束<开始"，则进行合并

        // 合并次数
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null;
                    cnt++;
                    break;
                }
            }
        }
        int[][] res = new int[n - cnt][2];
        int ri = 0;
        for (int[] pair : intervals) {
            if (pair != null) {
                res[ri++] = pair;
            }
        }
        return res;
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

