#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""FRAMEGUARD -- 端到端 2P 云端对战"卡帧/卡顿"量化检测器。

=============================================================================
用途 / 判据设计原则
=============================================================================
卡帧 = 帧率突降 / 帧间隔尖峰 / 链路断链导致画面冻结。本工具只读取证据日志，
不启动 AVD、不改 C 源码。真进战斗 / 卡帧 / 对手真实性三条判据平行输出：
BATTLE=, STUTTER=, OPPONENT=。不与 ROOTHUNT/[RHPLYR] 既有判定重复实现，只读日志。

真进战斗唯一判据（同源 rom.elf 符号，ROOTHUNT 确认）：
  cb2 ∈ [0x080B4845, 0x080B48A8) = BattleMainCB2 .. FreeRestoreBattleData，且必须双端都满足。
  以下均不算进战斗：
    0x080B310D CB2_InitBattle / 0x080B376D CB2_HandleStartBattle /
    0x0816D8CD CB2_PrintErrorMessage。
  废弃宽窗口 summary.battle_window=[0x080B30C0,0x080BCA78)（整个 battle_main.o，假阳性来源）。
  app 停在启动回调时 battle_stable_sec=None（真主循环口径），旧宽段时长仅作诊断。

必须区分两种现象：
  * 进战斗过渡黑屏（已知视觉现象）：仅短暂 fps  dip / 帧间隔偏大，但 rem 保持 1、
    无 GLINK 错误态、无通信错误 cb2、无 RTT 尖峰 -> 记为 TRANSITION_BLACKSCREEN，
    **不算卡帧**，不参与 FAIL 判定。
  * 真实链路断链卡死（算卡帧）：出现下列任一 dispositive 信号 --
      - GLINK rem=0 + st 错误态(0868/0968 等) / cmdguard 从 0 暴涨
      - LINKUP_OK 的 lnkst 从干净态回退到 0868（rem 1->0 等价签名）
      - PEEK 出现通信错误 cb2（默认 0816D8CD，位于 link-error 代码区间）
      - PC 端 mgba_sio.log 的 [diag] rem 从 1 变为 0
      - 战斗内 RTT 尖峰（peak >= --rtt-spike-ms，默认 100ms）

时间戳纪律：app logcat 时钟(06:xx) 与 PC 时钟(14:xx) 相差 8 小时时区，
**绝不跨时钟做差**；战斗稳定时长只用 app logcat 单一时钟计算。

=============================================================================
用法
=============================================================================
    python tools/frame_stutter_check.py --run-dir .zcode-tmp/cloud2p/APPHUNT-FINAL
    python tools/frame_stutter_check.py --run-dir <tag> --stable-sec 20 --max-gap-ms 33.3
    python tools/frame_stutter_check.py --run-dir <tag> --rtt-spike-ms 100 --json out.json
    python tools/frame_stutter_check.py --self-test          # 合成用例（PASS/FAIL/UNOBSERVED）

也可显式指定单个文件（用于自定义布局）：
    --summary F --logcat F [--logcat F2] --sio F --pc-stdout F --samples F --baseline F
    --frame-glob 'GLOB'

=============================================================================
退出码（进程状态码，与全家判据工具 battle_visual_gate / speed_parity_check 等一致）
=============================================================================
    0   OVERALL=PASS        —— BATTLE / STUTTER / OPPONENT 三条判据均 PASS
    1   OVERALL=FAIL        —— 任一判据 FAIL（含 OPPONENT=FAIL：对手是 ??? / 物种证据造假）
    3   OVERALL=UNOBSERVED  —— 无 FAIL，但至少一条判据 UNOBSERVED（证据不足，绝不当 PASS）
    2   = 输入/参数错误（argparse 自身以 2 退出；与全家 "2=输入错" 约定一致）
    总判取 worst(STUTTER, OPPONENT)（FAIL > UNOBSERVED > PASS）：
      verdict() 已把 BATTLE=FAIL 否决折进 STUTTER（无客观断链时降为 UNOBSERVED），
      故不重复把 BATTLE 纳入取最差，避免"日志缺失"被误降为 FAIL。
      旧行为：退出码只由 STUTTER 决定，FAIL=2 且 OPPONENT=FAIL 仍 exit 0（假 PASS 通道），
      现已修复：STUTTER=PASS + OPPONENT=FAIL -> exit 1；OPPONENT=UNOBSERVED -> exit 3。
    --self-test 是测试夹具，只返回 0（全通过）/ 1（有失败），不产出 3（例外，非验收门）。

=============================================================================
输入（在 --run-dir 下自动发现，缺失即 UNOBSERVED，不崩溃）
=============================================================================
    summary.txt              BATTLE / in_battle_frame / battle_window / fps_pc / rtt_PC / multi_PC
    app_logcat*.log          XFER(idx/have/peer/to) / Link RTT / GLINK(rem/cmdguard/st) /
                             LINKUP_OK(lnkst) / PEEK(cb2/st) / [RHPLYR](trainer 卡) /
                             [OPPSPECIES](出场精灵 species，新日志)
    mgba_sio.log (或 pc_tmp/) PC 端 [diag] rem / SIO multi ok/to / slave miss-rate
    pc_stdout.log            NAV / LINKOPEN / LAGDBG（辅助）
    samples.log              PC fps 采样（HH:MM:SS... fps=..）
    baseline_1x.txt          单人 1x 基准 fps（baseline_fps）
    frame*_big.png           帧截图文件 mtime（可选，用于帧间隔交叉验证）

=============================================================================
判据（顺序敏感：先 battle gate，再 dispositive 断链，再时长，再帧间隔）
=============================================================================
    BATTLE=FAIL    : 任一端 cb2 不在 BattleMainCB2 精确区（含单端进战斗）；
                     此时 opponent 判据一律 UNOBSERVED，species=0 不判 FAIL。
    STUTTER=FAIL   : BATTLE=FAIL 但仍有客观断链/通信错误/RTT 尖峰时如实报 FAIL
                     （reason 明示"未进战斗主循环"）；否则 Battle gate 不通 -> UNOBSERVED。
                     真进战斗后：任一 dispositive 断链/通信错误；或战斗内 RTT 尖峰；
                     或 battle_stable_sec < --stable-sec；或异常窗口内最大帧间隔 > --max-gap-ms。
    STUTTER=PASS   : 双方真进主循环、无断链、无 RTT 尖峰、稳定时长达标、帧间隔达标。
    UNOBSERVED     : 日志缺失/字段变化/STALE_BATTLE_WINDOW；"证据里没有" != "功能不存在"。

对手真实性（独立判据，OPPONENT=，与 STUTTER= 平行输出；硬标准：对方精灵是 ??? 不算成功）：
    trainer_card_real : [RHPLYR] lp1 ver/tid/name 均非零且 ver!=0xFFFF -> PASS；
                        只有 ver=4003  trainer 卡真实 **不足以** 判对手真实。
    species_real      : [OPPSPECIES] 敌方 battler 槽 species 非零且为合法物种
                        (1..0x0FFF；0/0xFFFF = ??? -> FAIL)。字段优先级 enemySpecies0 > mons[0]。
                        旧日志无 [OPPSPECIES] 行 -> UNOBSERVED（绝不因 trainer 卡真实而标 True）。
    opponent_real     : 仅 battle_gate==PASS 且 trainer_card_real==PASS 且 species_real==PASS
                        才 PASS；真战斗中任一 FAIL -> FAIL；单端进战斗(species=0)或缺 species
                        证据 -> UNOBSERVED（绝不因 trainer 卡真实而标 True/FAIL）。

=============================================================================
可配置阈值（全部走 argparse，对应 JSON.thresholds）
=============================================================================
    --stable-sec N       战斗稳定时长下限，默认 20s
    --max-gap-ms X       最大帧间隔上限，默认 33.34ms（60fps 基准 16.67ms × 2）
    --rtt-spike-ms X     RTT 尖峰阈值(ms)，默认 100
    --cmdguard-surge N   cmdguard 暴涨阈值，默认 100
    --empty-word-min N   投空字 burst 最小条数，默认 5
    --transition-grace-ms N  进战斗过渡宽限期(ms)，默认 3000；期内帧间隔大但无断链=过渡黑屏
    --error-cb2 HEX      通信错误 cb2 值，默认 0816D8CD
    --battle-cb2-range LO HI  精确 BattleMainCB2 cb2 区间（默认 0x080B4845 0x080B48A8）
    --rom-map PATH       rom.map 用于核对 BattleMainCB2 符号起点（不一致报 STALE_BATTLE_WINDOW）
    --baseline-fps X     手动覆盖基准 fps（否则从 baseline_1x.txt 读取）

