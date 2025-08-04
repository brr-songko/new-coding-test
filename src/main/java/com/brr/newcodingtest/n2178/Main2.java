package com.brr.newcodingtest.n2178;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, M;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(s.substring(j-1, j));
            }
        }

        BFS(1, 1);

        System.out.println(A[N][M]);
    }

    public static void BFS(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, m});
        visited[n][m] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int nexY = y + dy[i];

                if (newX > 0 && newX <= N && nexY > 0 && nexY <= M) {
                    if (!visited[newX][nexY] && A[newX][nexY] != 0) {
                        queue.offer(new int[]{newX, nexY});
                        visited[newX][nexY] = true;
                        A[newX][nexY] = A[x][y] + 1;
                    }
                }
            }

        }
    }
}

/*
BFS

int[][] A
boolean[][] visited
dx = {-1, 0, 1, 0}
dy = {0, 1, 0, -1}

BFS(1, 1)

BFS {
    Queue<int[]> queue = linkedList
    queue.offer(new int[]{1, 1})
    visited[1][1] = true

    while(!queue.isEmpty) {
        int[] temp = queue.poll()
        int x = temp[0]
        int y = temp[1]

        if(
    }
}
 */
