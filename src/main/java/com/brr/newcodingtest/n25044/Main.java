package com.brr.newcodingtest.n25044;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> result = new ArrayList<>();
        int delayTime = 0;

        int[] times = {15 * 60, 18 * 60, 21 * 60};
        for (int i = 0; i <= N; i++) {

            for (int j = 0; j < 3; j++) {
                int currentTime = (i * 24 * 60) + times[j] + delayTime;

                if (currentTime >= N * 1440 && currentTime < (N + 1) * 1440) {
                    result.add(currentTime % 1440);
                }
            }
            delayTime += K;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int time : result) {
            int h = time / 60;
            int m = time % 60;
            sb.append(String.format("%02d:%02d\n", h, m));
        }

        System.out.println(sb);
    }
}
