package com.brr.newcodingtest.n1697;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K, answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

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
            int cnt = temp[1];

            if (now == K) {
                answer = cnt;
                break;
            }

            if (now == 0) {
                if (!visited[now + 1]) {
                    q.offer(new int[]{now + 1, cnt + 1});
                    visited[now + 1] = true;
                }
            } else if (now == 100000) {
                if (!visited[now - 1]) {
                    q.offer(new int[]{now - 1, cnt + 1});
                    visited[now - 1] = true;
                }
            } else {
                if (!visited[now + 1]) {
                    q.offer(new int[]{now + 1, cnt + 1});
                    visited[now + 1] = true;
                }
                if (!visited[now - 1]) {
                    q.offer(new int[]{now - 1, cnt + 1});
                    visited[now - 1] = true;
                }
                if (now * 2 > 100000) continue;
                if (!visited[now * 2]) {
                    q.offer(new int[]{now * 2, cnt + 1});
                    visited[now * 2] = true;
                }
            }
        }
    }
}
