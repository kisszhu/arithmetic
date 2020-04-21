package com.zhl.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/09 09:14
 */
public class LeetCode_22 {

//    深度遍历：
//    第一步：明确递归参数 => 你说的"递归参数"，这种括号题都可以这么定义，你感受一下，熟了就好了
//    第二步：明确递归终止条件 => 你说的"递归终止条件"，递归参数都知道了，终止条件也知道了
//    第三步：明确递归函数中的内容 => 你说的"明确递归函数中的内容"，这个题是要么增加一个左括号，要么增加一个右括号，是一个二叉的选择
//                                这个很容易想，然后在加上if条件来剪枝
//    第四步：明确回溯返回值

    /**
     * 深度遍历：
     * 这个方法称为回溯也是可以的
     * 由于字符串的特殊性，产生一次拼接都生成新的对象，因此无需回溯
     */
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    /**
     * 感觉这种多个不同选择（但不是很多哈），都可以暴搜 + 剪枝呢。比如这个题每步要么增加一个左括号，要么增加一个右括号
     * 是一个二叉的选择，所以暴搜很容易写出来，就是
     * dfs(left -1, right, curStr +"(" )
     * dfs(left, right -1, curStr +")" )
     * 但是并不是每个分支都是符合要求的（正确的括号匹配），所以加上if来剪枝
     */
    private void dfs(int left, int right, String curStr) {
        // 当前左右括号都大于0个可以使用的时候，才产生分支
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 产生左分支的时候，只看当前是否还有左括号可以使用
        if (left > 0) {
            dfs(left - 1, right, curStr + "(");
        }

        // 产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支
        // 不满足条件的进行剪枝处理
        if (right > left) {
            dfs(left, right - 1, curStr + ")");
        }
    }

    public static void main(String[] args) {
        LeetCode_22 test = new LeetCode_22();
        List<String> list = test.generateParenthesis(3);
        for (String str : list) {
            System.out.println(str);
        }
    }
}














