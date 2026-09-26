package com.brr.newcodingtest.n10986;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        long[] sum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        long[] cnt = new long[M];
        cnt[0] = 1;
        long answer = 0;
        for (int i = 1; i <= N; i++) {
            cnt[(int)(sum[i] % M)]++;
        }

        for (int i = 0; i < M; i++) {
            answer += cnt[i] * (cnt[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
