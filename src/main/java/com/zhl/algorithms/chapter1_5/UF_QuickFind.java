package com.zhl.algorithms.chapter1_5;

/**
 * 动态连通性 union-find
 * <p>
 * API已经说明触点和分量都会用int值表示，所以我们可以用一个以触点为索引的数组id[]作为基本数据结构来表示
 * 所有分量。我们将使用分类中的某个触点的名称作为分量的标识符，因此你可以认为每个分量都是由它的触点之一
 * 所表示的。
 */
public class UF_QuickFind {

    private int[] id; // 分量id（以触点作为索引）
    private int count; // 分量数量

    public UF_QuickFind(int N) {
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

    /**
     * find() 对于处在同一个连通分量中的触点均返回相同的整数值
     * quick-find
     */
    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // 将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        // 如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pID == qID)
            return;

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
            count--;
        }
    }

    public static void main(String[] args) {
        // 解决由StdIn得到的动态连通性问题
        int N = 100;
        UF_QuickFind uf = new UF_QuickFind(N);
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