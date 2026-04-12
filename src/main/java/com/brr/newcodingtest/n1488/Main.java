package com.brr.newcodingtest.n1488;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long countA = Long.parseLong(st.nextToken());
        long countB = Long.parseLong(st.nextToken());
        long maxA = Long.parseLong(st.nextToken());
        long maxB = Long.parseLong(st.nextToken());

        // [1] 예외 처리
        // A를 한 글자도 쓸 수 없는 경우가 있는지 생각해보기
        // B를 한 글자도 쓸 수 없는 경우가 있는지 생각해보기
        // 힌트: 연속 허용 길이가 0이면 그 문자는 아예 못 씀
        if (maxA == 0) countA = 0;
        if (maxB == 0) countB = 0;

        // TODO

        // [2] x, y의 의미 정하기
        // x = A 블록의 개수
        // y = B 블록의 개수
        int x = 0;
        int y = 0;

        // [3] x의 최댓값 구하기
        // A 블록이 x개 있으려면:
        // 1) A 블록마다 A가 최소 1개씩 필요하다

        // 2) A 블록들 사이를 B가 끊어줘야 한다
        // 위 두 조건으로 x의 상한을 구해보기


        // long x = TODO;

        // [4] y의 최댓값 구하기
        // B 블록이 y개 있으려면:
        // 1) B 블록마다 B가 최소 1개씩 필요하다
        // 2) B 블록들 사이를 A가 끊어줘야 한다
        // 위 두 조건으로 y의 상한을 구해보기

        // long y = TODO;

        // [5] A를 실제로 최대 몇 개까지 쓸 수 있는지 구하기
        // x개의 A 블록이 있으면,
        // 각 블록에 A를 최대 maxA개까지 넣을 수 있다.
        // 즉 "A를 담을 수 있는 총 용량"을 먼저 구하고,
        // 실제 보유 개수 countA와 비교해서 더 작은 쪽을 사용한다.

        // long aUsed = TODO;

        // [6] B를 실제로 최대 몇 개까지 쓸 수 있는지 구하기
        // y개의 B 블록이 있으면,
        // 각 블록에 B를 최대 maxB개까지 넣을 수 있다.
        // 즉 "B를 담을 수 있는 총 용량"을 먼저 구하고,
        // 실제 보유 개수 countB와 비교해서 더 작은 쪽을 사용한다.

        // long bUsed = TODO;

        // [7] 최종 정답
        // 전체 문자열 길이 = 실제 사용한 A 개수 + 실제 사용한 B 개수

        // long answer = TODO;

        // [8] 출력
        // TODO
    }
}
