package com.brr.newcodingtest.n8911;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            map = new int[500][500];
            String s = br.readLine();
            int y = 0;
            int x = 0;
            int d = 0;
            int miny = Integer.MAX_VALUE;
            int minx = Integer.MAX_VALUE;
            int maxy = Integer.MIN_VALUE;
            int maxx = Integer.MIN_VALUE;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'F') {
                    y += dy[d];
                    x += dx[d];

                    if (y < miny) {
                        miny = y;
                    }
                    if (y > maxy) {
                        maxy = y;
                    }
                    if (x < minx) {
                        minx = x;
                    }
                    if (x > maxx) {
                        maxx = x;
                    }
                } else if (s.charAt(j) == 'B') {
                    y += dy[(d + 2) % 4];
                    x += dx[(d + 2) % 4];

                    if (y < miny) {
                        miny = y;
                    }
                    if (y > maxy) {
                        maxy = y;
                    }
                    if (x < minx) {
                        minx = x;
                    }
                    if (x > maxx) {
                        maxx = x;
                    }
                } else if (s.charAt(j) == 'R') {
                    d++;
                    if (d > 3) {
                        d = 0;
                    }
                } else if (s.charAt(j) == 'L') {
                    d--;
                    if (d < 0) {
                        d = 3;
                    }
                }
            }

            int row = 0;
            int col = 0;
            if (miny > 0 && minx > 0) {
                
            }

            sb.append(row * col).append("\n");
        }

        System.out.println(sb);
    }
}

