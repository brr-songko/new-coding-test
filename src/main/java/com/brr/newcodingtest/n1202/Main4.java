package com.brr.newcodingtest.n1202;

import java.io.*;
import java.util.*;

class Jewel4 {
    int m;
    int v;

    public Jewel4(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main4 {

    static int N, K;
    static Jewel4[] jewels;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    static int[] bags;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new Jewel4[N];
        bags = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel4(m, v);
        }
        Arrays.sort(jewels, (a, b) -> a.m - b.m);

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
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