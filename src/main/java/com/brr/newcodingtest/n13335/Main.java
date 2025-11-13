package com.brr.newcodingtest.n13335;

import java.io.*;
import java.util.*;

public class Main {
    static int n, w, L, tw, time, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Queue<Integer> truckQueue = new LinkedList<>();
        Queue<int[]> bridgeQueue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckQueue.offer(Integer.parseInt(st.nextToken()));
        }

        while (!truckQueue.isEmpty()) {
            time++;
            if (!bridgeQueue.isEmpty() && bridgeQueue.peek()[1] == time) {
                int[] now = bridgeQueue.poll();
                tw -= now[0];
            }

            if (bridgeQueue.size() == w) {
                continue;
            }

            if (tw + truckQueue.peek() <= L) {
                int now = truckQueue.poll();
                tw += now;
                bridgeQueue.offer(new int[]{now, time + w});
            }
        }

        while (!bridgeQueue.isEmpty()) {
            time++;
            if (bridgeQueue.peek()[1] == time) {
                bridgeQueue.poll();
            }
        }

        System.out.println(time);
    }
}
