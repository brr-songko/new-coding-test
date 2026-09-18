package com.brr.newcodingtest.n11724;

import java.io.*;
import java.util.*;

public class Main6 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
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
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int na : list[a]) {
                if (!visited[na]) {
                    visited[na] = true;
                    q.offer(na);
                }
            }
        }
    }
}

/*
6 5
1 2
2 5
5 1
3 4
4 6

2
 */
