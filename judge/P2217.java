import java.util.*;

// 2217 로프: 1<=N<=100000, 1<=중량<=10000. k개 로프를 고르면 min*k 까지 들 수 있음, 최댓값
public class P2217 implements Judge.Problem {
    public List<String[]> tests(Random rnd) {
        List<String[]> t = new ArrayList<>();
        t.add(new String[]{"example", "2\n10\n15\n"});
        t.add(new String[]{"N=1 min", "1\n1\n"});
        t.add(new String[]{"N=1 max", "1\n10000\n"});
        t.add(new String[]{"one strong rope wins", "3\n1\n1\n100\n"});
        t.add(new String[]{"all ropes win", "3\n10\n10\n11\n"});
        t.add(new String[]{"max N, all 10000 (10^9)", gen(100000, i -> 10000)});
        t.add(new String[]{"max N, all 1", gen(100000, i -> 1)});
        t.add(new String[]{"max N, descending", gen(100000, i -> Math.max(1, 10000 - i / 10))});
        t.add(new String[]{"max N, ascending", gen(100000, i -> 1 + i % 10000)});
        for (int k = 0; k < 300; k++) {
            int n = 1 + rnd.nextInt(12), max = rnd.nextBoolean() ? 5 : 10000;
            t.add(new String[]{"rand small #" + k, gen(n, i -> 1 + rnd.nextInt(max))});
        }
        for (int k = 0; k < 100; k++) {
            int n = 1 + rnd.nextInt(2000);
            t.add(new String[]{"rand mid #" + k, gen(n, i -> 1 + rnd.nextInt(10000))});
        }
        for (int k = 0; k < 5; k++) {
            t.add(new String[]{"rand large #" + k, gen(100000, i -> 1 + rnd.nextInt(10000))});
        }
        return t;
    }

    interface IntGen { int at(int i); }

    static String gen(int n, IntGen g) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 0; i < n; i++) sb.append(g.at(i)).append('\n');
        return sb.toString();
    }

    public String oracle(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int[] w = new int[n];
        for (int i = 0; i < n; i++) w[i] = Integer.parseInt(st.nextToken());
        if (n <= 12) { // 모든 부분집합: 고른 개수 * 최소 중량
            long best = 0;
            for (int mask = 1; mask < (1 << n); mask++) {
                long min = Long.MAX_VALUE;
                for (int i = 0; i < n; i++) if ((mask >> i & 1) == 1) min = Math.min(min, w[i]);
                best = Math.max(best, min * Integer.bitCount(mask));
            }
            return String.valueOf(best);
        }
        // 카운팅: 각 중량 x 에 대해 x 이상인 로프 수 * x
        long[] cnt = new long[10002];
        for (int x : w) cnt[x]++;
        long best = 0, atLeast = 0;
        for (int x = 10000; x >= 1; x--) {
            atLeast += cnt[x];
            best = Math.max(best, atLeast * x);
        }
        return String.valueOf(best);
    }
}
