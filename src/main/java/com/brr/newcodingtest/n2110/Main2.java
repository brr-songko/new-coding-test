package com.brr.newcodingtest.n2110;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, C;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch());
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
        int now = 0;
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[now]) >= mid) {
                now = i;
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
