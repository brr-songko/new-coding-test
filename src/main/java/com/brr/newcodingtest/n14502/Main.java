package com.brr.newcodingtest.n14502;

import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> empties = new ArrayList<>();
    static int max = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    empties.add(new int[]{i, j});
                }
            }
        }

        comb(0, 0);

        System.out.println(max);
    }

    static void comb(int index, int s) {
        if (index == 3) {
            simulate();
            return;
        }

        for (int i = s; i < empties.size(); i++) {
            int[] temp = empties.get(i);
            int y = temp[0];
            int x = temp[1];

            map[y][x] = 1;
            comb(index + 1, i + 1);
            map[y][x] = 0;
        }
    }

    static void simulate() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 2) {
                    bfs(i, j, temp);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }

    static void bfs(int a, int b, int[][] tempMap) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (tempMap[ny][nx] == 1 || tempMap[ny][nx] == 2) continue;

                queue.offer(new int[]{ny, nx});
                tempMap[ny][nx] = 2;
            }
        }
    }
}
