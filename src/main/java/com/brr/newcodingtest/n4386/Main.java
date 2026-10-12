package com.brr.newcodingtest.n4386;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static double answer;
    static ArrayList<double[]> list = new ArrayList<>();
    static double[][] coord;
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        size = new int[n];
        coord = new double[n][2];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            coord[i][0] = a;
            coord[i][1] = b;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double c = Math.sqrt(Math.pow(coord[i][0] - coord[j][0], 2) + Math.pow(coord[i][1] - coord[j][1], 2));
                list.add(new double[]{i, j, c});
            }
        }

        Collections.sort(list, (a, b) -> Double.compare(a[2], b[2]));

        for (double[] d : list) {
            int a = (int)d[0];
            int b = (int)d[1];
            double c = d[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += c;
            }
        }

        System.out.printf("%.2f%n", answer);
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
3
1.0 1.0
2.0 2.0
2.0 4.0

3.41
 */