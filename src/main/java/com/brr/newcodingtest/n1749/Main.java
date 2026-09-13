package com.brr.newcodingtest.n1749;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MIN_VALUE;

        // r1을 위쪽 행으로 고정
        for (int r1 = 1; r1 <= N; r1++) {
            int[] colSum = new int[M + 1];
            // r2를 아래쪽 행으로 늘려가며, r1~r2 사이 행들을 열 단위로 계속 누적
            for (int r2 = r1; r2 <= N; r2++) {
                for (int c = 1; c <= M; c++) {
                    colSum[c] += arr[r2][c];
                }
                // colSum[1..M] 안에서 최대 연속 구간 합 = 카데인 알고리즘
                // (이게 c1,c2를 고르는 부분을 대신함 - 전부 대입해보지 않음)
                int cur = 0;
                for (int c = 1; c <= M; c++) {
                    cur = Math.max(colSum[c], cur + colSum[c]);
                    answer = Math.max(answer, cur);
                }
            }
        }

        System.out.println(answer);
    }
}

/*
3 5
2 3 -21 -2 -23
5 6 -22 -23 -25
-22 -23 4 10 2

16
 */
