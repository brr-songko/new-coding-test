package com.brr.newcodingtest.n1436;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int idx = 1;

        while (cnt < N) {
            if (String.valueOf(idx).contains("666")) {
                cnt++;
                if (cnt == N) break;
            }
            idx++;
        }

        System.out.println(idx);
    }
}
