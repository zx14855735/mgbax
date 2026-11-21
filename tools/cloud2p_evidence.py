#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Cross-device 2P cloud E-1..E-8 machine-readable evidence parser (parse only).

Evidence rules
--------------
* docs/architecture/ADR-004-cross-device-2p-cloud-closeout.md section 3 (E-1..E-8 + anti-criteria)
* tools/cloud2p-duo.py::main summary.txt fields (:1144-1180)
* docs/architecture/ADR-003-cloud-2p-framerate.md section 6 (on-site criteria, five places)

Discipline (same as ADR-004)
----------------------------
* Every item emits PASS/FAIL/UNOBSERVED plus exact file:line refs. UNOBSERVED
  means "no evidence found in these logs", NOT "the feature does not exist" (R-10-7).
* Never treat linkup=1 (role=im0/lid0/st=0 menu leftover) as success; it is a trap.
* scope=PROXY-2PC is always NOT-CROSS-DEVICE regardless of other items.
* PC never prints "SIO fast on" (ADR-003 section 6.4); E-3 uses [SIO multi] last= step.

Usage
-----
    python tools/cloud2p_evidence.py --self-test
    python tools/cloud2p_evidence.py --run-dir .zcode-tmp/cloud2p/FR6 --scope PROXY-2PC
    python tools/cloud2p_evidence.py --sio A/mgba_sio.log --sio B/mgba_sio.log \
        --lobby A/mgba_lobby_debug.log --logcat logcat.txt --summary summary.txt \
        --scope CROSS-DEVICE-AVD --commit SHA --binary-md5 MD5 --source-md5 MD5
    # final gate (opt-in): physical two devices only, AVD can never be green
    python tools/cloud2p_evidence.py ... --scope REAL-DEVICE --strict-cross-device \
        --expect-uuid BPEE,<pc-rom-md5> --expect-uuid BPEE,<app-rom-md5>

