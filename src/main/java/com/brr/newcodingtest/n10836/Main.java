package com.brr.newcodingtest.n10836;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][M];
        for (int i = 0; i < M; i++) {
            Arrays.fill(map[i], 1);
        }
        int[] growth = new int[2 * M - 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                growth[idx] += 0;
                idx++;
            }
            for (int j = 0; j < b; j++) {
                growth[idx] += 1;
                idx++;
            }
            for (int j = 0; j < c; j++) {
                growth[idx] += 2;
                idx++;
            }
        }

        int idx = 0;
        for (int i = M - 1; i > 0; i--) {
            map[i][0] += growth[idx];
            idx++;
        }
        for (int i = 0; i < M; i++) {
            map[0][i] += growth[idx];
            idx++;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                map[i][j] = map[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
