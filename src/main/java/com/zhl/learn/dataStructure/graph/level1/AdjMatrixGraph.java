package com.zhl.learn.dataStructure.graph.level1;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/08/09 08:44
 */
public class AdjMatrixGraph<E> {

    /**
     * 顺序存储图的顶点的集合
     */
    protected List<E> vertexList;

    /**
     * 图的邻接矩阵
     */
    protected int[][] adjMatrix;


    private final int MAX_WEIGHT = Integer.MAX_VALUE / 2;


    public AdjMatrixGraph(int n) {
        this.vertexList = new ArrayList<E>(n);
        adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 对角线上为0，其余都为无穷大
                this.adjMatrix[i][j] = (i == j) ? 0 : MAX_WEIGHT;
            }
        }
    }

    public AdjMatrixGraph(E[] vertices, Edge[] edges) {
        this(vertices.length);
        for (int i = 0; i < vertices.length; i++) {
            // 添加节点
            insertVertex(vertices[i]);
        }
        for (int j = 0; j < edges.length; j++) {
            insertEdge(edges[j]);
        }
    }

    public AdjMatrixGraph(List<E> vertices, Edge[] edges) {
        this(vertices.size());
        this.vertexList = vertices;
        for (int j = 0; j < edges.length; j++) {
            insertEdge(edges[j]);
        }
    }

    public E get(int i) {
        return vertexList.get(i);
    }

    public boolean removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount() && j >= 0 && j < vertexCount() && i != j && adjMatrix[i][j] != MAX_WEIGHT) {
            adjMatrix[i][i] = MAX_WEIGHT;
            return true;
        }
        return false;
    }


    public boolean removeVertex(int num) {
        int n = vertexCount();
        if (num >= 0 && num < vertexCount()) {
            vertexList.remove(num);
            // y轴上移动
            for (int i = num; i < n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    // 邻接矩阵：删除点以下往上移动一位
                    adjMatrix[i][j] = adjMatrix[i + 1][j];
                }
            }
            // x轴左移动
            for (int j = num; j < n - 1; j++) {
                for (int i = 0; i < n; i++) {
                    // 邻接矩阵：删除点以右往左移动一位
                    adjMatrix[i][j] = adjMatrix[i][j + 1];
                }
            }
            return true;
        }
        return false;
    }

    public int getFirstNeighbor(int v) {
        // 返回顶点v的第一个邻接顶点的序号
        return getNextNeighbor(v, -1);
    }

    public int getNextNeighbor(int v, int w) {
        if (v >= 0 && v < vertexCount() && w >= -1 && w <= vertexCount() && v != w) {
            for (int j = w + 1; j < vertexCount(); j++) {
                if (adjMatrix[v][j] > 0 && adjMatrix[v][j] < MAX_WEIGHT) {
                    // 遍历和v相关的点，得到下一个点
                    return j;
                }
            }
        }
        return -1;
    }

    private boolean insertVertex(E vertex) {
        return this.vertexList.add(vertex);
    }

    private boolean insertEdge(Edge edge) {
        return insertEdge(edge.start, edge.dest, edge.weight);
    }

    private boolean insertEdge(int i, int j, int weight) {
        // 插入一条权值为weight的边<vi,vj>，若该边已有，则不插入
        if (i >= 0 && i < vertexCount() && j >= 0 && j < vertexCount() && i != j && adjMatrix[i][j] == MAX_WEIGHT) {
            // 添加权值
            this.adjMatrix[i][j] = weight;
            return true;
        }
        return false;
    }

    private int vertexCount() {
        return this.vertexList.size();
    }

    /**
     * 图的遍历（深度遍历）
     */
    public void dfStraverse() {
        int n = this.vertexCount();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("以顶点为" + i + "开始遍历");
                dfs(i, visited);
            }
        }
    }

    public void dfs(int i, boolean[] visited) {
        boolean[] vi = visited;
        vi[i] = true;
        System.out.println("遍历顶点 " + i);

        for (int w = getFirstNeighbor(i); w >= 0; w = getNextNeighbor(i, w)) {
            if (!vi[w]) {
                vi[w] = true;
                dfs(w, vi);
            }
        }
    }

    /**
     * 图的遍历（广度遍历）
     */
    public void bfStraverse() {
        int n = this.vertexCount();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        Queue queue = new LinkedBlockingQueue();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.println("遍历起点：" + i);

                queue.add(i);

                while (!queue.isEmpty()) {
                    int v = (Integer) queue.remove();
                    System.out.println("遍历点：" + v);

                    for (int w = getFirstNeighbor(v); w >= 0; w = getNextNeighbor(v, w)) {
                        if (!visited[w]) {
                            visited[w] = true;
                            queue.add(w);
                        }
                    }
                }
            }
        }
    }

    /**
     * 图的最短路径 Dijkstra算法
     * Dijkstra算法的缺点如下：
     * 1、不能处理边权值为负的情况，因为会导致算法中求得的最短路径未必是最短路径
     * <p>
     * 算法详解：
     * 1、将图上初始点看作一个集合S，其它点看作另一个集合
     * 2、根据初始点，求出其它点到初始点的距离d[i]（若相邻，则d[i]为边权值；若不相邻，则d[i]为无限大）
     * 3、选取最小的d[i]（记为d[x]），并将d[i]边对应的点(记为x)加入集合S
     * 4、在根据x，更新跟x相邻点y的d[y]值：d[y] = min{d[y],d[x]+边权值w[x][y]}，因为可能把距离调小，所以这个更新操作叫做松弛操作
     * 5、重复3,4两步，直到目标点也加入了集合，此时目标点所对应的d[i]记为最短路径长度
     */
    public void dijkstra() {
        int n = this.vertexCount();
        // 当前最小权重
        int minWeight = MAX_WEIGHT;

        // 当前最小顶点
        int minUn = 0;

        // 存放当前起始点到其余各个顶点的距离
        int[] minMatrix = new int[n];

        // 存放是否被访问过
        boolean[] isVisit = new boolean[n];

        // 每个字符串显示对应顶点最短距离的路径
        String[] route = new String[n];

        // 初始化数据
        for (int i = 1; i < n; i++) {
            // 初始化距离数据
            minMatrix[i] = adjMatrix[0][i];
            // 初始化节点访问
            isVisit[i] = false;
            // 初始化图的路由
            route[i] = "起点->" + i;
        }

        for (int i = 0; i < n; i++) {
            // 开局：因为Dijkstra只能用来处理正权，所以我们直接选择一个最小距离的顶点作为程序的入口
            // 备注：如果涉及到负权的话，两点之间最短的距离，就可能不是最短的了
            for (int k = 1; k < n; k++) {
                if (!isVisit[k]) {
                    if (minMatrix[k] < minWeight) {
                        minWeight = minMatrix[k];
                        minUn = k;
                    }
                }
            }

            isVisit[minUn] = true;
            for (int j = 1; j < n; j++) {
                // 已经访问过的节点，就不再需要比较了
                if (!isVisit[j]) {
                    // 查看 v0 -> vk + vk -> vj的距离是否小于 vo -> vj的距离，如果小于则交换
                    if (minWeight + adjMatrix[minUn][j] < minMatrix[j]) {
                        minMatrix[j] = minWeight + adjMatrix[minUn][j];
                        route[j] = route[minUn] + "->" + j;
                    }
                }
            }
            minWeight = MAX_WEIGHT;
        }

        for (int m = 0; m < n; m++) {
            System.out.println("从V0出发到达" + m + "点");
            if (minMatrix[m] == MAX_WEIGHT) {
                System.out.println("没有到达该点的路径");
            } else {
                System.out.println("当前从V0出发到达该点的最短距离：" + minMatrix[m]);
                System.out.println("当前从V0出发到达该店的最短距离：" + route[m]);
            }
        }
    }

    /**
     * 图的连通性
     * 连通性：从顶点i 到 顶点j 有路径相连，则称i 到 j是连通的
     * 连通图（无向图）：如果图中任意两点都是相连的，则称 连通图
     * 强连通图（有向图）：如果图中任意两点都是相连的，则称 强连通图（注意存在两个方向）
     */
    public boolean isConnect() {
        int n = this.vertexCount();
        boolean[] visited = new boolean[n];

        // 在无向图中，通过图的深度遍历，看是否存在没有遍历到的顶点，如果每次的深度遍历都存在没有遍历到的顶点的话，则说明图不是连通的
        int notConnectNum = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                visited[i] = false;
            }
            this.dfs(j, visited);
            for (int k = 0; k < n; k++) {
                System.out.println(visited[k]);
                if (visited[k] == false) {
                    // 一旦有没有被遍历到的顶点（说明该顶点不属于该连通分量），跳出循环
                    notConnectNum++;
                    break;
                }
            }
        }
        if (notConnectNum == n) {
            System.out.println("此图是不连通的");
            return false;
        } else {
            System.out.println("此图是连通的");
            return true;
        }
    }

    /**
     * 图的拓扑排序
     */
    public void topologicalSort() {
        int n = this.vertexCount();
        int[] indegree = new int[n];

        Stack stack = new Stack();
        String route = "拓扑排序出发：";
        int count = 0;

        for (int i = 0; i < n; i++) {
            indegree[i] = 0;
            // 获取每一个顶点的入度
            for (int j = 0; j < n; j++) {
                // 这里获取的是顶点i的入度，所以矩阵为adjMatrix[j][i]
                if (adjMatrix[j][i] != 0 && adjMatrix[j][i] != MAX_WEIGHT) {
                    indegree[i] += 1;
                }
            }
            // 先将入度为0的顶点加入到栈中
            if (indegree[i] == 0) {
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            // 从栈中删除该顶点
            int v = (Integer) stack.pop();
            route += "->" + v;
            ++count;
            // 基于广度遍历，一层层的消掉节点的入度
            for (int w = this.getFirstNeighbor(v); w >= 0; w = this.getNextNeighbor(v, w)) {
                // 因为该顶点被"删除"，所有以该顶点为弧尾的边的弧头的入度减一
                indegree[w] -= 1;
                if (indegree[w] == 0) {
                    stack.push(w);
                }
            }
        }
        if (count < n) {
            System.out.println("存在回路，不满足拓扑排序的条件 ");
        } else {
            System.out.println("实现拓扑排序 :" + route);
        }
    }

    /**
     * 最小生成树
     * 树：
     * 含有n个顶点以及含有n-1条边
     * <p>
     * 最小生成树：
     * 给定一个带权的无向连通图，如何选取一颗生成树，使树上所有边上权的总和为最小，这叫最小生成树
     * <p>
     * 普里姆算法的基本思想：
     * 取图中任意一个顶点v作为生成树的根，之后往生成树上添加新的顶点w。
     * 在添加的顶点w和已经在生成树上的顶点v之间必定存在一条边，并且该边的权值在所有连通顶点v和w之间的边中取值最小。
     * 之后继续往生成树上添加顶点，直至生成树上含有n-1个顶点为止。
     */
    public AdjMatrixGraph minSpanTreePrim() {
        int n = vertexCount();
        // 一棵树有n个节点，有n-1条边
        Edge[] mst = new Edge[n - 1];
        // 定义初始集合
        List<Integer> init = new ArrayList<>();
        // 定义初始节点
        init.add(0);

        // 循环原始集合
        for (int i = 0; i < n - 1; i++) {
            Integer startNode = 0;
            Integer endNode = 0;
            Integer maxWeight = Integer.MAX_VALUE;

            // 找到下一个最小边(在所有初始集合 和 原始集合中寻找下一个最小边)
            for (int j = 0; j < init.size(); j++) {
                int node = init.get(j);

                for (int k = 0; k < n; k++) {
                    // 贪心算法，找到node节点的的最小路径
                    if (adjMatrix[node][k] < maxWeight && (!init.contains(k))) {
                        maxWeight = adjMatrix[node][k];
                        startNode = node;
                        endNode = k;
                    }
                }
            }
            System.out.println("一次遍历所添加的最小边：它的权值，起点，终点分别为：weight:" + maxWeight + " start:" + startNode + " dest:" + endNode);
            init.add(endNode);
            Edge e = new Edge(startNode, endNode, adjMatrix[startNode][endNode]);
            mst[i] = e;
        }
        // 构造最小生成树相应的图对象
        return new AdjMatrixGraph(this.vertexList, mst);
    }

    @Override
    public String toString() {
        String str = "顶点集合：" + vertexList.toString() + "\n";
        str += "邻接矩阵：\n";

        int n = vertexCount();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == MAX_WEIGHT) {
                    // 最大值（不存在）的时候的显示方式
                    str += "    ∞    ";
                } else {
                    // 每个顶点到其他顶点的权值
                    str += "    " + adjMatrix[i][j] + "    ";
                }
            }
            str += "\n";
        }
        return str;
    }
}
