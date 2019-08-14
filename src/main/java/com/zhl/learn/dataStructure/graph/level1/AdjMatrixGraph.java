package com.zhl.learn.dataStructure.graph.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
                //TODO 对角线上为0，其余都为无穷大
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
     */
    public void dijkstra() {
        int n = this.vertexCount();
        // 权重
        int minWeight = MAX_WEIGHT;

        int minUn = 0;

        // 存放当前起始点到其余各个顶点的距离
        int[] minMatrix = new int[n];

        // 存放是否被访问过
        boolean[] isVisit = new boolean[n];

        // 每个字符串显示对应顶点最短距离的路径
        String[] route = new String[n];

        for (int i = 0; i < n; i++) {
            minMatrix[i] = adjMatrix[0][i];
            isVisit[i] = false;
            route[i] = "起点->" + i;
        }

        for (int i = 0; i < n; i++) {
            // 选择当前和起点连通的，且值最小的顶点
            for (int k = 0; k < n; k++) {
                if (!isVisit[k]) {
                    if (minMatrix[k] < minWeight) {
                        minWeight = minMatrix[k];
                        minUn = k;
                    }
                }
            }

            isVisit[minUn] = true;
            for (int j = 0; j < n; j++) {
                if (isVisit[j]) {
                    if (minWeight + adjMatrix[minUn][j] < minMatrix[j]) {
                        // 通过当下最小值访问到的其他顶点的距离小于原先的最小值，则进行交换
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
     * 最小生成树
     * 普里姆算法的基本思想：取图中任意一个顶点v作为生成树的根，之后往生成树上添加新的顶点w。
     * 在添加的顶点w和已经在生成树上的顶点v之间必定存在一条边，并且该边的权值在所有连通顶点v和w之间的边中取值最小。
     * 之后继续往生成树上添加顶点，直至生成树上含有n-1个顶点为止。
     */
    public AdjMatrixGraph minSpanTreePrim() {
        // n个顶点最小生成树有n-1条边
        Edge[] mst = new Edge[this.vertexCount() - 1];
        int un;
        // 存放所有已访问过的顶点集合
        List<Integer> u = new ArrayList<>();
        // 起始点默认为标识为0的顶点
        u.add(0);

        for (int i = 0; i < this.vertexCount() - 1; i++) {
            // 最小边的时候，权值
            int minWeight = MAX_WEIGHT;
            // 最小边的时候，起点
            int minStart = MAX_WEIGHT;
            // 最小边的时候，终点
            int minDest = MAX_WEIGHT;

            for (int j = 0; j < u.size(); j++) {
                un = u.get(j);
                for (int k = 0; k < this.vertexCount(); k++) {
                    // 获取最小值的条件：1、该边比当前情况下的最小值小；2、该边还未访问过
                    if ((minWeight > adjMatrix[un][k]) && (!u.contains(k))) {
                        minWeight = adjMatrix[un][k];
                        minStart = un;
                        minDest = k;
                    }
                }
            }
            System.out.println("一次遍历所添加的最小边：它的权值，起点，终点分别为：weight:" + minWeight + " start:" + minStart + " dest:" + minDest);
            u.add(minDest);
            Edge e = new Edge(minStart, minDest, adjMatrix[minStart][minDest]);
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


//
//
//
//// -------五，图的连通性-------------------------//
//
//    public boolean isConnect() {
//
//        int n = this.vertexCount();
//
//        boolean[] visited = new boolean[n];
//
//// 记录不能一次深度优先遍历通过的数目
//
//// 全部顶点作为出发点开始遍历，如果全部都不能一次遍历通过（notConnectNum == n），说明该图不连通。
//
//        int notConnectNum = 0;
//
//        for (int j = 0; j < n; j++) {
//
//            for (int i = 0; i < n; i++) {
//
//                visited[i] = false;
//
//            }
//
//            this.DFS(j, visited);
//
//            for (int k = 0; k < n; k++) {
//
//                System.out.println(visited[k]);
//
//                if (visited[k] == false) {
//
//                    notConnectNum++;
//
//                    break;// 一旦有没有被遍历到的顶点（说明该顶点不属于该连通分量），跳出循环
//
//                }
//
//            }
//
//        }
//
//        if (notConnectNum == n) {
//
//            System.out.println("此图是不连通的");
//
//            return false;
//
//        } else {
//
//            System.out.println("此图是连通的");
//
//            return true;
//
//        }
//
//    }
//
//
//
//// -------六，图的拓扑排序-------------------------//
//
//    public void topologicalSort() {
//
//        int n = this.vertexCount();
//
//        int[] indegree = new int[n];
//
//        MyStack mystack = new MyStack();
//
//        String route = "拓扑排序出发：";
//
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            indegree[i] = 0;
//
//            for (int j = 0; j < n; j++) {//获取每一个顶点的入度
//
//                if (adjmatrix[j][i] != 0 && adjmatrix[j][i] != MAX_WEIGHT) {
//
//                    indegree[i] += 1;
//
//                }
//
//            }//先将入度为0的顶点加入到栈中
//
//            if (indegree[i] == 0) {
//
//                mystack.push(i);
//
//            }
//
//        }
//
//        while (!mystack.empty()) {
//
//            int v = (Integer) mystack.pop();//从栈中删除该顶点
//
//            route += "->" + v;
//
//            ++count;
//
//            for (int w = this.getFirstNeighbor(v); w >= 0; w = this
//
//                    .getNextNeighbor(v, w)) {
//
//                indegree[w] -= 1;//因为该顶点被“删除”，所有以该顶点为弧尾的边的弧头的入度减一
//
//                if (indegree[w] == 0) {
//
//                    mystack.push(w);//先将入度为0的顶点加入到栈中
//
//                }
//
//            }
//
//        }
//
//        if (count < n) {//当经历拓扑排序遍历后，所有顶点都被“删除”时（count=n），此时实现拓扑排序
//
//            System.out.println("存在回路，不满足拓扑排序的条件");
//
//        } else {
//
//            System.out.println("实现拓扑排序" + route);
//
//
//
//        }
//
//    }
//}