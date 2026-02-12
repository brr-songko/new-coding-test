package com.brr.newcodingtest.n25379;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long case1 = solve(arr, N, 0);
        long case2 = solve(arr, N, 1);

        System.out.println(Math.min(case1, case2));
    }

    static long solve(int[] arr, int N, int target) {
        long cost = 0;
        int targetIndex = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == target) {
                cost += i - targetIndex;
                targetIndex++;
            }
        }

        return cost;
    }
}
