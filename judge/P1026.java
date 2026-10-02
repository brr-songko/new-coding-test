import java.util.*;

// 1026 보물: 1<=N<=50, 0<=A,B 원소<=100. A만 재배열해서 S = sum(A[i]*B[i]) 최솟값
public class P1026 implements Judge.Problem {
    public List<String[]> tests(Random rnd) {
        List<String[]> t = new ArrayList<>();
        t.add(new String[]{"example 1", "5\n1 1 1 6 0\n2 7 8 3 1\n"});
        t.add(new String[]{"example 2", "3\n1 1 3\n10 30 20\n"});
        t.add(new String[]{"example 3", "9\n5 15 100 31 39 0 0 3 26\n11 12 13 2 3 4 5 9 1\n"});
        t.add(new String[]{"N=1 zero", "1\n0\n0\n"});
        t.add(new String[]{"N=1 max", "1\n100\n100\n"});
        t.add(new String[]{"all zero", gen(50, i -> 0, i -> 0)});
        t.add(new String[]{"max N, all 100", gen(50, i -> 100, i -> 100)});
        t.add(new String[]{"A zero, B max", gen(50, i -> 0, i -> 100)});
        t.add(new String[]{"ascending both", gen(50, i -> i * 2, i -> i * 2)});
        t.add(new String[]{"A asc, B desc", gen(50, i -> i * 2, i -> 100 - i * 2)});
        t.add(new String[]{"half 0 half 100", gen(50, i -> i % 2 == 0 ? 0 : 100, i -> i < 25 ? 100 : 0)});
        for (int k = 0; k < 300; k++) {
            int n = 1 + rnd.nextInt(8), max = rnd.nextBoolean() ? 3 : 100;
            t.add(new String[]{"rand small #" + k, gen(n, i -> rnd.nextInt(max + 1), i -> rnd.nextInt(max + 1))});
        }
        for (int k = 0; k < 200; k++) {
            int n = 1 + rnd.nextInt(50);
            t.add(new String[]{"rand large #" + k, gen(n, i -> rnd.nextInt(101), i -> rnd.nextInt(101))});
        }
        return t;
    }

    interface IntGen { int at(int i); }

    static String gen(int n, IntGen a, IntGen b) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 0; i < n; i++) sb.append(a.at(i)).append(i + 1 < n ? " " : "\n");
        for (int i = 0; i < n; i++) sb.append(b.at(i)).append(i + 1 < n ? " " : "\n");
        return sb.toString();
    }

    public String oracle(String input) {
        Scanner sc = new Scanner(input);
        int n = sc.nextInt();
        long[] a = new long[n], b = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        for (int i = 0; i < n; i++) b[i] = sc.nextLong();
        if (n <= 8) { // A의 모든 순열 완전탐색
            long[] best = {Long.MAX_VALUE};
            permute(a, b, 0, best);
            return String.valueOf(best[0]);
        }
        return String.valueOf(hungarian(a, b));
    }

    static void permute(long[] a, long[] b, int k, long[] best) {
        if (k == a.length) {
            long s = 0;
            for (int i = 0; i < a.length; i++) s += a[i] * b[i];
            best[0] = Math.min(best[0], s);
            return;
        }
        for (int i = k; i < a.length; i++) {
            long tmp = a[k]; a[k] = a[i]; a[i] = tmp;
            permute(a, b, k + 1, best);
            tmp = a[k]; a[k] = a[i]; a[i] = tmp;
        }
    }

    // 최소 비용 할당 (헝가리안, O(n^3)): cost[i][j] = A[i]*B[j]
    static long hungarian(long[] a, long[] b) {
        int n = a.length;
        long INF = Long.MAX_VALUE / 4;
        long[] u = new long[n + 1], v = new long[n + 1];
        int[] p = new int[n + 1], way = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[0] = i;
            int j0 = 0;
            long[] minv = new long[n + 1];
            Arrays.fill(minv, INF);
            boolean[] used = new boolean[n + 1];
            do {
                used[j0] = true;
                int i0 = p[j0], j1 = 0;
                long delta = INF;
                for (int j = 1; j <= n; j++) {
                    if (used[j]) continue;
                    long cur = a[i0 - 1] * b[j - 1] - u[i0] - v[j];
                    if (cur < minv[j]) { minv[j] = cur; way[j] = j0; }
                    if (minv[j] < delta) { delta = minv[j]; j1 = j; }
                }
                for (int j = 0; j <= n; j++) {
                    if (used[j]) { u[p[j]] += delta; v[j] -= delta; }
                    else minv[j] -= delta;
                }
                j0 = j1;
            } while (p[j0] != 0);
            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }
        long s = 0;
        for (int j = 1; j <= n; j++) s += a[p[j] - 1] * b[j - 1];
        return s;
    }
}
