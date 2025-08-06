package com.brr.newcodingtest.n1253;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (start == i || end == i) {
                    if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                } else {
                    int now = arr[start] + arr[end];
                    if (arr[i] == now) {
                        answer++;
                        break;
                    } else if (now < arr[i]) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
