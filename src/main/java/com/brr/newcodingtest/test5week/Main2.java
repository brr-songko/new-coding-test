package com.brr.newcodingtest.test5week;

import java.io.*;
import java.util.*;

public class Main2 {

    static int K, N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = 1;
        long right = arr[K - 1];
        long mid;
        long answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    static boolean check(long mid) {
        long count = 0;

        for (long val : arr) {
            count += val / mid;
        }

        return count >= N;
    }
}

/*
mid 값은 랜선 길이

binarySearch 안에서 if 문 안의 조건 판별식
mid값으로 배열을 돌면서 나눈 몫을 sum 해서 N과 비교 N보다 크거나 같으면 true -> right = mid
false -> left = mid + 1

return left

4 11
802
743
457
539
 */