package com.brr.newcodingtest.n20546;

import java.io.*;
import java.util.*;

public class Main3 {
    static int jMoney, sMoney, jStock, sStock, jTotalMoney, sTotalMoney;
    static int[] chart = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        jMoney = n;
        sMoney = n;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            chart[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 14; i++) {
            if (jMoney >= chart[i]) {
                int stocks = jMoney / chart[i];
                jStock += stocks;
                jMoney -= chart[i] * stocks;
            }
            if (i >= 3) {
                if (chart[i - 3] < chart[i - 2] && chart[i - 2] < chart[i - 1]) {
                    sMoney += sStock * chart[i];
                    sStock = 0;
                } else if (chart[i - 3] > chart[i - 2] && chart[i - 2] > chart[i - 1]) {
                    int stocks = sMoney / chart[i];
                    if (chart[i] * stocks > sMoney) continue;
                    sStock += stocks;
                    sMoney -= chart[i] * stocks;
                }

            }
        }

        jTotalMoney = jMoney + jStock * chart[13];
        sTotalMoney = sMoney + sStock * chart[13];

        if (jTotalMoney > sTotalMoney) {
            System.out.println("BNP");
        } else if (jTotalMoney < sTotalMoney) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
