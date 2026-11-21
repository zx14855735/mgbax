#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""battle_visual_gate -- 战斗画面的**视觉硬门槛**（数据层 PASS 不算数）。

背景：BATTLE/OPPONENT=PASS 曾全是数据层假阳性——画面实际是
"名字真、HP 条空、对话框空 = 卡死"。本工具直接看 PC 战斗截图像素，
给出与数据层无关的独立判据，缺证据一律 UNOBSERVED，绝不缺省当 PASS。

三项硬判据（坐标按 672x579 基准截图缩放到实际尺寸）：
  HP_BAR    : 左上对手框 HP 条区域 x≈220..425, y≈287..307（已避开 x163..215 的
              "HP" 字样）。强绿像素 G>120 且 G>R+40 且 G>B+40 的占比 ≥30%，
              且连续绿色列宽 ≥30% 条宽 → PASS。空/黑条 → FAIL。
              这是最高优先级判据。
  TEXTBOX   : 底部对话框 x≈60..600, y≈480..579。先要有成片的浅色框底
              （连续 ≥10 行、每行 ≥60% 浅色像素 R/G/B>150），再在该框底内
              检出深色文字笔画（R/G/B<80 占比 >0.5%，且 ≥多列的竖向笔画）→
              PASS；纯场景/空框 → FAIL。
  LIVENESS  : battle_opponent_<tag>_1/2/3.png 三帧关键区（游戏画面）差异 >0
              （近全黑过渡帧跳过）→ PASS；三帧全同 = 冻结 → FAIL；
              帧数不足 → UNOBSERVED。

总判优先级 FAIL > UNOBSERVED > PASS。

用法：
    python tools/battle_visual_gate.py <run_dir> [--json-out PATH]
