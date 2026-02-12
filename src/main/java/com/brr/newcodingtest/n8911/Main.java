package com.brr.newcodingtest.n8911;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int y = 0;
            int x = 0;
            int d = 0;
            int miny = 0;
            int minx = 0;
            int maxy = 0;
            int maxx = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'F') {
                    y += dy[d];
                    x += dx[d];

                } else if (s.charAt(j) == 'B') {
                    y += dy[(d + 2) % 4];
                    x += dx[(d + 2) % 4];

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

                miny = Math.min(miny, y);
                minx = Math.min(minx, x);
                maxy = Math.max(maxy, y);
                maxx = Math.max(maxx, x);
            }

            int row = maxy - miny;
            int col = maxx - minx;

            sb.append(row * col).append("\n");
        }

        System.out.println(sb);
    }
}

