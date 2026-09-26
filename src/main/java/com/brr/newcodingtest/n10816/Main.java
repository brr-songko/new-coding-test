package com.brr.newcodingtest.n10816;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> map = new HashMap<>();
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());

            int targetKey = binarySearch(n);
            if (targetKey == Integer.MAX_VALUE) {
                sb.append(0).append(" ");
            } else {
                sb.append(map.get(targetKey)).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static int binarySearch(int target) {
        int left = 0;
        int right = list.size() - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (list.get(mid) == target) {
                return list.get(mid);
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}

/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */