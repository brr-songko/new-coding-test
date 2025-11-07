package com.brr.newcodingtest.n2606;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        dfs(1);

        System.out.println(answer - 1);
    }

    static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        answer++;
        visited[v] = true;

        for (int i = 0; i < list[v].size(); i++) {
            if (!visited[list[v].get(i)]) {
                dfs(list[v].get(i));
            }
        }
    }
}
