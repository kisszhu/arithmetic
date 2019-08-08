package com.zhl.learn.dataStructure.hash.map.level1;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/08/08 08:17
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap map = new HashMap(16);
        map.put(1, 1);
        map.put(2, 3);
        Object v = map.get(2);

        System.out.println(v);
    }
}
