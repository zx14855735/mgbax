# -*- coding: utf-8 -*-
"""
ADDR2 — 地址宏化一致性验证脚本（只读验证；不改源码 / 不编译产物 / 不跑 E2E）

产生背景
--------
用户明示「把全部地址用宏定义写进工作流并执行」。ADDR1 负责建 tools/gba_addrs.py
并把 11 个 py 脚本 + 2 driver 改成引用具名宏；ADDR2（本脚本）负责在 ADDR1 交付后
由父会话执行「一致性验证」。本脚本只读，不修改任何被验证文件。

策略：按值匹配（不假设宏名）
----------------------------
ADDR1 的宏名未定，故本脚本不假设任何宏名，改用「值」裁决：
  * 内置父会话扫描得到的 35 个唯一 GBA 地址值（原裸值，见 CANONICAL_ADDRS）；
  * import gba_addrs，用 dir() 取所有大写常量，收集其 int 值集合；
  * 正向：每个内置地址值都能在常量值集合里找到 → PASS，缺失 → FAIL；
  * 反向：常量集合里的地址值若不在内置清单 → WARN（可能是合理常量，不强制 FAIL）；
  * 这样无论 ADDR1 怎么命名宏，都能验证「值全部被具名宏覆盖」。

35 个地址的还原依据（诚实记录）
-------------------------------
父会话给出的 30 个值 = 26 个完整地址 + 4 个 IWRAM 族前缀
（0x03002A / 0x03002B / 030000 / 0x03007F）。按父会话扫描口径把 4 个前缀展开成
实际出现的完整地址（对 tools 下 py 的磁盘实测）：
    0x03002A -> 0x03002A4A, 0x03002AB0, 0x03002AF4
    0x03002B -> 0x03002B0C, 0x03002B1E, 0x03002B84, 0x03002BC8
    0x030000 -> 0x03000000
    0x03007F -> 0x03007FF0
合计 9 个；26 + 9 = 35，与父会话「35 个唯一地址」一致。
磁盘实测另见 0x03002E30 / 0x03008000 / 0x080B4844 / 0x08000000 等地址，它们不在
父会话 35 项内；若 ADDR1 也为它们建宏，反向检查会给 WARN（合理，不判 FAIL）。

诚实纪律
--------
地址宏化是 AGENTS §5 工程纪律，只改「写法」，不改任何判据真实性：
门维持 FAIL / 对手真实性 0/9 / 零注入 CROSSED 唯一裁决不变；不预设成功；
红线禁造假；中文注释不伪造。本脚本只验证一致性，输出的 PASS 不代表联机成功。

用法
----
    python tools/addr_macro_verify.py            # 完整验证（ADDR1 交付后由父会话执行）
    python tools/addr_macro_verify.py --selftest # 自测：注入一个错值，验证能检出 FAIL
"""

from __future__ import print_function

import os
import re
import sys
import types
import glob
import shutil
import tempfile
import importlib
import py_compile
import tokenize
import io

HERE = os.path.dirname(os.path.abspath(__file__))
TOOLS_DIR = HERE
REPO_DIR = os.path.dirname(HERE)

# 三端引用一致性要检查的「driver + duo」文件
ENDPOINT_FILES = [
    os.path.join(TOOLS_DIR, "cloud2p_avd.py"),
    os.path.join(TOOLS_DIR, "cloud2p_avd_vis.py"),
    os.path.join(TOOLS_DIR, "cloud2p-duo.py"),
]

