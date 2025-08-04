package com.brr.newcodingtest.n2468;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, height, max, answer;
    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, A[i][j]);
            }
        }

        for (int i = 0; i <= height; i++) {
            visited = new boolean[N][N];
            max = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && A[j][k] > i) {
                        BFS(j, k, i);
                        max++;
                    }
                }
            }
            answer = Math.max(answer, max);
        }

        System.out.println(answer);
    }

    public static void BFS(int y, int x, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1) continue;
                if (visited[ny][nx]) continue;
                if (A[ny][nx] > height) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
