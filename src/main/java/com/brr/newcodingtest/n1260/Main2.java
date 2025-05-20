package com.brr.newcodingtest.n1260;

import java.io.*;
import java.util.*;

public class Main2 {
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

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        sb.append(v).append(" ");
        visited[v] = true;

        for (int i = 0; i < list[v].size(); i++) {
            Collections.sort(list[v]);
            int nv = list[v].get(i);
            if (!visited[nv]) {
                dfs(nv);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        sb.append(v).append(" ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            Collections.sort(list[temp]);

            for (int i = 0; i < list[temp].size(); i++) {
                int nv = 0;
                if (visited[list[temp].get(i)]) continue;
                if (list[temp].isEmpty()) continue;
                nv = list[temp].get(i);
                queue.offer(nv);
                sb.append(nv).append(" ");
                visited[nv] = true;
            }
        }
    }
}
