package com.brr.newcodingtest.n2531;

import java.io.*;
import java.util.*;

public class Main {

    static int N, d, k, c, answer;
    static int[] sushi;
    static boolean[] eaten;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            eaten = new boolean[3001];
            eaten[c] = true;

            for (int j = i; j < i + k; j++) {
                int idx = j % N;
                eaten[sushi[idx]] = true;
            }

            for (int j = 0; j < eaten.length; j++) {
                if (eaten[j]) cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
