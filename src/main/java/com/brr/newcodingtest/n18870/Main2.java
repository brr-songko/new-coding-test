package com.brr.newcodingtest.n18870;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, M;
    static int[] arr, sortArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sortArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            sortArr[i] = n;
        }

        Arrays.sort(sortArr);

        // 정렬돼 있으니 같은 값은 붙어 있음 -> 앞 값과 다를 때만 앞쪽으로 당겨 담기
        M = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || sortArr[i] != sortArr[i - 1]) {
                sortArr[M++] = sortArr[i];
            }
        }
        // 이제 sortArr[0] ~ sortArr[M-1]이 중복 없는 정렬 배열

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(lowerBound(arr[i])).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int target) {
        int left = 0;
        int right = M; // N이 아니라 중복 제거 후 크기 M
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (sortArr[mid] >= target) {
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
2 4 -10 4 -9

6
1000 999 1000 999 1000 999
 */
