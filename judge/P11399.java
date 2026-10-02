import java.util.*;

// 11399 ATM: 1<=N<=1000, 1<=P<=1000
public class P11399 implements Judge.Problem {
    public List<String[]> tests(Random rnd) {
        List<String[]> t = new ArrayList<>();
        t.add(new String[]{"example", "5\n3 1 4 3 2\n"});
        t.add(new String[]{"N=1 min", "1\n1\n"});
        t.add(new String[]{"N=1 max", "1\n1000\n"});
        t.add(new String[]{"N=2", "2\n1000 1\n"});
        t.add(new String[]{"max N, all 1000", arr(1000, i -> 1000)});
        t.add(new String[]{"max N, all 1", arr(1000, i -> 1)});
        t.add(new String[]{"max N, descending", arr(1000, i -> 1000 - i)});
        t.add(new String[]{"max N, ascending", arr(1000, i -> i + 1)});
        t.add(new String[]{"trailing space", "3\n3 1 2 \n"});
        for (int k = 0; k < 300; k++) {
            int n = 1 + rnd.nextInt(8), maxP = rnd.nextBoolean() ? 5 : 1000;
            t.add(new String[]{"rand small #" + k, arr(n, i -> 1 + rnd.nextInt(maxP))});
        }
        for (int k = 0; k < 200; k++) {
            int n = 1 + rnd.nextInt(1000);
            t.add(new String[]{"rand large #" + k, arr(n, i -> 1 + rnd.nextInt(1000))});
        }
        return t;
    }

    interface IntGen { int at(int i); }

    static String arr(int n, IntGen g) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 0; i < n; i++) sb.append(g.at(i)).append(i + 1 < n ? " " : "\n");
        return sb.toString();
    }

    public String oracle(String input) {
        Scanner sc = new Scanner(input);
        int n = sc.nextInt();
        long[] p = new long[n];
        for (int i = 0; i < n; i++) p[i] = sc.nextLong();
        if (n <= 8) { // 모든 순서 완전탐색
            long[] best = {Long.MAX_VALUE};
            permute(p, 0, best);
            return String.valueOf(best[0]);
        }
        Long[] s = new Long[n];
        for (int i = 0; i < n; i++) s[i] = p[i];
        Arrays.sort(s, Collections.reverseOrder());
        long total = 0; // 큰 값은 1번, 작은 값일수록 많이 더해짐
        for (int i = 0; i < n; i++) total += s[i] * (i + 1);
        return String.valueOf(total);
    }

    static void permute(long[] a, int k, long[] best) {
        if (k == a.length) {
            long t = 0, acc = 0;
            for (long x : a) {
                acc += x;
                t += acc;
            }
            best[0] = Math.min(best[0], t);
            return;
        }
        for (int i = k; i < a.length; i++) {
            long tmp = a[k]; a[k] = a[i]; a[i] = tmp;
            permute(a, k + 1, best);
            tmp = a[k]; a[k] = a[i]; a[i] = tmp;
        }
    }
}
