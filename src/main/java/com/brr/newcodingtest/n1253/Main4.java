package com.brr.newcodingtest.n1253;

import java.io.*;
import java.util.*;

public class Main4 {
    static Long[] arr;
    static int N, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (isGood(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean isGood(int i) {
        for (int j = 0; j < N; j++) {
            if (j == i) continue;

            long target = arr[i] - arr[j];

            int index = Arrays.binarySearch(arr, target);

            if (index < 0) continue;
            if (index == i || index == j) continue;

            return true;
        }

        return false;
    }

}
