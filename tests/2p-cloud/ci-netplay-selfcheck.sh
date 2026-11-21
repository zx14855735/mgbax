#!/usr/bin/env bash
# ci-netplay-selfcheck.sh — runnable form of tests/2p-cloud/CI-联机自检.md
# ------------------------------------------------------------------------------
# 2P cloud netplay · LOCAL regression self-check (bash / git-bash compatible).
#
# !! SERIALIZATION REQUIRED !!
#   A FULL run must be serialized: no other ninja build and no other gradle
#   invocation may be in flight (other agents in this workspace are building).
#   Do NOT run `taskkill /F /IM mGBA.exe` here: the generic advice in
#   .workbuddy/memory/MEMORY.md §6 would kill OTHER AGENTS' mGBA instances.
#   Only an operator who has confirmed exclusive ownership may do that manually.
#
# Environment:
#   On Windows/git-bash the mingw64 toolchain (ninja) must be on PATH:
#       export PATH="/c/msys64/mingw64/bin:$PATH"
#   (Linux/macOS: drop that line; ninja/swiftc/gradlew come from the normal PATH.)
#
# Usage:
#   bash tests/2p-cloud/ci-netplay-selfcheck.sh [--dry-run | -n]
#   ./tests/2p-cloud/ci-netplay-selfcheck.sh --dry-run    # print commands only
#
# Output:
#   tests/2p-cloud/ci-run-<timestamp>/<gate>.log   (raw stdout+stderr per gate)
#   tests/2p-cloud/ci-run-<timestamp>/RESULT.md    (machine-readable table)
#
# Scope: these are LOCAL gates (frame layer, decision functions, JVM self-tests,
# Swift syntax). They are NOT cross-device 2P cloud E2E evidence. See RESULT.md.
#
# Exit code (process status, for CI):
#   0   = every executed gate PASS (also a SELFCHECK_ONLY targeted run whose one
#         selected gate PASSed) — no gate produced verdict FAIL.
#   N>0 = number of gates with verdict FAIL (so any FAIL => non-zero exit).
#   Skipped gates (SKIPPED-LOCK / SKIPPED-SELECTIVE) do NOT change the exit code:
#   they are reported as "OVERALL: INCOMPLETE" in RESULT.md. This keeps a targeted
#   re-run or a lock-contended full run from being misreported as a red CI job,
#   while the machine-readable verdict column still records that they did not run.
# ------------------------------------------------------------------------------
set -u
set -o pipefail

# --- repo root (script lives in <root>/tests/2p-cloud/) -----------------------
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd "$HERE/../.." && pwd)"

# --- args --------------------------------------------------------------------
DRY_RUN=0
case "${1:-}" in
  --dry-run|-n) DRY_RUN=1 ;;
  --help|-h)
    sed -n '2,30p' "$0"
    exit 0
    ;;
  "") ;;
  *) echo "ERROR: unknown arg: $1 (use --dry-run|-n)" >&2; exit 2 ;;
esac

# --- environment -------------------------------------------------------------
# Required on Windows/git-bash so that ninja (and other mingw tools) resolve.
export PATH="/c/msys64/mingw64/bin:$PATH"

# --- locate swiftc ------------------------------------------------------------
# Historical exit=127 root cause: the CI harness ran this script with a PATH that
# did not contain swiftc (Windows installs it under ~/AppData/Local/Programs/Swift/
# Toolchains/<ver>+Asserts/usr/bin, NOT on PATH). `swiftc -parse ...` then failed
# as "command not found" (127) even though the toolchain was installed.
# Probe an absolute toolchain path first; fall back to whatever is on PATH.
SWIFTC="$(command -v swiftc 2>/dev/null || true)"
if [ -z "$SWIFTC" ]; then
  # swiftc.exe links DLLs (BlocksRuntime.dll, UCRT api-ms-win-crt-*.dll) that
  # live in the Toolchains bin AND the Runtimes bin. Add every Swift bin dir so
  # both the compiler and its dependencies resolve, not just swiftc's own dir.
  for base in \
    /c/Users/*/AppData/Local/Programs/Swift/Toolchains/*/usr/bin \
    /c/Users/*/AppData/Local/Programs/Swift/Runtimes/*/usr/bin \
    /c/Users/*/AppData/Local/Programs/Swift/Tools/* \
    "/c/Program Files/Swift/Toolchains/"*/usr/bin \
    "/c/Program Files/Swift/Runtimes/"*/usr/bin; do
    [ -d "$base" ] && export PATH="$base:$PATH"
  done
  SWIFTC="$(command -v swiftc 2>/dev/null || true)"
