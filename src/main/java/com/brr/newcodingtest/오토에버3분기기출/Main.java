package com.brr.newcodingtest.오토에버3분기기출;

import java.io.*;
import java.util.*;

class Server {
    long totalData;
    long availableTime;

    public Server(long totalData, long availableTime) {
        this.totalData = totalData;
        this.availableTime = availableTime;
    }
}

public class Main {

    static int N, time;
    static long[] dataSize, processingTime;
    static long answer;
    // 아직 사용 불가능한 (작업 중인) 서버들 - 반납 시각 기준 최소힙
    static PriorityQueue<Server> busyServer = new PriorityQueue<>(Comparator.comparingLong(a -> a.availableTime));
    // 지금 당장 가능한 서버들 - 누적 처리량 기준 최소힙
    static PriorityQueue<Server> availableServer = new PriorityQueue<>(Comparator.comparingLong(a -> a.totalData));

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
            // 1. 사용할 수 있는 서버 중 누적 처리량이 가장 작은 서버 선택
            Server server = null;
            if (!availableServer.isEmpty()) {
                server = availableServer.poll();
            }

            // 2. 사용할 서버 없다면 새로운 서버 배정
            if (server == null) {
                Server newServer = new Server(0, 0);
                server = newServer;
            }

            server.totalData += dataSize[i];
            server.availableTime = time + processingTime[i];

            // 3. 사용중인 서버힙으로 넣어주기
            busyServer.offer(server);
            time++;

            // 4. availableTime이 time이 된 녀석들은 busy -> available로 옮겨주기
            while (!busyServer.isEmpty() && busyServer.peek().availableTime < time) {
                availableServer.offer(busyServer.poll());
            }

            answer = Math.max(answer, server.totalData);
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

/*
    server
            1       2       3       4       5
dataSize    9       10       0       0       0
time        4       5       0       0       0


nowTime     0   1   2   3
 */
