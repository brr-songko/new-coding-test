package com.brr.newcodingtest.n1654;

import java.io.*;
import java.util.*;

public class Main3 {

    static int K, N;
    static int[] arr;
    static long left, right, mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        long answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        left = 1;

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
        int cnt = 0;

        for (int i = 0; i < K; i++) {
            cnt += arr[i] / mid;
        }

        return cnt >= N;
    }
}
