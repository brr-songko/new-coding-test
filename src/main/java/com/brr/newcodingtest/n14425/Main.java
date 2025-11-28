package com.brr.newcodingtest.n14425;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, 0);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
