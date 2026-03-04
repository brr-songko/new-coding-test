package com.brr.newcodingtest.n10545;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] keypad = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        // index 값을 누르면 value 값이 입력된다
        int[] keyInputs = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 10; i++) {
            keyInputs[i] = Integer.parseInt(st.nextToken());
        }

        String s = br.readLine();

        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int padNum = 0;
            int num = 0;

            for (int j = 2; j <= 9; j++) {
                String S = keypad[j];
                for (int k = 0; k < S.length(); k++) {
                    if (S.charAt(k) == c) {
                        padNum = j;
                        num = k + 1;
                    }
                }
            }

            for (int j = 1; j < 10; j++) {
                if (keyInputs[j] == padNum) {
                    if (lastIndex == j) {
                        sb.append("#");
                    }
                    for (int k = 0; k < num; k++) {
                        sb.append(j);
                    }

                    lastIndex = j;
                }
            }
        }

        System.out.println(sb);
     }
}
