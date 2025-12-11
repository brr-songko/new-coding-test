package com.brr.newcodingtest.n2839;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= N / 5; i++) {
            int temp = 0;
            int tempN = N;
            tempN -= i * 5;
            temp += i;

            if (tempN % 3 == 0) {
                temp += tempN / 3;
                tempN -= tempN;
            }

            if (tempN == 0) {
                answer = Math.min(answer, temp);
            }
        }
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }
}
