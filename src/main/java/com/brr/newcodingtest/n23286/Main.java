package com.brr.newcodingtest.n23286;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T;
    static ArrayList<int[]>[] list;
    static int[] minHeight, starts, ends, answers;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

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

        Map<Integer, List<Integer>> queryMap = new HashMap<>();
        starts = new int[T + 1];
        ends = new int[T + 1];
        answers = new int[T + 1];

        for (int i = 1; i <= T; i++) {
             st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            starts[i] = s;
            ends[i] = e;

            if (!queryMap.containsKey(s)) {
                queryMap.put(s, new ArrayList<>());
            }
            queryMap.get(s).add(i);
        }

        for (int key : queryMap.keySet()) {
            Arrays.fill(minHeight, INF);
            dijkstra(key);

            for (int index : queryMap.get(key)) {
                int ne = ends[index];
                if (minHeight[ne] == INF) answers[index] = -1;
                else answers[index] = minHeight[ne];
            }
        }

        for (int i = 1; i <= T; i++) {
            sb.append(answers[i]).append("\n");
        }

        System.out.println(sb);
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

