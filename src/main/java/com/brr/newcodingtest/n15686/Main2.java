package com.brr.newcodingtest.n15686;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, M, answer;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> chickenHouses = new ArrayList<>();
    static int[][] targetList;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        targetList = new int[M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenHouses.add(new int[]{i, j});
                }
            }
        }

        answer = Integer.MAX_VALUE;
        solve(0, 0);

        System.out.println(answer);
    }

    public static void solve(int start, int depth) {
        if (depth == M) {
            bfs();
            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            targetList[depth] = chickenHouses.get(i);
            solve(i + 1, depth + 1);
        }
    }

    public static void bfs() {
        int[][] tempMap = map.clone();
        visited = new boolean[N][N];
        int totalDist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = tempMap[i][j];
                if (n == 2) {
                    boolean check = true;
                    for (int[] temp : targetList) {
                        int y = temp[0];
                        int x = temp[1];
                        if (y == i && x == j) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        tempMap[i][j] = 0;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int[] temp : targetList) {
            q.offer(new int[]{temp[0], temp[1], 0});
            visited[temp[0]][temp[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int dist = temp[2];

            if (map[y][x] == 1) {
                totalDist += dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;

                q.offer(new int[]{ny, nx, dist + 1});
                visited[ny][nx] = true;
            }
        }

        answer = Math.min(answer, totalDist);
    }
}
