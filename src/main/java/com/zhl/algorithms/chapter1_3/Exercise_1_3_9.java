package com.zhl.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式
 * 例如,给定输入:
 * 1 + 2 ) * 3 -4 ) * 5 - 6 ) ) )
 * ( ( 1 + 2 ) * ( ( 3 -4 ) * 5 - 6 ) ) )
 */
public class Exercise_1_3_9<Item> implements Iterable<Item> {

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
        Exercise_1_3_9<String> s = new Exercise_1_3_9<String>();
        s.push("a");
        s.push("b");
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
