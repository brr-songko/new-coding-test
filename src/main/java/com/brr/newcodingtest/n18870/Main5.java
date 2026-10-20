package com.brr.newcodingtest.n18870;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main5 {

    static Map<Integer, Integer> map = new HashMap<>();
    static int N;
    static int[] arr, sortedArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int rank = 0;
        for (int i = 0; i < N; i++) {
            int n = sortedArr[i];
            if (!map.containsKey(n)) {
                map.put(n, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}

/*
5
2 4 -10 4 -9

6
1000 999 1000 999 1000 999
 */