# ---------------------------------------------------------------------------
# 1. 内置 35 个唯一地址值（原裸值）→ 语义名（语义名取自源码周边注释，仅作说明）
#    值才是判据；语义名不参与裁决，仅用于 FAIL/WARN 时打印可读信息。
# ---------------------------------------------------------------------------
CANONICAL_ADDRS = {
    # --- 26 个父会话给出的完整地址 ---
    0x080B4845: "BattleMainCB2 cb2（真进战斗下界，入口+1）",
    0x080B48A8: "FreeRestoreBattleData（BattleMainCB2 cb2 上界）",
    0x080B30C0: "battle_main.o .text 起点（废弃宽窗口 lo）",
    0x080BCA78: "battle_main.o .text 终点（废弃宽窗口 hi）",
    0x080B376D: "CB2_HandleStartBattle（非战斗态，勿冒充）",
    0x080B310D: "CB2_InitBattle（非战斗态，勿冒充）",
    0x0816D8CD: "CB2_PrintErrorMessage（通信错误屏）",
    0x08105FD4: "CABLE_CLUB_CB2_LO",
    0x08107488: "CABLE_CLUB_CB2_HI",
    0x02033D0C: "gTasks（EWRAM base，gtasks）",
    0x0203FFF0: "EWRAM 扫描上界",
    0x02040000: "EWRAM 段尾",
    0x02000000: "EWRAM 基址",
    0x08100000: "ROM 窗口基址 0x08100000（旧战斗窗口族）",
    0x08110000: "ROM 窗口基址 0x08110000",
    0x08160000: "ROM 窗口基址 0x08160000",
    0x08190000: "ROM 窗口基址 0x08190000",
    0x08099848: "STALE 旧 ROM 战斗窗口 lo（仅旧 ROM 有效）",
    0x080A30FD: "STALE 旧 ROM 战斗窗口 hi（仅旧 ROM 有效）",
    0x080B24B8: "当前 ROM battle 窗口 lo（rom.map 动态解析用）",
    0x080BBE4C: "当前 ROM battle 窗口 hi",
    0x080B3C3C: "battle_main.o 函数入口（rom_addr_verify 观测点）",
    0x080B3C3D: "battle_main.o 函数入口+1（cb2 观测点）",
    0x080B7FB0: "cloud2p-duo 观测地址",
    0x080C1968: "cloud2p-duo 观测地址",
    0x00CC00:   "SRCCOPY 颜色/掩码常量（父会话列入清单，非 GBA 内存地址）",
    # --- 4 个前缀展开出的 9 个完整地址（磁盘实测，见文件头说明） ---
    0x03002A4A: "gRecvQueue（IWRAM 0x03002A 族）",
    0x03002AB0: "gSendCmd[8]（IWRAM 0x03002A 族）",
    0x03002AF4: "gLink（IWRAM canonical base，0x03002A 族）",
    0x03002B0C: "sendqueue（IWRAM 0x03002B 族）",
    0x03002B1E: "recv（IWRAM 0x03002B 族）",
    0x03002B84: "send（IWRAM 0x03002B 族）",
    0x03002BC8: "glink（IWRAM 0x03002B 族，旧基准）",
    0x03000000: "IWRAM 基址（0x030000 族）",
    0x03007FF0: "IWRAM 上界（0x03007F 族）",
}

CANONICAL_SET = set(CANONICAL_ADDRS.keys())

# 裸 hex 扫描的白名单：明显非地址常量（掩码 / 颜色 / 状态位），不报 WARN。
# is_gba_addr() 已按 GBA 内存区间过滤，这里只需补充落在清单里但属非地址的 0x00CC00。
NON_ADDR_WHITELIST = {
    0x00CC00, 0x00CC0020,  # SRCCOPY 颜色/位掩码，非 GBA 内存地址
}

# 父会话 typed 清单里两处的「口径对齐」（透明披露，不放宽其余 33 项的判据）：
#  (a) 前缀别名：父会话扫描把 Win32 SRCCOPY=0x00CC0020 截成 0x00CC00；
#      ADDR1 用完整值 SRCCOPY=0x00CC0020 建宏。前缀命中即视为覆盖。
PREFIX_ALIASES = {
    0x00CC00: 0x00CC0020,
}
#  (b) 注释-only 豁免：0x03002B0C 只在 sio_cmd_sim.py 的注释
#      （`OFF_SENDQUEUE = 0x18  # -> 0x03002B0C`）里出现，不是可执行字面量。
#      ADDR1 的 gba_addrs.py docstring 明示「注释保持原样以零改变行为」，故不建宏。
#      本脚本裸 hex 扫描同样跳过注释行；此处一致豁免，不判 FAIL。
COMMENT_ONLY_EXEMPT = {
    0x03002B0C,
}

