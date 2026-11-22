#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""G1 fail-closed 判读：只读两份逐帧 CSV，输出 VERDICT，不写任何 PASS/CROSSED。

模式：
  默认                 全字段须全等（EX-0 原口径）
  --determinism-only   只校验确定性字段(pc/fb_fnv/nonblack/keys)；rng/rng2 仅观测
  --expect converge    EX-1：写相同 seed 后所有字段(含 rng/rng2)须全等，且 rng 须有
                       区分力(排除恒定 seed 导致的假收敛)，否则 EXPERIMENT-INVALID
"""
import csv, sys

DETERMINISM_COLS = ["pc", "fb_fnv", "nonblack", "keys"]
SEED_COLS = ["rng", "rng2"]

def load(p):
    with open(p, newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))

args = sys.argv[1:]
det_only = "--determinism-only" in args
converge = "--expect" in args and "converge" in args
paths = [p for p in args if not p.startswith("--")]
a = load(paths[0])
b = load(paths[1])
if not a or not b:
    print("VERDICT=UNOBSERVED (empty CSV)")
    sys.exit(2)
if len(a) != len(b):
    print("VERDICT=UNOBSERVED (row count mismatch {}/{})".format(len(a), len(b)))
    sys.exit(2)

cols = [c for c in a[0] if c != "frame"]
check_cols = DETERMINISM_COLS if det_only else cols
det_diff = sum(1 for x, y in zip(a, b) for c in check_cols if x[c] != y[c])
seed_diff = {c: sum(1 for x, y in zip(a, b) if x[c] != y[c]) for c in SEED_COLS if c in a[0]}
distinct = {c: len(set(r[c] for r in a)) for c in check_cols}
dead = [c for c, d in distinct.items() if d < 2]

print("rows={}/{} checked_cols={} det_diff={} seed_diff={} distinct={}".format(
    len(a), len(b), ",".join(check_cols), det_diff, seed_diff, distinct))

if dead:
    print("EXPERIMENT-INVALID (dead/constant columns: {})".format(",".join(dead)))
    sys.exit(3)

if converge:
    # EX-1：写相同 seed 后，确定性字段 + rng/rng2 全部须 0 差异
    all_diff = sum(1 for x, y in zip(a, b) for c in cols if x[c] != y[c])
    rng_distinct = len(set(r["rng"] for r in a))
    if all_diff != 0:
        print("VERDICT=G1-EX1-FAIL (after same-seed writeback, columns still differ: {})".format(all_diff))
        sys.exit(1)
    if rng_distinct < 2:
        print("EXPERIMENT-INVALID (rng constant after writeback ->SeedRng overwrite or writeback failed; not a clean convergence)")
        sys.exit(3)
    print("VERDICT=G1-EX1-CONVERGED (same seed -> RNG state converges; determinism holds; "
          "seed source causality necessary-not-sufficient; R3 NETGATE reanchor not yet judged)")
    sys.exit(0)

if det_diff:
    print("VERDICT=G1-EX0-FAIL (determinism fields differ -> nondeterministic)")
    sys.exit(1)
if det_only and any(seed_diff.values()):
    print("VERDICT=G1-EX0-DETERMINISM-OK + RNG-DIVERGENCE-OBSERVED "
          "(execution/frame identical; RNG differs at runtime; source/TM1CNT_L UNPROVEN, non-sufficient)")
    sys.exit(0)
print("VERDICT=G1-EX0-EQUAL (all checked fields equal; determinism baseline observed)")
