package com.brr.newcodingtest.n7453;

import java.io.*;
import java.util.*;

public class Main {
    static int[] A, B, C, D, AB, CD;
    static int n;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];
        AB = new int[n * n];
        CD = new int[n * n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index++] = A[i] + B[j];
            }
        }

        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                CD[index++] = C[i] + D[j];
            }
        }

        Arrays.sort(CD);

        for (int i = 0; i < AB.length; i++) {
            int upperBound = upperBinarySearch(-AB[i]);
            int lowerBound = lowerBinarySearch(-AB[i]);

            answer += upperBound - lowerBound;
        }

        System.out.println(answer);
    }

    static int upperBinarySearch(int target) {
        int left = 0;
        int right = CD.length;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (CD[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int lowerBinarySearch(int target) {
        int left = 0;
        int right = CD.length;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (CD[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

/**
 * 1. A+B 배열 생성
 * 2. C+D 배열 생성
 * 3. 정렬
 * 4. A+B 배열 값 x를 C+D 배열에서 -x값 찾음
 * 5. 정답+
 */
