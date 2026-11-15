#!/usr/bin/env bash
cd "$(dirname "${BASH_SOURCE[0]}")/../.." || exit 1
bash ios/typecheck/typecheck.sh >/dev/null 2>&1
echo "errors=$(grep -c ': error: ' ios/typecheck/last-errors.log)"
grep ': error: ' ios/typecheck/last-errors.log | sed 's|.*ios\\typecheck\\||' | sed -E 's/:[0-9]+:[0-9]+: error:/ ::/' | head -"${1:-40}"
