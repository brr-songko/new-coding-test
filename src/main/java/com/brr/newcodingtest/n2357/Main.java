package com.brr.newcodingtest.n2357;

import java.io.*;
import java.util.*;

public class Main {

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
        while (M-- > 0) {
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

        // TODO 1️⃣ 리프 노드일 때 처리
        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        // TODO 2️⃣ 왼쪽, 오른쪽 자식 build 호출
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        // TODO 3️⃣ 현재 노드의 min, max 값 설정
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    static long queryMin(int node, int start, int end, int left, int right) {

        // TODO 4️⃣ 범위 밖일 때 반환값
        if (right < start || left > end) {
            return Long.MAX_VALUE;
        }

        // TODO 5️⃣ 완전히 포함될 때 반환값
        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        // TODO 6️⃣ 왼쪽, 오른쪽 재귀 호출 후 최소값 반환
        return Math.min(queryMin(node * 2, start, mid, left, right),
                queryMin(node * 2 + 1, mid + 1, end, left, right));
    }

    static long queryMax(int node, int start, int end, int left, int right) {

        // TODO 7️⃣ 범위 밖일 때 반환값
        if (right < start || left > end) {
            return Long.MIN_VALUE;
        }

        // TODO 8️⃣ 완전히 포함될 때 반환값
        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        // TODO 9️⃣ 왼쪽, 오른쪽 재귀 호출 후 최대값 반환
        return Math.max(queryMax(node * 2, start, mid, left, right),
                queryMax(node * 2 + 1, mid + 1, end, left, right));
    }
}
