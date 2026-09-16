#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

FILE="${1:-}"
if [[ -z "$FILE" ]]; then
  echo "用法: scripts/run-demo.sh <java-or-kt-file>"
  exit 1
fi

# 支持绝对路径或相对路径
if [[ "$FILE" != /* ]]; then
  FILE="$ROOT/$FILE"
fi

if [[ ! -f "$FILE" ]]; then
  echo "文件不存在: $FILE"
  exit 1
fi

case "$FILE" in
  *.java) ;;
  *.kt) ;;
  *)
    echo "仅支持 .java / .kt 文件"
    exit 1
    ;;
esac

REL="${FILE#"$ROOT"/}"
REL="${REL#app/}"

if [[ "$REL" == src/main/java/* ]]; then
  CLASS_PATH="${REL#src/main/java/}"
elif [[ "$REL" == src/main/kotlin/* ]]; then
  CLASS_PATH="${REL#src/main/kotlin/}"
elif [[ "$REL" == src/* ]]; then
  CLASS_PATH="${REL#src/}"
else
  echo "无法从路径解析主类: $REL"
  exit 1
fi

MAIN_CLASS="${CLASS_PATH%.*}"
MAIN_CLASS="${MAIN_CLASS//\//.}"

echo ">> 编译..."
./gradlew :app:compileDebugJavaWithJavac :app:compileDebugKotlin -q

CP="$ROOT/app/build/intermediates/javac/debug/classes:$ROOT/app/build/tmp/kotlin-classes/debug"

echo ">> 运行 $MAIN_CLASS"
echo "----------------------------------------"
java -cp "$CP" "$MAIN_CLASS"
