package com.brr.newcodingtest.n1541;

import java.io.*;
import java.util.*;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sList = s.split("-");

        int answer = 0;

        for (int i = 0; i < sList.length; i++) {
            String S = sList[i];
            String[] SList = S.split("\\+");
            int sum = 0;
            for (int j = 0; j < SList.length; j++) {
                sum += Integer.parseInt(SList[j]);
            }

            if (i == 0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}

/*
55-50+40

-35

10+20+30+40

100

00009-00009

0
 */