package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/28 10:19
 */
public class LeetCode_1051 {

    /**
     * 比较高度的问题，其实就是排序后，看看存在哪些不一致
     * 这里我选择使用了插入排序，可能性能会稍微慢一点，只是想在复习下插入排序
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] oldArray = new int[heights.length];
        System.arraycopy(heights, 0, oldArray, 0, heights.length);

        int i, j, temp;
        for (i = 1; i < heights.length; i++) {
            temp = heights[i];

            for (j = i - 1; j >= 0; j--) {
                if (temp > heights[j]) {
                    break;
                } else {
                    heights[j + 1] = heights[j];
                }
            }
            heights[j + 1] = temp;
        }
        System.out.println(heights);

        int ans = 0;
        for (int k = 0; k < heights.length; k++) {
            if (heights[k] != oldArray[k]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_1051 test = new LeetCode_1051();
        int ans = test.heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        System.out.println(ans);
    }
}
