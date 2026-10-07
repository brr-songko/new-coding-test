package com.brr.newcodingtest.n18870;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] arr, sortArr;
    static Map<Long, Integer> map = new HashMap<>();
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        sortArr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(st.nextToken());
            arr[i] = n;
            sortArr[i] = n;
            map.put(n, 0);
        }

        Arrays.sort(sortArr);
        list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long n = arr[i];

            int mid = lowerBound(n);

            sb.append(mid).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(long target) {
        int left = 0;
        int right = list.size();
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) >= target) {
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
