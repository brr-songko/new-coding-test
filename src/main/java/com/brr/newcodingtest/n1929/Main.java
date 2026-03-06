package com.brr.newcodingtest.n1929;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N= Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {

            if (i <= 1) continue;

            boolean prime = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                System.out.println(i);
            }
        }
    }
}
