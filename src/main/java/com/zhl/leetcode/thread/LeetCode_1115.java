package com.zhl.leetcode.thread;


/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/14 08:52
 */
public class LeetCode_1115 {

    private int n;

    public LeetCode_1115(int n) {
        this.n = n;
    }

    private volatile boolean flag = false;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (flag) {
                Thread.yield();
            }
            printFoo.run();
            flag = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            while (!flag) {
                Thread.yield();
            }
            printBar.run();
            flag = false;
        }
    }
}
/**
 * 看到先输出foo，在输出bar，就可以知道，这个是一个线程屏障问题
 * 第一种方式是通过CountDownLatch设置屏障，这个是Java自带的
 * 第二种方式是通过设置一个Object类型的成员变量，辅以synchronized，通过wait & notifyAll进行控制
 * 第三种方式是通过volatile这个特性，这个特性可以保证可见性
 */

//通过CountDownLatch & Object synchronized
//第一种方式是通过CountDownLatch设置屏障，这个是Java自带的。
//        第二种方式是通过Object这个成员变量辅以synchronzied，通过wait & notifyAll.
//        第三种方法是通过volatile这个特性,这个特性可以保证可见性，故全局唯一
