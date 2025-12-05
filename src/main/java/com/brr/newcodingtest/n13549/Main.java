package com.brr.newcodingtest.n13549;

import java.io.*;
import java.util.*;

class Node {
    int index;
    int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }
}

public class Main {
    static int N, K, max;
    static int[] answerList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        max = 100000;
        answerList = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            answerList[i] = Integer.MAX_VALUE;
        }

        dijkstra(N);

        System.out.println(answerList[K]);
    }

    static void dijkstra(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.time));
        pq.offer(new Node(n, 0));
        answerList[n] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int time = node.time;

            if (answerList[index] < time) continue;

            int next = index * 2;
            if (next <= max && answerList[next] > time) {
                answerList[next] = time;
                pq.offer(new Node(next, time));
            }

            next = index - 1;
            if (next >= 0 && answerList[next] > time + 1) {
                answerList[next] = time + 1;
                pq.offer(new Node(next, time + 1));
            }

            next = index + 1;
            if (next <= max && answerList[next] > time + 1) {
                answerList[next] = time + 1;
                pq.offer(new Node(next, time + 1));
            }
        }
    }
}
