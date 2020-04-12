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
public class LRUCache {

    /**
     * LRU（Least Recently Used）缓存机制
     * 当缓存满的时候，删除缓存里最久未使用的数据，然后在放入新元素
     * 数据的访问时间很重要，访问时间距离现在越近，就越不容易被删除
     * 所以，LRU一般比较简单，在删除元素的时候，只看【时间】这一个纬度
     */
    Map<Integer, Integer> cacheData;
    LinkedList<Integer> visitData;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheData = new HashMap<>(capacity);
        visitData = new LinkedList<>();
    }

    public int get(int key) {
        Integer i = cacheData.get(key);
        if (i == null) {
            return -1;
        }
        visitData.remove(new Integer(key));
        visitData.addFirst(new Integer(key));
        return i;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        Integer i = cacheData.get(key);
        if (i != null) {
            visitData.remove(new Integer(key));
            visitData.addFirst(new Integer(key));
            cacheData.put(key, value);
        } else {
            if (cacheData.size() == capacity) {
                cacheData.remove(visitData.getLast());
                visitData.removeLast();
            }
            visitData.addFirst(key);
            cacheData.put(key, value);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        /* 缓存容量 */
        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);
        System.out.println(cache.get(2));
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }
}
