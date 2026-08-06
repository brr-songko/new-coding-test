package com.brr.newcodingtest.autoeverReal;

import java.io.*;
import java.util.*;

class Server {
    long totalData;
    long time;

    public Server() {
        this.totalData = 0;
        this.time = 0;
    }
}

public class Main {

    static PriorityQueue<Server> busyPq = new PriorityQueue<>((a, b) -> (int)(a.time - b.time));
    static PriorityQueue<Server> availablePq = new PriorityQueue<>((a, b) -> (int)(a.totalData - b.totalData));
    static int N, now;
    static long[] dataSize, processingTime;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dataSize = new long[N];
        processingTime = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dataSize[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            processingTime[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            Server server = null;
            if (!availablePq.isEmpty()) {
                server = availablePq.poll();
            }

            if (server == null) {
                server = new Server();
            }

            server.totalData += dataSize[i];
            server.time = now + processingTime[i];

            answer = Math.max(server.totalData, answer);

            busyPq.offer(server);

            while (!busyPq.isEmpty() && busyPq.peek().time <= now) {
                availablePq.offer(busyPq.poll());
            }

            now++;
        }

        System.out.println(answer);
    }
}

/*
5
5 3 7 4 6
2 1 3 1 2

11

4
10 20 30 40
5 5 5 5

40
 */
