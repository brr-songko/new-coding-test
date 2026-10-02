package com.brr.newcodingtest.n2217;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = 0;
        int cnt = 1;
        for (int i = N - 1; i >= 0; i--) {
            answer = Math.max(answer, arr[i] * cnt);
            cnt++;
        }

        System.out.println(answer);
    }
}
