package com.brr.newcodingtest.n1074;

import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c, count;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size = 1;

        for (int i = 0; i < N; i++) {
            size *= 2;
        }

        partition(r, c, size);

        System.out.println(count);
    }

    private static void partition(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 2;

        if (row < newSize && col < newSize) {
            partition(row, col, newSize);
        } else if (row < newSize && col >= newSize) {
            count += newSize * newSize;
            partition(row, col - newSize, newSize);
        } else if (row >= newSize && col < newSize) {
            count += 2 * newSize * newSize;
            partition(row - newSize, col, newSize);
        } else {
            count += 3 * newSize * newSize;
            partition(row - newSize, col - newSize, newSize);
        }
    }
}
