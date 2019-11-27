package com.zhl.leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/27 09:06
 */
public class LeetCode_1114 {

    public LeetCode_1114() {

    }

    /**
     * Java自带的，控制多线程执行顺序的屏障，似乎flink的water-mark水位 就是通过它实现的
     */
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
