package com.brr.newcodingtest.n1916;

import java.io.*;
import java.util.*;

class Node {
    int city;
    int cost;

    public Node(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}
public class Main {
    static int N, M, s, e;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] answerList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answerList = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            answerList[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int busCost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, busCost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dijkstra(s);

        System.out.println(answerList[e]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.offer(new Node(start, 0));
        answerList[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int city = node.city;
            int cost = node.cost;

            if (cost > answerList[city]) continue;

            for (int i = 0; i < list[city].size(); i++) {
                int nextCity = list[city].get(i).city;
                int nextCost = list[city].get(i).cost;

                if (answerList[nextCity] > answerList[city] + nextCost) {
                    answerList[nextCity] = answerList[city] + nextCost;
                    pq.offer(new Node(nextCity, nextCost));
                }
            }
        }

    }
}
