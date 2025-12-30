package com.brr.newcodingtest.n1789;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long answer = 0;
        long sum = 0;
        long index = 1;
        while (sum + index <= S) {
            sum += index;
            index++;
            answer++;
        }

        System.out.println(answer);
    }
}
