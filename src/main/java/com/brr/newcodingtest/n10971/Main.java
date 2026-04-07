package com.brr.newcodingtest.n10971;

import java.io.*;
import java.util.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    static ArrayList<Node>[] list;
    static int N, answer;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        visited[1] = true;
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int c = map[i][j];
                if (c == 0) continue;

                list[i].add(new Node(j, c));
            }
        }

        answer = Integer.MAX_VALUE;
        dfs(1, 0, 0);

        System.out.println(answer);
    }

    static void dfs(int s, int depth, int dist) {
        if (depth == N - 1) {
            answer = Math.min(dist + map[s][1], answer);
            return;
        }

        for (int i = 0; i < list[s].size(); i++) {
            Node node = list[s].get(i);
            if (!visited[node.to]) {
                visited[node.to] = true;
                dfs(node.to, depth + 1, dist + node.cost);
                visited[node.to] = false;
            }
        }
    }
}
