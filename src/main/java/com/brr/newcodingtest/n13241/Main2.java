package com.brr.newcodingtest.n13241;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long lcm = lcm(A, B);

        System.out.println(lcm);
    }

    static long lcm(long A, long B) {
        return A / gcd(A, B) * B;
    }

    static long gcd(long A, long B) {
        while (B != 0) {
            long temp = A % B;
            A = B;
            B = temp;
        }

        return A;
    }
}
