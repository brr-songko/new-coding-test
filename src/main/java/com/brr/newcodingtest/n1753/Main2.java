package com.brr.newcodingtest.n1753;

import java.io.*;
import java.util.*;

public class Main2 {
    static int V, E, K;
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    static int[] answerList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        answerList = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
        }
        for (int i = 1; i <= V; i++) {
            answerList[i] = Integer.MAX_VALUE;
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (answerList[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(answerList[i]);
            }
        }
    }

    static void dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        pq.offer(new int[]{s, 0});
        answerList[s] = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int now = temp[0];

            if (temp[1] > answerList[now]) continue;

            for (int i = 0; i < list[now].size(); i++) {
                int e = list[now].get(i)[0];

                if (answerList[e] > answerList[now] + list[now].get(i)[1]) {
                    pq.offer(new int[]{e, answerList[now] + list[now].get(i)[1]});
                    answerList[e] = answerList[now] + list[now].get(i)[1];
                }
            }
        }
    }
}
