package com.brr.newcodingtest.n2231;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, answer;
    static ArrayList<Integer>[] list = new ArrayList[1000154];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int temp = i;
            int sum = temp;
            while (temp > 0) {
                sum += (temp % 10);
                temp /= 10;
            }
            list[sum].add(i);
        }

        Collections.sort(list[N]);

        if (list[N].size() == 0) System.out.println(0);
        else {
            answer = list[N].get(0);
            System.out.println(answer);
        }
    }
}

/*
216

198
 */
