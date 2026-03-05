package com.brr.newcodingtest.n2042;

import java.io.*;
import java.util.*;

public class Main {

    static long[] tree;
    static long[] arr;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // 값 변경
                update(1, 1, N, b, c);
            } else if (a == 2) {
                // 구간합
                long sum = query(1, 1, N, b, (int)c);
                sb.append(sum).append("\n");
            }
        }

        System.out.println(sb);

        // 사용 예시
        // 구간합: query(1, 1, N, left, right);
        // 값 변경: update(1, 1, N, index, newValue);
    }

    // 1. 트리 생성
    static long build(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        long leftSum = build(node * 2, start, mid);
        long rightSum = build(node * 2 + 1, mid + 1, end);

        return tree[node] = leftSum + rightSum;
    }

    // 2. 구간 합 구하기
    static long query(int node, int start, int end, int left, int right) {

        // 아예 범위 밖
        if (right < start || left > end) {
            return 0;
        }

        // 완전히 포함
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        long leftSum = query(node * 2, start, mid, left, right);
        long rightSum = query(node * 2 + 1, mid + 1, end, left, right);

        return leftSum + rightSum;
    }

    // 3. 값 변경 (점 업데이트)
    static void update(int node, int start, int end, int index, long newValue) {

        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, newValue);
        update(node * 2 + 1, mid + 1, end, index, newValue);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }
}
