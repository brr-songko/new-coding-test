package com.brr.newcodingtest.n1504;

import java.io.*;
import java.util.*;

class Node3 {
    int to;
    int cost;

    public Node3(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main3 {

    static ArrayList<Node3>[] list;
    static int N, E;
    static int[] dist1, dist2, dist3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node3(b, c));
            list[b].add(new Node3(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        dist1 = new int[N + 1];
        dist2 = new int[N + 1];
        dist3 = new int[N + 1];

        dist1 = dijkstra(1);
        dist2 = dijkstra(v1);
        dist3 = dijkstra(v2);

        long min1 =(long) dist1[v1] + dist2[v2] + dist3[N];
        long min2 =(long) dist1[v2] + dist3[v1] + dist2[N];

        long answer = Math.min(min1, min2);
        if (answer >= Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    static int[] dijkstra(int s) {
        int[] temp = new int[N + 1];
        Arrays.fill(temp, Integer.MAX_VALUE);
        PriorityQueue<Node3> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node3(s, 0));
        temp[s] = 0;

        while (!pq.isEmpty()) {
            Node3 node = pq.poll();
            int now = node.to;
            int cost = node.cost;



            for (int i = 0; i < list[now].size(); i++) {
                Node3 nextNode = list[now].get(i);
                int next = nextNode.to;
                int nextCost = nextNode.cost;

                if (temp[next] > cost + nextCost) {
                    temp[next] = cost + nextCost;
                    pq.offer(new Node3(next, cost + nextCost));
                }
            }
        }

        return temp;
    }
}