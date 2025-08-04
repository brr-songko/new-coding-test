package com.brr.newcodingtest.n1449;

import java.io.*;
import java.util.*;

public class Main {
    static int N, L, answer;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int range = (int)(A[0] - 0.5 + L);
        answer++;

        for (int i = 1; i < N; i++) {
            if ((int)(A[i] + 0.5) <= range) {
                continue;
            }
            range = (int)(A[i] - 0.5 + L);
            answer++;
        }

        System.out.println(answer);
    }
}
