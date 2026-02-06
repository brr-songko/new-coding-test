package com.brr.newcodingtest.n23286;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T;
    static ArrayList<int[]>[] list;
    static int[] minHeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        minHeight = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, h});
        }

        for (int i = 0; i < T; i++) {
            Arrays.fill(minHeight, Integer.MAX_VALUE);
             st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            dijkstra(s);

            if (minHeight[e] == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(minHeight[e]);
        }
    }

    static void dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0});
        minHeight[s] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curHeight = cur[1];

            if (curHeight > minHeight[curNode]) continue;

            for (int[] next : list[curNode]) {
                int nextNode = next[0];
                int nextHeight = next[1];

                int newHeight = Math.max(curHeight, nextHeight);
                if (newHeight < minHeight[nextNode]) {
                    minHeight[nextNode] = newHeight;
                    pq.offer(new int[]{nextNode, newHeight});
                }
            }
        }
    }
}

