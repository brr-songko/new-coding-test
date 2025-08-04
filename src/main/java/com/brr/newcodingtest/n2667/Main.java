package com.brr.newcodingtest.n2667;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Integer> answer;
    static int count, N;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    answer.add(count);
                    size++;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(size);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static void dfs(int y, int x) {
        if (arr[y][x] == 0) {
            return;
        }

        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (visited[ny][nx]) continue;
            if (arr[ny][nx] == 0) continue;
            dfs(ny, nx);
        }
    }
}
    /*
    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (arr[ny][nx] == 0) continue;
                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                count++;
            }
        }
    }
     */

