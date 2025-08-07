package com.brr.newcodingtest.n1253;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N, start, end, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            start = 0;
            end = N - 1;

            while (start < end) {
                int now = arr[start] + arr[end];

                if (start == i || end == i) {
                    if (start == i) start++;
                    else if (end == i) end--;
                } else if (now == arr[i]) {
                    answer++;
                    break;
                } else {
                    if (now < arr[i]) {
                        start++;
                    } else if (now > arr[i]){
                        end--;
                    }
                }

            }
        }
        System.out.println(answer);
    }
}
