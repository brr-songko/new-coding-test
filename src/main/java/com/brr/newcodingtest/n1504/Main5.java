package com.brr.newcodingtest.n1504;

import java.io.*;
import java.util.*;

class Node5 {
    int v;
    int cost;

    public Node5(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main5 {

    static int N, E, v1, v2;
    static ArrayList<Node5>[] list;
    static int[] dist1, dist2, dist3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        dist1 = new int[N + 1];
        dist2 = new int[N + 2];
        dist3 = new int[N + 3];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node5(e, c));
            list[e].add(new Node5(s, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dist1 = dijkstra(1);
        dist2 = dijkstra(v1);
        dist3 = dijkstra(v2);

        long path1 = (long)dist1[v1] + dist2[v2] + dist3[N];
        long path2 = (long)dist1[v2] + dist3[v1] + dist2[N];

        long answer = Math.min(path1, path2);
        if (answer >= Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    static int[] dijkstra(int s) {
        int[] answerList = new int[N + 1];
        Arrays.fill(answerList, Integer.MAX_VALUE);
        PriorityQueue<Node5> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node5(s, 0));
        answerList[s] = 0;

        while (!pq.isEmpty()) {
            Node5 node = pq.poll();
            int v = node.v;
            int cost = node.cost;

            for (int i = 0; i < list[v].size(); i++) {
                Node5 nNode = list[v].get(i);
                int nv = nNode.v;
                int nCost = nNode.cost;

                if (answerList[nv] > cost + nCost) {
                    answerList[nv] = cost + nCost;
                    pq.offer(new Node5(nv, cost + nCost));
                }
            }
        }

        return answerList;
    }
}
