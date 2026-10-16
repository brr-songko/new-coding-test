package com.brr.newcodingtest.n1197;

import java.io.*;
import java.util.*;

public class Main2 {

    static int V, E, answer;
    static int[] parent, size;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        size = new int[V + 1];
        arr = new int[E][3];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }

        Arrays.sort(arr, (a, b) -> a[2] - b[2]);

        for (int i = 0; i < E; i++) {
            int[] ar = arr[i];
            int a = ar[0];
            int b = ar[1];
            int c = ar[2];

            if(find(a) != find(b)) {
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
        if(na == nb) return;

        if(size[na] < size[nb]) {
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