IMPORT_RE = re.compile(r"\bgba_addrs\b")
LOCAL_DEF_RE = re.compile(r"^\s*([A-Z][A-Z0-9_]*)\s*=\s*0x([0-9A-Fa-f]{6,8})\b")


def is_gba_addr(value):
    """是否像 GBA 内存地址（EWRAM / IWRAM / ROM 镜像）。"""
    return (
        0x02000000 <= value <= 0x0203FFFF
        or 0x03000000 <= value <= 0x03007FFF
        or 0x08000000 <= value <= 0x0DFFFFFF
    )


def collect_const_values(mod):
    """按父会话要求：dir(mod) 取所有大写常量的 int 值集合（不看宏名）。"""
    values = set()
    for name in dir(mod):
        if name.startswith("_") or not name.isupper():
            continue
        try:
            value = getattr(mod, name)
        except Exception:
            continue
        if isinstance(value, bool):
            continue
        if isinstance(value, int):
            values.add(value)
    return values


def check_coverage(const_values):
    """正向：每个内置地址值都能在常量值集合里找到。返回 (ok, missing)。

    两处透明口径对齐（见 PREFIX_ALIASES / COMMENT_ONLY_EXEMPT）：
      * 前缀别名命中（0x00CC00 -> 完整 0x00CC0020）视为覆盖；
      * 注释-only 值（0x03002B0C）不计入必查项。
    其余 33 项一律要求精确值命中，不放宽。
    """
    missing = []
    for value in CANONICAL_ADDRS:
        if value in COMMENT_ONLY_EXEMPT:
            continue
        if value in const_values:
            continue
        if value in PREFIX_ALIASES and PREFIX_ALIASES[value] in const_values:
            continue
        missing.append((value, CANONICAL_ADDRS[value]))
    return (len(missing) == 0), missing


def check_extra(const_values):
    """反向：常量集合里的地址值都应属于内置清单；多余值 → WARN。"""
    extra = []
    for value in sorted(const_values):
        if value in CANONICAL_SET or value in NON_ADDR_WHITELIST:
            continue
        if is_gba_addr(value):
            extra.append(value)
    return extra


def iter_py_files():
    """tools 下所有 py 文件（含子目录，排除 __pycache__）。"""
    out = []
    for dp, dns, fns in os.walk(TOOLS_DIR):
        dns[:] = [d for d in dns if d != "__pycache__"]
        for fn in fns:
            if fn.endswith(".py"):
                out.append(os.path.join(dp, fn))
    return sorted(out)


def scan_bare_hex():
    """遗漏裸 hex 扫描：排除 gba_addrs.py 自身与本脚本（要求 2/5）。

    用 tokenize 只取 NUMBER token：注释、文档字符串、测试夹具字符串里的 hex
    一律不算「裸用」（ADDR1 的既定策略：注释保持原样以零改变行为）。这样 WARN
    只反映可执行代码里真正残留的地址字面量，不把「# 统一宏（原值 0x...）」误报。
    """
    findings = []
    skip_names = {"gba_addrs.py", "addr_macro_verify.py"}
    for path in iter_py_files():
        if os.path.basename(path) in skip_names:
            continue
        try:
            with open(path, "rb") as fh:
                tokens = tokenize.tokenize(fh.readline)
                for tok in tokens:
                    if tok.type != tokenize.NUMBER:
                        continue
                    text = tok.string
                    if not text.lower().startswith("0x"):
                        continue
                    value = int(text, 16)
                    if value in NON_ADDR_WHITELIST:
                        continue
                    if is_gba_addr(value):
                        findings.append((os.path.relpath(path, REPO_DIR),
                                         tok.start[0], value))
        except (OSError, tokenize.TokenError, SyntaxError, ValueError):
            # 编译检查（检查 4）会另行判 FAIL；这里只跳过无法 tokenize 的文件
            continue
    return findings


