package com.brr.newcodingtest.n3028;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            if (i == 0) arr[i] = 1;
            else arr[i] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            } else if (s.charAt(i) == 'B') {
                int temp = arr[1];
                arr[1] = arr[2];
                arr[2] = temp;
            } else {
                int temp = arr[0];
                arr[0] = arr[2];
                arr[2] = temp;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (arr[i] == 1) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
