package com.brr.newcodingtest.n2667;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int complex, cnt;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j) - '0'));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    complex++;
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        sb.append(complex).append("\n");
        for (int n : list) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = true;
        cnt = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                map[ny][nx] = 0;
                cnt++;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9
 */
