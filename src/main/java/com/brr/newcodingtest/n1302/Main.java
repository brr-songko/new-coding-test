package com.brr.newcodingtest.n1302;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String maxKey = "";
        int maxValue = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            } else if (value == maxValue) {
                if (key.compareTo(maxKey) < 0) {
                    maxKey = key;
                }
            }
        }

        System.out.println(maxKey);
    }
}
