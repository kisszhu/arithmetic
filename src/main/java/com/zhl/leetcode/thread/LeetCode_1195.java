package com.zhl.leetcode.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/14 21:35
 */
public class LeetCode_1195 {

    private int n;

    public LeetCode_1195(int n) {
        this.n = n;
    }

    /**
     * 一般控制屏障有
     * CountDownLatch，一般比较好，不需要做自旋
     * 标识，比如volatile，Atomic*等，一般需要借助自旋
     * 锁，如synchronized lock等，一般也需要自旋
     * <p>
     * 我目前的想法是，还是需要控制自旋，否则性能还是上不去
     */

    /**
     * 原子变量
     */
    private AtomicInteger integer = new AtomicInteger(1);

    /**
     * 状态锁
     */
    private Object lock = new Object();

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 3 == 0 && num % 15 != 0) {
                    printFizz.run();
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 5 == 0 && num % 15 != 0) {
                    printBuzz.run();
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 15 == 0) {
                    printFizzBuzz.run();
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 3 != 0 && num % 5 != 0) {
                    printNumber.accept(num);
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    public void fizz() {
        System.out.println("fizz");
    }

    public void buzz() {
        System.out.println("buzz");
    }          // only output "buzz"

    public void fizzbuzz() {
        System.out.println("fizzbuzz");
    }  // only output "fizzbuzz"

    public void number() {
        // System.out.println(num.get());
    }      // only output the numbers

    public static void main(String[] args) {
        LeetCode_1195 test = new LeetCode_1195(15);
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(4);

        Runnable fizz = new Runnable() {
            @Override
            public void run() {
                test.fizz();
            }
        };

        Runnable buzz = new Runnable() {
            @Override
            public void run() {
                test.buzz();
            }
        };

        Runnable fizzBuss = new Runnable() {
            @Override
            public void run() {
                test.fizzbuzz();
            }
        };

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    test.fizz(fizz);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    test.buzz(buzz);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    test.fizzbuzz(fizzBuss);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    test.number(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
