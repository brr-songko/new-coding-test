package com.brr.newcodingtest.n1012;

import java.io.*;
import java.util.*;

public class Main4 {
    static int T, N, M, K, answer;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            answer = 0;

            visited = new boolean[N][M];
            A = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                A[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[j][k] && A[j][k] == 1) {
                        bfs(j, k);
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }

    static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (A[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;

                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }
    }
}