Output: human table, then a "JSON:" line with structured JSON (--json FILE also saves).
"""

import argparse
import json
import os
import re
import sys

PASS, FAIL, UNO = "PASS", "FAIL", "UNOBSERVED"
SCOPES = ("PROXY-2PC", "CROSS-DEVICE-AVD", "REAL-DEVICE")

# ADR-004 E-2: hardcoded stale battle window (must be resolved from .map)
from gba_addrs import (             # 统一地址宏（AGENTS §5）
    STALE_BATTLE_LO as STALE_LO,    # 原值 0x08099848
    STALE_BATTLE_HI as STALE_HI,    # 原值 0x080A30FD
)
ERR_MASK = 0x7F000        # st error bits (LAG_MASTER / badChecksum / QUEUE_FULL ...)
MASTER_BIT = 0x20         # gLinkStatus LINK_STAT_MASTER


# ------------------------------------------------------------------ basics
class Src(object):
    """One input file: name + [(lineno, text)]. self-test builds in-memory Src."""
    def __init__(self, name, lines):
        self.name = name
        self.lines = lines


def load(path):
    rows = []
    try:
        with open(path, "r", encoding="utf-8", errors="replace") as f:
            for i, line in enumerate(f, 1):
                rows.append((i, line.rstrip("\r\n")))
    except OSError:
        pass
    return Src(path, rows)


def synth(text):
    """Build a synthetic Src from a text block (self-test)."""
    return [Src("SYNTH", [(i, ln) for i, ln in enumerate(text.splitlines(), 1)])]


def ref(name, lineno, text, limit=200):
    return {"file": name, "line": lineno, "text": text.strip()[:limit]}


KV_RE = re.compile(r"([A-Za-z_][A-Za-z0-9_]*)=([^\s]+)")


def kv(text):
    return {m.group(1): m.group(2) for m in KV_RE.finditer(text)}


def all_lines(ctx, kind):
    for s in ctx[kind]:
        for lineno, text in s.lines:
            yield s.name, lineno, text


def summary_kv(ctx):
    out = {}
    for name, lineno, text in all_lines(ctx, "summary"):
        for k, v in kv(text).items():
            out.setdefault(k, v)
    return out


def truthy(v):
    return str(v).strip().lower() in ("true", "yes", "1")


def numeric(v):
    return bool(re.fullmatch(r"\d+(?:\.\d+)?", str(v or "")))


def role_ok(v):
    """Valid elected link role: im8/lid0 (master) or im0/lid1 (slave)."""
    m = re.match(r"im(\d+)/lid(\d+)", v or "")
    if not m:
        return False
    return (m.group(1) == "8" and m.group(2) == "0") or \
           (m.group(1) == "0" and m.group(2) == "1")


# ------------------------------------------------------------------ diag scan
def scan_diags(ctx):
    """Scan every [diag] line once; produce shared facts for E-1/E-6/anti."""
    f = dict(rows=0, max_run=0, stable_ref=None, trap_count=0, trap_ref=None,
             err_count=0, err_ref=None, reset_count=0, reset_ref=None,
             rem1_ref=None, brs_ref=None, n8_max=0, n8_ref=None,
             last_trap=False, last_reset=False, last_err=False,
             last_diag=None, roles=set(), master_seen=False)
    run = 0
    last = None
    for name, lineno, text in all_lines(ctx, "sio"):
        if "[diag]" not in text:
            continue
        d = kv(text)
        f["rows"] += 1
        last = (d, name, lineno, text)
        try:
            lstate = int(d.get("lstate", "0"))
            pc = int(d.get("pc", "0"))
            st = int(d.get("st", "0"), 16)
            intr = int(d.get("intr", "0"))
            linkup = int(d.get("linkup", "0"))
        except (ValueError, TypeError):
            lstate = pc = intr = linkup = st = 0
        role = d.get("role", "")
        f["roles"].add(role.split("/hs")[0])
        master = bool(st & MASTER_BIT)
        if master:
            f["master_seen"] = True
        err = st & ERR_MASK
        if err and not f["err_ref"]:
            f["err_ref"] = ref(name, lineno, text)
        if err:
            f["err_count"] += 1
        if lstate == 1 and pc == 0 and intr == 0:
            f["reset_count"] += 1
            if not f["reset_ref"]:
                f["reset_ref"] = ref(name, lineno, text)
        # ADR-004 BLK-H4 / E2E-AVD-RUN: the residual signature is keyed on
        # linkup=1 + the un-elected role im0/lid0 + st without MASTER.  The
        # dominant real-world sample is lstate=2 pc=0 (1,562 lines in XDEV14),
        # so do NOT restrict lstate to (0,1): any non-stable state (<4) counts.
        is_trap = (linkup == 1 and role.startswith("im0/lid0") and
                   not master and lstate < 4)
        if is_trap:
            f["trap_count"] += 1
            if not f["trap_ref"]:
                f["trap_ref"] = ref(name, lineno, text)
        stable = (lstate == 4 and pc == 2 and master and not err and role_ok(role))
        if stable:
            run += 1
            if run > f["max_run"]:
                f["max_run"] = run
                f["stable_ref"] = ref(name, lineno, text)
        else:
            run = 0
        if d.get("rem") == "1" and not f["rem1_ref"]:
            f["rem1_ref"] = ref(name, lineno, text)
        if d.get("brs", "").startswith("0101") and not f["brs_ref"]:
            f["brs_ref"] = ref(name, lineno, text)
        m = re.search(r"n8=(\d+)", text)
        if m and int(m.group(1)) > f["n8_max"]:
            f["n8_max"] = int(m.group(1))
            f["n8_ref"] = ref(name, lineno, text)
    if last:
        d, name, lineno, text = last
        f["last_diag"] = ref(name, lineno, text)
        try:
            st = int(d.get("st", "0"), 16)
            f["last_trap"] = (int(d.get("linkup", "0")) == 1 and
                              d.get("role", "").startswith("im0/lid0") and
                              not (st & MASTER_BIT) and
                              int(d.get("lstate", "0")) < 4)
            f["last_reset"] = (int(d.get("lstate", "0")) == 1 and
                               int(d.get("pc", "0")) == 0 and
                               int(d.get("intr", "0")) == 0)
            f["last_err"] = bool(st & ERR_MASK)
        except (ValueError, TypeError):
            pass
    return f


# ------------------------------------------------------------------ netplay diag scan
def scan_netplay(ctx):
    """Fold the netplay-specific diagnostic tokens into structured facts.

    The original parser only looked at ``[diag]`` (sio), ``[sio-rtt]`` (lobby),
    the ``SIO fast`` boolean (logcat) and a curated set of summary keys.  Every
    token scanned below is genuinely emitted by the product/driver; this
    function makes them consumable by the E items and by the JSON evidence.
    It does not by itself change a verdict - each E item decides what is
    dispositive, the rest stays as supporting evidence.
    """
    np = {
        # lobby: raw machine-readable emits
        "p2p_result": {},      # [MGBAX_P2P] event=result (authoritative P2P outcome)
        "direct_diag": {},     # [direct] P2P 已启用 / p2p-rtt -> diagnosticsText()
        "path": {},            # [MGBAX_PATH] path=A|B mode= officialMode= transport= frameEnc=
        "gate": {},            # [MGBAX_GATE] env* / fastMinOk* ...
        "p2p_result_ref": None, "direct_diag_ref": None,
        "path_ref": None, "gate_ref": None,
        # sio + logcat: per-round / fast-gate proof
        "rearm_fired": 0, "rearm_rounds": 0, "rearm_hs1": 0, "rearm_ref": None,
        "slave_align_blocked_max": 0, "slave_align_blocked_ref": None,
        "sio_fast": {},        # SIO fast ... idx/pidx/pq/alignblk/n/reuse/miss
        "sio_fast_on": {},     # SIO fast on ... idx/ok/lstate/pc/minOk/...
        "sio_fast_ref": None,
        # logcat: Android-side channels / candidates / C0 decision
        "pa_frame": {},        # channels + directions seen
        "pa_direct": {},       # cand_me / cand_peer
        "c0_gate": {},         # last [C0-GATE] gate= decision
        "pa_frame_ref": None, "pa_direct_ref": None, "c0_gate_ref": None,
        # driver-derived summary keys (supporting evidence, not new E verdicts)
        "summary": {},
    }

    for name, lineno, text in all_lines(ctx, "lobby"):
        if "[MGBAX_P2P]" in text and "event=result" in text:
            np["p2p_result"] = kv(text)
            np["p2p_result_ref"] = ref(name, lineno, text)
        elif ("[direct]" in text and
              ("P2P 已启用" in text or "p2p-rtt" in text) and "via=" in text):
            np["direct_diag"] = kv(text)
            np["direct_diag_ref"] = ref(name, lineno, text)
        elif "[MGBAX_PATH]" in text and "path=" in text and "event=" not in text:
            d = kv(text)
            if "path" in d:
                np["path"] = d
                np["path_ref"] = ref(name, lineno, text)
        elif "[MGBAX_GATE]" in text:
            np["gate"] = kv(text)
            np["gate_ref"] = ref(name, lineno, text)

    for kind in ("sio", "logcat"):
        for name, lineno, text in all_lines(ctx, kind):
            if "[rearm] fired" in text:
                np["rearm_fired"] += 1
                if re.search(r"\bhs=1\b", text):
                    np["rearm_hs1"] += 1
                if not np["rearm_ref"]:
                    np["rearm_ref"] = ref(name, lineno, text)
            elif "[rearm] round" in text:
                np["rearm_rounds"] += 1
                if re.search(r"\bhs=1\b", text):
                    np["rearm_hs1"] += 1
                if not np["rearm_ref"]:
                    np["rearm_ref"] = ref(name, lineno, text)
            elif "slave fast align gate blocked" in text:
                m = re.search(r"\bn=(\d+)", text)
                if m and int(m.group(1)) > np["slave_align_blocked_max"]:
                    np["slave_align_blocked_max"] = int(m.group(1))
                    np["slave_align_blocked_ref"] = ref(name, lineno, text)
            elif "SIO fast on" in text:
                np["sio_fast_on"] = kv(text)
                if not np["sio_fast_ref"]:
                    np["sio_fast_ref"] = ref(name, lineno, text)
            elif "SIO fast" in text:
                np["sio_fast"] = kv(text)
                if not np["sio_fast_ref"]:
                    np["sio_fast_ref"] = ref(name, lineno, text)
            elif "[PA-FRAME]" in text:
                d = kv(text)
                ch, direction = d.get("ch", ""), d.get("dir", "")
                if ch:
                    np["pa_frame"].setdefault("channels", set()).add(ch)
                if direction:
                    np["pa_frame"].setdefault("dirs", set()).add(direction)
                for key in ("frames", "chunks", "rawbytes", "n"):
                    if key in d:
                        np["pa_frame"].setdefault(key + "_values", []).append(d[key])
                if not np["pa_frame_ref"]:
                    np["pa_frame_ref"] = ref(name, lineno, text)
            elif "[PA-DIRECT]" in text:
                d = kv(text)
                for key in ("cand_me", "cand_peer", "localPort", "phase"):
                    if key in d:
                        np["pa_direct"][key] = d[key]
                if not np["pa_direct_ref"]:
                    np["pa_direct_ref"] = ref(name, lineno, text)
            elif "[C0-GATE]" in text:
                np["c0_gate"] = kv(text)
                if not np["c0_gate_ref"]:
                    np["c0_gate_ref"] = ref(name, lineno, text)

    # sets are not JSON-serialisable -> flatten to sorted lists
    for key in ("channels", "dirs"):
        np["pa_frame"][key] = sorted(np["pa_frame"].pop(key, set()))

    # driver-derived summary keys (the two-stage pipeline: source -> driver -> summary)
    summary_text = "\n".join(t for _, _, t in all_lines(ctx, "summary"))
    keys = ("scope", "in_battle_frame", "pathB_2p_bus_ok", "rearm_A", "rearm_B",
            "slave_fast_align_blocked_A", "slave_fast_align_blocked_B",
            "badchecksum_A", "badchecksum_B", "bus_A", "bus_B",
            "bus_diag_A", "bus_diag_B", "gate_A", "gate_B",
            "p2p_result_A", "p2p_result_B", "p2p_avg_A", "p2p_avg_B",
            "p2p_ignored_A", "p2p_ignored_B", "peerCandidateCount_A",
            "peerCandidateCount_B", "path_A", "path_B", "env_fast_slave_align")
    sk = ctx.get("sk") or summary_kv(ctx)
    for key in keys:
        if key in sk:
            np["summary"][key] = sk[key]
    # rearm_A/B are compound ("fired=.. hs1=.. rounds=.."); parse the sub-fields too
    for side in ("A", "B"):
        m = re.search(r"rearm_%s\s+fired=(\S+)\s+hs1=(\S+)\s+rounds=(\S+)" % side,
                      summary_text)
        if m:
            np["summary"]["rearm_%s_fired" % side] = m.group(1)
            np["summary"]["rearm_%s_hs1" % side] = m.group(2)
            np["summary"]["rearm_%s_rounds" % side] = m.group(3)
    return np


def netplay_payload(np):
    """JSON-serialisable view of the netplay diagnostic facts."""
    ref_keys = ("p2p_result_ref", "direct_diag_ref", "path_ref", "gate_ref",
                "rearm_ref", "slave_align_blocked_ref", "sio_fast_ref",
                "pa_frame_ref", "pa_direct_ref", "c0_gate_ref")
    return {
        "p2p_result": np["p2p_result"],
        "direct_diag": np["direct_diag"],
        "path": np["path"],
        "gate": np["gate"],
        "rearm": {"fired": np["rearm_fired"], "rounds": np["rearm_rounds"],
                  "hs1": np["rearm_hs1"]},
        "slave_fast_align_blocked_max": np["slave_align_blocked_max"],
        "sio_fast": np["sio_fast"],
        "sio_fast_on": np["sio_fast_on"],
        "pa_frame": np["pa_frame"],
        "pa_direct": np["pa_direct"],
        "c0_gate": np["c0_gate"],
        "summary": np["summary"],
        "refs": {k: np[k] for k in ref_keys if np[k]},
    }


# ------------------------------------------------------------------ E items
def e1(ctx, sk, diag):
    ss = sk.get("stable_s", "")
    if numeric(ss):
        dur_ok, dur_note = float(ss) >= 5, "stable_s=%s" % ss
    elif truthy(sk.get("linkup_stable")) and numeric(sk.get("linkup_s")):
        dur_ok, dur_note = False, "linkup_stable only (--stable-sec default 3s); >=5s unproven"
    else:
        dur_ok, dur_note = False, "no stable duration field"
    sig_ok = diag["max_run"] >= 2
    if sig_ok and dur_ok:
        status, summary = PASS, "stable l=4 pc=2 MASTER, run=%d, %s" % (diag["max_run"], dur_note)
    elif diag["trap_count"] and not sig_ok:
        status, summary = FAIL, "trap linkup=1 role=im0/lid0 st=0; no stable window"
    elif sig_ok:
        status, summary = UNO, "stable signature seen but %s" % dur_note
    else:
        status, summary = UNO, "no l=4/pc=2/MASTER stable window"
    refs = []
    if diag["stable_ref"]:
        refs.append(diag["stable_ref"])
    if diag["trap_ref"]:
        refs.append(diag["trap_ref"])
    return mk(status, summary, refs,
              max_stable_samples=diag["max_run"], duration=dur_note,
              master_seen=diag["master_seen"], trap_count=diag["trap_count"])


WINDOW_RE = re.compile(r"\[0x([0-9A-Fa-f]+)\s*,\s*0x([0-9A-Fa-f]+)\)")


def window_tuple(win):
    """Parse ``[0xLO,0xHI)`` numerically so leading-zero formatting cannot
    hide the hardcoded stale window (e.g. [0x8099848,0x80A30FD))."""
    m = WINDOW_RE.search(win or "")
    if not m:
        return None
    return int(m.group(1), 16), int(m.group(2), 16)


def e2(ctx, sk):
    battle = sk.get("BATTLE", "")
    samples = sk.get("battle_samples", "")
    try:
        samples = int(samples)
    except (ValueError, TypeError):
        samples = 0
    win = sk.get("battle_window", "")
    source = sk.get("source", "")
    w = window_tuple(win)
    stale = ((source in ("UNKNOWN", "-", "")) or w == (STALE_LO, STALE_HI) or
             (win == "[0x%08X,0x%08X)" % (STALE_LO, STALE_HI)) or
             (bool(win) and w is None))
    # in_battle_frame is the driver's frame-level in-battle proof.  When present
    # it must agree with BATTLE=YES; a False here contradicts a YES verdict.
    ibf = sk.get("in_battle_frame", "")
    ibf_present = ibf != ""
    ibf_true = truthy(ibf)
    # optional .map cross-check
    mref = None
    if ctx.get("map_path"):
        name, lo, hi = resolve_map(ctx["map_path"])
        if name:
            mref = {"file": name, "line": 0, "text": "battle_main.o .text -> [0x%X,0x%X)" % (lo, hi)}
    refs = []
    for name, lineno, text in all_lines(ctx, "summary"):
        if "BATTLE=" in text or "battle_window=" in text or "in_battle_frame=" in text:
            refs.append(ref(name, lineno, text))
    if mref:
        refs.append(mref)
    if battle == "YES" and samples > 0 and not stale and (not ibf_present or ibf_true):
        status, summary = PASS, "BATTLE=YES samples=%d window=%s src=%s in_battle_frame=%s" % (
            samples, win, source, ibf or "-")
    elif ibf_present and not ibf_true and battle == "YES":
        status, summary = FAIL, "BATTLE=YES but in_battle_frame=%s (in-battle proof contradicted)" % ibf
    elif battle == "YES" and stale:
        status, summary = FAIL, "STALE_BATTLE_WINDOW (hardcoded/missing .map)"
    elif battle == "NO":
        status, summary = FAIL, "BATTLE=NO"
    else:
        status, summary = UNO, "no BATTLE field in summary"
    return mk(status, summary, refs[:6], battle=battle, samples=samples,
              window=win, source=source, stale=stale,
              in_battle_frame=ibf, in_battle_frame_true=(ibf_true if ibf_present else None))


def resolve_map(path):
    try:
        text = open(path, "r", encoding="utf-8", errors="replace").read()
    except OSError:
        return None, 0, 0
    m = re.search(r"\.text\s+(?:0x)?([0-9A-Fa-f]{6,8})\s+(?:0x)?([0-9A-Fa-f]+)\s+\S*battle_main\.o\b", text, re.M)
    if not m:
        return path, 0, 0
    start = int(m.group(1), 16)
    return path, start, start + int(m.group(2), 16)


def e3(ctx, sk, np):
    fps = []
    for k in ("fps_pc_A", "fps_pc_B"):
        if numeric(sk.get(k)):
            fps.append(float(sk[k]))
    fast_pc = False
    fast_refs = []
    # New summaries use fps_pc_A / multi_A last=; older ones embed "fps=59.6"
    # inside final_A and "last=0.4ms" inside multi_A. Scan raw lines for both.
    for name, lineno, text in all_lines(ctx, "summary"):
        for m in re.findall(r"fps=([0-9.]+)", text):
            if numeric(m):
                fps.append(float(m))
        for m in re.findall(r"last=([0-9.]+)ms", text):
            if float(m) < 2.0:
                fast_pc = True
                fast_refs.append(ref(name, lineno, text))
    fast_app = False
    for name, lineno, text in all_lines(ctx, "logcat"):
        if "SIO fast" in text:
            fast_app = True
            fast_refs.append(ref(name, lineno, text))
            break
    refs = []
    for name, lineno, text in all_lines(ctx, "summary"):
        if "fps_pc_" in text or "multi_" in text:
            refs.append(ref(name, lineno, text))
    refs = (refs[:4] + fast_refs[:2])
    good = [v for v in fps if 50.0 <= v <= 61.0]
    # E-3 is an IN-BATTLE frame-rate criterion (ADR-004 §3 / E2E-AVD-RUN §4):
    # a ~60fps reading in the lobby/menu (BATTLE=NO, battle_samples=0, or an
    # explicit in_battle_frame=False) is NOT evidence and must not go green.
    battle_samples = 0
    try:
        battle_samples = int(sk.get("battle_samples", "") or 0)
    except (ValueError, TypeError):
        pass
    ibf_val = sk.get("in_battle_frame", "")
    ibf_contradicts = ibf_val != "" and not truthy(ibf_val)
    in_battle = (sk.get("BATTLE") == "YES" and battle_samples > 0 and not ibf_contradicts)
    if good and (fast_pc or fast_app) and not in_battle:
        status, summary = UNO, ("fps=%s + fast seen but NOT in-battle "
                                "(BATTLE=%s battle_samples=%s in_battle_frame=%s); "
                                "menu-state fps does not satisfy E-3" %
                                (good, sk.get("BATTLE", "-"), battle_samples, ibf_val or "-"))
    elif good and (fast_pc or fast_app):
        status, summary = PASS, "in-battle fps=%s fast_pc=%s fast_app=%s" % (good, fast_pc, fast_app)
    elif good and not (fast_pc or fast_app):
        status, summary = UNO, "fps=%s but no fast evidence (RTT low: hit count 0 is normal)" % good
    elif fps and max(fps) < 50:
        status, summary = FAIL, "fps=%s below 50" % fps
    else:
        status, summary = UNO, "no fps reading"
    # e3 used to record only a `SIO fast` boolean; keep the idx-alignment values
    # that A1/A2 emit (cross-end pidx/idx/alignblk proof lives in these fields).
    sio_fast = np["sio_fast"]
    idx_fields = {k: sio_fast.get(k, "") for k in
                  ("idx", "pidx", "pq", "alignblk", "n", "reuse", "miss")}
    return mk(status, summary, refs, fps=fps, fast_pc=fast_pc, fast_app=fast_app,
              in_battle=in_battle, battle_samples=battle_samples,
              in_battle_frame=(ibf_val or None),
              sio_fast=idx_fields, pa_frame=np["pa_frame"])


def e4(ctx, sk, np):
    via = sk.get("via", "")
    pa, pb = sk.get("peerCandidates_A", ""), sk.get("peerCandidates_B", "")
    # Raw emits are authoritative when the summary (older driver) lacks them.
    pr, dd = np["p2p_result"], np["direct_diag"]
    raw_via = pr.get("via") or dd.get("via") or ""
    if not via:
        via = raw_via
    raw_pc = pr.get("peerCandidates") or dd.get("peerCandidates") or ""
    result = pr.get("result", "")
    refs = []
    for name, lineno, text in all_lines(ctx, "lobby"):
        if "[sio-rtt]" in text:
            refs.append(ref(name, lineno, text))
            if len(refs) >= 2:
                break
    for name, lineno, text in all_lines(ctx, "summary"):
        if "via=" in text or "peerCandidates_" in text:
            refs.append(ref(name, lineno, text))
    for key in ("p2p_result_ref", "direct_diag_ref", "pa_direct_ref", "pa_frame_ref"):
        if np[key]:
            refs.append(np[key])
    peers_present = bool(pa or pb)
    # ADR-004 R-4 / E2E-AVD-RUN §3.3: no-peer-candidates is the concrete
    # "peerCandidates=0" failure (PC candidates echoed self:true -> via=tunnel).
    # It must never be allowed to coexist with an E-4 PASS just because the
    # summary still carries a stale via=p2p / peerCandidates=True pair.
    FAILED_P2P = ("abort", "aborted", "fail", "failed", "error", "refused",
                  "no-peer-candidates", "no_peer_candidates", "no-candidates",
                  "no_candidates", "timeout")
    result_signals = [result]
    result_signals += [sk.get("p2p_result_%s" % s, "") for s in ("A", "B", "PC")]
    failed_result = any(str(v).strip().lower() in FAILED_P2P
                        for v in result_signals if str(v).strip())
    if failed_result:
        status, summary = FAIL, "[MGBAX_P2P] event=result result=%s (P2P setup failed)" % (
            result or next(v for v in result_signals if str(v).strip().lower() in FAILED_P2P))
    elif via == "p2p" and truthy(pa) and truthy(pb):
        status, summary = PASS, "via=p2p peerCandidates A=%s B=%s" % (pa, pb)
    elif via == "tunnel" or raw_via == "tunnel":
        status, summary = FAIL, "via=tunnel (not P2P direct)"
    elif peers_present and not (truthy(pa) and truthy(pb)):
        status, summary = FAIL, "peerCandidates present but not both >0: A=%s B=%s" % (pa, pb)
    elif via == "p2p":
        status, summary = UNO, "via=p2p but peerCandidates fields absent (old summary)"
    else:
        status, summary = UNO, "no via / peerCandidates fields"
    return mk(status, summary, refs[:6], via=via, peers=[pa, pb],
              p2p_result=pr, p2p_diag=dd, raw_peerCandidates=raw_pc,
              pa_direct=np["pa_direct"], pa_frame=np["pa_frame"])


def e5(ctx, sk, np):
    ma, mb = sk.get("mode_negotiated_A", ""), sk.get("mode_negotiated_B", "")
    oa, ob = sk.get("official_mode_A", ""), sk.get("official_mode_B", "")
    nav = sk.get("nav_at_leak", "")
    path, cg = np["path"], np["c0_gate"]
    refs = []
    for name, lineno, text in all_lines(ctx, "summary"):
        if "mode_negotiated_" in text or "official_mode_" in text or "nav_at_leak=" in text:
            refs.append(ref(name, lineno, text))
    for key in ("path_ref", "c0_gate_ref"):
        if np[key]:
            refs.append(np[key])
    ok = False
    if ma and mb:
        if ma == mb == "A":
            ok = (not truthy(oa)) and (not truthy(ob)) and (not truthy(nav))
        elif ma == mb == "B":
            ok = not truthy(nav)
    # C0 negotiation gate: these values are explicit mode-negotiation failures.
    c0_rejected = cg.get("gate", "") in ("SHORT_CIRCUIT", "PEER_INVALID",
                                         "PEER_UNKNOWN", "CONFLICT")
    if c0_rejected:
        status, summary = FAIL, "[C0-GATE] gate=%s (mode negotiation rejected)" % cg.get("gate")
    elif ma and mb and ok:
        status, summary = PASS, "negotiated A=%s B=%s official=%s/%s nav_leak=%s" % (ma, mb, oa, ob, nav)
    elif ma and mb:
        status, summary = FAIL, "mode mismatch/downgrade A=%s B=%s official=%s/%s nav_leak=%s" % (ma, mb, oa, ob, nav)
    else:
        status, summary = UNO, "no mode_negotiated fields"
    return mk(status, summary, refs[:4], negotiated=[ma, mb], official=[oa, ob],
              nav_leak=nav, mgbx_path=path, c0_gate=cg,
              pathB_2p_bus_ok=np["summary"].get("pathB_2p_bus_ok", ""))


def e6(ctx, sk, diag):
    linkup_s = sk.get("linkup_s", "")
    reached = numeric(linkup_s)
    refs = []
    for name, lineno, text in all_lines(ctx, "summary"):
        if "linkup_s=" in text:
            refs.append(ref(name, lineno, text))
    for r in (diag["rem1_ref"], diag["brs_ref"], diag["n8_ref"]):
        if r:
            refs.append(r)
    note = "brs is cleared after card copy; rem=1 / ts are authoritative"
    if not reached:
        status, summary = FAIL, "linkup_s not numeric (%s) - never reached LINKUP" % linkup_s
    elif diag["rem1_ref"] and diag["n8_max"] > 0:
        status, summary = PASS, "linkup_s=%s rem=1 brs=0101 n8=%d" % (linkup_s, diag["n8_max"])
    elif diag["rem1_ref"] and diag["brs_ref"]:
        status, summary = UNO, "rem=1 + brs=0101 but n8=0 (block channel not proven); %s" % note
    elif not diag["rem1_ref"]:
        status, summary = FAIL, "rem=0 (no remote player / block exchange)"
    else:
        status, summary = UNO, "middle-state evidence incomplete"
    badchecksum = {s: sk.get("badchecksum_%s" % s, "") for s in ("A", "B")}
    return mk(status, summary, refs[:6], linkup_s=linkup_s, rem1=bool(diag["rem1_ref"]),
              brs=bool(diag["brs_ref"]), n8=diag["n8_max"], note=note,
              badchecksum=badchecksum)


EMAIL_RE = re.compile(r"[\w.+-]+@[\w-]+\.[\w.-]+")
UUID_RE = re.compile(r"BPEE,[0-9a-fA-F]{32}")
ADVERTISED_RE = re.compile(r"advertised relay .*? for room (\d{4,8})\b")
ROOM_JSON_ID_RE = re.compile(r"room_id[\"']?\s*[:=]\s*[\"']?(\d{4,8})\b")
ROOM_STR_RE = re.compile(r"room[\"']?\s*[:=]\s*[\"']?(\d{4,8})\b")
STALE_ROOM_RE = re.compile(r"stale\s+room\s+(\d{4,8})\b", re.I)
SERIAL_RE = re.compile(r"(?:device_serial|serial|udid|device_id)[=: ]+([\w-]{6,})")
DEVICE_KEY_RE = re.compile(r"\b(device_(?:A|B|PC|app|serial_A|serial_B))\s*=\s*([^\s]+)")
ADB_DEVICE_RE = re.compile(r"^\s*([A-Za-z0-9]{8,})\s+device\s*$")
ROOM_END_KEYS = (("room_pc", "pc"), ("room_A", "A"), ("room", "pc"),
                 ("room_app", "app"), ("room_B", "B"))


def scan_devices(ctx, sk):
    """Split device evidence into rooms vs emulators vs PHYSICAL identities.

    The old E-7 used one mixed ``devices`` set whose ``or len(uuids)>=2``
    clause made the device requirement vacuous: an AVD plus two room ids (the
    two-room split from E2E-AVD-RUN) could score a topology PASS.  Keeping the
    three buckets separate makes each trap independently visible.

    Room ids are kept as an ordered event stream so TWO_ROOM_SPLIT can tell a
    stale/pre-join room (explicitly left or superseded) from two rooms that
    are genuinely active in the same window (E2-FAST false positive).
    """
    accounts, uuids = set(), set()
    emulators, physical = set(), set()
    room_events = []
    seq = 0
    # explicit per-side binding emitted by the driver / operator
    for key in ("device_A", "device_B", "device_PC", "device_app",
                "device_serial_A", "device_serial_B"):
        v = str(sk.get(key, "") or "").strip()
        if v and v.lower() not in ("-", "none", "unknown"):
            physical.add(v)
    for kind in ("lobby", "logcat", "summary"):
        for name, lineno, text in all_lines(ctx, kind):
            seq += 1
            for m in EMAIL_RE.findall(text):
                low = m.lower()
                if not any(x in low for x in ("google", "gms", "android", "example")):
                    accounts.add(low)
            uuids.update(UUID_RE.findall(text))
            ids = set()
            m = ADVERTISED_RE.search(text)
            if m:
                ids.add(m.group(1))
            ids.update(ROOM_JSON_ID_RE.findall(text))
            ids.update(ROOM_STR_RE.findall(text))
            # "own" = this end actually joined/advertised the room.  Incoming
            # peer messages ("<-", "(peer)") only OBSERVE a room, they do not
            # prove that end was sitting in it.
            own = not text.lstrip().startswith("<-")
            if "(peer)" in text and "(self)" not in text:
                own = False
            retired = set(STALE_ROOM_RE.findall(text))
            if "leave_room" in text:
                retired.update(ids)
            for rid in ids:
                room_events.append(dict(src=name, seq=seq, line=lineno, rid=rid,
                                        own=own, retire=rid in retired))
            # "host: stale room 673931" / bare leave_room lines carry the room
            # id only in the marker, not in a room_id= token: emit the retire
            # event explicitly so the room is still excluded from active set.
            for rid in retired - ids:
                room_events.append(dict(src=name, seq=seq, line=lineno, rid=rid,
                                        own=False, retire=True))
            emulators.update(re.findall(r"emulator-\d+", text))
            for m in SERIAL_RE.findall(text):
                if not m.lower().startswith("emulator"):
                    physical.add(m)
            for key, m in DEVICE_KEY_RE.findall(text):
                if m.lower() not in ("-", "none", "unknown"):
                    physical.add(m)
            m = ADB_DEVICE_RE.match(text)
            if m and not m.group(1).lower().startswith("emulator"):
                physical.add(m.group(1))
    physical = {p for p in physical if not p.lower().startswith("emulator")}
    retired_all = {e["rid"] for e in room_events if e["retire"]}
    active = sorted({e["rid"] for e in room_events if e["rid"] not in retired_all})
    return dict(accounts=sorted(accounts), uuids=sorted(uuids),
                rooms=active, emulators=sorted(emulators),
                physical=sorted(physical), room_events=room_events,
                retired_rooms=sorted(retired_all))


def room_split_facts(ctx, sk):
    """TWO_ROOM_SPLIT requires BOTH of these (E2-FAST false-positive guard):

    (a) two ROOMS ARE ADVERTISED IN THE SAME ACTIVE TIME WINDOW.  Rooms that
        were explicitly marked ``stale room`` / left via ``leave_room`` (or
        superseded before being advertised again) are excluded.  Remaining
        rooms need overlapping first..last reference windows.
    (b) THE TWO ENDS REFERENCE DIFFERENT ROOMS.  Prefer summary
        room_pc/room_app (room_A/room_B) bindings; when only one end is bound,
        combine it with rooms advertised/joined by the other end's own log
        events.  If BOTH ends are explicitly bound to the same room, no split.

    E2-FAST: a-lobby has ``stale room 673931`` + leave_room, both ends then use
    570954 -> (a) false and (b) false -> no split.
    """
    d = ctx.get("devices") or {}
    events = d.get("room_events", [])
    active = d.get("rooms", [])
    by_room = {}
    for ev in events:
        by_room.setdefault(ev["rid"], []).append(ev)
    windows = {rid: (min(e["seq"] for e in by_room[rid]),
                     max(e["seq"] for e in by_room[rid])) for rid in active}
    rids = sorted(windows)
    pair = None
    concurrent = False
    for i, a in enumerate(rids):
        for b in rids[i + 1:]:
            a1, a2 = windows[a]
            b1, b2 = windows[b]
            if a1 <= b2 and b1 <= a2:
                concurrent, pair = True, (a, b)
                break
        if concurrent:
            break

    src_own = {}
    for ev in events:
        if ev["own"] and ev["rid"] in windows:
            src_own.setdefault(ev["src"], set()).add(ev["rid"])
    summary_rooms = {}
    for key, end in ROOM_END_KEYS:
        v = str(sk.get(key, "") or "").strip()
        if v:
            summary_rooms.setdefault(end, v)
    explicit_both = (("room_pc" in sk or "room_A" in sk) and
                     ("room_app" in sk or "room_B" in sk))
    if explicit_both:
        end_rooms = set(summary_rooms.values())
    else:
        end_rooms = set(summary_rooms.values())
        for rooms in src_own.values():
            end_rooms |= {r for r in rooms if r not in summary_rooms.values()}
    ends_differ = len(end_rooms) >= 2
    split = bool(concurrent and ends_differ)
    return dict(split=split, concurrent=concurrent, ends_differ=ends_differ,
                active_rooms=rids, retired_rooms=d.get("retired_rooms", []),
                pair=list(pair) if pair else [],
                windows={k: list(v) for k, v in sorted(windows.items())},
                summary_rooms=summary_rooms,
                per_source_own={k: sorted(v) for k, v in sorted(src_own.items())},
                end_rooms=sorted(end_rooms),
                explicit_both=explicit_both)


def e7(ctx, sk):
    scope = ctx["scope"]
    d = ctx.get("devices") or scan_devices(ctx, sk)
    accounts, uuids = d["accounts"], d["uuids"]
    rooms, emulators, physical = d["rooms"], d["emulators"], d["physical"]
    device_tokens = set(rooms) | set(emulators) | set(physical)
    strict = bool(ctx.get("strict_cross_device"))
    refs = []
    for kind in ("summary", "logcat", "lobby"):
        for name, lineno, text in all_lines(ctx, kind):
            if "@" in text and EMAIL_RE.search(text):
                refs.append(ref(name, lineno, text))
                break
    detail = dict(accounts=accounts, uuids=uuids[:4],
                  devices=sorted(device_tokens), rooms=rooms,
                  emulators=emulators, physical=physical, strict=strict,
                  expected_uuids=ctx.get("expect_uuids") or [])
    if scope == "PROXY-2PC":
        status, summary = FAIL, "scope=PROXY-2PC (same-machine/agent topology, not cross-device)"
    elif (ctx.get("room_split") or {}).get("split"):
        # E2E-AVD-RUN: 572161 + 505099 concurrently, the two ends in different
        # rooms -> session migrated.  A stale/superseded room alone is not a
        # split (E2-FAST: stale 673931 then both ends in 570954).
        rs = ctx["room_split"]
        status, summary = FAIL, ("two-room split rooms=%s (concurrent active "
                                 "windows, ends reference %s)" %
                                 (rs["pair"], rs["end_rooms"]))
    elif strict and scope == "CROSS-DEVICE-AVD":
        status, summary = FAIL, ("strict-cross-device: CROSS-DEVICE-AVD is "
                                 "emulator-backed; two physical devices required")
    elif strict and len(physical) < 2:
        status, summary = FAIL, ("strict-cross-device: only %d physical device "
                                 "identity/identities (emulator=%s room=%s); two "
                                 "physical devices required" %
                                 (len(physical), emulators, rooms))
    elif strict and (ctx.get("expect_uuids") or []):
        expected = set(ctx["expect_uuids"])
        missing = sorted(expected - set(uuids))
        if missing:
            status, summary = FAIL, ("strict-cross-device: expected ROM uuid(s) "
                                     "missing %s (stale/wrong ROM, e.g. bus4.gba)" % missing)
        else:
            status, summary = PASS, ("2 accounts + 2 uuids + 2 PHYSICAL devices "
                                     "(scope=%s strict, uuids bound)" % scope)
    elif len(accounts) >= 2 and len(uuids) >= 2 and len(device_tokens) >= 2:
        # Default (non-strict) behaviour preserved: two accounts + two uuids
        # + two device identifiers (physical, emulator or room) may PASS.
        status, summary = PASS, "2 accounts + 2 uuids + 2 devices (scope=%s)" % scope
    else:
        status, summary = UNO, "accounts=%d uuids=%d devices=%d (scope=%s)" % (
            len(accounts), len(uuids), len(device_tokens), scope)
    # summary scope= is parsed for provenance only; the CLI --scope stays
    # authoritative so the PROXY-2PC anti-criterion cannot be talked away.
    return mk(status, summary, refs[:4], scope=scope,
              summary_scope=sk.get("scope", ""), **detail)


def e8(ctx, sk):
    blob = "\n".join(t for k in ("summary", "lobby", "logcat") for _, _, t in all_lines(ctx, k))
    commit = ctx.get("commit") or ""
    binmd5 = ctx.get("binary_md5") or ""
    srcmd5 = ctx.get("source_md5") or ""
    if not commit:
        m = re.search(r"commit[=: ]+([0-9a-fA-F]{7,40})", blob)
        commit = m.group(1) if m else ""
    if not binmd5:
        m = re.search(r"(?:mGBA|test-gboylink|binary|exe)[^\n]*?([0-9a-fA-F]{32})", blob)
        binmd5 = m.group(1) if m else ""
    if not srcmd5:
        m = re.search(r"source[^\n]*?([0-9a-fA-F]{32})", blob)
        srcmd5 = m.group(1) if m else ""
    provided = {k: bool(ctx[k]) for k in ("lobby", "sio", "logcat", "summary")}
    refs = []
    for name, lineno, text in all_lines(ctx, "summary"):
        if "EXIT=" in text or "exitcode_" in text:
            refs.append(ref(name, lineno, text))
    ok = bool(commit and binmd5 and srcmd5 and all(provided.values()))
    if ok:
        status, summary = PASS, "commit=%s bin=%s src=%s logs bound" % (commit[:10], binmd5[:10], srcmd5[:10])
    else:
        missing = [k for k, v in (("commit", commit), ("binary_md5", binmd5),
                                  ("source_md5", srcmd5)) if not v]
        status, summary = UNO, "missing binding: %s" % (", ".join(missing) or "log set")
    return mk(status, summary, refs[:4], commit=commit, binary_md5=binmd5,
              source_md5=srcmd5, inputs=provided)


# ------------------------------------------------------------------ verdict
def anti_criteria(ctx, diag, statuses):
    out = []

    def add(name, hit, explanation, refs):
        out.append({"name": name, "hit": hit, "explanation": explanation, "refs": refs})

    # Trap is disqualifying only when it is the latest [diag] state or there is
    # no genuine stable window; historical trap lines before a real link are normal.
    trap_hit = diag["trap_count"] > 0 and (diag["last_trap"] or diag["max_run"] < 2)
    add("KNOWN_TRAP_LINKUP_RESIDUAL", trap_hit,
        "linkup=1 with role=im0/lid0/st=0 is a menu leftover, not LINKUP success",
        [r for r in (diag["trap_ref"],) if r])
    last_reset_hit = diag["last_reset"] and diag["max_run"] < 2
    add("RESET_SIGNATURE", last_reset_hit,
        "last [diag] is lstate=1 pc=0 intr=0 (CpuFill32(&gLink) reset)",
        [diag["last_diag"]] if diag["last_diag"] else [])
    add("ERROR_BITS", diag["last_err"],
        "st contains 0x7F000 error bits at last sample (total=%d)" % diag["err_count"],
        [r for r in (diag["err_ref"],) if r])
    same_machine = ctx["scope"] == "PROXY-2PC" and ctx["sk"].get("BATTLE") == "YES"
    add("SAME_MACHINE_BATTLE", same_machine,
        "BATTLE=YES under PROXY-2PC is same-machine evidence, not cross-device", [])
    d = ctx.get("devices") or {}
    strict = bool(ctx.get("strict_cross_device"))
    rs = ctx.get("room_split") or {}
    add("TWO_ROOM_SPLIT", bool(rs.get("split")),
        "two rooms active in the same window AND the two ends reference different rooms "
        "(stale/pre-join room excluded)", [])
    add("AVD_UNDER_STRICT", strict and ctx["scope"] == "CROSS-DEVICE-AVD",
        "--strict-cross-device rejects emulator-backed CROSS-DEVICE-AVD scope", [])
    add("EMULATOR_UNDER_STRICT",
        strict and ctx["scope"] == "REAL-DEVICE" and
        bool(d.get("emulators")) and len(d.get("physical", [])) < 2,
        "scope=REAL-DEVICE but only emulator device identities present", [])
    return out


def verdict_for(ctx, statuses, anti):
    if ctx["scope"] == "PROXY-2PC":
        return "NOT-CROSS-DEVICE", "scope=PROXY-2PC forces NOT-CROSS-DEVICE regardless of E items"
    # Opt-in final gate: an AVD is a real end-to-end topology for debugging,
    # but it is NOT two physical devices and must never flip the release gate.
    if ctx.get("strict_cross_device") and ctx["scope"] == "CROSS-DEVICE-AVD":
        return "NOT-CROSS-DEVICE", ("strict-cross-device: CROSS-DEVICE-AVD is "
                                    "emulator-backed; two physical devices required")
    hits = [a["name"] for a in anti if a["hit"]]
    if "KNOWN_TRAP_LINKUP_RESIDUAL" in hits:
        return "TRAP-LINKUP-RESIDUAL", "known linkup=1 menu-leftover trap detected"
    if hits:
        return "FAIL", "anti-criteria hit: " + ", ".join(hits)
    if all(s == PASS for s in statuses.values()):
        return "CROSS-DEVICE-GREEN", "all E-1..E-8 PASS on cross-device scope"
    if any(s == FAIL for s in statuses.values()):
        return "FAIL", "one or more E items FAIL"
    return "INCONCLUSIVE", "no anti-criteria, but some items UNOBSERVED"


def mk(status, summary, refs, **extra):
    item = {"status": status, "summary": summary, "refs": refs}
    if extra:
        item["detail"] = extra
    return item


def analyze(ctx):
    ctx["sk"] = summary_kv(ctx)
    ctx["devices"] = scan_devices(ctx, ctx["sk"])
    ctx["room_split"] = room_split_facts(ctx, ctx["sk"])
    diag = scan_diags(ctx)
    np = scan_netplay(ctx)
    checks = [("E-1", e1(ctx, ctx["sk"], diag)), ("E-2", e2(ctx, ctx["sk"])),
              ("E-3", e3(ctx, ctx["sk"], np)), ("E-4", e4(ctx, ctx["sk"], np)),
              ("E-5", e5(ctx, ctx["sk"], np)), ("E-6", e6(ctx, ctx["sk"], diag)),
              ("E-7", e7(ctx, ctx["sk"])), ("E-8", e8(ctx, ctx["sk"]))]
    items = dict(checks)
    anti = anti_criteria(ctx, diag, {k: v["status"] for k, v in items.items()})
    verdict, reason = verdict_for(ctx, {k: v["status"] for k, v in items.items()}, anti)
    return {"schema": "cloud2p-evidence/1", "scope": ctx["scope"],
            "verdict": verdict, "verdict_reason": reason,
            "inputs": {k: [s.name for s in ctx[k]] for k in ("lobby", "sio", "logcat", "summary")},
            "items": items, "anti_criteria": anti,
            "room_split": ctx["room_split"],
            "diag_facts": {
                k: diag[k] for k in ("rows", "max_run", "trap_count", "err_count",
                                     "reset_count", "n8_max", "last_trap")},
            "netplay_diag": netplay_payload(np)}


# ------------------------------------------------------------------ output
def table(result):
    lines = ["scope=%s  verdict=%s" % (result["scope"], result["verdict"]),
             "reason: %s" % result["verdict_reason"], "",
             "%-5s %-12s %-58s %s" % ("ID", "STATUS", "SUMMARY", "REF"),
             "-" * 110]
    for eid, item in result["items"].items():
        r = item["refs"][0] if item["refs"] else {}
        loc = "%s:%s" % (r.get("file", "-"), r.get("line", "-"))
        lines.append("%-5s %-12s %-58s %s" % (eid, item["status"], item["summary"][:58], loc))
    lines += ["", "Anti-criteria:"]
    for a in result["anti_criteria"]:
        lines.append("  %-28s %-5s %s" % (a["name"], "HIT" if a["hit"] else "-", a["explanation"]))
    return "\n".join(lines)


# ------------------------------------------------------------------ self test
def self_test():
    green_summary = """\
