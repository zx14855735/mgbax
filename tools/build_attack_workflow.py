# -*- coding: utf-8 -*-
"""
build_attack_workflow.py — P0 入口轴/战斗场 ROM 改动 + 门开重编 + 冻结 + 重锚 工作流。

固化「改 ROM 代码 + 工作流执行」纪律（父会话独占串行，CPU<=70%，不碰 gen8 主树）：

  ROM 改动（灰区/流程便捷化，非造假，须标注）：
    data/scripts/cable_club.inc 服务菜单默认项由 TradeCenter 改为 Colosseum ——
    让 APP 在服务菜单不按 DOWN 直接 A 即 warp 战斗场 25.24（stall 落点 (6,8)），
    避开 driver 截图 oracle 选错项 warp 到交易中心 25.25 的假突破。
    ★ party 仍来自对端真游戏、握手仍需真 8FFF 双端字 —— 不造 party/信任位/伪 CROSSED/species，
      不强写 rem/nr/brs/st。产物须标「灰区流程便捷化、CROSSED 可信度存疑、非纯零注入、不进裁决」。

  流程（每步 fail-closed，任一失败即停、不污染 gen8 主树）：
    1. 读 gen8 最新已提交 HEAD；独立 WT 幂等 ff-only 到该 HEAD（不写主树）
    2. 在 WT 内应用可回滚 ROM patch（备份原文件 -> .orig；幂等：已打过则跳过）
    3. 门开重编 make -j8 MODERN=1 MGBAX_NETGATE_LOG=1（OBJ_DIR=build/modern_nglog）
    4. 冻结 rom.gba/elf/map + nm 到 .zcode-tmp/<tag>-frozen，md5 静置双次
    5. reanchor.py 真 PASS（全字段核，禁 vacuous）
    6. 打印 manifest 关键值 + 新 md5；manifest 落盘由父会话独占判读后执行

  门 FAIL/0/9/CROSSED 不变；本脚本产物 = ROM 产物级证据，≠ 运行时 tag_ok ≠ 对手真实 ≠ 翻门。

用法：
  python tools/build_attack_workflow.py --tag ATK-COLOSSEUM-01
  python tools/build_attack_workflow.py --tag ATK-COLOSSEUM-01 --revert   # 回滚 WT 内 ROM patch
"""
import argparse
import hashlib
import os
import shutil
import subprocess
import sys
import time

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
GEN8 = r"D:\gen8"                    # 只读来源；他人在此编译，绝不写入
WT = r"D:\mgbax-ng8-latest"          # 独立 worktree，唯一编译产物地
MSYS_BASH = r"C:\msys64\usr\bin\bash.exe"
NM = r"C:\msys64\opt\devkitpro\devkitARM\bin\arm-none-eabi-nm.exe"

GEN8_ROM = os.path.join(GEN8, "rom.gba")
GEN8_ELF = os.path.join(GEN8, "rom.elf")
GEN8_MAP = os.path.join(GEN8, "rom.map")
_WRITE_DENY = {os.path.normcase(os.path.abspath(p)) for p in (GEN8_ROM, GEN8_ELF, GEN8_MAP)}

# ROM patch：cable_club.inc 服务菜单 case 映射（默认项 0 -> Colosseum）
PATCH_REL = os.path.join("data", "scripts", "cable_club.inc")
PATCH_TAG = "MGBAX_P0_COLOSSEUM_DEFAULT"
OLD_BLOCK = """\tswitch VAR_RESULT
\tcase 0, CableClub_EventScript_TradeCenter
\tcase 1, CableClub_EventScript_Colosseum
\tcase 2, CableClub_EventScript_AbortLink"""
NEW_BLOCK = """\tswitch VAR_RESULT
\t@ MGBAX_P0_COLOSSEUM_DEFAULT: default item 0 -> Colosseum (gray flow convenience, not fake)
\tcase 0, CableClub_EventScript_Colosseum
\tcase 1, CableClub_EventScript_TradeCenter
\tcase 2, CableClub_EventScript_AbortLink"""


def assert_write_safe(path):
    ap = os.path.normcase(os.path.abspath(path))
    if ap in _WRITE_DENY:
        raise RuntimeError("WRITE DENIED: refusing to write gen8 main tree ROM: %s" % path)
    return path


