package com.brr.newcodingtest.n1504;

import java.io.*;
import java.util.*;

class Node4 {
    int v;
    int cost;

    public Node4(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main4 {

    static int[] dist1, dist2, dist3;
    static ArrayList<Node4>[] list;
    static int N, E, v1, v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        dist1 = new int[N + 1];
        dist2 = new int[N + 1];
        dist3 = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node4(b, c));
            list[b].add(new Node4(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dist1 = dijkstra(1);
        dist2 = dijkstra(v1);
        dist3 = dijkstra(v2);

        long path1 = (long) dist1[v1] + dist2[v2] + dist3[N];
        long path2 = (long) dist1[v2] + dist3[v1] + dist2[N];

        long answer = Math.min(path1, path2);
        if (answer >= Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    static int[] dijkstra(int s) {
        int[] answerList = new int[N + 1];
        Arrays.fill(answerList, Integer.MAX_VALUE);
        PriorityQueue<Node4> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node4(s, 0));
        answerList[s] = 0;

        while (!pq.isEmpty()) {
            Node4 now = pq.poll();
            int v = now.v;
            int cost = now.cost;

            for (int i = 0; i < list[v].size(); i++) {
                Node4 next = list[v].get(i);
                int nv = next.v;
                int nCost = next.cost;

                if (answerList[nv] > cost + nCost) {
                    answerList[nv] = cost + nCost;
                    pq.offer(new Node4(nv, cost + nCost));
                }
            }
        }

        return answerList;
    }
}
