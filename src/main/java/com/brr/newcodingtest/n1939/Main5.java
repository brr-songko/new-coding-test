package com.brr.newcodingtest.n1939;

import java.io.*;
import java.util.*;

class Node5 {
    int v;
    long cost;

    public Node5(int v, long cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main5 {

    static ArrayList<Node5>[] list;
    static int N, M;
    static long max;
    static int s, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            list[A].add(new Node5(B, C));
            list[B].add(new Node5(A, C));

            max = Math.max(max, C);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        long answer = lowerBound();

        System.out.println(answer);
    }

    public static long lowerBound() {
        long left = 0;
        long right = max + 1;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    public static boolean check(long mid) {
        boolean[] visited = new boolean[N + 1];
        Queue<Node5> q = new LinkedList<>();
        visited[s] = true;
        q.offer(new Node5(s, 0));

        while (!q.isEmpty()) {
            Node5 node = q.poll();
            int v = node.v;

            if (v == e) return true;

            for (Node5 nextNode : list[v]) {
                int nv = nextNode.v;
                long nCost = nextNode.cost;

                if (nCost < mid) continue;
                if (visited[nv]) continue;

                q.offer(new Node5(nv, nCost));
                visited[nv] = true;
            }
        }

        return false;
    }
}

/*
3 3
1 2 2
3 1 3
2 3 2
1 3

3
 */