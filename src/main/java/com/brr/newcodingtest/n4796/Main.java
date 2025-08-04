package com.brr.newcodingtest.n4796;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0) {
                break;
            }

            int count = 0;
            count += V/P * L;
            count += Math.min(V % P, L);

            sb.append("Case ").append(index).append(": ").append(count).append("\n");
            index++;
        }

        System.out.println(sb);
    }
}
