package com.zhl.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * 背包（链表实现）
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        // 和Stack的push()方法完全相同
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
        }
    }
}
