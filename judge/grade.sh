#!/usr/bin/env bash
# 사용법: bash judge/grade.sh <문제번호> <클래스명>    예) bash judge/grade.sh 1541 Main5
set -e
cd "$(dirname "$0")/.."
PROBLEM=$1
CLASS=$2
JDK_BIN=${JAVA_HOME:+$JAVA_HOME/bin}
JDK_BIN=${JDK_BIN:-$(ls -d "$HOME"/.jdks/*/bin 2>/dev/null | tail -1)}
OUT=build/judge
rm -rf "$OUT" && mkdir -p "$OUT"
"$JDK_BIN/javac" -encoding UTF-8 -d "$OUT" \
  "src/main/java/com/brr/newcodingtest/n$PROBLEM/$CLASS.java" judge/Judge.java "judge/P$PROBLEM.java"
"$JDK_BIN/java" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -cp "$OUT" Judge "$PROBLEM" "com.brr.newcodingtest.n$PROBLEM.$CLASS"
