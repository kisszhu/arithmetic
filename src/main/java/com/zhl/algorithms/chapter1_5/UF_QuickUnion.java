package com.zhl.algorithms.chapter1_5;

/**
 * 动态连通性 union-find
 * <p>
 * API已经说明触点和分量都会用int值表示，所以我们可以用一个以触点为索引的数组id[]作为基本数据结构来表示
 * 所有分量。我们将使用分类中的某个触点的名称作为分量的标识符，因此你可以认为每个分量都是由它的触点之一
 * 所表示的。
 */
public class UF_QuickUnion {

    private int[] id; // 分量id（以触点作为索引）
    private int count; // 分量数量

    public UF_QuickUnion(int N) {
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
     * 以触点作为索引的id[]数组，但我们赋予这些值的意义不同，我们需要用它们来定义更加复杂的结构。确切地说，
     * 每个触点所对应的id[]元素都是同一个分类中另一个触点的名称（也可能是它自己）——我们将这种联系称为链接
     * <p>
     * 在实现find()方法时，我们从给定的触点开始，由它的链接得到另一个触点，在由这个触点的链接到达第三个触点，如此继续
     * 跟随着链接直到到达一个跟触点，即链接指向自己的触点（你将会看到，这样一个触点必然存在）
     */
    public int find(int p) {
        // 找出分类的名称
        while (p != id[p])
            p = id[p];
        return p;
    }

    /**
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        id[pRoot] = qRoot;
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