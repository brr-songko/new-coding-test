package com.brr.newcodingtest.n10986;

import java.io.*;
import java.util.*;

public class Main4 {

    static int N, M;
    static long[] arr, sum, cnt;
    static long answer;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        sum = new long[N + 1];
        cnt = new long[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        cnt[0] = 1;
        for (int i = 1; i <= N; i++) {
            cnt[(int)(sum[i] % M)]++;
        }

        for (int i = 0; i <= M; i++) {
            answer += cnt[i] * (cnt[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
