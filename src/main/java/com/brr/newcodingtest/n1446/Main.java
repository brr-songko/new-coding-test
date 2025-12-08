package com.brr.newcodingtest.n1446;

import java.io.*;
import java.util.*;

class Node {
    int v;
    int dist;

    public Node(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }
}

public class Main {
    static int N, D;
    static ArrayList<Node>[] list;
    static int[] answerList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[D + 1];
        answerList = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <= D; i++) {
            answerList[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > D || b > D) continue;

            list[a].add(new Node(b, c));
        }
        for (int i = 0; i < D; i++) {
            list[i].add(new Node(i + 1, 1));
        }

        dijkstra(0);

        System.out.println(answerList[D]);
    }

    static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.dist));
        pq.offer(new Node(s, 0));
        answerList[s] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.v;
            int dist = node.dist;

            for (int i = 0; i < list[v].size(); i++) {
                int nv = list[v].get(i).v;
                int ndist = list[v].get(i).dist;

                if (nv > D) continue;

                if (answerList[nv] > dist + ndist) {
                    answerList[nv] = dist + ndist;
                    pq.offer(new Node(nv, dist + ndist));
                }
            }
        }
    }
}
