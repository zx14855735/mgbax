#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""quick_diag -- 单条命令把一个 E2E run 目录解析成精简判据表 + 机器可读 JSON。

目标：替代"手工翻 app_link_startup.log / mgba_sio.log / summary.txt 再多工具串跑"，
每轮验证一次性给出下列判据（缺证据时如实给 0 / null / UNOBSERVED，绝不伪造）：

  * [RHSIDECAR] hits                      双端对称 sidecar 解码命中数
  * [RHVIS] 早窗(080B376D) pcSp/epSp/cnt   HandleStartBattle 早窗口的物种证据
  * [RHVIS] 晚窗(BattleMainCB2) srcSp/epSp 主循环晚窗口的物种证据
  * [OPPSPECIES] mons/enemyPartyCnt/btlType 去重取值集合
  * FRAMEGUARD 的 BATTLE / STUTTER / OPPONENT 三个 verdict（直接复用其解析逻辑）
  * BATTLE cb2 双端取值 + LINK_RESET 次数 + PC fps + lgc

日志解析正则复用 tools/frame_stutter_check.py（FRAMEGUARD）与
tools/cloud2p_evidence.py 的既有口径；FRAMEGUARD verdict 直接 import 调用，
保证与正式检测器完全一致，而不是另写一套近似判据。

用法：
    python tools/quick_diag.py <run_dir> [--json-out PATH] [--no-table]

输出：
    <判据表(默认开)>            人读的精简表格
    摘要：<一行中文摘要>         恰好一行中文概括
    JSON: {...}                 单行机器可读 JSON（--json-out 另存美化版）
