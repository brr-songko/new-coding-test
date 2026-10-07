import java.util.*;

// 1715 카드 정렬하기: 1<=N<=100000, 묶음 크기<=1000. 두 묶음 합치는 비용 = A+B, 전체 최소 비교 횟수
public class P1715 implements Judge.Problem {
    public List<String[]> tests(Random rnd) {
        List<String[]> t = new ArrayList<>();
        t.add(new String[]{"example", "3\n10\n20\n40\n"});
        t.add(new String[]{"N=1 (0)", "1\n1000\n"});
        t.add(new String[]{"N=2", "2\n1\n1\n"});
        t.add(new String[]{"merged sum not smallest", "4\n5\n5\n6\n6\n"});
        t.add(new String[]{"max N, all 1000", gen(100000, i -> 1000)});
        t.add(new String[]{"max N, all 1", gen(100000, i -> 1)});
        t.add(new String[]{"max N, ascending", gen(100000, i -> 1 + i % 1000)});
        t.add(new String[]{"max N, descending", gen(100000, i -> 1000 - i % 1000)});
        for (int k = 0; k < 300; k++) {
            int n = 1 + rnd.nextInt(7), max = rnd.nextBoolean() ? 5 : 1000;
            t.add(new String[]{"rand small #" + k, gen(n, i -> 1 + rnd.nextInt(max))});
        }
        for (int k = 0; k < 100; k++) {
            int n = 1 + rnd.nextInt(2000);
            t.add(new String[]{"rand mid #" + k, gen(n, i -> 1 + rnd.nextInt(1000))});
        }
        for (int k = 0; k < 5; k++) {
            t.add(new String[]{"rand large #" + k, gen(100000, i -> 1 + rnd.nextInt(1000))});
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
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
        if (n <= 7) return String.valueOf(brute(new ArrayList<>(toList(a))));
        return String.valueOf(twoQueue(a));
    }

    static List<Long> toList(long[] a) {
        List<Long> l = new ArrayList<>();
        for (long x : a) l.add(x);
        return l;
    }

    // 합칠 두 묶음을 모든 경우로 골라보는 완전탐색
    static long brute(List<Long> l) {
        if (l.size() <= 1) return 0;
        long best = Long.MAX_VALUE;
        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                List<Long> next = new ArrayList<>();
                for (int k = 0; k < l.size(); k++) if (k != i && k != j) next.add(l.get(k));
                long s = l.get(i) + l.get(j);
                next.add(s);
                best = Math.min(best, s + brute(next));
            }
        }
        return best;
    }

    // 정렬 + 두 개의 큐(원본/합친 묶음)로 하는 O(N) 허프만, long 계산
    static long twoQueue(long[] a) {
        long[] src = a.clone();
        Arrays.sort(src);
        long[] merged = new long[src.length];
        int i = 0, mh = 0, mt = 0;
        long total = 0;
        for (int step = 0; step < src.length - 1; step++) {
            long x, y;
            if (mh == mt || (i < src.length && src[i] <= merged[mh])) x = src[i++]; else x = merged[mh++];
            if (mh == mt || (i < src.length && src[i] <= merged[mh])) y = src[i++]; else y = merged[mh++];
            total += x + y;
            merged[mt++] = x + y;
        }
        return total;
    }
}
