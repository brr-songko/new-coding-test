package com.brr.newcodingtest.n2818;

import java.io.*;
import java.util.*;

public class Main {

    static long R, C;
//                       top, bottom, north, south, east, west
    static long[] dice = {1, 6, 2, 5, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // [1] 입력
        R = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        // [2] 주사위 초기 상태 설정
        // static 에서 설정 완료

        // [3] 전체 합 변수
        long answer = 0;

        // [4] 현재 행이 오른쪽 진행인지, 왼쪽 진행인지 관리
        // 첫 행은 오른쪽 시작
        boolean toRight = true;

        // [5] 모든 행을 순서대로 처리
        for (long row = 0; row < R; row++) {
            long top = dice[0];
            long bottom = dice[1];
            long north = dice[2];
            long south = dice[3];
            long east = dice[4];
            long west = dice[5];

            // [5-1] 현재 행의 시작 칸 윗면을 합에 더할지 여부 생각
            // 첫 칸도 방문 칸이므로 윗면이 합에 포함됨
            answer += dice[0];

            // [5-2] 현재 방향으로 "한 행의 나머지 이동(C-1번)" 동안 윗면 합을 주기 4를 이요해서 빠르게 계산
            // 오른쪽이면 윗면 주기 :
            // west -> bottom -> east -> top

            // 이렇게 다시
            // [5-2] 현재 행의 나머지 이동 횟수
// 힌트:
// move = C - 1
// full = move / 4  -> 주기 4가 몇 번 완전히 반복되는가
// rem  = move % 4  -> 주기에서 몇 칸이 남는가
//
// sum = top + west + bottom + east  (오른쪽 기준 주기 합)
// 또는
// sum = top + east + bottom + west  (왼쪽 기준 주기 합)
//
// 단, 시작 칸 top은 이미 answer에 더했으므로
// 추가 합에서는 "이동 후 나오는 윗면들"만 세야 함
//
// 즉 오른쪽 추가 순서:
// 1칸 후 west
// 2칸 후 bottom
// 3칸 후 east
// 4칸 후 top
//
// 왼쪽 추가 순서:
// 1칸 후 east
// 2칸 후 bottom
// 3칸 후 west
// 4칸 후 top
            long sum = west + bottom + east + top;
            long k = (C - 1) / 4L;
            answer += sum * k;
            if (toRight) {
                if (k % 4 == 1) {
                    answer += west;
                } else if (k % 4 == 2) {
                    answer += west + bottom;
                } else if (k % 4 == 3) {
                    answer += west + bottom + east;
                }
                // 왼쪽이면
                // east -> bottom -> west -> top
            } else {
                if (k % 4 == 1) {
                    answer += east;
                } else if (k % 4 == 2) {
                    answer += east + bottom;
                } else if (k % 4 == 3) {
                    answer += east + bottom + west;
                }
            }


            // 핵심 :
            // - 이동 횟수 k = C - 1
            // - 주기 4 한 묶음 합 * (k / 4)
            // - 남는 (k % 4)개는 앞에서부터 더하기

            // [5-3] 한 행 끝까지 이동한 뒤의 주사위 상태 갱신
            // (C - 1) % 4의 상태와 같음.

            // 여기도 이렇게 다시
            // [5-3] 한 행 끝까지 이동한 뒤의 주사위 상태 갱신
// 힌트:
// move = C - 1
// rem = move % 4
//
// if (toRight) rem번 rollRight()
// else rem번 rollLeft()
//
// 왜 rem번만 하면 되나?
// 같은 방향 4번 이동하면 원래 상태로 돌아오기 때문

            // [5-4] 마지막 행이면 아래로 내려가지 않음
            if (row == R - 1) break;

            // [5-5] 아래로 한 칸 이동
            // 아래 이동도 주사위 면이 바뀜
            // TODO: dice를 "아래로 1칸 굴린 상태"로 갱신

            // [5-6] 방향 반전
            // 오른쪽 -> 왼쪽
            // 왼쪽 -> 오른쪽
            // TODO
        }

        // [6] 정답 출력
        System.out.println(answer);
    }

    // ------------------------------------------------------------
    // [A] 오른쪽으로 1칸 굴리는 함수
    // 새 top, bottom, east, west, north, south가
    // 이전 어떤 면이 되는지 직접 대입
    // TODO
    static void rollRight() {
    }

    // [B] 왼쪽으로 1칸 굴리는 함수
    // TODO
    static void rollLeft() {
    }

    // [C] 아래로 1칸 굴리는 함수
    // TODO
    static void rollDown() {
    }

    // ------------------------------------------------------------
    // [D] 현재 행이 오른쪽 진행일 때,
    // "이동 C-1번 동안" 추가되는 윗면 합 계산
    //
    // 시작 칸의 top은 여기서 더하지 말고 main에서 따로 처리하는 방식 추천
    //
    // 생각 순서:
    // 1) k = C - 1
    // 2) 주기 배열 만들기: [west, bottom, east, top]
    // 3) cycleSum 계산
    // 4) cycleSum * (k / 4)
    // 5) 나머지 (k % 4)개 더하기
    //
    // TODO
    static long getRightRowSum() {
        return 0;
    }

    // [E] 현재 행이 왼쪽 진행일 때,
    // "이동 C-1번 동안" 추가되는 윗면 합 계산
    //
    // 주기 배열: [east, bottom, west, top]
    // TODO
    static long getLeftRowSum() {
        return 0;
    }

    // ------------------------------------------------------------
    // [F] 오른쪽으로 (C-1)번 이동 후의 최종 상태 반영
    //
    // 핵심:
    // 실제로는 C-1번 이동이지만,
    // 상태는 주기 4이므로 rem = (C-1) % 4 번만 굴린 것과 같음
    //
    // TODO
    static void applyRightRowEndState() {
    }

    // [G] 왼쪽으로 (C-1)번 이동 후의 최종 상태 반영
    // TODO
    static void applyLeftRowEndState() {
    }
}
