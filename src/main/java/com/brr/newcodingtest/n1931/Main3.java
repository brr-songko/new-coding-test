package com.brr.newcodingtest.n1931;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{s, e});
        }

        int answer = 1;
        int[] start = pq.poll();
        int e = start[1];

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[0] >= e) {
                e = temp[1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
