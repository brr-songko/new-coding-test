package com.brr.newcodingtest.n1253;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;

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
                        cnt++;
                        break;
                    } else if (now < arr[i]) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
