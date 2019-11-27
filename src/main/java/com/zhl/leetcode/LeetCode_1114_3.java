package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/27 09:06
 */
public class LeetCode_1114_3 {

    public LeetCode_1114_3() {

    }

    private volatile int flag = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (flag != 2) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag != 3) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
