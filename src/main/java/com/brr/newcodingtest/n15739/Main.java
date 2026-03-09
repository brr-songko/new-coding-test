package com.brr.newcodingtest.n15739;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                arr[n]++;
            }
        }

        for (int i = 1; i <= N * N; i++) {
            if (arr[i] != 1) {
                System.out.println("FALSE");
                return;
            }
        }

        int targetSum = N * (N * N + 1) / 2;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
            if (sum != targetSum) {
                System.out.println("FALSE");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += map[j][i];
            }
            if (sum != targetSum) {
                System.out.println("FALSE");
                return;
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += map[i][i];
        }
        if (sum != targetSum) {
            System.out.println("FALSE");
            return;
        }

        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += map[N - 1 - i][i];
        }
        if (sum != targetSum) {
            System.out.println("FALSE");
            return;
        }

        System.out.println("TRUE");
    }
}
