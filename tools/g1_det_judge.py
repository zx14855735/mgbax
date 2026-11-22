#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""G1 EX-0 fail-closed 判读：只读两份逐帧 CSV，输出 VERDICT，不写任何 PASS/CROSSED。"""
import csv, sys

def load(p):
    with open(p, newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))

a = load(sys.argv[1])
b = load(sys.argv[2])
if not a or not b:
    print("VERDICT=UNOBSERVED (empty CSV)")
    sys.exit(2)
n = min(len(a), len(b))
diff = [(x["frame"], k, x[k], y[k])
        for x, y in zip(a, b) for k in x if x[k] != y[k]]
nz = [r for r in a if r["rng"] != "00000000"]
print("rows={}/{} diff_count={} rng_nonzero_frames={}".format(len(a), len(b), len(diff), len(nz)))
if len(a) != len(b):
    print("VERDICT=UNOBSERVED (row count mismatch)")
    sys.exit(2)
if diff:
    print("VERDICT=G1-EX0-FAIL (frame buckets differ -> nondeterministic)")
    sys.exit(1)
print("VERDICT=G1-EX0-EQUAL (all frame buckets equal; determinism baseline observed)")
