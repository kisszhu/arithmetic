package com.zhl.learn.algorithm.hash.map.level1;

/**
 * @program algorithm
 * @description:
 * @author: meilong
 * @create: 2019/08/08 07:21
 */
public interface Map<K, V> {
    void put(K key, V value);

    V get(K key);
}
