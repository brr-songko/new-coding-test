package com.brr.newcodingtest.n1976;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < M - 1; i++) {
            if (find(arr[i]) != find(arr[i + 1])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
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
3
3
0 1 0
1 0 1
0 1 0
1 2 3

 */
