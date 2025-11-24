package com.brr.newcodingtest.n1202;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{M, V});
        }
        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        while (!pq.isEmpty()) {
            boolean check = true;
            for (int i = 0; i < A.length; i++) {
                if (pq.peek()[0] <= A[i]) {
                    check = false;
                    answer += pq.poll()[1];
                    break;
                }
                if (check) {
                    pq.poll();
                }
            }
        }

        System.out.println(answer);
    }
}