fi
if [ -z "$SWIFTC" ]; then
  echo "WARNING: swiftc not found anywhere; swift_parse_netplay will fail (exit 127)." >&2
  SWIFTC="swiftc"
fi

TS="$(date +%Y%m%d-%H%M%S)"
RUN_DIR="$ROOT/tests/2p-cloud/ci-run-$TS"
RESULT="$RUN_DIR/RESULT.md"
LOCK="$ROOT/build-win/.ninja_lock"
LOCK_RETRY_WAIT=3

# The iOS Swift files in scope for 2P cloud netplay:
#   GBoyConsoleSet.swift / GBoyLink.swift  -> N-core path + remote-key slot routing
#   LobbyFrames.swift / LobbyLink.swift   -> C0 capability negotiation + WSS tunnel
#   AppDelegate.swift                     -> ROOTHUNT2 control surface (mgbaMobileSetRhOff).
#                                            parse-only: `-parse` does not resolve imports,
#                                            so no UIKit dependency is pulled in. Name-level
#                                            checking of the new C stub is covered by
#                                            ios/typecheck/typecheck.sh instead.
SWIFT_FILES=(
  "ios/mGBA/GBoyConsoleSet.swift"
  "ios/mGBA/GBoyLink.swift"
  "ios/mGBA/LobbyFrames.swift"
  "ios/mGBA/LobbyLink.swift"
  "ios/mGBA/AppDelegate.swift"
)

if [ "$DRY_RUN" -eq 0 ]; then
  mkdir -p "$RUN_DIR"
  {
    echo "# 2P cloud netplay · CI self-check RESULT"
    echo
    echo "- timestamp: $TS"
    echo "- run dir: tests/2p-cloud/ci-run-$TS"
    echo "- mode: full"
    echo
    echo "> **These are LOCAL gates, NOT cross-device 2P cloud E2E.**"
    echo "> A green table below only means the frame layer / decision functions /"
    echo "> JVM self-tests / Swift syntax are intact. It proves NO product acceptance"
    echo "> and NO cross-device E2E (XD-1..XD-8 all still need two accounts, two game"
    echo "> uuids and two real devices). See tests/2p-cloud/AC1-AC6-验收矩阵.md §0-D."
    echo
    echo "| gate | exit_code | ok_count | FAIL_count | verdict |"
    echo "| --- | --- | --- | --- | --- |"
  } >"$RESULT"
else
  echo "[DRY-RUN] commands only; no files will be created (would use: tests/2p-cloud/ci-run-$TS/)"
fi

echo "=== 2P cloud netplay LOCAL self-check (${TS}) mode=$([ "$DRY_RUN" -eq 1 ] && echo dry-run || echo full) ==="
if [ "$DRY_RUN" -eq 0 ]; then
  echo "REMINDER: full run must be serialized (no other ninja/gradle in flight)."
  echo "REMINDER: do NOT taskkill mGBA.exe — other agents may be using it."
fi

# --- helpers -----------------------------------------------------------------
record_row() {
  # $1 gate, $2 exit_code, $3 ok, $4 FAIL, $5 verdict
  [ "$DRY_RUN" -eq 1 ] && return 0
  printf '| %s | %s | %s | %s | %s |\n' "$1" "$2" "$3" "$4" "$5" >>"$RESULT"
}

sum_numbers() {
  # sum all integers appearing in text matched by regex $2 within file $1
  grep -Eo "$2" "$1" 2>/dev/null | grep -Eo '[0-9]+' | awk '{s+=$1} END{print s+0}'
}

