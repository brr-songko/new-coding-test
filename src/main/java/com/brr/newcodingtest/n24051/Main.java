package com.brr.newcodingtest.n24051;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            int loc = i - 1;
            int newItem = arr[i];

            while (1 <= loc && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                answer = arr[loc];
                cnt++;
                if (cnt == K) {
                    System.out.println(answer);
                    return;
                }
                loc--;
            }
            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
                cnt++;
                answer = newItem;
                if (cnt == K) {
                    System.out.println(answer);
                    return;
                }
            }
        }

        if (cnt < K) {
            System.out.println(-1);
        }
    }
}
