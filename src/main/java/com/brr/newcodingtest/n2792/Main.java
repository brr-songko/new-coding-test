package com.brr.newcodingtest.n2792;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long max, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long left = 1;
        long right = max;
        long answer = max;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canDivide(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean canDivide(long mid) {
        long sum = 0;

        for (int x : arr) {
            if (x % mid == 0) {
                sum += x / mid;
            } else {
                sum += x / mid + 1;
            }
        }

        return sum <= N;
    }
}
