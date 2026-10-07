import java.util.*;

// 1931 회의실 배정: 1<=N<=100000, 0<=시작,끝<=2^31-1, 시작==끝 가능, 끝나는 순간 다음 회의 시작 가능
public class P1931 implements Judge.Problem {
    static final long MAX = Integer.MAX_VALUE;

    public List<String[]> tests(Random rnd) {
        List<String[]> t = new ArrayList<>();
        t.add(new String[]{"example", "11\n1 4\n3 5\n0 6\n5 7\n3 8\n5 9\n6 10\n8 11\n8 12\n2 13\n12 14\n"});
        t.add(new String[]{"N=1", "1\n0 0\n"});
        t.add(new String[]{"N=1 max", "1\n" + MAX + " " + MAX + "\n"});
        t.add(new String[]{"zero-length after same end", "2\n1 2\n2 2\n"});
        t.add(new String[]{"zero-length before same end", "2\n2 2\n1 2\n"});
        t.add(new String[]{"zero-length inside", "2\n1 3\n2 2\n"});
        t.add(new String[]{"duplicate zero-length", "3\n5 5\n5 5\n5 5\n"});
        t.add(new String[]{"duplicate intervals", "3\n1 4\n1 4\n1 4\n"});
        t.add(new String[]{"touching chain", "4\n0 1\n1 2\n2 3\n3 4\n"});
        t.add(new String[]{"0 and max", "3\n0 " + MAX + "\n0 0\n" + MAX + " " + MAX + "\n"});
        t.add(new String[]{"max N, all same", gen(100000, i -> new long[]{0, MAX})});
        t.add(new String[]{"max N, all zero-length same", gen(100000, i -> new long[]{7, 7})});
        t.add(new String[]{"max N, chain", gen(100000, i -> new long[]{i, i + 1})});
        t.add(new String[]{"max N, nested", gen(100000, i -> new long[]{i, 200000 - i})});
        t.add(new String[]{"max N, near max", gen(100000, i -> new long[]{MAX - 100000 + i, MAX})});
        for (int k = 0; k < 400; k++) {
            int n = 1 + rnd.nextInt(12), range = rnd.nextBoolean() ? 6 : 30;
            t.add(new String[]{"rand small #" + k, gen(n, i -> interval(rnd, range))});
        }
        for (int k = 0; k < 100; k++) {
            int n = 1 + rnd.nextInt(2000), range = rnd.nextBoolean() ? 100 : 1_000_000;
            t.add(new String[]{"rand mid #" + k, gen(n, i -> interval(rnd, range))});
        }
        for (int k = 0; k < 5; k++) {
            t.add(new String[]{"rand large #" + k, gen(100000, i -> {
                long a = (long) (rnd.nextDouble() * (MAX + 1)), b = (long) (rnd.nextDouble() * (MAX + 1));
                return new long[]{Math.min(a, b), Math.max(a, b)};
            })});
        }
        return t;
    }

    static long[] interval(Random rnd, int range) {
        int a = rnd.nextInt(range + 1), b = rnd.nextInt(range + 1);
        return new long[]{Math.min(a, b), Math.max(a, b)};
    }

    interface Gen { long[] at(int i); }

    static String gen(int n, Gen g) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 0; i < n; i++) {
            long[] m = g.at(i);
            sb.append(m[0]).append(' ').append(m[1]).append('\n');
        }
        return sb.toString();
    }

    public String oracle(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        long[][] m = new long[n][];
        for (int i = 0; i < n; i++) m[i] = new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
        return String.valueOf(n <= 12 ? brute(m) : dp(m));
    }

    // 모든 부분집합 중 서로 겹치지 않는 최대 크기
    static int brute(long[][] m) {
        int n = m.length, best = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                if ((mask >> i & 1) == 0) continue;
                for (int j = i + 1; j < n && ok; j++) {
                    if ((mask >> j & 1) == 0) continue;
                    ok = m[i][1] <= m[j][0] || m[j][1] <= m[i][0];
                }
            }
            if (ok) best = Math.max(best, Integer.bitCount(mask));
        }
        return best;
    }

    // 가중치 1짜리 weighted interval scheduling DP (끝,시작 순 정렬 + 이분탐색)
    static int dp(long[][] m) {
        int n = m.length;
        Arrays.sort(m, (a, b) -> a[1] != b[1] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        int[] d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = i; // j<i 중 end <= start_i 인 개수
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (m[mid][1] <= m[i][0]) lo = mid + 1;
                else hi = mid;
            }
            d[i + 1] = Math.max(d[i], 1 + d[lo]);
        }
        return d[n];
    }
}
