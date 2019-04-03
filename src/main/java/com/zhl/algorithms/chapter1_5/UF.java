package com.zhl.algorithms.chapter1_5;

import java.util.Random;

/**
 * 动态连通性 union-find
 * <p>
 * API已经说明触点和分量都会用int值表示，所以我们可以用一个以触点为索引的数组id[]作为基本数据结构来表示
 * 所有分量。我们将使用分类中的某个触点的名称作为分量的标识符，因此你可以认为每个分量都是由它的触点之一
 * 所表示的。
 */
public class UF {

    private int[] id; // 分量id（以触点作为索引）
    private int count; // 分量数量

    public UF(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(9);
    }

    public int find(int p) {
        return 0;
    }

    public void union(int p, int q) {
    }

    public static void main(String[] args) {
        // 解决由StdIn得到的动态连通性问题
        int N = 100;
        UF uf = new UF(N);
        for (int i = 0; i < 5; i++) {
            int p = (int) (Math.random() * 100); // 读取整数对
            int q = (int) (Math.random() * 100);

            if (uf.connected(p, q)) //如果已经连通则忽略
                continue;
            uf.union(p, q); // 归并分量
            System.out.println(p + "  " + q); // 打印连接
        }
        System.out.println(uf.count() + "components");
    }
}