package com.brr.newcodingtest.n13305;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long answer, minCost;
    static long[] range, fuel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        range = new long[N-1];
        fuel = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            range[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fuel[i] = Long.parseLong(st.nextToken());
        }

        answer += fuel[0] * range[0];
        minCost = fuel[0];
        for (int i = 1; i < N - 1; i++) {
            if (minCost > fuel[i]) {
                minCost = fuel[i];
            }
            answer += minCost * range[i];
        }

        System.out.println(answer);
    }
}
