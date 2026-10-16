package com.brr.newcodingtest.n4386;

import java.io.*;
import java.util.*;

public class Main2 {

    static int[] parent, size;
    static int n;
    static double answer;
    static double[][] list;
    static ArrayList<double[]> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        size = new int[n];
        list = new double[n][2];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            list[i][0] = a;
            list[i][1] = b;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double y1 = list[i][0];
                double y2 = list[j][0];
                double x1 = list[i][1];
                double x2 = list[j][1];

                double length = Math.sqrt(Math.pow(y1 - y2, 2) + Math.pow(x1 - x2, 2));

                arr.add(new double[]{i, j, length});
            }
        }

        Collections.sort(arr, (a, b) -> Double.compare(a[2], b[2]));

        for (int i = 0; i < arr.size(); i++) {
            double[] doubles = arr.get(i);
            int a = (int)doubles[0];
            int b = (int)doubles[1];
            double c = doubles[2];

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