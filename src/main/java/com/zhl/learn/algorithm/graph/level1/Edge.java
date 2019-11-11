package com.zhl.learn.algorithm.graph.level1;

/**
 * @program algorithm
 * @description:
 * @author: meilong
 * @create: 2019/08/10 10:06
 */
public class Edge {
    public Integer start;
    public Integer dest;
    public Integer weight;

    public Edge(Integer start, Integer dest, Integer weight) {
        this.start = start;
        this.dest = dest;
        this.weight = weight;
    }
}
