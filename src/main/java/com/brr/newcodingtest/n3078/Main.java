package com.brr.newcodingtest.n3078;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String s = arr[i];
            for (int j = i + 1; j <= i + K; j++) {
                if (j >= arr.length) break;
                if (s.length() == arr[j].length()) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
