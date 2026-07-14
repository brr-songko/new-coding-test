package com.brr.newcodingtest.n1102;

/*
1102 발전소
 */
import java.io.*;
import java.util.*;

public class Main {

    static int N, P;
    static int[][] D;
    static int[] dp; // dp[mask]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N][N];
        dp = new int[1 << N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(dp, -1);

        String s = br.readLine();
        int init = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') {
                init |= (1 << i);
            }
        }

        P = Integer.parseInt(br.readLine());
        int answer = solve(init);

        // 4. -1 처리 : 고를 게 아예 없는 경우 (처음부터 안 켜져 있는데 P >0 인 상황)은 이중 루프가 한번도 안돌아서 자연스럽게 INF로 남는다. 최종 출력시 값이
        // INF 근처면 -1 을 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static int solve(int mask) {
        int station = Integer.bitCount(mask);
        // 1. 종료 조건 : factory 가 이미 P 이상이면 더 고칠 필요가 없으니 추가 비용 0
        if (station >= P) return 0;
        // 2. 메모이제이션 : 이미 계산한 mask면 캐시값 반환
        if (dp[mask] != -1) return dp[mask];
        // 3. 재귀 전이 - 지금 mask 안에 있는 발전소들 중 하나를 mask 밖에 있는 발전소들 중 하나를 target으로 골라서 i로 j를 고친다를 시도.
        // 이중 반복문으로 i는 mask 안에서 j는 마스크 밖에서 모든 조합을 시도하고, cost[i][j] + solve (mask | (1 << j)) 중 최솟값 찾음.
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) continue;
            for (int j = 0; j < N; j++) {
                if ((mask & (1 << j)) != 0) continue;
                int bit = mask | (1 << j);
                int cost = D[i][j] + solve (bit);
                best = Math.min(best, cost);
            }
        }

        return dp[mask] = best;
    }
}

/*
3
0 10 11
10 0 12
12 13 0
YNN
3

21
 */