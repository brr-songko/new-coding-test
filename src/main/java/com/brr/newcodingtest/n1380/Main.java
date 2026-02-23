package com.brr.newcodingtest.n1380;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            int n = Integer.parseInt(s);
            String[] names = new String[n + 1];

            for (int i = 1; i <= n; i++) {
                names[i] = br.readLine();
            }

            int[] arr = new int[n + 1];

            for (int i = 0; i < 2 * n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(st.nextToken());

                arr[number]++;
            }

            for (int i = 1; i <= arr.length; i++) {
                if (arr[i] != 2) {
                    System.out.println(num + " " + names[i]);
                    break;
                }
            }

            num++;
        }
    }
}