sum_first_number() {
  # sum the FIRST integer of each match (for "N/N PASS" style output)
  grep -Eo "$2" "$1" 2>/dev/null | sed -E 's/[^0-9].*//' | awk '{s+=$1} END{print s+0}'
}

count_lines() {
  local n
  n=$(grep -Ec "$2" "$1" 2>/dev/null)
  [ -n "$n" ] && echo "$n" || echo 0
}

compute_ok() {
  kind=$1; log=$2; code=$3
  case "$kind" in
    build)  [ "$code" -eq 0 ] && echo 1 || echo 0 ;;
    gboy)
      ok=$(sum_numbers "$log" '[0-9]+ ok')
      if [ "$ok" -eq 0 ]; then ok=$(count_lines "$log" 'PASS \(0 FAIL\)'); fi
      echo "$ok"
      ;;
    mobile)
      ok=$(sum_numbers "$log" '[0-9]+ ok')
      if [ "$ok" -eq 0 ]; then ok=$(count_lines "$log" 'mobile tests passed'); fi
      echo "$ok"
      ;;
    gradle)
      ok=$(sum_first_number "$log" '[0-9]+/[0-9]+ PASS')
      if [ "$ok" -eq 0 ] && [ "$code" -eq 0 ]; then ok=1; fi
      echo "$ok"
      ;;
    swift)  [ "$code" -eq 0 ] && echo "${#SWIFT_FILES[@]}" || echo 0 ;;
    *) echo '-' ;;
  esac
}

compute_fail() {
  kind=$1; log=$2; code=$3
  case "$kind" in
    build)  [ "$code" -eq 0 ] && echo 0 || echo 1 ;;
    gboy)   echo "$(sum_numbers "$log" '[0-9]+ FAIL')" ;;
    mobile) echo "$(( $(count_lines "$log" '^FAIL ') + $(sum_numbers "$log" '[0-9]+ FAIL') ))" ;;
    gradle) echo "$(( $(count_lines "$log" 'BUILD FAILED') + $(sum_numbers "$log" '[0-9]+ FAILED') ))" ;;
    swift)  echo "$(count_lines "$log" ': error:')" ;;
    *) echo '-' ;;
  esac
}

# run_gate NAME KIND DISPLAY [WORKDIR] -- CMD ARGS...
run_gate() {
  name=$1; kind=$2; display=$3; workdir=$4; shift 4
  # Optional targeted re-run: SELFCHECK_ONLY=swift_parse_netplay bash ...
  # Lets one gate be re-verified without invoking ninja/gradle (which may be
  # owned by another agent). Default (unset) runs every gate as before.
  if [ -n "${SELFCHECK_ONLY:-}" ] && [ "$SELFCHECK_ONLY" != "$name" ]; then
    echo "=== GATE: $name ==="
    echo "--> SKIPPED (SELFCHECK_ONLY=$SELFCHECK_ONLY)"
    # Keep the gate in the RESULT table (Q7 §2.3): a skipped gate must not vanish
    # from the statistics and leave a single-row, all-green table.
    record_row "$name" '-' '-' '-' 'SKIPPED-SELECTIVE'
    return 0
  fi
  log="$RUN_DIR/${name}.log"
  echo
  echo "=== GATE: $name ==="
  echo "CMD: $display"
  if [ "$DRY_RUN" -eq 1 ]; then
    echo "[DRY-RUN] $display"
    return 0
  fi
  if [ -n "$workdir" ]; then
    ( cd "$workdir" && "$@" ) >"$log" 2>&1
  else
    ( cd "$ROOT" && "$@" ) >"$log" 2>&1
  fi
  code=$?
  cat "$log"
  ok=$(compute_ok "$kind" "$log" "$code")
  fail=$(compute_fail "$kind" "$log" "$code")
  verdict=PASS
  if [ "$code" -ne 0 ] || [ "$fail" -ne 0 ]; then verdict=FAIL; fi
  echo "--> exit=$code ok=$ok FAIL=$fail verdict=$verdict (log: tests/2p-cloud/ci-run-$TS/${name}.log)"
  record_row "$name" "$code" "$ok" "$fail" "$verdict"
}

