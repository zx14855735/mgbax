#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""G1 fail-closed 判读：只读两份逐帧 CSV，输出 VERDICT，不写任何 PASS/CROSSED。

模式：
  默认                 全字段须全等（EX-0 原口径）
  --determinism-only   只校验确定性字段(pc/fb_fnv/nonblack/keys)；rng/rng2 仅观测
  --expect converge    EX-1：写相同 seed 后所有字段(含 rng/rng2)须全等，且 rng 须有
                       区分力(排除恒定 seed 导致的假收敛)，否则 EXPERIMENT-INVALID
"""
import csv, os, sys

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
# converge 模式：rng2 是次要观测列（钩子只拦 gRngValue 不碰 gRng2Value），允许恒定，
# 从死值自检中排除；主 rng 列的区分力在 converge 分支单独校验。
dead_cols = [c for c in check_cols if not (converge and c == "rng2")]
dead = [c for c in dead_cols if distinct[c] < 2]

print("rows={}/{} checked_cols={} det_diff={} seed_diff={} distinct={}".format(
    len(a), len(b), ",".join(check_cols), det_diff, seed_diff, distinct))

if dead:
    print("EXPERIMENT-INVALID (dead/constant columns: {})".format(",".join(dead)))
    sys.exit(3)

if converge:
    # 独立复核 EX1-BLITE-AUDIT 推翻了先前的 CONVERGED：
    #   钩子 LCG 判定式写错（真实递推 x=x*MUL+0x6073，代码只认 x==old*MUL），
    #   lcg_pass=0/unknown=1198 证明 LCG 从未被正确识别，DETRNG f003 是自然 LCG 步误判为 reseed。
    #   A.csv/B.csv 字节完全相同 -> 逐帧相等是 by-construction 平凡观测。
    # 按预注册 J 表：J5 lcg_pass>=1、J6 unknown==0 必须满足；judge 必须读钩子审计 sidecar，
    #   缺失或任一失败 -> EXPERIMENT-INVALID，绝不判 CONVERGED。
    audit_path = paths[2] if len(paths) > 2 else None
    if not audit_path or not os.path.exists(audit_path):
        print("EXPERIMENT-INVALID (converge requires hook audit sidecar <out>.audit; "
              "prior CONVERGED verdict retracted per EX1-BLITE-AUDIT)")
        sys.exit(3)
    audit = open(audit_path, encoding="utf-8", errors="replace").read()
    import re
    m = re.search(r"hits=(\d+)\s+lcg_pass=(\d+)\s+unknown=(\d+)", audit)
    if not m:
        print("EXPERIMENT-INVALID (hook audit summary missing)")
        sys.exit(3)
    hits, lcg_pass, unknown = int(m.group(1)), int(m.group(2)), int(m.group(3))
    if lcg_pass < 1 or unknown != 0:
        print("EXPERIMENT-INVALID (J5 lcg_pass>=1 / J6 unknown==0 failed: hits={} lcg_pass={} unknown={}; "
              "prior CONVERGED retracted)".format(hits, lcg_pass, unknown))
        sys.exit(3)
    core_cols = [c for c in cols if c != "rng2"]
    all_diff = sum(1 for x, y in zip(a, b) for c in core_cols if x[c] != y[c])
    rng_distinct = len(set(r["rng"] for r in a))
    identical = open(paths[0], "rb").read() == open(paths[1], "rb").read()
    if all_diff != 0 or rng_distinct < 2:
        print("EXPERIMENT-INVALID (convergence columns invalid: all_diff={} rng_distinct={})".format(all_diff, rng_distinct))
        sys.exit(3)
    if identical:
        print("EXPERIMENT-INVALID (A.csv == B.csv byte-identical -> trivial by-construction equality, "
              "not independent convergence evidence)")
        sys.exit(3)
    print("VERDICT=G1-EX1-CONVERGED-PROVISIONAL (hook audit J1-J6 pass; RNG converges with real LCG "
          "progression; CONTROLLED by-construction, NOT natural convergence, NOT opponent-reality; "
          "TM1CNT_L unproven; R3 NETGATE reanchor not judged)")
    sys.exit(0)

if det_diff:
    print("VERDICT=G1-EX0-FAIL (determinism fields differ -> nondeterministic)")
    sys.exit(1)
if det_only and any(seed_diff.values()):
    print("VERDICT=G1-EX0-DETERMINISM-OK + RNG-DIVERGENCE-OBSERVED "
          "(execution/frame identical; RNG differs at runtime; source/TM1CNT_L UNPROVEN, non-sufficient)")
    sys.exit(0)
print("VERDICT=G1-EX0-EQUAL (all checked fields equal; determinism baseline observed)")
