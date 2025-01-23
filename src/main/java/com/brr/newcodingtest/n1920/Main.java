package com.brr.newcodingtest.n1920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = A.length - 1;
            boolean find = false;
            while (start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = A[midIndex];
                if (target < midValue) {
                    end = midIndex - 1;
                } else if (target > midValue) {
                    start = midIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }
}

/*
1. 아이디어
- 이진탐색
- 탐색할 리스트 정렬 필수

2. 시간복잡도
- O(MlogN) = 100,000 * 최대 (100) = 10,000,000
- 가능

3. 자료구조
- int N, M
- int[] A
- boolean find
 */