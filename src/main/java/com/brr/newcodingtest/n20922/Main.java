package com.brr.newcodingtest.n20922;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;
    static int[] cnt = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int answer = 0;

        for (int right = 0; right < N; right++) {
            cnt[arr[right]]++;

            while (cnt[arr[right]] > K) {
                cnt[arr[left]]--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}
