package com.zhl.algorithms.chapter1_4;

/**
 * 统计一个文件中所有和为0的三整数元祖的数量.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 0};
        int cnt = count(a);
        System.out.println(cnt);
    }

    public static int count(int[] a) {
        // 统计和为0的元组的数量
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
