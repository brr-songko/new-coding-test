package com.brr.newcodingtest.n1817;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(0);
            return;
        }

        int boxCnt = 1;
        int boxSum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(st.nextToken());
            if (boxSum + w > M) {
                boxSum = 0;
                boxCnt++;
            }
            boxSum += w;
        }

        System.out.println(boxCnt);
    }
}
