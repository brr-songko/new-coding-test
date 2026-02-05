package com.brr.newcodingtest.n11952;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, S; // 도시 수, 도로 수, 점령 도시 개수, 위험 거리 기준
    static int p, q; // 안전 도시, 위험 도시 숙박 비용
    static ArrayList<Integer>[] list; // 도시 그래프
    static boolean[] isZombie; // 해당 도시가 점령 도시인지
    static boolean[] isDanger; // 해당 도시가 위험 도시인지
    static int[] cost; // 각 도시의 숙박 비용
    static int[] dist; // 좀비 도시로부터의 최단 거리

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
        isZombie = new boolean[N + 1];
        isDanger = new boolean[N + 1];
        cost = new int[N + 1];
        dist = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            int city = Integer.parseInt(br.readLine());
            queue.offer(new int[]{city, 0});
            isZombie[city] = true;
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

        bfs();
    }

    static void findDangerCities(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int city = cur[0];
            int depth = cur[1];

            if (depth == S) continue;

            for (int next : list[city]) {
                if (dist[next] != -1) {
                    dist[next] = depth + 1;
                    isDanger[next] = true;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }
    }

    static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        
    }
}
