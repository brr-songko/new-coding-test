package com.brr.newcodingtest.n11286;

import java.io.*;
import java.util.*;

class Number {
    int real;
    int abs;

    public Number(int real, int abs) {
        this.real = real;
        this.abs = abs;
    }
}

public class Main2 {

    static PriorityQueue<Number> pq = new PriorityQueue<>((a, b) -> {
        if (a.abs != b.abs) return a.abs - b.abs;
        return a.real - b.real;
    });
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.offer(new Number(x, Math.abs(x)));
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll().real).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}

/*
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0

-1
1
0
-1
-1
1
1
-2
2
0
 */
