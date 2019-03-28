package com.zhl.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * 给Stack添加一个方法peek()，返回栈中最近添加的元素（而不弹出它）
 */
public class Exercise_1_3_7<Item> implements Iterable<Item> {

    public Node first;
    public int n;

    class Node {

        Item item;
        Node next;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public Integer size() {
        return n;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (first != null) {
            return first.item;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Exercise_1_3_7<String> s = new Exercise_1_3_7<String>();
        s.push("a");
        s.push("b");
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
