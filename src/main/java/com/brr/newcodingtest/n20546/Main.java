package com.brr.newcodingtest.n20546;

import java.io.*;
import java.util.*;

public class Main {
    static int jhTotal, smTotal;
    static int jhStockCnt, smStockCnt, jhCash, smCash;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        jhCash = N;
        smCash = N;
        int[] A = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 14; i++) {
            if (jhCash >= A[i]) {
                int plusCnt = jhCash / A[i];
                jhStockCnt += plusCnt;
                jhCash -= plusCnt * A[i];
            }
        }
        jhTotal = jhCash + A[13] * jhStockCnt;

        for (int i = 3; i < 14; i++) {
            if (A[i - 3] < A[i - 2] && A[i - 2] < A[i - 1]) {
                smCash += A[i] * smStockCnt;
                smStockCnt = 0;
            }
            if (A[i - 3] > A[i - 2] && A[i - 2] > A[i - 1]) {
                int plusCnt = smCash / A[i];
                smStockCnt += plusCnt;
                smCash -= plusCnt * A[i];
            }
        }
        smTotal = smCash + A[13] * smStockCnt;

        if (jhTotal == smTotal) {
            System.out.println("SAMESAME");
        } else if (jhTotal > smTotal) {
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }
}

/*
int[] A

준현
가능한 한 많이 사기
int jhTotal
int jhStockCnt
int jhCash

for {
    if (내가 가진 돈이 주가보다 크다면)
        jhStockCnt += 내가 가진 돈 / 주가
        jhCash -= (내가 가진 돈 / 주가) * 주가
}
jsTotal = A[13] * jsStockCnt + jsCash

성민
int smCash
int buyCnt 가 3이면 매수
int sellCnt 가 3이면 매도
int smStockCnt
int smTotal

for int i = 1 ~ {
    if (전날 주가보다 오늘 주가가 높다면) {
        sellCnt++
    }
    if (전날 주가보다 오늘 주가가 낮다면) {
        buyCnt++
    }

    if(sellCnt == 3) {
        현금에 그날의 주가 * 주식수 더해주기
        sellCnt랑 주식수 = 0으로
    }
    if (buyCnt == 3) {
        smStockCnt += 내가 가진 돈 / 주가
        jhCash -= (내가 가진 돈 /주가) * 주가
    }
}
smTotal = A[13] * smStockCnt + smCash

 */