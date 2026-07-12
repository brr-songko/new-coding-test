package com.brr.newcodingtest.임시;

import java.io.*;
import java.util.*;

class Belt {
    int nae;
    boolean existRobot;

    public Belt(int nae) {
        this.nae = nae;
        this.existRobot = false;
    }
}

public class Temp {

    static Belt[] belts;
    static int N, K, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belts = new Belt[2 * N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            belts[i] = new Belt(Integer.parseInt(st.nextToken()));
        }

        while (true) {
            // 1. 벨트 회전
            rotateBelt();

            // 2. 로봇 이동
            moveRobot();

            // 3. 로봇 올리기
            setNewRobot();

            answer++;

            // 4. 종료 조건 체크
            int cnt = checkEnd();
            if (cnt >= K) break;
        }

        System.out.println(answer);
    }

    public static void rotateBelt() {
        Belt lastBelt = belts[2 * N];
        for (int i = 2 * N - 1; i >= 1; i--) {
            belts[i + 1] = belts[i];
            if (i + 1 == N && belts[i + 1].existRobot) {
                belts[i + 1].existRobot = false;
            }
        }
        belts[1] = lastBelt;
    }

    public static void moveRobot() {
        for (int i = N - 1; i >= 1; i--) {
            Belt belt = belts[i];
            Belt nextBelt = belts[i + 1];
            if (belt.existRobot) {
                if (!nextBelt.existRobot && nextBelt.nae >= 1) {
                    belt.existRobot = false;
                    nextBelt.existRobot = true;
                    nextBelt.nae -= 1;
                }
                if (i + 1 == N) {
                    nextBelt.existRobot = false;
                }
            }
        }
    }

    public static void setNewRobot() {
        if (belts[1].nae > 0) {
            belts[1].existRobot = true;
            belts[1].nae -= 1;
        }
    }

    public static int checkEnd() {
        int cnt = 0;

        for (int i = 1; i <= 2 * N; i++) {
            if (belts[i].nae == 0) cnt++;
        }

        return cnt;
    }
}

/*
3 2
1 2 1 2 1 2

2

3 6
10 10 10 10 10 10

31

4 5
10 1 10 6 3 4 8 2

24

5 8
100 99 60 80 30 20 10 89 99 100

472
 */