def sh(cmd, cwd=None, env=None):
    r = subprocess.run(cmd, cwd=cwd, env=env, capture_output=True, text=True,
                       encoding="utf-8", errors="replace")
    return r.returncode, (r.stdout or "") + (("\n[ERR]" + (r.stderr or "")) if r.stderr else "")


def md5(path):
    h = hashlib.md5()
    with open(path, "rb") as f:
        for chunk in iter(lambda: f.read(1 << 20), b""):
            h.update(chunk)
    return h.hexdigest().upper()


def apply_rom_patch(revert=False):
    p = os.path.join(WT, PATCH_REL)
    assert_write_safe(p)
    if not os.path.exists(p):
        print("FATAL: missing %s" % p); return False
    backup = p + ".p0-orig"
    with open(p, "r", encoding="utf-8", errors="replace") as f:
        t = f.read()

    if revert:
        if os.path.exists(backup):
            shutil.copy2(backup, p)
            print("ROM patch REVERTED from %s" % backup)
        else:
            print("WARN: no backup, trying in-place unpatch")
            t = t.replace(NEW_BLOCK, OLD_BLOCK)
            with open(p, "w", encoding="utf-8", errors="replace") as f:
                f.write(t)
        return True

    if PATCH_TAG in t:
        print("ROM patch already applied (idempotent)")
        return True
    if OLD_BLOCK not in t:
        print("FATAL: OLD_BLOCK not found in cable_club.inc (source drift?)")
        return False
    if not os.path.exists(backup):
        shutil.copy2(p, backup)
        print("backup -> %s" % backup)
    t2 = t.replace(OLD_BLOCK, NEW_BLOCK, 1)
    with open(p, "w", encoding="utf-8", errors="replace") as f:
        f.write(t2)
    print("ROM patch APPLIED: %s (case0->Colosseum, case1->TradeCenter)" % PATCH_TAG)
    return True