def check_endpoints():
    """三端引用一致：2 driver + duo 都 import gba_addrs，且不各自定义同值宏。"""
    not_imported = []
    duplicates = []
    for path in ENDPOINT_FILES:
        rel = os.path.relpath(path, REPO_DIR)
        if not os.path.isfile(path):
            not_imported.append((rel, "文件不存在"))
            continue
        with open(path, "r", encoding="utf-8", errors="replace") as fh:
            text = fh.read()
        if not IMPORT_RE.search(text):
            not_imported.append((rel, "未 import gba_addrs"))
        for match in LOCAL_DEF_RE.finditer(text):
            value = int(match.group(2), 16)
            if is_gba_addr(value) and value in CANONICAL_SET:
                duplicates.append((rel, match.group(1), value))
    return not_imported, duplicates


def check_compile():
    """py_compile 全部改造文件（用 py_compile.compile）；cfile 走临时目录，不污染仓库。"""
    tmpdir = tempfile.mkdtemp(prefix="addr_verify_")
    failures = []
    checked = 0
    try:
        for path in iter_py_files():
            checked += 1
            cfile = os.path.join(tmpdir, os.path.basename(path) + "c")
            try:
                py_compile.compile(path, cfile=cfile, doraise=True)
            except Exception as exc:  # noqa: BLE001 - 要捕获所有编译异常
                failures.append((os.path.relpath(path, REPO_DIR), str(exc)[:160]))
    finally:
        shutil.rmtree(tmpdir, ignore_errors=True)
    return checked, failures


def load_gba_addrs():
    """import tools.gba_addrs；ADDR1 未交付时抛异常由调用方判 FAIL。

    先清掉 __pycache__ 里 gba_addrs 的旧 .pyc：避免「源码已改、同秒同尺寸」时
    Python 复用陈旧字节码，导致验证读到旧宏值而误判 PASS（验证脚本必须读当前源码）。
    """
    if TOOLS_DIR not in sys.path:
        sys.path.insert(0, TOOLS_DIR)
    sys.modules.pop("gba_addrs", None)
    cache_dir = os.path.join(TOOLS_DIR, "__pycache__")
    if os.path.isdir(cache_dir):
        for pyc in glob.glob(os.path.join(cache_dir, "gba_addrs*.pyc")):
            try:
                os.remove(pyc)
            except OSError:
                pass
    return importlib.import_module("gba_addrs")


def selftest():
    """自测：构造假 gba_addrs（故意错一个宏值），验证能检出 FAIL（要求 6）。"""
    ok, _ = check_coverage(CANONICAL_SET)
    print("[SELFTEST] 正确值集合覆盖检查: %s" % ("PASS" if ok else "FAIL"))
    passed = 1 if ok else 0

    # 构造一个「假 gba_addrs」模块（大写常量），故意把 BattleMainCB2 cb2 写错 1。
    # 走与生产路径相同的 collect_const_values + check_coverage，验证能检出 FAIL。
    wrong = 0x080B4845
    fake = types.ModuleType("gba_addrs_fake")
    for i, value in enumerate(sorted(CANONICAL_ADDRS)):
        written = wrong + 1 if value == wrong else value
        setattr(fake, "M_%02d" % i, written)
    collected = collect_const_values(fake)
    ok2, missing2 = check_coverage(collected)
    detected = (not ok2) and any(v == wrong for v, _ in missing2)
    print("[SELFTEST] 注入错值 0x%08X -> 0x%08X 检出: %s"
          % (wrong, wrong + 1, "PASS" if detected else "FAIL"))
    if not detected:
        print("  实际 missing=%r" % (missing2,))
    passed += 1 if detected else 0

    print("SELFTEST_SUMMARY: %d/2 passed" % passed)
    return passed == 2


