package com.brr.newcodingtest.n1697;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, K, answer;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[200001];
        visited = new boolean[200001];

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int now = temp[0];
            int time = temp[1];

            if (now == K) {
                answer = time;
            }

            int next1 = now - 1;
            int next2 = now + 1;
            int next3 = now * 2;

            if (next1 >= 0 && !visited[next1]) {
                q.offer(new int[]{next1, time + 1});
                visited[next1] = true;
            }
            if (next2 <= 100000 && !visited[next2]) {
                q.offer(new int[]{next2, time + 1});
                visited[next2] = true;
            }
            if (next3 <= 100000 && !visited[next3]) {
                q.offer(new int[]{next3, time + 1});
                visited[next3] = true;
            }
        }
    }
}
