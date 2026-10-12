package com.brr.newcodingtest.n1197;

import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static int[] parent, size;
    static ArrayList<int[]> list = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V];
        size = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.add(new int[]{A, B, C});
        }

        Collections.sort(list, (a, b) -> a[2] - b[2]);

        for (int[] now : list) {
            int a = now[0] - 1;
            int b = now[1] - 1;
            int c = now[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += c;
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
        size[na] += size[nb];
    }
}

/*
3 3
1 2 1
2 3 2
1 3 3

3
 */