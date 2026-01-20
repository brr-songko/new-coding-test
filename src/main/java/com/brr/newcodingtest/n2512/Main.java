package com.brr.newcodingtest.n2512;

import java.io.*;
import java.util.*;

public class Main {
    static long max, sum, total, answer, tempMax;
    static Long[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        total = Integer.parseInt(br.readLine());

        if (sum <= total) {
            System.out.println(max);
            return;
        }

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long left = 0;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    static boolean isPossible(long mid) {
        sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                sum += mid;
            } else {
                sum += arr[i];
            }
        }

        if (sum > total) {
            return false;
        }

        return true;
    }
}
