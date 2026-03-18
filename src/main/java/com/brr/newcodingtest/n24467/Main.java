package com.brr.newcodingtest.n24467;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int currentPos = 0; // 시작점은 0
        boolean finished = false;

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            if (line == null || finished) continue;

            // 0의 개수 파악
            int move = 0;
            for (char c : line.toCharArray()) {
                if (c == '0') move++;
            }
            if (move == 0) move = 5; // 모

            // 이동 시작 시점의 위치에 따라 경로 결정
            for (int m = 0; m < move; m++) {
                currentPos = getNext(currentPos, m == 0);
                if (currentPos == 100) { // 100은 골인 지점
                    finished = true;
                    break;
                }
            }
        }

        System.out.println(finished ? "WIN" : "LOSE");
    }

    private static int getNext(int cur, boolean isStartOfTurn) {
        // 1. 방향 전환 (이동을 시작하는 첫 칸에서만 발생)
        if (isStartOfTurn) {
            if (cur == 5) return 21;  // 5번 -> 지름길 시작
            if (cur == 10) return 26; // 10번 -> 지름길 시작
            if (cur == 23) return 28; // 중앙 -> 아래 지름길
        }

        // 2. 각 위치별 다음 칸 정의
        if (cur >= 1 && cur <= 19) return cur + 1;
        if (cur == 20) return 100; // 골인!

        // 5번에서 꺾인 경로 (21-22-23-24-25-20)
        if (cur == 21) return 22;
        if (cur == 22) return 23;
        if (cur == 23) return 24;
        if (cur == 24) return 25;
        if (cur == 25) return 20;

        // 10번에서 꺾인 경로 (26-27-23)
        if (cur == 26) return 27;
        if (cur == 27) return 23;

        // 중앙에서 꺾인 경로 (28-29-20)
        if (cur == 28) return 29;
        if (cur == 29) return 20;

        // 0(시작점)에서 출발
        if (cur == 0) return 1;

        return 100;
    }
}


//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    static int[] next = new int[33];
//    static int[] shortcut = new int[33];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int i = 0; i < 20; i++) {
//            next[i] = i + 1;
//        }
//
//        next[20] = 32;
//
//        shortcut[5] = 21;
//        shortcut[10] = 24;
//        shortcut[15] = 26;
//
//        next[21] = 22;
//        next[22] = 23;
//        next[23] = 29;
//
//        next[24] = 25;
//        next[25] = 29;
//
//        next[26] = 27;
//        next[27] = 28;
//        next[28] = 29;
//
//        next[29] = 30;
//        next[30] = 31;
//        next[31] = 20;
//
//        int pos = 0;
//        int turn = 0;
//        boolean finished = false;
//
//        String s;
//
//        while ((s = br.readLine()) != null) {
//
//            int zero = 0;
//
//            for (char c : s.toCharArray()) {
//                if (c == '0') {
//                    zero++;
//                }
//            }
//
//            int step = zero;
//
//            if (zero == 0) {
//                step = 5;
//            }
//
//            if (!finished) {
//                turn++;
//
//                pos = move(pos, step);
//
//                if (pos == 32) {
//                    finished = true;
//                }
//
//                if ((zero == 4 || zero == 0) && pos != 32) {
//                    turn--;
//                }
//            }
//        }
//
//        if (finished && turn <= 10) {
//            System.out.println("WIN");
//        } else {
//            System.out.println("LOSE");
//        }
//    }
//
//    static int move(int pos, int step) {
//        if (shortcut[pos] != 0) {
//            pos = shortcut[pos];
//            step--;
//        } else {
//            pos = next[pos];
//            step--;
//        }
//
//        while (step-- > 0 && pos != 32) {
//            pos = next[pos];
//        }
//
//        return pos;
//    }
//}
