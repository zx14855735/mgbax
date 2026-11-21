#!/usr/bin/env python3
"""Offline verifier for the ROM-signature address-resolution approach.

Spec: production/sprint-2p/ROM-ADDRESS-RESOLUTION-SPEC.md

This tool does NOT read .map/.elf at runtime and does NOT need mGBA. It reads
only raw ROM bytes and simulates the three scanners used by the product code:

  1. battle_main.o .text prologue (code address resolution)
       src/platform/qt/sio_link.c::sioResolveCodeDelta()
  2. IWRAM gRecvCmds/gSendCmd literal-pair scan
       src/platform/qt/sio_link.c::sioResolveIwramDelta()
  3. EWRAM gTasks top-candidate scan
       src/platform/qt/sio_link.c::sioResolveEwramDelta() / sioLooksLikeTasks()

Expected values are embedded per-ROM md5 (they were obtained OFFLINE from the
matching .map files) and can be overridden with --expect-* arguments.

Usage:
    python tools/rom_addr_verify.py --rom rom.gba
    python tools/rom_addr_verify.py --rom D:/gen8/rom.gba
    python tools/rom_addr_verify.py --rom some_new_build.gba \
        --expect-prologue 0x080B30C0 --expect-cb2 0x080B4844 \
        --expect-glink 0x03002BC8 --expect-gtasks 0x02033D0C

Exit status: 0 = all checks PASS, 1 = at least one FAIL, 2 = IO/usage error.
"""

from __future__ import annotations

import argparse
import hashlib
import os
import sys

import gba_addrs as gba  # 统一地址宏（AGENTS §5，三端同名同值）

ROM_BASE = gba.ROM_BASE  # GBA ROM mirror base; runtime = base + file offset

# 12-byte Thumb prologue at the start of battle_main.o .text (layout-independent).
PROLOGUE = bytes.fromhex("064b1b780020022b06d1054a")

# Relative geometry (constant across the builds checked; see report):
PROLOGUE_TO_CB2 = 0x1784  # section start -> BattleMainCB2 (symbol, Thumb bit clear)

# Constants mirrored from sio_link.c (地址值统一取自 gba_addrs).
SIO_IW_BASE_GLINK = gba.SIO_GLINK_BASE
IWRAM_LO, IWRAM_HI = gba.IWRAM_LO, gba.IWRAM_HI
IWRAM_SPACING = gba.IWRAM_SPACING  # gSendCmd - gRecvCmds
GLINK_OFFSET = gba.GLINK_OFFSET    # gLink - gRecvCmds
IWRAM_MIN_SCORE = 4
DELTA_SANE_MAX = 0x2000    # |delta| >= this (and < 0xFFFFE000) is rejected

EWRAM_LO, EWRAM_HI = gba.EWRAM_LO, gba.EWRAM_HI
EWRAM_MIN_REFS = 100
EWRAM_TOP_N = 8
TASKS_SLOTS = 16
TASKS_STRIDE = 0x28
TASKS_SPAN = TASKS_SLOTS * TASKS_STRIDE  # 0x280
EWRAM_END = gba.EWRAM_END

# Offline ground truth keyed by the first 8 md5 hex digits (from matching maps).
# NOTE: the task statement's "workspace map" values (0x080B24B8 / CB2 0x080B3C3D)
# actually belong to the OLD build turbo_rom.gba (md5 f7886655), whose map is
# .zcode-tmp/busgame-run/rom.map. The on-disk rom.gba (50380227, 14:36) matches
# the gen8 layout. See production/sprint-2p/ROM-SIGNATURE-VERIFY.md.
EXPECT_PROFILES = {
    "50380227": {  # workspace rom.gba, 14:36 batch
        "label": "workspace rom.gba (14:36)",
        "prologue": gba.BATTLE_PROLOGUE_LO,
        "hi": gba.BATTLE_PROLOGUE_HI,
        "section_size": gba.BATTLE_WIDE_SIZE,
        "cb2": gba.BATTLE_CB2_SYM,
        "recv": gba.SIO_RECV_BASE,
        "send": gba.SIO_SEND_BASE,
        "glink": gba.SIO_GLINK_GEN8,
        "iw_delta": 0xD4,
        "gtasks": gba.G_TASKS_BASE,
        "ew_delta": 0x0,
    },
    "cb988b5b": {  # D:/gen8/rom.gba, 18:55 batch
        "label": "gen8 rom.gba (18:55)",
        "prologue": gba.BATTLE_PROLOGUE_LO,
        "hi": gba.BATTLE_PROLOGUE_HI,
        "section_size": gba.BATTLE_WIDE_SIZE,
        "cb2": gba.BATTLE_CB2_SYM,
        "recv": gba.SIO_RECV_BASE,
        "send": gba.SIO_SEND_BASE,
        "glink": gba.SIO_GLINK_GEN8,
        "iw_delta": 0xD4,
        "gtasks": gba.G_TASKS_BASE,
        "ew_delta": 0x0,
    },
    "f7886655": {  # BONUS: old build turbo_rom.gba (old workspace map)
        "label": "OLD turbo_rom.gba (old map)",
        "prologue": gba.OLD_PROLOGUE_LO,
        "hi": gba.OLD_PROLOGUE_HI,
        "section_size": 0x9994,
        "cb2": gba.OLD_BATTLE_CB2_SYM,  # map value; task text said 0x080B3C3D (off by one)
        "recv": gba.SIO_RECV_OLD,
        "send": gba.SIO_SEND_OLD,
        "glink": gba.SIO_GLINK_BASE,
        "iw_delta": 0x0,
        "gtasks": gba.G_TASKS_BASE,
        "ew_delta": 0x0,
    },
}


