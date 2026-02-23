package com.brr.newcodingtest.n15312;

import java.io.*;
import java.util.*;

public class Main {
    static int[] strokes = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        char[] cList = new char[A.length() + B.length()];
        int cIndex = 0;
        for (int i = 0; i < A.length(); i++) {
            cList[cIndex] = A.charAt(i);
            cList[cIndex + 1] = B.charAt(i);
            cIndex += 2;
        }

        int[] arr = new int[A.length() + B.length()];

        for (int i = 0; i < cList.length; i++) {
            int index = cList[i] - 'A';
            arr[i] = strokes[index];
        }

        while (arr.length > 2) {
            int[] arr2 = new int[arr.length - 1];

            for (int i = 0; i < arr.length - 1; i++) {
                arr2[i] = (arr[i] + arr[i + 1])% 10;
            }

            arr = arr2;
        }

        System.out.println(arr[0] + "" + arr[1]);
    }
}
