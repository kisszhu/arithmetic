package com.zhl.leetcode.array;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/25 09:00
 */
public class LeetCode_922 {

    /**
     * 第一种解法：通过分治的思路，得到ou ji，表示奇数&偶数
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int ou = 0;
        int ji = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[ou] = A[i];
                ou += 2;
            } else {
                result[ji] = A[i];
                ji += 2;
            }
        }
        return result;
    }

    /**
     * 第二种解法，提高一点难度,不开辟额外的空间
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        // a[0] a[2] a[4] a[6] a[8] a[10]
        int ou = 0;
        for (int i = 0; i < A.length; i++) {
            // 偶数
            if (A[i] % 2 == 0) {

                int temp = A[ou];
                A[ou] = A[i];
                ou += 2;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        LeetCode_922 test = new LeetCode_922();
        int[] result = test.sortArrayByParityII(new int[]{4, 2, 5, 7});
        System.out.println(result);
    }
}
