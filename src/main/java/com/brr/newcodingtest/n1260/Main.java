package com.brr.newcodingtest.n1260;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> dList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dList.add(V);
        visited = new boolean[N + 1];
        visited[V] = true;
        dfs(V);
        for (int d : dList) {
            sb.append(d).append(" ");
        }
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int v) {
        for (int i = 0; i < list[v].size(); i++) {
            int nv = list[v].get(i);
            if (!visited[nv]) {
                visited[nv] = true;
                dList.add(nv);
                dfs(nv);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(v);

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < list[a].size(); i++) {
                int na = list[a].get(i);
                if (!visited[na]) {
                    visited[na] = true;
                    answer.add(na);
                    q.offer(na);
                }
            }
        }

        for (int a : answer) {
            sb.append(a).append(" ");
        }
    }
}

/*
4 5 1
1 2
1 3
1 4
2 4
3 4

1 2 4 3
1 2 3 4
 */
