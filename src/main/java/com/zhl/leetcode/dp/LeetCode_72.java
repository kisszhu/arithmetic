package com.zhl.leetcode.dp;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/06 10:10
 */
public class LeetCode_72 {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

//        确实是楼上说的 思考过程形成 = 做过类似的题😂。。。
//        这种两个字符串的，以两个字符串分别作为二维数组的横轴和纵轴，从(0, 0)开始到(len1,len2)模拟一遍二维数组的递推，会很有助于理解～

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LeetCode_72 test = new LeetCode_72();
        System.out.println(test.minDistance("", ""));
    }
}
