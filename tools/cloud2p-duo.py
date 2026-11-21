#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""双 PC 实例云端 2P 联机闭环驱动（path A / path B 通用）。

用途
----
把「两个 PC 实例各自跑一个 GBoy 掌机、连同一个云端房间、按键由脚本注入、
全程采样 SIO / gLink / 帧率」这件事变成一条**可重复**的命令，并给出
**可判读**的落盘证据。

为什么要有这个脚本（2026-11-16 接手复盘）
----------------------------------------
早先的驱动脚本只活在 .zcode-tmp/（不进仓库），且**没有钉死联机模式**：
环境里残留 `MGBAX_OFFICIAL_LINK=1`（或 `MGBAX_LINK_MODE=B`）时，
`CloudLink` 构造器会把 `m_modeOverride` 置成 B，于是 **2 人房也走 path B**
（4 核本机房间 + 网络只传按键）。现场表现与 path A 完全不同：

  * path B 会创建 3 个镜像核 ⇒ `<scriptDir>/nav_at` 被写出来 ⇒ 可见核的
    按键改由 busgame 导航接管（`ScriptedControl::poll()` 里 nav_at 优先于
    `<dir>/keys`）；
  * path B 下可见核**不会**产生 SIO MULTI 轮次（`[diag] mu=0`），
    因为 MULTI 走的是本机环回总线而不是 SIO 包中继。

也就是说：那一轮「lstate=2 / pc=0 / 没到 LINKUP」的读数**不能**用来判断
path A 的握手是否正常 —— 它压根不是 path A。本脚本把模式**显式钉死并记录
协商结果**，避免再次踩这个坑。

约束
----
* A = `rom.gba` / `rom.sav`，B = `rom_b.gba` / `rom_b.sav`（两个实例绝不同
  ROM，避免共用 .sav 把存档写坏）。
* 每侧独立 `TEMP`，`%TEMP%/mgba_sio.log` 才不会互相覆盖，`[diag]` 行才能
  归属到具体实例。
* 只 kill 本脚本自己记下的 PID，绝不 `taskkill /IM`（同机可能还有别的实例）。

用法
----
    python tools/cloud2p-duo.py --preflight          # 起跑前查构建锁 / 残留进程
    python tools/cloud2p-duo.py --tag PA-DUO --mode A --runsec 420 --nav
    python tools/cloud2p-duo.py --tag PB-DUO --mode B --runsec 150 --nav
    python tools/cloud2p-duo.py --print-cross-device-cmd   # 打印真跨设备命令

`--mode` 显式钉死联机模式（A / B / AUTO，AUTO 也会写 `MGBAX_LINK_MODE=AUTO`
让两端按房间人数解析：2P→A、3/4P→B）。脚本另外记录**实际协商到的**模式
（mode_negotiated_A/B），避免环境残留把 2 人房悄悄拽成 path B。

拓扑与证据口径（务必分清）
----
* 本脚本默认跑 `(a)`：**同一台机器上的两个 PC 实例经 P2P 直连**，两端各用
  独立 TEMP / keys_dir。这是**快速本地代理（PROXY）**，不是跨设备 E2E：
  `summary.txt` 会写 `topology=p2p` 与 `scope=PROXY-2PC`。
* `(b)` 真跨设备 PC ↔ Android AVD（或真机）走 `tools/cloud2p_avd.py`：
  `summary.txt` 会写 `topology=avd` 与 `scope=CROSS-DEVICE`（或 `REAL-DEVICE`）。
  只有后者的 BATTLE=YES 才可作为「跨设备 2P 闭环」证据。
* 成功判据**不是** `linkup=1`（那是菜单 A 键留下的 gSpecialVar_Result 残留值，
  ADR-003 §4.2(h.5)）：真成功 = `lstate==4 && pc==2 && st 含 MASTER(0x20)`
  稳定 `--stable-sec` 秒（从机侧无 MASTER 位，故主/从任一侧有该位即可，
  两侧 lstate/pc 都必须到位）。BATTLE=YES 还要求两端 cb2 都落进动态解析的
  battle_main.o .text 窗口。
"""

import argparse
import ctypes
import os
import re
import shutil
import subprocess
import sys
import time
from ctypes import wintypes as wt

import gba_addrs as gba  # 统一地址宏（AGENTS §5，三端同名同值）

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
BASE = os.path.join(ROOT, ".zcode-tmp", "cloud2p")
EXE = os.path.join(ROOT, "build-win", "dist", "mGBA.exe")
# 2026-11-17 关键：仓库根 rom.gba 已被重建成 md5=5038…（新构建），而唯一
# 证明过 4 核能进对战的是 .zcode-tmp/busgame-run/rom.gba（md5=f7886…）。
# 允许用环境变量钉死 ROM；path B 两端都会用 ROM_A 的内容。
ROM_A = os.environ.get("MGBAX_ROM_A", os.path.join(ROOT, "rom.gba"))
ROM_B = os.environ.get("MGBAX_ROM_B", os.path.join(ROOT, "rom_b.gba"))
ACC_A = "525612743@qq.com:14855735"
ACC_B = "zx14855734@gmail.com:14855735"
K = {"A": 1, "B": 2, "START": 8, "R": 16, "L": 32, "U": 64, "D": 128}
# boot 判定用的 CB2_Overworld 地址。ROM 每次重建都会平移，写死必然假阴性
# （实测旧 0816F9C5 → 新 081897B0）。启动时从与 ROM 同构建的 rom.elf 自动解析；
# 找不到就退回 px/py 判定（boot() 里那条 or 分支）。
def _resolve_iwram_delta(rom_path):
    """从 ROM 字面量算 IWRAM delta（与 C 侧 SIOROM 同判据）：
    找 R 与 R+0x66 同时出现的地址，最高频者即 gRecvCmds；
    delta = (R+0xAA) - 0x03002AF4(=旧基准 gLink)。"""
    try:
        data = open(rom_path, "rb").read()
    except OSError:
        return None
    import struct as _struct
    cnt = {}
    for off in range(0, len(data) - 4, 4):
        v = _struct.unpack_from("<I", data, off)[0]
        if gba.IWRAM_LO <= v < gba.IWRAM_HI:
            cnt[v] = cnt.get(v, 0) + 1
    bestR, bestScore = 0, 0
    for r, c in cnt.items():
        c2 = cnt.get(r + gba.IWRAM_SPACING, 0)
        score = min(c, c2)
        if score > bestScore:
            bestScore, bestR = score, r
    if bestR == 0 or bestScore < 4:
        return None
    delta = (bestR + gba.GLINK_OFFSET) - gba.SIO_GLINK_BASE
    return delta & 0xFFFFFFFF

def _resolve_game_cb2():
    import re as _re, os as _os
    elf = os.path.join(ROOT, "rom.elf")
    if not os.path.exists(elf):
        return None
    try:
        out = subprocess.check_output(
            [r"C://msys64//clang64//bin//arm-none-eabi-nm.exe", "--defined-only", elf],
            stderr=subprocess.DEVNULL, text=True, timeout=30)
        m = _re.search(r"^([0-9a-fA-F]{8})\s+T\s+CB2_Overworld\s*$", out, _re.M)
        if m:
            return "%08x" % (int(m.group(1), 16) | 1)   # [room] 打印带 thumb 位
    except Exception:
        pass
    return None

# 切 ROM 基线时（例如已知良好 f7886…）必须同步覆盖 CB2_Overworld：
# 它是从 ROOT/rom.elf 解析的，换 ROM 后会与新构建不一致 ⇒ boot 永远判「开机中」。
GAME_CB2 = os.environ.get("MGBAX_GAME_CB2") or _resolve_game_cb2() or "081897b0"


def resolve_battle_window():
    """「进对战」判据窗口：优先 MGBAX_GBOY_BATTLE_LO/HI；否则从 rom.map 里
    动态解析 `battle_main.o .text`（与 gboylink_test.cpp 的 resolveBattleWindow
    同口径）。写死绝对地址必然因 ROM 重编译平移而假阴性，见 MEMORY.md §2。
    返回 (lo, hi, source)；解析不到返回 (0, 0, "UNKNOWN")。"""
    lo_s = os.environ.get("MGBAX_GBOY_BATTLE_LO")
    hi_s = os.environ.get("MGBAX_GBOY_BATTLE_HI")
    if lo_s and hi_s:
        try:
            return int(lo_s, 16), int(hi_s, 16), "ENV"
        except ValueError:
            pass
    # 5fb345c8e 教训：实际执行的是仓库 rom.gba（md5 5038022...），不是 D:/gen8 重编译版。
    # D:/gen8/rom.map 给出的 battle_main.o .text=[0x080B7FB0,0x080C1968) 与实际
    # BattleMainCB2=0x080B4844 不符 → 真进战斗却被判 BATTLE=NO。必须优先仓库 rom.map。
    for mp in (os.path.join(ROOT, "rom.map"), "D:/gen8/rom.map",
               os.path.join(ROOT, ".zcode-tmp", "busgame-run", "rom.map")):
        if not os.path.exists(mp):
            continue
        try:
            text = open(mp, "r", encoding="utf-8", errors="replace").read()
        except OSError:
            continue
        m = re.search(
            r"^\s*\.text\s+(?:0x)?([0-9A-Fa-f]{6,8})\s+(?:0x)?([0-9A-Fa-f]+)\s+\S*battle_main\.o\b",
            text, re.M)
        if m:
            start = int(m.group(1), 16)
            size = int(m.group(2), 16)
            return start, start + size, os.path.basename(mp)
    return 0, 0, "UNKNOWN"


class StateDebounce:
    """菜单状态去抖（ADR-003 §4.2(h.5) 的正解）：
    同一个状态签名必须**连续稳定** stable_s 秒、且距上次放行至少 cooldown_s
    才放行一次；签名一变立即重新开始计时。替代「每次 diag poll 都按 A」的
    震荡写法，避免 `l=2 menu=w2`→A→`l=1 menu=w0`→`l=2` 横跳。"""

    def __init__(self, stable_s=2.0, cooldown_s=5.0):
        self.stable_s = stable_s
        self.cooldown_s = cooldown_s
        self.key = None
        self.since = 0.0
        self.fired = {}

    def ready(self, key):
        now = time.time()
        if key != self.key:
            self.key, self.since = key, now
            return False
        if now - self.since < self.stable_s:
            return False
        if now - self.fired.get(key, 0.0) < self.cooldown_s:
            return False
        self.fired[key] = now
        self.since = now          # 同签名下一次放行要再稳定一轮
        return True


class BattleTrack:
    """采样两端 cb2 是否落进 battle_main.o .text 窗口，做 BATTLE 判据。"""

    def __init__(self, lo, hi):
        self.lo, self.hi = lo, hi
        self.hits = 0
        self.last_a = self.last_b = ""

    def note(self, a, b):
        oa, ca = a.in_battle(self.lo, self.hi)
        ob, cb = b.in_battle(self.lo, self.hi)
        if oa:
            self.last_a = ca
        if ob:
            self.last_b = cb
        both = oa and ob
        if both:
            self.hits += 1
        return both


def kv(line):
    """把空格分隔的 `key=value` 机器可读日志行拆成字典。"""
    d = {}
    for tok in line.split():
        if "=" in tok:
            k, _, v = tok.partition("=")
            d[k.strip()] = v.strip()
    return d


def judge_side(diag):
    """**唯一**的联机成功判据（Agent 15 TRAP-SCAN J1–J4）：
    gLink.state==4 && playerCount==2 && gLinkStatus 含 MASTER(0x20)。

    返回 (l4pc2, master)。`gSpecialVar_Result`（[diag] linkup=1）是菜单 A 键
    留下的残留值（role=im0/lid0/hs0, st=0），只能当诊断字段，**绝不能**用作
    is_l / success_now / linkup_stable / 按键时机 / summary 的绿灯。
    """
    try:
        l4pc2 = int(diag.get("lstate", 0)) == 4 and int(diag.get("pc", 0)) == 2
    except ValueError:
        l4pc2 = False
    try:
        master = bool(int(diag.get("st", "0"), 16) & 0x20)
    except ValueError:
        master = False
    return l4pc2, master


CROSS_DEVICE_CMD = """\
# ===== 真跨设备 2P（PC ↔ Android AVD/真机）：两个硬前提 =====
# ① 两端不同账号；② 两端不同 game uuid（uuid = "BPEE," + ROM md5）。
#    PC 用改 1 字节填充的 D:/gen8/rom_b.gba + rom_b.sav，app 用原始 rom.gba。
# ③ 启动时序：先起 app（CLOUD 广播不带 room = host），等 logcat 出现
#    `advertised relay <ip:port> for room <R>`，读出 R；再起 PC 带房间 R。
#    之后别重启 app（重启会 leave_room 解散房间），重启 PC 无影响。
#
# 终端 1 —— AVD（ANDROID_AVD_HOME=D:\\avd-home\\avd）：
python tools/cloud2p_avd.py --tag XDEV1 --mode A --runsec 420 \\
    --app-user <app账号> --app-pass <app密码> --pc-acc <pc账号>:<pc密码>
