package com.brr.newcodingtest.n1260;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int N, M, V;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        sb.append(v).append(" ");
        visited[v] = true;

        Collections.sort(A[v]);
        for (int i : A[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(" ");
            Collections.sort(A[v]);
            for (int i : A[temp]) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
