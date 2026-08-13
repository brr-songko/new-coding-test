package com.brr.newcodingtest.n14891;

import java.io.*;
import java.util.*;

class Wheel {
    int num;
    int[] details;

    public Wheel(int num, int[] details) {
        this.num = num;
        this.details = details;
    }
}

public class Main {

    static int[] rotateDir = new int[4];
    static boolean[] doRotate = new boolean[4];
    static int answer, K;
    static Wheel[] wheels = new Wheel[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            int[] temp = new int[8];
            // 0이면 N극 , 1이면 S극
            for (int j = 0; j < 8; j++) {
                temp[j] = s.charAt(j) - '0';
                wheels[i] = new Wheel(i, temp);
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
//            System.out.println("map");
//            for (int j = 0; j < 4; j++) {
//                for (int k = 0; k < 8; k++) {
//                    System.out.print(wheels[j].details[k]);
//                }
//                System.out.println();
//            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            // 현재 생각하고 있는 방법.
            // 현재 주어진 회전방향 리스트를 갱신함. int[] rotate. 오른쪽으로 총 4번 idx 옮기면서 idx 3 넘어가면 0 번으로 이동시켜줌.
            // 쨌든 그렇게 rotate 설정 시계 반시계 시계 반시계 이렇게 해줌.
            int tempDir = dir;
            for (int j = 0; j < 4; j++) {
                int idx = target + j;
                if (idx > 3) idx -= 4;
                rotateDir[idx] = tempDir;
                tempDir *= -1;
            }

//            System.out.println("rotateDir[]");
//            for (int j = 0; j < 4; j++) {
//                System.out.println(rotateDir[j]);
//            }

            // wheel.details[2] 가 오른쪽 target, wheel.details[6]이 왼쪽 target.
            // 다음 wheel을 돌면서 1번부터 i의 6과 i + 1의 2를 비교하면서 (3번만) 맞닿아 있는 부분을 체크해서 doRotate 갱신.
            // 기준바퀴 좌측으로 한 번 , 우측으로 한 번 따로따로 해야할듯?
            for (int j = target; j < 3; j++) {
                Wheel now = wheels[j];
                Wheel next = wheels[j + 1];
                if (now.details[2] == next.details[6]) {
                    break;
                } else {
                    doRotate[j] = true;
                    doRotate[j + 1] = true;
                }
            }

            for (int j = target; j > 0; j--) {
                Wheel now = wheels[j];
                Wheel next = wheels[j - 1];
                if (now.details[2] == next.details[6]) {
                    break;
                } else {
                    doRotate[j] = true;
                    doRotate[j - 1] = true;
                }
            }
//            System.out.println("doRotate[]");
//            for (int j = 0; j < 4; j++) {
//                System.out.println(doRotate[j]);
//            }

            // rotate 방향과 doRotate를 참고해서 회전을 수행.
            for (int j = 0; j < 4; j++) {
                if (doRotate[j]) {
                    int nowDir = rotateDir[j];
                    Wheel now = wheels[j];
                    // -1 이 반시계, 1이 시계
                    if (nowDir == 1) {
                        // 1 0 0 1 0 0 1 1
                        // temp = 1
                        //
                        int temp = now.details[7];
                        for (int k = 6; k >= 0; k--) {
                            now.details[k + 1] = now.details[k];
                        }
                        now.details[0] = temp;
                    } else {
                        int temp = now.details[0];
                        for (int k = 0; k < 7; k++) {
                            now.details[k] = now.details[k + 1];
                        }
                        now.details[7] = temp;
                    }
                }
            }
        }

        // 최종 점수 계산 각 0번 idx 를 보는데
        // 1번의 idx 0 이 S이면 1
        // 2번의 동일 부분은 2
        // 3번은 4
        // 4번은 8해서 최종 점수 계산
        for (int i = 0; i < 4; i++) {
            Wheel wheel = wheels[i];
            if (wheel.details[0] == 1) {
                if (i == 0) {
                    answer += 1;
                } else if (i == 1) {
                    answer += 2;
                } else if (i == 2) {
                    answer += 4;
                } else {
                    answer += 8;
                }
            }
        }

        System.out.println(answer);
    }
}

/*
10101111
01111101
11001110
00000010
2
3 -1
1 1

7

11111111
11111111
11111111
11111111
3
1 1
2 1
3 1

15

10001011
10000011
01011011
00111101
5
1 1
2 1
3 1
4 1
1 -1

6

10010011
01010011
11100011
01010101
8
1 1
2 1
3 1
4 1
1 -1
2 -1
3 -1
4 -1

5
 */