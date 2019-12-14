package com.zhl.leetcode.thread;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/27 09:06
 */
public class LeetCode_1114_2 {

    public LeetCode_1114_2() {

    }

    /**
     * 起到标识的作用
     */
    private boolean second = false;
    private boolean third = false;

    /**
     * 屏障
     */
    private Object lock = new Object();

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!second) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third = true;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!third) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
