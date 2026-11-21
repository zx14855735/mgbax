#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""quick_compare_frames -- 客观对比两个 run 的 PC 截图，判定"左上对手精灵是否变了"。

源码核实（battle_interface.c GetBattlerHealthboxCoords）：
单打时**对手(非玩家方)框在左上 (x44,y30)**，**我方(玩家)框在右下 (x158,y88)**；
数据取自 battle_gfx_sfx_util.c，玩家框读 gPlayerParty、对手框读 gEnemyParty。
因此左上 (55,175,470,305) 才是对手框（当前仍显示 "? Lv0" 问号），
右下 (470,440,950,600) 是我方框（"壶壶 Lv46"）——此前把右下当对手是误判。

用户核心标准是"对面精灵不是?"，所以本版：

  * 顶层 `opponent_box_changed`：**专门基于左上对手框 lt 判定**——这才是核心判据。
    同时给出 `opponent_box`（lt 的 diff%/changed/non_question_mark 明细）。
    `non_question_mark` 是"跨 run 像素变化推断"：同一问号占位符跨 run 恒为 0%，
    真精灵因每次注入物种不同才会变；这是启发式判据，不是 OCR，输出如实标注。
  * 内置预设区域：
      all        : 整张截图 (0,0,W,H)                 —— "全屏差异"
      full       : 整块游戏画面 (50,150,950,620)       —— 覆盖两个槽位
      lt         : 左上 (55,175,470,305)               —— **对手框**（核心判据）
      player_box : 右下 (470,440,950,600)              —— 我方框（旧名 rb，避免混淆）
  * 默认同时比对以上四个区域；`--box` 可重复指定，接受预设名或 `L,T,R,B`。
  * 区域按截图实际尺寸自动裁剪（PC 截图 672x579，越界框裁到边界内），
    输出 `requested_box` 与 `effective_box`，绝不把越界当 0。
  * 顶层 `changed` 仍取"全屏差异"：任何真实像素变化就是 True（非核心判据）。

PIL 可用时走 PIL；否则用内置 zlib 的纯 Python PNG 解码（8-bit RGB/RGBA/灰度，
全部 5 种 filter，非隔行），无第三方依赖也能跑。

用法：
    python tools/quick_compare_frames.py <runA> <runB>
    python tools/quick_compare_frames.py <runA> <runB> --box lt --box 0,0,672,579
