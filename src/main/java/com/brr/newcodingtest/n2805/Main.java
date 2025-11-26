package com.brr.newcodingtest.n2805;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M, answer;
    static int maxHeight = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, arr[i]);
        }

        answer = binarySearch();

        System.out.println(answer);
    }

    static int binarySearch() {
        int left = 0;
        int right = maxHeight;
        int mid;
        int answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long midValue = getMidValue(mid);
            if (M > midValue) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }

    static long getMidValue(int mid) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                sum += (arr[i] - mid);
            }
        }

        return sum;
    }
}
