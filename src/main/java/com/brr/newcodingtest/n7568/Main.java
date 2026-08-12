package com.brr.newcodingtest.n7568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        for (int i = 0; i < N; i++) {
            int[] temp = list.get(i);
            int x = temp[0];
            int y = temp[1];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int[] temp2 = list.get(j);
                int x2 = temp2[0];
                int y2 = temp2[1];
                if (x < x2 && y < y2) cnt++;
            }

            int rank = cnt + 1;
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}

/*
5
55 185
58 183

88 186
60 175
46 155

2 2 1 2 5
 */
