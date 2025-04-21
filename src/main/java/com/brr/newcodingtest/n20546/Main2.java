package com.brr.newcodingtest.n20546;

import java.io.*;
import java.util.*;

public class Main2 {
    static int jMoney, sMoney, jStock, sStock, jTotal, sTotal;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        jMoney = money;
        sMoney = money;
        arr = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 14; i++) {
            calculateJMoney(i);
            if (i >= 3) {
                calculateSMoney(i);
            }
        }

        jTotal = jMoney + jStock * arr[13];
        sTotal = sMoney + sStock * arr[13];

        if (jTotal > sTotal) {
            System.out.println("BNP");
        } else if (sTotal > jTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    public static void calculateJMoney(int index) {
        if (jMoney > 0) {
            int temp = jMoney / arr[index];
            jMoney -= temp * arr[index];
            jStock += temp;
        }
    }

    public static void calculateSMoney(int index) {
        if (arr[index] > arr[index - 1] && arr[index - 1] > arr[index - 2] && arr[index - 2] > arr[index - 3]) {
            sMoney += sStock * arr[index];
            sStock = 0;
        }

        if (arr[index] < arr[index - 1] && arr[index - 1] < arr[index - 2] && arr[index - 2] < arr[index - 3]) {
            int temp = sMoney / arr[index];
            sMoney -= temp * arr[index];
            sStock += temp;
        }
    }
}
