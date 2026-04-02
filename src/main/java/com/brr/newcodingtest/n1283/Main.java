package com.brr.newcodingtest.n1283;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] alphabet = new boolean[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] sList = br.readLine().split(" ");

            // 1. 단축키 지정
            boolean check = assignShortcutKey(sList);

            // 2. 단축키 지정 불가하면 그냥 출력
            if (check) {
                for (String s : sList) {
                    sb.append(s).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean assignShortcutKey(String[] sList) {
        boolean check = true;

        int cnt = 0;
        for (String s : sList) {
            String lowerS = s.toLowerCase();
            char c = lowerS.charAt(0);
            int idx = c - 'a';

            if (!alphabet[idx]) {
                alphabet[idx] = true;
                check = false;
                saveAnswer(sList, 0, cnt);
                break;
            }
            cnt++;
        }

        if (check) {
            cnt = 0;
            for (String s : sList) {
                String lowerS = s.toLowerCase();

                for (int j = 0; j < lowerS.length(); j++) {
                    char c = lowerS.charAt(j);
                    int idx = c - 'a';

                    if (!alphabet[idx]) {
                        alphabet[idx] = true;
                        saveAnswer(sList, j, cnt);
                        return false;
                    }
                }
                cnt++;
            }
        }

        return check;
    }

    static void saveAnswer(String[] sList, int idx, int sNum) {
        int cnt = 0;
        for (String s : sList) {
            for (int j = 0; j < s.length(); j++) {
                if (sNum == cnt) {
                    if (j == idx) {
                        sb.append("[");
                    }
                }

                sb.append(s.charAt(j));

                if (sNum == cnt) {
                    if (j == idx) {
                        sb.append("]");
                    }
                }
            }
            cnt++;
            sb.append(" ");
        }
        sb.append("\n");
    }
}
