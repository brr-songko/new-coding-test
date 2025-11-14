package com.brr.newcodingtest.n7576;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] A;
    static boolean[][] visited;
    static boolean possibleCheck;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        possibleCheck = true;
        queue = new LinkedList<>();
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, A[i][j]);
            }
        }

        System.out.println(answer - 1);
    }


    static void bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
//                if (A[ny][nx] == -1 || A[ny][nx] == 1) continue;
                if (A[ny][nx] != 0) continue;

                A[ny][nx] = A[y][x] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }
    }
}