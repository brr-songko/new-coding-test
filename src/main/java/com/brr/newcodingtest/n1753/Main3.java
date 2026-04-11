package com.brr.newcodingtest.n1753;

import java.io.*;
import java.util.*;

public class Main3 {

    static int V, E, K;
    static ArrayList<int[]>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int now = temp[0];
            int cost = temp[1];

            for (int i = 0; i < list[now].size(); i++) {
                int[] temp2 = list[now].get(i);
                int next = temp2[0];
                int nextCost = temp2[1];

                if (dist[next] > cost + nextCost) {
                    dist[next] = cost + nextCost;
                    pq.offer(new int[]{next, cost + nextCost});
                }
            }
        }
    }
}