tag=SELFT
topology=avd scope=CROSS-DEVICE
BATTLE=YES
linkup_stable=True
linkup_s=49 stable_s=6.0
final_A=A l=4 pc=2 mu=0 rem=1 brs=0101/0000 fps=59.8 cb=0816BE85
final_B=B l=4 pc=2 mu=0 rem=1 brs=0101/0000 fps=60.2 cb=0816BE85
fps_pc_A=59.8 fps_pc_B=60.2
via=p2p
peerCandidates_A=True peerCandidates_B=True
battle_window=[0x08100000,0x08110000) source=rom.map
in_battle_frame=True battle_samples=7
mode_requested=A mode_negotiated_A=A mode_negotiated_B=A
official_mode_A=False official_mode_B=False nav_at_leak=False
exitcode_A=0 exitcode_B=0
multi_A=SIO multi last=0.4ms n=64
multi_B=SIO multi last=0.5ms n=64
"""
    green_diag = "\n".join([
        "[diag] lstate=4 pc=2 st=00000828 intr=6 rem=1 brs=0101/0000 n8=32 role=im8/lid0/hs1 cb=0816BE85",
        "[diag] lstate=4 pc=2 st=00000828 intr=7 rem=1 brs=0101/0000 n8=32 role=im8/lid0/hs1 cb=0816BE85",
    ])
    green_logcat = "\n".join([
        "I/GBoyLink: 525612743@qq.com logged in",
        "I/GBoyLink: zx14855734@gmail.com logged in",
        "uuid=BPEE,aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        "uuid=BPEE,bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
        "advertised relay 10.0.2.15:1234 for room 4242",
        "device_A=PHY-A123456 device_B=PHY-B654321",
        "emulator-5554 mGBA: SIO fast on",
        "mGBA: SIO fast me=1 n=256 reuse=3 miss=0",
    ])
    # A physical-only variant for --strict-cross-device positive cases.
    physical_logcat = "\n".join(l for l in green_logcat.splitlines()
                                if "emulator-" not in l)

    def ctx_for(scope, summary=green_summary, diag=green_diag, logcat=green_logcat,
                lobby="[sio-rtt] me=1 avg=2ms via=p2p",
                commit="0d0bc46c7", binary="a" * 32, source="b" * 32,
                strict=False, expect=None):
        return dict(lobby=synth(lobby),
                    sio=synth(diag), logcat=synth(logcat), summary=synth(summary),
                    scope=scope, map_path=None, commit=commit,
                    binary_md5=binary, source_md5=source,
                    strict_cross_device=strict, expect_uuids=expect or [])

    results = []

    def check(name, cond):
        results.append((name, bool(cond)))
        print("  [%s] %s" % ("PASS" if cond else "FAIL", name))

    print("[self-test] synthetic evidence lines")
    base = analyze(ctx_for("CROSS-DEVICE-AVD"))
    check("green -> CROSS-DEVICE-GREEN", base["verdict"] == "CROSS-DEVICE-GREEN")
    check("green E-1 PASS", base["items"]["E-1"]["status"] == PASS)
    check("green E-2 PASS", base["items"]["E-2"]["status"] == PASS)
    check("green E-6 PASS", base["items"]["E-6"]["status"] == PASS)
    check("green E-7 PASS", base["items"]["E-7"]["status"] == PASS)
    check("green E-8 PASS", base["items"]["E-8"]["status"] == PASS)
    proxy = analyze(ctx_for("PROXY-2PC"))
    check("PROXY forces NOT-CROSS-DEVICE", proxy["verdict"] == "NOT-CROSS-DEVICE")
    trap_diag = "[diag] lstate=1 pc=0 st=00000000 intr=0 linkup=1 role=im0/lid0/hs0"
    trap = analyze(ctx_for("REAL-DEVICE", diag=trap_diag))
    check("trap -> TRAP-LINKUP-RESIDUAL", trap["verdict"] == "TRAP-LINKUP-RESIDUAL")
    check("trap E-1 not PASS", trap["items"]["E-1"]["status"] != PASS)
    stale = green_summary.replace("[0x08100000,0x08110000) source=rom.map",
                                  "[0x08099848,0x080A30FD) source=ENV")
    st = analyze(ctx_for("REAL-DEVICE", summary=stale))
    check("stale battle window -> E-2 FAIL", st["items"]["E-2"]["status"] == FAIL)
    nofps_summary = (green_summary.replace("fps_pc_A=59.8 fps_pc_B=60.2", "")
                     .replace("fps=59.8", "fps=-").replace("fps=60.2", "fps=-")
                     .replace("multi_A=SIO multi last=0.4ms n=64", "")
                     .replace("multi_B=SIO multi last=0.5ms n=64", ""))
    nofps = analyze(ctx_for("REAL-DEVICE", summary=nofps_summary, logcat=""))
    check("no fps/fast -> E-3 UNOBSERVED", nofps["items"]["E-3"]["status"] == UNO)
    nof = analyze(ctx_for("REAL-DEVICE",
                          summary=green_summary.replace("commit", "x") if False else
                          green_summary, commit=""))
    check("no commit -> E-8 UNOBSERVED", nof["items"]["E-8"]["status"] == UNO)

    # ---- new netplay-specific diagnostic tokens (M1 / DIAG-WIRING-CHECK) ----
    p2p_lobby = ("[sio-rtt] me=1 avg=2ms via=p2p\n"
                 "[MGBAX_P2P] me=1 event=result result=ok peerCandidates=2 "
                 "peerCandidateCount=2 directEnabled=1 via=p2p")
    p2p = analyze(ctx_for("CROSS-DEVICE-AVD", lobby=p2p_lobby))
    nd = p2p["netplay_diag"]
    check("[MGBAX_P2P] event=result parsed",
          nd["p2p_result"].get("result") == "ok" and
          nd["p2p_result"].get("peerCandidates") == "2" and
          nd["p2p_result"].get("via") == "p2p")
    check("[MGBAX_P2P] feeds E-4 detail",
          p2p["items"]["E-4"]["detail"]["p2p_result"].get("result") == "ok")

    c0_logcat = green_logcat + ("\nI/GBoyLink: [C0-GATE] gate=ACCEPT mode=A pc=2 "
                                "where=join pathA=1 fastgate_expected=1")
    pc = analyze(ctx_for("CROSS-DEVICE-AVD",
                         lobby="[MGBAX_PATH] me=1 path=A mode=A officialMode=0 "
                               "transport=udp frameEnc=raw",
                         logcat=c0_logcat))
    nd = pc["netplay_diag"]
    check("[MGBAX_PATH] parsed",
          nd["path"].get("path") == "A" and nd["path"].get("mode") == "A" and
          nd["path"].get("officialMode") == "0")
    check("[C0-GATE] parsed", nd["c0_gate"].get("gate") == "ACCEPT")
    check("[MGBAX_PATH]/[C0-GATE] feed E-5 detail",
          pc["items"]["E-5"]["detail"]["mgbx_path"].get("path") == "A")

    gate = analyze(ctx_for("CROSS-DEVICE-AVD",
                           lobby="[MGBAX_GATE] me=1 path=A envLinkMode=A "
                                 "envOfficialLink=0 envRearm=1 fastMinOk=256 "
                                 "fastMinOkSlave=256 sioFast=1"))
    nd = gate["netplay_diag"]
    check("[MGBAX_GATE] env/fastMinOk parsed",
          nd["gate"].get("envLinkMode") == "A" and
          nd["gate"].get("envOfficialLink") == "0" and
          nd["gate"].get("fastMinOk") == "256" and
          nd["gate"].get("fastMinOkSlave") == "256")

    round_sio = green_diag + "\n" + "\n".join([
        "[rearm] fired n=3 me=0 isMaster=0 hs=1 players=2 (hs set)",
        "[rearm] round n=3 me=0 isMaster=0 state=4 players=2 hs=1",
        "slave fast align gate blocked n=5 slaveIdx=10 hostIdx=10 window=4 state=4 ok=256",
    ])
    rc = analyze(ctx_for("CROSS-DEVICE-AVD", diag=round_sio))
    nd = rc["netplay_diag"]
    check("[rearm] round/fired hs=1 counted",
          nd["rearm"]["hs1"] >= 2 and nd["rearm"]["rounds"] >= 1 and
          nd["rearm"]["fired"] >= 1)
    check("slave fast align gate blocked n= parsed",
          nd["slave_fast_align_blocked_max"] == 5)

    direct_lobby = ("[direct] P2P 已启用 via=p2p avg=3ms peerCandidates=2 "
                    "direct=1 ignored=1 peer=10.0.0.2:1234")
    dc = analyze(ctx_for("CROSS-DEVICE-AVD", lobby=direct_lobby))
    nd = dc["netplay_diag"]
    check("diagnosticsText avg/direct/ignored/peer parsed",
          nd["direct_diag"].get("avg") == "3ms" and
          nd["direct_diag"].get("direct") == "1" and
          nd["direct_diag"].get("ignored") == "1" and
          nd["direct_diag"].get("peer") == "10.0.0.2:1234")

    fast_logcat = green_logcat + "\n" + "\n".join([
        "I/mGBA: SIO fast me=1 n=256 reuse=0 miss=0 idx=42 pidx=42 pq=0 alignblk=0",
        "I/GBoyLink: [PA-FRAME] ch=p2p dir=tx chunks=256 rawbytes=16384 framing=RAW(no Reader)",
        "I/GBoyLink: [PA-DIRECT] cand_me=3 localPort=1234 phase=announce",
    ])
    fc = analyze(ctx_for("CROSS-DEVICE-AVD", logcat=fast_logcat))
    nd = fc["netplay_diag"]
    check("SIO fast pidx/idx/alignblk parsed",
          nd["sio_fast"].get("pidx") == "42" and nd["sio_fast"].get("idx") == "42" and
          nd["sio_fast"].get("alignblk") == "0")
    check("[PA-FRAME]/[PA-DIRECT] parsed",
          "p2p" in nd["pa_frame"].get("channels", []) and
          nd["pa_direct"].get("cand_me") == "3")
    check("SIO fast values feed E-3 detail",
          fc["items"]["E-3"]["detail"]["sio_fast"].get("pidx") == "42")

    extra_summary = green_summary + "\n".join([
        "pathB_2p_bus_ok=False reason=caller-requests-4",
        "rearm_A fired=2 hs1=2 rounds=2 | rearm_B fired=2 hs1=2 rounds=2",
        "slave_fast_align_blocked_A=5 slave_fast_align_blocked_B=0",
        "badchecksum_A=0 badchecksum_B=0",
        "bus_A=key-a bus_B=key-b",
    ]) + "\n"
    sc = analyze(ctx_for("CROSS-DEVICE-AVD", summary=extra_summary))
    nd = sc["netplay_diag"]
    check("summary pathB/rearm/badchecksum/bus keys parsed",
          nd["summary"].get("pathB_2p_bus_ok") == "False" and
          nd["summary"].get("rearm_A_hs1") == "2" and
          nd["summary"].get("badchecksum_A") == "0" and
          nd["summary"].get("bus_A") == "key-a")
    check("summary scope= parsed (CLI stays authoritative)",
          nd["summary"].get("scope") == "CROSS-DEVICE" and
          sc["scope"] == "CROSS-DEVICE-AVD")
    ibf_false = green_summary.replace("in_battle_frame=True", "in_battle_frame=False")
    ib = analyze(ctx_for("CROSS-DEVICE-AVD", summary=ibf_false))
    check("in_battle_frame=False flips E-2 to FAIL",
          ib["items"]["E-2"]["status"] == FAIL)

    # ---- E-x trap hardening (E3 review) ----
    trap2_diag = "\n".join([
        "[diag] lstate=2 pc=0 st=00000000 intr=0 linkup=1 role=im0/lid0/hs0 n8=0 rem=0 brs=0000/0000",
        "[diag] lstate=2 pc=0 st=00000000 intr=0 linkup=1 role=im0/lid0/hs0 n8=0 rem=0 brs=0000/0000",
    ])
    tr2 = analyze(ctx_for("CROSS-DEVICE-AVD", diag=trap2_diag))
    check("lstate=2 linkup trap counted", tr2["diag_facts"]["trap_count"] == 2)
    check("lstate=2 linkup trap -> TRAP-LINKUP-RESIDUAL",
          tr2["verdict"] == "TRAP-LINKUP-RESIDUAL")
    check("lstate=2 linkup trap E-1 not PASS", tr2["items"]["E-1"]["status"] != PASS)

    menu_summary = (green_summary.replace("BATTLE=YES", "BATTLE=NO")
                    .replace("in_battle_frame=True", "in_battle_frame=False")
                    .replace("battle_samples=7", "battle_samples=0"))
    mn = analyze(ctx_for("REAL-DEVICE", summary=menu_summary))
    check("menu fps+fast -> E-3 UNOBSERVED", mn["items"]["E-3"]["status"] == UNO)
    check("green in-battle fps -> E-3 PASS", base["items"]["E-3"]["status"] == PASS)

    npc_lobby = ("[sio-rtt] me=1 avg=2ms via=p2p\n"
                 "[MGBAX_P2P] event=result result=no-peer-candidates via=tunnel peerCandidates=0")
    npc = analyze(ctx_for("REAL-DEVICE", lobby=npc_lobby))
    check("no-peer-candidates -> E-4 FAIL", npc["items"]["E-4"]["status"] == FAIL)
    npc_summary = green_summary.replace("via=p2p", "via=p2p\np2p_result_A=no-peer-candidates")
    npc2 = analyze(ctx_for("REAL-DEVICE", summary=npc_summary))
    check("summary p2p_result=no-peer-candidates -> E-4 FAIL",
          npc2["items"]["E-4"]["status"] == FAIL)

    stale2 = green_summary.replace("[0x08100000,0x08110000) source=rom.map",
                                   "[0x8099848,0x80A30FD) source=rom.map")
    st2 = analyze(ctx_for("REAL-DEVICE", summary=stale2))
    check("unpadded stale battle window -> E-2 FAIL", st2["items"]["E-2"]["status"] == FAIL)

    # Genuine split: both rooms advertised repeatedly in the SAME window,
    # PC owns 572161 while the app owns 505099.
    two_room_lobby = ("[sio-rtt] via=p2p\n"
                      "advertised relay 1.2.3.4:1 for room 572161\n"
                      "advertised relay 1.2.3.4:2 for room 505099\n"
                      "advertised relay 1.2.3.4:1 for room 572161\n"
                      "advertised relay 1.2.3.4:2 for room 505099")
    tr = analyze(ctx_for("CROSS-DEVICE-AVD", lobby=two_room_lobby,
                         summary=green_summary + "room_pc=572161\n"))
    check("concurrent two-room split -> E-7 FAIL", tr["items"]["E-7"]["status"] == FAIL)
    check("concurrent two-room split -> anti HIT",
          any(a["name"] == "TWO_ROOM_SPLIT" and a["hit"] for a in tr["anti_criteria"]))

    # E2-FAST false positive: a-lobby had a stale/pre-join room 673931 that
    # was explicitly left, then BOTH ends moved to 570954.  No split.
    e2_a_lobby = "\n".join([
        "01:24:28.936 -> {\"action\":\"create_game_room\",\"room_name\":\"rom_a\"}",
        "01:24:29.027 <- {\"type\":\"create_game_room\",\"success\":true,\"room_id\":\"673931\"}",
        "01:24:31.446 host: stale room 673931",
        "01:24:31.454 -> {\"action\":\"join_room\",\"room_id\":\"673931\"}",
        "01:24:32.957 -> {\"action\":\"leave_room\",\"token\":\"***\"}",
        "01:24:33.042 <- {\"type\":\"leave_room\",\"success\":true}",
        "01:24:35.296 -> {\"action\":\"create_game_room\",\"room_name\":\"rom_a\"}",
        "01:24:35.391 <- {\"type\":\"create_game_room\",\"success\":true,\"room_id\":\"570954\"}",
        "01:24:37.802 host: room 570954",
        "01:24:37.808 -> {\"action\":\"join_room\",\"room_id\":\"570954\"}",
        "01:24:49.662 -> {\"action\":\"send_message\",\"message\":\"{\\\"room\\\":\\\"570954\\\"}\"}",
    ])
    e2_b_lobby = "\n".join([
        "01:25:01.721 [status] joining room 570954",
        "01:25:01.725 -> {\"action\":\"join_room\",\"room_id\":\"570954\"}",
        "01:25:07.777 -> {\"action\":\"send_message\",\"message\":\"{\\\"room\\\":\\\"570954\\\"}\"}",
    ])
    e2_ctx = dict(lobby=synth(e2_a_lobby) + synth(e2_b_lobby),
                  sio=synth(""), logcat=synth(""), summary=synth("BATTLE=NO\n"),
                  scope="PROXY-2PC", map_path=None, commit="", binary_md5="", source_md5="",
                  strict_cross_device=False, expect_uuids=[])
    e2r = analyze(e2_ctx)
    check("E2 stale 673931 + shared 570954 -> NO split",
          not any(a["name"] == "TWO_ROOM_SPLIT" and a["hit"] for a in e2r["anti_criteria"]))
    check("E2 stale room excluded from active rooms",
          e2r["room_split"]["active_rooms"] == ["570954"])
    check("E2 both ends reference same room",
          not e2r["room_split"]["ends_differ"])
    check("E2 E-7 FAIL is scope-only, not split",
          "two-room split" not in e2r["items"]["E-7"]["summary"])
    one_dev_logcat = "\n".join(l for l in green_logcat.splitlines()
                               if "device_A=" not in l and "emulator-" not in l
                               and "advertised relay" not in l)
    od = analyze(ctx_for("REAL-DEVICE", logcat=one_dev_logcat))
    check("2 accounts+2 uuids+0 device tokens -> E-7 UNOBSERVED",
          od["items"]["E-7"]["status"] == UNO)

    # ---- --strict-cross-device (opt-in final gate) ----
    sa = analyze(ctx_for("CROSS-DEVICE-AVD", strict=True))
    check("strict rejects CROSS-DEVICE-AVD verdict", sa["verdict"] == "NOT-CROSS-DEVICE")
    check("strict rejects CROSS-DEVICE-AVD E-7", sa["items"]["E-7"]["status"] == FAIL)
    sg = analyze(ctx_for("REAL-DEVICE", logcat=physical_logcat, strict=True))
    check("strict physical two devices -> E-7 PASS", sg["items"]["E-7"]["status"] == PASS)
    check("strict physical two devices -> GREEN", sg["verdict"] == "CROSS-DEVICE-GREEN")
    emu_only = "\n".join(l for l in green_logcat.splitlines()
                         if "device_A=" not in l and "advertised relay" not in l)
    se = analyze(ctx_for("REAL-DEVICE", logcat=emu_only, strict=True))
    check("strict emulator-only -> E-7 FAIL", se["items"]["E-7"]["status"] == FAIL)
    check("strict emulator-only -> not GREEN", se["verdict"] != "CROSS-DEVICE-GREEN")
    su = analyze(ctx_for("REAL-DEVICE", logcat=physical_logcat, strict=True,
                         expect=["BPEE," + "a" * 32, "BPEE," + "c" * 32]))
    check("strict wrong expected uuid -> E-7 FAIL", su["items"]["E-7"]["status"] == FAIL)
    su_ok = analyze(ctx_for("REAL-DEVICE", logcat=physical_logcat, strict=True,
                            expect=["BPEE," + "a" * 32, "BPEE," + "b" * 32]))
    check("strict bound uuids -> GREEN", su_ok["verdict"] == "CROSS-DEVICE-GREEN")
    check("default (non-strict) AVD still GREEN", base["verdict"] == "CROSS-DEVICE-GREEN")

    failed = [n for n, ok in results if not ok]
    print("[self-test] %d/%d passed" % (len(results) - len(failed), len(results)))
    return 0 if not failed else 1


# ------------------------------------------------------------------ main
def main():
    ap = argparse.ArgumentParser(description="Parse cross-device 2P cloud evidence (E-1..E-8)")
    ap.add_argument("--lobby", action="append", default=[], metavar="PATH", help="PC mgba_lobby_debug.log (repeatable)")
    ap.add_argument("--sio", action="append", default=[], metavar="PATH", help="PC mgba_sio.log (repeatable)")
    ap.add_argument("--logcat", action="append", default=[], metavar="PATH", help="Android logcat.txt (repeatable)")
    ap.add_argument("--summary", action="append", default=[], metavar="PATH", help="driver summary.txt (repeatable)")
    ap.add_argument("--run-dir", metavar="DIR", help="auto-add a_tmp/b_tmp logs + summary.txt under DIR")
    ap.add_argument("--scope", choices=SCOPES, help="evidence scope")
    ap.add_argument("--map", dest="map_path", metavar="PATH", help=".map for E-2 battle window")
    ap.add_argument("--json", dest="json_path", metavar="FILE", help="also write JSON to FILE")
    ap.add_argument("--commit", default="", help="binding commit sha")
    ap.add_argument("--binary-md5", default="", help="binding binary md5")
    ap.add_argument("--source-md5", default="", help="binding source md5")
    ap.add_argument("--strict-cross-device", action="store_true",
                    help="final-gate mode: require two PHYSICAL devices; reject "
                         "--scope CROSS-DEVICE-AVD as emulator-backed")
    ap.add_argument("--expect-uuid", action="append", default=[], metavar="BPEE,...",
                    help="expected ROM game uuid (repeatable); enforced under --strict-cross-device "
                         "to catch a stale/wrong ROM such as bus4.gba")
    ap.add_argument("--self-test", action="store_true", help="run synthetic self-test and exit")
    args = ap.parse_args()

    if args.self_test:
        return self_test()
    if not args.scope:
        ap.error("--scope is required (PROXY-2PC|CROSS-DEVICE-AVD|REAL-DEVICE)")

    if args.run_dir:
        d = args.run_dir
        for side in ("a_tmp", "b_tmp"):
            for kind, fn in (("lobby", "mgba_lobby_debug.log"), ("sio", "mgba_sio.log")):
                p = os.path.join(d, side, fn)
                if os.path.isfile(p):
                    getattr(args, kind).append(p)
        for kind, fn in (("lobby", "mgba_lobby_debug.log"), ("sio", "mgba_sio.log")):
            p = os.path.join(d, fn)
            if os.path.isfile(p):
                getattr(args, kind).append(p)
        p = os.path.join(d, "summary.txt")
        if os.path.isfile(p):
            args.summary.append(p)
        if not args.map_path:
            for mp in (os.path.join(d, "rom.map"), os.path.join(d, "..", "rom.map")):
                if os.path.isfile(mp):
                    args.map_path = mp
                    break

    ctx = {
        "lobby": [load(p) for p in args.lobby],
        "sio": [load(p) for p in args.sio],
        "logcat": [load(p) for p in args.logcat],
        "summary": [load(p) for p in args.summary],
        "scope": args.scope, "map_path": args.map_path,
        "commit": args.commit, "binary_md5": args.binary_md5,
        "source_md5": args.source_md5,
        "strict_cross_device": args.strict_cross_device,
        "expect_uuids": args.expect_uuid,
    }
    result = analyze(ctx)
    print(table(result))
    payload = json.dumps(result, ensure_ascii=False, indent=2)
    print("\nJSON:\n" + payload)
    if args.json_path:
        with open(args.json_path, "w", encoding="utf-8") as f:
            f.write(payload + "\n")
        print("\n[written] " + args.json_path)
    return 0


if __name__ == "__main__":
    sys.exit(main())
