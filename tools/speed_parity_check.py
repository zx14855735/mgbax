#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""SPEEDTEST - same-speed netplay framerate parity check (acceptance tool).

User acceptance criterion (2026-11-18):
    "Add a check that when BOTH ends use the SAME speed multiplier, netplay
     battle works normally AND the framerate is the same as single-player."

This tool is READ-ONLY with respect to the other agents' drivers: it never
edits cloud2p-duo.py / cloud2p_avd.py. It uses their existing, documented
hooks instead:

  * PC ends: ``--env MGBAX_SPEED_9=1`` (CloudLink.cpp:2340, presence based)
    plus a speed file in ``<MGBAX_SCRIPT_DIR>/speed`` containing one of
    1 / -1 / 2 / 4 (wire values; -1 = 0.5x). CloudLink sends official
    type 9 and logs ``[gboy] speed hook: <wire>`` /
    ``[gboy] type 9 speed sent: <wire>`` in the per-instance
    ``mgba_lobby_debug.log``.
  * Android end: ``adb shell am broadcast -a io.mgba.android.action.SPEED
    --ei value <wire>``; EmulatorActivity logs ``speed broadcast value=<wire>``.

Summary fields consumed (produced by APPHUNT's drivers):
  * ``BATTLE=YES`` and ``in_battle_frame=True`` / ``battle_samples>0``
    (in-battle gate; a lobby/menu ~60 fps does NOT count, cf. E3 in
    cloud2p_evidence.py).
  * ``opponent_data_real=True`` - the NEW acceptance criterion: BATTLE=YES
    alone is not enough; the opponent must be real data, not ???.
    ``UNOBSERVED`` (the driver's default, never auto-True) is treated as
    "cannot judge" => overall verdict UNOBSERVED, never PASS.
  * ``fps_pc_A`` / ``fps_pc_B`` (duo) or ``fps_pc`` + optionally ``fps_app``
    (avd) - netplay fps samples taken during the battle.

Verdict precedence: FAIL > UNOBSERVED > PASS. Every verdict carries the
exact numbers and the reasons. Exit codes: 0=PASS, 1=FAIL, 3=UNOBSERVED.

Modes
-----
  --dry-run                 Print the exact host/baseline/arm/analyse commands,
                            touch nothing (safe on any machine).
  --measure-baseline        Launch solo PC mGBA, sample window-title fps for
                            N seconds, write a baseline file (Windows only).
  --write-baseline          Write a baseline file from an externally measured
                            fps value (e.g. app FPS read by other means).
  --arm-speed <run-dir>     Drop the speed file into the driver's script dirs
                            while a run is in progress; also print the adb
                            command for the Android end.
  --from-summary <dir>      Compute the parity verdict from an existing run.

Examples
--------
  python tools/speed_parity_check.py --speed 2 --dry-run
  python tools/speed_parity_check.py --measure-baseline --speed 2 --seconds 30 \
      --out .zcode-tmp/speed-parity/baseline_2x.txt
  python tools/cloud2p-duo.py --tag SPD2 --mode A --runsec 420 --nav \
      --env MGBAX_SPEED_9=1
  python tools/speed_parity_check.py --arm-speed .zcode-tmp/cloud2p/SPD2 --speed 2
  python tools/speed_parity_check.py --from-summary .zcode-tmp/cloud2p/SPD2 \
      --baseline .zcode-tmp/speed-parity/baseline_2x.txt --speed 2
"""

import argparse
import ctypes
import json
import os
import re
import subprocess
import sys
import time
from datetime import datetime

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
DEFAULT_BASELINE_DIR = os.path.join(ROOT, ".zcode-tmp", "speed-parity")
DEFAULT_EXE = os.path.join(ROOT, "build-win", "mGBA.exe")
DEFAULT_ROM = r"D:\gen8\rom.gba"

# Speed multiplier <-> official type-9 wire value. -1 means 0.5x.
WIRE_FOR_SPEED = {0.5: -1, 1.0: 1, 2.0: 2, 4.0: 4}
SPEED_FOR_WIRE = {-1: 0.5, 1: 1.0, 2: 2.0, 4: 4.0}

# Log evidence of "this end is at wire W". Used only as a cross-check;
# the fps comparison is the primary measurement.
EVIDENCE_PATTERNS = [
    re.compile(r"\[gboy\]\s+speed hook:\s*(-?\d+)"),
    re.compile(r"\[gboy\]\s+type 9 speed sent:\s*(-?\d+)"),
    re.compile(r"speed broadcast value=(-?\d+)"),
]
BAD_EVIDENCE_PATTERNS = [
    re.compile(r"speed hook ignored:\s*(-?\d+)"),
    re.compile(r"speed broadcast ignored"),
]

PAIR_RE = re.compile(r"([A-Za-z_][A-Za-z0-9_]*)=([^\s]+)")
FPS_RE = re.compile(r"([\d.]+)\s*fps", re.I)

STATUS_OK = "PASS"
STATUS_FAIL = "FAIL"
STATUS_UNKNOWN = "UNOBSERVED"
STATUS_RANK = {STATUS_OK: 0, STATUS_UNKNOWN: 1, STATUS_FAIL: 2}


def log(msg):
    print(msg, flush=True)


def numeric(value):
    try:
        return float(str(value).strip())
    except (TypeError, ValueError):
        return None


def truthy(value):
    return str(value).strip().lower() in ("yes", "true", "1", "ok", "y")


def falsy(value):
    return str(value).strip().lower() in ("no", "false", "0", "off", "n")


def parse_pairs(text):
    """Parse every ``key=value`` token, ignoring trailing ``# comment`` text.

    Summary lines pack several pairs per line (``fps_pc_A=59.8 fps_pc_B=60.2``),
    so a simple ``line.split('=', 1)`` is not enough.
    """
    out = {}
    for line in text.splitlines():
        line = re.split(r"\s+#", line, 1)[0]
        for m in PAIR_RE.finditer(line):
            out[m.group(1)] = m.group(2)
    return out


def read_kv(path):
    with open(path, "r", encoding="utf-8", errors="replace") as f:
        return parse_pairs(f.read())


def wire_text(speed):
    return str(WIRE_FOR_SPEED[speed])


def speed_label(speed):
    return ("%gx" % speed).replace(".0x", "x")


# ---------------------------------------------------------------------------
# Baseline file helpers
# ---------------------------------------------------------------------------

def write_baseline(path, speed, fps, fps_1x=None, stats=None, source="external"):
    os.makedirs(os.path.dirname(os.path.abspath(path)), exist_ok=True)
    lines = [
        "# speed-parity single-player baseline (written by tools/speed_parity_check.py)",
        "speed=%s" % speed,
        "wire=%s" % wire_text(speed),
        "fps=%.3f" % fps,
    ]
    if fps_1x is not None:
        lines.append("fps_1x=%.3f" % fps_1x)
    for k in ("fps_min", "fps_max", "samples", "seconds", "speed_mode"):
        if stats and k in stats and stats[k] is not None:
            lines.append("%s=%s" % (k, stats[k]))
    lines.append("source=%s" % source)
    lines.append("created=%s" % datetime.now().isoformat(timespec="seconds"))
    with open(path, "w", encoding="utf-8") as f:
        f.write("\n".join(lines) + "\n")
    log("baseline written: %s (speed=%s fps=%.2f)" % (path, speed_label(speed), fps))


def find_baseline(run_dir, explicit, speed=None):
    """Locate a baseline: explicit > run_dir > DEFAULT_BASELINE_DIR.

    基线默认落在 .zcode-tmp/speed-parity/，旧版只扫 run_dir，导致必须显式
    --baseline 才能找到；这里同时搜索默认目录，并按本次 speed 匹配最合适的文件。
    同一速度标签下，规范名 baseline_<tag>.txt 优先于 baseline_<tag>_trialN.txt
    等试验变体（P7：trial2=60.1 曾被误选，权威 baseline_2x=123.3）。
    """
    if explicit:
        return explicit if os.path.isfile(explicit) else None
    pools = [(run_dir, False)]
    if os.path.isdir(DEFAULT_BASELINE_DIR):
        pools.append((DEFAULT_BASELINE_DIR, True))
    candidates = []
    for pool, is_default in pools:
        if not pool or not os.path.isdir(pool):
            continue
        for name in os.listdir(pool):
            if name.startswith("baseline") and name.endswith(".txt"):
                candidates.append((os.path.join(pool, name), is_default))
    if not candidates:
        return None

    # 1) 文件名带速度标签（baseline_2x.txt）
    tag = speed_label(speed) if speed is not None else None
    named = [p for p, _ in candidates if tag and tag in os.path.basename(p)]
    if named:
        # P7: baseline_2x_trial2.txt 与 baseline_2x.txt 都含 "2x"，旧版
        # sorted()[-1] 按文件名排序会误选 trial 变体（60.1）而非权威基线（123.3）。
        # 规范名 baseline_<tag>.txt 优先；没有规范名才回退到原排序，避免回归。
        canonical = "baseline_%s.txt" % tag
        exact = [p for p in named if os.path.basename(p).lower() == canonical.lower()]
        return sorted(exact)[-1] if exact else sorted(named)[-1]

    # 2) 文件内容 speed/wire 字段与本次请求一致
    if speed is not None:
        for p, _ in sorted(candidates, key=lambda x: x[1]):
            try:
                kv = read_kv(p)
            except OSError:
                continue
            if (numeric(kv.get("speed")) == speed or
                    numeric(kv.get("wire")) == WIRE_FOR_SPEED.get(speed)):
                return p

    # 3) 都不匹配：run_dir 本地优先，其次默认目录；同类取最新（排序末位）
    for is_default in (False, True):
        group = sorted(p for p, d in candidates if d == is_default)
        if group:
            return group[-1]
    return None


# ---------------------------------------------------------------------------
# Solo baseline measurement (PC window title, same method as pcfps.py)
# ---------------------------------------------------------------------------

def window_titles():
    u32 = ctypes.windll.user32
    found = []

    @ctypes.WINFUNCTYPE(ctypes.c_bool, ctypes.c_void_p, ctypes.c_void_p)
    def cb(hwnd, _):
        if not u32.IsWindowVisible(hwnd):
            return True
        n = u32.GetWindowTextLengthW(hwnd)
        if n:
            buf = ctypes.create_unicode_buffer(n + 1)
            u32.GetWindowTextW(hwnd, buf, n + 1)
            if "mGBA" in buf.value:
                found.append(buf.value)
        return True

    u32.EnumWindows(cb, None)
    return found


def measure_baseline(args):
    if sys.platform != "win32":
        log("ERROR: --measure-baseline needs Windows (window-title sampling).")
        log("       Use --write-baseline --fps F with an externally measured fps.")
        return 2
    env = dict(os.environ)
    for key in ("MGBAX_NO_DIRECT", "MGBAX_SIO_LOG", "MGBAX_ROOM", "MGBAX_LINK_REARM",
                "MGBAX_SPEED_9", "MGBAX_AUTOLINK", "MGBAX_SCRIPT_DIR"):
        env.pop(key, None)
    if args.speed != 1.0:
        log("NOTE: solo PC has no env speed hook. During the first %.0fs settle window,"
            % args.settle_sec)
        log("      set Tools -> Speed -> %s in the mGBA window (or pass --speed-cmd)."
            % speed_label(args.speed))
    proc = subprocess.Popen([args.exe, args.rom], env=env,
                            stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    if args.speed_cmd:
        log("running --speed-cmd: %s" % args.speed_cmd)
        subprocess.call(args.speed_cmd, shell=True)
    try:
        time.sleep(args.settle_sec)
        samples = []
        t0 = time.time()
        while time.time() - t0 < args.seconds:
            time.sleep(args.interval)
            titles = window_titles()
            vals = [float(m.group(1)) for t in titles for m in [FPS_RE.search(t)] if m]
            if vals:
                samples.append(vals[0])
                log("  t=%5.1fs fps=%.2f" % (time.time() - t0, vals[0]))
            else:
                log("  t=%5.1fs fps=- (no fps in window title; enable showFps)"
                    % (time.time() - t0))
    finally:
        proc.terminate()
        try:
            proc.wait(timeout=5)
        except subprocess.TimeoutExpired:
            proc.kill()
    if not samples:
        log("ERROR: no fps samples collected; baseline NOT written.")
        return 2
    stats = {
        "fps_min": "%.2f" % min(samples),
        "fps_max": "%.2f" % max(samples),
        "samples": len(samples),
        "seconds": args.seconds,
        "speed_mode": "manual-ui" if args.speed != 1.0 else "default-1x",
    }
    # Median is more robust to a single stutter than the mean.
    ordered = sorted(samples)
    median = ordered[len(ordered) // 2]
    write_baseline(args.out, args.speed, median, args.baseline_1x, stats,
                   source="pc-window-title")
    return 0


# ---------------------------------------------------------------------------
# Arming the two ends at the same wire value (no driver edits)
# ---------------------------------------------------------------------------

def arm_speed(args):
    wire = wire_text(args.speed)
    targets = []
    for sub in ("keys_a", "keys_b", "pc_keys", "pc_keys_a", "pc_keys_b"):
        d = os.path.join(args.arm_speed, sub)
        if os.path.isdir(d):
            path = os.path.join(d, "speed")
            with open(path, "w", encoding="ascii") as f:
                f.write(wire + "\n")
            targets.append(path)
    if not targets:
        log("WARN: no script dir found under %s - start the driver first "
            "(it creates keys_a/keys_b or pc_keys)." % args.arm_speed)
    else:
        for path in targets:
            log("speed file written: %s (= %s)" % (path, wire))
    log("PC ends must be started with: --env MGBAX_SPEED_9=1")
    log("Android end (if present):")
    log("  adb shell am broadcast -a io.mgba.android.action.SPEED --ei value %s" % wire)
    log("Verify both ends in the logs: '[gboy] speed hook: %s' / "
        "'[gboy] type 9 speed sent: %s' / 'speed broadcast value=%s'"
        % (wire, wire, wire))
    return 0


# ---------------------------------------------------------------------------
# Evidence collection from an existing run
# ---------------------------------------------------------------------------

def collect_speed_evidence(run_dir):
    """Return {end: set(wire)} where end is inferred from the log path.

    Ends: 'A' (a_tmp/keys_a), 'B' (b_tmp/keys_b), 'PC' (pc_tmp/pc_keys),
    'app' (app_logcat*), or '?' for other logs. A run with two PC ends maps
    A/B; an avd run maps PC/app.
    """
    evidence = {}
    bad = {}
    if not run_dir or not os.path.isdir(run_dir):
        return evidence, bad
    for dirpath, _, files in os.walk(run_dir):
        for name in files:
            if not name.endswith(".log") and name != "summary.txt":
                continue
            path = os.path.join(dirpath, name)
            # 流式逐行匹配：不再对 >8MB 日志整份跳过。真实 run 里
            # app_logcat_after.log 可达 13MB+，整份跳过会丢掉 2x wire 证据
            # => speed_* 误报 UNOBSERVED。逐行读内存恒定，大日志也能取到匹配行。
            seen_wires = set()
            has_bad = False
            try:
                with open(path, "r", encoding="utf-8", errors="replace") as f:
                    for line in f:
                        for pat in EVIDENCE_PATTERNS:
                            for m in pat.finditer(line):
                                seen_wires.add(int(m.group(1)))
                        if any(p.search(line) for p in BAD_EVIDENCE_PATTERNS):
                            has_bad = True
            except OSError:
                continue
            low = (dirpath + os.sep).replace("\\", "/").lower()
            fname = name.lower()
            if "/a_tmp/" in low or "/keys_a/" in low:
                end = "A"
            elif "/b_tmp/" in low or "/keys_b/" in low:
                end = "B"
            elif fname.startswith("app") or "logcat" in fname:
                end = "app"
            elif "/pc_tmp/" in low or "/pc_keys" in low or fname.startswith("pc_"):
                end = "PC"
            else:
                end = "?"
            for wire in seen_wires:
                evidence.setdefault(end, set()).add(wire)
            if has_bad:
                bad.setdefault(end, []).append(os.path.relpath(path, run_dir))
    return evidence, bad


def fps_from_summary(kv):
    """Map end name -> fps. duo: A/B; avd: PC (from fps_pc) and app if present."""
    ends = {}
    for key, end in (("fps_pc_A", "A"), ("fps_pc_B", "B")):
        v = numeric(kv.get(key))
        if v is not None:
            ends[end] = v
    if not ends:
        v = numeric(kv.get("fps_pc"))
        if v is not None:
            ends["PC"] = v
    for key, end in (("fps_app", "app"), ("fps_app_A", "A"),
                     ("fps_app_B", "B"), ("app_fps", "app")):
        v = numeric(kv.get(key))
        if v is not None:
            ends[end] = v
    return ends


def required_ends(kv, evidence):
    if numeric(kv.get("fps_pc_A")) is not None or numeric(kv.get("fps_pc_B")) is not None:
        return ["A", "B"]
    if "A" in evidence and "B" in evidence:
        return ["A", "B"]
    if str(kv.get("topology", "")).lower() == "avd" or "app" in evidence or "fps_app" in kv:
        return ["PC", "app"]
    return ["A", "B"]


# ---------------------------------------------------------------------------
# Verdict
# ---------------------------------------------------------------------------

def add(checks, name, status, detail):
    checks.append({"name": name, "status": status, "detail": detail})


def evaluate(args, kv, baseline, evidence, bad):
    checks = []
    speed = args.speed
    wire = WIRE_FOR_SPEED[speed]
    ends = required_ends(kv, evidence)

    # 1. Battle validity: BATTLE=YES, in-battle samples, and REAL opponent data.
    battle = str(kv.get("BATTLE", "")).upper()
    samples = numeric(kv.get("battle_samples")) or 0
    ibf = kv.get("in_battle_frame")
    if battle != "YES":
        add(checks, "battle", STATUS_FAIL,
            "BATTLE=%s (need YES); battle_samples=%s" % (battle or "-", int(samples)))
    elif samples <= 0:
        add(checks, "battle", STATUS_FAIL,
            "BATTLE=YES but battle_samples=%d (fps may be from lobby/menu)" % samples)
    elif ibf is not None and falsy(ibf):
        add(checks, "battle", STATUS_FAIL,
            "BATTLE=YES but in_battle_frame=%s (in-battle fps gate failed)" % ibf)
    else:
        add(checks, "battle", STATUS_OK,
            "BATTLE=YES battle_samples=%d in_battle_frame=%s"
            % (samples, ibf if ibf is not None else "?"))

    opp = kv.get("opponent_data_real")
    if opp is None or str(opp).strip().lower() == "unobserved":
        add(checks, "opponent_data_real", STATUS_UNKNOWN,
            "summary says %s; battle screenshot must be adjudicated "
            "(non-??? opponent) before this check can PASS" % (opp or "<missing>"))
    elif truthy(opp):
        add(checks, "opponent_data_real", STATUS_OK, "opponent_data_real=%s" % opp)
    else:
        add(checks, "opponent_data_real", STATUS_FAIL,
            "opponent_data_real=%s (opponent was ??? / not real data)" % opp)

    # 2. Both ends at the same requested speed, confirmed in logs.
    for end in ends:
        seen = evidence.get(end, set())
        # summary can carry explicit future fields too
        sw = kv.get("speed_wire_" + end) or kv.get("speed_" + end)
        if sw is not None:
            n = numeric(sw)
            if n is not None:
                seen = set(seen) | {int(n)}
        if wire in seen:
            add(checks, "speed_" + end, STATUS_OK,
                "%s confirmed wire=%d (%s) by log/summary" % (end, wire, speed_label(speed)))
        elif seen:
            add(checks, "speed_" + end, STATUS_FAIL,
                "%s wire(s)=%s, expected %d (%s)" % (end, sorted(seen), wire, speed_label(speed)))
        elif speed == 1.0:
            add(checks, "speed_" + end, STATUS_OK,
                "%s: no speed override seen; 1x is the product default "
                "(disconnect resets to 1x)" % end)
        else:
            add(checks, "speed_" + end, STATUS_UNKNOWN,
                "%s: no speed evidence; need '[gboy] speed hook: %d' or "
                "'speed broadcast value=%d' in the run logs" % (end, wire, wire))
        if end in bad:
            add(checks, "speed_bad_" + end, STATUS_UNKNOWN,
                "%s: ignored speed value in %s" % (end, ", ".join(bad[end])))

    # 3. In-battle netplay fps >= tolerance x single-player baseline at same R.
    net_fps = fps_from_summary(kv)
    base_fps = numeric(args.baseline_fps)
    base_src = "--baseline-fps"
    if base_fps is None and baseline:
        base_fps = numeric(baseline.get("fps"))
        base_src = args.baseline or "baseline file"
    if base_fps is None:
        add(checks, "baseline_fps", STATUS_UNKNOWN,
            "no baseline fps; use --baseline FILE or --baseline-fps F "
            "(--measure-baseline / --write-baseline)")
    else:
        add(checks, "baseline_fps", STATUS_OK,
            "baseline=%.2f fps at %s from %s" % (base_fps, speed_label(speed), base_src))

    if not net_fps:
        add(checks, "netplay_fps", STATUS_UNKNOWN,
            "no fps_pc_A/fps_pc_B (duo) or fps_pc/fps_app (avd) in summary.txt")
    elif base_fps is None:
        add(checks, "netplay_fps", STATUS_UNKNOWN,
            "netplay fps present (%s) but baseline fps missing"
            % ", ".join("%s=%.2f" % (e, v) for e, v in sorted(net_fps.items())))
    else:
        for end in sorted(net_fps):
            v = net_fps[end]
            ratio = v / base_fps if base_fps else 0.0
            if ratio >= args.tolerance:
                add(checks, "fps_" + end, STATUS_OK,
                    "%s netplay=%.2f fps / baseline=%.2f fps = %.1f%% (>= %.0f%%)"
                    % (end, v, base_fps, ratio * 100, args.tolerance * 100))
            else:
                add(checks, "fps_" + end, STATUS_FAIL,
                    "%s netplay=%.2f fps / baseline=%.2f fps = %.1f%% (< %.0f%%)"
                    % (end, v, base_fps, ratio * 100, args.tolerance * 100))
        if len(net_fps) >= 2:
            vals = list(net_fps.values())
            spread = max(vals) / min(vals) if min(vals) else float("inf")
            if spread <= (1.0 + args.end_spread):
                add(checks, "ends_match", STATUS_OK,
                    "both ends at same speed: fps spread=%.1f%% (<= %.0f%%)"
                    % ((spread - 1) * 100, args.end_spread * 100))
            else:
                add(checks, "ends_match", STATUS_FAIL,
                    "fps spread=%.1f%% > %.0f%%: ends likely at different speeds"
                    % ((spread - 1) * 100, args.end_spread * 100))

    # 4. For R > 1x, the game must actually run faster at the same R.
    if speed > 1.0:
        fps_1x = numeric(args.baseline_1x)
        if fps_1x is None and baseline:
            fps_1x = numeric(baseline.get("fps_1x"))
        if fps_1x is None or base_fps is None:
            add(checks, "speed_scale", STATUS_UNKNOWN,
                "no 1x baseline (fps_1x); cannot verify that fps scales with %s"
                % speed_label(speed))
        else:
            scale = base_fps / fps_1x if fps_1x else 0.0
            lo, hi = speed * args.scale_tolerance, speed / args.scale_tolerance
            if lo <= scale <= hi:
                add(checks, "speed_scale", STATUS_OK,
                    "baseline %s / 1x = %.2fx (expected %.2fx within %.2f-%.2fx)"
                    % (speed_label(speed), scale, speed, lo, hi))
            else:
                add(checks, "speed_scale", STATUS_FAIL,
                    "baseline %s / 1x = %.2fx, outside %.2f-%.2fx"
                    % (speed_label(speed), scale, lo, hi))

    # Precedence: FAIL > UNOBSERVED > PASS.
    statuses = [c["status"] for c in checks]
    verdict = STATUS_FAIL if STATUS_FAIL in statuses else (
        STATUS_UNKNOWN if STATUS_UNKNOWN in statuses else STATUS_OK)
    return verdict, checks


def print_result(args, verdict, checks, kv):
    tag = kv.get("tag", "-")
    log("=" * 72)
    log("SPEED PARITY CHECK  tag=%s  speed=%s (wire=%d)" %
        (tag, speed_label(args.speed), WIRE_FOR_SPEED[args.speed]))
    log("=" * 72)
    for c in checks:
        log("  [%-11s] %-20s %s" % (c["status"], c["name"], c["detail"]))
    log("-" * 72)
    log("VERDICT: %s  (PASS requires: valid battle + real opponent + both ends "
        "at speed %s + fps >= %.0f%% of single-player baseline%s)"
        % (verdict, speed_label(args.speed), args.tolerance * 100,
           " + fps scales with speed" if args.speed > 1.0 else ""))
    log("=" * 72)


# ---------------------------------------------------------------------------
# Dry run - print commands only
# ---------------------------------------------------------------------------

def dry_run(args):
    wire = wire_text(args.speed)
    log("SPEED PARITY CHECK - PLAN (speed=%s wire=%s; NO device/file changes)"
        % (speed_label(args.speed), wire))
    log("")
    log("0) Preconditions")
    log("   - Use the SAME speed multiplier on both ends; wire values: "
        "1x=1, 0.5x=-1, 2x=2, 4x=4 (1e9/(rate*60) on all three ends).")
    log("   - Battle counts only when BATTLE=YES AND opponent_data_real=True "
        "(not ???). UNOBSERVED => this check reports UNOBSERVED, never PASS.")
    log("   - In-battle fps gate: battle_samples>0 and in_battle_frame not False.")
    log("")
    log("1) Single-player baseline at %s (N=%s s)" % (speed_label(args.speed), args.seconds))
    log("   python tools/speed_parity_check.py --measure-baseline --speed %s "
        "--seconds %s --out .zcode-tmp/speed-parity/baseline_%s.txt"
        % (args.speed, args.seconds, speed_label(args.speed)))
    if args.speed != 1.0:
        log("   (solo PC has no env speed hook: set Tools->Speed->%s during "
            "the settle window, or pass --speed-cmd)" % speed_label(args.speed))
    log("   Alternative with an externally measured fps:")
    log("   python tools/speed_parity_check.py --write-baseline "
        ".zcode-tmp/speed-parity/baseline_%s.txt --speed %s "
        "--baseline-fps <FPS> [--baseline-1x <FPS_1X>]"
        % (speed_label(args.speed), args.speed))
    log("")
    log("2) Netplay E2E at the SAME speed on both ends (keep the existing drivers)")
    log("   # cross-device PC<->Android (authoritative for 2P acceptance):")
    log("   python tools/cloud2p_avd.py --tag SPD-AVX --mode A --runsec 420 "
        "--env MGBAX_SPEED_9=1 --app-user <APP_USER> --app-pass <APP_PASS> "
        "--pc-acc <PC_USER>:<PC_PASS>")
    log("   # or same-machine dual-PC PROXY (not cross-device evidence):")
    log("   python tools/cloud2p-duo.py --tag SPD-DUO --mode A --runsec 420 --nav "
        "--env MGBAX_SPEED_9=1")
    log("")
    log("3) While the session runs, arm BOTH ends at wire=%s" % wire)
    log("   python tools/speed_parity_check.py --arm-speed "
        ".zcode-tmp/cloud2p/<TAG> --speed %s" % args.speed)
    log("   adb shell am broadcast -a io.mgba.android.action.SPEED --ei value %s" % wire)
    log("")
    log("4) Judge the opponent screenshot (APPHUNT field), then analyse")
    log("   inspect <run>/battle_screenshot_*.png; set opponent_data_real=True "
        "in summary.txt ONLY after confirming a real (non-???) opponent")
    log("   python tools/speed_parity_check.py --from-summary "
        ".zcode-tmp/cloud2p/<TAG> --baseline "
        ".zcode-tmp/speed-parity/baseline_%s.txt --speed %s"
        % (speed_label(args.speed), args.speed))
    log("")
    log("Tolerances: fps >= %.0f%% of baseline; end-to-end spread <= %.0f%%; "
        "scale in [%.2fx, %.2fx] of requested R for R>1."
        % (args.tolerance * 100, args.end_spread * 100,
           args.speed * args.scale_tolerance, args.speed / args.scale_tolerance))
    log("Exit codes: 0=PASS 1=FAIL 3=UNOBSERVED")


# ---------------------------------------------------------------------------
# CLI
# ---------------------------------------------------------------------------

def build_parser():
    p = argparse.ArgumentParser(
        description="Same-speed netplay framerate parity check (SPEEDTEST).",
        formatter_class=argparse.RawDescriptionHelpFormatter)
    p.add_argument("--speed", type=float, default=1.0, choices=sorted(WIRE_FOR_SPEED),
                   help="speed multiplier on BOTH ends (default 1); 0.5/1/2/4 "
                        "map to type-9 wire -1/1/2/4")
    p.add_argument("--tolerance", type=float, default=0.90,
                   help="netplay fps must be >= this fraction of baseline (default 0.90)")
    p.add_argument("--end-spread", type=float, default=0.10,
                   help="max fps spread between the two ends (default 0.10)")
    p.add_argument("--scale-tolerance", type=float, default=0.75,
                   help="for R>1: baseline(R)/baseline(1x) in [R*t, R/t] (default 0.75)")

    p.add_argument("--dry-run", action="store_true", help="print plan/commands only")
    p.add_argument("--from-summary", metavar="DIR", help="analyse an existing run")
    p.add_argument("--baseline", metavar="FILE", help="baseline file (default: <DIR>/baseline*.txt)")
    p.add_argument("--baseline-fps", type=float, help="explicit baseline fps (overrides file)")
    p.add_argument("--baseline-1x", type=float, help="explicit 1x fps for the speed-scale check")
    p.add_argument("--json", action="store_true", help="also print machine-readable JSON")

    p.add_argument("--measure-baseline", action="store_true",
                   help="launch solo mGBA and sample window-title fps")
    p.add_argument("--out", default=None, help="baseline output path (with --measure-baseline)")
    p.add_argument("--seconds", type=float, default=20.0, help="sampling duration (default 20)")
    p.add_argument("--interval", type=float, default=2.0, help="sample interval seconds")
    p.add_argument("--settle-sec", type=float, default=8.0,
                   help="wait before sampling (time to set Tools->Speed for R>1)")
    p.add_argument("--speed-cmd", default=None, help="optional shell cmd to set speed after launch")
    p.add_argument("--exe", default=DEFAULT_EXE, help="mGBA executable for solo baseline")
    p.add_argument("--rom", default=DEFAULT_ROM, help="ROM for solo baseline")
    p.add_argument("--write-baseline", metavar="FILE", help="write baseline from --baseline-fps")
    p.add_argument("--source", default="external", help="baseline source label")

    p.add_argument("--arm-speed", metavar="DIR", help="write speed file(s) into a running driver")
    return p


def main():
    args = build_parser().parse_args()
    actions = [args.dry_run, bool(args.from_summary), args.measure_baseline,
               bool(args.write_baseline), bool(args.arm_speed)]
    if sum(1 for a in actions if a) != 1:
        log("ERROR: choose exactly one of --dry-run / --from-summary / "
            "--measure-baseline / --write-baseline / --arm-speed")
        return 2

    if args.dry_run:
        dry_run(args)
        return 0

    if args.measure_baseline:
        if not args.out:
            log("ERROR: --measure-baseline needs --out FILE")
            return 2
        return measure_baseline(args)

    if args.write_baseline:
        if args.baseline_fps is None:
            log("ERROR: --write-baseline needs --baseline-fps F")
            return 2
        write_baseline(args.write_baseline, args.speed, args.baseline_fps,
                       args.baseline_1x, source=args.source)
        return 0

    if args.arm_speed:
        return arm_speed(args)

    # --from-summary
    run_dir = args.from_summary
    summary = os.path.join(run_dir, "summary.txt")
    if not os.path.isfile(summary):
        log("ERROR: %s not found" % summary)
        return 2
    kv = read_kv(summary)
    baseline_path = find_baseline(run_dir, args.baseline, args.speed)
    baseline = read_kv(baseline_path) if baseline_path else None
    if args.baseline and baseline is None:
        log("WARN: baseline file %s not found (will report UNOBSERVED)" % args.baseline)
    evidence, bad = collect_speed_evidence(run_dir)
    verdict, checks = evaluate(args, kv, baseline, evidence, bad)
    print_result(args, verdict, checks, kv)
    if args.json:
        print(json.dumps({"tag": kv.get("tag"), "speed": args.speed,
                          "wire": WIRE_FOR_SPEED[args.speed], "verdict": verdict,
                          "baseline": baseline_path, "baseline_fps": (
                              args.baseline_fps if args.baseline_fps is not None
                              else (baseline.get("fps") if baseline else None)),
                          "netplay_fps": fps_from_summary(kv),
                          "speed_evidence": {k: sorted(v) for k, v in evidence.items()},
                          "checks": checks}, indent=2, sort_keys=True))
    return {STATUS_OK: 0, STATUS_FAIL: 1, STATUS_UNKNOWN: 3}[verdict]


if __name__ == "__main__":
    sys.exit(main())
