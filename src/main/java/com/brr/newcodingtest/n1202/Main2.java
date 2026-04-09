package com.brr.newcodingtest.n1202;

import java.io.*;
import java.util.*;

class Jewel {
    long M;
    long V;

    public Jewel(long M, long V) {
        this.M = M;
        this.V = V;
    }
}

public class Main2 {

    static int N, K;
    static long answer;
    static boolean[] visited;
    static long[] bags;
    static Jewel[] jewels;
    static PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bags = new long[K];
        jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new  StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(jewels, (a, b) -> (int)(a.M - b.M));
        Arrays.sort(bags);
        int j = 0;

        for (long bag : bags) {
            while (j < N && jewels[j].M <= bag) {
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
