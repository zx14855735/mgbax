#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""按 PID 抓 mGBA 窗口画面（PrintWindow + PIL）。

为什么需要它：`[diag]`/`[room]` 只能告诉我们 gLink 与菜单字段，看不到游戏到底
停在哪个提示框上。11-16 那几轮「rem=1 稳定两分钟但 menu/px/py 一动不动」
再靠猜按键只会白烧帧，必须先看图。

用法：
    python tools/win_shot.py --out shot_a.png --pid 1234
    python tools/win_shot.py --out both.png            # 抓所有 mGBA 窗口，纵向拼接
"""
import argparse
import ctypes
import os
import re
import sys
from ctypes import wintypes as wt

u = ctypes.windll.user32
g = ctypes.windll.gdi32

from gba_addrs import PW_RENDERFULLCONTENT  # 统一 Win32 常量宏（原值 0x00000002）

EnumProc = ctypes.WINFUNCTYPE(wt.BOOL, wt.HWND, wt.LPARAM)


def windows():
    """返回 [(pid, hwnd, title)]，只要可见、标题含 mGBA 的顶层窗口。"""
    out = []

    def cb(h, _l):
        if not u.IsWindowVisible(h):
            return True
        n = u.GetWindowTextLengthW(h)
        if n == 0:
            return True
        buf = ctypes.create_unicode_buffer(n + 1)
        u.GetWindowTextW(h, buf, n + 1)
        title = buf.value
        if "mGBA" not in title:
            return True
        pid = wt.DWORD(0)
        u.GetWindowThreadProcessId(h, ctypes.byref(pid))
        out.append((int(pid.value), int(h), title))
        return True

    u.EnumWindows(EnumProc(cb), 0)
    return out


def grab(hwnd, path):
    from PIL import Image

    rect = wt.RECT()
    if not u.GetClientRect(hwnd, ctypes.byref(rect)):
        return None
    w, h = rect.right - rect.left, rect.bottom - rect.top
    if w <= 0 or h <= 0:
        return None
    hdc = u.GetDC(hwnd)
    mdc = g.CreateCompatibleDC(hdc)
    bmp = g.CreateCompatibleBitmap(hdc, w, h)
    old = g.SelectObject(mdc, bmp)
    ok = u.PrintWindow(hwnd, mdc, PW_RENDERFULLCONTENT)
    if not ok:
        u.PrintWindow(hwnd, mdc, 0)

    class BITMAPINFOHEADER(ctypes.Structure):
        _fields_ = [("biSize", wt.DWORD), ("biWidth", wt.LONG), ("biHeight", wt.LONG),
                    ("biPlanes", wt.WORD), ("biBitCount", wt.WORD),
                    ("biCompression", wt.DWORD), ("biSizeImage", wt.DWORD),
                    ("biXPelsPerMeter", wt.LONG), ("biYPelsPerMeter", wt.LONG),
                    ("biClrUsed", wt.DWORD), ("biClrImportant", wt.DWORD)]

    bi = BITMAPINFOHEADER()
    bi.biSize = ctypes.sizeof(BITMAPINFOHEADER)
    bi.biWidth, bi.biHeight = w, -h
    bi.biPlanes, bi.biBitCount = 1, 32
    buf = ctypes.create_string_buffer(w * h * 4)
    got = g.GetDIBits(mdc, bmp, 0, h, buf, ctypes.byref(bi), 0)
    g.SelectObject(mdc, old)
    g.DeleteObject(bmp)
    g.DeleteDC(mdc)
    u.ReleaseDC(hwnd, hdc)
    if not got:
        return None
    img = Image.frombuffer("RGBA", (w, h), buf, "raw", "BGRA", 0, 1).convert("RGB")
    img.save(path)
    return path


def by_pid(pid):
    for p, h, t in windows():
        if p == pid:
            return h
    return None


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--out", required=True)
    ap.add_argument("--pid", type=int, default=0)
    args = ap.parse_args()
    if args.pid:
        h = by_pid(args.pid)
        if not h:
            print("no window for pid %d" % args.pid)
            return 1
        print(grab(h, args.out) or "grab failed")
        return 0
    hits = windows()
    if not hits:
        print("no mGBA window")
        return 1
    from PIL import Image
    shots = []
    for i, (p, h, t) in enumerate(hits):
        one = os.path.join(os.path.dirname(args.out) or ".",
                           "win_%d.png" % i)
        if grab(h, one):
            shots.append((p, t, one))
    if not shots:
        return 1
    ims = [Image.open(s[2]) for s in shots]
    W = max(im.width for im in ims)
    H = sum(im.height for im in ims)
    canvas = Image.new("RGB", (W, H), (0, 0, 0))
    y = 0
    for im in ims:
        canvas.paste(im, (0, y))
        y += im.height
    canvas.save(args.out)
    for p, t, one in shots:
        print("pid=%d %s" % (p, t))
    print(args.out)
    return 0


if __name__ == "__main__":
    sys.exit(main())