def h(x: int) -> str:
    return "0x%08X" % (x & 0xFFFFFFFF)


def md5_of(path: str) -> str:
    digest = hashlib.md5()
    with open(path, "rb") as fp:
        for chunk in iter(lambda: fp.read(1 << 20), b""):
            digest.update(chunk)
    return digest.hexdigest()


def scan_prologue(data: bytes):
    """Return all file offsets where the 12-byte prologue occurs."""
    offsets = []
    start = 0
    while True:
        idx = data.find(PROLOGUE, start)
        if idx < 0:
            break
        offsets.append(idx)
        start = idx + 1
    return offsets


def scan_iwram(data: bytes):
    """Simulate sioResolveIwramDelta().

    The C code reads fixed 1 MiB chunks and walks them in 4-byte steps, so for
    any ROM whose size is a multiple of 4 this is equivalent to counting every
    aligned little-endian 32-bit word in the whole file. It indexes the count
    table by the literal's byte address (NOT v>>2): gRecvCmds is not 4-aligned.
    """
    # C uses `static uint16_t cnt[0x8000]` indexed by the literal's BYTE address
    # (v - 0x03000000), not v>>2; max valid index is 0x7FEF.
    size = gba.IWRAM_SCAN_ARRAY_SIZE
    cnt = [0] * size
    limit = len(data) - 3
    for i in range(0, limit, 4):
        v = (data[i] | (data[i + 1] << 8) | (data[i + 2] << 16)
             | (data[i + 3] << 24))
        if IWRAM_LO <= v < IWRAM_HI:
            idx = v - IWRAM_LO
            if cnt[idx] < 0xFFFF:
                cnt[idx] += 1

    best_r = 0
    best_score = 0
    best_c1 = best_c2 = 0
    ties = []
    for idx in range(size):
        c1 = cnt[idx]
        if c1 < 2:
            continue
        r = IWRAM_LO + idx
        if r + IWRAM_SPACING >= IWRAM_HI + 0x10:  # matches C: >= 0x03008000
            continue
        c2 = cnt[(r + IWRAM_SPACING) - IWRAM_LO]
        score = c1 if c1 < c2 else c2
        if score > best_score:
            best_score, best_r, best_c1, best_c2 = score, r, c1, c2
            ties = [(r, c1, c2)]
        elif score == best_score:
            ties.append((r, c1, c2))

    found = best_r != 0 and best_score >= IWRAM_MIN_SCORE
    glink = (best_r + GLINK_OFFSET) & 0xFFFFFFFF
    delta = (glink - SIO_IW_BASE_GLINK) & 0xFFFFFFFF
    sane = not (DELTA_SANE_MAX <= delta < 0xFFFFE000)
    accepted = found and sane
    return {
        "recv": best_r, "score": best_score, "c1": best_c1, "c2": best_c2,
        "ties": ties, "glink": glink, "delta": delta,
        "found": found, "sane": sane, "accepted": accepted,
    }


