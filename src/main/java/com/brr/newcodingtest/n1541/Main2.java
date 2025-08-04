package com.brr.newcodingtest.n1541;

import java.io.*;
import java.util.*;

public class Main2 {
    static int sum = 0;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '-'){
                check = true;
                break;
            }
        }

        //-가 있다면
        if (check) {
            String[] inputArr = A.split("-");
            for (int i = 0; i < inputArr.length; i++) {
                int tempSum = calculate(inputArr[i]);
                if (i == 0){
                    sum += tempSum;
                } else {
                    sum -= tempSum;
                }
            }
        } else {
            sum = calculate(A);
        }

        System.out.println(sum);
    }

    public static int calculate(String s) {
        int result = 0;

        String[] inputArr = s.split("[+]");
        for (int i = 0; i < inputArr.length; i++) {
            result += Integer.parseInt(inputArr[i]);
        }

        return result;
    }
}

/*
식을 최소로 만들려면 빼기 뒷 값들을 다 더해주고 빼면 된다.
그러기 위해서는 - 가 있다면 -로 나눠주고 각 구역을 더한 뒤 첫 값만 + 나머지는 - 해주면 된다.
-가 없다면 전부 더하면 된다.
 */