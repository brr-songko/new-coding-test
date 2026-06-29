package com.brr.newcodingtest.test6;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        int now = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, e});
        }

        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int[] meeting : list) {
            if (meeting[0] >= now) {
                now = meeting[1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}

/*
시간이 가장 짧은 애들 고르면 되려나..?
그 중에서 시작 종료 시간 겹치지 않는 애들로?

Map 같은거 활용하면 어떰?
그래서 그 key에 연결될 수 있는 데이터들 중 가장 작은거 선택하는거지
근데 그러면 0에서부터 시작했을 때 갑자기 0 6으로 가면 줴줴이얀데?
이것도 똑같이 뒤에서부터 역순으로 잡아보면 되려나?
 */

/*
N개의 회의에 대한 회의실 사용표 작성
시작시간과 끝나는 시간 주어짐
겹치지 않으면서 사용할 수 있는 최대 회의 개수
시작과 끝이 같은 회의도 존재 가능

11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

4
 */