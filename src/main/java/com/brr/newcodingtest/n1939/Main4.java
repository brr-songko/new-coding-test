package com.brr.newcodingtest.n1939;

import java.io.*;
import java.util.*;

class Island4 {
    int v;
    long cost;

    public Island4(int v, long cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main4 {

    static int N, M, s, e;
    static ArrayList<Island4>[] list;
    static long answer, max;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            list[a].add(new Island4(b, c));
            list[b].add(new Island4(a, c));
            max = Math.max(max, c);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        answer = binarySearch();

        System.out.println(answer);
    }

    public static long binarySearch() {
        long left = 0;
        long right = max + 1;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (!canGo(mid)) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static boolean canGo(long mid) {
        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while (!q.isEmpty()) {
            int v = q.poll();

            if (v == e) return true;

            for (Island4 island : list[v]) {
                int nv = island.v;
                long nCost = island.cost;

                if (nCost < mid) continue;
                if (visited[nv]) continue;

                q.offer(nv);
                visited[nv] = true;
            }
        }

        return false;
    }
}
