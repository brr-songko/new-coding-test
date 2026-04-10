package com.brr.newcodingtest.n1202;

import java.io.*;
import java.util.*;

class Jewel3 {
    long M;
    long V;

    public Jewel3(long M, long V) {
        this.M = M;
        this.V = V;
    }
}

public class Main3 {

    static int N, K;
    static long[] bags;
    static long answer;
    static PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int)(b - a));
    static Jewel3[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bags = new long[K];
        jewels = new Jewel3[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long M = Long.parseLong(st.nextToken());
            long V = Long.parseLong(st.nextToken());

            jewels[i] = new Jewel3(M, V);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(bags);
        Arrays.sort(jewels, (a, b) -> Long.compare(a.M, b.M));

        int j = 0;

        for (long bag : bags) {
            while (j < N && bag >= jewels[j].M) {
                pq.offer(jewels[j].V);
                j++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
