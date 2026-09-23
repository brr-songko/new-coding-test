package com.brr.newcodingtest.n10026;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, answer;
    static StringBuilder sb = new StringBuilder();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    answer++;
                }
            }
        }
        sb.append(answer).append(" ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        visited = new boolean[N][N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    answer++;
                }
            }
        }
        sb.append(answer);

        System.out.println(sb);
    }

    public static void bfs(int r, int c, char ch) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != ch) continue;

                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }
    }
}
