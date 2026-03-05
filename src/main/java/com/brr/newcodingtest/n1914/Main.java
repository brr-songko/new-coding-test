package com.brr.newcodingtest.n1914;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger moves = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
        System.out.println(moves);

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.println(sb);
        }
    }

    static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, via);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, from, to);
    }
}
