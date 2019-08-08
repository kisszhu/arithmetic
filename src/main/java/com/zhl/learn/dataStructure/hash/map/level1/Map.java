package com.zhl.learn.dataStructure.hash.map.level1;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/08/08 07:21
 */
public interface Map<K, V> {
    void put(K key, V value);

    V get(K key);
}
