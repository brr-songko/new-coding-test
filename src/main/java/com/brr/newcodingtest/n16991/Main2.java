package com.brr.newcodingtest.n16991;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N;
    static double[][] D;
    static double[][] dp;
    static ArrayList<double[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new double[N + 1][N + 1];
        dp = new double[1 << N][N + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            list.add(new double[]{x, y});
        }
        for (double[] a : dp) {
            Arrays.fill(a, -1.0);
        }

        for (int i = 0; i < list.size(); i++) {
            double[] temp = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                double[] temp2 = list.get(j);
                double x1 = temp[0];
                double x2 = temp2[0];
                double y1 = temp[1];
                double y2 = temp2[1];
                double dx = x1 - x2;
                double dy = y1 - y2;
                double dist = Math.sqrt(dx * dx + dy * dy);
                D[i + 1][j + 1] = dist;
            }
        }

        System.out.println(solve(1, 1));
    }

    public static double solve(int mask, int cur) {
        if (mask == (1 << N) - 1) return D[cur][1];
        if (dp[mask][cur] != -1.0) return D[mask][cur];

        double best = Double.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                double result = solve(mask | bit, i);
//                if (result == Double.MAX_VALUE) continue;
                best = Math.min(best, result + D[cur][i]);
            }
        }

        return dp[mask][cur] = best;
    }
}
