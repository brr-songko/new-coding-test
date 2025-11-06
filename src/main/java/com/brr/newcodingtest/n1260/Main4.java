package com.brr.newcodingtest.n1260;

import java.io.*;
import java.util.*;

public class Main4 {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int V) {
        if (visited[V]) {
            return;
        }

        sb.append(V).append(" ");
        visited[V] = true;

        for (int i = 0; i < list[V].size(); i++) {
            if (!visited[list[V].get(i)]) {
                dfs(list[V].get(i));
            }
        }
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(" ");

            for (int i = 0; i < list[temp].size(); i++) {
                if (!visited[list[temp].get(i)]) {
                    queue.offer(list[temp].get(i));
                    visited[list[temp].get(i)] = true;
                }
            }
        }
    }
}
