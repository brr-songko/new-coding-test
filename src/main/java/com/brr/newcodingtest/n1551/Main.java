package com.brr.newcodingtest.n1551;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), ",");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cur = arr.clone();

        for (int i = 0; i < K; i++) {
            int[] next = new int[cur.length - 1];

            for (int j = 0; j < cur.length - 1; j++) {
                next[j] = cur[j + 1] - cur[j];
            }
            cur = next;
        }

        for (int i = 0; i < cur.length; i++) {
            sb.append(cur[i]);
            if (i < cur.length - 1) sb.append(",");
        }

        System.out.println(sb);
    }
}
