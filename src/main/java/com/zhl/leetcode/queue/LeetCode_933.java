package com.zhl.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/10 18:07
 */
public class LeetCode_933 {

    public LeetCode_933() {

    }

    /**
     * 我们只会考虑最近 3000 毫秒到现在的 ping 数，因此我们可以使用队列存储这些 ping 的记录。
     * 当收到一个时间 t 的 ping 时，我们将它加入队列，然后将所有在时间 t-3000之前的ping 移出队列
     */
    Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        // Your RecentCounter object will be instantiated and called as such:
        LeetCode_933 obj = new LeetCode_933();
        int param_1 = obj.ping(3);
    }
}