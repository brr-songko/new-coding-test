package com.brr.newcodingtest.n9205;

import java.io.*;
import java.util.*;

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static Point[] points;
    static boolean[] visited;
    static int n;
    static boolean canGo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            points = new Point[n + 2];
            visited = new boolean[n + 2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            points[0] = new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                points[i] = new Point(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }

            st = new StringTokenizer(br.readLine());
            points[n + 1] = new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            canGo = false;
            dfs(0);

            if (canGo) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    static void dfs(int now) {
        if (canGo) return;

        if (now == n + 1) {
            canGo = true;
            return;
        }

        visited[now] = true;

        for (int i = 0; i < n + 2; i++) {
            if (!visited[i] && dist(now, i) <= 1000) {
                dfs(i);
            }
        }
    }

    static int dist(int a, int b) {
        return Math.abs(points[a].y - points[b].y) + Math.abs(points[a].x - points[b].x);
    }
}
