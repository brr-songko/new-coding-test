package com.brr.newcodingtest.n14889;

import java.io.*;
import java.util.*;

public class Main {
    static int N, answer, start, link;
    static boolean[] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 99999999;
        dfs(1, 0);

        System.out.println(answer);
    }

    public static void dfs(int n, int depth) {
        if (depth == N / 2) {
            start = 0;
            link = 0;
            //스타트팀, 링크팀 합산 구하기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (visited[i] && visited[j]) {
                        start += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        link += arr[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(start - link));
            return;
        }

        for (int i = n; i <= N; i++) {
            visited[n] = true;
            dfs(i + 1, depth + 1);
            visited[n] = false;
        }
    }
}
