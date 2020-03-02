package com.zhl.leetcode.compound;

/**
 * @program arithmetic
 * @description:
 * @author: zhu_alan
 * @create: 2020/02/14 09:28
 */
public class CompoundInterest {
    public static void main(String[] args) {
        // 本金
        double money = 100000;
        // 存款年数
        int years = 10;
        // 存款金额
        double sum = 0;
        // 利率
        double r = 0.06;
        for (int i = 1; i <= years; i++) {
            sum = (1 + r) * i * money;
            System.out.println("存入第" + i + "年后的存款总额为：" + sum);
        }
    }
}
