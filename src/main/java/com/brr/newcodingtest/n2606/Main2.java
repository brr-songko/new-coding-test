package com.brr.newcodingtest.n2606;

import java.io.*;
import java.util.*;

public class Main2 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int nv : list[v]) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    answer++;
                    q.offer(nv);
                }
            }
        }
    }
}

/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7

4
 */
