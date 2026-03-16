package com.brr.newcodingtest.n24467;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = new int[29];
        String s;
        int cnt = 0;
        int idx = 0;
        boolean check2 = true;
        boolean end = false;

        while ((s = br.readLine()) != null) {
            boolean check = true;
            int oneCnt = 0;
            int zeroCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }

            if (zeroCnt == 1) {
                idx++;
            } else if (zeroCnt == 2) {
                idx += 2;
            } else if (zeroCnt == 3) {
                idx += 3;
            } else if (zeroCnt == 4) {
                idx += 4;
                check = false;
            } else if (zeroCnt == 0) {
                idx += 5;
                check = false;
            }

            if (idx == 5) {
                idx = 19;
                check2 = false;
            } else if (idx == 10) {
                idx = 24;
            } else if (idx == 22) {
                idx = 26;
            }
            System.out.println("진행 중 idx = " + idx);

            if (check) {
                cnt++;
            }

            if (!check2) {
                if (idx == 20) {
                    cnt++;
                    end = true;
                    System.out.println("종료 idx = " + idx);
                    break;
                } else if (idx > 20) {
                    end = true;
                    System.out.println("종료 idx = " + idx);
                    break;
                }
            }

            if (idx == 29) {
                cnt++;
                end = true;
                System.out.println("종료 idx = " + idx);
                break;
            } else if (idx > 29) {
                end = true;
                System.out.println("종료 idx = " + idx);
                break;
            }
        }

        if (end && cnt <= 10) {
            System.out.println("WIN");
        } else {
            System.out.println("LOSE");
        }
    }
}
