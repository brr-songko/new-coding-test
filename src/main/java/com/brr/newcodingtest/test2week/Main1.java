package com.brr.newcodingtest.test2week;

import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            int value;
            if (map.get(key) == null) value = 0;
            else value = map.get(key);

            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }
}
