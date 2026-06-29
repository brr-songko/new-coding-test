package com.brr.newcodingtest.test6;

import java.io.*;
import java.util.*;

class Jewel {
    long m;
    long v;

    public Jewel (long m, long v) {
        this.m = m;
        this.v = v;
    }
}

public class Main3 {

    static int N, K;
    static long[] bags;
    static Jewel[] jewels;
    static PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int)(b - a));
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bags = new long[K];
        jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long M = Long.parseLong(st.nextToken());
            long V = Long.parseLong(st.nextToken());

            jewels[i] = new Jewel(M, V);
        }

        for (int i = 0; i < K; i++) {
            long c = Long.parseLong(br.readLine());
            bags[i] = c;
        }

        Arrays.sort(bags);
        Arrays.sort(jewels, Comparator.comparingLong(a -> a.m));

        int j = 0;

        for (long bag : bags) {
            while (j < N && bag >= jewels[j].m) {
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

/*
2 1
5 10
100 100
11

10

3 2
1 65
5 23
2 99
10
2

164
 */