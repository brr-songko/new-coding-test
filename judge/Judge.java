import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

// 로컬 채점기: 문제별 P<번호>.java 가 테스트 생성 + 독립 정답(oracle)을 제공한다.
// 실행: bash judge/grade.sh <문제번호> <클래스명>   예) bash judge/grade.sh 1541 Main5
public class Judge {
    public interface Problem {
        // {이름, 입력} 목록. 예제 + 엣지케이스 + 랜덤(히든테케 대용)
        List<String[]> tests(Random rnd);

        // 제출 코드와 다른 방식(완전탐색/DP/long 등)으로 구한 정답
        String oracle(String input);
    }

    public static void main(String[] args) throws Exception {
        Problem problem = (Problem) Class.forName("P" + args[0]).getDeclaredConstructor().newInstance();
        Method main = Class.forName(args[1]).getMethod("main", String[].class);
        List<String[]> tests = problem.tests(new Random(20261002L));

        int pass = 0, fail = 0;
        long maxMs = 0;
        String slowest = "";
        for (String[] t : tests) {
            String expected = problem.oracle(t[1]).trim();
            long st = System.nanoTime();
            String got;
            try {
                got = run(main, t[1]);
            } catch (Throwable e) {
                got = "EXCEPTION " + (e.getCause() != null ? e.getCause() : e);
            }
            long ms = (System.nanoTime() - st) / 1_000_000;
            if (ms > maxMs) {
                maxMs = ms;
                slowest = t[0];
            }
            if (normalize(got).equals(normalize(expected))) pass++;
            else {
                fail++;
                if (fail <= 5) {
                    String in = t[1].length() > 300 ? t[1].substring(0, 300) + "..." : t[1];
                    System.out.println("FAIL [" + t[0] + "]\n--- input\n" + in + "\n--- expected\n" + expected + "\n--- got\n" + got.trim() + "\n");
                }
            }
        }
        System.out.println("tests=" + tests.size() + " pass=" + pass + " fail=" + fail
                + " slowest=" + maxMs + "ms (" + slowest + ")");
        System.out.println(fail == 0 ? "RESULT: 맞았습니다!!" : "RESULT: 틀렸습니다");
        System.exit(fail == 0 ? 0 : 1);
    }

    // 백준처럼 줄 끝 공백과 마지막 빈 줄은 무시
    static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (String line : s.trim().split("\\R")) sb.append(line.replaceAll("\\s+$", "")).append('\n');
        return sb.toString();
    }

    static String run(Method main, String input) throws Exception {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(bos));
        try {
            main.invoke(null, (Object) new String[0]);
        } finally {
            System.out.flush();
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
        return bos.toString();
    }
}
