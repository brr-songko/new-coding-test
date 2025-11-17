package com.brr.newcodingtest.n1753;

import java.io.*;
import java.util.*;

public class TempMain {
    static int V, E, K, answer;
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    static StringBuilder sb;
    static boolean impossibleCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
        }

        for (int i = 1; i <= V; i++) {
            if (i == K) {
                sb.append(0).append("\n");
                continue;
            }

            answer = Integer.MAX_VALUE;
            visited = new boolean[V + 1];
            dfs(K, i, 0);
            if (answer == Integer.MAX_VALUE && !visited[i]) {
                sb.append("INF").append("\n");
            } else {
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int s, int e, int total) {
        if (s == e) {
            answer = Math.min(answer, total);
            return;
        }

        visited[s] = true;

        for (int i = 0; i < list[s].size(); i++) {
            if (!visited[list[s].get(i)[0]]) {
                ;dfs(list[s].get(i)[0], e, total + list[s].get(i)[1]);
                visited[list[s].get(i)[0]] = false;
            }
        }
    }
}
