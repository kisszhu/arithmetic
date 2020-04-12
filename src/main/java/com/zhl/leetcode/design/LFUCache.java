package com.zhl.leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/05 14:30
 */
public class LFUCache {

    /**
     * LFU：
     * 在缓存满的时候，删除缓存里使用次数最少的元素，然后在缓存中放入新元素；
     * 数据的访问次数很重要，访问次数越多，就越不容易被删除；
     * 根据题意[当存在平局（即两个或更多个健具有相同使用频率）时，最近最少使用的键将被去除]，
     * 即在[访问次数]相同的情况下，按照时间顺序，先删除在缓存里时间最久的数据
     * <p>
     * 先考虑访问次数，在访问次数相同的情况下，在考虑缓存时间
     */

    /**
     * 由于题目的时间复杂度要求O(1)，空间肯定不能省，存取数据时间性能最好的就是哈希表，因此底层的数据结构一定是一个哈希表；
     * 由于缓存大小有限制，删除策略是[先看访问频次，在看访问时间]，所以需要记录每个数据访问的频次；所以频次是一个很关键的指标
     * [删除某个数据]得到O(1)，访问某个数据，时间优先级得提前（提前到当前频次最高），这样的数据结构符合在头尾访问数据最快，采用双向链表
     * <p>
     * 链表节点得记录：1、value，2、key（在哈希表删除的时候用得上），3、访问次数信息，以便知道下一个访问次数是多少；前驱节点引用，后继节点用用
     * <p>
     * 哈希表存储的key，value是节点的引用
     */

    Map<Integer, Node> cacheData;
    Map<Integer, LinkedList<Node>> visitData;
    private Integer capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        // data map init
        cacheData = new HashMap(capacity);
        // visit map init
        visitData = new HashMap<>();
        // 初始化访问次数为0的List
        visitData.put(0, new LinkedList<>());
    }

    public int get(int key) {
        Node node = cacheData.get(key);
        if (node == null) {
            return -1;
        }
        // 增加访问频次
        visitInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        // 判断容量
        if (cacheData.size() == capacity && !cacheData.containsKey(key)) {
            // 获取最少访问次数
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, LinkedList<Node>> entry : visitData.entrySet()) {
                if (entry.getKey() < min && entry.getValue().size() > 0) {
                    min = entry.getKey();
                }
            }
            // 移除最少访问次数的，最后访问的元素
            LinkedList<Node> nodes = visitData.get(min);
            Node node = nodes.getLast();
            cacheData.remove(node.key);
            nodes.removeLast();
        }

        // 清空之前的访问记录
        if (cacheData.containsKey(key)) {
            Node node = cacheData.get(key);

            visitInc(node);
            
            // 添加值
            node.value = value;
            cacheData.put(key, node);
        } else {
            // 初始化访问记录为0
            Node node = new Node(key, value, 0);
            visitData.get(0).addFirst(node);
            // 添加值
            cacheData.put(key, node);
        }
    }

    private void visitInc(Node node) {
        int visit = node.visit;
        visitData.get(visit).remove(node);
        node.visit = visit + 1;

        LinkedList<Node> nodes = visitData.get(node.visit);
        if (nodes == null) {
            nodes = new LinkedList<>();
            nodes.addFirst(node);
            visitData.put(node.visit, nodes);
        } else {
            nodes.addFirst(node);
        }
    }

    class Node {
        Integer key;
        Integer value;
        Integer visit;

        public Node(Integer key, Integer value, Integer visit) {
            this.key = key;
            this.value = value;
            this.visit = visit;
        }
    }

    public static void main(String[] args) {
        /* capacity (缓存容量) */
        LFUCache cache = new LFUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
