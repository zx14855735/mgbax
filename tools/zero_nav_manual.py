# -*- coding: utf-8 -*-
r"""零注入手动导航到 cable club 等待连接（父会话实证成功路径固化，2026-11-24）。

用途：2.2fps 软渲染 AVD 下，cloud2p 的 driver 自动 SCREENSHOT oracle 无法稳定跳过
开场动画（8FFF/B9A0/LINKUP 全 0，cap 超时）。本脚本用父会话实证成功的完整手动 adb
命令序列，把干净母本从冷启动导航到 cable club 等待连接（APP link st=2 open=1）。

零注入纯度：仅用 am broadcast KEYS 受控输入 + 干净母本 1AD3BC83（party 00D5），
不发任何数据注入门（7 数据门用 driver 的 --env 全关）；受控输入≠数据注入，不碰红线。

用法：
  python tools/zero_nav_manual.py --tag ZEROMAN-01 [--serial emulator-5554]
每步截图落 .zcode-tmp/<tag>/step_XX.png，父会话逐图验收（截图是唯一可靠信号）。
"""
import argparse, io, os, subprocess, sys, time

ADB = r"D:\Android\Sdk\platform-tools\adb.exe"
PKG = "io.mgba.android"
KEY = "io.mgba.android.action.KEYS"
ROM = "/sdcard/Download/rom.gba"
BOOT_NOW = r"D:\gen8\rom_b.sav"   # 干净母本 1AD3BC83 party00D5 pos10,4 map2.3
ROOT = r"D:\mgba-android-version"


def run(*a, **kw):
    return subprocess.run([ADB] + list(a), capture_output=True, text=True,
                          encoding="utf-8", errors="replace", timeout=kw.get("timeout", 30))


def adb_sh(*a):
    return run("shell", *a)


def tap(mask, hold_ms=800, settle_ms=500):
    adb_sh("am", "broadcast", "-a", KEY, "--ei", "mask", str(mask))
    time.sleep(hold_ms / 1000.0)
    adb_sh("am", "broadcast", "-a", KEY, "--ei", "mask", "0")
    time.sleep(settle_ms / 1000.0)


def tap_burst(n, mask=1, hold_ms=650, settle_ms=450):
    for _ in range(n):
        tap(mask, hold_ms, settle_ms)


def shot(gdir, name):
    r = subprocess.run([ADB, "exec-out", "screencap", "-p"], capture_output=True, timeout=30)
    if r.returncode == 0 and r.stdout[:4] == b"\x89PNG":
        p = os.path.join(gdir, name)
        with open(p, "wb") as f:
            f.write(r.stdout)
        return p
    return None


def peek():
    r = adb_sh("logcat", "-d", "-t", "120", "-s", "mGBA:I")
    lines = [l for l in (r.stdout or "").splitlines() if "PEEK st=" in l]
    last = lines[-1] if lines else ""
    out = {}
    for pat, key in [(r"open=(\d+)", "open"), (r"link\[m=-?\d+ st=(-?\d+) pc=(-?\d+)", "st_pc"),
                     (r"pos=(-?\d+),(-?\d+) map=(-?\d+)\.(-?\d+)", "pos_map"),
                     (r"cb2=([0-9A-Fa-f]{8})", "cb2")]:
        import re
        m = re.search(pat, last)
        if m:
            out[key] = m.groups() if m.groups() > 1 else m.group(1)
    return out


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--tag", required=True)
    ap.add_argument("--serial", default="emulator-5554")
    ap.add_argument("--skip-boot", action="store_true", help="APP 已在主菜单/field,跳过冷启动")
    a = ap.parse_args()
    gdir = os.path.join(ROOT, ".zcode-tmp", a.tag)
    os.makedirs(gdir, exist_ok=True)

    # 确认设备
    if a.serial not in (run("devices").stdout or ""):
        print("FATAL: 设备 %s 未连接" % a.serial)
        return 2

    if not a.skip_boot:
        print("[0] 冷启动 + 干净母本")
        adb_sh("pm", "clear", PKG)
        run("push", BOOT_NOW, "/sdcard/Download/rom.sav")
        md5 = adb_sh("shell", "md5sum", "/sdcard/Download/rom.sav").stdout.strip()
        print("    设备 sav md5=%s (期望 1ad3bc83...)" % md5)
        adb_sh("am", "start", "-n", PKG + "/.EmulatorActivity")
        time.sleep(16)
        adb_sh("am", "broadcast", "-a", "io.mgba.android.action.ROM", "--es", "path", ROM)
        time.sleep(18)

    print("[1] 连打 A 跳过声明页")
    shot(gdir, "step_00_before_pulse.png")
    tap_burst(8)
    time.sleep(6)
    shot(gdir, "step_01_after_decl.png")

    print("[2] 连打 A 跳过战斗动画到主菜单")
    tap_burst(25)
    time.sleep(6)
    shot(gdir, "step_02_menu.png")

    print("[3] A 载入存档进 field")
    tap(1, 800, 500)
    time.sleep(12)
    shot(gdir, "step_03_field.png")
    print("    PEEK: %s" % peek())

    print("[4] UP 到柜台前 + A 触发接待员")
    tap(64, 7000, 500)   # 2.2fps 走一格需 ~7s
    tap(1, 800, 500)
    time.sleep(5)
    shot(gdir, "step_04_reception.png")

    print("[5] 连打 A 过接待员对话到服务菜单")
    tap_burst(5)
    time.sleep(3)
    shot(gdir, "step_05_service_menu.png")

    print("[6] DOWN 选大竞技场 + A")
    tap(128, 900, 600)
    tap(1, 900, 600)
    time.sleep(3)
    shot(gdir, "step_06_mode_menu.png")

    print("[7] A 选单打对战")
    tap(1, 900, 600)
    time.sleep(5)
    shot(gdir, "step_07_save_prompt.png")

    print("[8] A 确认保存 + 连打过保存")
    tap_burst(4, hold_ms=900, settle_ms=700)
    time.sleep(45)   # 2.2fps 保存慢
    shot(gdir, "step_08_saving.png")
    tap_burst(5, hold_ms=800, settle_ms=700)
    time.sleep(15)
    shot(gdir, "step_09_wait.png")
    print("    最终 PEEK: %s" % peek())
    print("    判据: open=1 + link st=2 = 到 cable club 等待连接(手动实证里程碑)")
    print("    诚实: 截图是唯一可靠信号,父会话逐图验收;灰区受控输入,非纯零注入玩法,不进CROSSED裁决")
    return 0


if __name__ == "__main__":
    sys.exit(main())
