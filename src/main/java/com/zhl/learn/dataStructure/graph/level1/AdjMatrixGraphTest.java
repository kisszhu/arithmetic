package com.zhl.learn.dataStructure.graph.level1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/08/10 10:01
 */
public class AdjMatrixGraphTest {
    public static void main(String[] args) {

        Vertex node1 = new Vertex(0, "节点1");
        Vertex node2 = new Vertex(1, "节点2");
        Vertex node3 = new Vertex(2, "节点3");
        Vertex node4 = new Vertex(4, "节点4");


        Edge edge1 = new Edge(0, 1, 12);
        Edge edge2 = new Edge(1, 2, 23);
        Edge edge3 = new Edge(2, 3, 34);
        Edge edge4 = new Edge(3, 0, 41);
        Edge edge5 = new Edge(0, 2, 99);

        List nodes = new ArrayList();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        Edge[] edges = new Edge[5];
        edges[0] = edge1;
        edges[1] = edge2;
        edges[2] = edge3;
        edges[3] = edge4;
        edges[4] = edge5;

        AdjMatrixGraph graph = new AdjMatrixGraph(nodes, edges);

        System.out.println(graph.toString());

        // 移动顶点
        /// graph.removeVertex(1);
        /// System.out.println(graph.toString());

        // 最小生成树-普里姆算法
        /// AdjMatrixGraph minGraph = graph.minSpanTreePrim();
        /// System.out.println(minGraph.toString());

        // 深度遍历
        /// graph.dfStraverse();

        // 广度遍历
        /// graph.bfStraverse();

        // 最短路径
        graph.dijkstra();
        // 从结果来看，代码应该是存在问题，0 -> 2的最短路径应该是 0 -> 1 -> 2 = 12 + 23 = 35
        // 邻接矩阵：
        // 0        12        99        ∞
        // ∞        0         23        ∞
        // ∞        ∞         0        34
        // 41       ∞         ∞        0

        // 从V0出发到底1点
        // 当前从V0出发到达该点的最短距离：12
        // 当前从V0出发到达该店的最短距离：起点->1
        // 从V0出发到底2点
        // 当前从V0出发到达该点的最短距离：99
        // 当前从V0出发到达该店的最短距离：起点->2
        // 从V0出发到底3点
        // 没有到达该点的路径
    }
}
