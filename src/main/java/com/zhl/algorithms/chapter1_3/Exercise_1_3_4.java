package com.zhl.algorithms.chapter1_3;

public class Exercise_1_3_4 {
    public static void main(String[] args) {
        // 这里计划采用Dijkstra的思想来做
        String[] str = {"[", "(", ")", "]", "{", "}", "{", "[", "(", ")", "(", ")", "]", "(", ")", "}"};
        // String[] str = {"[","(","]",")"};

        int N = 10;
        int a = 0;
        for (int i = 0; i < N; i++) {
            ++a;
            for (int j = i + 1; j < N; j++) {
                a++;
                for (int k = j + 1; k < N; k++) {
                    a++;
                }
            }
        }
        System.out.println(a);
    }
}
