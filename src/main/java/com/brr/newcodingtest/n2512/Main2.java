package com.brr.newcodingtest.n2512;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N;
    static long M, answer, max;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        M = Long.parseLong(br.readLine());

        Arrays.sort(arr);

        answer = lowerBound();

        System.out.println(answer);
    }

    public static long lowerBound() {
        long left = 0;
        long right = max + 1;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (check(mid) > M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public static long check(long mid) {
        long sum = 0;

        for (long s : arr) {
            if (s > mid) sum += mid;
            else sum += s;
        }

        return sum;
    }
}

/*
4
120 110 140 150
485

127
 */