package com.brr.newcodingtest.n2357;

import java.io.*;
import java.util.*;

public class Main2 {

    static long[] minTree;
    static long[] maxTree;
    static long[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        minTree = new long[4 * N];
        maxTree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        build(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            long min = queryMin(1, 1, N, left, right);
            long max = queryMax(1, 1, N, left, right);

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    static long queryMin(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Long.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(queryMin(node * 2, start, mid, left, right),
                queryMin(node * 2 + 1, mid + 1, end, left, right));
    }

    static long queryMax(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Long.MIN_VALUE;
        }

        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(queryMax(node * 2, start, mid, left, right),
                queryMax(node * 2 + 1, mid + 1, end, left, right));
    }
}
