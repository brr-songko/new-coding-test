package com.brr.newcodingtest.n1717;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, M;
    static int[] arr, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int div = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (div == 0) {
                union(a, b);
            } else {
                int na = find(a);
                int nb = find(b);

                if (na != nb) {
                    sb.append("NO").append("\n");
                } else {
                    sb.append("YES").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int na = find(a);
        int nb = find(b);

        if (na != nb) {
            parent[nb] = na;
        }
    }
}

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