def main():
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--tag", default="ATK-COLOSSEUM-01")
    ap.add_argument("--fz", default=None)
    ap.add_argument("--revert", action="store_true", help="revert ROM patch in WT only")
    ap.add_argument("--skip-build", action="store_true")
    ap.add_argument("--arch-logic-master", action="store_true",
                    help="§3.6 大改架构：门开重编时加 MGBAX_ARCH_LOGIC_MASTER=1"
                         "（CheckMasterOrSlave 由逻辑角色 localId==0 判主机，跳过 SIO 硬件 SD 线）")
    args = ap.parse_args()

    if args.revert:
        ok = apply_rom_patch(revert=True)
        print("REVERT_DONE=%s" % ok)
        return 0 if ok else 3

    # CPU <=70% 硬闸
    rc, out = sh(["powershell", "-NoProfile", "-Command",
                  "(Get-CimInstance Win32_Processor|Measure-Object LoadPercentage -Average).Average"])
    cpu = float((out or "0").strip().splitlines()[0])
    print("CPU=%.1f" % cpu, flush=True)
    if cpu > 70:
        print("FATAL: CPU>70, refuse to build"); return 2

    print("=== [1] gen8 最新 HEAD + WT 幂等 ff-only ===", flush=True)
    rc, head = sh(["git", "rev-parse", "--short", "HEAD"], cwd=GEN8)
    if rc != 0:
        print("FATAL: cannot read gen8 HEAD"); return 2
    head = head.strip()
    print("gen8 HEAD=%s" % head, flush=True)
    if not (os.path.isdir(os.path.join(WT, ".git")) or os.path.exists(os.path.join(WT, ".git"))):
        print("FATAL: WT missing; add worktree first"); return 2
    rc, wt_head = sh(["git", "rev-parse", "--short", "HEAD"], cwd=WT)
    wt_head = wt_head.strip()
    if wt_head != head:
        rc, out = sh(["git", "merge", "--ff-only", head], cwd=WT)
        print("WT ff-only %s -> %s : %s" % (wt_head, head, out.strip()[-160:]), flush=True)
        if rc != 0:
            print("FATAL: WT ff-only failed (WT has divergent commits?)"); return 2
    else:
        print("WT already at HEAD=%s" % head, flush=True)

    # 构建工具补齐（gitignore 的 .exe）
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

    print("=== [2] 应用 ROM patch ===", flush=True)
    if not apply_rom_patch(revert=False):
        return 3

    fz = args.fz or os.path.join(BASE, ".zcode-tmp", args.tag + "-frozen")
    os.makedirs(fz, exist_ok=True)

    if not args.skip_build:
        arch_flag = " MGBAX_ARCH_LOGIC_MASTER=1" if args.arch_logic_master else ""
        print("=== [3] 门开重编 MODERN=1 MGBAX_NETGATE_LOG=1%s ===" % arch_flag, flush=True)
        env = os.environ.copy()
        build_sh = os.path.join(fz, "build.sh")
        with open(build_sh, "w", encoding="ascii") as f:
            f.write("#!/usr/bin/env bash\n")
            f.write("export PATH=/c/msys64/opt/devkitpro/devkitARM/bin:/c/msys64/usr/bin:/usr/bin:/bin:$PATH\n")
            f.write("cd /d/mgbax-ng8-latest || exit 9\n")
            f.write("make -j8 MODERN=1 MGBAX_NETGATE_LOG=1%s\n" % arch_flag)
        rc, out = sh([MSYS_BASH, build_sh.replace("\\", "/").replace("D:", "/d")], env=env)
        print("\n".join(out.splitlines()[-25:]), flush=True)
        if rc != 0:
            print("FATAL: build failed rc=%d" % rc); return 3
    else:
        print("=== [3] SKIP BUILD ===", flush=True)

    print("=== [4] 冻结 + md5 静置双次 ===", flush=True)
    rom = os.path.join(WT, "rom.gba")
    elf = os.path.join(WT, "rom.elf")
    mp = os.path.join(WT, "rom.map")
    for p in (rom, elf, mp):
        if not os.path.exists(p):
            print("FATAL: missing %s" % p); return 4
    md5s = {}
    for name, src in (("rom.gba", rom), ("rom.elf", elf), ("rom.map", mp)):
        if os.path.normcase(os.path.abspath(src)) in _WRITE_DENY:
            raise RuntimeError("SOURCE DENIED: reading gen8 main ROM not allowed")
        shutil.copy2(src, assert_write_safe(os.path.join(fz, name)))
        p = os.path.join(fz, name)
        time.sleep(1)
        m1 = md5(p); time.sleep(1); m2 = md5(p)
        if m1 != m2:
            print("FATAL: md5 unsettled %s" % name); return 4
        md5s[name] = m1
        print("%s md5=%s (settled x2)" % (name, m1), flush=True)

    print("=== [5] nm 符号表 ===", flush=True)
    nmout = os.path.join(fz, "syms_nm.txt")
    rc, out = sh([NM, "-nS", os.path.join(fz, "rom.elf")])
    with open(nmout, "w", encoding="ascii", errors="replace") as f:
        f.write(out)
    for sym in ("gNetGateDiag", "GnpNetGate_HmacTagOk", "gGnpTxPort", "BattleMainCB2"):
        print("%s => %d" % (sym, out.count(sym)), flush=True)

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
           "--tag", args.tag, "--out", tmpl, "--report", report]
    rc, out = sh(cmd)
    # Windows 控制台 GBK 无法编码 sh() 解码产生的 \ufffd，打印前统一 ASCII 安全化
    print(out.strip()[-1200:].encode("ascii", "replace").decode("ascii"), flush=True)
    if rc != 0:
        print("FATAL: reanchor failed rc=%d" % rc); return 5

    import json
    try:
        r = json.load(open(report, encoding="utf-8"))
    except Exception as e:
        print("FATAL: bad report %s" % e); return 5
    guards = r.get("guards", [])
    bad = ([g.get("name") for g in guards if not g.get("ok", False)]
           if isinstance(guards, list) else
           [k for k, v in guards.items() if not v.get("ok", False)])
    syms = r.get("symbols", {})
    diag = syms.get("gNetGateDiag", {})
    true_pass = (r.get("status") == "PASS" and not bad and
                 diag.get("src") == "nm" and diag.get("size") == 64 and
                 r.get("diag_size_from_source") == 64)
    print("REANCHOR status=%s guards_bad=%s TRUE_PASS=%s" % (r.get("status"), bad, true_pass), flush=True)
    print("ROM_MD5=%s" % md5s["rom.gba"], flush=True)
    print("FZ=%s" % fz, flush=True)
    print("NOTE: 灰区流程便捷化产物，CROSSED 可信度存疑、非纯零注入、不进裁决；门 FAIL/0/9 不变", flush=True)
    return 0 if true_pass else 5


if __name__ == "__main__":
    sys.exit(main())
