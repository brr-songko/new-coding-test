package com.brr.newcodingtest.n1654;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, K;
    static long right;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            right = Math.max(right, arr[i]);
        }

        long answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = 1;
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    static boolean check(long mid) {
        long cnt = 0;
        for (long l : arr) {
            cnt += l / mid;
        }

        return N <= cnt;
    }
}