"""

import argparse
import glob
import json
import os
import sys

_HERE = os.path.dirname(os.path.abspath(__file__))
if _HERE not in sys.path:
    sys.path.insert(0, _HERE)

from quick_compare_frames import find_pc_shot, _load_rgb  # noqa: E402

BASE_W, BASE_H = 672, 579
STATUS_PASS, STATUS_FAIL, STATUS_UNKNOWN = "PASS", "FAIL", "UNOBSERVED"
RANK = {STATUS_PASS: 0, STATUS_UNKNOWN: 1, STATUS_FAIL: 2}

HP_BOX = (220, 287, 425, 307)      # 对手 HP 条（不含 x163..215 的 "HP" 字样）
TEXTBOX_BOX = (60, 480, 600, 579)  # 底部对话框
KEY_BOX = (50, 150, 672, 579)      # LIVENESS 关键区：整块游戏画面（排除窗口标题/菜单）

HP_GREEN_RATIO = 0.30
HP_GREEN_RUN = 0.30
TB_LIGHT_ROW = 0.60
TB_MIN_LIGHT_ROWS = 10
TB_DARK_RATIO = 0.005


def scale_box(box, w, h):
    l, t, r, b = box
    return (int(round(l * w / BASE_W)), int(round(t * h / BASE_H)),
            int(round(r * w / BASE_W)), int(round(b * h / BASE_H)))


def is_green(R, G, B):
    return G > 120 and G > R + 40 and G > B + 40


def is_light(R, G, B):
    return R > 150 and G > 150 and B > 150


def is_dark(R, G, B):
    return R < 80 and G < 80 and B < 80


def _status_fail(detail, **extra):
    out = {"status": STATUS_FAIL, "detail": detail}
    out.update(extra)
    return out


def _status_unknown(detail, **extra):
    out = {"status": STATUS_UNKNOWN, "detail": detail}
    out.update(extra)
    return out


def check_hp_bar(px, w, h):
    box = scale_box(HP_BOX, w, h)
    l, t, r, b = box
    if r <= l or b <= t:
        return _status_unknown("HP_BAR box outside image", box=list(box))
    col_has_green = [0] * (r - l)
    green = 0
    for y in range(t, b):
        for x in range(l, r):
            R, G, B = px[x, y]
            if is_green(R, G, B):
                green += 1
                col_has_green[x - l] = 1
    total = (r - l) * (b - t)
    ratio = green / float(total) if total else 0.0
    run = best = 0
    for flag in col_has_green:
        run = run + 1 if flag else 0
        best = max(best, run)
    run_ratio = best / float(r - l) if r > l else 0.0
    out = {
        "box": list(box), "green_pixels": green, "total_pixels": total,
        "green_ratio": round(ratio, 5), "contiguous_green_width": best,
        "contiguous_green_ratio": round(run_ratio, 5),
        "required_green_ratio": HP_GREEN_RATIO,
        "required_run_ratio": HP_GREEN_RUN,
    }
    if ratio >= HP_GREEN_RATIO and run_ratio >= HP_GREEN_RUN:
        out["status"] = STATUS_PASS
        out["detail"] = ("green %s%% contiguous %s%% of bar width (>= %s%%)" %
                         (round(ratio * 100, 2), round(run_ratio * 100, 2),
                          int(HP_GREEN_RATIO * 100)))
    else:
        out["status"] = STATUS_FAIL
        out["detail"] = ("HP bar empty/frozen: green %s%% (need >= %s%%), "
                         "contiguous %s%% (need >= %s%%)" %
                         (round(ratio * 100, 2), int(HP_GREEN_RATIO * 100),
                          round(run_ratio * 100, 2), int(HP_GREEN_RUN * 100)))
    return out


def check_textbox(px, w, h):
    box = scale_box(TEXTBOX_BOX, w, h)
    l, t, r, b = box
    width = r - l
    if width <= 0 or b <= t:
        return _status_unknown("TEXTBOX box outside image", box=list(box))

    # 1) 找连续浅色框底：逐行统计浅色占比，取最长连续行段。
    rows = []
    for y in range(t, b):
        n = 0
        for x in range(l, r):
            R, G, B = px[x, y]
            if is_light(R, G, B):
                n += 1
        rows.append(n / float(width))
    best_run = cur = 0
    best_end = -1
    for i, frac in enumerate(rows):
        if frac >= TB_LIGHT_ROW:
            cur += 1
            if cur > best_run:
                best_run, best_end = cur, i
        else:
            cur = 0
    y0 = t + best_end - best_run + 1 if best_run else None
    y1 = t + best_end + 1 if best_run else None

    out = {
        "box": list(box), "light_band_y": [y0, y1],
        "light_band_rows": best_run,
        "required_light_rows": TB_MIN_LIGHT_ROWS,
        "required_row_light_ratio": TB_LIGHT_ROW,
    }
    if best_run < TB_MIN_LIGHT_ROWS:
        out["status"] = STATUS_FAIL
        out["detail"] = ("no light textbox frame: longest light band=%d rows "
                         "(need >= %d); bottom is scene/empty" %
                         (best_run, TB_MIN_LIGHT_ROWS))
        return out

    # 2) 框底内找深色文字笔画：占比 + 多列连通域。
    dark = 0
    col_dark = [0] * width
    for y in range(y0, y1):
        for x in range(l, r):
            R, G, B = px[x, y]
            if is_dark(R, G, B):
                dark += 1
                col_dark[x - l] += 1
    area = width * best_run
    dark_ratio = dark / float(area) if area else 0.0
    text_cols = sum(1 for n in col_dark if n >= 2)
    out["dark_pixels"] = dark
    out["dark_ratio"] = round(dark_ratio, 5)
    out["text_columns"] = text_cols
    out["required_dark_ratio"] = TB_DARK_RATIO
    if dark_ratio > TB_DARK_RATIO and text_cols >= 8:
        out["status"] = STATUS_PASS
        out["detail"] = ("light frame %d rows + dark text %s%% across %d columns" %
                         (best_run, round(dark_ratio * 100, 3), text_cols))
    else:
        out["status"] = STATUS_FAIL
        out["detail"] = ("textbox frame present but no text strokes: dark %s%% "
                         "across %d columns" % (round(dark_ratio * 100, 3), text_cols))
    return out


def _frame_paths(run_dir):
    pats = ["battle_opponent_*_[123].png", "battle_opponent_*.png"]
    found = []
    for pat in pats:
        for p in glob.glob(os.path.join(run_dir, pat)):
            name = os.path.basename(p)
            if name.startswith("battle_opponent_pc_"):
                continue  # PC 截图不是连续帧
            if name not in [os.path.basename(x) for x in found]:
                found.append(p)
    return sorted(found)


def check_liveness(run_dir):
    frames = _frame_paths(run_dir)
    out = {"frames": [os.path.basename(p) for p in frames]}
    if len(frames) < 2:
        out["status"] = STATUS_UNKNOWN
        out["detail"] = "need >=2 battle_opponent_* frames, got %d" % len(frames)
        return out
    loaded = []
    try:
        for p in frames[:3]:
            w, h, rgb = _load_rgb(p)
            loaded.append((p, w, h, rgb))
    except (OSError, ValueError) as exc:
        out["status"] = STATUS_UNKNOWN
        out["detail"] = "frame decode failed: %s" % exc
        return out
    if any((w, h) != (loaded[0][1], loaded[0][2]) for _, w, h, _ in loaded):
        out["status"] = STATUS_UNKNOWN
        out["detail"] = "frame sizes mismatch"
        return out
    w, h = loaded[0][1], loaded[0][2]
    kl, kt, kr, kb = scale_box(KEY_BOX, w, h)
    stride = w * 3

    def region_diff(a, b):
        n = 0
        for y in range(kt, kb):
            base = y * stride
            ia = base + kl * 3
            ib = base + kr * 3
            for i in range(ia, ib, 3):
                if a[i] != b[i] or a[i + 1] != b[i + 1] or a[i + 2] != b[i + 2]:
                    n += 1
        return n

    def is_transition_black(rgb):
        dark_count = 0
        total = 0
        for y in range(kt, kb):
            base = y * stride
            for x in range(kl, kr):
                idx = base + x * 3
                R, G, B = rgb[idx], rgb[idx + 1], rgb[idx + 2]
                dark_count += 1 if is_dark(R, G, B) else 0
                total += 1
        return bool(total) and dark_count / float(total) > 0.90

    black_flags = [is_transition_black(item[3]) for item in loaded]
    skipped_black = 0
    diffs = []
    for i in range(len(loaded) - 1):
        fa, fb = loaded[i], loaded[i + 1]
        # 过渡黑屏帧：配对中任一帧关键区近全黑则跳过，不算冻结也不算变化。
        if black_flags[i] or black_flags[i + 1]:
            skipped_black += 1
            continue
        diffs.append(region_diff(fa[3], fb[3]))
    out["pair_diffs"] = diffs
    out["black_frame_flags"] = black_flags
    out["skipped_black_frames"] = skipped_black
    out["key_box"] = [kl, kt, kr, kb]
    if not diffs:
        out["status"] = STATUS_UNKNOWN
        out["detail"] = "all frame pairs skipped as transition black screens"
    elif any(d > 0 for d in diffs):
        out["status"] = STATUS_PASS
        out["detail"] = "frames differ in key region (diff pixels=%s)" % diffs
    else:
        out["status"] = STATUS_FAIL
        out["detail"] = "frames identical in key region (frozen battle)"
    return out


def gate(run_dir):
    """返回完整判据 dict；供本工具与 quick_diag 复用。"""
    result = {
        "schema": "battle-visual-gate/1",
        "run_dir": os.path.abspath(run_dir),
        "shot_pc": None,
        "size": None,
        "verdict": STATUS_UNKNOWN,
        "criteria": {},
        "error": None,
    }
    if not run_dir or not os.path.isdir(run_dir):
        result["error"] = "not a directory: %s" % run_dir
        return result

    result["criteria"]["LIVENESS"] = check_liveness(run_dir)

    shot = find_pc_shot(run_dir)
    if not shot:
        result["error"] = "missing battle_opponent_pc_*.png"
        result["criteria"]["HP_BAR"] = _status_unknown(result["error"])
        result["criteria"]["TEXTBOX"] = _status_unknown(result["error"])
    else:
        result["shot_pc"] = os.path.basename(shot)
        try:
            w, h, rgb = _load_rgb(shot)
        except (OSError, ValueError) as exc:
            result["error"] = "decode failed: %s" % exc
            result["criteria"]["HP_BAR"] = _status_unknown(result["error"])
            result["criteria"]["TEXTBOX"] = _status_unknown(result["error"])
            return _finalize(result)
        result["size"] = [w, h]
        px = _PixelView(rgb, w)
        result["criteria"]["HP_BAR"] = check_hp_bar(px, w, h)
        result["criteria"]["TEXTBOX"] = check_textbox(px, w, h)
    return _finalize(result)


class _PixelView(object):
    """按 (x,y) 取 RGB 的轻量视图，基于扁平 rgb 字节。"""

    def __init__(self, rgb, w):
        self.rgb = rgb
        self.w = w

    def __getitem__(self, xy):
        x, y = xy
        i = (y * self.w + x) * 3
        return self.rgb[i], self.rgb[i + 1], self.rgb[i + 2]


def _finalize(result):
    statuses = [c["status"] for c in result["criteria"].values()]
    if STATUS_FAIL in statuses:
        result["verdict"] = STATUS_FAIL
    elif STATUS_UNKNOWN in statuses:
        result["verdict"] = STATUS_UNKNOWN
    else:
        result["verdict"] = STATUS_PASS
    return result


def format_report(g):
    crit = g["criteria"]
    line = "VISUAL_GATE: %s  HP_BAR=%s TEXTBOX=%s LIVENESS=%s" % (
        g["verdict"],
        crit.get("HP_BAR", {}).get("status", "UNOBSERVED"),
        crit.get("TEXTBOX", {}).get("status", "UNOBSERVED"),
        crit.get("LIVENESS", {}).get("status", "UNOBSERVED"))
    details = ""
    for name in ("HP_BAR", "TEXTBOX", "LIVENESS"):
        c = crit.get(name, {})
        if c:
            details += "\n  %-9s %-11s %s" % (name, c.get("status"), c.get("detail"))
    if g.get("error"):
        details += "\n  error: %s" % g["error"]
    return line + details


def main(argv=None):
    ap = argparse.ArgumentParser(
        description="battle visual hard gate: HP_BAR + TEXTBOX + LIVENESS")
    ap.add_argument("run_dir", help="E2E run dir containing battle_opponent*.png")
    ap.add_argument("--json-out", help="also write pretty JSON to this path")
    args = ap.parse_args(argv)
    if not os.path.isdir(args.run_dir):
        sys.stderr.write("battle_visual_gate: not a directory: %s\n" % args.run_dir)
        return 2
    g = gate(args.run_dir)
    print(format_report(g))
    if args.json_out:
        try:
            with open(args.json_out, "w", encoding="utf-8") as fh:
                json.dump(g, fh, ensure_ascii=False, indent=2, sort_keys=True)
        except OSError as exc:
            sys.stderr.write("battle_visual_gate: cannot write json: %s\n" % exc)
    print("JSON: " + json.dumps(g, ensure_ascii=False, sort_keys=True))
    return {STATUS_PASS: 0, STATUS_FAIL: 1, STATUS_UNKNOWN: 3}[g["verdict"]]


if __name__ == "__main__":
    sys.exit(main())
