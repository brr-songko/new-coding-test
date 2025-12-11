package com.brr.newcodingtest.n16401;

import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static long answer;
    static int[] arr;
    static long max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = 1;
        long right = max;
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (canDivide(mid)) left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }

    static boolean canDivide(long mid) {
        long count = 0;

        for (int i = 0; i < N; i++) {
            count += arr[i] / mid;
        }

        if (count >= M) return true;
        return false;
    }
}

