package com.zhl.leetcode.thread;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/15 08:33
 */
public class BasicIntroduce {

    /**
     * 1、wait()、notify()、notifyAll()方法是Object的本地final方法，无法被重写
     *
     * 2、wait()使当前线程阻塞，前提是必须先获得锁，一般配合synchronized关键字使用，即，一般在synchronized同步代码块里使用wait()、notify()、notifyAll()
     *
     * 3、由于wait()、notify、notifyAll()在synchronized代码块执行，说明当前线程一定是获取了锁的。当线程执行wait()方法时，会释放当前的锁，然后让出CPU，
     * 进入等待状态，只有当notify、notifyAll()被执行时候，才会唤醒一个或多个正处于等待状态的线程，然后继续往下执行，直到执行完synchronized代码块的代码
     * 或是中途遇到wait()，再次释放锁。也就是说notify/notifyAll()的执行只是唤醒沉睡的线程，而不会立即释放锁，锁的释放要看代码块的具体执行情况。所以在编程中
     * 尽量在使用了notify/notifyAll()后立即退出临界区，以唤醒其他线程让其获得锁
     *
     * 4、notify和wait的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的
     *
     * 5、在多线程中要测试某个条件的变化，使用if 还是while
     * 一般情况下，都是要使用while语句进行等待,直到满足条件才继续往下执行
     */

    /**
     * IllegalMonitorStateException 异常解析
     * 1、当前线程不含有当前对象的锁资源时，调用wait()
     * 2、当前线程不含有当前对象的锁资源时，调用notify()
     * 3、当前线程不含有当前对象的锁资源时，调用notifyAll()
     */

    class ThreadTest1 extends Thread {
        String a;

        public ThreadTest1(String a) {
            this.a = a;
        }

///
//        @Override
//        public void run() {
//            try {
//                a.wait();
//            } catch (InterruptedException ex) {
//
//            }
//        }

        @Override
        public void run() {
            try {
                synchronized (a) {
                    a.wait();
                }
            } catch (InterruptedException ex) {

            }
        }
    }

    public static void main(String[] args) {
        String a = "11";
        BasicIntroduce base = new BasicIntroduce();
        ThreadTest1 test1 = base.new ThreadTest1(a);
        test1.start();

        // 以上程序会出现如下错误:
        // Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
        // at java.lang.Object.wait(Native Method)
        // at java.lang.Object.wait(Object.java:502)
        // at com.zhl.leetcode.thread.BasicIntroduce$ThreadTest1.run(BasicIntroduce.java:44)

        // 修改代码，在将a.wait放在synchronized同步代码块中
    }
}
