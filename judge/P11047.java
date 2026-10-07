import java.util.*;

// 11047 동전 0: 1<=N<=10, 1<=K<=1e8, A1=1, A_i는 A_{i-1}의 배수, A_i<=1e6
public class P11047 implements Judge.Problem {
    public List<String[]> tests(Random rnd) {
        List<String[]> t = new ArrayList<>();
        int[] std = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000};
        t.add(new String[]{"example 1", coins(4200, std)});
        t.add(new String[]{"example 2", coins(4790, std)});
        t.add(new String[]{"N=1, K=1", coins(1, new int[]{1})});
        t.add(new String[]{"N=1, K=1e8", coins(100_000_000, new int[]{1})});
        t.add(new String[]{"K=1e8, coins up to 1e6", coins(100_000_000, new int[]{1, 10, 100, 1000, 10000, 100000, 1000000})});
        t.add(new String[]{"K=1e8-1, powers of 2", coins(99_999_999, new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512})});
        t.add(new String[]{"K smaller than most coins", coins(3, new int[]{1, 1000000})});
        t.add(new String[]{"K exactly largest coin", coins(1000000, new int[]{1, 1000, 1000000})});
        t.add(new String[]{"ratio 1 coins", coins(7, new int[]{1, 1, 1})});
        for (int k = 0; k < 400; k++) {
            int[] c = randomChain(rnd);
            int K = k < 250 ? 1 + rnd.nextInt(20000) : 1 + rnd.nextInt(100_000_000);
            t.add(new String[]{"rand #" + k, coins(K, c)});
        }
        return t;
    }

    static int[] randomChain(Random rnd) {
        int n = 1 + rnd.nextInt(10);
        int[] c = new int[n];
        c[0] = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            int m = 1 + rnd.nextInt(10);
            if ((long) c[i - 1] * m > 1_000_000) break;
            c[len++] = c[i - 1] * m;
        }
        return Arrays.copyOf(c, len);
    }

    static String coins(int K, int[] c) {
        StringBuilder sb = new StringBuilder().append(c.length).append(' ').append(K).append('\n');
        for (int x : c) sb.append(x).append('\n');
        return sb.toString();
    }

    public String oracle(String input) {
        Scanner sc = new Scanner(input);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[i] = sc.nextInt();
        if (K <= 20000) { // 그리디와 무관한 동전 교환 DP
            int[] dp = new int[K + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int v = 1; v <= K; v++)
                for (int x : c) if (x <= v && dp[v - x] != Integer.MAX_VALUE) dp[v] = Math.min(dp[v], dp[v - x] + 1);
            return String.valueOf(dp[K]);
        }
        long rem = K, cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            cnt += rem / c[i];
            rem %= c[i];
        }
        return String.valueOf(cnt);
    }
}
