package com.brr.newcodingtest.n7682;

import java.io.*;
import java.util.*;

public class Main {

    static char[][] map = new char[3][3];
    static int xCnt, oCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!(s = br.readLine()).equals("end")) {
            init(s);

            boolean xWin = isWin('X');
            boolean oWin = isWin('O');

            if (isValid(xWin, oWin)) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }
        }

        System.out.println(sb);
    }

    static void init(String s) {
        xCnt = 0;
        oCnt = 0;

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = s.charAt(idx++);
                if (map[i][j] == 'X') xCnt++;
                else if (map[i][j]  == 'O') oCnt++;
            }
        }
    }

    static boolean isWin(char target) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == target && map[i][1] == target && map[i][2] == target) {
                return true;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == target && map[1][i] == target && map[2][i] == target) {
                return true;
            }
        }

        // 대각선
        if (map[0][0] == target && map[1][1] == target && map[2][2] == target) {
            return true;
        }

        if (map[0][2] == target && map[1][1] == target && map[2][0] == target) {
            return true;
        }

        return false;
    }

    static boolean isValid(boolean xWin, boolean oWin) {
        // 말 개수 조건
        if (!(xCnt == oCnt || xCnt == oCnt + 1)) {
            return false;
        }

        // X와 O가 동시에 이기는 건 불가능
        if (xWin && oWin) {
            return false;
        }

        // X가 이겼으면 X가 한 번 더 많아야 함
        if (xWin) {
            if (xCnt == oCnt + 1) return true;
            else return false;
        }

        // O가 이겼으면 X와 O가 같아야 함
        if (oWin) {
            if (xCnt == oCnt) return true;
            else return false;
        }

        // 아무도 안 이겼으면 칸이 꽉 차있어야 함
        return xCnt == 5 && oCnt == 4;
    }
}
