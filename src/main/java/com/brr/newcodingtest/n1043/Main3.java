package com.brr.newcodingtest.n1043;

import java.io.*;
import java.util.*;

public class Main3 {

    static int N, M, answer;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] parent, size, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            union(0, arr[i]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int[] temp = new int[2];
            temp[0] = 2;
            int first = Integer.parseInt(st.nextToken());
            temp[1] = first;
            for (int j = 1; j < L; j++) {
                union(first, Integer.parseInt(st.nextToken()));
            }
            list.add(temp);
        }

        for (int i = 0; i < M; i++) {
            int[] temp = list.get(i);
            if (find(0) != find(temp[1])) {
                answer++;
            }
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
        size[na] += nb;
    }
}
