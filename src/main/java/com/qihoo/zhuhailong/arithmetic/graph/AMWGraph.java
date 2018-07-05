package com.qihoo.zhuhailong.arithmetic.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zhuhailong-dc on 2018/7/3.
 * 深度优先遍历
 * 广度优先遍历
 */
public class AMWGraph {

    private ArrayList vertexList; //存储点的链表
    private int[][] edges; //邻接矩阵，用来存储边
    private int numOfEdges; //边的数目

    public AMWGraph(int n) {
        // 初始化矩阵，一维数组，和边的数目
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
    }

    // 得到节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点i的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i).toString();
    }

    // 返回v1,v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    // 插入边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdges++;
    }

    // 删除节点
    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdges--;   //TODO 这里不要删除存储点的链表吗
    }

    // 得到第一个邻接节点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) { //TODO 基于的原理是两点确认一条线
                return j;
            }
        }
        return -1;
    }

    // 根据前一个邻接节点的下标来取得下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) { //TODO 为什么V1没有动
                return j;
            }
        }
        return -1;
    }

    // 私有函数，深度优先遍历
    private void depthFirstSearch(boolean[] isVisited, int i) {
        // 首先方法该节点，在控制台打印出来
        System.out.println(getValueByIndex(i));
        // 置该节点为已访问
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    // 对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch(boolean[] isVisited) {
        for (int i = 0; i < getNumOfVertex(); i++) {
            // 因为对于非连通图来说，并不是通过一个节点就一定可以遍历所有节点的。
            if (!isVisited[i]) {
                depthFirstSearch(isVisited, i);
            }
        }
    }

    // 私有函数，广度优先遍历
    private void broadFirstSearch(boolean[] isVisited, int i) {
        int u, w;
        LinkedList queue = new LinkedList();

        // 访问节点i
        System.out.println(getValueByIndex(i) + " ");
        isVisited[i] = true;

        // 节点入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            u = ((Integer) queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    // 访问该节点
                    System.out.println(getValueByIndex(w) + " ");
                    // 标记已被访问
                    isVisited[w] = true;
                    // 入队列
                    queue.addLast(w);
                }
                // 寻找下一个邻接节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    // 对外公开函数，广度优先遍历
    public void broadFirstSearch(boolean[] isVisited) {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }

    public static void main(String[] args) {
        // 有8个节点，9条边
        int n = 8, e = 9;
        String labels[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        AMWGraph graph = new AMWGraph(n); // 8个节点

        boolean[] isVisited = new boolean[n];

        for (String lable : labels) {
            graph.insertVertex(lable); // 插入节点
        }

        // 插入九条边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        

        System.out.println("深度优先搜索序列为：");
        graph.depthFirstSearch(isVisited);

        isVisited = new boolean[n];

        System.out.println("广度优先搜索序列为：");
        graph.broadFirstSearch(isVisited);

    }

}
