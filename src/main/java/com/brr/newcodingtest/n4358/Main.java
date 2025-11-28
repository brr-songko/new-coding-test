package com.brr.newcodingtest.n4358;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String s;
        double total = 0;

        while ((s = br.readLine()) != null) {
            map.put(s, map.getOrDefault(s, 0.0) + 1);
            total++;
        }
//        for (int i = 0; i < 29; i++) {
//            s = br.readLine();
//            map.put(s, map.getOrDefault(s, 0.0) + 1);
//            total++;
//        }

        for (String key : map.keySet()) {
            map.put(key, (map.get(key) / total) * 100);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            sb.append(key).append(" ").append(String.format("%.4f", map.get(key))).append("\n");
        }

        System.out.println(sb);
    }
}
