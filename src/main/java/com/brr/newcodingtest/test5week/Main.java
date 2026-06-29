package com.brr.newcodingtest.test5week;

import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = binarySearch(target);

            if (index < N && A[index] == target) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int target) {
        int left = 0;
        int right = N;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (A[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

/*
5
4 1 5 2 3
5
1 3 7 9 5

1
1
0
0
1
*/