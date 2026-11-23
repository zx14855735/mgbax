# -*- coding: utf-8 -*-
"""
build_netgate_latest.py — 以 gen8 当前最新已提交源码为准，门开重编 NETGATE ROM
并生成 manifest 重锚报告。固化「最新 ROM 为准、随时改代码」工作流（父会话独占串行执行）。

流程（每步 fail-closed，任一失败即停、不污染主树/源码树）：
  1. 读 gen8 当前 HEAD（不手动同步、不 ff-only、不 reset；以最新已提交源码为准）
  2. 建独立临时 worktree（基于该 HEAD，带 untracked 构建工具）
  3. make -j8 MODERN=1 MGBAX_NETGATE_LOG=1（门开，OBJ_DIR=build/modern_nglog）
  4. 冻结 rom.gba/elf/map + nm 到私有目录，md5 静置双次确认
  5. judge_frozen 结构判读（diag 64B EWRAM / line ABSENT / HmacTagOk 出现 / ewram_data_end）
  6. reanchor.py 真 PASS（全字段核，禁 vacuous）-> manifest 模板 + report
  7. 打印 manifest 关键值 + 新 md5，供父会话落盘 src/platform/gboy/gnp_manifest.h

产物全部落私有目录，不自动写源码树（manifest 落盘由父会话独占判读后执行）。
门 FAIL/0/9/CROSSED 不变；本脚本产物 = ROM 产物级证据，≠ 运行时 tag_ok ≠ 对手真实。
"""
import argparse
import hashlib
import os
import shutil
import subprocess
import sys
import time

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))  # repo root
GEN8 = r"D:\gen8"                    # 只读来源：gen8 主树（其他人在此编译 ROM，绝不写入/覆盖）
WT = r"D:\mgbax-ng8-latest"          # 独立临时 worktree（最新 HEAD），本脚本唯一编译产物地
MSYS_BASH = r"C:\msys64\usr\bin\bash.exe"
NM = r"C:\msys64\opt\devkitpro\devkitARM\bin\arm-none-eabi-nm.exe"

# 硬约束（用户明示）：绝不替换/覆盖其他人编译的 ROM。
# 所有写操作仅限 WT / 私有冻结目录；GEN8 主树 rom.gba/elf/map 只读，禁止任何写入。
GEN8_ROM = os.path.join(GEN8, "rom.gba")
GEN8_ELF = os.path.join(GEN8, "rom.elf")
GEN8_MAP = os.path.join(GEN8, "rom.map")
_WRITE_DENY = {os.path.normcase(os.path.abspath(p)) for p in (GEN8_ROM, GEN8_ELF, GEN8_MAP)}


def assert_write_safe(path):
    """写前断言：目标不得是 gen8 主树 ROM（他人产物）。命中即中止。"""
    ap = os.path.normcase(os.path.abspath(path))
    if ap in _WRITE_DENY:
        raise RuntimeError("WRITE DENIED: refusing to overwrite another builder's ROM: %s" % path)
    return path


def sh(cmd, cwd=None, env=None):
    # Windows 中文环境：make 输出含非 gbk 字节，必须 errors=replace 防 UnicodeDecodeError
    r = subprocess.run(cmd, cwd=cwd, env=env, capture_output=True,
                       text=True, encoding="utf-8", errors="replace")
    return r.returncode, (r.stdout or "") + (("\n[ERR]" + r.stderr or "") if r.stderr else "")


def md5(path):
    h = hashlib.md5()
    with open(path, "rb") as f:
        for chunk in iter(lambda: f.read(1 << 20), b""):
            h.update(chunk)
    return h.hexdigest().upper()


