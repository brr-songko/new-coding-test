package com.brr.newcodingtest.n1446;

import java.io.*;
import java.util.*;

class Node3 {
    int v;
    int cost;

    public Node3(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main3 {

    static int N, D;
    static ArrayList<Node3>[] list;
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
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node3(e, c));
        }
        for (int i = 0; i < 10000; i++) {
            list[i].add(new Node3(i + 1, 1));
        }

        dijkstra();

        System.out.println(dist[D]);
    }

    static void dijkstra() {
        PriorityQueue<Node3> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Node3(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node3 now = pq.poll();
            int v = now.v;
            int cost = now.cost;

            for (int i = 0; i < list[v].size(); i++) {
                Node3 next = list[v].get(i);
                int nv = next.v;
                int nCost = next.cost;

                if (dist[nv] > cost + nCost) {
                    dist[nv] = cost + nCost;
                    pq.offer(new Node3(nv, cost + nCost));
                }
            }
        }
    }
}
