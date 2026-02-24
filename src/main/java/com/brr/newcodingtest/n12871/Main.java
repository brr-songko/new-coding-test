package com.brr.newcodingtest.n12871;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        long lcm = lcm(s.length(), t.length());

        StringBuilder ss = new StringBuilder();
        StringBuilder tt = new StringBuilder();

        while (ss.length() < lcm) {
            ss.append(s);
        }
        while (tt.length() < lcm) {
            tt.append(t);
        }

        if (ss.toString().equals(tt.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
