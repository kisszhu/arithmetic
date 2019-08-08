package com.zhl.learn.dataStructure.hash.map.level1;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/08/08 07:25
 */
public class HashMap<K, V> implements Map<K, V> {

    private Node<K, V>[] nodes;

    /**
     * TODO 采用位运算
     */
    private int initSize = 1 << 4;

    public HashMap() {
        this.nodes = new Node[initSize];
    }

    public HashMap(int initSize) {
        this.initSize = initSize;
        this.nodes = new Node[initSize];
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }

        int index = this.indexOf(key);
        Node<K, V> node = nodes[index];

        if (node == null) {
            return null;
        }

        while (!key.equals(node.getKey())) {
            node = node.next;
            if (node == null) {
                break;
            }
        }

        return node.value;
    }

    @Override
    public void put(K key, V value) {
        int index = this.indexOf(key);
        Node thisNode = new Node(key, value);
        if (nodes[index] != null) {
            Node node = nodes[index];
            Node next = node.next;
            for (; next != null; ) {
                node = next;
                next = node.next;
            }
            node.setNext(thisNode);
        } else {
            nodes[index] = thisNode;
        }
    }

    /**
     * TODO 取余算法
     *
     * @param key
     * @return
     */
    private int indexOf(K key) {
        return key.hashCode() % this.initSize;
    }

    /**
     * TODO 泛型数组创建
     *
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> {
        public K key;
        public V value;
        public Node next;

        public Node() {

        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
