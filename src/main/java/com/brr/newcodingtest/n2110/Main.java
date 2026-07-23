package com.brr.newcodingtest.n2110;

import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static long answer;
    static long[] arr;
    static long[] checkArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new long[N];
        checkArr = new long[C];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        answer = binarySearch();

        System.out.println(answer);
    }

    public static long binarySearch() {
        long left = 1;
        long right = 1000000001;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (!check(mid)) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static boolean check(long mid) {
        int cnt = 1;
        long last = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= mid) {
                cnt++;
                last = arr[i];
            }
        }

        return cnt >= C;
    }
}