def scan_ewram(data: bytes):
    """Simulate the literal-count part of sioResolveEwramDelta().

    Returns the top candidates ordered by count, with the range pre-check that
    the C code applies before calling sioLooksLikeTasks(). The full structure
    check reads *runtime EWRAM* via GBAView32/GBAView8 and therefore cannot be
    reproduced from ROM bytes alone; from ROM bytes the count ranking is the
    discriminator (gTasks has a wide lead). See the report for details.
    """
    cnt = {}
    limit = len(data) - 3
    for i in range(0, limit, 4):
        v = (data[i] | (data[i + 1] << 8) | (data[i + 2] << 16)
             | (data[i + 3] << 24))
        if EWRAM_LO <= v < EWRAM_HI and (v & 3) == 0:
            cnt[v] = cnt.get(v, 0) + 1
    ranked = sorted(((a, c) for a, c in cnt.items() if c >= EWRAM_MIN_REFS),
                    key=lambda kv: (-kv[1], kv[0]))
    top = []
    for addr, refs in ranked[:EWRAM_TOP_N]:
        top.append({
            "addr": addr, "refs": refs,
            "in_range": addr + TASKS_SPAN <= EWRAM_END,
        })
    # The C code picks the first top-8 candidate passing both checks; with no
    # EWRAM image we approximate it as the first in-range candidate (= highest
    # count), and flag that the structure check is not simulatable offline.
    chosen = next((t["addr"] for t in top if t["in_range"]), 0)
    delta = (chosen - gba.G_TASKS_BASE) & 0xFFFFFFFF if chosen else 0
    return {"top": top, "chosen": chosen, "delta": delta,
            "distinct": len(cnt)}


def build_expect(args, md5prefix: str):
    exp = dict(EXPECT_PROFILES[md5prefix]) if md5prefix in EXPECT_PROFILES else {
        "label": "unknown ROM (no embedded profile)",
    }
    for key, attr in (("prologue", "expect_prologue"), ("hi", "expect_hi"),
                      ("cb2", "expect_cb2"), ("recv", "expect_recv"),
                      ("send", "expect_send"), ("glink", "expect_glink"),
                      ("iw_delta", "expect_iw_delta"),
                      ("gtasks", "expect_gtasks"),
                      ("ew_delta", "expect_ew_delta")):
        val = getattr(args, attr)
        if val is not None:
            exp[key] = val
    return exp


RESULTS = []


