package com.zhl.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * 队列（链表实现）
 */
public class Queue<Item> implements Iterable<Item> {
    // 指向最早添加的结点的链接
    private Node first;
    // 指向最近添加的结点的链接
    private Node last;
    // 队列中的元素数量
    private int N;

    private class Node {
        private Item item;
        private Node next;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public Integer size() {
        return N;
    }

    public void enqueue(Item item) {
        // 向表尾添加元素
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        // 从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("a");
        q.enqueue("b");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
