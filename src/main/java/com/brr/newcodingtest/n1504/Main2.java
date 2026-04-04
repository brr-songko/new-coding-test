package com.brr.newcodingtest.n1504;

import java.io.*;
import java.util.*;

class Node2 {
    int to;
    int cost;

    public Node2(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main2 {

    static int N, E, v1, v2;
    static ArrayList<Node2>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[s].add(new Node2(e, c));
            list[e].add(new Node2(s, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int dist1 = search(1, v1);
        int dist2 = search(v1, v2);
        int dist3 = search(v2, N);

        int distSum1 = 0;
        if (dist1 == Integer.MAX_VALUE || dist2 == Integer.MAX_VALUE || dist3 == Integer.MAX_VALUE) distSum1 = -1;
        else distSum1 = dist1 + dist2 + dist3;

        int dist4 = search(1, v2);
        int dist5 = search(v2, v1);
        int dist6 = search(v1, N);

        int distSum2 = 0;
        if (dist4 == Integer.MAX_VALUE || dist5 == Integer.MAX_VALUE || dist6 == Integer.MAX_VALUE) distSum2 = -1;
        else distSum2 = dist4 + dist5 + dist6;

        long answer = Math.min(distSum1, distSum2);

        System.out.println(answer);
    }

    static int search(int s, int e) {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];});
        pq.offer(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int now = temp[0];
            int nowTotal = temp[1];

            if (nowTotal > dist[now]) continue;

            if (now == e) {
                return nowTotal;
            }


            for (int i = 0; i < list[now].size(); i++) {
                Node2 node2 = list[now].get(i);
                int next = node2.to;
                int nextCost = node2.cost;


                if (dist[next] > nowTotal + nextCost) {
                    dist[next] = nowTotal + nextCost;
                    pq.offer(new int[]{next, nowTotal + nextCost});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
