package com.brr.newcodingtest.n10026;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.substring(j, j+1);
            }
        }

        visited = new boolean[N][N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        sb.append(answer).append(" ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("G")) {
                    map[i][j] = "R";
                }
            }
        }

        visited = new boolean[N][N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        sb.append(answer);

        System.out.println(sb);
    }

    static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            String color = map[y][x];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                String nColor = map[ny][nx];
                if (visited[ny][nx]) continue;
                if (!color.equals(nColor)) continue;

                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }
    }
}
