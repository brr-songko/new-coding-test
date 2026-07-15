package com.brr.newcodingtest.n1939;

import java.io.*;
import java.util.*;

class Island {
    int v;
    long cost;

    public Island(int v, long cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main3 {

    static int N, M, s, e;
    static ArrayList<Island>[] list;
    static boolean[] visited;
    static long max;

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
            list[a].add(new Island(b, c));
            list[b].add(new Island(a, c));
            max = Math.max(max, c);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        System.out.println(binarySearch());
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
        q.offer(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            if (v == e) return true;

            for (Island ni : list[v]) {
                int nv = ni.v;
                long nCost = ni.cost;

                if (visited[nv]) continue;
                if (nCost < mid) continue;

                q.offer(nv);
                visited[nv] = true;
            }
        }

        return false;
    }
}

/*
3 3
1 2 2
3 1 3
2 3 2
1 3

3
 */
