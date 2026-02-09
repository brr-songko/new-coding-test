package com.brr.newcodingtest.n12763;

import java.io.*;
import java.util.*;

class Building {
    int num;
    int time;
    int cost;

    public Building(int num, int time, int cost) {
        this.num = num;
        this.time = time;
        this.cost = cost;
    }
}

public class Main {
    static int N, T, M, L;
    static ArrayList<Building>[] list;
    static Building[] buildings;
    static long[][] minCost; // [건물][누적시간] -- 건물 x에 t분으로 도착했을 때의 최소 비용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(br.readLine());
        long answer = Long.MAX_VALUE;
        list = new ArrayList[N + 1];
        buildings = new Building[N + 1];
        minCost = new long[N + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(minCost[i], Long.MAX_VALUE);
        }
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            buildings[i] = new Building(i, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new Building(e, time, cost));
            list[e].add(new Building(s, time, cost));
        }

        dijkstra();

        for (int i = 0; i <= T; i++) {
            answer = Math.min(answer, minCost[N][i]);
        }
        if (answer == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void dijkstra() {
        PriorityQueue<Building> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Building(1, 0, 0));
        minCost[1][0] = 0;

        while (!pq.isEmpty()) {
            Building cur = pq.poll();
            int curNum = cur.num;
            int curTime = cur.time;
            int curCost = cur.cost;

            for (Building next : list[curNum]) {
                int nextNum = next.num;
                int nextTime = next.time;
                int nextCost = next.cost;

                int newTime = curTime + nextTime;
                long newCost = (long) curCost + nextCost;

                if (newTime > T) continue;
                if (newCost > M) continue;

                if (newCost < minCost[nextNum][newTime]) {
                    minCost[nextNum][newTime] = newCost;
                    pq.offer(new Building(nextNum, newTime, (int)newCost));
                }
            }
        }
    }
}

