package com.brr.newcodingtest.n2805;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N;
    static long M, max, answer;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        answer = lowerBound();

        System.out.println(answer);
    }

    public static long lowerBound() {
        long left = 0;
        long right = max + 1;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (possible(mid) < M) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static long possible(long mid) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            long val = arr[i] - mid;
            if (val < 0) continue;
            sum += val;
        }

        return sum;
    }
}

/*
4 7
20 15 10 17

15

5 20
4 42 40 26 46

36
 */


/*
mid 값은 자르려고하는 높이 h
우리가 구하려는 값은 집에 가져가려는 나무 길이 M만큼 만들기
h를 높일수록 가져갈 수 있는 M이 줄어듦.
h를 낮출수록 가져갈 수 있는 M이 늘어남.
적어도 M의 나무를 가져가기 위해 자를 수 있는 높이 h의 최댓값

N = 5 M = 3
1 2 3 4 5
    O X
h를 3으로 하면
1 + 2 3가져갈 수 있음. 가능
그러니 h를 늘려
left = mid + 1

h를 4로
mid는 4
1 가져갈 수 있음. 불가능
그러니 h를 줄여
right = mid
 */
