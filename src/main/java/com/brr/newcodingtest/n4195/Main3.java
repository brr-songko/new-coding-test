package com.brr.newcodingtest.n4195;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main3 {

    static int T, N;
    static int[] parent, cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[2 * N];
            for (int j = 0; j < 2 * N; j++) {
                parent[j] = j;
            }
            cnt = new int[2 * N];
            Arrays.fill(cnt, 1);
            Map<String, Integer> map = new HashMap<>();
            int idx = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, idx);
                    idx++;
                }
                if (!map.containsKey(b)) {
                    map.put(b, idx);
                    idx++;
                }

                if (find(map.get(a)) != find(map.get(b))) {
                    union(map.get(a), map.get(b));
                }
                sb.append(cnt[find(map.get(a))]).append("\n");
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
            cnt[na] += cnt[nb];
        }
    }
}

/*
2
3
Fred Barney
Barney Betty
Betty Wilma
3
Fred Barney
Betty Wilma
Barney Betty
 */