package com.zhl.leetcode.thread;

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
     * Java中，如果只是简单的控制多个线程之间执行顺序的屏障，那么首先推荐的就是使用CountDownLath
     */

    /**
     * 用于控制第二个线程
     */
    private CountDownLatch second = new CountDownLatch(1);

    /**
     * 用于控制第三个线程
     */
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

    public void one() {
        System.out.println("one");
    }

    public void two() {
        System.out.println("two");
    }

    public void three() {
        System.out.println("three");
    }


    public static void main(String[] args) throws Exception {
        LeetCode_1114 test = new LeetCode_1114();

        test.first(new Runnable() {
            @Override
            public void run() {
                test.one();
            }
        });

        test.second(new Runnable() {
            @Override
            public void run() {
                test.two();
            }
        });

        test.third(new Runnable() {
            @Override
            public void run() {
                test.three();
            }
        });
    }
}
