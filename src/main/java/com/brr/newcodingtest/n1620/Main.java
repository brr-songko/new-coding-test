package com.brr.newcodingtest.n1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            map.put(s, i);
            map2.put(i, s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            boolean isNumber = Character.isDigit(s.charAt(0));
            if (isNumber) {
                sb.append(map2.get(Integer.parseInt(s))).append("\n");
            } else {
                sb.append(map.get(s)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
