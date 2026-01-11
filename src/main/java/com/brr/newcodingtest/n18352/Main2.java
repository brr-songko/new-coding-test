package com.brr.newcodingtest.n18352;

import java.io.*;
import java.util.*;

class Node2 {
    int v;
    int dist;

    public Node2(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }
}

public class Main2 {
    static int N, M, K, X;
    static boolean check = true;
    static ArrayList<Node2>[] list;
    static boolean[] visited;
    static ArrayList answers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        answers = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(new Node2(e,0));
        }

        bfs(X);

        Collections.sort(answers);
        for (int i = 0; i < answers.size(); i++) {
            sb.append(answers.get(i)).append("\n");
        }

        if (check) System.out.println(-1);
        else System.out.println(sb);
    }

    static void bfs(int x) {
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(new Node2(x, 0));
        visited[x] = true;

        while (!queue.isEmpty()) {
            Node2 node = queue.poll();

            for (int i = 0; i < list[node.v].size(); i++) {
                Node2 nextNode = list[node.v].get(i);
                if (!visited[nextNode.v]) {
                    nextNode.dist += node.dist + 1;
                    if (nextNode.dist == K) {
                        check = false;
                        answers.add(nextNode.v);
                    }
                    visited[nextNode.v] = true;
                    queue.offer(nextNode);
                }
            }
        }
    }
}
