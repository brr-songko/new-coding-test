package com.brr.newcodingtest.n2468;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N, answer;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] A;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k <= 101; k++) {
            visited = new boolean[N][N];
            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] > k && !visited[i][j]) {
                        BFS(i, j, k);
                        temp++;
                    }
                    answer = Math.max(answer, temp);
                }
            }
        }

        System.out.println(answer);
    }

    static void BFS(int a, int b, int height) {
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

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (A[ny][nx] <= height) continue;
                if (visited[ny][nx]) continue;

                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }
    }
}
