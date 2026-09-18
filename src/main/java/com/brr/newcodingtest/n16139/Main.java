package com.brr.newcodingtest.n16139;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] sum = new int[26][s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            for (int j = 0; j < 26; j++) {
                sum[j][i] = sum[j][i - 1];
                if (j == (c - 'a')) sum[j][i] += 1;
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;

            sb.append(sum[c.charAt(0) - 'a'][r] - sum[c.charAt(0) - 'a'][l - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
