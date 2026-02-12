package com.brr.newcodingtest.n20365;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int rcnt = 0;
        int bcnt = 0;
        int min = 1;
        if (s.charAt(0) == 'R') {
            rcnt++;
        } else {
            bcnt++;
        }

        for (int i = 1; i < N; i++) {
            char now = s.charAt(i);
            char prev = s.charAt(i - 1);

            if (now == 'R' && prev == 'B') {
                rcnt++;
            } else if (now == 'B' && prev == 'R') {
                bcnt++;
            }

            min = Math.min(rcnt, bcnt) + 1;
        }

        System.out.println(min);
    }
}
