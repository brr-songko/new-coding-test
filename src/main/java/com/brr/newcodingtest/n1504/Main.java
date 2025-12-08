package com.brr.newcodingtest.n1504;

import java.io.*;
import java.util.*;

class Node {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    static int N, E, v1, v2;
    static long answer;
    static ArrayList<Node>[] list;
    static int[] dist1, distV1, distV2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        dist1 = new int[N + 1];
        distV1 = new int[N + 1];
        distV2 = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dist1 = dijkstra(1);
        distV1 = dijkstra(v1);
        distV2 = dijkstra(v2);

        long path1 = (long)dist1[v1] + distV1[v2] + distV2[N];
        long path2 = (long)dist1[v2] + distV2[v1] + distV1[N];

        answer = Math.min(path1, path2);
        if (answer >= Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    static int[] dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.offer(new Node(s, 0));
        int[] answerList = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            answerList[i] = Integer.MAX_VALUE;
        }
        answerList[s] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.v;
            int cost = node.cost;

            for (int i = 0; i < list[v].size(); i++) {
                int nv = list[v].get(i).v;
                int ncost = list[v].get(i).cost;

                if (answerList[nv] > cost + ncost) {
                    answerList[nv] = cost + ncost;
                    pq.offer(new Node(nv, cost + ncost));
                }
            }
        }

        return answerList;
    }
}
