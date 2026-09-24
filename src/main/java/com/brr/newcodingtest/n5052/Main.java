package com.brr.newcodingtest.n5052;

import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] sList = new String[n];
            for (int j = 0; j < n; j++) {
                sList[j] = br.readLine();
            }

            Arrays.sort(sList);

            boolean check = true;
            for (int j = 0; j < n - 1; j++) {
                if (sList[j + 1].startsWith(sList[j])) {
                    sb.append("NO").append("\n");
                    check = false;
                    break;
                }
            }

            if (check) {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }
}

/*
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346

 */
