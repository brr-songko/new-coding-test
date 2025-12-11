package com.brr.newcodingtest.n1939;

import java.io.*;
import java.util.*;

class Node {
    int island;
    int weight;

    public Node (int island, int weight) {
        this.island = island;
        this.weight = weight;
    }
}

public class Main2 {
    static ArrayList<Node>[] list;
    static int N, M, s, e;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;

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
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
            max = Math.max(max, C);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        long answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = 0;
        long right = max;
        long mid;
        long answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            visited = new boolean[N + 1];
            if (canGo(s, mid)) {
                left = mid + 1;
                answer = mid;
            }
            else right = mid - 1;
        }

        return answer;
    }

    static boolean canGo(int start, long mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int nowIsland = queue.poll();
            for (int i = 0; i < list[nowIsland].size(); i++) {
                int nextIsland = list[nowIsland].get(i).island;
                int nextWeight = list[nowIsland].get(i).weight;

                if (nextWeight < mid) continue;
                if (visited[nextIsland]) continue;

                queue.offer(nextIsland);
                visited[nextIsland] = true;

                if (nextIsland == e) return true;
            }
        }

        return false;
    }
}
