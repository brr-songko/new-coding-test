package com.brr.newcodingtest.n1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{temp, j});
            }


            while (!queue.isEmpty()) {
                boolean check = false;
                int[] temp = queue.poll();
                for (Iterator<int[]> iterator = queue.iterator(); iterator.hasNext();) {
                    int[] arr = iterator.next();
                    if (arr[0] > temp[0]) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    queue.offer(temp);
                } else {
                    answer++;
                    if (M == temp[1]) {
                        System.out.println(answer);
                        break;
                    }
                }
            }
        }
    }
}
