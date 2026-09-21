package com.brr.newcodingtest.n2470;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[2];

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (min > Math.abs(sum)) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                min = Math.abs(sum);
            }

            if (sum == 0) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                break;
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
