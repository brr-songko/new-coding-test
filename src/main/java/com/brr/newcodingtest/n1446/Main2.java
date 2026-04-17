package com.brr.newcodingtest.n1446;

import java.io.*;
import java.util.*;

class Node2 {
    int v;
    int cost;

    public Node2(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main2 {

    static ArrayList<Node2>[] list;
    static int N, D;
    static int[] dist = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new Node2(e, cost));
        }

        for (int i = 0; i < D; i++) {
            list[i].add(new Node2(i + 1, 1));
        }

        dijkstra();

        System.out.println(dist[D]);
    }

    static void dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node2> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node2(0, 0));

        while (!pq.isEmpty()) {
            Node2 node = pq.poll();
            int v = node.v;
            int cost = node.cost;

            for (int i = 0; i < list[v].size(); i++) {
                Node2 nextNode = list[v].get(i);
                int nv = nextNode.v;
                int nCost = nextNode.cost;

                if (dist[nv] > cost + nCost) {
                    dist[nv] = cost + nCost;
                    pq.offer(new Node2(nv, cost + nCost));
                }
            }
        }
    }
}
