#!/usr/bin/env bash
# 生成 docs/index.md；不依赖 pyenv shell。
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
SCRIPTS="$ROOT/scripts"
PY="$("$SCRIPTS/resolve-python.sh")"

cd "$SCRIPTS"
echo ">> using: $PY"
exec "$PY" generate-pages.py "$@"
