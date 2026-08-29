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

    static Wheel[] wheels = new Wheel[4];
    static boolean[] doRotate = new boolean[4];
    static int[] rotateDir = new int[4];
    static int K, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            int[] details = new int[8];
            for (int j = 0; j < 8; j++) {
                details[j] = s.charAt(j) - '0';
            }
            wheels[i] = new Wheel(i, details);
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int targetDir = Integer.parseInt(st.nextToken());
            doRotate = new boolean[4];
            rotateDir = new int[4];
            doRotate[target] = true;
            rotateDir[target] = targetDir;

            // 타겟 기준 왼쪽으로 , 오른쪽으로 확인하면서 왼쪽바퀴의 2번 오른쪽 바퀴의 6번을 비교해서 같으면 회전 t 아니면 회전 x로 표시
            for (int j = target; j < 3; j++) {
                Wheel leftWheel = wheels[j];
                Wheel rightWheel = wheels[j + 1];
                if (leftWheel.details[2] != rightWheel.details[6]) {
                    doRotate[j + 1] = true;
                } else {
                    break;
                }
            }

            for (int j = target; j > 0; j--) {
                Wheel rightWheel = wheels[j];
                Wheel leftWheel = wheels[j - 1];
                if (rightWheel.details[6] != leftWheel.details[2]) {
                    doRotate[j - 1] = true;
                } else {
                    break;
                }
            }

            // rotateDir 배열은 targetDir 기준으로 1, -1 번갈아가며 갱신. 1이 시계 -1이 반시계
            for (int j = target; j < 3; j++) {
                if (rotateDir[j] == 1) {
                    rotateDir[j + 1] = -1;
                } else {
                    rotateDir[j + 1] = 1;
                }
            }

            for (int j = target; j > 0; j--) {
                if (rotateDir[j] == 1) {
                    rotateDir[j - 1] = -1;
                } else {
                    rotateDir[j - 1] = 1;
                }
            }

            // 그거 바탕으로 doRotate T 인 곳만 실제 rotate 수행, rotateDir에 따라 하는 건 잘 체크
            for (int j = 0; j < 4; j++) {
                if (doRotate[j]) {
                    if (rotateDir[j] == 1) {
                        int temp = wheels[j].details[7];
                        for (int k = 6; k >= 0; k--) {
                            wheels[j].details[k + 1] = wheels[j].details[k];
                        }
                        wheels[j].details[0] = temp;
                    } else {
                        int temp = wheels[j].details[0];
                        for (int k = 0; k < 7; k++) {
                            wheels[j].details[k] = wheels[j].details[k + 1];
                        }
                        wheels[j].details[7] = temp;
                    }
                }
            }


        }
        // 모든 rotate 끝난 후 점수 계산
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                if (wheels[i].details[0] == 1) {
                    answer += 1;
                }
            } else if (i == 1) {
                if (wheels[i].details[0] == 1) {
                    answer += 2;
                }
            } else if (i == 2) {
                if (wheels[i].details[0] == 1) {
                    answer += 4;
                }
            } else {
                if (wheels[i].details[0] == 1) {
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
