package com.zhl.algorithms.chapter1_5;

/**
 * 加权quick-union算法.
 */
public class WeightedQuickUnionUF {
    private int[] id; // 父链接数组（由触点索引）
    private int[] sz; // （由触点索引的）各个根节点所对应的分量的大小
    private int count; // 连通分量的数量

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        // 跟随链接找到根节点
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        /*
         将小树的根节点连接到大树的根节点
         我们加入了一个由触点索引的实例变量数组sz[]，这样union()就可以将小树的根节点连接到大树的根节点。
         这使得算法能够处理规模较大的问题。
         */
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        // 解决由StdIn得到的动态连通性问题
        int N = 100;
        UF_QuickUnion uf = new UF_QuickUnion(N);
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
