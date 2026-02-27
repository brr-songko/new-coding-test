package com.brr.newcodingtest.n2840;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] answers = new String[N];
        boolean[] alphabets = new boolean[26];
        Arrays.fill(answers, "?");

        int idx = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            idx = (idx + num) % N;

            if (answers[idx].equals("?")) {
                answers[idx] = s;
                if (alphabets[s.charAt(0) - 'A']) {
                    System.out.println("!");
                    return;
                }
                alphabets[s.charAt(0) - 'A'] = true;
            } else {
                if (!answers[idx].equals(s)) {
                    System.out.println("!");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = idx; i >= 0; i--) {
            sb.append(answers[i]);
        }
        for (int i = N - 1; i > idx; i--) {
            sb.append(answers[i]);
        }

        System.out.println(sb);
    }
}
