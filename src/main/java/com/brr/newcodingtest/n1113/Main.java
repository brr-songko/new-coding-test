package com.brr.newcodingtest.n1113;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int answer, N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 1; i <= 9; i++) {
            int h = i;
            visited = new boolean[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (j == 0 || k == 0 || j == N - 1 || k == M - 1) continue;
                    if (arr[j][k] <= h && !visited[j][k]) {
                        bfs(h, j, k);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int h, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        list.add(new int[]{r, c});
        boolean check = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (arr[ny][nx] > h) continue;

                if (ny == 0 || ny == N - 1 || nx == 0 || nx == M - 1) {
                    check = false;
                }

                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                list.add(new int[]{ny, nx});
            }
        }

        if (check) {
            for (int i = 0; i < list.size(); i++) {
                int y = list.get(i)[0];
                int x = list.get(i)[1];
                answer += h - arr[y][x];
                arr[y][x] = h;
            }
        }
    }
}
