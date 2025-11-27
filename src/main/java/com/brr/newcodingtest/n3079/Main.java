package com.brr.newcodingtest.n3079;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, time;
    static long max, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        max = max * M;

        answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = 0;
        long right = max;
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (checkPossible(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static boolean checkPossible(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += mid/arr[i];
            if (sum >= M) return true;
        }

        return false;
    }
}
