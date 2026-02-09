package com.brr.newcodingtest.n11952;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, S; // 도시 수, 도로 수, 점령 도시 개수, 위험 거리 기준
    static int p, q; // 안전 도시, 위험 도시 숙박 비용
    static ArrayList<Integer>[] list; // 도시 그래프
    static int[] cost; // 각 도시의 숙박 비용
    static int[] dist; // 좀비 도시로부터의 최단 거리
    static long[] minCost; // 각 도시까지의 누적 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        cost = new int[N + 1];
        dist = new int[N + 1];
        minCost = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        Arrays.fill(minCost, Long.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            int city = Integer.parseInt(br.readLine());
            queue.offer(new int[]{city, 0});
            dist[city] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        findDangerCities(queue);

        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) {
                cost[i] = -1;
            } else if (dist[i] != -1 && dist[i] <= S) {
                cost[i] = q;
            } else {
                cost[i] = p;
            }
        }

        cost[N] = 0;
        dijkstra();

        if (minCost[N] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost[N]);
        }
    }

    static void findDangerCities(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int city = cur[0];
            int depth = cur[1];

            if (depth == S) continue;

            for (int next : list[city]) {
                if (dist[next] == -1) {
                    dist[next] = depth + 1;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        pq.offer(new long[]{1, 0});
        minCost[1] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int city = (int)cur[0];
            long curCost = cur[1];

            if (curCost > minCost[city]) continue;

            for (int next : list[city]) {
                if (cost[next] == -1) continue;

                long newCost = curCost + cost[next];

                if (newCost < minCost[next]) {
                    minCost[next] = newCost;
                    pq.offer(new long[]{next, newCost});
                }
            }
        }
    }
}