输出：人类可读表 + "BATTLE=..." + "STUTTER=..." + "OPPONENT=..." 机器判据行 + "JSON:" 行；
JSON 含 opponent_evidence.{trainer_card_real,species_real,opponent_real} 与顶层 opponent_verdict 字段；
--json FILE 另存。
=============================================================================
"""

import argparse
import glob
import json
import os
import re
import statistics
import sys

from gba_addrs import (             # 统一地址宏（AGENTS §5，三端同名同值）
    BATTLE_CB2_LO, BATTLE_CB2_HI,   # 战斗主循环精确 cb2 区
    ROM_TEXT_LO, ROM_TEXT_HI,       # cb2 合法性预筛区间
)

PASS, FAIL, UNO = "PASS", "FAIL", "UNOBSERVED"

# ------------------------------------------------------------------ regexes
APP_TS_RE = re.compile(r"(?:(\d{2})-(\d{2})\s+)?(\d{2}):(\d{2}):(\d{2})[.,](\d{3})")
KV_RE = re.compile(r"([A-Za-z_][A-Za-z0-9_]*)=([^\s\]]+)")
BATTLE_WINDOW_RE = re.compile(r"battle_window=\[0x([0-9A-Fa-f]+)\s*,\s*0x([0-9A-Fa-f]+)\)")
CB2_RE = re.compile(r"\bcb2=(?:0[xX])?([0-9A-Fa-f]{6,8})\b")
HEX_N_RE = re.compile(r"^0x([0-9A-Fa-f]+)$|^([0-9A-Fa-f]+)$")
NUM_RE = re.compile(r"[-+]?\d+(?:\.\d+)?")
# 对手真实性双证据：[RHPLYR] 是 trainer 卡，[OPPSPECIES] 才是出场精灵（新日志）
RHPLYR_LP1_RE = re.compile(
    r"lp1\s+ver=([0-9A-Fa-f]+)\s+tid=([0-9A-Fa-f]+)\s+name=([0-9A-Fa-f]+)")
OPPSPECIES_ENEMY_RE = re.compile(r"\benemySpecies0=([^\s\]]+)")
OPPSPECIES_MONS_RE = re.compile(r"\bmons(?:\[0\.\.3\])?=([^\s\]]+)")


# ------------------------------------------------------------------ sources
class Src(object):
    def __init__(self, name, lines):
        self.name = name
        self.lines = lines  # [(lineno, text)]


def load(path):
    rows = []
    try:
        with open(path, "r", encoding="utf-8", errors="replace") as fh:
            for i, line in enumerate(fh, 1):
                rows.append((i, line.rstrip("\r\n")))
    except OSError:
        pass
    return Src(path, rows)


def kv(text):
    return {m.group(1): m.group(2) for m in KV_RE.finditer(text)}


def ref(src, lineno, text, limit=220):
    return {"file": os.path.basename(src.name) if src else "-",
            "line": lineno, "text": text.strip()[:limit]}


def all_lines(sources):
    for s in sources:
        for lineno, text in s.lines:
            yield s, lineno, text


def app_ts(text):
    """app logcat 时钟 -> 当日秒(float)；无法解析返回 None。"""
    m = APP_TS_RE.search(text)
    if not m:
        return None
    h, mi, sec, ms = int(m.group(3)), int(m.group(4)), int(m.group(5)), int(m.group(6))
    return h * 3600 + mi * 60 + sec + ms / 1000.0


def app_ts_str(text):
    m = APP_TS_RE.search(text)
    return m.group(0) if m else ""


def as_int(value, default=0):
    try:
        return int(str(value), 0) if str(value).lower().startswith("0x") else int(value)
    except (ValueError, TypeError):
        return default


def as_float(value, default=None):
    try:
        return float(value)
    except (ValueError, TypeError):
        return default


def hexval(value):
    m = HEX_N_RE.match(str(value or ""))
    if not m:
        return None
    return int(m.group(1) or m.group(2), 16)


def fmt_sec(ts):
    return None if ts is None else round(ts, 3)


# ------------------------------------------------------------------ discovery
def discover(run_dir, explicit):
    """自动发现 run-dir 下的证据文件；explicit 为命令行显式路径，优先。"""
    out = {k: [] for k in ("logcat", "summary", "sio", "pc_stdout", "samples", "baseline")}
    if not run_dir:
        for k, v in explicit.items():
            if v:
                out[k] = [load(p) for p in v]
        return out, []

    missing = []
    patterns = {
        "summary": ["summary.txt"],
        "logcat": ["app_logcat.log", "app_logcat_full.log", "app_link_startup.log",
                   "app_logcat*.log"],
        "sio": ["mgba_sio.log", "pc_tmp/mgba_sio.log"],
        "pc_stdout": ["pc_stdout.log"],
        "samples": ["samples.log"],
        "baseline": ["baseline_1x.txt", "baseline*.txt"],
    }
    for kind, pats in patterns.items():
        if explicit.get(kind):
            paths = explicit[kind]
        else:
            paths = []
            for pat in pats:
                paths.extend(sorted(glob.glob(os.path.join(run_dir, pat))))
            # 去重保序
            seen = set()
            paths = [p for p in paths if not (p in seen or seen.add(p))]
        out[kind] = [load(p) for p in paths]
        if not out[kind]:
            missing.append(kind)

    # 日志去重：同一会话常同时留下 app_logcat_full.log / app_link_startup.log /
    # app_logcat.log（互为子集）。若某文件 >=60% 的行已出现在更大的文件里，丢弃它，
    # 避免 RTT/投空字/GLINK 事件被重复计数。
    if len(out["logcat"]) > 1:
        ordered = sorted(out["logcat"], key=lambda s: len(s.lines), reverse=True)
        kept = [ordered[0]]
        for s in ordered[1:]:
            if not s.lines:
                continue
            pool = set(text for k in kept for _, text in k.lines)
            overlap = sum(1 for _, text in s.lines if text in pool) / float(len(s.lines))
            if overlap < 0.60:
                kept.append(s)
        out["logcat"] = kept
    return out, missing


# ------------------------------------------------------------------ summary
def parse_summary(sources):
    """summary.txt / baseline 的 key=value（首个出现者胜出，避免日志重复键污染）。"""
    sk = {}
    for s in sources:
        for lineno, text in s.lines:
            for k, v in kv(text).items():
                sk.setdefault(k, v)
    return sk


def battle_window(sk):
    m = BATTLE_WINDOW_RE.search(str(sk.get("battle_window", "")))
    if not m:
        return None
    return int(m.group(1), 16), int(m.group(2), 16)


# ------------------------------------------------------------------ fps
def parse_fps(srcs, sk, baseline_override=None):
    """baseline_fps / battle_fps / fps 采样序列（区分时钟，跨源只取数值不做时间差）。"""
    fps = {"baseline_fps": None, "battle_fps": None,
           "fps_min": None, "fps_max": None, "fps_samples": [], "source": []}

    def add(v, tag):
        f = as_float(v)
        if f is not None and 1.0 <= f <= 240.0:
            fps["fps_samples"].append(round(f, 3))
            fps["source"].append(tag)

    # baseline: --baseline-fps > baseline_1x.txt fps= > summary fps_pc
    if baseline_override is not None:
        fps["baseline_fps"] = as_float(baseline_override)
    for s in srcs.get("baseline", []):
        for lineno, text in s.lines:
            m = re.search(r"\bfps=([0-9.]+)", text)
            if m and fps["baseline_fps"] is None:
                fps["baseline_fps"] = as_float(m.group(1))
    if fps["baseline_fps"] is None and sk.get("fps_pc") is not None:
        fps["baseline_fps"] = as_float(sk.get("fps_pc"))

    # 战斗 fps: samples.log 的 fps= 优先，其次 summary fps_pc / final_* fps=
    for s in srcs.get("samples", []):
        for lineno, text in s.lines:
            for m in re.finditer(r"\bfps=([0-9.]+)", text):
                add(m.group(1), "samples.log")
    for s in srcs.get("summary", []):
        for lineno, text in s.lines:
            for m in re.finditer(r"\bfps=([0-9.]+)", text):
                add(m.group(1), "summary.txt")
    if sk.get("fps_pc") is not None:
        add(sk.get("fps_pc"), "summary.fps_pc")

    if fps["fps_samples"]:
        fps["battle_fps"] = round(statistics.mean(fps["fps_samples"]), 3)
        fps["fps_min"] = min(fps["fps_samples"])
        fps["fps_max"] = max(fps["fps_samples"])
    if fps["baseline_fps"] is None:
        fps["baseline_fps"] = fps["battle_fps"]
    return fps


# ------------------------------------------------------------------ RTT
def parse_rtt(srcs, sk, spike_ms):
    out = {"rtt_peak_ms": None, "rtt_spike_count": 0, "events": [], "samples": 0}
    peak = 0.0
    spikes = 0

    def record(us=None, ms=None, when=None, src=None, lineno=0, text=""):
        nonlocal peak, spikes
        val_ms = None
        if us is not None:
            u = as_float(us)
            if u is not None:
                val_ms = u / 1000.0
        if val_ms is None and ms is not None:
            val_ms = as_float(ms)
        if val_ms is None:
            return
        out["samples"] += 1
        if val_ms > peak:
            peak = val_ms
        is_spike = val_ms >= spike_ms
        if is_spike:
            spikes += 1
            out["events"].append({
                "type": "RTT_SPIKE", "ts": app_ts_str(text) or when or "",
                "clock": "app" if app_ts_str(text) else (when and "pc" or "unknown"),
                "value_ms": round(val_ms, 3),
                "ref": ref(src, lineno, text) if src else None,
            })

    for s in srcs.get("logcat", []):
        for lineno, text in s.lines:
            if "Link RTT" not in text:
                continue
            mmax = re.search(r"max=(\d+)us", text)
            mavg = re.search(r"avg=(\d+)us", text)
            mlast = re.search(r"last=(\d+)us", text)
            # 一行只记一次：用 max 作为该样本峰值（重复上报的同一尖峰会各记一次，
            # rtt_spike_count 反映"尖峰样本数"，stutter_events 里逐条留 ref）。
            if mmax:
                record(us=mmax.group(1), src=s, lineno=lineno, text=text)
            elif mlast:
                record(us=mlast.group(1), src=s, lineno=lineno, text=text)

    # summary 的 rtt_PC=HH:MM:SS ... peak=NNms（PC 时钟，仅数值入 peak，不做跨时钟时间差）
    for s in srcs.get("summary", []):
        for lineno, text in s.lines:
            if "rtt_PC=" in text or "[sio-rtt]" in text:
                m = re.search(r"peak=(\d+(?:\.\d+)?)ms", text)
                if m:
                    v = as_float(m.group(1))
                    if v is not None:
                        out["samples"] += 1
                        if v > peak:
                            peak = v
                        if v >= spike_ms:
                            spikes += 1
                            out["events"].append({
                                "type": "RTT_SPIKE",
                                "ts": (re.search(r"(\d{2}:\d{2}:\d{2}\.\d{3})", text) or [None, ""])[1]
                                      if re.search(r"(\d{2}:\d{2}:\d{2}\.\d{3})", text) else "",
                                "clock": "pc", "value_ms": round(v, 3),
                                "ref": ref(s, lineno, text),
                            })

    out["rtt_peak_ms"] = round(peak, 3) if out["samples"] else None
    out["rtt_spike_count"] = spikes
    return out


# ------------------------------------------------------------------ XFER / 帧间隔
def parse_xfer(srcs, battle_start_ts=None):
    """XFER idx 时间戳 -> 帧间隔代理；have=0/peer=DEAD -> 投空字；to= -> peer-timeout。"""
    out = {"xfer_count": 0, "empty_word_count": 0, "peer_dead_count": 0,
           "sio_peer_timeout_count": 0, "to_max": 0, "gaps_ms": [], "gap_pairs": [],
           "records": [], "empty_first_ts": None, "empty_last_ts": None}
    for s in srcs.get("logcat", []):
        for lineno, text in s.lines:
            if "XFER" not in text and "HSX" not in text:
                continue
            d = kv(text)
            ts = app_ts(text)
            # 投空字/peer-timeout 只统计战斗窗口内；菜单握手期的 peer=DEAD 是正常态
            in_battle = (battle_start_ts is None or
                         (ts is not None and ts >= battle_start_ts))
            if "XFER" in text and in_battle:
                out["xfer_count"] += 1
                rec = {"ts": fmt_sec(ts), "idx": as_int(d.get("idx", 0), -1),
                       "have": d.get("have"), "peer": d.get("peer"),
                       "own": d.get("own"), "to": as_int(d.get("to", 0), 0),
                       "ref": ref(s, lineno, text)}
                out["records"].append(rec)
                empty = (d.get("have") == "0" or d.get("peer") == "DEAD" or
                         d.get("own") == "0000")
                if empty:
                    out["empty_word_count"] += 1
                    if ts is not None:
                        if out["empty_first_ts"] is None or ts < out["empty_first_ts"]:
                            out["empty_first_ts"] = ts
                        if out["empty_last_ts"] is None or ts > out["empty_last_ts"]:
                            out["empty_last_ts"] = ts
                if d.get("peer") == "DEAD":
                    out["peer_dead_count"] += 1
                to = as_int(d.get("to", 0), 0)
                if to > out["to_max"]:
                    out["to_max"] = to
                # peer-timeout: to 明显偏大(>=5) 或显式 timeout token
                if to >= 5 or re.search(r"peer[- ]timeout|timeout", text, re.I):
                    out["sio_peer_timeout_count"] += 1

    # 用 XFER 时间戳序列计算间隔（同一 logcat 时钟）；只统计战斗窗口内，
    # 避免把进战斗前的菜单采样间隔误当成帧间隔。
    recs = [r for r in out["records"] if r["ts"] is not None]
    if battle_start_ts is not None:
        recs = [r for r in recs if r["ts"] >= battle_start_ts]
    recs.sort(key=lambda r: r["ts"])
    for a, b in zip(recs, recs[1:]):
        gap = round((b["ts"] - a["ts"]) * 1000.0, 3)
        if gap >= 0:
            out["gaps_ms"].append(gap)
            out["gap_pairs"].append((a["ts"], b["ts"], gap))
    out["gaps_ms"].sort()
    out["max_gap_ms"] = max(out["gaps_ms"]) if out["gaps_ms"] else None
    out["p95_gap_ms"] = (out["gaps_ms"][int(len(out["gaps_ms"]) * 0.95)]
                         if out["gaps_ms"] else None)
    out["gap_over_limit_count"] = 0  # 由 analyze 按阈值填充
    return out


# ------------------------------------------------------------------ GLINK / 断链
def parse_link(srcs, sk, cfg, battle_start_ts=None):
    """断链信号：LINKUP_OK lnkst 回退、GLINK rem=0+错误态、cmdguard 暴涨、通信 cb2、PC rem 1->0。"""
    out = {"link_drop_events": [], "cmdguard_max": 0, "cmdguard_surge_count": 0,
           "glink_rem0_count": 0, "lnkst_clean": None, "lnkst_error": None,
           "comm_error_cb2_events": [], "pc_rem_transitions": []}
    raw_cb2 = cfg.get("error_cb2") or ["0816D8CD"]
    if isinstance(raw_cb2, str):
        raw_cb2 = [raw_cb2]
    err_cb2 = set(str(v).lower().replace("0x", "") for v in raw_cb2)
    surge = cfg.get("cmdguard_surge", 100)

    for s in srcs.get("logcat", []):
        for lineno, text in s.lines:
            # --- LINKUP_OK lnkst（战斗握手态回退 0968 -> 0868）---
            if "LINKUP_OK" in text and "lnkst=" in text:
                d = kv(text)
                ln = hexval(d.get("lnkst", ""))
                if ln is not None:
                    # 偶发 lnkst 取值：0x...968 视为干净态，0x...868/0x...8xx 视为错误态
                    if (ln & 0x0F00) == 0x0900 and out["lnkst_clean"] is None:
                        out["lnkst_clean"] = {"ts": fmt_sec(app_ts(text)), "val": hex(ln),
                                              "ref": ref(s, lineno, text)}
                    if (ln & 0x0F00) == 0x0800 and out["lnkst_error"] is None:
                        out["lnkst_error"] = {"ts": fmt_sec(app_ts(text)), "val": hex(ln),
                                              "ref": ref(s, lineno, text)}
                        out["link_drop_events"].append({
                            "type": "LINK_DROP", "signal": "LINKUP_OK_lnkst_regression",
                            "ts": fmt_sec(app_ts(text)), "ts_str": app_ts_str(text),
                            "detail": "lnkst clean->err-state (rem 1->0 equivalent)",
                            "ref": ref(s, lineno, text)})

            # --- GLINK rem / cmdguard / st ---
            if "GLINK" in text:
                d = kv(text)
                rem = d.get("rem")
                st = hexval(d.get("st", "")) or 0
                cg = as_int(d.get("cmdguard", 0), 0)
                if cg > out["cmdguard_max"]:
                    out["cmdguard_max"] = cg
                if cg >= surge:
                    out["cmdguard_surge_count"] += 1
                    out["link_drop_events"].append({
                        "type": "CMDGUARD_SURGE", "signal": "cmdguard",
                        "ts": fmt_sec(app_ts(text)), "ts_str": app_ts_str(text),
                        "value": cg, "st": hex(st),
                        "detail": "cmdguard>=%d, rem=%s, st=%s" % (surge, rem, hex(st)),
                        "ref": ref(s, lineno, text)})
                if rem == "0" and st != 0:
                    out["glink_rem0_count"] += 1
                    out["link_drop_events"].append({
                        "type": "LINK_DROP", "signal": "GLINK_rem0_errstate",
                        "ts": fmt_sec(app_ts(text)), "ts_str": app_ts_str(text),
                        "st": hex(st), "cmdguard": cg,
                        "detail": "GLINK rem=0 st=%s cmdguard=%d" % (hex(st), cg),
                        "ref": ref(s, lineno, text)})

            # --- 通信错误 cb2（PEEK 行 + 明确配置的 error_cb2；NAV 行排除）---
            if "PEEK" in text:
                m = CB2_RE.search(text)
                if m:
                    cb = m.group(1).lower()
                    link_st = re.search(r"link\[m=(\d+) st=(\d+)", text)
                    ts = app_ts(text)
                    # 精确匹配的 cb2 签名总是算；区间签名仅在"战斗开始之后"才算，
                    # 避免把菜单导航态 cb2=0817481D/081897B1 误报为通信错误。
                    is_err = cb in err_cb2 or (
                        ROM_TEXT_LO <= int(cb, 16) < ROM_TEXT_HI and
                        link_st and link_st.group(1) == "0" and
                        ts is not None and
                        (battle_start_ts is None or ts >= battle_start_ts))
                    if is_err:
                        out["comm_error_cb2_events"].append({
                            "type": "COMM_ERROR_CB2", "signal": "peek_cb2",
                            "ts": fmt_sec(app_ts(text)), "ts_str": app_ts_str(text),
                            "cb2": cb, "ref": ref(s, lineno, text)})

    # PC 端 [diag] rem 1 -> 0
    for s in srcs.get("sio", []):
        prev = None
        for lineno, text in s.lines:
            if "[diag]" not in text:
                continue
            m = re.search(r"\brem=(\d+)", text)
            if not m:
                continue
            rem = m.group(1)
            if prev == "1" and rem == "0":
                out["pc_rem_transitions"].append({
                    "type": "LINK_DROP", "signal": "PC_sio_diag_rem_1to0",
                    "ts": None, "ts_str": "", "detail": "mgba_sio.log [diag] rem 1->0",
                    "ref": ref(s, lineno, text)})
            prev = rem

    # 去重：LINK_DROP 信号按 (type,signal) 保留最早一条作为"断链时刻"，其余进 events 列表
    drops = [e for e in out["link_drop_events"] if e["type"] == "LINK_DROP"]
    out["link_drop_count"] = 1 if drops else 0  # 同一失败片段只算一次断链
    return out


def battle_start(srcs, sk, win):
    """in_battle 首帧：优先 app logcat 里 cb2 落在战斗窗口的运行期行，其次 LINKUP_OK。"""
    cands = []
    lo, hi = win if win else (0, 0)
    for s in srcs.get("logcat", []):
        for lineno, text in s.lines:
            if "SIOROM" in text or "SIOCODE" in text:  # 代码签名行，不是运行期
                continue
            m = CB2_RE.search(text)
            ts = app_ts(text)
            if m and ts is not None and lo <= int(m.group(1), 16) < hi:
                cands.append((ts, app_ts_str(text), "cb2_in_battle_window",
                              ref(s, lineno, text), text))
            if "LINKUP_OK" in text and ts is not None:
                cands.append((ts, app_ts_str(text), "LINKUP_OK",
                              ref(s, lineno, text), text))
    if cands:
        cands.sort(key=lambda x: x[0])
        ts, ts_str, src_name, r, txt = cands[0]
        return {"ts": fmt_sec(ts), "ts_str": ts_str, "source": src_name, "ref": r}
    # 无时间戳时退回 summary 布尔量（无法算时长）
    if str(sk.get("in_battle_frame", "")).lower() in ("true", "1", "yes") or \
       sk.get("BATTLE") == "YES":
        return {"ts": None, "ts_str": "", "source": "summary.flag_no_timestamp", "ref": None}
    return None


# ------------------------------------------------------------------ battle main gate
# 唯一"真进战斗"判据：同源 rom.elf 符号 BattleMainCB2 = 0x080B4845(Thumb cb2)，
# 下一符号 FreeRestoreBattleData = 0x080B48A8。区间是 **cb2 值区间**，直接比较。
# 非主循环回调（均不算进战斗）：
#   0x080B310D CB2_InitBattle / 0x080B376D CB2_HandleStartBattle / 0x0816D8CD CB2_PrintErrorMessage
ELF_BATTLE_CB2_LO = BATTLE_CB2_LO   # 统一宏原值 0x080B4845
ELF_BATTLE_CB2_HI = BATTLE_CB2_HI   # 统一宏原值 0x080B48A8


def resolve_battle_main_window(cfg, run_dir):
    """返回精确 cb2 区间 [lo,hi)（ROOTHUNT 同源 rom.elf 确认），可用 CLI 覆盖。

    绝不使用 summary 的宽 battle_window=[0x080B30C0,0x080BCA78)：那是整个
    battle_main.o 段，含 CB2_InitBattle(0x080B310D) 与换屏回调(0x080B376D)，
    不是战斗主循环，是假阳性来源。rom.map 仅用于交叉核对符号起点。
    """
    explicit = cfg.get("battle_cb2_range")
    if explicit:
        lo, hi = int(str(explicit[0]), 0), int(str(explicit[1]), 0)
        return {"lo": lo, "hi": hi,
                "source": cfg.get("battle_cb2_source", "cli"), "symbol": "BattleMainCB2"}

    lo, hi = ELF_BATTLE_CB2_LO, ELF_BATTLE_CB2_HI
    source = "rom.elf (ROOTHUNT): BattleMainCB2..FreeRestoreBattleData"
    # 交叉核对：rom.map 中 BattleMainCB2 symbol|1 必须等于 lo，否则判过期窗口
    candidates = []
    if cfg.get("rom_map"):
        candidates.append(cfg["rom_map"])
    if run_dir:
        candidates.append(os.path.join(run_dir, "rom.map"))
    candidates.append("rom.map")
    for path in candidates:
        if not path or not os.path.isfile(path):
            continue
        try:
            with open(path, "r", encoding="utf-8", errors="replace") as fh:
                content = fh.read()
        except OSError:
            continue
        m = re.search(r"0x([0-9A-Fa-f]+)\s+BattleMainCB2\b", content)
        if m:
            sym = int(m.group(1), 16)
            if (sym | 1) != lo:
                return {"lo": None, "hi": None, "source": "STALE_BATTLE_WINDOW",
                        "symbol": "BattleMainCB2",
                        "error": "rom.map BattleMainCB2=0x%X(+1=0x%X) != elf 0x%X; pass --battle-cb2-range" %
                                 (sym, sym | 1, lo)}
            source += " + rom.map cross-checked"
            break
    return {"lo": lo, "hi": hi, "source": source, "symbol": "BattleMainCB2"}


def is_battle_main_cb2(cb2_raw, win):
    """cb2 值必须精确落在 [0x080B4845,0x080B48A8)；这是唯一真进战斗判据。"""
    if not win or win.get("lo") is None:
        return False
    val = hexval(cb2_raw)
    if val is None:
        return False
    return win["lo"] <= val < win["hi"]


def parse_battle_gate(srcs, sk, win):
    """真进战斗主循环 = 双方 cb2 都精确落在 BattleMainCB2 函数区间。

    app 侧 cb2 来自 app logcat 运行期行 + summary.app_cb2；PC 侧来自
    mgba_sio.log [room]/[diag] cb2 + summary.in_battle_cb2_PC。
    单端进战斗 -> gate=FAIL（no-battle），绝不算"进战斗"。
    """
    out = {"battle_gate": UNO, "app_entered": False, "pc_entered": False,
           "app_cb2_values": [], "pc_cb2_values": [],
           "app_hits": [], "pc_hits": [], "app_first_main_ts": None,
           "legacy_wide_window": sk.get("battle_window"), "window": win,
           "notes": []}
    if win.get("lo") is None:
        out["notes"].append("STALE_BATTLE_WINDOW: no precise BattleMainCB2 range")
        return out

    app_seen, pc_seen = set(), set()
    for s in srcs.get("logcat", []):
        for lineno, text in s.lines:
            if "SIOROM" in text or "SIOCODE" in text:  # 代码签名行，不是运行期 cb2
                continue
            m = CB2_RE.search(text)
            if not m:
                continue
            cb = m.group(1).lower()
            app_seen.add(cb)
            if is_battle_main_cb2(cb, win):
                ts = app_ts(text)
                hit = {"cb2": cb, "ts": fmt_sec(ts), "ref": ref(s, lineno, text, limit=260)}
                out["app_hits"].append(hit)
                if ts is not None and (out["app_first_main_ts"] is None or
                                       ts < out["app_first_main_ts"]):
                    out["app_first_main_ts"] = ts
    for key in ("app_cb2", "app_in_battle_cb2"):
        v = sk.get(key)
        if v:
            cb = hexval(v)
            if cb is not None:
                app_seen.add(("%08X" % cb).lower())
            if is_battle_main_cb2(v, win):
                out["app_hits"].append({"cb2": str(v), "ts": None,
                                        "source": "summary." + key})

    for s in srcs.get("sio", []):
        for lineno, text in s.lines:
            if "[room]" not in text and "[diag]" not in text:
                continue
            m = re.search(r"\bcb2=0x?([0-9A-Fa-f]{6,8})\b", text, re.I)
            if not m:
                continue
            cb = m.group(1).lower()
            pc_seen.add(cb)
            if is_battle_main_cb2(cb, win):
                out["pc_hits"].append({"cb2": cb, "ref": ref(s, lineno, text, limit=260)})
    for key in ("in_battle_cb2_PC", "lastCb2_PC"):
        v = sk.get(key)
        if v:
            cb = hexval(v)
            if cb is not None:
                pc_seen.add(("%08X" % cb).lower())
            if is_battle_main_cb2(v, win):
                out["pc_hits"].append({"cb2": str(v), "source": "summary." + key})

    out["app_cb2_values"] = sorted(app_seen)
    out["pc_cb2_values"] = sorted(pc_seen)
    out["app_entered"] = bool(out["app_hits"])
    out["pc_entered"] = bool(out["pc_hits"])
    if out["app_entered"] and out["pc_entered"]:
        out["battle_gate"] = PASS
    elif out["app_entered"] or out["pc_entered"]:
        out["battle_gate"] = FAIL
        out["notes"].append("single-ended battle main entry (app=%s pc=%s) -> no-battle" %
                            (out["app_entered"], out["pc_entered"]))
    elif app_seen or pc_seen:
        out["battle_gate"] = FAIL
        out["notes"].append("cb2 observed but none in BattleMainCB2 precise range")
    else:
        out["notes"].append("no cb2 evidence")
    return out


# ------------------------------------------------------------------ opponent reality
def parse_species_value(raw):
    """species 字段解析：默认十六进制(与 cb2/tid 一致)，支持 0x 前缀与十进制 d 后缀。"""
    if raw is None:
        return None
    v = str(raw).strip().rstrip(",")
    if not v:
        return None
    if v.lower().endswith("d") and re.fullmatch(r"\d+d", v, re.I):
        return int(v[:-1], 10)
    try:
        if v.lower().startswith("0x"):
            return int(v, 16)
        if re.fullmatch(r"[0-9A-Fa-f]{1,8}", v):
            return int(v, 16)
    except ValueError:
        return None
    return None


def species_valid(val):
    """??? = 0 / 0xFFFF / 非法大数；Gen3 合法物种 1..0x58A。

    上界收紧到 0x58A(1418)：0x58B(1419)=gNumSpeciesNames 表长度/越界哨兵，
    不是有效物种，必须排除（旧上界 0x0FFF 会把它误纳为合法）。"""
    return val is not None and 1 <= val <= 0x58A


def is_zero_token(tok):
    return tok is None or re.fullmatch(r"0+(?:x0+)?", str(tok), re.I) is not None


def parse_opponent(srcs, sk, battle_gate=None):
    """对手真实性 = 双证据(trainer 卡 AND 出场精灵) AND 双方都真进战斗主循环。

    硬标准：单端进战斗时 species=0 不算 FAIL，而是 no-battle -> UNOBSERVED
    （由 battle gate 否决）。旧日志无 [OPPSPECIES] 时 species 也是 UNOBSERVED。
    """
    out = {
        "trainer_card_real": UNO, "species_real": UNO, "opponent_real": UNO,
        "criterion": "battle_gate(PASS) AND trainer_card([RHPLYR]) AND species([OPPSPECIES])",
        "trainer_evidence": [], "species_evidence": [], "refs": [],
        "rhplyr_lines": [], "oppspecies_lines": [], "notes": [],
        "battle_gate": (battle_gate or {}).get("battle_gate") if battle_gate else None,
    }
    all_srcs = [("logcat", s) for s in srcs.get("logcat", [])] + \
               [("summary", s) for s in srcs.get("summary", [])]

    # ---- (1) trainer 卡：[RHPLYR] lp1 ver/tid/name ----
    trainer_good = False
    trainer_bad = False
    for kind, s in all_srcs:
        for lineno, text in s.lines:
            if "[RHPLYR]" not in text:
                continue
            out["rhplyr_lines"].append(ref(s, lineno, text, limit=260))
            saw_lp1 = False
            for m in RHPLYR_LP1_RE.finditer(text):
                saw_lp1 = True
                ver, tid, name = m.group(1), m.group(2), m.group(3)
                ver_v = parse_species_value(ver)
                # ver 是 trainer 卡版本，不是物种：只需非零且非 0xFFFF
                ver_ok = ver_v is not None and ver_v not in (0, 0xFFFF, 0xFFFFFFFF)
                good = (ver_ok and not is_zero_token(tid) and not is_zero_token(name))
                rec = {"ver": ver, "tid": tid, "name": name, "good": good,
                       "ref": ref(s, lineno, text, limit=260)}
                out["trainer_evidence"].append(rec)
                out["refs"].append(rec["ref"])
                if good:
                    trainer_good = True
                elif not ver_ok or is_zero_token(name) or is_zero_token(tid):
                    trainer_bad = True
            if not saw_lp1 and len(out["rhplyr_lines"]) == 1:
                out["notes"].append("[RHPLYR] line lacks lp1 ver/tid/name")
    # summary 的 opponent_data_real=True 仅作旁证，不能替代原始 lp1 字段
    if not out["rhplyr_lines"]:
        out["notes"].append("no [RHPLYR] line in logs")

    if trainer_good:
        out["trainer_card_real"] = PASS
    elif trainer_bad or out["rhplyr_lines"]:
        out["trainer_card_real"] = FAIL if trainer_bad else UNO
    # ---- (2) 出场精灵：[OPPSPECIES] ----
    species_good = False
    species_bad = False
    for kind, s in all_srcs:
        for lineno, text in s.lines:
            if "[OPPSPECIES]" not in text:
                continue
            line = ref(s, lineno, text, limit=320)
            out["oppspecies_lines"].append(line)
            out["refs"].append(line)
            em = OPPSPECIES_ENEMY_RE.search(text)
            mm = OPPSPECIES_MONS_RE.search(text)
            raw = em.group(1) if em else None
            mons_raw = mm.group(1) if mm else None
            mons_vals = []
            if mons_raw:
                for tok in re.split(r"[,/\s]+", mons_raw):
                    v = parse_species_value(tok)
                    if v is not None:
                        mons_vals.append(v)
            # 敌方 battler 槽：优先 enemySpecies0，其次 mons[0]
            cand = parse_species_value(raw) if raw is not None else \
                   (mons_vals[0] if mons_vals else None)
            cand_src = "enemySpecies0" if raw is not None else "mons[0]"
            m_party = re.search(r"enemyPartyCnt=(\d+)", text)
            m_buf = re.search(r"recvBuf0=([^\s\]]+)", text)
            ent = {"enemySpecies0": raw, "mons": mons_raw, "mons_vals": mons_vals,
                   "candidate": cand, "candidate_source": cand_src,
                   "valid": species_valid(cand),
                   "party_cnt": m_party.group(1) if m_party else None,
                   "recv_buf0": m_buf.group(1) if m_buf else None,
                   "ref": line}
            out["species_evidence"].append(ent)
            if species_valid(cand):
                species_good = True
            else:
                species_bad = True

    if species_good:
        out["species_real"] = PASS
    elif species_bad:
        out["species_real"] = FAIL
    else:
        out["notes"].append("no [OPPSPECIES] species field -> species UNOBSERVED (legacy logs)")

    # ---- (3) battle gate 否决：双方未真进主循环时 species 不参与 FAIL 判定 ----
    gate = (battle_gate or {}).get("battle_gate")
    if gate != PASS:
        out["notes"].append("battle gate=%s: opponent species not judged (no-battle); "
                            "species=0 here is NOT a FAIL" % gate)
        # 仍保留原始 species_evidence 供审计，但判据统一为 UNOBSERVED
        for ent in out["species_evidence"]:
            ent["valid_under_gate"] = None
        out["species_real"] = UNO
        out["opponent_real"] = UNO
        return out

    # ---- (4) 双方真进主循环：双证据都 PASS 才算对手真实 ----
    if out["trainer_card_real"] == PASS and out["species_real"] == PASS:
        out["opponent_real"] = PASS
    elif out["trainer_card_real"] == FAIL or out["species_real"] == FAIL:
        out["opponent_real"] = FAIL
    else:
        out["opponent_real"] = UNO
    return out


# ------------------------------------------------------------------ frame png
def parse_frame_pngs(run_dir, pattern):
    if not run_dir or not pattern:
        return []
    rows = []
    for p in sorted(glob.glob(os.path.join(run_dir, pattern))):
        try:
            rows.append({"name": os.path.basename(p), "mtime": os.path.getmtime(p)})
        except OSError:
            pass
    return rows


# ------------------------------------------------------------------ analyze
def analyze(srcs, cfg, run_dir=None):
    sk = parse_summary(srcs.get("summary", []))
    legacy_win = battle_window(sk)          # 宽段，仅作诊断，绝不再当"进战斗"判据
    win = resolve_battle_main_window(cfg, run_dir)  # 精确 BattleMainCB2 cb2 区间
    gate = parse_battle_gate(srcs, sk, win)
    fps = parse_fps(srcs, sk, cfg.get("baseline_fps"))
    rtt = parse_rtt(srcs, sk, cfg["rtt_spike_ms"])
    # init anchor (LINKUP_OK / 宽段) 只用于圈定链路事件采样窗口，不证明进了主循环
    start = battle_start(srcs, sk, legacy_win)
    start_ts = start["ts"] if start else None
    xfer = parse_xfer(srcs, battle_start_ts=start_ts)
    link = parse_link(srcs, sk, cfg, battle_start_ts=start_ts)
    opponent = parse_opponent(srcs, sk, battle_gate=gate)
    pngs = parse_frame_pngs(run_dir, cfg.get("frame_glob"))

    # ---- 战斗稳定时长（仅 app 时钟）----
    battle_stable_sec = None
    sampling_end_ts = None
    all_app_ts = []
    for s in srcs.get("logcat", []):
        for lineno, text in s.lines:
            t = app_ts(text)
            if t is not None:
                all_app_ts.append(t)
    if all_app_ts:
        sampling_end_ts = max(all_app_ts)
    drop_ts = None
    if link["link_drop_count"]:
        timed = [e["ts"] for e in link["link_drop_events"]
                 if e["type"] == "LINK_DROP" and e.get("ts") is not None]
        if timed:
            drop_ts = min(timed)
    end = drop_ts if drop_ts is not None else sampling_end_ts
    # 旧口径（宽段/LINKUP_OK 起算）：仅诊断，不是真战斗主循环时长
    battle_init_stable_sec = None
    if start and start["ts"] is not None and end is not None and end >= start["ts"]:
        battle_init_stable_sec = round(end - start["ts"], 3)
    # 真口径：只从 app cb2 首次落入 BattleMainCB2 精确区起算；未进主循环则为 None
    battle_stable_sec = None
    if gate["battle_gate"] == PASS and gate["app_first_main_ts"] is not None and \
            end is not None and end >= gate["app_first_main_ts"]:
        battle_stable_sec = round(end - gate["app_first_main_ts"], 3)

    # ---- 帧间隔判定 ----
    max_gap = xfer.get("max_gap_ms")
    gap_over = 0
    if max_gap is not None:
        gap_over = sum(1 for g in xfer["gaps_ms"] if g > cfg["max_gap_ms"])
    xfer["gap_over_limit_count"] = gap_over

    # ---- 过渡黑屏 vs 真实卡帧分类（按时间邻近性，而非全局布尔）----
    grace = cfg["transition_grace_ms"] / 1000.0
    abn_ts = []
    for e in (link["link_drop_events"] + link["comm_error_cb2_events"] + rtt["events"]):
        if isinstance(e.get("ts"), (int, float)):
            abn_ts.append(e["ts"])
    if xfer["empty_first_ts"] is not None:
        abn_ts.append(xfer["empty_first_ts"])
        if xfer["empty_last_ts"] is not None:
            abn_ts.append(xfer["empty_last_ts"])
    link_abnormal = bool(link["link_drop_count"] or link["comm_error_cb2_events"] or
                         rtt["rtt_spike_count"] or link["cmdguard_surge_count"] or
                         xfer["empty_word_count"] >= cfg["empty_word_min"])

    frame_gap_events = []
    stutter_gaps = []
    for t0, t1, g in xfer["gap_pairs"]:
        if g <= cfg["max_gap_ms"]:
            continue
        near = any(t0 - grace <= a <= t1 + grace for a in abn_ts)
        if not abn_ts and link_abnormal:
            near = True  # 只有 summary 级异常(无 app 时间戳)时的保守回退
        classified = "STUTTER" if near else "TRANSITION_BLACKSCREEN"
        if classified == "STUTTER":
            stutter_gaps.append(g)
        frame_gap_events.append({
            "type": "FRAME_GAP", "ts": fmt_sec(t1), "gap_ms": g,
            "classified": classified, "near_abnormal_signal": near,
            "detail": ("frame gap over limit near link-abnormal event" if near
                       else "frame gap inside battle-transition grace window, no drop signature"),
        })
    # 仅保留最大的若干条，避免 JSON 爆炸
    frame_gap_events.sort(key=lambda e: e["gap_ms"], reverse=True)
    frame_gap_events = frame_gap_events[:8]
    max_stutter_gap = max(stutter_gaps) if stutter_gaps else None

    stutter_events = []
    stutter_events.extend(link["link_drop_events"])
    stutter_events.extend(rtt["events"])
    stutter_events.extend(link["comm_error_cb2_events"])
    # 投空字 burst 作为一条汇总事件
    if xfer["empty_word_count"] >= cfg["empty_word_min"]:
        stutter_events.append({
            "type": "EMPTY_WORD_BURST", "signal": "XFER_have0_peerDEAD",
            "ts": fmt_sec(xfer["empty_first_ts"]),
            "ts_str": (app_ts_str(next((r["ref"]["text"] for r in xfer["records"]
                                        if r["ts"] == xfer["empty_first_ts"]), ""))
                       if xfer["empty_first_ts"] is not None else ""),
            "count": xfer["empty_word_count"],
            "detail": "%d x XFER have=0/peer=DEAD/own=0000" % xfer["empty_word_count"],
        })
    stutter_events.extend(frame_gap_events)

    def _sort_key(e):
        t = e.get("ts")
        if isinstance(t, (int, float)):
            return (0, float(t), e["type"])
        return (1, 0.0, e["type"])  # 无时间戳(PC 时钟/未知)的排末尾

    # 按时间/类型稳定排序（无时间的放末尾）
    stutter_events.sort(key=_sort_key)
    # 只有"链路异常窗口内"的帧间隔超限才算卡帧；过渡宽限期内算 TRANSITION_BLACKSCREEN
    gap_stutter_count = sum(1 for e in frame_gap_events if e["classified"] == "STUTTER")

    metrics = {
        "baseline_fps": fps["baseline_fps"], "battle_fps": fps["battle_fps"],
        "fps_min": fps["fps_min"], "fps_max": fps["fps_max"],
        "fps_sample_count": len(fps["fps_samples"]), "fps_source": fps["source"],
        "max_gap_ms": max_gap, "max_stutter_gap_ms": max_stutter_gap,
        "p95_gap_ms": xfer.get("p95_gap_ms"),
        "gap_over_limit_count": gap_over, "gap_stutter_count": gap_stutter_count,
        "transition_blackscreen_gap_count": len(frame_gap_events) - gap_stutter_count,
        "xfer_count": xfer["xfer_count"],
        "rtt_peak_ms": rtt["rtt_peak_ms"], "rtt_spike_count": rtt["rtt_spike_count"],
        "rtt_samples": rtt["samples"],
        "link_drop_count": link["link_drop_count"],
        "glink_rem0_count": link["glink_rem0_count"],
        "cmdguard_max": link["cmdguard_max"],
        "cmdguard_surge_count": link["cmdguard_surge_count"],
        "empty_word_count": xfer["empty_word_count"],
        "peer_dead_count": xfer["peer_dead_count"],
        "sio_peer_timeout_count": xfer["sio_peer_timeout_count"], "to_max": xfer["to_max"],
        "comm_error_cb2_count": len(link["comm_error_cb2_events"]),
        "comm_error_cb2_values": sorted({e["cb2"] for e in link["comm_error_cb2_events"]}),
        "battle_start": ({"ts": fmt_sec(gate["app_first_main_ts"]),
                          "source": "app_cb2_in_BattleMainCB2"}
                         if gate["battle_gate"] == PASS and gate["app_first_main_ts"] is not None
                         else None),
        "battle_init_start_diagnostic": start,
        "link_drop_ts": fmt_sec(drop_ts),
        "sampling_end_ts": fmt_sec(sampling_end_ts),
        "battle_stable_sec": battle_stable_sec,          # 真主循环口径
        "battle_init_stable_sec_diagnostic": battle_init_stable_sec,
        "frame_png_count": len(pngs),
        "battle_window": [hex(legacy_win[0]), hex(legacy_win[1])] if legacy_win else None,
        "battle_main_cb2_window": (["0x%08X" % win["lo"], "0x%08X" % win["hi"]]
                                   if win.get("lo") is not None else None),
        "battle_main_cb2_source": win.get("source"),
        "battle_gate": gate["battle_gate"],
        "app_entered_battle_main": gate["app_entered"],
        "pc_entered_battle_main": gate["pc_entered"],
        "app_cb2_values": gate["app_cb2_values"],
        "pc_cb2_values": gate["pc_cb2_values"],
        "battle_gate_hits": gate["app_hits"][:4] + gate["pc_hits"][:4],
        "battle_gate_notes": gate["notes"],
        "in_battle_frame_flag": sk.get("in_battle_frame"),
        "battle_flag": sk.get("BATTLE"),
        # opponent reality: dual evidence, missing species => UNOBSERVED (not True)
        "trainer_card_real": opponent["trainer_card_real"],
        "opponent_species_real": opponent["species_real"],
        "opponent_real": opponent["opponent_real"],
    }

    continuity = {
        # 真进战斗必须双方 cb2 都落在 BattleMainCB2 精确区；宽段/LINKUP_OK 不算
        "battle_observed": (gate["battle_gate"] == PASS),
        "stable_duration_met": (battle_stable_sec is not None and
                                battle_stable_sec >= cfg["stable_sec"]),
        "max_gap_within_limit": (max_gap is None or max_gap <= cfg["max_gap_ms"]),
        "gap_stutter_free": (gap_stutter_count == 0),
        "link_held": (link["link_drop_count"] == 0 and
                      not link["comm_error_cb2_events"]),
        "rtt_clean": (rtt["rtt_spike_count"] == 0),
        "timing_source": "XFER idx timestamps (app clock)" if xfer["records"] else None,
    }
    return {"metrics": metrics, "continuity": continuity, "stutter_events": stutter_events,
            "battle_gate": gate, "opponent": opponent,
            "fps_details": fps, "xfer_gaps_ms": xfer["gaps_ms"],
            "summary_keys": {k: sk[k] for k in ("tag", "BATTLE", "in_battle_frame",
                                                "battle_samples", "fps_pc", "rtt_PC")
                             if k in sk}}


def battle_verdict(result):
    """BATTLE= 判据：真进战斗唯一标准是双方 cb2 ∈ [0x080B4845,0x080B48A8)。"""
    m, g = result["metrics"], result["battle_gate"]
    if m.get("battle_main_cb2_source") == "STALE_BATTLE_WINDOW":
        return UNO, "STALE_BATTLE_WINDOW: precise BattleMainCB2 range unavailable"
    if g["battle_gate"] == PASS:
        return PASS, ("both ends cb2 in [%s,%s) BattleMainCB2" %
                      (m["battle_main_cb2_window"][0], m["battle_main_cb2_window"][1]))
    app = ",".join(m["app_cb2_values"][:4]) or "-"
    pc = ",".join(m["pc_cb2_values"][:4]) or "-"
    return FAIL, ("NO-BATTLE-MAIN: app cb2=%s pc cb2=%s; app stuck at "
                  "CB2_HandleStartBattle(0x080B376D)/CB2_InitBattle(0x080B310D)/"
                  "CB2_PrintErrorMessage(0x0816D8CD) - NOT in battle main loop" % (app, pc))


def verdict(result, cfg):
    m, c = result["metrics"], result["continuity"]
    bg, br = battle_verdict(result)
    if bg == UNO:
        return UNO, br
    if bg == FAIL:
        # 未真进战斗：客观断链/通信错误仍要如实报告，但 reason 必须明示"未进战斗"
        drop_bits = []
        if m["link_drop_count"]:
            drop_bits.append("link-drop x%d" % m["link_drop_count"])
        if m["comm_error_cb2_count"]:
            drop_bits.append("comm cb2=%s" % ",".join(m["comm_error_cb2_values"]))
        if m["rtt_spike_count"]:
            drop_bits.append("RTT spike x%d peak=%.3fms" %
                             (m["rtt_spike_count"], m["rtt_peak_ms"] or 0))
        if drop_bits:
            return FAIL, ("BATTLE=FAIL no battle main loop (%s); objective link anomaly: %s" %
                          (br, " + ".join(drop_bits)))
        return UNO, ("BATTLE=FAIL no battle main loop (%s); stutter unobservable, never PASS" % br)
    if m["max_gap_ms"] is None and m["rtt_peak_ms"] is None and \
            m["xfer_count"] == 0 and m["baseline_fps"] is None:
        return UNO, "no timing signal (logs missing/fields changed)"
    # 1) dispositive link drop / comm error
    if c["link_held"] is False:
        reasons = []
        if m["link_drop_count"]:
            reasons.append("GLINK/lnkst link-drop signature x%d" % m["link_drop_count"])
        if m["comm_error_cb2_count"]:
            reasons.append("comm-error cb2=%s" % ",".join(m["comm_error_cb2_values"]))
        return FAIL, "real link drop / comm error: " + " + ".join(reasons)
    # 2) cmdguard surge + empty-word burst (C layer out of control w/o explicit drop)
    if (m["cmdguard_surge_count"] > 0 and
            m["empty_word_count"] >= cfg["empty_word_min"]):
        return FAIL, ("cmdguard surge(max=%d) + %d empty words -> link runaway/freeze" %
                      (m["cmdguard_max"], m["empty_word_count"]))
    # 3) in-battle RTT spike
    if not c["rtt_clean"]:
        return FAIL, ("in-battle RTT spike x%d peak=%.3fms >= %.1fms" %
                      (m["rtt_spike_count"], m["rtt_peak_ms"] or 0, cfg["rtt_spike_ms"]))
    # 4) battle stable duration
    if m["battle_stable_sec"] is None:
        return UNO, "battle observed but no app-clock anchor for stable duration"
    if not c["stable_duration_met"]:
        return FAIL, ("battle stable %.3fs < %.1fs (link dropped/sampling ended early)" %
                      (m["battle_stable_sec"], cfg["stable_sec"]))
    # 5) frame gap: only gaps inside an abnormal-link window count as stutter;
    #    gaps inside the battle transition grace period are TRANSITION_BLACKSCREEN.
    if not c["gap_stutter_free"]:
        return FAIL, ("max frame gap %.3fms > %.3fms inside abnormal-link window (stutter)" %
                      (m["max_gap_ms"], cfg["max_gap_ms"]))
    return PASS, ("battle stable %.3fs OK, no drop/RTT spike, max frame gap %.3fms" %
                  (m["battle_stable_sec"], m["max_gap_ms"] or 0))


def overall_verdict(status, opponent):
    """总判 = worst(STUTTER, OPPONENT)，FAIL > UNOBSERVED > PASS。

    status 来自 verdict()（已含 BATTLE 否决），opponent 来自 opponent_real。
    这样 STUTTER=PASS 不能再掩盖 OPPONENT=FAIL/UNOBSERVED 的假 PASS（Q7 §2.4b）。
    不重复纳入 BATTLE：缺日志时 BATTLE=FAIL 但 STUTTER=UNOBSERVED，
    重复取最差会把"证据不足"误降成 FAIL（退出码 1），破坏既有语义。
    """
    order = {PASS: 0, UNO: 1, FAIL: 2}
    return max((status, opponent), key=lambda v: order.get(v, 1))


# ------------------------------------------------------------------ output
def render(result, status, reason, cfg, run_dir):
    m, c = result["metrics"], result["continuity"]
    lines = []
    lines.append("tag=%s  STUTTER=%s" % (result.get("summary_keys", {}).get("tag") or
                                         (os.path.basename(run_dir) if run_dir else "-"), status))
    lines.append("reason: %s" % reason)
    lines.append("thresholds: stable_sec=%s max_gap_ms=%s rtt_spike_ms=%s" %
                 (cfg["stable_sec"], cfg["max_gap_ms"], cfg["rtt_spike_ms"]))
    lines.append("")
    lines.append("  max_gap_ms            = %s" % m["max_gap_ms"])
    lines.append("  rtt_peak_ms           = %s   (spikes=%s)" %
                 (m["rtt_peak_ms"], m["rtt_spike_count"]))
    lines.append("  link_drop_count       = %s" % m["link_drop_count"])
    lines.append("  battle_stable_sec     = %s" % m["battle_stable_sec"])
    lines.append("  baseline_fps          = %s" % m["baseline_fps"])
    lines.append("  battle_fps            = %s" % m["battle_fps"])
    lines.append("  empty_word_count      = %s" % m["empty_word_count"])
    lines.append("  cmdguard_max          = %s" % m["cmdguard_max"])
    lines.append("  comm_error_cb2        = %s" % (m["comm_error_cb2_values"] or []))
    bg, br = battle_verdict(result)
    lines.append("")
    lines.append("battle main gate (BATTLE=):")
    lines.append("  BATTLE                = %s" % bg)
    lines.append("  reason                = %s" % br[:150])
    lines.append("  battle_main_cb2_window= %s  src=%s" %
                 (m["battle_main_cb2_window"], m["battle_main_cb2_source"]))
    lines.append("  app_entered/pc_entered= %s / %s" %
                 (m["app_entered_battle_main"], m["pc_entered_battle_main"]))
    lines.append("  app_cb2_values        = %s" % m["app_cb2_values"][:6])
    lines.append("  pc_cb2_values         = %s" % m["pc_cb2_values"][:6])
    lines.append("  battle_init_stable(diag)=%s  (wide/LINKUP_OK anchor, NOT real battle)" %
                 m["battle_init_stable_sec_diagnostic"])
    lines.append("")
    lines.append("opponent (battle gate AND dual evidence):")
    lines.append("  trainer_card_real     = %s  ([RHPLYR] lp1 ver/tid/name)" %
                 m["trainer_card_real"])
    lines.append("  opponent_species_real = %s  ([OPPSPECIES], 0/0xFFFF=??? => FAIL)" %
                 m["opponent_species_real"])
    lines.append("  opponent_real         = %s  (battle gate AND trainer AND species; no-battle => UNOBSERVED)" %
                 m["opponent_real"])
    lines.append("")
    lines.append("stutter_events (%d):" % len(result["stutter_events"]))
    for e in result["stutter_events"]:
        r = e.get("ref") or {}
        loc = "%s:%s" % (r.get("file", "-"), r.get("line", "-"))
        lines.append("  %-20s %-10s %-40s %s" %
                     (e["type"], e.get("ts_str") or e.get("ts") or "-",
                      str(e.get("detail", ""))[:40], loc))
    return "\n".join(lines)


def build_json(result, status, reason, cfg, run_dir, missing):
    return {
        "schema": "frame-stutter-check/1",
        "tag": (result.get("summary_keys", {}).get("tag") or
                (os.path.basename(run_dir) if run_dir else None)),
        "verdict": status,
        "verdict_reason": reason,
        "STUTTER": status,
        # 真进战斗唯一判据：双方 cb2 ∈ BattleMainCB2 精确区 [0x080B4845,0x080B48A8)
        "battle_verdict": battle_verdict(result)[0],
        "battle_gate": result["battle_gate"],
        # 对手判定：battle gate 否决 + 双证据；no-battle 时 species=0 不判 FAIL
        # 缺 [OPPSPECIES] 时 species/opponent 均为 UNOBSERVED（不是 True）。
        "opponent_verdict": result["opponent"]["opponent_real"],
        "opponent_evidence": result["opponent"],
        "run_dir": run_dir,
        "missing_inputs": missing,
        "thresholds": cfg,
        "metrics": result["metrics"],
        "continuity": result["continuity"],
        "stutter_events": result["stutter_events"],
        "xfer_gaps_ms": result["xfer_gaps_ms"],
        "fps_details": result["fps_details"],
    }


# ------------------------------------------------------------------ self test
def self_test():
    """合成用例：精确 BattleMainCB2 窗口 + PASS/FAIL/UNOBSERVED + battle gate 否决。"""
    print("[self-test] synthetic evidence (BattleMainCB2=[0x080B4845,0x080B48A8))")
    ok = []

    def check(name, cond):
        ok.append(bool(cond))
        print("  [%s] %s" % ("PASS" if cond else "FAIL", name))

    def mk_srcs(summary, logcat, sio=None):
        return {"summary": [Src("SYNTH", [(i, t) for i, t in enumerate(summary.splitlines(), 1)])],
                "logcat": [Src("SYNTH", [(i, t) for i, t in enumerate(logcat.splitlines(), 1)])],
                "sio": ([Src("SYNTH", [(i, t) for i, t in enumerate(sio.splitlines(), 1)])]
                        if sio else []),
                "pc_stdout": [], "samples": [], "baseline": []}

    cfg = {"stable_sec": 20, "max_gap_ms": 33.34, "rtt_spike_ms": 100,
           "cmdguard_surge": 100, "empty_word_min": 5, "transition_grace_ms": 3000,
           "error_cb2": ["0816D8CD"], "baseline_fps": None, "frame_glob": None,
           "battle_cb2_range": ["0x080B4845", "0x080B48A8"], "rom_map": None}

    clean_sum = ("tag=CLEAN\nBATTLE=YES\nin_battle_frame=True\n"
                 "battle_window=[0x080B30C0,0x080BCA78)\n"
                 "in_battle_cb2_PC=080B4845 app_cb2=080B4845\nfps_pc=60.0\n")
    clean_log = "\n".join([
        "11-18 06:01:01.000 1 1 I mGBA : LINKUP_OK st=4 pc=2 lnkst=00000968",
        "11-18 06:01:01.100 1 1 I mGBA : PEEK st=00000845 cb2=080B4845",
        "11-18 06:01:21.000 1 1 I mGBA : XFER #1 me=0 idx=2 own=FFF8 peer=FFF8 have=1 to=0",
        "11-18 06:01:22.000 1 1 I mGBA : XFER #2 me=0 idx=3 own=FFF8 peer=FFF8 have=1 to=0",
        "11-18 06:01:23.000 1 1 I mGBA : XFER #3 me=0 idx=4 own=FFF8 peer=FFF8 have=1 to=0",
        "11-18 06:01:24.000 1 1 I mGBA : Link RTT avg=2000us max=3000us (last=2100us)",
        "11-18 06:01:09.982 1 1 I mGBA : [RHPLYR] cb2=080B4845 +0 lp1 ver=4003 tid=8A420D82 name=00FFCD08/00000000",
    ])
    r = analyze(mk_srcs(clean_sum, clean_log), cfg)
    st, _ = verdict(r, cfg)
    check("both ends in BattleMainCB2 -> BATTLE=PASS", battle_verdict(r)[0] == PASS)
    check("clean battle -> STUTTER=PASS", st == PASS)
    check("battle_stable_sec uses precise main-loop anchor",
          r["metrics"]["battle_stable_sec"] is not None and
          r["metrics"]["battle_stable_sec"] >= 20)
    check("trainer card real via [RHPLYR]", r["metrics"]["trainer_card_real"] == PASS)
    check("legacy logs (no OPPSPECIES) -> species UNOBSERVED",
          r["metrics"]["opponent_species_real"] == UNO and
          r["metrics"]["opponent_real"] == UNO)

    # 精确窗口：app 停在 CB2_HandleStartBattle / InitBattle / PrintErrorMessage 一律未进战斗
    for nonbattle_cb in ("080B376D", "080B310D", "0816D8CD"):
        nb_log = clean_log.replace("080B4845", nonbattle_cb)
        nb_sum = clean_sum.replace("app_cb2=080B4845", "app_cb2=" + nonbattle_cb)
        rr = analyze(mk_srcs(nb_sum, nb_log), cfg)
        check("app cb2=%s -> BATTLE=FAIL (not battle main)" % nonbattle_cb,
              battle_verdict(rr)[0] == FAIL and
              not rr["metrics"]["app_entered_battle_main"] and
              rr["metrics"]["battle_stable_sec"] is None)

    # 单端进战斗 + species=0 -> no-battle，species 不判 FAIL（ROOTHUNT 硬标准）
    single_log = clean_log.replace("080B4845", "080B376D")
    single_sum = clean_sum.replace("app_cb2=080B4845", "app_cb2=080B376D")
    single_log += "\n" + (
        "11-18 06:01:10.100 1 1 I mGBA : [OPPSPECIES] cb2=080B376D n=4 "
        "mons=0000,0000,0000,0000 enemyPartyCnt=0 recvBuf0=0000")
    rr = analyze(mk_srcs(single_sum, single_log), cfg)
    check("single-ended battle + species=0 -> opponent UNOBSERVED (NOT FAIL)",
          battle_verdict(rr)[0] == FAIL and
          rr["metrics"]["opponent_species_real"] == UNO and
          rr["metrics"]["opponent_real"] == UNO)

    # 双证据齐全 -> opponent PASS
    opp_log = clean_log + "\n" + (
        "11-18 06:01:10.100 1 1 I mGBA : [OPPSPECIES] cb2=080B310D n=4 "
        "mons[0..3]=0099,0000,0000,0000 enemyPartyCnt=1 enemySpecies0=0099 recvBuf0=00")
    r = analyze(mk_srcs(clean_sum, opp_log), cfg)
    check("RHPLYR + valid species -> opponent PASS", r["metrics"]["opponent_real"] == PASS)

    # species=0 / 0xFFFF / 0x58B(058B 哨兵，> 合法上限 0x58A) -> ??? -> opponent FAIL（即使 trainer 卡真实）
    for bad_species in ("0000", "FFFF", "058B"):
        bad_opp_log = clean_log + "\n" + (
            "11-18 06:01:10.100 1 1 I mGBA : [OPPSPECIES] cb2=080B310D n=4 "
            "mons[0..3]=%s,0000,0000,0000 enemyPartyCnt=1 enemySpecies0=%s recvBuf0=00" %
            (bad_species, bad_species))
        r = analyze(mk_srcs(clean_sum, bad_opp_log), cfg)
        check("species=%s(???) -> opponent FAIL" % bad_species,
              r["metrics"]["opponent_species_real"] == FAIL and
              r["metrics"]["opponent_real"] == FAIL)

    bad_sum = ("tag=BAD\nBATTLE=YES\nin_battle_frame=True\n"
               "battle_window=[0x080B30C0,0x080BCA78)\n"
               "in_battle_cb2_PC=080B4845 app_cb2=080B376D\nfps_pc=60.0\n")
    bad_log = "\n".join([
        "11-18 06:01:01.000 1 1 I mGBA : LINKUP_OK st=4 pc=2 lnkst=00000968",
        "11-18 06:01:01.100 1 1 I mGBA : PEEK st=00000845 cb2=080B376D",
        "11-18 06:01:03.600 1 1 I mGBA : LINKUP_OK st=4 pc=2 lnkst=00000868",
        "11-18 06:01:12.067 1 1 I mGBA : Link RTT avg=81685us max=315389us (last=51556us)",
        "11-18 06:01:12.098 1 1 I mGBA : GLINK res=1 rem=0 cmdguard=561 st=0868",
        "11-18 06:01:23.443 1 1 I mGBA : PEEK st=00000000 link[m=0 st=1 id=0 pc=0] cb2=0816D8CD",
        "11-18 06:01:09.982 1 1 I mGBA : [RHPLYR] cb2=080B310D +0 lp1 ver=4003 tid=8A420D82 name=00FFCD08/00000000",
    ])
    for _ in range(6):
        bad_log += "\n11-18 06:01:12.100 1 1 I mGBA : XFER #9 me=0 idx=9 own=0000 peer=DEAD have=0 to=2"
    r = analyze(mk_srcs(bad_sum, bad_log), cfg)
    st, _ = verdict(r, cfg)
    check("APPHUNT-FINAL-like app cb2=080B376D -> BATTLE=FAIL (no battle main)",
          battle_verdict(r)[0] == FAIL)
    check("link drop + RTT 315ms -> STUTTER=FAIL", st == FAIL)
    check("rtt_peak captured 315.389", abs(r["metrics"]["rtt_peak_ms"] - 315.389) < 0.01)
    check("link_drop_count >= 1", r["metrics"]["link_drop_count"] >= 1)
    check("comm cb2 captured", "0816d8cd" in r["metrics"]["comm_error_cb2_values"])
    check("broken link: trainer real but species absent -> opponent UNOBSERVED",
          r["metrics"]["trainer_card_real"] == PASS and
          r["metrics"]["opponent_species_real"] == UNO and
          r["metrics"]["opponent_real"] == UNO)

    empty = {"summary": [], "logcat": [], "sio": [], "pc_stdout": [], "samples": [], "baseline": []}
    r = analyze(empty, cfg)
    st, _ = verdict(r, cfg)
    check("missing logs -> UNOBSERVED", st == UNO)

    # Q7 §2.4: 退出码纳入 OPPONENT，FAIL 从 2 统一为 1。
    check("overall: STUTTER=PASS + OPPONENT=PASS -> PASS",
          overall_verdict(PASS, PASS) == PASS)
    check("overall: STUTTER=PASS + OPPONENT=FAIL -> FAIL (假 PASS 已堵)",
          overall_verdict(PASS, FAIL) == FAIL)
    check("overall: STUTTER=PASS + OPPONENT=UNOBSERVED -> UNOBSERVED",
          overall_verdict(PASS, UNO) == UNO)
    check("overall: STUTTER=FAIL dominates any opponent",
          overall_verdict(FAIL, PASS) == FAIL and overall_verdict(FAIL, UNO) == FAIL)
    check("overall: STUTTER=UNOBSERVED + OPPONENT=FAIL -> FAIL",
          overall_verdict(UNO, FAIL) == FAIL)

    print("[self-test] %d/%d passed" % (sum(ok), len(ok)))
    return 0 if all(ok) else 1


# ------------------------------------------------------------------ main
def main(argv=None):
    ap = argparse.ArgumentParser(description="FRAMEGUARD frame-stutter quantifier")
    ap.add_argument("--run-dir", help="evidence dir .zcode-tmp/cloud2p/<tag>")
    ap.add_argument("--summary", nargs="+", help="summary.txt path(s)")
    ap.add_argument("--logcat", nargs="+", help="app_logcat*.log path(s)")
    ap.add_argument("--sio", nargs="+", help="mgba_sio.log path(s)")
    ap.add_argument("--pc-stdout", nargs="+", help="pc_stdout.log path(s)")
    ap.add_argument("--samples", nargs="+", help="samples.log path(s)")
    ap.add_argument("--baseline", nargs="+", help="baseline_1x.txt path(s)")
    ap.add_argument("--frame-glob", help="frame screenshot glob, e.g. 'frame*_big.png'")
    ap.add_argument("--stable-sec", type=float, default=20.0)
    ap.add_argument("--max-gap-ms", type=float, default=33.34)
    ap.add_argument("--rtt-spike-ms", type=float, default=100.0)
    ap.add_argument("--cmdguard-surge", type=int, default=100)
    ap.add_argument("--empty-word-min", type=int, default=5)
    ap.add_argument("--transition-grace-ms", type=float, default=3000.0)
    ap.add_argument("--error-cb2", nargs="+", default=["0816D8CD"],
                    help="comm-error cb2 signature(s), hex")
    ap.add_argument("--battle-cb2-range", nargs=2, metavar=("LO", "HI"),
                    help="precise BattleMainCB2 cb2 range (default 0x080B4845 0x080B48A8)")
    ap.add_argument("--rom-map", help="rom.map for symbol cross-check")
    ap.add_argument("--baseline-fps", type=float, default=None)
    ap.add_argument("--json", help="also save JSON to file")
    ap.add_argument("--self-test", action="store_true")
    args = ap.parse_args(argv)

    if args.self_test:
        return self_test()

    cfg = {"stable_sec": args.stable_sec, "max_gap_ms": args.max_gap_ms,
           "rtt_spike_ms": args.rtt_spike_ms, "cmdguard_surge": args.cmdguard_surge,
           "empty_word_min": args.empty_word_min,
           "transition_grace_ms": args.transition_grace_ms,
           "error_cb2": args.error_cb2, "baseline_fps": args.baseline_fps,
           "frame_glob": args.frame_glob,
           "battle_cb2_range": args.battle_cb2_range, "rom_map": args.rom_map}
    explicit = {"summary": args.summary, "logcat": args.logcat, "sio": args.sio,
                "pc_stdout": args.pc_stdout, "samples": args.samples,
                "baseline": args.baseline}
    srcs, missing = discover(args.run_dir, explicit)
    result = analyze(srcs, cfg, args.run_dir)
    status, reason = verdict(result, cfg)
    if not result["summary_keys"].get("tag") and args.run_dir:
        result["summary_keys"]["tag"] = os.path.basename(args.run_dir)

    opponent = result["opponent"]["opponent_real"]
    overall = overall_verdict(status, opponent)
    print(render(result, status, reason, cfg, args.run_dir))
    print("STUTTER=%s" % status)
    print("BATTLE=%s" % battle_verdict(result)[0])
    print("OPPONENT=%s" % opponent)
    print("OVERALL=%s" % overall)
    payload = build_json(result, status, reason, cfg, args.run_dir, missing)
    # 与进程退出码同源的总判，供机器可读消费（与顶层 STUTTER / opponent_verdict 并存）
    payload["overall_verdict"] = overall
    # 先落盘再打印超长 JSON 行，避免下游 head/Select-Object 提前关管道导致文件未写
    if args.json:
        try:
            with open(args.json, "w", encoding="utf-8") as fh:
                json.dump(payload, fh, ensure_ascii=False, indent=2, sort_keys=True)
        except OSError as exc:
            print("WARN: cannot write json: %s" % exc, file=sys.stderr)
    print("JSON: " + json.dumps(payload, ensure_ascii=False, sort_keys=True))
    # 统一全家约定：FAIL=1、UNOBSERVED=3、PASS=0（见头部"退出码"段）。
    return 0 if overall == PASS else (1 if overall == FAIL else 3)


if __name__ == "__main__":
    sys.exit(main())
