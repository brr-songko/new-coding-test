package com.brr.newcodingtest.n18352;

import java.io.*;
import java.util.*;

class Node {
    int city;
    int dist;

    public Node(int city, int dist) {
        this.city = city;
        this.dist = dist;
    }
}

public class Main {
    static int N, M, K, X;
    static ArrayList<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, 1));
        }
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra(X);

        boolean check = true;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                check = false;
                System.out.println(i);
            }
        }

        if (check) {
            System.out.println(-1);
        }
    }

    static void dijkstra(int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.dist));
        pq.offer(new Node(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nowCity = node.city;
            int nowDist = node.dist;

            for (int i = 0; i < list[nowCity].size(); i++) {
                int nextCity = list[nowCity].get(i).city;
                int nextDist = list[nowCity].get(i).dist;

                if (dist[nextCity] > nowDist + nextDist) {
                    dist[nextCity] = nowDist + nextDist;
                    pq.offer(new Node(nextCity, nowDist + nextDist));
                }
            }
        }
    }
}
