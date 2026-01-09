package com.brr.newcodingtest.n2947;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (arr[0] < arr[1] && arr[1] < arr[2] && arr[2] < arr[3] && arr[3] < arr[4]) break;

            if (arr[0] > arr[1]) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
                for (int i = 0; i < 5; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            if (arr[1] > arr[2]) {
                int temp = arr[1];
                arr[1] = arr[2];
                arr[2] = temp;
                for (int i = 0; i < 5; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            if (arr[2] > arr[3]) {
                int temp = arr[2];
                arr[2] = arr[3];
                arr[3] = temp;
                for (int i = 0; i < 5; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            if (arr[3] > arr[4]) {
                int temp = arr[3];
                arr[3] = arr[4];
                arr[4] = temp;
                for (int i = 0; i < 5; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
