package com.brr.newcodingtest.n1316;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[26];
            String s = br.readLine();
            visited[s.charAt(0) - 'a'] = true;
            boolean check = true;
            for (int j = 1; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';
                if (s.charAt(j - 1) == s.charAt(j)) {
                    continue;
                } else {
                    if (visited[idx]) {
                        check = false;
                        break;
                    } else {
                        visited[idx] = true;
                    }
                }
            }

            if (check) answer++;
        }

        System.out.println(answer);
    }
}

/*
3
happy
new
year

3

4
aba
abab
abcabc
a

1
 */
