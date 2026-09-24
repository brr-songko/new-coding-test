package com.brr.newcodingtest.n1939;

import java.io.*;
import java.util.*;

class Node2 {
    int v;
    long cost;

    public Node2(int v, long cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main3 {

    static ArrayList<Node2>[] list;
    static int N, M;
    static long answer, max;
    static int start, end;
    static boolean[] visited;
    static boolean check;

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
            list[A].add(new Node2(B, C));
            list[B].add(new Node2(A, C));
            max = Math.max(max, C);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        answer = binarySearch();

        System.out.println(answer);
    }

    public static long binarySearch() {
        long left = 0;
        long right = max + 1;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if(!isPossible(mid)) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static boolean isPossible(long mid) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (Node2 node : list[v]) {
                int nv = node.v;
                long nc = node.cost;

                if (visited[nv]) continue;
                if (nc < mid) continue;

                queue.offer(nv);
                visited[nv] = true;

                if (nv == end) return true;
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