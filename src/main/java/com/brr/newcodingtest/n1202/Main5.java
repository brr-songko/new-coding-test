package com.brr.newcodingtest.n1202;

import java.io.*;
import java.util.*;

class Jewel5 {
    long m;
    long v;

    public Jewel5(long m, long v) {
        this.m = m;
        this.v = v;
    }
}

public class Main5 {

    static long[] bags;
    static PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int)(b - a));
    static int N, K;
    static long answer;
    static Jewel5[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new Jewel5[N];
        bags = new long[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            jewels[i] = new Jewel5(m, v);
        }

        for (int i = 0; i < K; i++) {
            long bag = Long.parseLong(br.readLine());
            bags[i] = bag;
        }

        Arrays.sort(jewels, (a, b) -> (int)(a.m - b.m));
        Arrays.sort(bags);

        int j = 0;
        for (int i = 0; i < bags.length; i++) {
            while (j < N && bags[i] >= jewels[j].m) {
                pq.offer(jewels[j].v);
                j++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
