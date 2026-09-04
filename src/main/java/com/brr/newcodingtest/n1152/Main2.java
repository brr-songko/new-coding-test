package com.brr.newcodingtest.n1152;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sList = s.split(" ");
        int answer = 0;
        for (String str : sList) {
            if (str.equals("")) continue;
            answer++;
        }

        System.out.println(answer);
    }
}
