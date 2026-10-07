package com.brr.newcodingtest.n1043;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, L, answer;
    static int[] parent, size;
    static int[][] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        for (int i = 0; i < L; i++) {
            int n = Integer.parseInt(st.nextToken());

            int na = find(0);
            int nb = find(n);

            if (na != nb) {
                union(0, n);
            }
        }

        party = new int[M][51];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            party[i][0] = l;
            int first = Integer.parseInt(st.nextToken());
            party[i][1] = first;
            for (int j = 1; j < l; j++) {
                int n = Integer.parseInt(st.nextToken());
                union(first, n);
            }
        }

        for (int i = 0; i < M; i++) {
            boolean check = true;

            if (find(0) == find(party[i][1])) {
                check = false;
            }

            if (check) answer++;
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int na = find(a);
        int nb = find(b);
        if (na == nb) return;

        if (size[na] < size[nb]) {
            int t = na;
            na = nb;
            nb = t;
        }

        parent[nb] = na;
        size[na] += size[nb];
    }
}

/*
4 3
0
2 1 2
1 3
3 2 3 4

3
 */