def main():
    argv = sys.argv[1:]
    if "--selftest" in argv:
        return 0 if selftest() else 1

    print("=" * 64)
    print("ADDR2 地址宏化一致性验证（按值匹配，不假设宏名）")
    print("内置地址数 = %d；tools 目录 = %s" % (len(CANONICAL_ADDRS), TOOLS_DIR))
    print("=" * 64)

    verdict_fail = False
    const_values = None  # import 失败时保持 None，避免检查 1b 引用未定义变量

    # --- 检查 1：宏值覆盖（FAIL 级） ---
    print("\n[1] 宏值 == 原裸值（正向覆盖）")
    try:
        mod = load_gba_addrs()
        const_values = collect_const_values(mod)
        ok, missing = check_coverage(const_values)
        if ok:
            print("  PASS: %d 个内置地址值全部在 gba_addrs 大写常量值集合中找到"
                  % len(CANONICAL_ADDRS))
        else:
            verdict_fail = True
            print("  FAIL: 缺失 %d 个地址值（无具名宏覆盖）:" % len(missing))
            for value, name in missing:
                print("    - 0x%08X  %s" % (value, name))
        # 透明披露口径对齐（不隐藏、不冒充「全部精确命中」）
        print("  口径对齐披露: %d 项精确必查；%d 项前缀别名(%s)；%d 项注释-only豁免(%s)"
              % (len(CANONICAL_ADDRS) - len(COMMENT_ONLY_EXEMPT),
                 len(PREFIX_ALIASES),
                 ",".join("0x%08X->0x%08X" % (k, v) for k, v in PREFIX_ALIASES.items()),
                 len(COMMENT_ONLY_EXEMPT),
                 ",".join("0x%08X" % v for v in COMMENT_ONLY_EXEMPT)))
    except Exception as exc:  # noqa: BLE001
        verdict_fail = True
        print("  FAIL: 无法 import gba_addrs（ADDR1 是否已交付？）: %s" % exc)

    # --- 检查 1b：反向多余地址值（WARN 级） ---
    print("\n[1b] 反向：常量中的额外地址值（WARN，可能合理）")
    if const_values is not None:
        extra = check_extra(const_values)
        if extra:
            print("  WARN: %d 个地址值不在 35 项内置清单:" % len(extra))
            for value in extra:
                names = [n for n in dir(mod)
                         if n.isupper() and getattr(mod, n, None) == value]
                print("    - 0x%08X  (%s)" % (value, ",".join(names[:4]) or "?"))
        else:
            print("  PASS: 常量地址值均为内置清单子集")

    # --- 检查 2：遗漏裸 hex（WARN 级） ---
    print("\n[2] 遗漏裸 hex 扫描（排除 gba_addrs.py 自身 / 本脚本；WARN）")
    bare = scan_bare_hex()
    if bare:
        print("  WARN: 发现 %d 处 GBA 地址裸用:" % len(bare))
        for rel, lineno, value in bare:
            print("    - %s:%d  0x%08X" % (rel, lineno, value))
    else:
        print("  PASS: 未发现遗漏的 GBA 地址裸用")

    # --- 检查 3：三端引用一致（WARN 级） ---
    print("\n[3] 三端引用一致（2 driver + duo import，无重复同值宏；WARN）")
    not_imported, duplicates = check_endpoints()
    if not_imported:
        print("  WARN: 以下文件未 import gba_addrs:")
        for rel, why in not_imported:
            print("    - %s（%s）" % (rel, why))
    else:
        print("  PASS: 两个 driver + duo 均引用 gba_addrs")
    if duplicates:
        print("  WARN: 以下文件各自定义了同值宏（疑似重复定义）:")
        for rel, name, value in duplicates:
            print("    - %s: %s = 0x%08X" % (rel, name, value))
    else:
        print("  PASS: 未发现重复的同值宏定义")

    # --- 检查 4：py_compile（FAIL 级） ---
    print("\n[4] py_compile 全部改造文件（FAIL 级）")
    checked, failures = check_compile()
    if failures:
        verdict_fail = True
        print("  FAIL: %d/%d 个文件编译失败:" % (len(failures), checked))
        for rel, err in failures:
            print("    - %s: %s" % (rel, err))
    else:
        print("  PASS: %d 个 py 文件全部编译通过" % checked)

    # --- 总结 ---
    print("\n" + "=" * 64)
    print("VERDICT=%s" % ("FAIL" if verdict_fail else "PASS"))
    print("说明：PASS 仅表示「地址宏化一致性 + 语法」过关，不改变门 FAIL / 对手真实性")
    print("      0/9 / 零注入 CROSSED 唯一裁决；不代表联机成功。")
    print("=" * 64)
    return 1 if verdict_fail else 0


if __name__ == "__main__":
    sys.exit(main())
