import java.util.*;

// 1541 잃어버린 괄호: 길이<=50, 숫자/+/-, 숫자로 시작·끝, 연산자 연속 X, 숫자는 5자리 이하(0으로 시작 가능)
public class P1541 implements Judge.Problem {
    public List<String[]> tests(Random rnd) {
        List<String[]> t = new ArrayList<>();
        t.add(new String[]{"example 1", "55-50+40\n"});
        t.add(new String[]{"example 2", "10+20+30+40\n"});
        t.add(new String[]{"example 3", "00009-00009\n"});
        t.add(new String[]{"single 0", "0\n"});
        t.add(new String[]{"single 00000", "00000\n"});
        t.add(new String[]{"single 99999", "99999\n"});
        t.add(new String[]{"leading minus first then plus", "1-2+3+4-5+6\n"});
        t.add(new String[]{"all minus", "1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1\n"});
        t.add(new String[]{"all plus max", "99999+99999+99999+99999+99999+99999+99999+99999\n"});
        t.add(new String[]{"most negative", "00000-99999+99999+99999+99999+99999+99999+99999\n"});
        t.add(new String[]{"zeros", "0-0+0-0+0\n"});
        for (int k = 0; k < 600; k++) t.add(new String[]{"rand #" + k, random(rnd, 1 + rnd.nextInt(50)) + "\n"});
        for (int k = 0; k < 100; k++) t.add(new String[]{"rand len~50 #" + k, random(rnd, 45 + rnd.nextInt(6)) + "\n"});
        return t;
    }

    // 길이 maxLen 이하의 유효한 식
    static String random(Random rnd, int maxLen) {
        StringBuilder sb = new StringBuilder(num(rnd, Math.min(maxLen, 1 + rnd.nextInt(5))));
        while (true) {
            int len = 1 + rnd.nextInt(5);
            if (sb.length() + 1 + len > maxLen) break;
            sb.append(rnd.nextBoolean() ? '+' : '-').append(num(rnd, len));
        }
        return sb.toString();
    }

    static String num(Random rnd, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) sb.append(rnd.nextInt(10) == 0 ? '0' : (char) ('0' + rnd.nextInt(10)));
        return sb.toString();
    }

    // 모든 괄호 배치를 구간 DP로 탐색해 최솟값 (그리디와 무관)
    public String oracle(String input) {
        String s = input.trim();
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
            nums.add(Long.parseLong(s.substring(i, j)));
            if (j < s.length()) ops.add(s.charAt(j));
            i = j + 1;
        }
        int n = nums.size();
        long[][] mn = new long[n][n], mx = new long[n][n];
        for (int a = 0; a < n; a++) mn[a][a] = mx[a][a] = nums.get(a);
        for (int len = 2; len <= n; len++) {
            for (int a = 0; a + len - 1 < n; a++) {
                int b = a + len - 1;
                mn[a][b] = Long.MAX_VALUE;
                mx[a][b] = Long.MIN_VALUE;
                for (int m = a; m < b; m++) {
                    long lo, hi;
                    if (ops.get(m) == '+') {
                        lo = mn[a][m] + mn[m + 1][b];
                        hi = mx[a][m] + mx[m + 1][b];
                    } else {
                        lo = mn[a][m] - mx[m + 1][b];
                        hi = mx[a][m] - mn[m + 1][b];
                    }
                    mn[a][b] = Math.min(mn[a][b], lo);
                    mx[a][b] = Math.max(mx[a][b], hi);
                }
            }
        }
        return String.valueOf(mn[0][n - 1]);
    }
}