def check(name: str, ok: bool, detail: str) -> None:
    RESULTS.append((name, ok, detail))
    print("  [%s] %-22s %s" % ("PASS" if ok else "FAIL", name, detail))


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--rom", required=True, help="path to the .gba ROM to verify")
    ap.add_argument("--expect-prologue", type=lambda x: int(x, 0))
    ap.add_argument("--expect-hi", type=lambda x: int(x, 0))
    ap.add_argument("--expect-cb2", type=lambda x: int(x, 0))
    ap.add_argument("--expect-recv", type=lambda x: int(x, 0))
    ap.add_argument("--expect-send", type=lambda x: int(x, 0))
    ap.add_argument("--expect-glink", type=lambda x: int(x, 0))
    ap.add_argument("--expect-iw-delta", type=lambda x: int(x, 0))
    ap.add_argument("--expect-gtasks", type=lambda x: int(x, 0))
    ap.add_argument("--expect-ew-delta", type=lambda x: int(x, 0))
    args = ap.parse_args()

    path = args.rom
    if not os.path.isfile(path):
        print("ERROR: ROM not found: %s" % path, file=sys.stderr)
        return 2
    with open(path, "rb") as fp:
        data = fp.read()
    md5 = md5_of(path)
    prefix = md5[:8]
    exp = build_expect(args, prefix)

    print("=" * 72)
    print("ROM       : %s" % os.path.abspath(path))
    print("MD5       : %s" % md5)
    print("Size      : %d bytes (0x%X)" % (len(data), len(data)))
    print("Profile   : %s" % exp["label"])
    print("=" * 72)

    RESULTS.clear()

    # --- 1. Code address / prologue -------------------------------------
    print("\n[1] battle_main.o prologue (code address resolution)")
    offs = scan_prologue(data)
    print("  signature          : %s" % PROLOGUE.hex(" "))
    print("  file offset(s)     : %s" % ", ".join(h(o) for o in offs) or "(none)")
    if not offs:
        check("prologue found", False, "signature NOT FOUND in ROM")
        lo = None
    else:
        lo = ROM_BASE + offs[0]
        cb2 = lo + PROLOGUE_TO_CB2
        hi = lo + exp.get("section_size", 0)
        print("  runtime lo         : %s" % h(lo))
        print("  runtime cb2        : %s (= lo + 0x%X; Thumb-bit cb2 = %s)"
              % (h(cb2), PROLOGUE_TO_CB2, h(cb2 + 1)))
        if "section_size" in exp:
            print("  window [lo,hi)     : [%s, %s) size=0x%X"
                  % (h(lo), h(hi), exp["section_size"]))
        check("prologue unique", len(offs) == 1,
              "%d occurrence(s); ambiguity=%s" % (len(offs), len(offs) != 1))
        if "prologue" in exp:
            check("prologue addr", lo == exp["prologue"],
                  "got %s expected %s" % (h(lo), h(exp["prologue"])))
        if "cb2" in exp:
            check("BattleMainCB2", cb2 == exp["cb2"],
                  "got %s expected %s" % (h(cb2), h(exp["cb2"])))
        if "hi" in exp and hi != exp["hi"]:
            check("window hi", False, "derived %s expected %s"
                  % (h(hi), h(exp["hi"])))

    # --- 2. IWRAM --------------------------------------------------------
    print("\n[2] IWRAM gRecvCmds/gSendCmd scan (sioResolveIwramDelta)")
    iw = scan_iwram(data)
    print("  bestR (gRecvCmds)  : %s" % h(iw["recv"]))
    print("  score              : %d (cnt[R]=%d, cnt[R+0x66]=%d)"
          % (iw["score"], iw["c1"], iw["c2"]))
    print("  #tied winners      : %d" % len(iw["ties"]))
    print("  gLink (bestR+0xAA) : %s" % h(iw["glink"]))
    print("  delta              : %s" % h(iw["delta"]))
    print("  accepted           : %s (found=%s sane=%s)"
          % (iw["accepted"], iw["found"], iw["sane"]))
    check("iw scan accepted", iw["accepted"],
          "bestR=%s score=%d" % (h(iw["recv"]), iw["score"]))
    check("iw unique winner", len(iw["ties"]) == 1,
          "%d top scorer(s)" % len(iw["ties"]))
    for key, got, label in (("recv", iw["recv"], "gRecvCmds"),
                            ("glink", iw["glink"], "gLink"),
                            ("iw_delta", iw["delta"], "IWRAM delta")):
        if key in exp:
            check(label, got == exp[key],
                  "got %s expected %s" % (h(got), h(exp[key])))

    # --- 3. EWRAM --------------------------------------------------------
    print("\n[3] EWRAM gTasks top candidates (sioResolveEwramDelta)")
    ew = scan_ewram(data)
    print("  distinct literals  : %d" % ew["distinct"])
    for rank, t in enumerate(ew["top"], 1):
        print("   #%d %s refs=%-5d range_ok=%s%s"
              % (rank, h(t["addr"]), t["refs"], t["in_range"],
                 "  <-- chosen" if t["addr"] == ew["chosen"] else ""))
    print("  chosen gTasks      : %s" % h(ew["chosen"]))
    print("  delta              : %s" % h(ew["delta"]))
    print("  NOTE: sioLooksLikeTasks() reads runtime EWRAM (GBAView32/8),")
    print("        which cannot be reproduced from ROM bytes alone; the offline")
    print("        approximation uses literal-count ranking + the 0x280 range check.")
    check("ew top candidate", bool(ew["top"]),
          "%d candidates with refs>=%d" % (len(ew["top"]), EWRAM_MIN_REFS))
    if "gtasks" in exp:
        check("gTasks (ROM-only)", ew["chosen"] == exp["gtasks"],
              "got %s expected %s" % (h(ew["chosen"]), h(exp["gtasks"])))
    if "ew_delta" in exp:
        check("EWRAM delta", ew["delta"] == exp["ew_delta"],
              "got %s expected %s" % (h(ew["delta"]), h(exp["ew_delta"])))

    # --- Summary ---------------------------------------------------------
    results = RESULTS
    failed = [name for name, ok, _ in results if not ok]
    print("\n" + "=" * 72)
    print("SUMMARY: %d checks, %d passed, %d failed -> %s"
          % (len(results), len(results) - len(failed), len(failed),
             "PASS" if not failed else "FAIL"))
    if failed:
        print("FAILED: " + ", ".join(failed))
    print("=" * 72)
    return 1 if failed else 0


if __name__ == "__main__":
    sys.exit(main())
