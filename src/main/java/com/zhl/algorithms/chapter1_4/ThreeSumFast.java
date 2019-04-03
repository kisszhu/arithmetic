package com.zhl.algorithms.chapter1_4;

import java.util.Arrays;

public class ThreeSumFast {
    public static int count(int[] a) {
        // 计算和为0的三元组的数目
        Arrays.sort(a);
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
//                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
//                    cnt++;
//                }
            }
        }
        return cnt;
    }
}