"""

import argparse
import glob
import json
import os
import re
import sys

# 让脚本无论从仓库根还是别处调用，都能 import 到同目录的 FRAMEGUARD。
_HERE = os.path.dirname(os.path.abspath(__file__))
if _HERE not in sys.path:
    sys.path.insert(0, _HERE)

try:
    import frame_stutter_check as fsc
except ImportError as exc:  # pragma: no cover - 环境损坏时给出明确错误
    sys.stderr.write("quick_diag: cannot import frame_stutter_check: %s\n" % exc)
    raise

try:
    import quick_compare_frames as qcf
except ImportError as exc:  # pragma: no cover
    sys.stderr.write("quick_diag: cannot import quick_compare_frames: %s\n" % exc)
    qcf = None

try:
    import battle_visual_gate as bvg
except ImportError as exc:  # pragma: no cover
    sys.stderr.write("quick_diag: cannot import battle_visual_gate: %s\n" % exc)
    bvg = None

# ------------------------------------------------------------------ 常量 / 正则
from gba_addrs import (             # 统一地址宏，保留本地别名以零改变引用
    CB2_HANDLE_START_BATTLE as EARLY_CB2,   # 早窗 = CB2_HandleStartBattle（原值 0x080B376D）
    BATTLE_CB2_LO as LATE_LO,               # 晚窗下界 = BattleMainCB2（原值 0x080B4845）
    BATTLE_CB2_HI as LATE_HI,               # 晚窗上界（原值 0x080B48A8）
)

# [RHSIDECAR] hi=%04X idx=%u byte=%02X hits=%u sp0=%04X
RHSIDECAR_RE = re.compile(
    r"\[RHSIDECAR\]\s+hi=([0-9A-Fa-f]{4})\s+idx=(\d+)\s+"
    r"byte=([0-9A-Fa-f]{2})\s+hits=(\d+)\s+sp0=([0-9A-Fa-f]{4})")

# [RHVIS] cb2=%08X bIdx=%u,%u srcSp=,,,, pcSp=,,,, hits=%u sp0=%04X
#         epSp=,, epLv=%u,%u cnt=%u
RHVIS_RE = re.compile(
    r"\[RHVIS\]\s+cb2=([0-9A-Fa-f]{8})\s+"
    r"bIdx=(\d+),(\d+)\s+"
    r"srcSp=([0-9A-Fa-f]{4}),([0-9A-Fa-f]{4}),([0-9A-Fa-f]{4})\s+"
    r"pcSp=([0-9A-Fa-f]{4}),([0-9A-Fa-f]{4}),([0-9A-Fa-f]{4})\s+"
    r"hits=(\d+)\s+sp0=([0-9A-Fa-f]{4})\s+"
    r"epSp=([0-9A-Fa-f]{4}),([0-9A-Fa-f]{4})\s+"
    r"epLv=(\d+),(\d+)\s+cnt=(\d+)")

# [OPPSPECIES] 字段：沿用 FRAMEGUARD 的 "直到空白/]" 取值口径。
OPP_MONS_RE = re.compile(r"\bmons(?:\[0\.\.3\])?=([^\s\]]+)")
OPP_CNT_RE = re.compile(r"\benemyPartyCnt=([^\s\]]+)")
OPP_BTLTYPE_RE = re.compile(r"\bbtlType=([^\s\]]+)")
LGC_RE = re.compile(r"\blgc=([-+]?\d+)")

# avd_driver.log 里的图例行，不是真正的 LINK_RESET 事件，必须排除。
LINK_RESET_LEGEND_RE = re.compile(r"ST/LINK_RESET/CloseLink/GLINK")
LINK_RESET_RE = re.compile(r"\bLINK_RESET\b")


def _hx(v):
    """统一成大写 4/8 位 hex 字符串，便于比较。"""
    try:
        return ("%04X" % int(v, 16))
    except (ValueError, TypeError):
        return str(v)


def _all_sources(srcs):
    """FRAMEGUARD discover() 已按文件去重（logcat 子集互丢），遍历全部类型。"""
    for kind in ("logcat", "sio", "pc_stdout", "samples", "summary", "baseline"):
        for s in srcs.get(kind, []):
            yield s


def parse_rhsidecar(srcs):
    hits_max = 0
    lines = 0
    first = None
    for s in _all_sources(srcs):
        for lineno, text in s.lines:
            m = RHSIDECAR_RE.search(text)
            if not m:
                continue
            lines += 1
            h = int(m.group(4))
            hits_max = max(hits_max, h)
            if first is None:
                first = {"file": os.path.basename(s.name), "line": lineno,
                         "text": text.strip()[:220]}
    return {"hits": hits_max, "lines": lines, "first": first}


def parse_rhvis(srcs):
    early = []
    late = []
    total = 0
    for s in _all_sources(srcs):
        for lineno, text in s.lines:
            m = RHVIS_RE.search(text)
            if not m:
                continue
            total += 1
            cb2 = int(m.group(1), 16)
            rec = {
                "cb2": "%08X" % cb2,
                "bIdx": [int(m.group(2)), int(m.group(3))],
                "srcSp": [_hx(m.group(4)), _hx(m.group(5)), _hx(m.group(6))],
                "pcSp": [_hx(m.group(7)), _hx(m.group(8)), _hx(m.group(9))],
                "hits": int(m.group(10)),
                "sp0": _hx(m.group(11)),
                "epSp": [_hx(m.group(12)), _hx(m.group(13))],
                "epLv": [int(m.group(14)), int(m.group(15))],
                "cnt": int(m.group(16)),
                "ref": {"file": os.path.basename(s.name), "line": lineno},
            }
            if cb2 == EARLY_CB2:
                early.append(rec)
            elif LATE_LO <= cb2 < LATE_HI:
                late.append(rec)

    def _pick(rows, keys):
        if not rows:
            return {"found": False}
        last = rows[-1]
        out = {"found": True, "count": len(rows), "cb2": last["cb2"],
               "ref": last["ref"]}
        for k in keys:
            out[k] = last[k]
        return out

    return {
        "lines": total,
        "early": dict(_pick(early, ["pcSp", "epSp", "cnt"]), cb2_window="%08X" % EARLY_CB2),
        "late": dict(_pick(late, ["srcSp", "epSp"]),
                     cb2_window=["%08X" % LATE_LO, "%08X" % LATE_HI]),
    }


def parse_oppspecies(srcs):
    mons, cnts, btls = set(), set(), set()
    lines = 0
    for s in _all_sources(srcs):
        for lineno, text in s.lines:
            if "[OPPSPECIES]" not in text:
                continue
            lines += 1
            m = OPP_MONS_RE.search(text)
            if m:
                mons.add(m.group(1))
            m = OPP_CNT_RE.search(text)
            if m:
                cnts.add(m.group(1))
            m = OPP_BTLTYPE_RE.search(text)
            if m:
                btls.add(m.group(1))
    return {"lines": lines,
            "mons": sorted(mons), "enemyPartyCnt": sorted(cnts),
            "btlType": sorted(btls)}


def parse_link_reset(srcs):
    """真 LINK_RESET 事件次数（跨去重后的日志），排除驱动图例行。

    summary.txt 的 app_link_timeline_tail 会原样引用时间线里的 LINK_RESET，
    属于同一事件的副本，不计入，避免重复计数。
    """
    events = []
    kinds = ("logcat", "sio", "pc_stdout", "samples")
    for s in (s for k in kinds for s in srcs.get(k, [])):
        for lineno, text in s.lines:
            if not LINK_RESET_RE.search(text):
                continue
            if LINK_RESET_LEGEND_RE.search(text):
                continue
            events.append({"file": os.path.basename(s.name), "line": lineno,
                           "text": text.strip()[:220]})
    return {"count": len(events), "events": events[:8]}


def parse_lgc(srcs):
    vals = []
    for s in srcs.get("summary", []):
        for lineno, text in s.lines:
            if text.strip().startswith("multi_") or "multi me=" in text:
                m = LGC_RE.search(text)
                if m:
                    vals.append(int(m.group(1)))
    return vals[0] if vals else None


def parse_opponent_visual(run_dir, compare_run, sk):
    """OPPONENT_VISUAL: 左上对手框差异% + 是否非问号（跨 run 像素变化推断）。

    复用 quick_compare_frames.compare(..., box_specs=["lt"]) 的真实计算结果；
    未提供 --compare-with 时如实返回 observed=False，绝不伪造差异%。
    "非问号"是启发式推断（0%=>问号占位符，>0%=>真精灵），不是 OCR。
    """
    ov = {
        "compare_with": os.path.abspath(compare_run) if compare_run else None,
        "observed": False,
        "diff_percent": None,
        "diff_pixels": None,
        "total_pixels": None,
        "opponent_box_changed": None,
        "non_question_mark": None,
        "summary_opponent_visual_real": sk.get("opponent_visual_real"),
        "basis": "cross-run lt (top-left opponent box) pixel change heuristic (not OCR)",
    }
    if not compare_run:
        ov["note"] = "未提供 --compare-with <另一run>，无法计算左上对手框差异%"
        return ov
    if qcf is None:
        ov["note"] = "quick_compare_frames 不可用"
        return ov
    try:
        cmp = qcf.compare(run_dir, compare_run, box_specs=["lt"])
    except Exception as exc:  # noqa: BLE001
        ov["note"] = "compare failed: %s" % exc
        return ov
    if cmp.get("error"):
        ov["note"] = "compare error: %s" % cmp["error"]
        return ov
    ob = cmp.get("opponent_box") or {}
    ov["observed"] = True
    ov["diff_percent"] = ob.get("diff_percent")
    ov["diff_pixels"] = ob.get("diff_pixels")
    ov["total_pixels"] = ob.get("total_pixels")
    ov["opponent_box_changed"] = cmp.get("opponent_box_changed")
    ov["non_question_mark"] = ob.get("non_question_mark")
    ov["shot_a"] = cmp.get("shot_a")
    ov["shot_b"] = cmp.get("shot_b")
    return ov


def opponent_visual_line(ov):
    """一行明确输出：左上对手框差异% + 是否非问号。"""
    s_real = ov.get("summary_opponent_visual_real") or "无"
    if not ov.get("observed"):
        return ("OPPONENT_VISUAL: 左上对手框差异%%=UNOBSERVED (%s)；"
                "非问号=UNOBSERVED；summary opponent_visual_real=%s" %
                (ov.get("note") or "无对比run", s_real))
    return ("OPPONENT_VISUAL: 左上对手框差异%%=%s%% (%s/%s)；"
            "非问号=%s；opponent_box_changed=%s；"
            "summary opponent_visual_real=%s [跨run差异推断，非OCR；shot %s vs %s]" %
            (ov["diff_percent"], ov["diff_pixels"], ov["total_pixels"],
             "是" if ov.get("non_question_mark") else "否",
             ov.get("opponent_box_changed"), s_real,
             ov.get("shot_a"), ov.get("shot_b")))


def parse_battle_cb2(srcs, metrics, sk):
    """BATTLE cb2 双端：FRAMEGUARD 观测值 + summary 的运行期锚点。"""
    return {
        "app_values": metrics.get("app_cb2_values", []),
        "pc_values": metrics.get("pc_cb2_values", []),
        "app_entered_battle_main": metrics.get("app_entered_battle_main"),
        "pc_entered_battle_main": metrics.get("pc_entered_battle_main"),
        "summary_app_cb2": sk.get("app_cb2"),
        "summary_in_battle_cb2_PC": sk.get("in_battle_cb2_PC"),
    }


def compact_table(d):
    fg = d["frameguard"]
    rh = d["rhvis"]
    op = d["oppspecies"]
    bc = d["battle_cb2"]

    def _short(pick, keys):
        if not pick.get("found"):
            return "-"
        return " ".join("%s=%s" % (k, ",".join(pick[k]) if isinstance(pick[k], list)
                                   else pick[k]) for k in keys)

    rows = [
        ("tag", d["tag"]),
        ("RHSIDECAR", "hits=%d (lines=%d)" % (d["rhsidecar"]["hits"], d["rhsidecar"]["lines"])),
        ("RHVIS 早窗", _short(rh["early"], ["pcSp", "epSp", "cnt"])),
        ("RHVIS 晚窗", _short(rh["late"], ["srcSp", "epSp"])),
        ("OPPSPECIES", "mons=%s enemyPartyCnt=%s btlType=%s" %
         (op["mons"] or "-", op["enemyPartyCnt"] or "-", op["btlType"] or "-")),
        ("FRAMEGUARD", "BATTLE=%s STUTTER=%s OPPONENT=%s" %
         (fg["BATTLE"], fg["STUTTER"], fg["OPPONENT"])),
        ("VISUAL_GATE", "%s (HP_BAR=%s TEXTBOX=%s LIVENESS=%s)" % tuple(
            [d.get("visual_gate", {}).get("verdict", "UNOBSERVED")] +
            [d.get("visual_gate", {}).get("criteria", {}).get(k, {}).get("status",
             "UNOBSERVED") for k in ("HP_BAR", "TEXTBOX", "LIVENESS")])),
        ("BATTLE cb2", "app=%s pc=%s" %
         (",".join(bc["app_values"][:4]) or "-", ",".join(bc["pc_values"][:4]) or "-")),
        ("LINK_RESET", str(d["link_reset"]["count"])),
        ("PC fps", "summary=%s battle=%s(min=%s max=%s)" %
         (d["pc_fps"]["summary_fps_pc"], d["pc_fps"]["battle_fps"],
          d["pc_fps"]["fps_min"], d["pc_fps"]["fps_max"])),
        ("lgc", str(d["lgc"])),
    ]
    width = max(len(k) for k, _ in rows)
    return "\n".join("  %-*s : %s" % (width, k, v) for k, v in rows)


def chinese_summary(d):
    fg = d["frameguard"]
    rh = d["rhvis"]
    op = d["oppspecies"]
    e = rh["early"]
    l = rh["late"]

    def _val(pick, key):
        if not pick.get("found"):
            return "未观测"
        v = pick[key]
        return ",".join(v) if isinstance(v, list) else str(v)

    vg = d.get("visual_gate") or {}
    vg_verdict = vg.get("verdict", "UNOBSERVED")
    # 视觉硬门槛是成功的必要条件：BATTLE/OPPONENT=PASS 但画面卡死仍不算成功。
    overall = "成功" if vg_verdict == "PASS" else "未达成(VISUAL_GATE!=PASS)"

    return (
        "摘要：%s RHSIDECAR hits=%d；RHVIS早窗(pcSp=%s epSp=%s cnt=%s)、"
        "晚窗(srcSp=%s epSp=%s)；OPPSPECIES mons=%s/cnt=%s/btlType=%s；"
        "FRAMEGUARD BATTLE=%s STUTTER=%s OPPONENT=%s；VISUAL_GATE=%s；"
        "BATTLE cb2 双端 %s/%s；LINK_RESET=%d 次；PC fps=%s；lgc=%s；总判=%s。"
    ) % (
        d["tag"], d["rhsidecar"]["hits"],
        _val(e, "pcSp"), _val(e, "epSp"), _val(e, "cnt"),
        _val(l, "srcSp"), _val(l, "epSp"),
        op["mons"] or "无", op["enemyPartyCnt"] or "无", op["btlType"] or "无",
        fg["BATTLE"], fg["STUTTER"], fg["OPPONENT"], vg_verdict,
        ",".join(d["battle_cb2"]["app_values"][:2]) or "无",
        ",".join(d["battle_cb2"]["pc_values"][:2]) or "无",
        d["link_reset"]["count"], d["pc_fps"]["summary_fps_pc"], d["lgc"], overall,
    )


def diagnose(run_dir, compare_with=None):
    """核心：返回完整判据 dict。"""
    srcs, missing = fsc.discover(run_dir, {})
    sk = fsc.parse_summary(srcs.get("summary", []))

    cfg = {"stable_sec": 20.0, "max_gap_ms": 33.34, "rtt_spike_ms": 100.0,
           "cmdguard_surge": 100, "empty_word_min": 5,
           "transition_grace_ms": 3000.0, "error_cb2": ["0816D8CD"],
           "baseline_fps": None, "frame_glob": None,
           "battle_cb2_range": None, "rom_map": None}
    result = fsc.analyze(srcs, cfg, run_dir)
    stutter, stutter_reason = fsc.verdict(result, cfg)
    battle, battle_reason = fsc.battle_verdict(result)
    opponent = result["opponent"]["opponent_real"]

    m = result["metrics"]
    tag = sk.get("tag") or os.path.basename(os.path.normpath(run_dir))
    return {
        "schema": "quick-diag/1",
        "tag": tag,
        "run_dir": os.path.abspath(run_dir),
        "rhsidecar": parse_rhsidecar(srcs),
        "rhvis": parse_rhvis(srcs),
        "oppspecies": parse_oppspecies(srcs),
        "frameguard": {
            "BATTLE": battle, "STUTTER": stutter, "OPPONENT": opponent,
            "battle_reason": battle_reason, "stutter_reason": stutter_reason,
        },
        "battle_cb2": parse_battle_cb2(srcs, m, sk),
        "opponent_visual": parse_opponent_visual(run_dir, compare_with, sk),
        "visual_gate": bvg.gate(run_dir) if bvg else {
            "verdict": "UNOBSERVED", "criteria": {}, "error": "battle_visual_gate unavailable"},
        "link_reset": parse_link_reset(srcs),
        "pc_fps": {
            "summary_fps_pc": fsc.as_float(sk.get("fps_pc")),
            "baseline_fps": m.get("baseline_fps"),
            "battle_fps": m.get("battle_fps"),
            "fps_min": m.get("fps_min"), "fps_max": m.get("fps_max"),
        },
        "lgc": parse_lgc(srcs),
        "missing_inputs": missing,
    }


def main(argv=None):
    ap = argparse.ArgumentParser(description="quick diag: one run dir -> compact criteria + JSON")
    ap.add_argument("run_dir", help="evidence dir, e.g. .zcode-tmp/cloud2p/<tag>")
    ap.add_argument("--compare-with", metavar="RUN_DIR",
                    help="另一条 run 目录：用于计算左上对手框差异% / 是否非问号"
                         "(调用 quick_compare_frames 的 lt 框判定)")
    ap.add_argument("--json-out", help="also write pretty JSON to this path")
    ap.add_argument("--no-table", action="store_true", help="suppress the human criteria table")
    args = ap.parse_args(argv)

    run_dir = args.run_dir
    if not os.path.isdir(run_dir):
        sys.stderr.write("quick_diag: not a directory: %s\n" % run_dir)
        return 2

    d = diagnose(run_dir, args.compare_with)
    if not args.no_table:
        print(compact_table(d))
    print(opponent_visual_line(d["opponent_visual"]))
    print(chinese_summary(d))
    if args.json_out:
        try:
            with open(args.json_out, "w", encoding="utf-8") as fh:
                json.dump(d, fh, ensure_ascii=False, indent=2, sort_keys=True)
        except OSError as exc:
            sys.stderr.write("quick_diag: cannot write json: %s\n" % exc)
    print("JSON: " + json.dumps(d, ensure_ascii=False, sort_keys=True))
    return 0


if __name__ == "__main__":
    sys.exit(main())
