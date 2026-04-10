package com.brr.newcodingtest.n35289;

import java.io.*;
import java.util.*;

public class Main {

    static long A, B, C, D, E, F;
    static long x, openCnt, closeCnt, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        D = Long.parseLong(st.nextToken());
        E = Long.parseLong(st.nextToken());
        F = Long.parseLong(st.nextToken());

        openCnt = A + 2L * B;
        closeCnt = C + 2L * D;

        x = Math.min(openCnt, closeCnt);

        while (x >= 0) {
            if (possibleOpen() && possibleClose()) {
                break;
            }
            x--;
        }

        answer = 2L * E + 2L * x;
        if (x > 0) {
            answer += 2L * F;
        }

        System.out.println(answer);
    }

    static boolean possibleOpen() {
        long max = A + 2L * B;
        if (x < 0 || x > max) return false;
        if (A > 0) return true;
        return x % 2 == 0;
    }

    static boolean possibleClose() {
        long max = C + 2L * D;
        if (x < 0 || x > max) return false;
        if (C > 0) return true;
        return x % 2 == 0;
    }
}