def main():
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--tag", default="NGLATEST-01")
    ap.add_argument("--fz", default=None, help="freeze dir (default: repo .zcode-tmp/<tag>-frozen)")
    ap.add_argument("--skip-build", action="store_true", help="reuse existing WT rom.*")
    args = ap.parse_args()

    fz = args.fz or os.path.join(BASE, ".zcode-tmp", args.tag + "-frozen")
    os.makedirs(fz, exist_ok=True)

    print("=== [1] gen8 当前最新 HEAD ===", flush=True)
    rc, head = sh(["git", "rev-parse", "--short", "HEAD"], cwd=GEN8)
    if rc != 0:
        print("FATAL: cannot read gen8 HEAD"); return 2
    head = head.strip()
    print("HEAD=%s" % head, flush=True)

    print("=== [2] 独立 worktree(基于最新 HEAD, 不手动同步) ===", flush=True)
    if not os.path.isdir(os.path.join(WT, ".git")) and not os.path.exists(os.path.join(WT, ".git")):
        rc, out = sh(["git", "worktree", "add", "-b", "nglatest", WT, head], cwd=GEN8)
        if rc != 0:
            # 分支可能存在，试 --detach
            rc, out = sh(["git", "worktree", "add", "--detach", WT, head], cwd=GEN8)
        print(out.strip()[-300:], flush=True)
        if rc != 0:
            print("FATAL: worktree add failed"); return 2
    # 从主树补齐 gitignore 的构建工具（preproc/scaninc/gbafix 等 .exe）
    src_tools = os.path.join(GEN8, "tools")
    dst_tools = os.path.join(WT, "tools")
    copied = 0
    for root, _dirs, files in os.walk(src_tools):
        for fn in files:
            if fn.endswith(".exe"):
                rel = os.path.relpath(os.path.join(root, fn), src_tools)
                dst = os.path.join(dst_tools, rel)
                os.makedirs(os.path.dirname(dst), exist_ok=True)
                if not os.path.exists(dst):
                    shutil.copy2(os.path.join(root, fn), dst)
                    copied += 1
    print("build tools copied=%d" % copied, flush=True)

    if not args.skip_build:
        print("=== [3] 门开重编(MODERN=1 MGBAX_NETGATE_LOG=1) ===", flush=True)
        env = os.environ.copy()
        build_sh = os.path.join(fz, "build.sh")
        with open(build_sh, "w", encoding="ascii") as f:
            f.write("#!/usr/bin/env bash\n")
            f.write("export PATH=/c/msys64/opt/devkitpro/devkitARM/bin:/c/msys64/usr/bin:/usr/bin:/bin:$PATH\n")
            f.write("cd /d/mgbax-ng8-latest || exit 9\n")
            f.write("make -j8 MODERN=1 MGBAX_NETGATE_LOG=1\n")
        rc, out = sh([MSYS_BASH, build_sh.replace("\\", "/").replace("D:", "/d")], env=env)
        tail = "\n".join(out.splitlines()[-25:])
        print(tail, flush=True)
        if rc != 0:
            print("FATAL: build failed rc=%d" % rc); return 3
    else:
        print("=== [3] SKIP BUILD (reuse WT rom.*) ===", flush=True)

    print("=== [4] 冻结 + md5 静置双次 ===", flush=True)
    rom = os.path.join(WT, "rom.gba")
    elf = os.path.join(WT, "rom.elf")
    mp = os.path.join(WT, "rom.map")
    for p in (rom, elf, mp):
        if not os.path.exists(p):
            print("FATAL: missing %s" % p); return 4
    for name, src in (("rom.gba", rom), ("rom.elf", elf), ("rom.map", mp)):
        # 源必须来自独立 worktree，且目的必须非 gen8 主树 ROM（他人产物）
        if os.path.normcase(os.path.abspath(src)) in _WRITE_DENY:
            raise RuntimeError("SOURCE DENIED: reading ROM from gen8 main tree is not allowed: %s" % src)
        shutil.copy2(src, assert_write_safe(os.path.join(fz, name)))
    time.sleep(2)
    md5s = {}
    for name in ("rom.gba", "rom.elf", "rom.map"):
        p = os.path.join(fz, name)
        m1 = md5(p); time.sleep(1); m2 = md5(p)
        if m1 != m2:
            print("FATAL: md5 unsettled %s %s != %s" % (name, m1, m2)); return 4
        md5s[name] = m1
        print("%s md5=%s (settled x2)" % (name, m1), flush=True)

    print("=== [5] nm 符号表(门开须含 diag) ===", flush=True)
    nmout = os.path.join(fz, "syms_nm.txt")
    rc, out = sh([NM, "-nS", os.path.join(fz, "rom.elf")])
    with open(nmout, "w", encoding="ascii", errors="replace") as f:
        f.write(out)
    for sym in ("gNetGateDiag", "GnpNetGate_HmacTagOk", "gGnpTxPort"):
        n = out.count(sym)
        print("%s => %d" % (sym, n), flush=True)
        if n == 0:
            print("WARN: %s absent -> ROM may be gate-off" % sym, flush=True)

    print("=== [6] reanchor 真 PASS ===", flush=True)
    report = os.path.join(fz, "reanchor_report.json")
    tmpl = os.path.join(fz, "manifest_template.h")
    reanchor = os.path.join(BASE, ".zcode-tmp", "reanchor.py")
    cmd = [sys.executable, reanchor,
           "--rom", os.path.join(fz, "rom.gba"),
           "--map", os.path.join(fz, "rom.map"),
           "--nm-txt", nmout,
           "--netcode-c", os.path.join(WT, "src", "netcode.c"),
           "--netcode-h", os.path.join(WT, "include", "netcode.h"),
           "--old-manifest", os.path.join(BASE, "src", "platform", "gboy", "gnp_manifest.h"),
           "--tag", args.tag,
           "--out", tmpl, "--report", report]
    rc, out = sh(cmd)
    print(out.strip()[-1200:], flush=True)
    if rc != 0:
        print("FATAL: reanchor failed rc=%d" % rc); return 5

    # 真 PASS 字段核（禁只凭 RESULT 字符串）
    import json
    try:
        r = json.load(open(report, encoding="utf-8"))
    except Exception as e:
        print("FATAL: bad report %s" % e); return 5
    guards = r.get("guards", [])
    if isinstance(guards, list):
        bad = [g.get("name") for g in guards if not g.get("ok", False)]
    else:
        bad = [k for k, v in guards.items() if not v.get("ok", False)]
    syms = r.get("symbols", {})
    diag = syms.get("gNetGateDiag", {})
    print("REANCHOR status=%s guards_bad=%s diag=%s src=%s diag_size_from_source=%s" % (
        r.get("status"), bad, diag.get("addr"), diag.get("src"), r.get("diag_size_from_source")), flush=True)
    true_pass = (r.get("status") == "PASS" and not bad and
                 diag.get("src") == "nm" and diag.get("size") == 64 and
                 r.get("diag_size_from_source") == 64)
    print("TRUE_PASS=%s" % ("YES" if true_pass else "NO"), flush=True)
    print("ROM_MD5=%s" % md5s["rom.gba"], flush=True)
    print("FZ=%s" % fz, flush=True)
    print("NOTE: manifest 落盘由父会话判读后独占执行; 产物=ROM级证据, != 运行时tag_ok != CROSSED", flush=True)
    return 0 if true_pass else 5


if __name__ == "__main__":
    sys.exit(main())
