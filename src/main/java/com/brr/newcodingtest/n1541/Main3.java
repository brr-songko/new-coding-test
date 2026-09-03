package com.brr.newcodingtest.n1541;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sList = s.split("-");
        int answer = 0;

        for (int i = 0; i < sList.length; i++) {
            String[] sList2 = sList[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < sList2.length; j++) {
                sum += Integer.parseInt(sList2[j]);
            }

            if (i == 0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
