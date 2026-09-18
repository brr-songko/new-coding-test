package com.brr.newcodingtest.n1749;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            int[] colSum = new int[M + 1];
            for (int j = i; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    colSum[k] += arr[j][k];
                }
                int cur = 0;
                for (int k = 1; k <= M; k++) {
                    cur = Math.max(colSum[k], cur + colSum[k]);
                    answer = Math.max(answer, cur);
                }
            }
        }

        System.out.println(answer);
    }
}
