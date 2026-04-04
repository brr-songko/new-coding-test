package com.brr.newcodingtest.n14889;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, answer, min;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[N + 1];
        find(1, 0);

        System.out.println(answer);
    }

    static void find(int start, int depth) {
        if (depth == N / 2) {
            min = calculate();
            answer = Math.min(answer, min);
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                find(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static int calculate() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    sum1 += map[i][j];
                } else if (!visited[i] && !visited[j]) {
                    sum2 += map[i][j];
                }
            }
        }

        return Math.abs(sum1 - sum2);
    }
}
