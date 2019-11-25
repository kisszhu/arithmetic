package com.zhl.leetcode.simple;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/13 08:27
 */
public class LeetCode_LCP1 {

    /**
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/guess-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param guess
     * @param answer
     * @return
     */
    public int game(int[] guess, int[] answer) {
        int num = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_LCP1 leetCode = new LeetCode_LCP1();
        int num = leetCode.game(new int[]{2, 2, 3}, new int[]{3, 2, 1});
        System.out.println(num);
    }
}
