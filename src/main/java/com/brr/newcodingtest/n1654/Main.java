package com.brr.newcodingtest.n1654;

import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static long maxLength;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine().trim());
            maxLength = Math.max(maxLength, arr[i]);
        }

        long answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = 1;
        long right = maxLength;
        long mid;
        long answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long sum = getSum(mid);

            if (sum >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    static long getSum(long mid) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / mid;
        }

        return sum;
    }
}
