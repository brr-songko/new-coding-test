package com.brr.newcodingtest.n1202;

import java.io.*;
import java.util.*;

class Jewel6 {
    int m;
    int v;

    public Jewel6(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main6 {

    static int N, K;
    static Jewel6[] jewels;
    static int[] bags;
    static int answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new Jewel6[N];
        bags = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel6(m, v);
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

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