package com.brr.newcodingtest.n3048;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        String s1 = br.readLine();
        String s2 = br.readLine();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = s1.length() - 1; i >= 0; i--) {
            sb.append(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            sb.append(s2.charAt(i));
        }

        String ts = sb.toString();
        char[] chars = ts.toCharArray();
        boolean[] check = new boolean[chars.length];
        for (int i = 0; i < s1.length(); i++) {
            check[i] = true;
        }

        int count = 0;
        while (count != T) {
            for (int i = 0; i < chars.length - 1; i++) {
                if (check[i] && !check[i + 1]) {
                    boolean temp = check[i];
                    check[i] = check[i + 1];
                    check[i + 1] = temp;

                    char tempChar = chars[i];
                    chars[i] = chars[i + 1];
                    chars[i + 1] = tempChar;

                    i++;
                }
            }

            count++;
        }

        sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }

        System.out.println(sb);
    }
}
