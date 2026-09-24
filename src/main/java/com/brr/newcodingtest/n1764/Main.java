package com.brr.newcodingtest.n1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        List<String> answerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                answerList.add(s);
            }
        }

        Collections.sort(answerList);

        StringBuilder sb = new StringBuilder();
        sb.append(answerList.size()).append("\n");
        for (String s : answerList) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
