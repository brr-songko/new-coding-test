package com.brr.newcodingtest.n1260;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N, M ,V;
    static StringBuilder sb;
    static int[] A;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        list = new ArrayList[N + 1];

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

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;


        sb.append(v).append(" ");

        for (int i = 0; i < list[v].size(); i++) {
            if (!visited[list[v].get(i)]) {
                dfs(list[v].get(i));
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(" ");

            for (int i = 0; i < list[temp].size(); i++) {
                if (visited[list[temp].get(i)]) continue;
                queue.offer(list[temp].get(i));
                visited[list[temp].get(i)] = true;
            }
        }
    }
}
