package com.zhl.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/29 18:30
 */
public class LeetCode_310 {

    /**
     * 图的BFS：首先把各个叶子节点（入度为1的节点）全部入队，一层一层的剥掉最外层的叶子节点，
     * 那么最后剩下的一个节点（或2个节点）则就是最终的根节点
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minTreeRoot = new ArrayList<>();
        if (n == 1) {
            minTreeRoot.add(0);
            return minTreeRoot;
        }

        // 存储每个点对应的入度
        int[] degree = new int[n];
        int first;
        int second;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 遍历边，求入度为1
        for (int[] array : edges) {
            first = array[0];
            second = array[1];
            degree[first]++;
            degree[second]++;
            adjacencyList.get(first).add(second);
            adjacencyList.get(second).add(first);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        // 从叶子节点，开始进行bsf遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            minTreeRoot.clear();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                minTreeRoot.add(node);
                List<Integer> nextNode = adjacencyList.get(node);
                for (Integer num : nextNode) {
                    degree[num]--;
                    if (degree[num] == 1) {
                        queue.add(num);
                    }
                }
            }
        }
        return minTreeRoot;
    }

    public static void main(String[] args) {
        LeetCode_310 test = new LeetCode_310();
        int[][] edges = new int[3][3];
        edges[0][0] = 1;
        edges[0][1] = 0;
        edges[1][0] = 1;
        edges[1][1] = 2;
        edges[2][0] = 1;
        edges[2][1] = 3;

        List<Integer> list = test.findMinHeightTrees(4, edges);
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
