package com.brr.newcodingtest.n16139;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] sum = new int[26][s.length() + 1];
        int q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[j][i] = sum[j][i - 1];
                if (j == s.charAt(i - 1) - 'a') sum[j][i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String alpha = st.nextToken();
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;

            sb.append(sum[alpha.charAt(0) - 'a'][r] - sum[alpha.charAt(0) - 'a'][l - 1]).append("\n");
        }

        System.out.println(sb);
    }
}

/*
seungjaehwang
4
a 0 5
a 0 6
a 6 10
a 7 10

0
1
2
1
 */