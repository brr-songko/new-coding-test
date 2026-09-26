package com.brr.newcodingtest.n3273;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int answer = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                start++;
                end--;
                answer++;
            } else if (sum < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer);
    }
}