# ninja build gate: skip if lock held, retry once.
run_build_gate() {
  name=$1; target=$2
  if [ -n "${SELFCHECK_ONLY:-}" ] && [ "$SELFCHECK_ONLY" != "$name" ]; then
    echo "=== GATE: $name ==="
    echo "--> SKIPPED (SELFCHECK_ONLY=$SELFCHECK_ONLY)"
    record_row "$name" '-' '-' '-' 'SKIPPED-SELECTIVE'
    return 0
  fi
  display="ninja -C build-win $target"
  log="$RUN_DIR/${name}.log"
  echo
  echo "=== GATE: $name ==="
  echo "CMD: $display"
  if [ "$DRY_RUN" -eq 1 ]; then
    echo "[DRY-RUN] (pre-check $LOCK; if held -> retry once -> SKIPPED-LOCK) $display"
    return 0
  fi
  code=0; attempted=0; locked_skip=0
  while [ "$attempted" -lt 2 ]; do
    attempted=$((attempted + 1))
    if [ -e "$LOCK" ]; then
      echo "ninja lock held before attempt $attempted; waiting ${LOCK_RETRY_WAIT}s (retry 1/1)"
      sleep "$LOCK_RETRY_WAIT"
      if [ -e "$LOCK" ]; then
        echo "lock still held -> SKIPPED-LOCK"
        locked_skip=1
        break
      fi
    fi
    ( cd "$ROOT" && ninja -C build-win "$target" ) >"$log" 2>&1
    code=$?
    if [ "$code" -eq 0 ]; then break; fi
    echo "attempt $attempted failed (exit=$code)"
    if [ "$attempted" -lt 2 ]; then
      echo "retrying once..."
      sleep "$LOCK_RETRY_WAIT"
      if [ -e "$LOCK" ]; then
        echo "lock now held -> SKIPPED-LOCK"
        locked_skip=1
        break
      fi
    fi
  done
  if [ -f "$log" ]; then cat "$log"; fi
  if [ "$locked_skip" -eq 1 ]; then
    echo "--> verdict=SKIPPED-LOCK (ninja lock held; another build in flight)"
    record_row "$name" '-' '-' '-' 'SKIPPED-LOCK'
    return 0
  fi
  ok=$(compute_ok build "$log" "$code")
  fail=$(compute_fail build "$log" "$code")
  verdict=PASS; [ "$code" -eq 0 ] || verdict=FAIL
  echo "--> exit=$code ok=$ok FAIL=$fail verdict=$verdict (log: tests/2p-cloud/ci-run-$TS/${name}.log)"
  record_row "$name" "$code" "$ok" "$fail" "$verdict"
}

# --- gates -------------------------------------------------------------------
# 1) build the Qt test binary (lock-aware, retry once)
run_build_gate "ninja_test_gboylink" "test-gboylink"

# 2) Qt test-gboylink sub-suites (exact commands from ADR-003 §4.2(a)/(b)/(g))
TG="build-win/qt/test-gboylink.exe"
run_gate "test_gboylink_frames"          gboy "$TG frames"            "" "$TG" frames
run_gate "test_gboylink_buslocal"        gboy "$TG buslocal"          "" "$TG" buslocal
run_gate "test_gboylink_product_lockstep" gboy "$TG product-lockstep" "" "$TG" product-lockstep
run_gate "test_gboylink_c0"              gboy "$TG --c0"              "" "$TG" --c0
run_gate "test_gboylink_gatetest"        gboy "$TG --gatetest"        "" "$TG" --gatetest
run_gate "test_gboylink_fastgate"        gboy "$TG --fastgate"        "" "$TG" --fastgate
run_gate "test_gboylink_direct_order"    gboy "$TG direct-order"      "" "$TG" direct-order

