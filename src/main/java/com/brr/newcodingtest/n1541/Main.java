package com.brr.newcodingtest.n1541;

import java.io.*;
import java.util.*;

public class Main {
    static int sum = 0;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                check = true;
                break;
            }
        }
        if (check) {
            String[] inputArr = input.split("-");

            for (int i = 0; i < inputArr.length; i++) {
                int temp = calculate(inputArr[i]);
                if (i == 0) {
                    sum += temp;
                } else {
                    sum -= temp;
                }
            }
        } else {
            sum += calculate(input);
        }

        System.out.println(sum);
    }

    public static int calculate(String input2) {
        int result = 0;

        String[] inputArr2 = input2.split("[+]");
        for (int i = 0; i < inputArr2.length; i++) {
            result += Integer.parseInt(inputArr2[i]);
        }

        return result;
    }
}

/*
1. 아이디어
- 수식을 최소로 만들기 위해서는 - 뒤 값을 가장 크게 만들면 된다.
- 즉 첫 - 가 나온 뒤 다음 - 가 나오기 전까지의 값을 다 더해주면 됨
- split("-")를 통해서 -를 기준으로 리스트를 생성한다.
- sum 변수에 0번째 값은 더하고 그 뒤의 값은 다 빼준다.
- 빼주기 위한 값은 split("+")를 통해서 리스트 생성 후 각 값을 Integer.parseInt()로 숫자로 변환 후 더해준다.
- calculate() 함수를 통해 + 관련된 데이터를 생성하는 작업을 한다.
- 본 main에서 for문을 돌며 calculate()로 나온 값을 sum에서 빼준다.

2. 시간복잡도
- O(N2) = 50 * 50 = 2500
- 가능

3. 자료구조
- int sum
 */