package com.brr.newcodingtest.n4195;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, size;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        parent[ra] = rb;
        size[rb] += size[ra]; // 크기를 합치면서 갱신
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine().trim());
            // 이름(String) -> 정수 id 매핑용. union-find 자체는 그대로 정수 배열로 처리
            Map<String, Integer> idMap = new HashMap<>();
            parent = new int[2 * F];
            size = new int[2 * F];

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!idMap.containsKey(a)) {
                    int id = idMap.size();
                    idMap.put(a, id);
                    parent[id] = id;
                    size[id] = 1;
                }
                if (!idMap.containsKey(b)) {
                    int id = idMap.size();
                    idMap.put(b, id);
                    parent[id] = id;
                    size[id] = 1;
                }

                union(idMap.get(a), idMap.get(b));
                sb.append(size[find(idMap.get(a))]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