# 3) build the mobile test binary (lock-aware, retry once), then run its suites
run_build_gate "ninja_mgba_mobile_test" "mgba_mobile_test"
MT="build-win/mgba_mobile_test.exe"
run_gate "mgba_mobile_test_bus"  mobile "$MT --bus"  "" "$MT" --bus
run_gate "mgba_mobile_test_link" mobile "$MT --link" "" "$MT" --link
run_gate "mgba_mobile_test_dual" mobile "$MT --dual" "" "$MT" --dual

# 4) Android self-tests — exact commands, two explicit steps (do NOT merge)
run_gate "gradle_compile_debug" gradle \
  'cd android && ./gradlew :app:compileDebugJavaWithJavac --offline' \
  "$ROOT/android" ./gradlew :app:compileDebugJavaWithJavac --offline
run_gate "gradle_run_link_selftests" gradle \
  'cd android && ./gradlew :app:runLinkSelfTests --offline' \
  "$ROOT/android" ./gradlew :app:runLinkSelfTests --offline

# 5) Swift syntax parse on the in-scope iOS netplay files (incl. AppDelegate.swift)
SWIFT_DISPLAY="$SWIFTC -parse ${SWIFT_FILES[*]}"
run_gate "swift_parse_netplay" swift "$SWIFT_DISPLAY" "" "$SWIFTC" -parse "${SWIFT_FILES[@]}"

# --- summary -----------------------------------------------------------------
count_verdict() {
  awk -F'|' -v want="$1" '
    { v=$6; gsub(/^ +| +$/, "", v); if (v==want) c++ }
    END { print c+0 }
  ' "$RESULT"
}

if [ "$DRY_RUN" -eq 0 ]; then
  pass=$(count_verdict PASS)
  failc=$(count_verdict FAIL)
  skip=$(count_verdict SKIPPED-LOCK)
  skip_sel=$(count_verdict SKIPPED-SELECTIVE)
  total=$((pass + failc + skip + skip_sel))
  {
    echo
    echo "## Summary"
    echo
    echo "- PASS: $pass"
    echo "- FAIL: $failc"
    echo "- SKIPPED-LOCK: $skip"
    echo "- SKIPPED-SELECTIVE: $skip_sel"
    echo "- total gates: $total"
    if [ "$failc" -gt 0 ]; then
      echo "- OVERALL: FAIL"
    elif [ "$skip" -gt 0 ]; then
      # Q7 §2.2: a gate that never ran is NOT a pass. Do not emit "OVERALL: PASS".
      echo "- OVERALL: INCOMPLETE (SKIPPED-LOCK gates — rerun serialized)"
    elif [ "$skip_sel" -gt 0 ]; then
      # Q7 §2.3: SELFCHECK_ONLY selected run — one gate ran, the others are recorded
      # as SKIPPED-SELECTIVE. Honest label; exit code still reflects only real FAILs.
      echo "- OVERALL: INCOMPLETE (SELFCHECK_ONLY single-gate run; other gates not executed)"
    else
      echo "- OVERALL: PASS"
    fi
    echo
    echo "**LOCAL gates only — NOT cross-device 2P cloud E2E.**"
    echo "See tests/2p-cloud/AC1-AC6-验收矩阵.md §0-D (XD-1..XD-8) and"
    echo "tests/2p-cloud/CI-联机自检.md §4 for what these gates do NOT cover."
  } >>"$RESULT"
  echo
  echo "=== DONE: PASS=$pass FAIL=$failc SKIPPED-LOCK=$skip SKIPPED-SELECTIVE=$skip_sel (total=$total) ==="
  echo "RESULT: tests/2p-cloud/ci-run-$TS/RESULT.md"
  # Q7 §2.1: propagate gate verdicts to the process exit code. Previously the
  # script always exited 0 even when RESULT.md said OVERALL: FAIL, so any CI
  # harness checking $? reported a false green. failc is the number of FAIL rows
  # (0 => PASS, >0 => non-zero). Skipped rows intentionally do not affect it.
  exit "$failc"
else
  echo
  echo "=== DRY-RUN complete: all commands printed, nothing executed. ==="
  exit 0
fi
