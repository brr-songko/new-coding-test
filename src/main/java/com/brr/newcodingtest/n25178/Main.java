package com.brr.newcodingtest.n25178;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[] vowels1 = new int[5];
        int[] vowels2 = new int[5];

        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) == 'a') {
                vowels1[0]++;
            }
            if (s2.charAt(i) == 'a') {
                vowels2[0]++;
            }
            if (s1.charAt(i) == 'e') {
                vowels1[1]++;
            }
            if (s2.charAt(i) == 'e') {
                vowels2[1]++;
            }
            if (s1.charAt(i) == 'i') {
                vowels1[2]++;
            }
            if (s2.charAt(i) == 'i') {
                vowels2[2]++;
            }
            if (s1.charAt(i) == 'o') {
                vowels1[3]++;
            }
            if (s2.charAt(i) == 'o') {
                vowels2[3]++;
            }
            if (s1.charAt(i) == 'u') {
                vowels1[4]++;
            }
            if (s2.charAt(i) == 'u') {
                vowels2[4]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (vowels1[i] != vowels2[i]) {
                System.out.println("NO");
                return;
            }
        }

        if (s1.charAt(0) != s2.charAt(0)) {
            System.out.println("NO");
            return;
        }
        if (s1.charAt(s1.length() - 1) != s2.charAt(s2.length() - 1)) {
            System.out.println("NO");
            return;
        }

        s1 = s1.replaceAll("[aeiou]", "");
        s2 = s2.replaceAll("[aeiou]", "");

        if (!s1.equals(s2)) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
