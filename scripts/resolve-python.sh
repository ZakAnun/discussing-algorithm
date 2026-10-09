#!/usr/bin/env bash
# 解析可用的 Python，不依赖 `pyenv shell` / shell integration。
set -euo pipefail

PYENV_VER="${PROJECT_PYTHON_VERSION:-3.13.0}"
PYENV_ROOT="${PYENV_ROOT:-$HOME/.pyenv}"
CANDIDATES=(
  "${PYENV_ROOT}/versions/${PYENV_VER}/bin/python"
  "${PYENV_ROOT}/versions/${PYENV_VER}/bin/python3"
  "$(command -v python3 || true)"
  "$(command -v python || true)"
)

for py in "${CANDIDATES[@]}"; do
  if [[ -n "$py" && -x "$py" ]]; then
    echo "$py"
    exit 0
  fi
done

echo "未找到可用 Python（优先 pyenv ${PYENV_VER}，其次 PATH 中的 python3）" >&2
exit 1
