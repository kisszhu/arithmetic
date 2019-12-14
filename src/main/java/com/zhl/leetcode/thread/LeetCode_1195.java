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

    private AtomicInteger num = new AtomicInteger(1);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (num.get() <= n) {
            int value = num.get();
            if (value % 3 == 0 && value % 15 != 0 && value <= n) {
                printFizz.run();
                num.getAndIncrement();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (num.get() <= n) {
            int value = num.get();
            if (value % 5 == 0 && value % 15 != 0 && value <= n) {
                printBuzz.run();
                num.getAndIncrement();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (num.get() <= n) {
            int value = num.get();
            if (value % 15 == 0 && value <= n) {
                printFizzBuzz.run();
                num.getAndIncrement();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (num.get() <= n) {
            int value = num.get();
            if (value % 3 != 0 && value % 5 != 0 && value <= n) {
                printNumber.accept(value);
                num.getAndIncrement();
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

    public static void main(String[] arggs) throws Exception {
        LeetCode_1195 test = new LeetCode_1195(15);

        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(4);


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

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    test.fizz(fizz);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    test.buzz(buzz);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    test.fizzbuzz(fizzBuss);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
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
