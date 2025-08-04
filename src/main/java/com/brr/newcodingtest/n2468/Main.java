package com.brr.newcodingtest.n2468;

import java.io.*;
import java.util.*;

public class Main {
    static int N, count, answer;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }


        for (int k = 0; k <= maxHeight; k++) {
            visited = new boolean[N][N];
            count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > k) {
                        BFS(i, j, k);
                        count++;
                    }
                }
            }
            if (count > answer) {
                answer = count;
            }
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
                if (arr[ny][nx] > height) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
