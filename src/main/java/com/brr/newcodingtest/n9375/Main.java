package com.brr.newcodingtest.n9375;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            int answer = 1;
            for (int val : map.values()) {
                answer *= (val + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
