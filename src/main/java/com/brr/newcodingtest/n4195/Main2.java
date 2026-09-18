package com.brr.newcodingtest.n4195;

import java.io.*;
import java.util.*;

public class Main2 {

    static int[] parent;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            Map<String, Integer> map = new HashMap<>();
            int F = Integer.parseInt(br.readLine());
            parent = new int[2 * F];
            cnt = new int[2 * F];
            int idx = 0;
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, idx);
                    parent[idx] = idx;
                    cnt[idx]++;
                    idx++;
                }
                if (!map.containsKey(b)) {
                    map.put(b, idx);
                    parent[idx] = idx;
                    cnt[idx]++;
                    idx++;
                }

                if (find(map.get(a)) != find(map.get(b))) {
                    union(map.get(a), map.get(b));
                }

                sb.append(cnt[find(map.get(a))]).append('\n');
            }
        }
        System.out.print(sb);
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
