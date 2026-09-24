package com.brr.newcodingtest.n10809;

import java.io.*;
import java.util.*;

public class Main {

    static int[] alphabet = new int[26];
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (alphabet[idx] == 0 && !visited[idx]) {
                alphabet[idx] = i;
                visited[idx] = true;
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (!visited[i]) alphabet[i] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : alphabet) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