"""

import argparse
import glob
import json
import os
import struct
import sys
import zlib

# 预设区域（源码核实：左上 lt=对手框；右下 player_box=我方框；full 覆盖整块画面）
PRESETS = {
    "all": (0, 0, 0, 0),               # 特例：运行时取 (0,0,W,H)
    "full": (50, 150, 950, 620),       # 整块游戏画面
    "lt": (55, 175, 470, 305),         # 左上对手框（核心判据，当前 ? Lv0）
    "player_box": (470, 440, 950, 600),  # 右下我方框（旧名 rb）；壶壶 Lv46
}
DEFAULT_BOXES = ["all", "full", "lt", "player_box"]

try:
    from PIL import Image as _PILImage
    _HAS_PIL = True
except ImportError:  # pragma: no cover
    _PILImage = None
    _HAS_PIL = False


# ---------------------------------------------------------------- 纯 Python PNG 解码
def _png_decode(path):
    """解码 8-bit 非隔行 PNG -> (width, height, rgb_bytes)。"""
    with open(path, "rb") as fh:
        data = fh.read()
    if data[:8] != b"\x89PNG\r\n\x1a\n":
        raise ValueError("not a PNG: %s" % path)

    pos = 8
    idat = bytearray()
    w = h = bit_depth = color_type = None
    interlace = 0
    while pos + 12 <= len(data):
        length = struct.unpack(">I", data[pos:pos + 4])[0]
        ctype = data[pos + 4:pos + 8]
        chunk = data[pos + 8:pos + 8 + length]
        pos += 12 + length
        if ctype == b"IHDR":
            w, h, bit_depth, color_type, comp, filt, interlace = struct.unpack(
                ">IIBBBBB", chunk)
        elif ctype == b"IDAT":
            idat.extend(chunk)
        elif ctype == b"IEND":
            break
    if w is None:
        raise ValueError("PNG missing IHDR: %s" % path)
    if bit_depth != 8 or interlace != 0:
        raise ValueError("unsupported PNG (bit_depth=%s interlace=%s): %s" %
                         (bit_depth, interlace, path))
    channels = {0: 1, 2: 3, 4: 2, 6: 4}.get(color_type)
    if channels is None:
        raise ValueError("unsupported PNG color_type=%s: %s" % (color_type, path))

    raw = zlib.decompress(bytes(idat))
    stride = w * channels
    rows = []
    prev = bytearray(stride)
    off = 0
    for _ in range(h):
        ft = raw[off]
        off += 1
        cur = bytearray(raw[off:off + stride])
        off += stride
        if ft == 1:    # Sub
            for i in range(channels, stride):
                cur[i] = (cur[i] + cur[i - channels]) & 0xFF
        elif ft == 2:  # Up
            for i in range(stride):
                cur[i] = (cur[i] + prev[i]) & 0xFF
        elif ft == 3:  # Average
            for i in range(stride):
                a = cur[i - channels] if i >= channels else 0
                cur[i] = (cur[i] + ((a + prev[i]) >> 1)) & 0xFF
        elif ft == 4:  # Paeth
            for i in range(stride):
                a = cur[i - channels] if i >= channels else 0
                b = prev[i]
                c = prev[i - channels] if i >= channels else 0
                p = a + b - c
                pa, pb, pc = abs(p - a), abs(p - b), abs(p - c)
                pr = a if (pa <= pb and pa <= pc) else (b if pb <= pc else c)
                cur[i] = (cur[i] + pr) & 0xFF
        elif ft != 0:
            raise ValueError("bad PNG filter type %d: %s" % (ft, path))
        prev = cur
        if channels == 3:
            rows.append(bytes(cur))
        elif channels == 4:
            rows.append(bytes(b for i in range(0, stride, 4)
                              for b in (cur[i], cur[i + 1], cur[i + 2])))
        elif channels == 1:
            rows.append(bytes(b for g in cur for b in (g, g, g)))
        else:  # gray+alpha
            rows.append(bytes(b for i in range(0, stride, 2)
                              for b in (cur[i], cur[i], cur[i])))
    return w, h, b"".join(rows)


def _load_rgb(path):
    """返回 (width, height, rgb_bytes)，统一 PIL / 纯解码两条路径。"""
    if _HAS_PIL:
        im = _PILImage.open(path).convert("RGB")
        return im.size[0], im.size[1], im.tobytes()
    return _png_decode(path)


def find_pc_shot(run_dir):
    hits = sorted(glob.glob(os.path.join(run_dir, "battle_opponent_pc_*.png")))
    if not hits:
        return None
    return max(hits, key=lambda p: os.path.getmtime(p))


# ---------------------------------------------------------------- 区域解析 / 比较
def parse_box(spec, w, h):
    """接受预设名或 `L,T,R,B`；返回 (requested_box, label)。"""
    key = spec.strip().lower()
    if key in PRESETS:
        box = PRESETS[key]
        if key == "all":
            box = (0, 0, w, h)
        return box, key
    parts = spec.split(",")
    if len(parts) != 4:
        raise ValueError("--box must be a preset (%s) or L,T,R,B, got %r" %
                         (",".join(PRESETS), spec))
    try:
        vals = tuple(int(p.strip()) for p in parts)
    except ValueError:
        raise ValueError("--box values must be integers: %r" % spec)
    if vals[2] <= vals[0] or vals[3] <= vals[1]:
        raise ValueError("--box needs right>left and bottom>top: %r" % spec)
    return vals, "custom"


def clip_box(box, w, h):
    l, t, r, b = box
    cl, ct = max(0, l), max(0, t)
    cr, cb = min(w, r), min(h, b)
    return (cl, ct, cr, cb), (cl, ct, cr, cb) == tuple(box)


def _diff_mask(a, b, w, h):
    """逐像素差异掩码：1 字节/像素，供所有区域复用（只解码/比较一次）。"""
    n = w * h
    mask = bytearray(n)
    for p in range(n):
        i = p * 3
        if a[i] != b[i] or a[i + 1] != b[i + 1] or a[i + 2] != b[i + 2]:
            mask[p] = 1
    return mask


def _region_stats(mask, w, h, box, label):
    requested = box
    eff, exact = clip_box(requested, w, h)
    l, t, r, b = eff
    if r <= l or b <= t:
        return {"label": label, "requested_box": list(requested),
                "effective_box": list(eff), "in_bounds": False,
                "total_pixels": 0, "diff_pixels": 0, "diff_percent": 0.0,
                "changed": False, "first_diff_xy": None,
                "error": "region entirely outside image"}
    total = (r - l) * (b - t)
    diff = 0
    first = None
    for y in range(t, b):
        base = y * w
        row = mask[base + l:base + r]
        if 1 in row:
            if first is None:
                first = [l + row.index(1), y]
            diff += sum(row)
    return {"label": label, "requested_box": list(requested),
            "effective_box": list(eff), "in_bounds": exact,
            "total_pixels": total, "diff_pixels": diff,
            "diff_percent": round(diff * 100.0 / total, 4),
            "changed": diff > 0, "first_diff_xy": first, "error": None}


def compare(run_a, run_b, box_specs=None):
    pa, pb = find_pc_shot(run_a), find_pc_shot(run_b)
    specs = box_specs if box_specs else DEFAULT_BOXES
    out = {
        "schema": "quick-compare-frames/2",
        "decoder": "PIL" if _HAS_PIL else "pure-python-png",
        "run_a": os.path.abspath(run_a), "run_b": os.path.abspath(run_b),
        "shot_a": os.path.basename(pa) if pa else None,
        "shot_b": os.path.basename(pb) if pb else None,
        "box_specs": specs,
        "presets": {k: list(v) for k, v in PRESETS.items()},
        "regions": {},
        "opponent_box_changed": None,
        "opponent_box": None,
        "error": None,
    }
    if not pa or not pb:
        out["error"] = "missing PC opponent screenshot in %s" % (
            run_a if not pa else run_b)
        out.update({"changed": None, "diff_pixels": None, "diff_percent": None,
                    "total_pixels": None, "box": None, "size_a": None, "size_b": None})
        return out

    wa, ha, a = _load_rgb(pa)
    wb, hb, b = _load_rgb(pb)
    out["size_a"], out["size_b"] = [wa, ha], [wb, hb]
    if (wa, ha) != (wb, hb):
        out["error"] = "screenshot size mismatch: %sx%s vs %sx%s" % (wa, ha, wb, hb)
        out.update({"changed": None, "diff_pixels": None, "diff_percent": None,
                    "total_pixels": None, "box": None})
        return out

    mask = _diff_mask(a, b, wa, ha)
    for spec in specs:
        try:
            box, label = parse_box(spec, wa, ha)
        except ValueError as exc:
            out["regions"][spec] = {"label": spec, "error": str(exc),
                                    "changed": None, "diff_pixels": None}
            continue
        out["regions"][label] = _region_stats(mask, wa, ha, box, label)

    # 核心判据：左上对手框 lt（用户标准"对面精灵不是?"）。
    # 若两次 run 的左上框像素一致（0%），视为仍是问号占位符；有差异才推断为真精灵。
    lt = out["regions"].get("lt")
    lt_changed = bool(lt.get("changed")) if lt and lt.get("changed") is not None else None
    out["opponent_box_changed"] = lt_changed
    out["opponent_box"] = {
        "box": lt["effective_box"] if lt else None,
        "diff_pixels": lt["diff_pixels"] if lt else None,
        "diff_percent": lt["diff_percent"] if lt else None,
        "total_pixels": lt["total_pixels"] if lt else None,
        "changed": lt_changed,
        "non_question_mark": lt_changed,
        "basis": "cross-run lt-box pixel change heuristic (not OCR): "
                 "0% => fixed '?' placeholder, >0% => real opponent sprite",
    }

    # 顶层取"全屏差异"：只要整张截图有任何真实变化就 changed=True。
    screen = out["regions"].get("all")
    if screen is None:
        screen = _region_stats(mask, wa, ha, (0, 0, wa, ha), "all")
        out["regions"]["all"] = screen
    out["changed"] = any(r.get("changed") for r in out["regions"].values()
                         if r.get("changed") is not None)
    out["diff_pixels"] = screen["diff_pixels"]
    out["diff_percent"] = screen["diff_percent"]
    out["total_pixels"] = screen["total_pixels"]
    out["box"] = screen["effective_box"]
    return out


def main(argv=None):
    ap = argparse.ArgumentParser(
        description="compare PC screenshots of two runs (lt=opponent box is the core criterion)")
    ap.add_argument("run_a")
    ap.add_argument("run_b")
    ap.add_argument("--box", action="append", default=None,
                    help="region preset (all/full/lt/player_box) or L,T,R,B; repeatable; "
                         "default: all full lt player_box")
    ap.add_argument("--json-out", help="also write pretty JSON to this path")
    args = ap.parse_args(argv)
    for d in (args.run_a, args.run_b):
        if not os.path.isdir(d):
            sys.stderr.write("quick_compare_frames: not a directory: %s\n" % d)
            return 2

    out = compare(args.run_a, args.run_b, args.box)
    if out["error"]:
        print("错误：%s" % out["error"])
    else:
        print("摘要：%s vs %s  全屏差异 %d/%d = %s%%，changed=%s；" % (
            out["shot_a"], out["shot_b"], out["diff_pixels"],
            out["total_pixels"], out["diff_percent"], out["changed"]))
        ob = out["opponent_box"] or {}
        print("OPPONENT_BOX: 左上对手框差异 %s%% (%s/%s)；"
              "opponent_box_changed=%s；非问号(跨run差异推断)=%s" % (
                  ob.get("diff_percent"), ob.get("diff_pixels"),
                  ob.get("total_pixels"), out["opponent_box_changed"],
                  ob.get("non_question_mark")))
        parts = []
        for label, r in out["regions"].items():
            parts.append("%s %d/%d(%s%%)%s" % (
                label, r["diff_pixels"], r["total_pixels"], r["diff_percent"],
                "@%s" % r["first_diff_xy"] if r["first_diff_xy"] else ""))
        print("区域：" + "；".join(parts))
    if args.json_out:
        try:
            with open(args.json_out, "w", encoding="utf-8") as fh:
                json.dump(out, fh, ensure_ascii=False, indent=2, sort_keys=True)
        except OSError as exc:
            sys.stderr.write("quick_compare_frames: cannot write json: %s\n" % exc)
    print("JSON: " + json.dumps(out, ensure_ascii=False, sort_keys=True))
    return 0 if not out["error"] else 2


if __name__ == "__main__":
    sys.exit(main())
