package com.brr.newcodingtest.n1920;

import java.io.*;
import java.util.*;

public class Main3 {

    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (binarySearch(n)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        }

        System.out.println(sb);
    }

    public static boolean binarySearch  (int target) {
        int left = 0;
        int right = N - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}

/*
5
4 1 5 2 3
5
1 3 7 9 5
 */