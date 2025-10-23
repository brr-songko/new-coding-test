package com.brr.newcodingtest.n11724;

import java.io.*;
import java.util.*;

public class Main4 {
    static int N, M, answer;
    static int[] A;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        visited = new boolean[N + 1];
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
            if (!visited[i]) {
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void DFS(int a) {
        if (visited[a]) {
            return;
        }

        visited[a] = true;

        for (int i = 0; i < list[a].size(); i++) {
            int temp = list[a].get(i);
            if (!visited[temp]) {
                DFS(temp);
            }
        }
    }
}