# 若 AVD 已在跑：加 --no-emulator；若要指定房间：加 --room <R>（此时 PC 为 join）。
# 真机：把 --avd 换成设备序列号并加 --no-emulator，先 adb devices 确认。
#
# 快速本地代理（PROXY，不是跨设备！等价同机双 PC 实例）：
python tools/cloud2p-duo.py --tag PA-DUO --mode A --runsec 420 --nav
"""


u = ctypes.windll.user32
EnumProc = ctypes.WINFUNCTYPE(wt.BOOL, wt.HWND, wt.LPARAM)


def fps_by_pid():
    """按 PID 取窗口标题里的实时 fps —— 同时也是「进程还活着」的手段。"""
    out = {}

    def cb(h, _l):
        if not u.IsWindowVisible(h):
            return True
        n = u.GetWindowTextLengthW(h)
        if n == 0:
            return True
        buf = ctypes.create_unicode_buffer(n + 1)
        u.GetWindowTextW(h, buf, n + 1)
        if "mGBA" not in buf.value:
            return True
        pid = wt.DWORD(0)
        u.GetWindowThreadProcessId(h, ctypes.byref(pid))
        m = re.search(r"\(([0-9.]+) fps\)", buf.value)
        out[int(pid.value)] = float(m.group(1)) if m else None
        return True

    u.EnumWindows(EnumProc(cb), 0)
    return out


def grab_win(inst, outpath):
    """抓这个实例的 mGBA 窗口画面。看不到画面时只记一行日志，绝不抛。"""
    try:
        sys.path.insert(0, os.path.join(ROOT, "tools"))
        import win_shot
        h = win_shot.by_pid(inst.pid)
        if not h:
            return None
        return win_shot.grab(h, outpath)
    except Exception as ex:            # noqa: BLE001
        print("  !! 截图失败(%s): %s" % (inst.name, ex))
        return None


class Inst:
    def __init__(self, name, tmp, keys_dir, nav_on=False):
        self.name, self.tmp, self.keys_dir = name, tmp, keys_dir
        self.nav_on = nav_on
        self.sio = os.path.join(tmp, "mgba_sio.log")
        self.lobby = os.path.join(tmp, "mgba_lobby_debug.log")
        self.proc = self.pid = None
        os.makedirs(keys_dir, exist_ok=True)
        os.makedirs(tmp, exist_ok=True)

    def key(self, mask):
        with open(os.path.join(self.keys_dir, "keys"), "w") as f:
            f.write(str(mask))

    def drop_nav(self):
        """撤掉 nav_at，把按键控制权交还给 <dir>/keys。
        ScriptedControl::poll() 里 nav_at 优先于 keys，导航在「走位 + 选模式」
        阶段是必须的；但它不负责 linkup 确认，而 tap() 在 nav_on 时是空操作，
        于是「请稍候」阶段没人按 A，帧数白烧，最后撞上 TryLinkTimeout 的
        600 帧预算 ⇒ LINKUP_CONNECTION_ERROR(6) ⇒ special CloseLink。"""
        try:
            os.remove(os.path.join(self.keys_dir, "nav_at"))
            # 必须同步清掉 nav_on：tap() 一开始就按这个标志提前返回，不清掉
            # 的话即使 nav_at 已删、keys 已能生效，本脚本自己也还是空按。
            self.nav_on = False
            return True
        except OSError:
            return False

    def tap(self, mask, hold=0.22, gap=2.0):
        if self.nav_on:
            # 导航已接管按键（ScriptedControl::poll 里 nav_at 优先于 <dir>/keys），
            # 这里再写 keys 是白写，只会掩盖「导航到底走到哪了」。
            time.sleep(min(gap, 0.5))
            return
        self.key(mask)
        time.sleep(hold)
        self.key(0)
        time.sleep(gap)

    def alive(self):
        return self.proc is not None and self.proc.poll() is None

    def text(self, path):
        try:
            with open(path, "r", encoding="utf-8", errors="replace") as f:
                return f.read()
        except OSError:
            return ""

    def diag(self):
        for line in reversed(self.text(self.sio).splitlines()):
            if "[diag]" in line:
                d = {}
                for k in ("lstate", "pc", "px", "py", "menu", "mt", "mid", "cb",
                          "st", "brs", "linkup", "ltype", "intr", "mu", "rem"):
                    m = re.search(r"\b" + k + r"=([^\s]+)", line)
                    if m:
                        d[k] = m.group(1)
                return d
        return {}

    def cb2(self):
        for line in reversed(self.text(self.sio).splitlines()):
            if "[room]" in line:
                m = re.search(r"cb2=([0-9A-Fa-f]+)", line)
                if m:
                    return m.group(1)
        return ""

    def multi(self):
        for line in reversed(self.text(self.sio).splitlines()):
            if line.startswith("SIO multi"):
                return line.strip()
        return ""

    def rtt(self):
        for line in reversed(self.text(self.lobby).splitlines()):
            if "[sio-rtt]" in line:
                return line.strip()
        return ""

    def negotiated_mode(self):
        """从大厅日志里取**实际协商到的**模式。

        path A ⇒ 「联机模式协商通过：A…」，path B ⇒ 「…：B…」。
        取最后一条（每轮连接会重新协商一次）。
        """
        # Agent 3 的 [MGBAX_PATH] 是 negotiateLinkMode() 里写的权威协商结果。
        p = self.mgbx_path().get("mode", "")
        if p in ("A", "B"):
            return p
        pat = re.compile(r"协商通过：([AB])")
        found = ""
        for line in self.text(self.lobby).splitlines():
            m = pat.search(line)
            if m:
                found = m.group(1)
        return found

    def official_mode(self):
        """path B 才有的痕迹：官方镜像联机（创建镜像核）。"""
        v = self.mgbx_path().get("officialMode", "")
        if v in ("0", "1"):
            return v == "1"
        for line in reversed(self.text(self.lobby).splitlines()):
            if "官方镜像联机" in line:
                return True
        return False

    def fps(self):
        """窗口标题里的实时 fps —— 判断「联机掉帧」的唯一直接读数。"""
        try:
            return fps_by_pid().get(self.pid)
        except Exception:              # noqa: BLE001
            return None

    def lstate_pc(self):
        d = self.diag()
        try:
            return int(d.get("lstate", 0)), int(d.get("pc", 0))
        except ValueError:
            return 0, 0

    def st_master(self):
        """gLinkStatus 的 LINK_STAT_MASTER(0x20)：选举阶段「主机已发起」位。"""
        try:
            return bool(int(self.diag().get("st", "0"), 16) & 0x20)
        except ValueError:
            return False

    def in_battle(self, lo, hi):
        """cb2（gMain.callback2）或 gLinkCallback 落进 battle_main.o .text 窗口。"""
        if not lo or not hi:
            return False, ""
        for v in (self.cb2(), self.diag().get("cb", "")):
            try:
                addr = int(v, 16)
            except (ValueError, TypeError):
                continue
            if lo <= addr < hi:
                return True, v
        return False, ""

    def bus_identity(self):
        """本机 4 核总线的实例身份：LocalBus 用时间戳 key（天然每实例独立）；
        TCP 对照分支走 18781..18788 扫描（A 先占 18781，B 顺延 18782）。"""
        for line in reversed(self.text(self.lobby).splitlines()):
            m = re.search(r"\[arm\] local SIO (bus|lockstep) key=(\d+) players=(\d+)", line)
            if m:
                return "%s:key=%s" % (m.group(1), m.group(2))
        return "-"

    def via(self):
        # 优先 Agent 3 的建链结论行、Agent 8 的 diagnosticsText，再退回旧文本。
        for src in (self.p2p_result().get("via"), self.p2p_diag().get("via")):
            if src in ("p2p", "tunnel"):
                return src
        t = self.text(self.lobby)
        if re.search(r"\[sio-rtt\][^\n]*\bvia=p2p\b", t) or "直连加速已启用" in t:
            return "p2p"
        return "tunnel"

    def path(self):
        p = self.mgbx_path().get("path", "")
        if p in ("A", "B"):
            return p
        return self.negotiated_mode() or "-"

    def peer_candidates(self):
        """对端候选公告是否落地（F6/F7 修复的观测点）。

        优先读 Agent 3/8 新增的结构化行：
          [MGBAX_P2P] ... peerCandidates=0|1 peerCandidateCount=N ...
          [direct] P2P 已启用 via=p2p avg=15ms peerCandidates=3 direct=1 ...
        旧版只有中文 `[direct] 对端候选` 时退回文本匹配。
        """
        r = self.p2p_result()
        cnt = r.get("peerCandidateCount")
        if cnt and cnt.isdigit():
            return int(cnt) > 0
        flag = r.get("peerCandidates")
        if flag in ("0", "1"):
            return flag == "1"
        d = self.p2p_diag()
        if d.get("peerCandidates", "").isdigit():
            return int(d["peerCandidates"]) > 0
        for line in self.text(self.lobby).splitlines():
            if "[direct]" in line and "对端候选" in line and "无候选地址" not in line:
                return True
        return False

    def p2p_result(self):
        """Agent 3：每次建链尝试收尾都会写一条 [MGBAX_P2P] event=result。"""
        for line in reversed(self.text(self.lobby).splitlines()):
            if "[MGBAX_P2P]" in line and "event=result" in line:
                d = kv(line)
                return {"result": d.get("result", "-"),
                        "peerCandidates": d.get("peerCandidates", "-"),
                        "peerCandidateCount": d.get("peerCandidateCount", "-"),
                        "localCandidates": d.get("localCandidates", "-"),
                        "directEnabled": d.get("directEnabled", "-"),
                        "via": d.get("via", "-")}
        return {}

    def p2p_diag(self):
        """Agent 8：DirectLink::diagnosticsText() 的 via/avg/peerCandidates/direct/peer。"""
        for line in reversed(self.text(self.lobby).splitlines()):
            if ("[direct] P2P 已启用" in line or "[direct] p2p-rtt" in line) and "via=" in line:
                d = kv(line)
                if "via" in d:
                    return d
        return {}

    def mgbx_path(self):
        """Agent 3：协商完成后写 [MGBAX_PATH] path=A|B mode=A|B officialMode=0|1。"""
        for line in reversed(self.text(self.lobby).splitlines()):
            if "[MGBAX_PATH]" in line and "path=" in line and "event=" not in line:
                d = kv(line)
                if "path" in d:
                    return d
        return {}

    def mgbx_gate(self):
        """Agent 3：环境变量门的实际取值（驱动钉死模式后可据此反查）。"""
        for line in reversed(self.text(self.lobby).splitlines()):
            if "[MGBAX_GATE]" in line:
                return kv(line)
        return {}

    def stdout_text(self):
        path = getattr(self, "stdout", "")
        return self.text(path) if path else ""

    def bus2p_diag(self):
        """Agent 7：MGBAX_LOCALBUS_DIAG=1 时 link_net.c 打在 stderr 的总线快照。
        2P fallback 的 go/no-go：players=2 / attached>=2 / slave slot=1。"""
        out = {"players": "-", "attached": "-", "slot": "-",
               "idx": "-", "hostIdx": "-", "key": "-"}
        for line in self.stdout_text().splitlines():
            if "LOCALBUS host " in line:
                d = kv(line)
                for k in ("key", "idx", "players", "attached"):
                    out[k] = d.get(k, "-")
            elif "LOCALBUS slave " in line:
                d = kv(line)
                for k in ("slot", "myIdx", "hostIdx"):
                    out[k] = d.get(k, "-")
        return out

    def rearm_hs(self):
        """Agent 1：[rearm] fired/round 行里 hs=1 的计数（证明每轮补了 handshakeAsMaster）。"""
        fired = hs1 = rounds = 0
        for line in self.text(self.sio).splitlines():
            if "[rearm] fired" in line:
                fired += 1
                if re.search(r"\bhs=1\b", line):
                    hs1 += 1
            elif "[rearm] round" in line:
                rounds += 1
                if re.search(r"\bhs=1\b", line):
                    hs1 += 1
        return {"fired": fired, "hs1": hs1, "rounds": rounds}

    def fast_align_blocked(self):
        """Agent 1：从机快帧因两端 idx 未对齐而挡下的轮次（最大值）。"""
        n = 0
        for line in self.text(self.sio).splitlines():
            if "slave fast align gate blocked" in line:
                m = re.search(r"\bn=(\d+)", line)
                if m:
                    n = max(n, int(m.group(1)))
        return n

    def bad_checksum_count(self):
        """统计 [diag] st= 里 badChecksum(0x2000) 出现的行数（应恒为 0）。"""
        cnt = 0
        for line in self.text(self.sio).splitlines():
            if "[diag]" not in line:
                continue
            m = re.search(r"\bst=([0-9A-Fa-f]+)", line)
            if m:
                try:
                    if int(m.group(1), 16) & 0x2000:
                        cnt += 1
                except ValueError:
                    pass
        return cnt

    def snap(self):
        d = self.diag()
        f = self.fps()
        return "%s l=%s pc=%s mu=%s rem=%s brs=%s fps=%s px=%s py=%s menu=%s mt=%s mid=%s cb=%s" % (
            self.name, d.get("lstate", "-"), d.get("pc", "-"), d.get("mu", "-"),
            d.get("rem", "-"), d.get("brs", "-"), ("%.1f" % f) if f else "-",
            d.get("px", "-"), d.get("py", "-"),
            d.get("menu", "-"), d.get("mt", "-"), d.get("mid", "-"), d.get("cb", "-"))


def main():
    # Windows 控制台默认 GBK，日志里的「⇒」「��」等非 GBK 字符会让
    # print 直接抛 UnicodeEncodeError 把整轮驱动打断（实测已踩）。
    try:
        sys.stdout.reconfigure(encoding="utf-8", errors="replace")
        sys.stderr.reconfigure(encoding="utf-8", errors="replace")
    except Exception:
        pass
    ap = argparse.ArgumentParser()
    ap.add_argument("--tag", default="DUO")
    ap.add_argument("--mode", default="AUTO", choices=["AUTO", "A", "B"],
                    help="钉死联机模式：AUTO=按人数自动（2P→A），A/B=显式")
    ap.add_argument("--runsec", type=int, default=420)
    ap.add_argument("--nav", action="store_true",
                    help="给可见核装上内存驱动导航（写 <scriptDir>/nav_at）。"
                         "只在 path A 用：path A 没有镜像核，CloudLink 不会写 "
                         "nav_at，可见核的按键只能靠盲按 <dir>/keys；装上导航后"
                         "由 gLink/菜单内存状态驱动（见 mgba_mobile.c 的 "
                         "mgbaMobileBusGameNavKeys）。path B 下 nav_at 由 "
                         "CloudLink 在三个镜像核就绪后才写，提前写会让四核相位错开。")
    ap.add_argument("--sav", default="D:/gen8/rom.sav",
                    help="每轮起跑用的「已知良好」存档母本（默认 D:/gen8/rom.sav）。"
                         "**必须**每轮用干净副本：游戏退出时会把内存里的存档写回"
                         "<rom>.sav，于是仓库里的 rom.sav 每轮都在漂 —— 导航的"
                         "盲按 A 落到哪个菜单取决于存档里的位置，所以同一套参数"
                         "这一轮能进联机、下一轮就停在柜台（11-16 实测过这种漂移）。")
    ap.add_argument("--no-rearm", action="store_true",
                    help="关闭 MGBAX_LINK_REARM（默认开）。path A 握手**必须**有它："
                         "25dc57dea 把每轮补 gLink.handshakeAsMaster 的逻辑挂在"
                         "MGBAX_LINK_REARM 门后，关掉后主机永远只发 0xB9A0、"
                         "不发 0x8FFF，对端 DoHandshake 收尾条件永不成立。留作 A/B 对照。")
    ap.add_argument("--fast-early", action="store_true",
                    help="把 MGBAX_FAST_MIN_OK 降到 8，让快帧在握手成功(lstate=4 pc=2)"
                         "后立即生效，而非等 sioOk>=256。PHASE3 实测：path A 云端握手在"
                         "n≈34 达成，但要在 n>=256 才开快帧，这 220 轮走慢速网络往返"
                         "每帧 SIO 中断不足 9 次 → LAG_MASTER(0x10000) → CheckErrorStatus"
                         "拆链。默认关（原行为 256）；开它验证能否救回链路。")
    ap.add_argument("--fast-min-ok-slave", type=int, default=None,
                    help="设 MGBAX_FAST_MIN_OK_SLAVE（默认不设=C 侧 256）。Agent 1 的从机快帧门；"
                         "云端可设 8 让从机尽早放行。")
    ap.add_argument("--fast-slave-align", type=int, default=None,
                    help="设 MGBAX_FAST_SLAVE_ALIGN（默认不设=C 侧 0=关闭）。Agent 1：从机快帧"
                         "要求 |hostIdx-slaveIdx| <= N 才放行，杜绝复用旧字导致 badChecksum(0x2000)。"
                         "典型值 4。")
    ap.add_argument("--fast-align", action="store_true",
                    help="一键组合：MGBAX_FAST_MIN_OK=8 + MGBAX_FAST_MIN_OK_SLAVE=8 + "
                         "MGBAX_FAST_SLAVE_ALIGN=4（配合默认 MGBAX_LINK_REARM=1）。")
    ap.add_argument("--topology", default="p2p", choices=["p2p", "avd"],
                    help="证据口径标签。p2p=同机双 PC 实例（PROXY，不是跨设备）；"
                         "avd=由 tools/cloud2p_avd.py 编排的 PC↔Android（CROSS-DEVICE）。"
                         "本脚本自身只驱动前者的两个 PC 实例。")
    ap.add_argument("--stable-sec", type=float, default=3.0,
                    help="真成功（lstate=4 && pc=2 && st含MASTER(0x20)）必须稳定的秒数"
                         "（默认 3s）。杜绝把瞬时 l=4 或 linkup=1 残留当成功。")
    ap.add_argument("--debounce-sec", type=float, default=2.0,
                    help="菜单状态去抖：同一状态签名需连续稳定多少秒才允许按一次 A"
                         "（默认 2s）。修 ADR-003 §4.2(h.5) 的按 A 震荡。")
    ap.add_argument("--preflight", action="store_true",
                    help="只查构建产物 / .ninja_lock / 残留 mGBA 进程后退出，不起实例。")
    ap.add_argument("--kill-all-mgba", action="store_true",
                    help="起跑前 taskkill /F /IM mGBA.exe。默认**不开**：同机可能有别的 "
                         "agent 的实例，默认只按本轮 pids.txt 里的 PID 精确清理。")
    ap.add_argument("--print-cross-device-cmd", action="store_true",
                    help="打印真跨设备（PC↔AVD/真机）的可复制命令与前提条件后退出。")
    ap.add_argument("--env", action="append", default=[], metavar="K=V",
                    help="额外环境变量（可重复）。用于不改脚本就做单变量对照，"
                         "例如 --env MGBAX_FAST_MIN_OK=8 --env MGBAX_FAST_MIN_OK_SLAVE=8")
    ap.add_argument("--pure-block", action="store_true",
                    help="关掉快帧与握手轮询（MGBAX_SIO_FAST=0, MGBAX_SIO_CONNECT_POLL=0），"
                         "回最原始的阻塞等真字路径：等待期冻结模拟时钟 ⇒ 每模拟帧仍 9 次"
                         "SIO 中断（不 LAG）、每轮真字（校验和自洽），代价是墙钟帧率低。"
                         "用于验证「链路本身能否走通并进对战」。")
    args = ap.parse_args()

    if args.print_cross_device_cmd:
        print(CROSS_DEVICE_CMD)
        return 0

    # ---------- 起跑前体检（构建锁 / 残留进程）----------
    locks = [p for p in (os.path.join(ROOT, "build-win", ".ninja_lock"),
                         os.path.join(ROOT, "build", ".ninja_lock"))
             if os.path.exists(p)]
    try:
        tl = subprocess.run(["tasklist", "/FI", "IMAGENAME eq mGBA.exe"],
                            capture_output=True, text=True).stdout
        running = re.findall(r"\bmGBA\.exe\s+(\d+)", tl)
    except Exception:                       # noqa: BLE001
        running = []
    print("[preflight] EXE=%s (%s)" % (EXE, "存在" if os.path.exists(EXE) else "缺失"))
    print("[preflight] .ninja_lock=%s  运行中的 mGBA PID=%s"
          % (locks or "无", running or "无"))
    if args.preflight:
        return 0 if (os.path.exists(EXE) and not locks and not running) else 1
    if args.kill_all_mgba and running:
        print("[preflight] --kill-all-mgba：taskkill /F /IM mGBA.exe")
        subprocess.run(["taskkill", "/F", "/IM", "mGBA.exe"], capture_output=True)
    elif running:
        print("[preflight] 注意：上面这些 PID 不是本轮 pids.txt 记下的，本脚本不会动它们；"
              "若要强制清场请显式加 --kill-all-mgba。")

    gdir = os.path.join(BASE, args.tag)
    SHOT = {}   # rem=1 现场只抓一次图
    os.makedirs(gdir, exist_ok=True)
    drv = open(os.path.join(gdir, "loop.log"), "w", encoding="utf-8")
    smp = open(os.path.join(gdir, "samples.log"), "w", encoding="utf-8")

    def log(msg):
        line = "[%s] %s" % (time.strftime("%H:%M:%S"), msg)
        print(line, flush=True)
        drv.write(line + "\n")
        drv.flush()

    # 只清理本脚本上一轮自己留下的 PID（绝不 taskkill /IM：同机还有别的线在跑实例）
    pidfile = os.path.join(gdir, "pids.txt")
    if os.path.exists(pidfile):
        for line in open(pidfile, "r", encoding="utf-8").read().split():
            if line.isdigit():
                subprocess.run(["taskkill", "/F", "/PID", line], capture_output=True)
    open(pidfile, "w", encoding="utf-8").close()
    time.sleep(0.5)
    time.sleep(1.5)
    for d in ("a_tmp", "b_tmp", "keys_a", "keys_b"):
        shutil.rmtree(os.path.join(gdir, d), ignore_errors=True)

    # path B 开机阶段不写 nav_at（见上方），因此 nav_on 也必须为 False，
    # 否则 tap() 开头的 `if self.nav_on: return` 会把 boot 的 A 键全吞掉。
    nav_at_boot = args.nav and args.mode != "B"
    a = Inst("A", os.path.join(gdir, "a_tmp"), os.path.join(gdir, "keys_a"), nav_at_boot)
    b = Inst("B", os.path.join(gdir, "b_tmp"), os.path.join(gdir, "keys_b"), nav_at_boot)
    # Agent 7 的 LOCALBUS 诊断写在 stderr（合进 stdout 日志），供 bus2p_diag() 解析。
    a.stdout = os.path.join(gdir, "a_stdout.log")
    b.stdout = os.path.join(gdir, "b_stdout.log")

    # ---- 每轮一份干净的 ROM + 存档副本 -------------------------------------
    # 为什么要复制 ROM：mGBA 按 <rom>.sav 读电池存档、游戏退出时写回同一个
    # <rom>.sav。两端必须各用各的 ROM（否则共用一个 .sav 会互相写坏），
    # 而且**每轮都要从同一份母本重来** —— 否则存档在轮次之间漂移，导航的
    # 盲按落到不同菜单，同一套参数时好时坏（11-16 实测：PA2/PA4 能进 state 2，
    # PA5~PA7 进不去，差别就是存档漂移）。
    rom_a = os.path.join(gdir, "rom_a.gba")
    rom_b = os.path.join(gdir, "rom_b.gba")
    if not os.path.exists(args.sav):
        log("FATAL: 找不到母本存档 %s" % args.sav)
        return 8
    # path B（本机多核 + 网络只传按键）靠 savestate 快照同步镜像核：
    # 两端镜像核的 code/数据量必须逐字节一致，否则 type-6 加载时被拒
    # （历史 9/14 轮 `TYPE_STATE rejected by mirror (code -5)`）。所以
    # --mode B 时两端**都用 ROM_A 的内容**（各自独立副本，.sav 不共用）。
    # path A 反过来必须不同 uuid（= 不同 ROM md5），否则服务器当同一玩家
    # 只回显自己，故仍用 ROM_B。
    rom_b_src = ROM_A if args.mode == "B" else ROM_B
    if args.mode == "B":
        log("path B：两端强制同一份 ROM（%s），避免镜像快照 -5 断链" % ROM_A)
    for src_rom, dst_rom in ((ROM_A, rom_a), (rom_b_src, rom_b)):
        if not os.path.exists(dst_rom):
            shutil.copyfile(src_rom, dst_rom)
        shutil.copyfile(args.sav, dst_rom[:-4] + ".sav")
    log("每轮 ROM/存档副本：%s / %s（母本 %s）" % (rom_a, rom_b, args.sav))

    a.key(0), b.key(0)
    # 【path B 修正】nav_at 在 ScriptedControl::poll() 里优先于 <dir>/keys。
    # 如果开机阶段就写死 "1500 2"，boot() 的 tap(A) 会被全部吞掉，游戏
    # 停在开机画面（px=0 py=0），而 CloudLink 随后又要自己写 nav_at
    # （CloudLink.cpp:2169，等三个镜像核就绪才写，保证四相同步）——
    # 两边冲突 ⇒ 实测 path B 两端都卡在"开机中"直到 FATAL。
    # 所以：path B 下**不在开机前写 nav_at**，先用 keys 把两端 boot 进游戏；
    # 镜像核就绪后由 CloudLink 自己写（那才是正确的四相同步时机）。
    if args.nav and args.mode != "B":
        # 「menuAt modeDowns」——与 tools/busgame-lockstep.sh 的
        # BUSGAME_MENU_AT=1500 / BUSGAME_MODE_DOWNS=2 同一套参数。
        for inst in (a, b):
            with open(os.path.join(inst.keys_dir, "nav_at"), "w") as f:
                f.write("1500 2")
        log("已给两端可见核装上内存驱动导航（nav_at = 1500 2）")
    elif args.nav and args.mode == "B":
        log("path B：开机阶段不写 nav_at（交给 CloudLink 在镜像核就绪后写，"
            "否则 tap(A) 被吞、卡在开机画面）")

    base = dict(os.environ)
    base.update({"MGBAX_SIO_LOG": "1", "MGBAX_LINK_DIAG": "1",
                 "MGBAX_DIRECT_LOCAL_FIRST": "1"})
    # 环境残留会把 2 人房悄悄拽进 path B（见文件头）。这里一律清干净，
    # 只保留显式 --mode 决定的那一个。
    base.pop("MGBAX_NO_DIRECT", None)
    base.pop("MGBAX_SIO_FAST", None)
    base.pop("MGBAX_OFFICIAL_LINK", None)
    base.pop("MGBAX_LINK_MODE", None)
    base.pop("MGBAX_NAV_AT", None)
    base.pop("MGBAX_NAV_DOWNS", None)
    if args.mode == "B":
        # Agent 7：让 link_net.c 打 LOCALBUS host/slave 收敛快照到 stdout 日志，
        # 驱动据此做 2P fallback 的 go/no-go 断言。
        base["MGBAX_LOCALBUS_DIAG"] = "1"
    # path A 握手必须每轮补 gLink.handshakeAsMaster，而那段逻辑挂在
    # MGBAX_LINK_REARM 门后（25dc57dea）。默认开；--no-rearm 仅作 A/B 对照。
    # 2026-11-17：Qt/mobile 产品默认已统一为开，这里 force-ON 幂等且一致。
    base.pop("MGBAX_LINK_REARM", None)
    if not args.no_rearm:
        base["MGBAX_LINK_REARM"] = "1"
    # path A 快帧门：主机 MGBAX_FAST_MIN_OK / 从机 MGBAX_FAST_MIN_OK_SLAVE /
    # 从机 idx 对齐窗 MGBAX_FAST_SLAVE_ALIGN（Agent 1，默认 0=关闭）。
    # --env K=V 在下面覆盖，便于单变量 A/B 对照。
    for k in ("MGBAX_FAST_MIN_OK", "MGBAX_FAST_MIN_OK_SLAVE", "MGBAX_FAST_SLAVE_ALIGN"):
        base.pop(k, None)
    fast_min = 8 if (args.fast_early or args.fast_align) else None
    fast_min_slave = args.fast_min_ok_slave
    fast_align = args.fast_slave_align
    if args.fast_align:
        fast_min_slave = fast_min_slave if fast_min_slave is not None else 8
        fast_align = fast_align if fast_align is not None else 4
    if fast_min is not None:
        base["MGBAX_FAST_MIN_OK"] = str(fast_min)
    if fast_min_slave is not None:
        base["MGBAX_FAST_MIN_OK_SLAVE"] = str(fast_min_slave)
    if fast_align is not None:
        base["MGBAX_FAST_SLAVE_ALIGN"] = str(fast_align)
    # --pure-block：关掉快帧与握手轮询，回到最原始的「阻塞等真字」路径。
    # 该路径等待期间冻结模拟时钟 ⇒ 每个模拟帧仍凑够 9 次 SIO 中断（不触发
    # LAG_MASTER/LAG_SLAVE），且每轮都是真字（校验和自洽）。代价是墙钟帧率
    # 掉到 RTT 决定的量级（≈9×RTT/帧）。用于验证「链路本身能不能通」。
    base.pop("MGBAX_SIO_CONNECT_POLL", None)
    base.pop("MGBAX_SIO_DELAY_N", None)
    if args.pure_block:
        base["MGBAX_SIO_FAST"] = "0"
        base["MGBAX_SIO_CONNECT_POLL"] = "0"
    for kv in args.env:
        k, _, v = kv.partition("=")
        if k:
            base[k.strip()] = v.strip()
            log("env 覆写：%s=%s" % (k.strip(), v.strip()))
    # AUTO 也显式写 "AUTO"：CloudLink 构造器把未知串解析成 UNKNOWN(=AUTO)，
    # 这样即使 QSettings 里留着上一次的 A/B 下拉框选择也不会偷偷生效。
    base["MGBAX_LINK_MODE"] = args.mode
    log("联机模式=%s(已钉死 MGBAX_LINK_MODE)  topology=%s  rearm=%s  "
        "fast_min_ok=%s fast_min_ok_slave=%s fast_slave_align=%s  "
        "pure_block=%s  sav母本=%s"
        % (args.mode, args.topology, "OFF" if args.no_rearm else "ON(每轮补 handshakeAsMaster)",
           base.get("MGBAX_FAST_MIN_OK", "<unset>"),
           base.get("MGBAX_FAST_MIN_OK_SLAVE", "<unset>"),
           base.get("MGBAX_FAST_SLAVE_ALIGN", "<unset>"),
           "ON(FAST=0,POLL=0 阻塞真字)" if args.pure_block else "OFF", args.sav))

    def env_for(inst, autolink):
        e = dict(base)
        e.update({"TEMP": inst.tmp, "TMP": inst.tmp, "MGBAX_SCRIPT_DIR": inst.keys_dir,
                  "MGBAX_AUTOLINK": autolink,
                  # 让模拟器自己扫 ROM 解析 IWRAM 偏移（不依赖 rom.map）
                  "MGBAX_ROM_PATH": os.path.join(gdir, "rom_a.gba" if inst is a else "rom_b.gba")})
        # 【path B 必须】CloudLink 只在 MGBAX_NAV_AT>0 时才写 nav_at（CloudLink.cpp:2164）。
        # 驱动原本 base.pop("MGBAX_NAV_AT") 清掉它、又不自己写 ⇒ 四核无导航、
        # 全停在柜台（PB10 现场）。path B 必须由 CloudLink 写（四相同步），
        # 所以用环境变量把参数还给它；nav_at 内容仍是 "1500 2"。
        if args.mode == "B" and args.nav:
            e["MGBAX_NAV_AT"] = "1500"
            e["MGBAX_NAV_DOWNS"] = "2"
            # native 导航层的 0x0300 地址是写死旧构建的，必须告知 delta
            d = _resolve_iwram_delta(os.path.join(gdir, "rom_a.gba" if inst is a else "rom_b.gba"))
            if d is not None:
                e["MGBAX_IWRAM_DELTA"] = "0x%X" % d
                log("%s IWRAM delta=0x%X（native 导航层）" % (inst.name, d))
        return e

    def note_pid(inst):
        with open(pidfile, "a", encoding="utf-8") as f:
            f.write("%d\n" % inst.proc.pid)

    t0 = time.time()
    log("== 启动 A (rom.gba)  mode=%s" % args.mode)
    a.proc = subprocess.Popen([EXE, rom_a], cwd=ROOT, env=env_for(a, ACC_A),
                              stdout=open(os.path.join(gdir, "a_stdout.log"), "w"),
                              stderr=subprocess.STDOUT)
    a.pid = a.proc.pid
    note_pid(a)
    room = None
    tq = time.time()
    while time.time() - tq < 120:
        if not a.alive():
            log("FATAL: A 退出")
            return 3
        m = re.search(r"房号 (\d+)", a.text(a.lobby))
        if m:
            room = m.group(1)
            break
        time.sleep(1.0)
    if not room:
        log("FATAL: 无房号")
        return 4
    log("A pid=%d 房号=%s (%.0fs)" % (a.pid, room, time.time() - tq))

    log("== 启动 B (rom_b.gba)")
    b.proc = subprocess.Popen([EXE, rom_b], cwd=ROOT, env=env_for(b, ACC_B + ":" + room),
                              stdout=open(os.path.join(gdir, "b_stdout.log"), "w"),
                              stderr=subprocess.STDOUT)
    b.pid = b.proc.pid
    note_pid(b)

    # ---------- 采样 ----------
    def sample(tag):
        fps = fps_by_pid()
        da, db = a.diag(), b.diag()
        ma, mb = a.multi(), b.multi()

        def w(line):
            m = re.search(r"wait=([\d/]+ms)", line)
            return m.group(1) if m else "-"

        smp.write("%s %s A=%s B=%s | A %s | B %s | waitA=%s waitB=%s\n" % (
            time.strftime("%H:%M:%S"), tag, fps.get(a.pid), fps.get(b.pid),
            a.snap(), b.snap(), w(ma), w(mb)))
        smp.flush()
        return fps

    # ---------- 开机到游戏内（两端同一套序列，禁用 START） ----------
    # START 一旦在游戏内按下就会打开暂停菜单，继续按 A 就会选到「图鉴」。
    # 开机阶段一律只按 A：标题画面 A 也能进主菜单，主菜单第一项是「继续游戏」。
    def boot(side, tag, timeout=150):
        t = time.time()
        last = ""
        while time.time() - t < timeout:
            if not side.alive():
                log("FATAL: %s 进程没了" % tag)
                return False
            d = side.diag()
            # path B 下可见核 SIO 走镜像核、gSaveBlock1Ptr 的主循环位置可能
            # 不更新（px/py 恒 0），但 cb2 已是 CB2_Overworld ⇒ 实际已进游戏。
            # 所以：mode B 时**只认 cb2**，不看 px/py。
            # cb2() 从 [room] 读的是大写 hex，GAME_CB2 是小写 ⇒ 必须
            # casefold 后比较，否则明明在 CB2_Overworld 也判"开机中"。
            if side.cb2().lower() == GAME_CB2.lower() or (args.mode != "B" and
                                          d.get("px") == "10" and d.get("py") == "4"):
                log("%s 进游戏 cb2=%s px=%s py=%s (%.0fs)"
                    % (tag, side.cb2(), d.get("px"), d.get("py"), time.time() - t))
                return True
            snap = side.snap()
            if snap != last:
                last = snap
                log("  %s 开机中 | %s" % (tag, snap))
            side.tap(K["A"], gap=2.0)
        log("FATAL: %s 没进游戏 | %s" % (tag, side.snap()))
        return False

    if not boot(a, "A"):
        return 6
    if not boot(b, "B"):
        log("B 开机失败 | A=%s | B=%s" % (a.snap(), b.snap()))
        return 7
    log("两端开机完成 | A=%s | B=%s" % (a.snap(), b.snap()))

    # ---------- 逐侧闭环推进 ----------
    def at_w2(d):
        return "w2" in d.get("menu", "")

    it = 0
    linkup = None
    nav_leak = False
    # 每端是否已经拿到 keys 控制权（=已撤掉 nav_at）
    KCTL = {"a": False, "b": False}

    # ---- 去抖 + 真成功/对战判据（ADR-003 §4.2(h.5)）----
    NAV_DEB = StateDebounce(args.debounce_sec, cooldown_s=max(5.0, args.debounce_sec * 2))
    B_DEB = StateDebounce(args.debounce_sec, cooldown_s=max(5.0, args.debounce_sec * 2))
    ELEC_DEB = StateDebounce(args.debounce_sec, cooldown_s=max(5.0, args.debounce_sec * 2))
    LEAD_DEB = StateDebounce(args.debounce_sec, cooldown_s=max(5.0, args.debounce_sec * 2))
    B_LO, B_HI, B_SRC = resolve_battle_window()
    BTRACK = BattleTrack(B_LO, B_HI)
    log("对战判据窗口=[0x%X,0x%X) 来源=%s  stable=%.1fs  debounce=%.1fs"
        % (B_LO, B_HI, B_SRC, args.stable_sec, args.debounce_sec))
    stable_since = None
    linkup_stable = False
    success_seen = False
    battle_done = False

    def tap_pair(mask=1, hold=0.28, gap=1.0):
        """两端**同一瞬间**按下同一个键。
        游戏的时间单位是帧，而本机 path A 一帧要 9 个网络往返（~7fps），
        串行点按 1.2s ≈ 8 帧差；两端在游戏时间里差出十几帧，就会一端先起
        链路、另一端还在等 —— 先起的一端进 CONN_ESTABLISHED 后改发命令字，
        另一端永远等不到握手字，卡 state2 直到 TryLinkTimeout(600 帧) 判
        LINKUP_CONNECTION_ERROR 并拆链。成对按键把两端钉在同一帧上。"""
        if KCTL["a"]:
            a.key(mask)
        if KCTL["b"]:
            b.key(mask)
        time.sleep(hold)
        if KCTL["a"]:
            a.key(0)
        if KCTL["b"]:
            b.key(0)
        time.sleep(gap)

    deadline = time.time() + args.runsec
    while time.time() < deadline:
        if not (a.alive() and b.alive()):
            log("FATAL: 进程退出 A_rc=%s B_rc=%s" % (a.proc.poll(), b.proc.poll()))
            break
        fps = sample("loop")
        la, lb = a.lstate_pc(), b.lstate_pc()
        # 【Agent 15 J2 修正】mode B 也走与 path A **同一套** judge_side：
        # gLink.state==4 && pc==2 && st&MASTER(0x20)。原先 mode B 拿
        # gSpecialVar_Result==1 当「链路已建立」是陷阱（菜单 A 残留值）。
        da, db = a.diag(), b.diag()
        la_ok, ma = judge_side(da)
        lb_ok, mb = judge_side(db)
        is_l = (la_ok and ma) or (lb_ok and mb)
        # 一旦本端已经把链路开起来（lstate>=1），导航的「走位/选模式」使命
        # 就结束了，从这里起改由本脚本成对按 A —— 这是把两端的 linkup 确认
        # 钉在同一帧的唯一手段。
        # 【path B 绝不 drop_nav】path B 下 lstate=1 是可见核的常态（不走 SIO），
        # 旧逻辑一看到 lstate>=1 就 drop_nav() 删掉 nav_at —— 而那份 nav_at 是
        # CloudLink 在"三个镜像核 LINK_CONNECTED"后写的四相同步起跑信号。
        # 删掉它 ⇒ 可见核导航停在柜台、3 个镜像核继续跑 ⇒ 四核状态分叉 ⇒
        # 游戏内联机永远走不完（PB9 现场：两端 linkup=1 但都停在 px=10,4）。
        # path B 的导航全程由 CloudLink/ScriptedControl 管理，本脚本不插手。
        if args.nav and args.mode != "B":
            if not KCTL["a"] and la[0] >= 1:
                a.drop_nav()
                KCTL["a"] = True
                log("A lstate=%s ⇒ 撤掉 nav_at，交还 keys 控制" % la[0])
            if not KCTL["b"] and lb[0] >= 1:
                b.drop_nav()
                KCTL["b"] = True
                log("B lstate=%s ⇒ 撤掉 nav_at，交还 keys 控制" % lb[0])
        # path B 的镜像核就绪后会写 <scriptDir>/nav_at，可见核的按键改由
        # busgame 导航接管 —— 那一轮之后 <dir>/keys 就失效了，脚本必须知情。
        # 注意：--nav 时 nav_at 是本脚本自己写的，不算「泄漏」。
        if not args.nav and (os.path.exists(os.path.join(a.keys_dir, "nav_at")) or
                             os.path.exists(os.path.join(b.keys_dir, "nav_at"))):
            if not nav_leak:
                nav_leak = True
                log("!! 出现 nav_at ⇒ 本轮走的是 path B（镜像核接管了按键），"
                    "本脚本的 <dir>/keys 注入从此刻起不再生效")
        # 【Agent 15 J1 修正】path A / path B 一律用同一套 judge_side：
        # 两端 lstate==4 && pc==2，且至少一侧 st 含 MASTER(0x20)（从机天然无该位）。
        # gSpecialVar_Result（`linkup=`）只是**诊断字段**：菜单 A 留下的残留值
        # role=im0/lid0/hs0/st=0 也会显示 1，绝不能判绿。
        success_now = la_ok and lb_ok and (ma or mb)
        raw_link_a, raw_link_b = da.get("linkup", "-"), db.get("linkup", "-")
        if success_now:
            if stable_since is None:
                stable_since = time.time()
            if not success_seen:
                success_seen = True
                linkup = stable_since
                log("SUCCESS-CANDIDATE %.0fs | %s | %s | raw_linkup_A=%s raw_linkup_B=%s"
                    % (linkup - t0, a.snap(), b.snap(), raw_link_a, raw_link_b))
        else:
            stable_since = None
            if linkup_stable:
                log("!! SUCCESS 失去稳定态，重新计时 | %s | %s" % (a.snap(), b.snap()))
            linkup_stable = False
        if stable_since is not None and time.time() - stable_since >= args.stable_sec:
            if not linkup_stable:
                linkup_stable = True
                log("LINKUP-STABLE 稳定 %.1fs | %s | %s"
                    % (args.stable_sec, a.snap(), b.snap()))
        if BTRACK.note(a, b) and linkup_stable and not battle_done:
            battle_done = True
            log("BATTLE=YES（两端 cb2 进对战窗口）| A=%s | B=%s"
                % (BTRACK.last_a, BTRACK.last_b))
        if battle_done:
            break
        it += 1
        # 步数上限只是防死循环的最后一道闸；**不能**用它来控制实验时长 ——
        # 旧值 26 步 ≈ 30 秒，而联机握手本身就要几十秒（游戏要走完
        # 「柜台对话 → 选联机方式 → 等对端 → 选举」），于是 11-16 那几轮
        # 全部在 state 2 之前就被砍掉，读数自然是「没握手」。时长一律由
        # --runsec 控制。
        if it > 4000:
            log("闭环步数用尽 | %s | %s" % (a.snap(), b.snap()))
            break
        if linkup:
            # 【17:20 关键修正】lstate=4 之后进入「训练家卡片块交换」阶段，
            # 这一步 gen8 是纯自动的（BBBB 块头 + 5 帧 8888 数据 + 校验），
            # **不需要任何按键**。旧逻辑每 3 步给两端 tap(A)，在块交换中途
            # 被 JOY_NEW(B)/确认键打断 → 链路 CloseLink → rem 永远 0、黑屏
            # （SLAVEREAL 现场：n=32-48 块数据正常推进，n=48 突然 st=0、
            # linkup=1→0，正是这时工具在狂按 A）。
            # 现在改为静默观察：只等 rem=1 / 进对战；不住任何键。
            a.key(0), b.key(0)  # 确保松开，包括之前长按残留
            la_now, lb_now = a.lstate_pc()[0], b.lstate_pc()[0]
            if args.mode == "B":
                # 【Agent 15 J3 修正】按键/静默时机一律用 judge_side：
                # lstate==4 && pc==2 && st&MASTER(0x20)。旧的 gSpecialVar_Result==1
                # 是菜单 A 键残留（im0/lid0/hs0/st=0），拿它当「已联机」会误判绿灯。
                # raw linkup 只打进日志做诊断，绝不参与时机判断。
                def _jd(inst):
                    d = inst.diag()
                    l_ok, m = judge_side(d)
                    return l_ok and m, d.get("linkup", "?")

                okA, rawA = _jd(a)
                okB, rawB = _jd(b)
                sig_b = ("B", okA, okB, a.cb2(), b.cb2())
                if B_DEB.ready(sig_b):
                    if not okA:
                        a.tap(K["A"], hold=0.22, gap=0.8)
                    if not okB:
                        b.tap(K["A"], hold=0.22, gap=0.8)
                    if okA and okB:
                        # 两端都通过真判据：游戏停在"连接成功"确认，
                        # 成对按 A 才 warp 进房间（path A 同一机制）。
                        tap_pair(K["A"], hold=0.25, gap=0.8)
                else:
                    a.key(0), b.key(0)
                if it % 6 == 0:
                    log("  path B 引导 | A cb2=%s judge=%s raw_linkup=%s px=%s | "
                        "B cb2=%s judge=%s raw_linkup=%s px=%s"
                        % (a.cb2(), okA, rawA, a.diag().get("px", "?"),
                           b.cb2(), okB, rawB, b.diag().get("px", "?")))
                time.sleep(0.8)
                continue
            if la_now >= 4 and lb_now >= 4:
                # 【11-17 00:5x】块交换完成（rem=1）之后游戏会停在
                # 「连接成功」的确认上，等玩家按 A 才继续；这一步脚本以前
                # 一直静默，于是即使 rem=1 也永远停在这里（TR44 现场：
                # 两端 rem=1 连续 15 秒、menu 字段一动不动）。
                # rem 双双为 1 之后改回成对按 A 推进，但仍然只在**两端都
                # rem=1** 时按，避免打断还在搬块的那一端。
                ra = str(da.get("rem", "0"))
                rb = str(db.get("rem", "0"))
                if ra == "1" and rb == "1":
                    if it % 3 == 1:
                        log("  rem=1 两端已交换 → 按 A 推进 | A %s | B %s"
                            % (a.snap(), b.snap()))
                    # 【11-17】按了 8 轮（约 10 秒）画面字段一点没变就抓图 ——
                    # rem=1 之后到底停在哪个提示，只有看画面才知道，盲按键
                    # 只会白烧帧并消耗 --runsec 预算。
                    if it % 12 == 1 and not SHOT.get("done"):
                        SHOT["done"] = True
                        pa = grab_win(a, os.path.join(gdir, "shot_a_rem1.png"))
                        pb = grab_win(b, os.path.join(gdir, "shot_b_rem1.png"))
                        log("  已截图 rem=1 现场 | A=%s | B=%s" % (pa, pb))
                    # 【11-17 截图定案】rem=1 之后画面是**联机大厅房间本体**：
                    # 玩家角色站在下方、上方是柜台服务员，没有任何对话框
                    #（shot_a_rem1.png / shot_b_rem1.png）。也就是说 linkup
                    # 已经把玩家放进房间了，光按 A 不会推进 —— 要走上去跟
                    # 柜台对话。顺序：Up ×2 → A，之后恢复按 A。
                    SHOT["step"] = SHOT.get("step", 0) + 1
                    n = SHOT["step"]
                    # 【11-17 截图定案】rem=1 之后两端会进入**对战待机房间**：
                    # 两个玩家角色并排站在房间下方平台上，中间是联机台
                    #（TR53 now.png）。ceiling 之后要继续**往上走**到台前再按 A
                    # —— 之前只按 A，位置永远停在平台上下不来。
                    # 节奏：Up ×2 → A，循环。
                    # 【23:4x 坐标定案】gen8 `data/maps/BattleColosseum_2P/events.inc`：
                    #     warp_def 6, 8, ...                     ← 出口，玩家初始在 (5,8)/(6,8)
                    #     coord_event 3,  5, ... PlayerSpot0     ← A 的站位
                    #     coord_event 10, 5, ... PlayerSpot1     ← B 的站位
                    # 踩上站位格才会触发 EventScript_BattleColosseum_2P_PlayerSpotN。
                    # 所以两端要走**不同的**方向序列，不能 tap_pair 同一个键。
                    # 【23:5x 按键定性】房间里的方向键在 FR10/12/14 三局里都没让
                    # px/py 动过一格。先确认「场地到底接不接受按键」：按 START
                    # 若菜单能开 ⇒ 场地可操作，问题在方向键注入；开不了 ⇒ 场地
                    # 还被俱乐部任务锁着，方向完全不同。只按键、不改代码。
                    if SHOT.get("walked") and not SHOT.get("starttest"):
                        SHOT["starttest"] = True
                        before = a.snap()
                        a.tap(K["START"], hold=0.35, gap=0.9)
                        after = a.snap()
                        log("  START 测试 | 前 %s" % before)
                        log("  START 测试 | 后 %s" % after)
                        a.tap(K["B"], hold=0.20, gap=0.5)
                    if not SHOT.get("walked"):
                        SHOT["walked"] = True
                        plan = {a: [K["L"], K["L"], K["U"], K["U"], K["U"]],
                                b: [K["R"], K["R"], K["R"], K["R"], K["U"], K["U"], K["U"]]}
                        log("  走位到站位：A→(3,5) B→(10,5)")
                        for i in range(max(len(plan[a]), len(plan[b]))):
                            for side in (a, b):
                                seq = plan[side]
                                if i < len(seq):
                                    side.tap(seq[i], hold=0.22, gap=0.06)
                            time.sleep(0.18)
                        time.sleep(0.4)
                        log("  走位后 | A %s | B %s" % (a.snap(), b.snap()))
                    if n % 3 == 1 or n % 3 == 2:
                        tap_pair(K["U"], hold=0.40, gap=0.05)
                        time.sleep(0.5)
                    else:
                        if n % 9 == 3 and not SHOT.get("done2"):
                            SHOT["done2"] = True
                            pa = grab_win(a, os.path.join(gdir, "shot_a_stand.png"))
                            pb = grab_win(b, os.path.join(gdir, "shot_b_stand.png"))
                            log("  已截图 待机房间 | A=%s | B=%s" % (pa, pb))
                        tap_pair(K["A"], hold=0.25, gap=0.05)
                        time.sleep(1.0)
                else:
                    if it % 6 == 0:
                        log("  静默观察块交换 | A %s | B %s" % (a.snap(), b.snap()))
                    time.sleep(2.0)
            else:
                # 只有一端到 l=4：另一端还在握手，轻按落后的一端帮它确认；
                # 已到 l=4 的保持松手，避免打断它那侧的块交换。
                # 同样去抖：签名不变就不再按，等游戏自己推进。
                if LEAD_DEB.ready(("lead", la_now, lb_now, da.get("menu", ""), db.get("menu", ""))):
                    if la_now < 4:
                        b.tap(K["A"], gap=1.2)
                    elif lb_now < 4:
                        a.tap(K["A"], gap=1.2)
                else:
                    a.key(0), b.key(0)
                log("  引导落后端 | A l=%s | B l=%s" % (la_now, lb_now))
            continue
        # 【选举阶段】pc>=2 但 lstate<4：这一刻才满足 CheckShouldAdvanceLinkState
        # 的 (gLinkStatus & MASTER) && playerCount>1，按 A 才会把
        # shouldAdvanceLinkState 置 1 → handshakeAsMaster=TRUE → 发 0x8FFF。
        # 【11-16 修正】"主机已发起"必须查 LINK_STAT_MASTER=0x20，不是 0x40
        # （后者是 CONN_ESTABLISHED）。gen8/src/link.c:1148 原文：
        # (gLinkStatus & LINK_STAT_MASTER) && EXTRACT_PLAYER_COUNT()>1。
        # 旧脚本用 0x40 判 False 后反复长按 A 5s，把已进行的握手打断 →
        # 游戏弹「连接发生错误」、pc 掉回 0（11-16 P2PFIX 现场）。
        if (la[1] >= 2 or lb[1] >= 2) and not is_l:
            sa = da.get("st", "0")
            try:
                stab = int(sa, 16)
            except ValueError:
                stab = 0
            log("选举阶段 pc>=2 | A st=%s(master0x20=%s) l=%s | B st=%s l=%s"
                % (sa, bool(stab & 0x20), la, db.get("st"), lb))
            # 去抖：pc>=2 的选举态连续稳定后才允许一次长按，不再每轮长按 5s
            # 反复打断握手（11-16 P2PFIX 现场就是被反复长按打断）。
            if not ELEC_DEB.ready(("elec", la[0], la[1], lb[0], lb[1], sa, db.get("st"))):
                a.key(0), b.key(0)
                time.sleep(0.8)
                continue
            if not (stab & 0x20):
                # cable_club.c 要求同帧同时满足 GetFieldMessageBoxMode()==HIDDEN
                # 与 JOY_HELD(A)；点按 1~2 帧永远到不了那一行 → 停在
                # Task_LinkupTryConfirmation 空转（画面就是「请稍候」）。长按 5 秒。
                tap_pair(K["A"], hold=5.0, gap=1.0)
                time.sleep(1.0)
                sa2 = a.diag().get("st", "0")
                try:
                    stab2 = int(sa2, 16)
                except ValueError:
                    stab2 = 0
                log("  主机按 A 后 | A st=%s(master0x20=%s) l=%s"
                    % (sa2, bool(stab2 & 0x20), a.lstate_pc()))
                if stab2 & 0x20:
                    tap_pair(K["A"], hold=5.0, gap=1.0)
                    log("  两端成对长按后 | B %s" % b.snap())
            else:
                # A 已是主机且 pc>=2，选举条件已满足，别再长按打断握手；
                # 只让从机轻按确认，然后耐心等握手推进。
                tap_pair(K["A"], gap=1.4)
                log("  A 已是主机(master=1)，不再长按打断；两端成对轻按确认")
            continue
        wa, wb = at_w2(da), at_w2(db)
        log("step%d wa=%s wb=%s | %s | %s" % (it, wa, wb, a.snap(), b.snap()))
        # 【去抖核心】旧逻辑每次 diag 都按 A ⇒ 菜单在 `l=2 menu=w2`→A→
        # `l=1 menu=w0`→`l=2` 之间横跳，确认框从没被一致推进（ADR §4.2(h.5)）。
        # 现在状态签名必须连续稳定 --debounce-sec 秒才放行一次 A；签名没变
        # 就松键等待；两端都不在 w2 时绝不盲按 A（那正是震荡源）。
        sig_nav = (la[0], da.get("menu", ""), a.cb2(),
                   lb[0], db.get("menu", ""), b.cb2())
        if NAV_DEB.ready(sig_nav):
            if wa and wb:
                tap_pair(K["A"], gap=1.2)
                log("  [debounce] 两端成对按 A 后 | %s | %s" % (a.snap(), b.snap()))
            elif wa:
                b.tap(K["A"], gap=1.2)
                log("  [debounce] B 在确认框，单独按 B | %s" % b.snap())
            elif wb:
                a.tap(K["A"], gap=1.2)
                log("  [debounce] A 在确认框，单独按 A | %s" % a.snap())
            else:
                a.key(0), b.key(0)
                log("  [debounce] 两端均未在确认框，静默等待（不按 A）")
        else:
            a.key(0), b.key(0)

    log("== 收尾采样")
    for _ in range(3):
        sample("post")
        BTRACK.note(a, b)
        time.sleep(3.0)
    sample("post")
    BTRACK.note(a, b)

    # ---- 机器可读最终判据（本脚本存在的意义）----
    da_f, db_f = a.diag(), b.diag()

    # 【Agent 15 J4 修正】两种模式共用 judge_side，彻底移除 _side_linkup1。
    l4_a, m_a = judge_side(da_f)
    l4_b, m_b = judge_side(db_f)
    ok_a, ok_b = l4_a and m_a, l4_b and m_b
    raw_link_a_f, raw_link_b_f = da_f.get("linkup", "-"), db_f.get("linkup", "-")
    in_battle = BTRACK.hits > 0 or battle_done
    battle_yes = bool(linkup_stable and in_battle)
    via = "p2p" if (a.via() == "p2p" or b.via() == "p2p") else "tunnel"
    scope = "PROXY-2PC" if args.topology == "p2p" else "CROSS-DEVICE"

    # ---- Agent 3/8/1/7 的结构化证据 ----
    pr_a, pr_b = a.p2p_result(), b.p2p_result()
    pd_a, pd_b = a.p2p_diag(), b.p2p_diag()
    pa_a, pa_b = a.mgbx_path(), b.mgbx_path()
    g_a, g_b = a.mgbx_gate(), b.mgbx_gate()
    ra, rb = a.rearm_hs(), b.rearm_hs()
    bd_a, bd_b = a.bus2p_diag(), b.bus2p_diag()

    def _bus_ok(bd):
        try:
            return int(bd.get("players", 0)) == 2
        except (ValueError, TypeError):
            return False

    if args.mode == "B":
        bus2p_ok = _bus_ok(bd_a) and _bus_ok(bd_b)
        bus2p_reason = ("ok" if bus2p_ok else
                        "caller requests MIRROR_COUNT+1=4 (CloudLink.cpp:2002/2013); "
                        "needs netLinkBusHostLocal(key,2)+netLinkBusJoinLocalSlot(key,1)")
    else:
        bus2p_ok, bus2p_reason = "N/A", "not path B"

    out = [
        "tag=%s" % args.tag,
        "topology=%s scope=%s" % (args.topology, scope),
        # 以下是判读「到底成没成」的机器可读字段（禁止再用 linkup=1 当成功）
        "BATTLE=%s" % ("YES" if battle_yes else "NO"),
        "linkup_stable=%s" % linkup_stable,
        "linkup_stable_A=%s linkup_stable_B=%s  # judge_side: state4/pc2/MASTER"
        % (ok_a, ok_b),
        "lstate4_pc2_A=%s lstate4_pc2_B=%s st_master_A=%s st_master_B=%s"
        % (l4_a, l4_b, m_a, m_b),
        "linkup_raw_A=%s linkup_raw_B=%s  # gSpecialVar_Result 残留值，仅诊断不判绿"
        % (raw_link_a_f, raw_link_b_f),
        "in_battle_frame=%s battle_samples=%d" % (in_battle, BTRACK.hits),
        "in_battle_cb2_A=%s in_battle_cb2_B=%s" % (BTRACK.last_a, BTRACK.last_b),
        "battle_window=[0x%X,0x%X) source=%s" % (B_LO, B_HI, B_SRC),
        "fps_pc_A=%s fps_pc_B=%s" % (("%.1f" % a.fps()) if a.fps() else "-",
                                     ("%.1f" % b.fps()) if b.fps() else "-"),
        "via=%s  # [MGBAX_P2P]/diagnosticsText 优先" % via,
        "peerCandidates_A=%s peerCandidates_B=%s"
        % (a.peer_candidates(), b.peer_candidates()),
        "peerCandidateCount_A=%s peerCandidateCount_B=%s"
        % (pr_a.get("peerCandidateCount", pd_a.get("peerCandidates", "-")),
           pr_b.get("peerCandidateCount", pd_b.get("peerCandidates", "-"))),
        "p2p_result_A result=%s directEnabled=%s | p2p_result_B result=%s directEnabled=%s"
        % (pr_a.get("result", "-"), pr_a.get("directEnabled", "-"),
           pr_b.get("result", "-"), pr_b.get("directEnabled", "-")),
        "p2p_avg_A=%s p2p_avg_B=%s p2p_ignored_A=%s p2p_ignored_B=%s"
        % (pd_a.get("avg", "-"), pd_b.get("avg", "-"),
           pd_a.get("ignored", "-"), pd_b.get("ignored", "-")),
        "path_A=%s path_B=%s" % (pa_a.get("path", a.path()), pa_b.get("path", b.path())),
        "bus_A=%s bus_B=%s  # 仅 path B 有本机 4 核总线（LocalBus key 天然每实例独立）"
        % (a.bus_identity(), b.bus_identity()),
        "alive_A=%s alive_B=%s" % (a.alive(), b.alive()),
        "mode_requested=%s mode_negotiated_A=%s mode_negotiated_B=%s"
        % (args.mode, a.negotiated_mode() or "-", b.negotiated_mode() or "-"),
        "official_mode_A=%s official_mode_B=%s nav_at_leak=%s"
        % (a.official_mode(), b.official_mode(), nav_leak),
        "gate_A envLinkMode=%s envOfficialLink=%s envRearm=%s fastMinOk=%s fastMinOkSlave=%s sioFast=%s"
        % (g_a.get("envLinkMode", "-"), g_a.get("envOfficialLink", "-"),
           g_a.get("envRearm", "-"), g_a.get("fastMinOk", "-"),
           g_a.get("fastMinOkSlave", "-"), g_a.get("sioFast", "-")),
        "gate_B envLinkMode=%s envOfficialLink=%s envRearm=%s fastMinOk=%s fastMinOkSlave=%s sioFast=%s"
        % (g_b.get("envLinkMode", "-"), g_b.get("envOfficialLink", "-"),
           g_b.get("envRearm", "-"), g_b.get("fastMinOk", "-"),
           g_b.get("fastMinOkSlave", "-"), g_b.get("sioFast", "-")),
        "env_fast_slave_align=%s  # 本轮驱动钉死值（C 侧未设时为 0=关闭）"
        % (base.get("MGBAX_FAST_SLAVE_ALIGN", "<unset>")),
        "rearm_A fired=%s hs1=%s rounds=%s | rearm_B fired=%s hs1=%s rounds=%s"
        % (ra["fired"], ra["hs1"], ra["rounds"],
           rb["fired"], rb["hs1"], rb["rounds"]),
        "slave_fast_align_blocked_A=%s slave_fast_align_blocked_B=%s"
        % (a.fast_align_blocked(), b.fast_align_blocked()),
        "badchecksum_A=%s badchecksum_B=%s  # 应为 0（[diag] st 的 0x2000 位）"
        % (a.bad_checksum_count(), b.bad_checksum_count()),
        "bus_diag_A players=%s attached=%s slot=%s idx=%s hostIdx=%s"
        % (bd_a["players"], bd_a["attached"], bd_a["slot"], bd_a["idx"], bd_a["hostIdx"]),
        "bus_diag_B players=%s attached=%s slot=%s idx=%s hostIdx=%s"
        % (bd_b["players"], bd_b["attached"], bd_b["slot"], bd_b["idx"], bd_b["hostIdx"]),
        "pathB_2p_bus_ok=%s reason=%s" % (bus2p_ok, bus2p_reason),
        "exitcode_A=%s exitcode_B=%s" % (a.proc.poll(), b.proc.poll()),
        "linkup_s=%s stable_s=%s"
        % ("%.0f" % (linkup - t0) if linkup else "未到LINKUP",
           ("%.1f" % (time.time() - stable_since)) if stable_since else "-"),
        "final_A=%s" % a.snap(),
        "final_B=%s" % b.snap(),
        "rtt_A=%s" % (a.rtt() or "-"),
        "rtt_B=%s" % (b.rtt() or "-"),
        "multi_A=%s" % (a.multi() or "-"),
        "multi_B=%s" % (b.multi() or "-"),
    ]
    with open(os.path.join(gdir, "summary.txt"), "w", encoding="utf-8") as f:
        f.write("\n".join(out) + "\n")
    for s in out:
        log(s)

    for i in (a, b):
        if i.alive():
            subprocess.run(["taskkill", "/F", "/PID", str(i.proc.pid)], capture_output=True)
    log("结束")
    return 0


if __name__ == "__main__":
    sys.exit(main())
