package com.brr.newcodingtest.n2110;

import java.io.*;
import java.util.*;

public class Main3 {

    static int N, C;
    static long[] arr;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        answer = binarySearch();

        System.out.println(answer);
    }

    public static long binarySearch() {
        long left = 0;
        long right = arr[arr.length - 1] - arr[0] + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            if (!check(mid)) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static boolean check(long mid) {
        int idx = 0;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[idx] >= mid) {
                idx = i;
                cnt++;
            }
        }

        return cnt >= C;
    }
}

/*
5 3
1
2
8
4
9

3
 */
