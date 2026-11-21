#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""抓 mGBA 窗口画面（纯 ctypes + Pillow，不碰模拟器内部）。

用 PrintWindow 把窗口内容画到位图，即使窗口被遮挡或被最小化也能拿到，
且完全不经过 CoreController，联机等待时不会干扰核心线程。

窗口选择（关键）
----------------
联机驱动跑起来时，机器上可能**同时存在多个 mGBA.exe 进程**（本轮 PC + 别的
agent 的 PyInstaller mGBA）。旧版 find_window() 用 tasklist 取"所有 mGBA.exe 的
PID"，再返回 EnumWindows 命中的第一个可见窗口 —— 会抓到别的进程的窗口，让
battle_visual_gate 因"抓错窗口"产生假 FAIL。

因此 find_window() 支持 ``pid`` 参数：**只认属于该 PID 的可见窗口**，找不到就
返回 None，绝不退回别的 mGBA（退回正是假 FAIL 的根因）。driver 启动时用
subprocess.Popen 起了自己的 mGBA 并记下 pc.pid，直接传进来即可。
拿不到 PID 时保留旧行为（tasklist 限定 mGBA.exe 的 PID 集合），也支持用
``title_contains`` 按窗口标题里的 ROM/版本标识兜底匹配。

用法:
    python tools/pcscreen.py out.png                       # 旧行为
    python tools/pcscreen.py out.png --pid 31076            # 精确抓本轮 PC
    python tools/pcscreen.py out.png --title-contains 0.11-10027
"""
import argparse
import ctypes
import ctypes.wintypes as wt
import sys

from PIL import Image

user32 = ctypes.windll.user32
gdi32 = ctypes.windll.gdi32

from gba_addrs import PW_RENDERFULLCONTENT, SRCCOPY  # 统一 Win32 常量宏（原值 0x00000002 / 0x00CC0020）

EnumProc = ctypes.WINFUNCTYPE(wt.BOOL, wt.HWND, wt.LPARAM)


def _mgba_pids(exe_name="mGBA.exe"):
    """tasklist 取当前所有 ``exe_name`` 进程的 PID（旧行为靠它限定 mGBA 进程）。"""
    import subprocess
    out = subprocess.run(
        ["tasklist", "/FI", "IMAGENAME eq " + exe_name, "/FO", "CSV", "/NH"],
        capture_output=True, text=True, errors="replace").stdout
    pids = []
    for line in out.splitlines():
        parts = [p.strip('"') for p in line.split('","')]
        if len(parts) >= 2 and parts[0].lower().endswith(".exe"):
            try:
                pids.append(int(parts[1]))
            except ValueError:
                pass
    return pids


def enumerate_windows():
    """返回 [(hwnd, pid, title)]：所有可见、有标题的顶层窗口。

    纯查询、不带任何 mGBA/PID 过滤；上层按 PID 或标题挑选。
    单测可整体替换本函数注入假窗口，无需真实 Windows 窗口。
    """
    found = []

    def enum(hwnd, _):
        if not user32.IsWindowVisible(hwnd):
            return True
        length = user32.GetWindowTextLengthW(hwnd)
        if length <= 0:
            return True
        buf = ctypes.create_unicode_buffer(length + 1)
        user32.GetWindowTextW(hwnd, buf, length + 1)
        pid = wt.DWORD()
        user32.GetWindowThreadProcessId(hwnd, ctypes.byref(pid))
        found.append((int(hwnd), int(pid.value), buf.value))
        return True

    user32.EnumWindows(EnumProc(enum), 0)
    return found


def find_window_info(exe_name="mGBA.exe", pid=None, title_contains=None):
    """挑本轮的 mGBA 窗口，返回 (hwnd, pid, title)；找不到返回 (None, None, None)。

    过滤优先级：
      * ``pid`` 给定 → **只**认属于该 PID 的可见窗口。多个 mGBA 并存时这是唯一
        可靠的区分手段；找不到就返回 None，绝不退回别的 mGBA 窗口。
      * ``pid`` 未给定 → 退回旧行为：用 tasklist 把候选限定在 mGBA.exe 的 PID 集合。
      * ``title_contains`` 给定 → 再要求标题含该子串（ROM/版本标识兜底，可与 pid 叠加）。
    """
    if pid is not None:
        try:
            pid = int(pid)
        except (TypeError, ValueError):
            pid = None
    allowed = None
    if pid is None:
        allowed = set(_mgba_pids(exe_name))
    for hwnd, wpid, title in enumerate_windows():
        if allowed is not None and wpid not in allowed:
            continue
        if pid is not None and wpid != pid:
            continue
        if title_contains and title_contains not in title:
            continue
        return (hwnd, wpid, title)
    return (None, None, None)


def find_window(exe_name="mGBA.exe", pid=None, title_contains=None):
    """兼容旧接口：只返回 hwnd（int）或 None。"""
    hwnd, _wpid, _title = find_window_info(exe_name, pid, title_contains)
    return hwnd


def grab(hwnd, out_path):
    rect = wt.RECT()
    user32.GetWindowRect(hwnd, ctypes.byref(rect))
    w = rect.right - rect.left
    h = rect.bottom - rect.top
    if w <= 0 or h <= 0:
        return None
    hdc = user32.GetWindowDC(hwnd)
    memdc = gdi32.CreateCompatibleDC(hdc)
    bmp = gdi32.CreateCompatibleBitmap(hdc, w, h)
    gdi32.SelectObject(memdc, bmp)
    ok = user32.PrintWindow(hwnd, memdc, PW_RENDERFULLCONTENT)
    if not ok:
        gdi32.BitBlt(memdc, 0, 0, w, h, hdc, 0, 0, SRCCOPY)

    class BITMAPINFOHEADER(ctypes.Structure):
        _fields_ = [("biSize", wt.DWORD), ("biWidth", wt.LONG), ("biHeight", wt.LONG),
                    ("biPlanes", wt.WORD), ("biBitCount", wt.WORD),
                    ("biCompression", wt.DWORD), ("biSizeImage", wt.DWORD),
                    ("biXPelsPerMeter", wt.LONG), ("biYPelsPerMeter", wt.LONG),
                    ("biClrUsed", wt.DWORD), ("biClrImportant", wt.DWORD)]

    bi = BITMAPINFOHEADER()
    bi.biSize = ctypes.sizeof(BITMAPINFOHEADER)
    bi.biWidth = w
    bi.biHeight = -h
    bi.biPlanes = 1
    bi.biBitCount = 32
    bi.biCompression = 0
    buf = ctypes.create_string_buffer(w * h * 4)
    gdi32.GetDIBits(memdc, bmp, 0, h, buf, ctypes.byref(bi), 0)

    img = Image.frombuffer("RGBA", (w, h), buf, "raw", "BGRA", 0, 1).convert("RGB")
    img.save(out_path)

    gdi32.DeleteObject(bmp)
    gdi32.DeleteDC(memdc)
    user32.ReleaseDC(hwnd, hdc)
    return img.size


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("out", nargs="?", default="pc_win.png")
    ap.add_argument("--pid", type=int, default=None)
    ap.add_argument("--title-contains", default=None)
    ap.add_argument("--exe", default="mGBA.exe")
    args = ap.parse_args()
    hwnd, wpid, title = find_window_info(args.exe, args.pid, args.title_contains)
    if not hwnd:
        print("NO_WINDOW")
        return 1
    print("hwnd=%d pid=%d title=%s" % (hwnd, wpid, title))
    size = grab(hwnd, args.out)
    print(size)
    return 0 if size else 1


if __name__ == "__main__":
    sys.exit(main())
