package com.zhl.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * 下压栈（链表实现）
 */
public class Stack<Item> implements Iterable<Item> {
    // 栈顶（最近添加的元素）
    private Node first;
    // 元素数量
    private int N;

    private class Node {
        // 定义了结点的嵌套类
        Item item;
        Node next;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public Integer size() {
        return N;
    }

    public void push(Item item) {
        // 向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        // 从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("a");
        s.push("b");
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
