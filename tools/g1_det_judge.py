#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""G1 EX-0 fail-closed 判读：只读两份逐帧 CSV，输出 VERDICT，不写任何 PASS/CROSSED。

判据口径（依据 r10 决定性实测修正）：
  - 确定性字段 pc/fb_fnv/nonblack/keys：两实例必须逐帧全等（执行流+画面+输入）。
  - seed 观测字段 rng/rng2：来自 REG_TM1CNT_L，两实例（模拟真机两端）本就应不同；
    分歧是 G1 命题的前提证据，不是确定性失败。
模式：
  默认                 全字段须全等（原 EX-0 口径）
  --determinism-only   只校验确定性字段；rng/rng2 作为观测项报告，不因分歧判 FAIL
"""
import csv, sys

DETERMINISM_COLS = ["pc", "fb_fnv", "nonblack", "keys"]
SEED_COLS = ["rng", "rng2"]

def load(p):
    with open(p, newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))

args = sys.argv[1:]
det_only = "--determinism-only" in args
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
# 区分力自检：确定性字段必须有 >=2 个不同值，否则是死值（退化平凡全等）
distinct = {c: len(set(r[c] for r in a)) for c in check_cols}
dead = [c for c, d in distinct.items() if d < 2]

print("rows={}/{} checked_cols={} det_diff={} seed_diff={} distinct={}".format(
    len(a), len(b), ",".join(check_cols), det_diff, seed_diff, distinct))
if dead:
    print("EXPERIMENT-INVALID (dead/constant columns: {})".format(",".join(dead)))
    sys.exit(3)
if det_diff:
    print("VERDICT=G1-EX0-FAIL (determinism fields differ -> nondeterministic)")
    sys.exit(1)
if det_only and any(seed_diff.values()):
    print("VERDICT=G1-EX0-DETERMINISM-OK + SEED-DIVERGENCE-OBSERVED "
          "(execution/frame identical; RNG seed differs -> G1 premise premise-supported, non-sufficient)")
    sys.exit(0)
print("VERDICT=G1-EX0-EQUAL (all checked fields equal; determinism baseline observed)")
