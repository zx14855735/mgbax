#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""diff_party_check.py — 差分 party 实验判据工具（只读 run 日志，不伪造证据）。

实验设计（见 production/联机实现全过程.md 的 B2 结论）：
  * PC 端 sav 首位物种改为喷火龙 Charizard = 0x0006；
  * APP 端保留壶壶 Shuckle = 0x00D5。

若两端真的过网交换了 party 数据：
  * APP 对手框应显示 PC 的 party 首位 -> 喷火龙 0x0006；
  * PC 对手框应显示 APP 的 party 首位 -> 壶壶 0x00D5。
若 APP 对手框仍显示壶壶(自己 0x00D5) -> 自我回显坐实。

判据来源（按标签语义归类，不靠文件名猜；两端都打 OPPSPECIES/RHPLYR）：
  * [SPENC]      species=   -> PC 自己 party 首位（PC 发出，PC 侧 qt/sio_link.c）
  * [RHVIS]      pcSp/sp0=  -> PC 解码到的 APP party 首位（APP 经 sidecar 发出）
  * [RHVIS]      epSp=      -> PC 对手框显示的物种（gEnemyParty）
  * [RHREND]     bm=        -> APP 对手框显示的物种（gBattleMons，APP 侧 mgba_mobile.c）
  * [OPPSPECIES] mons=      -> 出场精灵 species（佐证/回退，按文件侧别归类）
  * [SPDEC]      sp0=       -> APP 解码到的 PC party 首位（佐证 PC 字节真的过网）
  * [RHPLYR]                 -> trainer 卡（无 species，只记存在）

判定：
  CROSSED   / PASS : 两端对手框都交叉（APP=喷火龙 且 PC=壶壶）
  SELF_ECHO / FAIL : 对手框显示本端自己的物种（APP=壶壶 或 PC=喷火龙）
  UNOBSERVED       : 关键物种缺失，或观测值不符合任一假设（诚实标注，不硬断）

模式自动检测（JSON 增 mode 字段）：
  INJECT : 日志命中 >=2 个注入标签(SPENC/SPDEC/RHVIS/RHREND) —— 旧注入 run，
           完全保留上面原 7 bucket 判据，历史结论不回归。
  ZERO   : 零注入(MGBAX_RH_OFF=1)，上述注入标签全部关闭，只剩 [OPPSPECIES]/[RHPLYR]
           (可选 [OPPGATE])。判据改为：侧别按内容签名(APP 带 n= / RHPLYR 带 cb2=；
           PC 反之)+文件名兜底；主证据 [OPPSPECIES] mons= 是 gBattleMons(L2)，
           差分标记 APP=0006 / PC=00D5 必须落在对手槽(slot1)且本端槽(slot0)未被污染
           才算 cross_marker；标记只在 slot0/事实不清记 wrongslot，不判交叉。
           [OPPGATE] blkSp0 是 L0(gBlockRecvBuffer)；闭合态判据为 brs 两字节各=1。
           C 侧 sio_link.c:4776 / mgba_mobile.c:3701 用 %04X 打印 GBAView16(0x03002A40)
           的原始 16 位读（低字节=[0]、高字节=[1]），原生闭合 byte0=byte1=1 ⇒ 0x0101，
           并非拼装位域 0003；旧判据 brs&3==3 因 0x0101&3==1 恒不合格（W35 §3.4 假阴性）。
           须闭合+blkSp0 合法+cnt>0+块头非命令字的合格样本两端全交叉才算 L0 成立；
           brs=0000/部分态(0001/0100)/旧位域(0003)/畸形、blkHdr 命中命令字(BBBB/8888/2222)、
           以及命中 RHBRS/RHBRS-GRAY 灰区强写标记（0101 可能来自伪 ACK，不可辨真伪）均不算。
           CROSSED 必须 L2 双交叉 + L0 闭合双交叉 + enemyPartyCnt>0；
           L2-only / L0 未确认 / ec=0 / 灰区强写在场一律降级 UNOBSERVED，绝不输出裁决级 CROSSED。

零注入 path B 别名（mode_alias=pathB-zero，ARC13/ARCH14 终裁）：
  大改架构 path B 下 party 字节由对端真游戏 SetLinkOpponentMonData 从
  gLinkBattleRecvBuffer 拷贝，CROSSED 判据原样适用。ZERO 模式的裁决通道
  **不要求任何注入标签**（SPENC/SPDEC/RHVIS/RHREND 全部关闭也能 CROSSED）：
  只认纯数据层自洽链——OPPSPECIES mons 四槽合法且 slot1=对端标记/slot0 未污染、
  双端 cross_marker 交叉(APP=0006/PC=00D5)、OPPGATE 全部合格样本
  brs 两字节各=1(原始读 0101,非位域 0003)+cnt>0+块头非命令字+无 RHBRS 灰区强写标记
  且 blkSp0 为对端标记、enemyPartyCnt>0。
  别名/criterion 仅供下游 gate 明确「零注入也能裁决」，不降低任何门槛：
  L2-only / L0 未闭合 / ec=0 / wrongslot 仍降 UNOBSERVED。判据可用≠对手真实已证。

 NETGATE 等效新 L0 判据（pathB-net，--l0-mode netgate；判据先于代码，见
 netgate_criterion() / .zcode-tmp/NETGATE_impl.md）：
   默认 --l0-mode sio 逐字保留上述 SIO 判据，向后兼容。仅 netgate 模式只读 ROM
   netcode 打印的 [NETGATE] 字段（state=CLOSED/tag_ok/seq/sender/rom_md5/blob/tag/
   rx_digest/tx_digest/msg_type=PARTY/src_tag/cnt/sp0/tx_sp0），做「闭合态由 ROM 自置
   + 跨端 digest 对账（A.rx==B.tx 且 B.rx==A.tx 且两向不同）+ sender≠self + seq 单调
   + src_tag provenance + 全部旧否定门（ec>0/无注入/非回显/species 合法/L2 cross_marker/
   无灰区/fail-closed）」。HMAC 只证来源可追溯与完整性、不证「来自真游戏而非脚本」，
   须靠真 gPlayerParty 序列化写径审计 + writer≠checker 隔离兜底。判据可用≠对手真实已证；
   NETGATE 产出的 CROSSED 标注新口径，门 FAIL/0/9 不自动翻，须视觉门人工复核重新裁决。

退出码：0=CROSSED(PASS), 1=SELF_ECHO(FAIL), 3=UNOBSERVED, 2=输入错误（未下调）。

Examples
--------
  python tools/diff_party_check.py .zcode-tmp/cloud2p/SOMERUN
  python tools/diff_party_check.py .zcode-tmp/cloud2p/SOMERUN --json
  python tools/diff_party_check.py --self-test
  python tools/diff_party_check.py .zcode-tmp/cloud2p/SOMERUN --l0-mode netgate --json
  python tools/diff_party_check.py .zcode-tmp/cloud2p/SOMERUN --l0-mode netgate --net-rom-md5 <disk_md5> --json
"""

import argparse
import contextlib
import io
import json
import os
import re
import sys
import tempfile

# 实验设定的 party 首位物种（法国/火红全国图鉴 ID）
EXPECTED_PC_PARTY_FIRST = "0006"   # 喷火龙 Charizard
EXPECTED_APP_PARTY_FIRST = "00D5"  # 壶壶 Shuckle
SP_NAMES = {
    EXPECTED_PC_PARTY_FIRST: "喷火龙/Charizard",
    EXPECTED_APP_PARTY_FIRST: "壶壶/Shuckle",
}

# 只认这些标签，避免误抓其它日志。OPPGATE 为 ROOTHUNT2/B7 新增的 L0 具名打点，
# 有则升级判据，无则降级 L2-only（见 check_zero）。
TAG_RE = re.compile(
    r"\[(RHVIS|RHREND|OPPSPECIES|SPENC|SPDEC|RHPLYR|OPPGATE)\]")
KV_RE = re.compile(r"\b([A-Za-z][A-Za-z0-9_.\[\]]*)=([^\s\]]+)")

# 注入模式特征标签（零注入下全部关闭）：命中 >=2 个即判为旧 INJECT run，
# 原样保留 7 bucket 判据，历史 run 不回归。
INJ_TAGS = ("SPENC", "SPDEC", "RHVIS", "RHREND")

# 显式模式（W66）：auto=维持原标签计数自动判定；zero/inject 由 CLI 钉死。
# mode_source 固定为 explicit_cli / auto_detect，下游 gate 可据此拒绝「只看 exit 0」。
MODE_AUTO, MODE_ZERO, MODE_INJECT = "auto", "zero", "inject"
CLI_MODES = (MODE_AUTO, MODE_ZERO, MODE_INJECT)
MODE_SOURCE_EXPLICIT = "explicit_cli"
MODE_SOURCE_AUTO = "auto_detect"

# 零注入 path B 别名（FIXDIFF3/ARC13/ARCH14）：ZERO 模式裁决通道不要求任何注入标签，
# 纯数据层自洽链即可 CROSSED。以函数返回，避免调用方改动污染全局常量。
MODE_ALIAS_ZERO = "pathB-zero"

# ---- NETGATE（pathB-net）等效 L0 重锚：判据先于代码，默认 sio 完全不变 ----
# L0_MODE=sio 维持现有 SIO 块闭合判据逐字不变（向后兼容）；
# L0_MODE=netgate 只读 ROM netcode 打印的 [NETGATE] 字段做等效 L0 裁决。
L0_SIO, L0_NETGATE = "sio", "netgate"
L0_MODES = (L0_SIO, L0_NETGATE)
NETGATE_ALIAS = "pathB-net"

# 具名完成态（对应 C 侧 gNetPartyRxState=GNP_RX_CLOSED 具名宏；禁裸 hex）。
NETGATE_STATE_CLOSED = "CLOSED"
# 反命令/反控制维度：只认 MSG_PARTY，拒 HELLO/ACK/CONTROL。
NETGATE_MSG_TYPE = "PARTY"
# 若 run 内出现 emulator 侧强写 ROM 收包状态的标记（类比 RHBRS），整轮拒认闭合。
NETGRAY_MARKERS = ("[NETGRAY]", "force net state", "force gNetPartyRxState",
                   "set net state", "force gNetEnemyPartyCount")
# src_tag provenance 模板/常量/缓存来源黑名单（命中即拒认，来源不可追溯）。
NET_SRC_BLACKLIST = ("template", "constant", "const:", "cache", "dummy",
                     "mock", "fake", "hardcode", "hard-code")

NETGATE_TAG_RE = re.compile(r"\[NETGATE\]")


def zero_criterion():
    """零注入 path B 判据的精确定义（写进 JSON，供下游 gate 明确门槛未降）。"""
    return {
        "mode_alias": MODE_ALIAS_ZERO,
        "injection_tags_required": False,
        "basis": "零注入(MGBAX_RH_OFF=1) path B：ZERO 模式裁决不依赖 SPENC/SPDEC/RHVIS/RHREND；"
                 "仅凭纯数据层自洽链即可出 CROSSED。判据可用≠对手真实已证，须结合截图/视觉门人工复核。"
                 "W39 三处均为 fail-closed/透明化，门槛只升不降：blkHdr 缺/畸形拒认、"
                 "slot0 须为合法本端标记、degenerate 为结构性重述非观测证据。",
        "required_data_layer": [
            "OPPSPECIES mons 四槽 species 合法(排除 0000/058B/FFFF/BBBB/8888)",
            "cross_marker 双交叉：APP L2 slot1=0006(PC标记) 且 slot0=00D5(APP本端标记、合法己方物种)；"
            "PC L2 slot1=00D5(APP标记) 且 slot0=0006(PC本端标记、合法己方物种)",
            "OPPGATE 全部合格样本：blkSp0 合法且为对端标记 + brs 两字节各=1(原始读 0101,"
            "非拼装位域 0003)闭合 + cnt>0 + blkHdr 非命令字(BBBB/8888/2222)"
            " + blkHdr 字段存在且形态合法(缺/畸形 fail-closed，块头维须可观测)"
            " + 无 RHBRS/RHBRS-GRAY 灰区强写标记(否则 0101 不可辨真伪,拒认闭合)",
            "端到端标记：双端 enemyPartyCnt>0（L1 已就绪）",
        ],
        "degrade_to_unobserved": [
            "L2-only(L0 缺/未闭合)", "标记落 slot0 或 slot0 被污染(wrongslot)",
            "slot0 被非法 species 污染(2222/BBBB/8888/058B/FFFF/0000)或合法但非本端差分标记",
            "OPPGATE 合格样本非全交叉", "brs=0 陷阱", "brs 部分态/旧位域 0003/畸形",
            "RHBRS 灰区强写 brs(伪 ACK)", "enemyPartyCnt=0", "命令块 blkHdr",
            "blkHdr 缺字段/形态畸形(块头维不可观测, fail-closed)",
        ],
        "exit_code_contract": "0=CROSSED / 1=SELF_ECHO / 3=UNOBSERVED / 2=输入错误（未下调）",
    }


def netgate_criterion():
    """NETGATE（pathB-net）等效 L0 的机器可读判据定义（判据先于代码）。

    门槛只升不降：现 L0 六门槛逐项一一映射且加强；HMAC 局限如实披露。
    """
    return {
        "mode_alias": NETGATE_ALIAS,
        "l0_anchor": "ROM netcode 收包状态机自置 gNetPartyRxState=CLOSED（非 emulator hook 写）"
                     " + HMAC tag_ok=1 + seq 单调 + 跨端 digest 对账"
                     "（A.rx==B.tx 且 B.rx==A.tx 且两向 digest 不同）",
        "writer_checker_separated": True,
        "writer": "ROM netcode receive handler：HMAC 通过 + seq 单调后才写 gNetPartyRxBuffer/State，"
                  "并经 SetLinkOpponentMonData 等价路径载入 gEnemyParty/gBattleMons；"
                  "emulator hook 只搬运字节到 ROM 邮槽，禁直接写 gEnemyParty/gBattleMons/gNetPartyRxState",
        "checker": "本工具只读 [NETGATE] 日志字段，绝不写游戏内存；writer≠checker 结构性成立",
        "hmac_scope": "HMAC 只证来源可追溯 + 完整性 + 闭合接收 + 抗重放，"
                      "不证『字节来自真游戏而非脚本』；密钥若被 hook/驱动持有即可自产 party。"
                      "必须靠真 gPlayerParty 序列化写径审计 + writer≠checker 隔离兜底。",
        "nonce_scope": "seq/nonce 只做逻辑单调序号（抗重放），非熵源；ROM 无硬件随机，不宣称密码学随机。",
        "required": [
            "两端 gNetPartyRxState=CLOSED（具名宏，缺/畸形/部分态 fail-closed）"
            " + tag_ok=1 + msg_type=PARTY（拒控制消息）",
            "两端 sp0(gNetPartyRxSp0) 合法且为对端差分标记（APP=0006 / PC=00D5）；"
            "tx_sp0 合法且为本端标记；rx_sp0≠tx_sp0",
            "跨端 digest 对账：A.rx_digest==B.tx_digest 且 B.rx_digest==A.tx_digest，"
            "两向 digest 单例且互不相同（两端不同 party 的交叉，非同源自证）",
            "seq>0 且各端严格单调递增、两端 seq 链有交集；sender=对端且≠本端；"
            "rom_md5 两端一致（可用 --net-rom-md5 钉死磁盘实测值）",
            "src_tag provenance 为 file:line/路径形态且非模板/常量/缓存来源；"
            "blob 与 tag 字段形态合法且非空",
            "run 内无 NETGRAY 强写 ROM 收包状态标记；无 RHBRS/RHBRS-GRAY 灰区标记",
            "L2 [OPPSPECIES] cross_marker 双交叉 + slot0 未被对端标记污染 + 无非法 species 污染",
            "ec(enemyPartyCnt / gNetEnemyPartyCount)>0（L1 就绪）",
            "无注入标签（SPENC/SPDEC/RHVIS/RHREND 命中即 fail-closed 降级 UNOBSERVED）",
        ],
        "degrade_to_unobserved": [
            "state 非 CLOSED / tag_ok!=1 / msg_type 非 PARTY（伪造闭合态）",
            "sp0 不在对手槽形态或非对端标记 / tx_sp0 非本端标记",
            "缺 digest 或跨端 digest 不对账 / 两向 digest 相同（自回显嫌疑）",
            "seq 非单调 / 无交集 / sender==self / rom_md5 两端不一致或与磁盘不符",
            "src_tag 缺或命中模板/常量/缓存黑名单 / blob/tag 缺或畸形",
            "NETGRAY / RHBRS 灰区强写在场", "注入标签矛盾",
            "L2-only / wrongslot / pollution / ec=0 / degenerate / SELF_ECHO",
            "单端观测（无真实对端 → 不可能全绿，Q1 守卫）",
        ],
        "three_question_check": {
            "Q1_no_peer_cannot_all_green": True,
            "Q1_rationale": "无真实对端则缺另一端 NETGATE 行或 digest 无法跨端对账且 sp0 无法为对端标记；"
                            "单端/缺 digest/伪造闭合均 fail-closed → UNOBSERVED，不能全绿。",
            "Q2_writer_checker_separated": True,
            "Q2_rationale": "闭合态由 ROM netcode 自置，checker 只读日志；跨端 digest 双端独立记录"
                            " + NETGRAY 检测防 emulator 侧强写；HMAC 不证真游戏产生，靠写径审计兜底。",
            "Q3_all_old_negative_gates_kept": True,
            "Q3_rationale": "ec>0 / 无注入标签 / 非 SELF_ECHO / species 合法 / L2 cross_marker"
                            " / slot0 洁净 / 无污染 / 无灰区 / fail-closed / 退出码契约全保留。",
        },
        "honest_caveat": "NETGATE 为 L0 等效重锚，判据可用≠对手真实已证；"
                         "差分标记 0006/00D5 属人工构造输入，可信度存疑、非纯零注入；"
                         "CROSSED 仍是唯一裁决，门 FAIL/0/9 不自动翻，须视觉门人工复核重新裁决。",
        "exit_code_contract": "0=CROSSED / 1=SELF_ECHO / 3=UNOBSERVED / 2=输入错误（未下调）",
    }


# 侧别判定：内容签名为主（零注入仍有效），文件名为辅。
# APP 的 [OPPSPECIES] 带 n=、[RHPLYR] 带 cb2=；PC 反之（无 n=、RHPLYR 带 blk0=/blk1=）。
PC_FILE_RE = re.compile(
    r"(?:^|[/\\])(?:pc_tmp[/\\])?(mgba_sio|mgba_lobby_debug|pc_stdout|lobby_debug|lobby)\.log$",
    re.I)
APP_FILE_RE = re.compile(
    r"(?:^|[/\\])(app_logcat(?:_full|_after)?|app_link_startup|app_link_timeline|logcat)\.log$",
    re.I)

# [OPPSPECIES] 的 mons= 是 gBattleMons[0..3].species（L2），CSV 四个槽位。
OPP_MONS_RE = re.compile(r"\bmons(?:\[0\.\.3\])?=([0-9A-Fa-f,]+)")

# 差分实验 party 首位（本地端 = sav 离线确认；远端 = 对端标记，用来破槽位悬案）。
LOCAL = {"PC": EXPECTED_PC_PARTY_FIRST, "APP": EXPECTED_APP_PARTY_FIRST}
REMOTE = {"PC": EXPECTED_APP_PARTY_FIRST, "APP": EXPECTED_PC_PARTY_FIRST}

# 合法物种上界（H4/H16 口径）：0x58B=gNumSpeciesNames 表长/越界哨兵，必须排除。
MAX_LEGAL_SPECIES = 0x58A
FORBIDDEN = {0x058B, 0xFFFF, 0xBBBB, 0x8888}

# 链路命令字（link.h SEND_LINK_TYPE/INIT_BLOCK/CONT_BLOCK）。真 party 块的
# gBlockRecvBuffer 前几字应是精灵数据；出现命令字 ⇒ 命令块/污染/错位，不是 0xA0
# 队伍块。Z74 P3：blkHdr 命中这些字时不得计入合格 L0 样本（裁决级假阳性缺口）。
CMD_BLOCK_WORDS = {0x2222, 0xBBBB, 0x8888}
PARTY_BLOCK_SIZE = 0xA0       # 160B = 6 只精灵队伍块（B 案正向校验用，A 案不启用）

# 二进制/大文件跳过；.py 也跳过（源码里有标签正则字面量，会污染证据）
SKIP_EXT = {
    ".gba", ".sav", ".png", ".jpg", ".jpeg", ".zip", ".dex", ".db",
    ".exe", ".elf", ".so", ".dll", ".pyc", ".ppm", ".bmp", ".pdf",
    ".7z", ".gz", ".py", ".class", ".ipa", ".apk", ".mp4",
}
MAX_BYTES = 32 * 1024 * 1024

# 侧别判定：PC 独有 RHVIS/SPENC；APP 独有 RHREND/SPDEC
PC_ONLY = ("[RHVIS]", "[SPENC]")
APP_ONLY = ("[RHREND]", "[SPDEC]")


def read_text(path):
    with open(path, "r", encoding="utf-8", errors="replace") as fh:
        return fh.read()


def discover_logs(run_dir):
    out = []
    for root, _dirs, files in os.walk(run_dir):
        for fn in files:
            if os.path.splitext(fn)[1].lower() in SKIP_EXT:
                continue
            p = os.path.join(root, fn)
            try:
                if os.path.getsize(p) > MAX_BYTES:
                    continue
            except OSError:
                continue
            out.append(p)
    return sorted(out)


def norm_sp(value):
    """把字段值归一成 4 位大写 hex；取 CSV 首项；非 hex 返回 None。"""
    if value is None:
        return None
    tok = str(value).strip().split(",")[0].strip().upper()
    if re.fullmatch(r"[0-9A-F]{1,4}", tok):
        return "%04X" % int(tok, 16)
    if re.fullmatch(r"\d{1,5}", tok):  # 罕见十进制形态
        return "%04X" % int(tok, 10)
    return None


def valid_sp(value):
    """0000 / 0xFFFF / 越界 视为 ???（不可作为物种判据）。

    上界收紧到 0x58A(1418)：0x58B(1419)=gNumSpeciesNames 表长度/越界哨兵，
    不是有效物种，必须排除（旧上界 0x7FF/0x0FFF 会把它误纳为合法）。"""
    if value is None:
        return False
    try:
        v = int(value, 16)
    except (ValueError, TypeError):
        return False
    return 0 < v <= MAX_LEGAL_SPECIES and v not in FORBIDDEN


def sp_name(value):
    return SP_NAMES.get(value, "未知物种")


def pick(records):
    """records=[(species|None, {'file':..,'line':..,'raw':..})]，取最后一个合法值。"""
    distinct = sorted({v for v, _ in records if v is not None})
    invalid_seen = sorted({v for v, _ in records if v is not None and not valid_sp(v)})
    valids = [(v, ref) for v, ref in records if valid_sp(v)]
    if valids:
        v, ref = valids[-1]
        return {
            "species": v,
            "name": sp_name(v),
            "ref": ref,
            "valid": True,
            "distinct": distinct,
            "invalid_seen": invalid_seen,
        }
    return {
        "species": None,
        "name": "???",
        "ref": records[-1][1] if records else None,
        "valid": False,
        "distinct": distinct,
        "invalid_seen": invalid_seen,
    }


def load(run_dir):
    """返回 (records, file_sides)。

    records: list of dict {file, line, raw, tag, fields, side}
    file_sides: {file_abs: 'PC'|'APP'|'MIXED'|None}
    """
    records = []
    file_sides = {}
    for path in discover_logs(run_dir):
        text = read_text(path)
        has_pc = any(t in text for t in PC_ONLY)
        has_app = any(t in text for t in APP_ONLY)
        side = "PC" if has_pc and not has_app else (
            "APP" if has_app and not has_pc else ("MIXED" if has_pc and has_app else None))
        file_sides[path] = side
        for lineno, line in enumerate(text.splitlines(), 1):
            m = TAG_RE.search(line)
            if not m:
                continue
            tag = m.group(1)
            fields = {k: v for k, v in KV_RE.findall(line)}
            records.append({
                "file": path, "line": lineno, "raw": line.strip()[:300],
                "tag": tag, "fields": fields, "side": side,
            })
    return records, file_sides


def file_base_side(path):
    """文件名兜底侧别：PC 日志 / APP 日志；混合聚合日志与未知文件返回 None。"""
    if PC_FILE_RE.search(path):
        return "PC"
    if APP_FILE_RE.search(path):
        return "APP"
    return None


def decide_side(record, base_side):
    """内容签名为主、文件名为辅；冲突则 (None, why)，绝不猜。"""
    raw, tag = record["raw"], record["tag"]
    sig = None
    if tag == "OPPSPECIES":
        sig = "APP" if re.search(r"\bn=", raw) else "PC"
    elif tag == "RHPLYR":
        if re.search(r"\bblk0=", raw):
            sig = "PC"
        elif re.search(r"\bcb2=", raw):
            sig = "APP"
    # OPPGATE 两端同格式、无内容签名，只能用文件名兜底（sig=None）。
    if sig and base_side and sig != base_side:
        return None, "side_conflict:%s/%s" % (sig, base_side)
    return sig or base_side, None


def parse_count(value):
    """enemyPartyCnt / cnt 之类十进制计数，容错解析。"""
    if value is None:
        return 0
    s = str(value).strip()
    try:
        return int(s, 10)
    except ValueError:
        try:
            return int(s, 0)
        except ValueError:
            return 0


def parse_hex(value):
    """解析 %04X 形态的字段（如 OPPGATE brs）；A-F 数字必须按 16 进制读。

    parse_count() 先试 10 进制再试 base=0，对 '000B' 这类带前导零的 hex 会解析失败
    并退回 0，导致 brs&3 误判；此处固定按 16 进制解析。"""
    if value is None:
        return 0
    s = str(value).strip()
    try:
        return int(s, 16)
    except ValueError:
        return 0


def brs_closed(brs):
    """判 OPPGATE 的 brs 是否为「两字节各 =1」的真实闭合态。

    C 侧打印口径（W52/W35 §3.4）：sio_link.c:4776 与 mgba_mobile.c:3701 都用
    "%04X" 打印 GBAView16(gba->cpu, SIO_IW(0x03002A40u)) 的**原始 16 位读**——
    低 8 位 = gBlockReceivedStatus[0]，高 8 位 = gBlockReceivedStatus[1]。
    游戏原生 SetBlockReceivedFlag 令两字节各为 1 ⇒ 原始读 0x0101，并不是
    byte0|(byte1<<1) 的拼装位域 0003。旧判据 (brs & 3) == 3 在 0x0101 上 = 1，
    故 OPPGATE 合格 L0 样本恒空、CROSSED 结构性假阴性（全仓 brs=0003 为 0 条）。
    这里要求两个字节都精确 ==1：拒绝 0000(未闭合)/0001/0100(部分态)/0003(位域口径)
    /0102/0201 等畸形值，避免放宽误收。

    红线（不可放宽）：brs 数值本身**无法区分**「游戏原生闭合」与「灰区 RHBRS
    GBAPatch8 伪 ACK」——两者都写 byte0=byte1=1，都打印 0101（sio_link.c:4911,
    4949 / mgba_mobile.c:4836,4877）。因此本修正只在零注入轮启用，且必须叠加
    gray_force_present()==False；命中灰区强写标记时一律拒认闭合。
    """
    return (brs & 0xFF) == 1 and ((brs >> 8) & 0xFF) == 1


# 灰区强写 brs 的日志标记：命中任一即说明 brs=0101 可能来自 C 侧 GBAPatch8 伪 ACK，
# 不可当作原生闭合证据（红线：拒灰区强写）。两个标签都是真实的驱动日志文案。
GRAY_BRS_MARKERS = ("[RHBRS]", "[RHBRS-GRAY]", "set brs=03", "force brs=03")


def gray_force_present(run_dir):
    """扫描 run 目录日志，返回是否出现 RHBRS/RHBRS-GRAY 强写 brs 标记。"""
    for path in discover_logs(run_dir):
        try:
            text = read_text(path)
        except OSError:
            continue
        if any(marker in text for marker in GRAY_BRS_MARKERS):
            return True
    return False


def parse_blk_hdr(value):
    """blkHdr=A,B,C（逗号分隔 hex）-> [int,...]；缺失或形态异常返回 []。

    旧日志无 blkHdr 字段时返回 []；形态异常（非 hex token）整组作废 = fail-closed，
    不可当「块头合法」（W39-F1）。"""
    if not value:
        return []
    out = []
    for tok in str(value).split(","):
        tok = tok.strip()
        if re.fullmatch(r"[0-9A-Fa-f]{1,4}", tok):
            out.append(int(tok, 16))
        else:
            return []
    return out


def block_valid(hdr, size=None, strict_size=False):
    """块头校验（Z74 P3 / W39-F1）：命中命令字(2222/BBBB/8888)即命令块/污染，不计合格 L0。

    W39-F1 fail-closed：缺字段(hdr=None)或形态畸形(parse_blk_hdr 返回 [])一律 False，
    不可当「块头合法」放行；块头维未覆盖由 hdr_observable() 显式标注 UNOBSERVED。
    strict_size=True(B 案，需 C 侧 blkSize 打点)时还要求块长==0xA0；A 案不启用。
    """
    if isinstance(hdr, str):
        hdr = parse_blk_hdr(hdr)
    if not hdr:                 # 缺字段 / 畸形整组作废：不可当「块头合法」
        return False
    if any(w in CMD_BLOCK_WORDS for w in hdr):
        return False
    if strict_size and size != PARTY_BLOCK_SIZE:
        return False
    return True


def hdr_observable(hdr_raw):
    """blkHdr 是否真的被发射且形态合法（W39-F1）。

    用于区分「块头维结构性未覆盖」（全 build 未打 hdr / 畸形）与「本样本非法」：
    前者 L0 不裁决(UNOBSERVED)，后者仅该样本被 block_valid fail-closed 排除。"""
    return bool(hdr_raw) and bool(parse_blk_hdr(hdr_raw))


def degenerate_precondition(local, remote):
    """结构性前提（由 EXPECTED_* 常量派生，非运行时观测）：两端 party0 是否退化同物种。

    W39-F2：恒空判据，标注为 structural/observable=false，不得当 PASS/CROSSED 证据。"""
    return (local["APP"] == remote["APP"] or local["PC"] == remote["PC"])


# ---------------- NETGATE（pathB-net）L0 等效判据：只读 [NETGATE] 字段 ----------------
# 这些函数完全独立于 sio 判据路径（TAG_RE/load/OPPGATE 均未改动）。


def load_netgate(run_dir):
    """单独扫描 [NETGATE] 行（不污染 sio 的 TAG_RE/load 证据计数）。

    返回 [{file, line, raw, fields, base_side}]，base_side 仅文件名兜底。
    """
    rows = []
    for path in discover_logs(run_dir):
        text = read_text(path)
        base = file_base_side(path)
        for lineno, line in enumerate(text.splitlines(), 1):
            if not NETGATE_TAG_RE.search(line):
                continue
            fields = {k: v for k, v in KV_RE.findall(line)}
            rows.append({
                "file": path, "line": lineno, "raw": line.strip()[:300],
                "fields": fields, "base_side": base,
            })
    return rows


def net_int(fields, key, default=None):
    """NETGATE 十进制整数字段容错解析（seq/tag_ok）。"""
    v = fields.get(key)
    if v is None:
        return default
    s = str(v).strip()
    try:
        return int(s, 10)
    except ValueError:
        try:
            return int(s, 0)
        except ValueError:
            return default


def net_gray_present(run_dir):
    """run 内是否出现 emulator 侧强写 ROM 收包状态的 NETGRAY 标记（类比 RHBRS）。"""
    for path in discover_logs(run_dir):
        try:
            text = read_text(path)
        except OSError:
            continue
        if any(marker in text for marker in NETGRAY_MARKERS):
            return True
    return False


def net_qualified(row, side, expected_rom_md5=None):
    """单条 [NETGATE] 样本是否满足全部 L0 维度；返回 (ok, reasons)。

    任一维缺/畸形/不符即 False（fail-closed），不做任何猜侧/补值。
    """
    f = row["fields"]
    reasons = []
    if (f.get("state") or "").upper() != NETGATE_STATE_CLOSED:
        reasons.append("state非CLOSED(伪造/部分态闭合)")
    sp0 = norm_sp(f.get("sp0"))
    if not (sp0 and valid_sp(sp0) and sp0 == REMOTE[side]):
        reasons.append("rx_sp0非对端标记")
    tx_sp0 = norm_sp(f.get("tx_sp0"))
    if not (tx_sp0 and valid_sp(tx_sp0) and tx_sp0 == LOCAL[side]):
        reasons.append("tx_sp0非本端标记")
    if net_int(f, "tag_ok", 0) != 1:
        reasons.append("tag_ok!=1(HMAC未通过)")
    if (f.get("msg_type") or "").upper() != NETGATE_MSG_TYPE:
        reasons.append("msg_type非PARTY(控制消息)")
    seq = net_int(f, "seq")
    if seq is None or seq <= 0:
        reasons.append("seq非法")
    if not f.get("nonce"):
        reasons.append("nonce缺")
    other = "PC" if side == "APP" else "APP"
    if (f.get("sender") or "").upper() != other:
        reasons.append("sender!=对端(sender==self或缺失)")
    src = f.get("src_tag") or ""
    src_l = src.lower()
    if (not src or any(b in src_l for b in NET_SRC_BLACKLIST)
            or not (":" in src or "/" in src or "\\" in src)):
        reasons.append("src_tag provenance缺/模板/缓存")
    for key in ("blob", "tag"):
        val = f.get(key)
        if key == "tag" and not val:
            val = f.get("tag8")
        if not val or not re.fullmatch(r"[0-9A-Fa-f]{4,}", val):
            reasons.append("%s指纹缺/畸形" % key)
    if parse_count(f.get("cnt")) <= 0:
        reasons.append("cnt<=0")
    md5 = (f.get("rom_md5") or "").lower()
    if not re.fullmatch(r"[0-9a-f]{8,32}", md5):
        reasons.append("rom_md5缺/畸形")
    elif expected_rom_md5 and md5 != expected_rom_md5.lower():
        reasons.append("rom_md5与磁盘实测不符")
    for key in ("rx_digest", "tx_digest"):
        val = f.get(key)
        if not val or not re.fullmatch(r"[0-9A-Fa-f]{4,}", val):
            reasons.append("%s缺/畸形" % key)
    return (len(reasons) == 0, reasons)


def evaluate_netgate(net_rows, run_dir, expected_rom_md5=None):
    """跨端 NETGATE L0 裁决，返回 (l0_ok, info)。

    l0_ok=True 必须同时满足：
      * 两端各有合格样本（state=CLOSED/tag_ok/对端标记/源/指纹全过）；
      * 各端 seq 严格单调且与对端 seq 链有交集；
      * 跨端 digest 对账：APP.rx=={D1}==PC.tx 且 PC.rx=={D2}==APP.tx 且 D1!=D2；
      * rom_md5 两端一致（且等于 --net-rom-md5 若给定）；
      * 无 NETGRAY / RHBRS 灰区强写标记（闭合不可信 → 整轮拒认）。
    """
    info = {
        "rows": {}, "qualified": {}, "seq": {}, "mono": {},
        "reasons": {}, "net_gray": net_gray_present(run_dir),
        "gray_brs": gray_force_present(run_dir),
        "digest_ok": False, "digests": {}, "rom_md5_ok": False,
        "rom_md5s": [], "seq_overlap": False, "verdict_reason": "",
    }
    for side in ("APP", "PC"):
        good = []
        reasons_all = []
        for row in net_rows[side]:
            ok, reasons = net_qualified(row, side, expected_rom_md5)
            info["rows"].setdefault(side, []).append(row)
            if ok:
                good.append(row)
            else:
                reasons_all.append({
                    "ref": "%s:%s" % (os.path.basename(row["file"]), row["line"]),
                    "reasons": reasons,
                })
        info["qualified"][side] = good
        info["reasons"][side] = reasons_all
        seqs = [net_int(r["fields"], "seq") for r in good]
        info["seq"][side] = seqs
        info["mono"][side] = all(b > a for a, b in zip(seqs, seqs[1:]))

    qa, qp = info["qualified"]["APP"], info["qualified"]["PC"]
    info["qualified_counts"] = {"APP": len(qa), "PC": len(qp)}
    if not qa or not qp or not info["mono"]["APP"] or not info["mono"]["PC"]:
        info["verdict_reason"] = "缺合格样本或 seq 非单调"
        return False, info
    if info["net_gray"] or info["gray_brs"]:
        info["verdict_reason"] = "NETGRAY/RHBRS 灰区强写在场，拒认闭合"
        return False, info

    app_rx = {r["fields"]["rx_digest"].upper() for r in qa}
    pc_tx = {r["fields"]["tx_digest"].upper() for r in qp}
    pc_rx = {r["fields"]["rx_digest"].upper() for r in qp}
    app_tx = {r["fields"]["tx_digest"].upper() for r in qa}
    digest_ok = (len(app_rx) == 1 and app_rx == pc_tx
                 and len(pc_rx) == 1 and pc_rx == app_tx
                 and app_rx != pc_rx)
    info["digest_ok"] = digest_ok
    info["digests"] = {
        "app_rx": sorted(app_rx), "pc_tx": sorted(pc_tx),
        "pc_rx": sorted(pc_rx), "app_tx": sorted(app_tx),
    }

    md5s = {r["fields"]["rom_md5"].lower() for r in (qa + qp)}
    rom_ok = (len(md5s) == 1)
    info["rom_md5_ok"] = rom_ok
    info["rom_md5s"] = sorted(md5s)

    seq_overlap = bool(set(info["seq"]["APP"]) & set(info["seq"]["PC"]))
    info["seq_overlap"] = seq_overlap

    ok = digest_ok and rom_ok and seq_overlap
    info["verdict_reason"] = "通过" if ok else "digest/rom_md5/seq 跨端对账失败"
    return ok, info


def check(run_dir, mode=MODE_AUTO, l0_mode=L0_SIO, expected_rom_md5=None):
    """模式分派：auto 维持原标签计数；zero/inject 由 CLI 显式钉死（fail-closed）。

    mode=zero 不绕过注入标签检测：仍完整扫描；任一注入标签命中即告警 + 降级
    UNOBSERVED，绝不输出 mode=ZERO 的裁决级 CROSSED（W62 高危误判的闸门）。

    l0_mode=sio（默认）逐字保留现有 SIO 块闭合判据（向后兼容）；
    l0_mode=netgate 走 pathB-net 等效 L0 重锚（只读 [NETGATE] 字段），
    不修改任何 sio 判据分支。
    """
    if not os.path.isdir(run_dir):
        raise SystemExit("ERROR: 不是目录：%s" % run_dir)
    if l0_mode not in L0_MODES:
        raise SystemExit("ERROR: 未知 L0 模式：%s" % l0_mode)

    records, file_sides = load(run_dir)
    if l0_mode == L0_NETGATE:
        return check_netgate(records, file_sides, run_dir, mode, expected_rom_md5)
    inj_hits = [r for r in records if r["tag"] in INJ_TAGS]
    inj_tags = sorted({r["tag"] for r in inj_hits})
    mode_source = (MODE_SOURCE_EXPLICIT if mode in (MODE_ZERO, MODE_INJECT)
                   else MODE_SOURCE_AUTO)

    def _stamp(result, warning=None, contradiction=False):
        """所有返回路径统一回填模式溯源字段；禁止任何分支静默缺字段。"""
        result["mode_source"] = mode_source
        result["mode_warning"] = warning
        result["injection_contradiction"] = bool(contradiction)
        return result

    if mode == MODE_INJECT:
        return _stamp(check_inject(records, file_sides, run_dir))

    if mode == MODE_ZERO:
        # 关键安全闸（fail-closed）：显式 zero 仍扫标签，命中即降级，不能静默放行。
        # 阈值取 1（比 auto 的 >=2 更严）：只要出现任何注入标签，数据与「纯零注入」
        # 前提矛盾，拒绝以零注入口径出裁决级 CROSSED。
        if inj_hits:
            warning = ("--mode zero 显式要求零注入，但 run 目录命中 %d 行注入标签(%s)："
                       "拒绝以零注入口径裁决，降级 UNOBSERVED（fail-closed，非纯零注入）。"
                       % (len(inj_hits), ",".join(inj_tags)))
            result = _stamp(check_zero(records, file_sides, run_dir), warning, True)
            result["verdict"] = "UNOBSERVED"
            result["verdict_cn"] = "显式zero与注入标签矛盾，拒绝裁决(fail-closed)"
            result["exit_code"] = 3
            result["notes"].append(warning)
            # 纠正 check_zero 内置 evidence「未命中注入标签」的自述，避免 JSON 自相矛盾。
            result["evidence"].append(
                "MODE_ZERO_CONTRADICTION=1  # 注入标签命中，零注入前提破裂，拒绝裁决(fail-closed)")
            return result
        return _stamp(check_zero(records, file_sides, run_dir))

    # auto：原逻辑逐字保留（>=2 标签行切 INJECT），历史 run 结论不回归。
    if len(inj_hits) >= 2:
        return _stamp(check_inject(records, file_sides, run_dir))
    return _stamp(check_zero(records, file_sides, run_dir))


def check_inject(records, file_sides, run_dir):
    """旧注入模式：原 7 bucket 判据原样保留，历史 run 不回归。"""
    ev = []
    ev.append("RUN_DIR=%s" % os.path.abspath(run_dir))
    ev.append("LOG_FILES=%d TAG_LINES=%d" %
              (len(file_sides), len(records)))

    # 收集每个字段的 (species, ref)
    buckets = {
        "pc_party_first": [],       # [SPENC] species  -> PC party 首位
        "pc_rx_app_party": [],      # [RHVIS] pcSp[0]/sp0 -> PC 解码到的 APP party 首位
        "pc_opponent_box": [],      # [RHVIS] epSp[0]   -> PC 对手框
        "app_rx_pc_party": [],      # [SPDEC] sp0        -> APP 解码到的 PC party 首位
        "app_opponent_box": [],     # [RHREND] bm[0]     -> APP 对手框
        "opp_pc_side": [],          # [OPPSPECIES] mons[0] 归到 PC 侧（佐证/回退）
        "opp_app_side": [],         # [OPPSPECIES] mons[0] 归到 APP 侧（佐证/回退）
    }
    rhplyr_count = 0

    for r in records:
        tag, f, side = r["tag"], r["fields"], r["side"]
        ref = {"file": os.path.basename(r["file"]), "line": r["line"], "raw": r["raw"]}
        if tag == "RHPLYR":
            rhplyr_count += 1
            continue
        if tag == "SPENC":
            buckets["pc_party_first"].append((norm_sp(f.get("species")), ref))
        elif tag == "SPDEC":
            buckets["app_rx_pc_party"].append((norm_sp(f.get("sp0")), ref))
        elif tag == "RHREND":
            buckets["app_opponent_box"].append((norm_sp(f.get("bm")), ref))
        elif tag == "RHVIS":
            buckets["pc_rx_app_party"].append((norm_sp(f.get("pcSp")), ref))
            buckets["pc_rx_app_party"].append((norm_sp(f.get("sp0")), ref))
            buckets["pc_opponent_box"].append((norm_sp(f.get("epSp")), ref))
        elif tag == "OPPSPECIES":
            v = norm_sp(f.get("mons") or f.get("mons[0..3]"))
            if side == "APP":
                buckets["app_opponent_box"].append((v, ref))
                buckets["opp_app_side"].append((v, ref))
            elif side == "PC":
                buckets["pc_opponent_box"].append((v, ref))
                buckets["opp_pc_side"].append((v, ref))
            else:
                # 侧别不明：只记原始证据，不作判据（绝不靠猜）
                buckets.setdefault("opp_unclassified", []).append((v, ref))

    obs = {k: pick(v) for k, v in buckets.items() if k in
           ("pc_party_first", "pc_rx_app_party", "pc_opponent_box",
            "app_rx_pc_party", "app_opponent_box")}
    for k in ("opp_pc_side", "opp_app_side", "opp_unclassified"):
        if k in buckets:
            obs[k] = pick(buckets[k])

    ev.append("RHPLYR_LINES=%d  # trainer 卡，无 species，仅记存在" % rhplyr_count)

    def sval(k):
        d = obs.get(k, {})
        return d.get("species")

    pc_party = sval("pc_party_first")          # 期望 0006（喷火龙）
    app_party = sval("pc_rx_app_party")        # 期望 00D5（壶壶，PC 解码 APP sidecar）
    app_box = sval("app_opponent_box")         # APP 对手框实测
    pc_box = sval("pc_opponent_box")           # PC 对手框实测
    app_rx_pc = sval("app_rx_pc_party")        # 佐证：APP 收到 PC 字节

    # ---- 交叉/回显检查：用实验设定的目标物种作判据基准 ----
    app_crossed = (app_box == EXPECTED_PC_PARTY_FIRST) if app_box else None
    pc_crossed = (pc_box == EXPECTED_APP_PARTY_FIRST) if pc_box else None
    app_self = (app_box == EXPECTED_APP_PARTY_FIRST) if app_box else None
    pc_self = (pc_box == EXPECTED_PC_PARTY_FIRST) if pc_box else None

    checks = {
        "app_opponent_eq_pc_party_expected": app_crossed,
        "pc_opponent_eq_app_party_expected": pc_crossed,
        "app_opponent_is_self_echo": app_self,
        "pc_opponent_is_self_echo": pc_self,
    }

    notes = []
    # setup 健全性：观测到的 party 首位是否真等于实验设定
    if pc_party and pc_party != EXPECTED_PC_PARTY_FIRST:
        notes.append("PC party 首位实测 %s(%s) != 喷火龙 %s：实验设定可能未生效，"
                     "仍按设定目标判对手框" %
                     (pc_party, sp_name(pc_party), EXPECTED_PC_PARTY_FIRST))
    if app_party and app_party != EXPECTED_APP_PARTY_FIRST:
        notes.append("APP party 首位(PC sidecar 解码)实测 %s(%s) != 壶壶 %s："
                     "APP 端可能未保留壶壶/侧信道失败" %
                     (app_party, sp_name(app_party), EXPECTED_APP_PARTY_FIRST))
    if app_rx_pc and app_rx_pc != EXPECTED_PC_PARTY_FIRST:
        notes.append("APP 解码到的 PC party 首位 sp0=%s(%s) != 喷火龙 %s" %
                     (app_rx_pc, sp_name(app_rx_pc), EXPECTED_PC_PARTY_FIRST))

    box_observed = bool(app_box or pc_box)
    if app_crossed is True and pc_crossed is True:
        verdict, verdict_cn = "CROSSED", "真交换（两端对手框交叉，数据确实过网）"
        exit_code = 0
    elif (app_self is True or pc_self is True) and not (
            app_crossed is True and pc_crossed is True):
        verdict, verdict_cn = "SELF_ECHO", "自我回显（对手框显示本端自己的 party 首位）"
        exit_code = 1
    elif box_observed:
        verdict, verdict_cn = "UNOBSERVED", "观测值不符合任一假设，请人工核对"
        exit_code = 3
        notes.append("APP 对手框=%s PC 对手框=%s，既非交叉也非典型自回显，"
                     "不硬断为回显" %
                     (app_box or "<缺>", pc_box or "<缺>"))
    else:
        verdict, verdict_cn = "UNOBSERVED", "缺关键物种证据"
        exit_code = 3
        if not app_box:
            notes.append("缺 APP 对手框物种（[RHREND] bm / APP 侧 [OPPSPECIES] mons）")
        if not pc_box:
            notes.append("缺 PC 对手框物种（[RHVIS] epSp）")

    # 证据行（带 file:line）
    for k in ("pc_party_first", "pc_rx_app_party", "app_rx_pc_party",
              "app_opponent_box", "pc_opponent_box"):
        d = obs[k]
        ref = d.get("ref") or {}
        ev.append("%-18s = %s  # %s:%s" %
                  (k, d.get("species") or "???",
                   ref.get("file", "-"), ref.get("line", "-")))

    result = {
        "verdict": verdict,
        "verdict_cn": verdict_cn,
        "exit_code": exit_code,
        "mode": "INJECT",
        "mode_alias": None,      # 注入 run 无 path B 零注入别名
        "experiment": {
            "pc_party_first_expected": EXPECTED_PC_PARTY_FIRST,
            "pc_party_first_name": sp_name(EXPECTED_PC_PARTY_FIRST),
            "app_party_first_expected": EXPECTED_APP_PARTY_FIRST,
            "app_party_first_name": sp_name(EXPECTED_APP_PARTY_FIRST),
        },
        "observed": obs,
        "checks": checks,
        "evidence": ev,
        "notes": notes,
    }
    return result


def check_zero(records, file_sides, run_dir):
    """零注入（MGBAX_RH_OFF=1）正道判据。

    只剩 [OPPSPECIES] / [RHPLYR]（可选 [OPPGATE] L0 具名打点）：
      * 主证据 [OPPSPECIES] mons= 是 gBattleMons[0..3].species（L2，不是 gEnemyParty）；
      * 不赌"哪个槽才是对手"，用差分标记（APP=0006 / PC=00D5）在四值中找对端；
      * [OPPGATE] blkSp0 是 L0（gBlockRecvBuffer enemy 槽首只 species），有则做
        L0/L2 交叉复核；无则诚实降级 L2-only 并记 note。
    """
    ev = []
    ev.append("RUN_DIR=%s" % os.path.abspath(run_dir))
    ev.append("LOG_FILES=%d TAG_LINES=%d" %
              (len(file_sides), len(records)))
    ev.append("MODE=ZERO  # 未命中注入标签，按零注入正道判据")
    ev.append("MODE_ALIAS=%s  # 零注入 path B 裁决通道，不要求任何注入标签（门槛未降）"
              % MODE_ALIAS_ZERO)

    # 红线（W52）：brs=0101 既可能是游戏原生闭合，也可能是灰区 RHBRS GBAPatch8
    # 伪 ACK（两者字节同值，brs 自身不可区分）。有灰区强写标记在场时拒认闭合，
    # 即修正后的 brs 口径只在零注入轮（无灰区强写）启用。
    gray_brs = gray_force_present(run_dir)
    ev.append("GRAY_BRS=%s  # 灰区强写标记在场时，brs=0101 拒认闭合（红线）" % gray_brs)

    notes = []
    if gray_brs:
        notes.append("[OPPGATE] 命中 RHBRS/RHBRS-GRAY 灰区强写 brs 标记：brs=0101 不可辨真伪"
                     "（伪 ACK 与原生闭合同值），拒绝据此认 L0 闭合，不判 CROSSED")
    app_rows, pc_rows = [], []
    oppgate_rows = {"APP": [], "PC": []}
    rhplyr_count = 0

    for r in records:
        tag = r["tag"]
        ref = {"file": os.path.basename(r["file"]), "line": r["line"], "raw": r["raw"]}
        base = file_base_side(r["file"])
        side, why = decide_side(r, base) if tag in ("OPPSPECIES", "RHPLYR") else (base, None)
        if why:
            notes.append("%s:%s %s" % (ref["file"], ref["line"], why))

        if tag == "RHPLYR":
            rhplyr_count += 1  # trainer 卡，无 species，仅记存在
            continue
        if tag == "OPPSPECIES":
            if side not in ("APP", "PC"):
                notes.append("%s:%s OPPSPECIES 侧别不明（内容签名/文件名均缺失或冲突），不作判据"
                             % (ref["file"], ref["line"]))
                continue
            m = OPP_MONS_RE.search(r["raw"])
            if not m:
                notes.append("%s:%s OPPSPECIES 无 mons= 字段" %
                             (ref["file"], ref["line"]))
                continue
            vals = [norm_sp(x) for x in m.group(1).split(",")]
            ec = parse_count(r["fields"].get("enemyPartyCnt"))
            (app_rows if side == "APP" else pc_rows).append((vals, ec, ref))
        elif tag == "OPPGATE":
            if side not in ("APP", "PC"):
                notes.append("%s:%s OPPGATE 文件名无法判侧别，忽略" %
                             (ref["file"], ref["line"]))
                continue
            sp = norm_sp(r["fields"].get("blkSp0"))
            brs = parse_hex(r["fields"].get("brs"))
            blk_cnt = parse_count(r["fields"].get("cnt"))
            hdr_raw = r["fields"].get("blkHdr")          # Z74 P3: 块头语义（命令块负向校验）
            size_raw = r["fields"].get("blkSize")        # B 案 C 打点字段；旧日志缺=None
            blk_size = parse_hex(size_raw) if size_raw is not None else None
            # (blkSp0, ref, brs, cnt, blkHdr, blkSize)：brs/cnt 供 P0 硬门槛；
            # blkHdr 供命令块负向校验；blkSize 仅 JSON 暴露（严格块长校验属 B 案）。
            oppgate_rows[side].append((sp, ref, brs, blk_cnt, hdr_raw, blk_size))

    ev.append("RHPLYR_LINES=%d  # trainer 卡，无 species，仅记存在" % rhplyr_count)

    def pick_opp(rows, side):
        """返回 (opp_species, src_tag, ec, ref, polluted)；差分标记 + 槽位语义破槽位悬案。

        polluted = 归一后非法的 mons 值（2222/BBBB/8888/058B…），回传供 JSON
        显式暴露 ZERO 模式被静默丢弃的污染（Z74 P1）。
        cross_marker 只在「对端标记落在对手槽 slot1、且本端槽 slot0 未被对端标记污染」
        时成立。标记只出现在 slot0/其它槽、或 slot0 也被污染 -> 事实不清，记
        cross_marker_wrongslot，绝不作为交叉判据（Y12 探针 1/4 假阳性通道）。"""
        if not rows:
            return (None, "missing", None, None, [])
        last = rows[-1]                       # 取最后一次合法采样
        vals = last[0]
        valid = [v for v in vals if valid_sp(v)]
        # 0000 = 空的 gBattleMons 槽，不是污染；只暴露真实垃圾值(2222/BBBB/8888/058B…)
        polluted = sorted({v for v in vals if v and v != "0000" and not valid_sp(v)})
        if not valid:
            return (None, "no_valid_species", last[1], last[2], polluted)
        slot0 = vals[0] if len(vals) > 0 else None
        slot1 = vals[1] if len(vals) > 1 else None
        remote = REMOTE[side]
        if slot1 == remote:
            if slot0 == LOCAL[side]:
                # 对手槽=对端标记，本端槽=本端差分标记（合法己方物种）-> 真交叉形态
                return (remote, "cross_marker", last[1], last[2], polluted)
            if not valid_sp(slot0):
                # slot0 为 2222/BBBB/8888/058B/FFFF/0000 等污染 -> 事实不清，fail-closed
                return (remote, "cross_marker_slot0_polluted", last[1], last[2], polluted)
            # slot0 是合法物种但不是本端差分标记（可能换首发/异常）-> 人工核，不硬断交叉
            return (remote, "cross_marker_slot0_unexpected", last[1], last[2], polluted)
        if remote in valid:
            # 对端标记出现过，但不在对手槽 / 本端槽也被污染 -> 事实不清，不判交叉
            return (remote, "cross_marker_wrongslot", last[1], last[2], polluted)
        if slot0 == LOCAL[side]:
            return (LOCAL[side], "slot0_self", last[1], last[2], polluted)
        if valid_sp(slot1):
            return (slot1, "battler1_fallback", last[1], last[2], polluted)
        return (None, "ambiguous", last[1], last[2], polluted)

    app_opp, app_src, app_ec, app_ref, app_polluted = pick_opp(app_rows, "APP")
    pc_opp, pc_src, pc_ec, pc_ref, pc_polluted = pick_opp(pc_rows, "PC")

    # 交叉只认 src=cross_marker（对端标记在对手槽 slot1）；wrongslot/回显/回退
    # 一律不算，即使物种值恰好等于对端标记（Y12 探针 1/4 假阳性通道）。
    app_crossed = True if app_src == "cross_marker" else (False if app_opp else None)
    pc_crossed = True if pc_src == "cross_marker" else (False if pc_opp else None)
    app_self = (app_opp == LOCAL["APP"]) if app_opp else None        # APP 见 00D5 = 回显
    pc_self = (pc_opp == LOCAL["PC"]) if pc_opp else None            # PC 见 0006 = 回显

    # [OPPGATE] 的 blkSp0 = gBlockRecvBuffer enemy 槽首只 species（L0）。
    # 本实验的 OPPGATE 两端同格式、无内容签名，侧别只能用文件名；有则复核 L2。
    # P0：brs 陷阱（blkSp0 非 0 但 brs=0，块未闭合/训练家卡块）必须挡在门外：
    # 闭合态 = brs_closed()：C 侧 %04X 打印 GBAView16(0x03002A40) 原始读 0x0101
    # （两字节各=1），不是拼装位域 0003；旧 brs&3==3 因 0x0101&3==1 恒不合格
    # （W35 §3.4 结构性假阴性）。再叠加 blkSp0 合法 + cnt>0 + 块头非命令字。
    # 红线：RHBRS/RHBRS-GRAY 灰区强写也写 0101，brs 数值不可辨真伪；
    # gray_brs 为真时一律无合格样本，拒认闭合。
    def oppgate_l0():
        """通读全部 OPPGATE 样本（不只末条），返回 (cross, info)。

        合格样本 = valid_sp(blkSp0) 且 brs_closed(brs) 且 cnt>0 且 block_valid(blkHdr)。
        W39-F1：block_valid 对 blkHdr 缺字段/畸形 fail-closed；hdr_observable 为 False
        （两端都无合法块头）时 L0 结构性不裁决，UNOBSERVED，不判 CROSSED。
        brs_closed = 原始读两字节各=1(0x0101)；拒 0000/部分态/0003 位域/畸形值。
        Z74 P3：blkHdr 命中命令字(BBBB/8888/2222)的命令块不算合格样本。
        红线：gray_brs=True（命中 RHBRS 灰区强写标记）时一律无合格样本，
        因为 0101 可能是伪 ACK，无法与原生闭合区分——拒灰区强写。
        两端都有合格样本时，仅当两端「全部合格样本」blkSp0 均为对端标记才 True
        （防单帧瞬态/仅末条对，Y12 探针 3）；有合格样本但不全交叉 False；
        缺任一端合格样本 None（brs 陷阱/块未闭合/命令块/灰区强写走此路，不判 CROSSED）。
        """
        info = {}
        for side in ("APP", "PC"):
            rows = oppgate_rows[side]
            qualified = ([row for row in rows
                          if valid_sp(row[0]) and brs_closed(row[2]) and row[3] > 0
                          and block_valid(row[4])] if not gray_brs else [])
            info[side] = {
                "rows": rows,
                "qualified": qualified,
                "last_brs": rows[-1][2] if rows else None,
                "any_closed": (any(brs_closed(row[2]) for row in rows)
                               if not gray_brs else False),
                "block_valid_seen": [block_valid(row[4]) for row in rows],
                "hdr_seen": any(hdr_observable(row[4]) for row in rows),
            }
        # W39-F1：块头维结构性未覆盖（两端都无合法 blkHdr）-> L0 不裁决。
        # 若仅部分样本缺/畸形，这些样本已被 block_valid fail-closed 排除，
        # 只要某端仍有合格样本且全合格样本交叉，真 CROSSED 仍可成立。
        obs_any = any(hdr_observable(row[4])
                      for side in ("APP", "PC") for row in oppgate_rows[side])
        info["hdr_observable"] = obs_any
        if not obs_any:
            return None, info
        qa, qp = info["APP"]["qualified"], info["PC"]["qualified"]
        if gray_brs or not qa or not qp:
            return None, info
        a_ok = all(row[0] == REMOTE["APP"] for row in qa)
        p_ok = all(row[0] == REMOTE["PC"] for row in qp)
        return (a_ok and p_ok), info

    l0_cross, gate_info = oppgate_l0()
    rows_a, rows_p = oppgate_rows["APP"], oppgate_rows["PC"]
    if not rows_a and not rows_p:
        notes.append("L2-only：OPPSPECIES=gBattleMons；零注入下 L0/L1 物种无日志（未见 [OPPGATE]），"
                     "完整对手真实性需 [OPPGATE]+B7 后再判；L2-only 不输出裁决级 CROSSED")
    elif not rows_a or not rows_p:
        notes.append("[OPPGATE] 仅单端出现，L0 交叉复核不成立，按 L2-only 解读（降级 UNOBSERVED）")
    else:
        for side in ("APP", "PC"):
            if not gate_info[side]["qualified"]:
                notes.append("[OPPGATE] %s 无合格样本（blkSp0 合法 + brs 两字节各=1(0101)闭合 + cnt>0 + 块头合法非命令字 缺一不可；"
                             "末条 brs=%s%s），brs 陷阱/块未闭合/块头缺或畸形/命令块/灰区强写，L0 不成立，不判 CROSSED" %
                             (side, gate_info[side]["last_brs"],
                              " (灰区强写在场)" if gray_brs else ""))
                if any(not block_valid(row[4]) for row in oppgate_rows[side]):
                    notes.append("[OPPGATE] %s 块头命中命令字(BBBB/8888/2222)、缺字段或形态畸形："
                                 "已 fail-closed 不计合格，L0 无合格样本，不判 CROSSED" % side)
    if not gate_info["hdr_observable"]:
        notes.append("[OPPGATE] 两端均无可观测的合法 blkHdr（缺字段/畸形已 fail-closed）："
                     "块头维结构性未覆盖，L0 不裁决，不判 CROSSED")

    if app_src == "cross_marker_wrongslot" or pc_src == "cross_marker_wrongslot":
        notes.append("对端标记未在对手槽(slot1)或本端槽(slot0)也被标记污染：事实不清，不判交叉")
    if app_src == "cross_marker_slot0_polluted" or pc_src == "cross_marker_slot0_polluted":
        notes.append("本端槽 slot0 含非法 species（2222/BBBB/8888/058B/FFFF/0000 等）：交叉事实不清，不判 CROSSED")
    if app_src == "cross_marker_slot0_unexpected" or pc_src == "cross_marker_slot0_unexpected":
        notes.append("slot0 是合法物种但非本端差分标记：需人工核对首发，不硬断交叉")

    if app_src == "battler1_fallback" or pc_src == "battler1_fallback":
        notes.append("槽位不确定：已按 H4 的 gBattleMons[1] 回退取值，需 [OPPGATE] 复核")
    if (app_crossed or pc_crossed) and (app_ec in (0, None) or pc_ec in (0, None)):
        notes.append("enemyPartyCnt=0：gEnemyPartyCount 未填充，UI 框可能仍 ? Lv0（L1 未就绪），"
                     "降级不判 CROSSED")

    degenerate = degenerate_precondition(LOCAL, REMOTE)
    degenerate_check = {
        "kind": "structural",
        "observable": False,
        "value": degenerate,
        "note": "LOCAL/REMOTE 由 EXPECTED_* 常量派生；当前差分设定 0006/00D5 下恒 False。"
                "此为结构性前提重述，非独立运行时观测；工具未读取 sav，不能证明本次 run 两端 party 真不同。"
                "差分前提须由 sav md5 + section-id 重组读外部核（W29），不据此出 PASS/CROSSED。",
    }
    notes.append("degenerate 结构性前提=%s（恒空判据，非独立观测，不构成防线）" % degenerate)

    both_crossed = (app_crossed is True and pc_crossed is True)
    cnt_ok = not (app_ec in (0, None) or pc_ec in (0, None))
    if l0_cross is False:
        notes.append("[OPPGATE] 合格 blkSp0(L0) 与 L2 不一致/非全交叉：已降级为 UNOBSERVED，需人工复核")

    if degenerate or l0_cross is False:
        verdict, verdict_cn, exit_code = "UNOBSERVED", "判据前提不成立或 L0/L2 矛盾，不硬断", 3
    elif both_crossed and l0_cross is not True:
        verdict, verdict_cn, exit_code = ("UNOBSERVED",
                                          "仅 L2 交叉、L0 未闭合确认，降级不输出裁决级 CROSSED", 3)
    elif both_crossed and not cnt_ok:
        verdict, verdict_cn, exit_code = ("UNOBSERVED",
                                          "enemyPartyCnt=0（L1 未就绪），降级不判 CROSSED", 3)
    elif both_crossed:
        verdict, verdict_cn, exit_code = ("CROSSED", "真交换（两端 L2 交叉 + L0 闭合双交叉）", 0)
        qa, qp = gate_info["APP"]["qualified"], gate_info["PC"]["qualified"]
        ev.append("OPPGATE blkSp0(L0) APP=%s / PC=%s  # L0/L2 双交叉(brs=0101 两字节各=1, cnt>0, 无灰区强写)" %
                  (qa[-1][0], qp[-1][0]))
        ev.append("OPPGATE 合格样本数 APP=%d / PC=%d  末条 brs APP=%s PC=%s" %
                  (len(qa), len(qp), gate_info["APP"]["last_brs"], gate_info["PC"]["last_brs"]))
    elif app_self is True or pc_self is True:
        verdict, verdict_cn, exit_code = ("SELF_ECHO", "自我回显（对手 L2 显示本端自己的 party 首位）", 1)
    else:
        verdict, verdict_cn, exit_code = "UNOBSERVED", "缺关键物种证据或观测值不符合假设", 3
        if not app_rows:
            notes.append("缺 APP 侧 [OPPSPECIES] mons（或侧别/战斗窗口未命中）")
        if not pc_rows:
            notes.append("缺 PC 侧 [OPPSPECIES] mons（或侧别/战斗窗口未命中）")
        if app_rows and pc_rows and not (app_crossed or pc_crossed or app_self or pc_self):
            notes.append("APP L2=%s(%s) PC L2=%s(%s)，既非交叉也非典型回显，不硬断" %
                         (app_opp or "<缺>", app_src, pc_opp or "<缺>", pc_src))

    ev.append("APP OPPSPECIES(L2)=%s src=%s ec=%s  # %s:%s" %
              (app_opp or "???", app_src, app_ec if app_ec is not None else "-",
               (app_ref or {}).get("file", "-"), (app_ref or {}).get("line", "-")))
    ev.append("PC  OPPSPECIES(L2)=%s src=%s ec=%s  # %s:%s" %
              (pc_opp or "???", pc_src, pc_ec if pc_ec is not None else "-",
               (pc_ref or {}).get("file", "-"), (pc_ref or {}).get("line", "-")))

    def obs_entry(sp, ref, src, invalid_seen=None, block_hdr=None, blk_size=None):
        inv = list(invalid_seen or [])
        return {
            "species": sp, "name": sp_name(sp) if sp else "???",
            "ref": ref, "valid": bool(sp and valid_sp(sp)),
            "distinct": sorted({v for v in ([sp] + inv) if v}),
            "invalid_seen": inv, "source": src,
            "block_hdr": block_hdr, "blk_size": blk_size,
        }

    missing = {"species": None, "name": "???（零注入无此标签）", "ref": None,
               "valid": False, "distinct": [], "invalid_seen": [],
               "block_hdr": None, "blk_size": None}
    obs = {
        "pc_party_first": dict(missing),      # [SPENC] 零注入下关闭
        "pc_rx_app_party": dict(missing),     # [RHVIS] 零注入下关闭
        "app_rx_pc_party": dict(missing),     # [SPDEC] 零注入下关闭
        "app_opponent_box": obs_entry(app_opp, app_ref, app_src, app_polluted),
        "pc_opponent_box": obs_entry(pc_opp, pc_ref, pc_src, pc_polluted),
        "opp_app_side": obs_entry(app_opp, app_ref, app_src, app_polluted),
        "opp_pc_side": obs_entry(pc_opp, pc_ref, pc_src, pc_polluted),
        "oppgate_l0_app": obs_entry(
            oppgate_rows["APP"][-1][0] if oppgate_rows["APP"] else None,
            oppgate_rows["APP"][-1][1] if oppgate_rows["APP"] else None, "blkSp0",
            block_hdr=(oppgate_rows["APP"][-1][4] if oppgate_rows["APP"] else None),
            blk_size=(oppgate_rows["APP"][-1][5] if oppgate_rows["APP"] else None)),
        "oppgate_l0_pc": obs_entry(
            oppgate_rows["PC"][-1][0] if oppgate_rows["PC"] else None,
            oppgate_rows["PC"][-1][1] if oppgate_rows["PC"] else None, "blkSp0",
            block_hdr=(oppgate_rows["PC"][-1][4] if oppgate_rows["PC"] else None),
            blk_size=(oppgate_rows["PC"][-1][5] if oppgate_rows["PC"] else None)),
    }
    checks = {
        "app_opponent_eq_pc_party_expected": app_crossed,
        "pc_opponent_eq_app_party_expected": pc_crossed,
        "app_opponent_is_self_echo": app_self,
        "pc_opponent_is_self_echo": pc_self,
        "oppgate_l0_cross": l0_cross,
        # 新增透明字段：供人工核对 brs 陷阱 / 槽位语义 / ec 降级 / 2222 污染 / 命令块
        "oppgate_l0_qualified_app": bool(gate_info["APP"]["qualified"]),
        "oppgate_l0_qualified_pc": bool(gate_info["PC"]["qualified"]),
        "enemy_party_cnt_ok": cnt_ok,
        "cross_marker_slot_ok": (app_src not in ("cross_marker_wrongslot",
                                                 "cross_marker_slot0_polluted",
                                                 "cross_marker_slot0_unexpected")
                                 and pc_src not in ("cross_marker_wrongslot",
                                                    "cross_marker_slot0_polluted",
                                                    "cross_marker_slot0_unexpected")),
        "mons_pollution_app": bool(app_polluted),
        "mons_pollution_pc": bool(pc_polluted),
        "oppgate_block_valid_app": any(block_valid(row[4]) for row in oppgate_rows["APP"]),
        "oppgate_block_valid_pc": any(block_valid(row[4]) for row in oppgate_rows["PC"]),
        "oppgate_hdr_observable": gate_info["hdr_observable"],
        "oppgate_hdr_seen_app": gate_info["APP"]["hdr_seen"],
        "oppgate_hdr_seen_pc": gate_info["PC"]["hdr_seen"],
        "cross_marker_slot0_clean": (app_src == "cross_marker" and pc_src == "cross_marker"),
    }
    return {
        "verdict": verdict,
        "verdict_cn": verdict_cn,
        "exit_code": exit_code,
        "mode": "ZERO",
        "mode_alias": MODE_ALIAS_ZERO,
        "criterion": zero_criterion(),
        "injection_tags_required": False,
        "degenerate_check": degenerate_check,
        "degenerate_is_observation": False,
        "experiment": {
            "pc_party_first_expected": EXPECTED_PC_PARTY_FIRST,
            "pc_party_first_name": sp_name(EXPECTED_PC_PARTY_FIRST),
            "app_party_first_expected": EXPECTED_APP_PARTY_FIRST,
            "app_party_first_name": sp_name(EXPECTED_APP_PARTY_FIRST),
        },
        "observed": obs,
        "checks": checks,
        "evidence": ev,
        "notes": notes,
    }


def check_netgate(records, file_sides, run_dir, mode=MODE_AUTO, expected_rom_md5=None):
    """pathB-net 等效 L0 裁决（只读 [NETGATE] 字段，不改任何 sio 判据分支）。

    门槛不降：NETGATE L0 闭合 + 跨端 digest 对账 + 全部旧否定门
    （ec>0 / 无注入标签 / 非 SELF_ECHO / species 合法 / L2 cross_marker / 无灰区 / fail-closed）。
    HMAC 局限与_writer≠checker 隔离如实写入 notes/criterion。
    """
    ev, notes = [], []
    ev.append("RUN_DIR=%s" % os.path.abspath(run_dir))
    ev.append("MODE=NETGATE  # L0_MODE=netgate（pathB-net 等效重锚）；判据可用≠对手真实已证")
    ev.append("L0_ANCHOR=%s" % netgate_criterion()["l0_anchor"])

    def _res(verdict, verdict_cn, exit_code, **extra):
        base = {
            "verdict": verdict, "verdict_cn": verdict_cn,
            "exit_code": exit_code,
            "mode": "NETGATE",
            "l0_mode": L0_NETGATE,
            "mode_alias": NETGATE_ALIAS,
            "requested_mode": mode,
            "criterion": netgate_criterion(),
            "writer_checker_separated": True,
            "evidence": ev, "notes": notes,
            "mode_source": MODE_SOURCE_EXPLICIT,   # l0_mode 由 CLI 显式钉死
            "mode_warning": None,
            "injection_contradiction": False,
        }
        base.update(extra)
        return base

    # 旧否定门：无注入标签（fail-closed，参照 --mode zero 的 W62 闸门）
    inj_hits = [r for r in records if r["tag"] in INJ_TAGS]
    inj_tags = sorted({r["tag"] for r in inj_hits})
    ev.append("INJECTION_TAGS=%d  # 命中即拒裁（fail-closed）" % len(inj_hits))
    if inj_hits:
        warning = ("NETGATE 要求零注入，但 run 命中 %d 行注入标签(%s)："
                   "拒绝以 NETGATE 口径裁决，降级 UNOBSERVED（fail-closed，非纯零注入）。"
                   % (len(inj_hits), ",".join(inj_tags)))
        notes.append(warning)
        ev.append("NETGATE_INJECTION_CONTRADICTION=1")
        return _res("UNOBSERVED", "注入标签命中，拒绝以 NETGATE 口径裁决(fail-closed)", 3,
                    mode_warning=warning, injection_contradiction=True)

    # 复用 check_zero 的 L2 cross_marker 提取（完全不修改其判据分支）
    z = check_zero(records, file_sides, run_dir)
    zc = z["checks"]
    app_l2 = zc["app_opponent_eq_pc_party_expected"]
    pc_l2 = zc["pc_opponent_eq_app_party_expected"]
    slot_ok = zc["cross_marker_slot_ok"]
    ec_ok = zc["enemy_party_cnt_ok"]
    polluted = bool(zc["mons_pollution_app"] or zc["mons_pollution_pc"])
    app_self = zc["app_opponent_is_self_echo"]
    pc_self = zc["pc_opponent_is_self_echo"]
    ev.append("L2(复用ZERO的OPPSPECIES cross_marker)：APP=%s PC=%s slot_ok=%s ec_ok=%s polluted=%s"
              % (app_l2, pc_l2, slot_ok, ec_ok, polluted))

    # NETGATE 行侧别：role 内容签名为主、文件名兜底；冲突 fail-closed
    net_rows = {"APP": [], "PC": []}
    raw_rows = load_netgate(run_dir)
    for row in raw_rows:
        role = (row["fields"].get("role") or "").upper()
        base = row["base_side"]
        if role and base and role != base:
            notes.append("%s:%s NETGATE role=%s 与文件名侧别 %s 冲突，忽略(fail-closed)"
                         % (os.path.basename(row["file"]), row["line"], role, base))
            continue
        side = role or base
        if side not in ("APP", "PC"):
            notes.append("%s:%s NETGATE 侧别不明(role/文件名均缺)，忽略"
                         % (os.path.basename(row["file"]), row["line"]))
            continue
        net_rows[side].append(row)
    ev.append("NETGATE_LINES=%d  # APP=%d PC=%d"
              % (len(raw_rows), len(net_rows["APP"]), len(net_rows["PC"])))

    l0_ok, info = evaluate_netgate(net_rows, run_dir, expected_rom_md5)

    for side in ("APP", "PC"):
        q = info["qualified"][side]
        ev.append("NETGATE %s 合格样本=%d seq=%s" %
                  (side, len(q), info["seq"][side]))
        for rr in info["reasons"][side]:
            ev.append("NETGATE %s 不合格 %s : %s" %
                      (side, rr["ref"], ",".join(rr["reasons"])))
    ev.append("NETGATE 跨端: digest_ok=%s rom_md5_ok=%s seq_overlap=%s net_gray=%s gray_brs=%s"
              % (info["digest_ok"], info["rom_md5_ok"], info["seq_overlap"],
                 info["net_gray"], info["gray_brs"]))

    # NETGATE 层自回显检测：rx_sp0 == 本端标记
    net_self = False
    for side in ("APP", "PC"):
        for row in net_rows[side]:
            if norm_sp(row["fields"].get("sp0")) == LOCAL[side]:
                net_self = True

    # HMAC 局限 + 重锚口径标注（不可省略）
    notes.append("NETGATE/HMAC 局限：HMAC 只证来源可追溯+完整性+闭合接收+抗重放，"
                 "不证字节来自真游戏而非脚本；密钥若被 hook/驱动持有即可自产 party。"
                 "必须靠真 gPlayerParty 序列化写径审计 + writer≠checker 隔离兜底。")
    notes.append("NETGATE(seq/nonce) 只做逻辑单调序号抗重放，非熵源，不宣称密码学随机。")
    notes.append("NETGATE 为 L0 等效重锚：判据可用≠对手真实已证；"
                 "差分标记 0006/00D5 为人工构造输入、可信度存疑、非纯零注入；"
                 "门 FAIL/0/9 不自动翻，须视觉门人工复核重新裁决。")
    notes.append("L0 裁决理由：%s" % info["verdict_reason"])

    l2_ok = (app_l2 is True and pc_l2 is True and slot_ok and ec_ok and not polluted)
    observed_any = bool(net_rows["APP"] or net_rows["PC"] or app_l2 or pc_l2
                        or app_self or pc_self)
    if l0_ok and l2_ok:
        verdict, verdict_cn, exit_code = ("CROSSED",
            "真交换（NETGATE L0 闭合双交叉 + 跨端 digest 对账 + L2 cross_marker 双交叉）", 0)
        ev.append("NETGATE 跨端 digest：APP.rx==PC.tx / PC.rx==APP.tx 均成立且两向不同")
    elif observed_any and (net_self or app_self is True or pc_self is True):
        verdict, verdict_cn, exit_code = ("SELF_ECHO",
            "自我回显（NETGATE.rx_sp0 或 L2 对手框显示本端自己的 party 标记）", 1)
    else:
        verdict, verdict_cn, exit_code = ("UNOBSERVED",
            "NETGATE L0 未闭合/未跨端对账 或 L2 未双交叉（含缺 digest/单端/伪造闭合）", 3)
        if not net_rows["APP"] or not net_rows["PC"]:
            notes.append("单端或缺 NETGATE 行：无真实对端时不可能全绿（Q1 守卫），不判 CROSSED")

    return _res(verdict, verdict_cn, exit_code,
                observed={
                    "netgate_l0_app": {"rows": len(net_rows["APP"]),
                                       "qualified": len(info["qualified"]["APP"]),
                                       "seq": info["seq"]["APP"],
                                       "digests": info["digests"].get("app_rx", [])},
                    "netgate_l0_pc": {"rows": len(net_rows["PC"]),
                                      "qualified": len(info["qualified"]["PC"]),
                                      "seq": info["seq"]["PC"],
                                      "digests": info["digests"].get("pc_rx", [])},
                    "l2_from_zero": z.get("observed", {}),
                },
                checks={
                    "netgate_l0_cross": l0_ok,
                    "netgate_digest_ok": info["digest_ok"],
                    "netgate_rom_md5_ok": info["rom_md5_ok"],
                    "netgate_seq_overlap": info["seq_overlap"],
                    "netgate_mono_app": info["mono"]["APP"],
                    "netgate_mono_pc": info["mono"]["PC"],
                    "netgate_qualified_app": bool(info["qualified"]["APP"]),
                    "netgate_qualified_pc": bool(info["qualified"]["PC"]),
                    "net_gray": info["net_gray"],
                    "app_l2_cross": app_l2, "pc_l2_cross": pc_l2,
                    "l2_all_ok": l2_ok,
                    "ec_ok": ec_ok, "slot_ok": slot_ok, "no_pollution": not polluted,
                    "netgate_self_echo": net_self,
                    "three_question_check": netgate_criterion()["three_question_check"],
                })


def _format_netgate_summary(result):
    """NETGATE 模式的独立文本摘要（不共用 sio 的观测字段，避免误读）。"""
    ck = result["checks"]
    tri = lambda b: "YES" if b is True else ("NO" if b is False else "?")
    lines = []
    lines.append("=== 差分 party 实验判据 · NETGATE（pathB-net 等效 L0 重锚）===")
    lines.append("别名：%s  # 判据可用≠对手真实已证；门 FAIL/0/9 不自动翻" % NETGATE_ALIAS)
    lines.append("模式来源：%s（下游须以此为准，禁止只看 exit 0）"
                 % result.get("mode_source", "-"))
    if result.get("mode_warning"):
        lines.append("模式告警：%s" % result["mode_warning"])
    lines.append("-- NETGATE L0 --")
    for k, label in (
        ("netgate_l0_cross", "L0 整体交叉（闭合+跨端对账）"),
        ("netgate_digest_ok", "跨端 digest 对账 A.rx==B.tx 且 B.rx==A.tx"),
        ("netgate_rom_md5_ok", "rom_md5 两端一致"),
        ("netgate_seq_overlap", "seq 链两端有交集"),
        ("netgate_mono_app", "APP seq 单调"),
        ("netgate_mono_pc", "PC seq 单调"),
        ("netgate_qualified_app", "APP 有合格 NETGATE 样本"),
        ("netgate_qualified_pc", "PC 有合格 NETGATE 样本"),
        ("net_gray", "NETGRAY 灰区强写标记在场(须否)"),
    ):
        lines.append("  %-44s = %s" % (label, tri(ck.get(k))))
    lines.append("-- 旧否定门（全保留）--")
    for k, label in (
        ("app_l2_cross", "L2 APP cross_marker"),
        ("pc_l2_cross", "L2 PC cross_marker"),
        ("l2_all_ok", "L2 全通过(slot0洁净/无污染/ec>0)"),
        ("ec_ok", "ec>0"),
        ("slot_ok", "slot0 洁净"),
        ("no_pollution", "无非法 species 污染"),
        ("netgate_self_echo", "NETGATE 自回显(须否)"),
    ):
        lines.append("  %-44s = %s" % (label, tri(ck.get(k))))
    lines.append("-- 证据 --")
    for e in result.get("evidence", []):
        lines.append("  " + e)
    if result.get("notes"):
        lines.append("-- 备注 --")
        for n in result["notes"]:
            lines.append("  * " + n)
    lines.append("VERDICT=%s (%s)  exit=%d" %
                 (result["verdict"], result["verdict_cn"], result["exit_code"]))
    return "\n".join(lines)


def format_summary(result):
    if result.get("mode") == "NETGATE":
        return _format_netgate_summary(result)
    obs = result["observed"]
    ck = result["checks"]
    tri = lambda b: "YES" if b is True else ("NO" if b is False else "?")
    lines = []
    lines.append("=== 差分 party 实验判据 ===")
    if result.get("mode") == "ZERO":
        lines.append("模式：ZERO（零注入正道，主证据 [OPPSPECIES]=gBattleMons L2）")
        lines.append("别名：%s（不要求注入标签；纯数据层自洽链，门槛未降；判据可用≠对手真实已证）"
                     % result.get("mode_alias", MODE_ALIAS_ZERO))
    if result.get("mode_source"):
        lines.append("模式来源：%s（下游须以此为准，禁止只看 exit 0）"
                     % result["mode_source"])
    if result.get("mode_warning"):
        lines.append("模式告警：%s" % result["mode_warning"])
    lines.append("实验设定：PC 首位=%s(%s) / APP 首位=%s(%s)" % (
        EXPECTED_PC_PARTY_FIRST, sp_name(EXPECTED_PC_PARTY_FIRST),
        EXPECTED_APP_PARTY_FIRST, sp_name(EXPECTED_APP_PARTY_FIRST)))
    lines.append("-- 观测到的物种 --")
    for k, label in (
        ("pc_party_first", "PC party 首位  [SPENC] species"),
        ("pc_rx_app_party", "PC 收到的 APP party [RHVIS] pcSp/sp0"),
        ("app_rx_pc_party", "APP 收到的 PC party [SPDEC] sp0"),
        ("app_opponent_box", "APP 对手框      [RHREND] bm / [OPPSPECIES]"),
        ("pc_opponent_box", "PC 对手框       [RHVIS] epSp"),
    ):
        d = obs.get(k, {})
        sp = d.get("species")
        lines.append("  %-42s = %s (%s)" %
                     (label, sp or "???", sp_name(sp) if sp else "缺失"))
    lines.append("-- 判定检查 --")
    lines.append("  APP 对手框 == 喷火龙(PC party)? %s" %
                 tri(ck["app_opponent_eq_pc_party_expected"]))
    lines.append("  PC  对手框 == 壶壶(APP party)?  %s" %
                 tri(ck["pc_opponent_eq_app_party_expected"]))
    lines.append("  APP 对手框 == 壶壶(自己/回显)?  %s" %
                 tri(ck["app_opponent_is_self_echo"]))
    lines.append("  PC  对手框 == 喷火龙(自己/回显)? %s" %
                 tri(ck["pc_opponent_is_self_echo"]))
    if result["notes"]:
        lines.append("-- 备注 --")
        for n in result["notes"]:
            lines.append("  * " + n)
    lines.append("VERDICT=%s (%s)  exit=%d" %
                 (result["verdict"], result["verdict_cn"], result["exit_code"]))
    return "\n".join(lines)


def _write(path, text):
    with open(path, "w", encoding="utf-8") as fh:
        fh.write(text)


def self_test():
    """合成日志自测：INJECT 正/回显 + ZERO 正向 + 7 项负向/透明性 + 空目录。

    负向覆盖 Y12 终审：brs=0 但标记对、标记落 slot0、仅末条对、ec=0、cnt=0；
    Z74 P3/A 案：blkHdr=BBBB/8888 命令块不判 CROSSED（N6）；
    Z74 P1 暴露：mons 含 2222 时 JSON invalid_seen/mons_pollution 显式列出（N7）。"""
    app_cross = "\n".join([
        "11-18 23:01:11.282 5248 5282 I mGBA : [RHPLYR] cb2=080B4845 +0 lp1 ver=4003 tid=8A420D82 name=00FFCD08",
        "11-18 23:01:11.282 5248 5282 I mGBA : [OPPSPECIES] cb2=080B4845 btlType=0000002E n=4 mons=0006,0000,0000,0000 enemyPartyCnt=1 recvBuf0=2B8C",
        "11-18 23:01:11.283 5248 5282 I mGBA : [RHREND] cb2=080B4845 gEnemyParty sp=0006,0412,038F,0188,02BC,0000 bIdx=0,0,0,0 spr=0,0,0,0 gfx=02006CBC bm=0006,0000,0000,0000",
        "11-18 23:01:11.284 5248 5282 I mGBA : [SPDEC] remote=80000600 idx=0 byte=06 sp0=0006",
    ])
    pc_cross = "\n".join([
        "11-18 23:01:11.100 1 1 I mGBA : [SPENC] party0 raw=0202A5EC species=0006 encodedHi=8006 syncidx=0",
        "11-18 23:01:11.101 1 1 I mGBA : [RHVIS] cb2=080B4845 bIdx=0,0 srcSp=0006,0000,0000 pcSp=00D5,0412,038F hits=3 sp0=00D5 epSp=00D5,0000 epLv=50,50 cnt=6",
        "11-18 23:01:11.101 1 1 I mGBA : [OPPSPECIES] cb2=080B4845 btlType=0000002E mons=00D5,0000,0000,0000 enemyPartyCnt=6 recvBuf0=2B8C",
    ])
    # 回显例：APP 对手框改成壶壶(自己 00D5)，其余保持 PC 确实收到了 APP 的壶壶
    app_echo = app_cross.replace("mons=0006", "mons=00D5").replace(
        "sp=0006,0412", "sp=00D5,0412").replace("bm=0006,0000", "bm=00D5,0000")

    all_ok = True

    def run_case(name, app, pc, want_verdict, want_exit):
        nonlocal all_ok
        d = tempfile.mkdtemp(prefix="diff_party_")
        _write(os.path.join(d, "app_logcat.log"), app)
        _write(os.path.join(d, "mgba_sio.log"), pc)
        r = check(d)
        ok = r["verdict"] == want_verdict and r["exit_code"] == want_exit
        all_ok = all_ok and ok
        print("[%s] %s -> verdict=%s exit=%d (want %s/%d)" %
              ("OK" if ok else "BAD", name, r["verdict"], r["exit_code"],
               want_verdict, want_exit))
        print(format_summary(r))
        print("")
        return r

    r_xcross = run_case("交叉(APP对手=喷火龙, PC对手=壶壶)", app_cross, pc_cross, "CROSSED", 0)
    assert r_xcross.get("mode_alias") is None, "INJECT 模式不应带 pathB-zero 别名"
    r_echo = run_case("回显(APP对手=壶壶)", app_echo, pc_cross, "SELF_ECHO", 1)
    assert r_echo["checks"]["app_opponent_is_self_echo"] is True, \
        "回显例应判定 app_opponent_is_self_echo=True"

    # 058B 哨兵（gNumSpeciesNames 表长=1419 > 合法上限 0x58A=1418）必须判非法、不纳入物种判据
    ok_058b = (valid_sp("058B") is False and
               pick([("058B", {"file": "synthetic", "line": 1,
                               "raw": "058B"})])["valid"] is False)
    all_ok = all_ok and ok_058b
    print("[%s] 058B sentinel -> valid_sp=False / pick invalid (want excluded)" %
          ("OK" if ok_058b else "BAD"))

    # ---------------- ZERO（零注入）模式自测 ----------------
    # 合成日志只含 [OPPSPECIES]/[RHPLYR]（可选 [OPPGATE]），不含注入标签。
    # 故意用中性文件名验证"内容签名为主"；文件名为辅的用例随后单列。
    def opp_app(mons, ec):
        return ("11-19 06:36:38.438 5159 5185 I mGBA    : [OPPSPECIES] "
                "cb2=080B4845 btlType=0000002E n=4 mons=%s enemyPartyCnt=%s recvBuf0=2B8C"
                % (mons, ec))

    def opp_pc(mons, ec):
        return ("[OPPSPECIES] cb2=080B4845 btlType=0000002E mons=%s enemyPartyCnt=%s recvBuf0=2B8C"
                % (mons, ec))

    def opp_gate(sp, brs="0101", cnt=6, hdr="0001,0002,0003", size=None):
        # ROOTHUNT2/B7 实际格式：blkSp0 = gBlockRecvBuffer enemy 槽首只 species(L0)
        # W52：brs 是 C 侧 %04X 原始读，闭合态=两字节各=1=0101（非拼装位域 0003）；
        # 正向例默认 0101；负向例显式传 0000/0001/0100/0003/畸形，验证不误收。
        # hdr 默认合法(非命令字)以保既有用例不变；N6 用 BBBB/8888 验证命令块被拒。
        line = ("[OPPGATE] cb2=080B4845 blkHdr=%s blkSp0=%s cnt=%s brs=%s"
                % (hdr, sp, cnt, brs))
        if size is not None:
            line += " blkSize=%s" % size
        return line

    rhplyr_app = ("11-19 06:36:38.437 5159 5185 I mGBA    : [RHPLYR] cb2=080B4845 "
                  "+2 lp0 ver=8000 tid=8A420D82 name=00FFCD08 lp1 ver=0000 tid=00000000 name=00000000/00000000")
    rhplyr_pc = ("[RHPLYR] +2 lp0 ver=0000 tid=00000000 name=00000000 lp1 ver=0000 "
                 "tid=00000000 name=00000000/00000000 blk0=0/0 blk1=0/0")

    def run_zero_case(name, files, want_verdict, want_exit):
        nonlocal all_ok
        d = tempfile.mkdtemp(prefix="diff_party_zero_")
        for fn, content in files.items():
            _write(os.path.join(d, fn), content)
        r = check(d)
        ok = (r["verdict"] == want_verdict and r["exit_code"] == want_exit
              and r.get("mode") == "ZERO")
        all_ok = all_ok and ok
        print("[%s] ZERO %s -> verdict=%s exit=%d mode=%s (want %s/%d/ZERO)" %
              ("OK" if ok else "BAD", name, r["verdict"], r["exit_code"],
               r.get("mode"), want_verdict, want_exit))
        if not ok:
            print(format_summary(r))
        print("")
        return r

    # 交叉形态但无 OPPGATE -> L2-only：必须降级 UNOBSERVED，不输出裁决级 CROSSED
    # （checks 仍可显示两端 cross_marker 成立，但 verdict 不得为 CROSSED）
    r_zcross = run_zero_case(
        "交叉(内容签名定侧, 无OPPGATE->L2-only降级)",
        {"trace_A.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6),
         "trace_B.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)},
        "UNOBSERVED", 3)
    assert r_zcross["checks"]["app_opponent_eq_pc_party_expected"] is True, \
        "ZERO 交叉例应判定 APP 侧出现对端标记 0006"
    assert r_zcross["checks"]["pc_opponent_eq_app_party_expected"] is True, \
        "ZERO 交叉例应判定 PC 侧出现对端标记 00D5"
    assert r_zcross["observed"]["app_opponent_box"]["source"] == "cross_marker", \
        "ZERO 交叉例 APP 取值来源应为 cross_marker"

    # 文件名兜底 + OPPGATE L0 双交叉（blkSp0 两端都显示对端标记）
    r_zgate = run_zero_case(
        "交叉(文件名定侧+OPPGATE L0双交叉)",
        {"app_logcat.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6)
                           + "\n" + opp_gate("0006"),
         "mgba_sio.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)
                         + "\n" + opp_gate("00D5")},
        "CROSSED", 0)
    assert r_zgate["checks"]["oppgate_l0_cross"] is True, \
        "OPPGATE L0 双交叉例应判定 oppgate_l0_cross=True"

    # ---------------- W52：brs 口径修正 + 灰区强写拒认（红线）自测 ----------------
    # 正向：C 侧真实格式 brs=0101（低/高字节各=1），必须认 L0 闭合、可出 CROSSED。
    r_brs_real = run_zero_case(
        "brs=0101原始读(真实闭合)正向",
        {"app_logcat.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6)
                           + "\n" + opp_gate("0006", brs="0101"),
         "mgba_sio.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)
                         + "\n" + opp_gate("00D5", brs="0101")},
        "CROSSED", 0)
    assert r_brs_real["checks"]["oppgate_l0_cross"] is True, \
        "brs=0101 必须计入合格 L0 样本并判双交叉"

    # 负向 A：旧拼装位域口径 0003（C 侧从不打印）——不得当闭合，防放宽误收。
    r_brs_bitfield = run_zero_case(
        "brs=0003旧位域口径拒收",
        {"app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n"
                           + opp_gate("0006", brs="0003"),
         "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n"
                         + opp_gate("00D5", brs="0003")},
        "UNOBSERVED", 3)
    assert r_brs_bitfield["checks"]["oppgate_l0_qualified_app"] is False, \
        "brs=0003(位域口径)不得计入合格样本"

    # 负向 B：部分态 0001/0100、畸形 0102/0201、未闭合 0000 —— 拒收。
    for bad_brs in ("0000", "0001", "0100", "0102", "0201"):
        r_bad = run_zero_case(
            "brs=%s部分态/畸形拒收" % bad_brs,
            {"app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n"
                               + opp_gate("0006", brs=bad_brs),
             "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n"
                             + opp_gate("00D5", brs=bad_brs)},
            "UNOBSERVED", 3)
        assert r_bad["checks"]["oppgate_l0_qualified_app"] is False, \
            "brs=%s 不得计入合格样本" % bad_brs

    # 负向 C（红线）：日志有 RHBRS-GRAY 灰区强写标记时，brs=0101 可能是伪 ACK，
    # 不可与原生闭合区分 —— 必须拒认闭合、不判 CROSSED（即使 blkSp0 双交叉）。
    gray_line = ("11-18 23:01:11.500 5248 5282 I mGBA : [RHBRS-GRAY] force brs=03 mu=2 "
                 "b0=0->1 b1=0->1 cb2=080B4845 st=4 pc=0 (灰区强写,非原生闭合)")
    r_gray = run_zero_case(
        "红线-brs=0101但灰区RHBRS强写在场拒认闭合",
        {"app_logcat.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6)
                           + "\n" + opp_gate("0006", brs="0101") + "\n" + gray_line,
         "mgba_sio.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)
                         + "\n" + opp_gate("00D5", brs="0101")},
        "UNOBSERVED", 3)
    assert r_gray["checks"]["oppgate_l0_cross"] is not True, \
        "灰区强写在场时 0101 不得判 L0 交叉（红线：拒伪 ACK）"
    assert any("灰区" in n for n in r_gray.get("notes", [])), \
        "灰区强写在场应产出 note 显式标注"

    # 回显：APP L2=00D5(自己)、PC L2=0006(自己)，无对端标记 -> SELF_ECHO
    r_zecho = run_zero_case(
        "回显(APP=壶壶/PC=喷火龙, 均本端)",
        {"trace_A.log": rhplyr_app + "\n" + opp_app("00D5,0009,0412,038F", 0),
         "trace_B.log": rhplyr_pc + "\n" + opp_pc("0006,0009,0412,038F", 6)},
        "SELF_ECHO", 1)
    assert r_zecho["checks"]["app_opponent_is_self_echo"] is True, \
        "ZERO 回显例应判定 app_opponent_is_self_echo=True"

    # 单端 -> UNOBSERVED
    run_zero_case("单端观测", {"trace_A.log": opp_app("00D5,0006,0000,0000", 6)},
                  "UNOBSERVED", 3)
    # 空 mons / 058B 哨兵 -> UNOBSERVED（验证 valid_sp 上界收紧）
    run_zero_case("mons全零", {
        "trace_A.log": opp_app("0000,0000,0000,0000", 0),
        "trace_B.log": opp_pc("0000,0000,0000,0000", 0)}, "UNOBSERVED", 3)
    run_zero_case("058B哨兵", {
        "trace_A.log": opp_app("058B,0000,0000,0000", 6),
        "trace_B.log": opp_pc("058B,0000,0000,0000", 6)}, "UNOBSERVED", 3)
    # OPPGATE L0 与 L2 矛盾 -> 降级 UNOBSERVED
    run_zero_case("OPPGATE-L0与L2矛盾降级", {
        "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n" + opp_gate("00D5"),
        "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate("0006")},
        "UNOBSERVED", 3)

    # ---------------- 负向用例：堵 Y12 终审发现的 CROSSED 假阳性通道 ----------------
    # N1 brs=0000（brs 陷阱/块未闭合）但 blkSp0 两端标记都对 -> 必须不 CROSSED
    r_n1 = run_zero_case("负向-brs=0但blkSp0对(brs陷阱)", {
        "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n" + opp_gate("0006", brs="0000"),
        "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate("00D5", brs="0000")},
        "UNOBSERVED", 3)
    assert r_n1["checks"]["oppgate_l0_cross"] is not True, \
        "brs=0 时 oppgate_l0_cross 不得为 True"
    assert r_n1["checks"]["oppgate_l0_qualified_app"] is False, \
        "brs=0 不得计入合格 L0 样本"

    # N2 对端标记落在本端 slot0（事实不清）-> 必须不 CROSSED
    r_n2 = run_zero_case("负向-标记落本端slot0", {
        "trace_A.log": rhplyr_app + "\n" + opp_app("0006,0000,0000,0000", 6),
        "trace_B.log": rhplyr_pc + "\n" + opp_pc("00D5,0000,0000,0000", 6)},
        "UNOBSERVED", 3)
    assert r_n2["checks"]["app_opponent_eq_pc_party_expected"] is not True, \
        "标记落本端 slot0 不得判 APP 侧交叉"
    assert r_n2["checks"]["cross_marker_slot_ok"] is False, \
        "标记落本端 slot0 应记 cross_marker_wrongslot"

    # N3 OPPGATE 多帧、前帧错仅末条对 -> 必须不 CROSSED（不只末条）
    # W52：brs 用真实 C 侧格式 0101；前帧 sp 错（本端标记）故不全交叉 -> UNOBSERVED。
    run_zero_case("负向-OPPGATE仅末条对", {
        "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n"
                          + opp_gate("00D5", brs="0101") + "\n" + opp_gate("0006", brs="0101"),
        "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n"
                        + opp_gate("0006", brs="0101") + "\n" + opp_gate("00D5", brs="0101")},
        "UNOBSERVED", 3)

    # N4 四槽同时含本端+对端标记且 enemyPartyCnt=0 -> 必须不 CROSSED（ec=0 降级）
    r_n4 = run_zero_case("负向-四槽含双标记且ec=0", {
        "trace_A.log": opp_app("00D5,0006,0000,0000", 0),
        "trace_B.log": opp_pc("0006,00D5,0000,0000", 6)},
        "UNOBSERVED", 3)
    assert r_n4["checks"]["enemy_party_cnt_ok"] is False, \
        "ec=0 应记 enemy_party_cnt_ok=False"

    # N5 OPPGATE 有行但 cnt=0（无有效块）-> 必须不 CROSSED
    run_zero_case("负向-OPPGATE cnt=0", {
        "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n" + opp_gate("0006", cnt=0),
        "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate("00D5", cnt=0)},
        "UNOBSERVED", 3)

    # N6（Z74 P3 / A 案核心）：blkHdr 命中命令字(BBBB/8888/2222)，brs3/blkSp0/cnt 全对
    # 但块是命令块而非 0xA0 party 块 -> L0 无合格样本，必须非 CROSSED / UNOBSERVED。
    r_n6 = run_zero_case("负向-blkHdr=BBBB命令块(非party块)", {
        "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n"
                          + opp_gate("0006", hdr="BBBB,0064,0081"),
        "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n"
                        + opp_gate("00D5", hdr="8888,0032,0006")},
        "UNOBSERVED", 3)
    assert r_n6["checks"]["oppgate_l0_cross"] is not True, "命令块不得判 L0 交叉"
    assert r_n6["checks"]["oppgate_block_valid_app"] is False, "命令块不得算合格样本"
    assert r_n6["checks"]["oppgate_block_valid_pc"] is False, "命令块不得算合格样本"
    assert r_n6["observed"]["oppgate_l0_app"]["block_hdr"] == "BBBB,0064,0081", \
        "JSON 应显式回填 blkHdr 原貌（2222 污染不再静默）"

    # N7（Z74 P1 污染暴露 + W39-F3 收紧）：mons 含 2222（非法），slot0=2222 污染
    # -> 不得判 CROSSED（原版把假阳性锁进回归，此处纠正）。JSON 仍显式列出
    # invalid_seen=2222 与 mons_pollution_*=True（不再静默丢弃）。
    r_n7 = run_zero_case("mons含2222污染(slot0污染不判CROSSED)", {
        "app_logcat.log": opp_app("2222,0006,0000,0000", 6) + "\n" + opp_gate("0006"),
        "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate("00D5")},
        "UNOBSERVED", 3)
    assert r_n7["observed"]["app_opponent_box"]["source"] in (
        "cross_marker_slot0_polluted", "cross_marker_wrongslot"), \
        "slot0=2222 应记为 slot0 污染/wrongslot，不得记为干净 cross_marker"
    assert r_n7["checks"]["cross_marker_slot_ok"] is False, \
        "slot0 污染必须使 cross_marker_slot_ok=False"
    assert "2222" in r_n7["observed"]["app_opponent_box"]["invalid_seen"], \
        "mons 中的 2222 必须在 JSON invalid_seen 显式列出"
    assert r_n7["checks"]["mons_pollution_app"] is True, \
        "mons 含 2222 应记 mons_pollution_app=True"

    # ---------------- W39-F1/F2/F3 手改回归（隔离副本重基线） ----------------
    # F1-NEG-A：缺 blkHdr（brs 用 W52 口径 0101，确保隔离 hdr 维度）-> UNOBSERVED
    def opp_gate_nohdr(sp, brs="0101", cnt=6):
        return "[OPPGATE] cb2=080B4845 blkSp0=%s cnt=%s brs=%s" % (sp, cnt, brs)

    r_f1_nohdr = run_zero_case(
        "W39-F1-缺blkHdr应UNOBSERVED(brs=0101隔离hdr维度)", {
            "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n" + opp_gate_nohdr("0006"),
            "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate_nohdr("00D5")},
        "UNOBSERVED", 3)
    assert r_f1_nohdr["checks"]["oppgate_hdr_observable"] is False, \
        "缺 blkHdr 时块头维不可观测"
    assert r_f1_nohdr["checks"]["oppgate_l0_cross"] is not True, \
        "缺 blkHdr 时 L0 不得判交叉"
    # F1-NEG-B：畸形 blkHdr 同样 fail-closed
    r_f1_badhdr = run_zero_case(
        "W39-F1-畸形blkHdr应UNOBSERVED", {
            "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n" + opp_gate("0006", hdr="ZZZZ"),
            "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate("00D5", hdr="ZZZZ")},
        "UNOBSERVED", 3)
    assert block_valid(None) is False and block_valid("ZZZZ") is False, \
        "block_valid 对缺/畸形 hdr 必须 fail-closed"
    assert block_valid("0001,0002,0003") is True and block_valid("BBBB,0064,0081") is False, \
        "block_valid 对合法/命令字 hdr 行为不变"

    # F2：degenerate 标注为结构性、非观测，且不进 evidence；干净交叉仍 CROSSED
    r_f2 = run_zero_case(
        "W39-F2-degenerate结构性标注(干净交叉仍CROSSED)", {
            "app_logcat.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6)
                              + "\n" + opp_gate("0006"),
            "mgba_sio.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)
                            + "\n" + opp_gate("00D5")},
        "CROSSED", 0)
    dc = r_f2["degenerate_check"]
    assert dc["kind"] == "structural" and dc["observable"] is False and dc["value"] is False, \
        "degenerate 必须标为 structural/observable=false/value=false"
    assert r_f2["degenerate_is_observation"] is False, \
        "degenerate 不得当运行时观测"
    assert not any("已验证两端 party 不同" in x for x in r_f2["evidence"]), \
        "evidence 不得出现「已验证两端不同」"
    assert degenerate_precondition(LOCAL, REMOTE) is False, \
        "当前差分设定下 degenerate 恒 False"
    assert degenerate_precondition({"APP": "0006", "PC": "0006"},
                                   {"APP": "0006", "PC": "0006"}) is True, \
        "常量同物种时 degenerate 守卫应触发(fail-closed)"

    # F3-POS：干净 slot0(=LOCAL) 仍 CROSSED（不误拒真 CROSSED）
    r_f3_pos = run_zero_case(
        "W39-F3-干净slot0仍CROSSED", {
            "app_logcat.log": opp_app("00D5,0006,0000,0000", 6) + "\n" + opp_gate("0006"),
            "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate("00D5")},
        "CROSSED", 0)
    assert r_f3_pos["observed"]["app_opponent_box"]["source"] == "cross_marker", \
        "干净 slot0 应判 cross_marker"
    assert r_f3_pos["checks"]["cross_marker_slot0_clean"] is True, \
        "干净 slot0 应记 cross_marker_slot0_clean=True"
    # F3-BOUND：slot0 合法但非本端标记 -> UNOBSERVED（不硬断 SELF_ECHO）
    r_f3_bound = run_zero_case(
        "W39-F3-slot0合法但非本端标记", {
            "app_logcat.log": opp_app("0412,0006,0000,0000", 6) + "\n" + opp_gate("0006"),
            "mgba_sio.log": opp_pc("0006,00D5,0000,0000", 6) + "\n" + opp_gate("00D5")},
        "UNOBSERVED", 3)
    assert r_f3_bound["observed"]["app_opponent_box"]["source"] == "cross_marker_slot0_unexpected", \
        "slot0 合法但非本端标记应记 cross_marker_slot0_unexpected"

    # ---------------- 零注入 path B 别名 / 判据字段自测（FIXDIFF3） ----------------
    # B1：零注入、无任何注入标签，但纯数据层三件套全成立 -> 必须 CROSSED，
    #     且 JSON 显式声明 mode_alias=pathB-zero / injection_tags_required=False。
    r_pb = run_zero_case(
        "pathB-zero-零注入数据层全交叉应可裁决",
        {"app_logcat.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6)
                          + "\n" + opp_gate("0006"),
         "mgba_sio.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)
                         + "\n" + opp_gate("00D5")},
        "CROSSED", 0)
    assert r_pb.get("mode_alias") == MODE_ALIAS_ZERO, \
        "零注入 path B 结果应带 mode_alias=pathB-zero"
    assert r_pb.get("injection_tags_required") is False, \
        "pathB-zero 结果应显式声明 injection_tags_required=False"
    assert r_pb.get("criterion", {}).get("injection_tags_required") is False, \
        "pathB-zero criterion 应显式声明不要求注入标签"
    assert r_pb["checks"]["cross_marker_slot_ok"] is True, \
        "pathB-zero 交叉例 slot 语义应成立"
    assert r_pb["checks"]["oppgate_l0_cross"] is True, \
        "pathB-zero 交叉例 L0 应闭合双交叉"
    assert r_pb["checks"]["enemy_party_cnt_ok"] is True, \
        "pathB-zero 交叉例 ec 应合格"

    # B2：别名/criterion 是说明，不是降门槛——L2 交叉但缺 OPPGATE(L0) -> 仍 UNOBSERVED。
    r_pb_l2only = run_zero_case(
        "pathB-zero-L2-only即使带别名也不降门槛",
        {"trace_A.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6),
         "trace_B.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)},
        "UNOBSERVED", 3)
    assert r_pb_l2only.get("mode_alias") == MODE_ALIAS_ZERO, \
        "L2-only 零注入结果也带 pathB-zero 别名，但 verdict 不得被放宽"

    # B3：标记落本端 slot0 -> 即便带 pathB-zero 别名且 L0 看似闭合，仍非 CROSSED（红线回归）。
    r_pb_wrongslot = run_zero_case(
        "pathB-zero-标记落本端slot0仍非CROSSED",
        {"app_logcat.log": rhplyr_app + "\n" + opp_app("0006,0000,0000,0000", 6)
                          + "\n" + opp_gate("0006"),
         "mgba_sio.log": rhplyr_pc + "\n" + opp_pc("00D5,0000,0000,0000", 6)
                         + "\n" + opp_gate("00D5")},
        "UNOBSERVED", 3)
    assert r_pb_wrongslot["checks"]["cross_marker_slot_ok"] is False, \
        "标记落本端 slot0 必须记 wrongslot，不得因别名放宽"

    # ---------------- CLI 级 --mode 自测（W66）----------------
    # 不传 --mode = auto（向后兼容）；显式 zero/inject 钉死模式；非法值由 argparse exit 2。
    zero_clean_files = {
        "app_logcat.log": rhplyr_app + "\n" + opp_app("00D5,0006,0000,0000", 6)
                          + "\n" + opp_gate("0006"),
        "mgba_sio.log": rhplyr_pc + "\n" + opp_pc("0006,00D5,0000,0000", 6)
                        + "\n" + opp_gate("00D5"),
    }
    inject_files = {"app_logcat.log": app_cross, "mgba_sio.log": pc_cross}

    def run_cli_case(name, files, argv_tail, want_verdict, want_exit,
                     want_mode=None, want_mode_source=None,
                     want_warn=False, want_contradiction=False,
                     want_system_exit=None):
        nonlocal all_ok
        d = tempfile.mkdtemp(prefix="diff_party_cli_")
        for fn, content in files.items():
            _write(os.path.join(d, fn), content)
        buf = io.StringIO()
        rc = None
        parsed = None
        try:
            with contextlib.redirect_stdout(buf):
                rc = main([d, "--json"] + argv_tail)
        except SystemExit as exc:
            rc = exc.code
        if want_system_exit is not None:
            ok = (rc == want_system_exit)
            all_ok = all_ok and ok
            print("[%s] CLI %s -> SystemExit=%s (want %s)" %
                  ("OK" if ok else "BAD", name, rc, want_system_exit))
            return
        try:
            parsed = json.loads(buf.getvalue())
        except Exception:
            parsed = None
        ok = (rc == want_exit and parsed is not None
              and parsed.get("verdict") == want_verdict)
        if want_mode is not None:
            ok = ok and parsed.get("mode") == want_mode
        if want_mode_source is not None:
            ok = ok and parsed.get("mode_source") == want_mode_source
        if want_warn:
            ok = ok and bool(parsed.get("mode_warning"))
        else:
            ok = ok and not parsed.get("mode_warning")
        if want_contradiction:
            ok = ok and parsed.get("injection_contradiction") is True
        else:
            ok = ok and parsed.get("injection_contradiction") is False
        all_ok = all_ok and ok
        print("[%s] CLI %s -> verdict=%s exit=%s mode=%s src=%s warn=%s contradiction=%s" %
              ("OK" if ok else "BAD", name,
               parsed.get("verdict") if parsed else "?", rc,
               parsed.get("mode") if parsed else "?",
               parsed.get("mode_source") if parsed else "?",
               bool(parsed.get("mode_warning")) if parsed else "?",
               parsed.get("injection_contradiction") if parsed else "?"))
        return parsed

    # C1 不传 --mode：干净零注入样本仍 CROSSED，mode_source=auto_detect（回归）。
    run_cli_case("默认auto-干净数据仍CROSSED", zero_clean_files, [],
                 "CROSSED", 0, want_mode="ZERO", want_mode_source=MODE_SOURCE_AUTO)
    # C2 --mode zero + 干净数据 -> ZERO / explicit_cli，无告警。
    run_cli_case("--mode zero-干净数据", zero_clean_files, ["--mode", MODE_ZERO],
                 "CROSSED", 0, want_mode="ZERO", want_mode_source=MODE_SOURCE_EXPLICIT)
    # C3 --mode zero + 注入标签（仅 1 行，写在独立 README，不改主日志侧别）-> 告警 + 降级。
    dirty = dict(zero_clean_files)
    dirty["README.txt"] = "[SPENC] species=0006\n"
    run_cli_case("--mode zero-注入标签降级", dirty, ["--mode", MODE_ZERO],
                 "UNOBSERVED", 3, want_mode="ZERO",
                 want_mode_source=MODE_SOURCE_EXPLICIT,
                 want_warn=True, want_contradiction=True)
    # C4 控制：同样 1 行标签在 auto 下仍按原 >=2 阈值走 ZERO（证明 auto 未改、zero 更严）。
    run_cli_case("auto-单行注入标签不切模式", dirty, [],
                 "CROSSED", 0, want_mode="ZERO", want_mode_source=MODE_SOURCE_AUTO)
    # C5 --mode inject 显式 INJECT -> 原 7 bucket 判据，CROSSED。
    run_cli_case("--mode inject-显式INJECT", inject_files, ["--mode", MODE_INJECT],
                 "CROSSED", 0, want_mode="INJECT", want_mode_source=MODE_SOURCE_EXPLICIT)
    # C6 非法值 -> argparse exit 2（不产生任何裁决）。
    run_cli_case("--mode 非法值exit2", zero_clean_files, ["--mode", "bogus"],
                 None, None, want_system_exit=2)

    # ---------------- NETGATE（pathB-net）模式自测 ----------------
    ROM_MD5 = "0123456789abcdef0123456789abcdef"
    D1, D2 = "1111222233334444", "5555666677778888"

    def ng(role, sp0, tx_sp0, rx_digest, tx_digest, state="CLOSED",
           tag_ok=1, msg_type="PARTY", seq=5, sender=None,
           src_tag="battle_controller_link_opponent.c:903",
           blob="deadbeefcafe", tag="aa11bb22cc33dd44",
           cnt=6, rom_md5=ROM_MD5, nonce="5"):
        if sender is None:
            sender = "PC" if role == "APP" else "APP"
        return ("[NETGATE] role=%s state=%s seq=%s sender=%s rom_md5=%s blob=%s nonce=%s "
                "tag=%s rx_digest=%s tx_digest=%s msg_type=%s src_tag=%s cnt=%s sp0=%s "
                "tx_sp0=%s tag_ok=%s"
                % (role, state, seq, sender, rom_md5, blob, nonce,
                   tag, rx_digest, tx_digest, msg_type, src_tag, cnt, sp0, tx_sp0, tag_ok))

    def run_netgate_case(name, files, want_verdict, want_exit,
                         extra_argv=None, want_check=None):
        nonlocal all_ok
        d = tempfile.mkdtemp(prefix="diff_party_netgate_")
        for fn, content in files.items():
            _write(os.path.join(d, fn), content)
        buf = io.StringIO()
        rc = None
        argv = [d, "--json", "--l0-mode", "netgate"] + (extra_argv or [])
        try:
            with contextlib.redirect_stdout(buf):
                rc = main(argv)
        except SystemExit as exc:
            rc = exc.code
        try:
            parsed = json.loads(buf.getvalue())
        except Exception:
            parsed = None
        ok = (rc == want_exit and parsed is not None
              and parsed.get("verdict") == want_verdict
              and parsed.get("mode") == "NETGATE"
              and parsed.get("l0_mode") == "netgate"
              and parsed.get("mode_alias") == "pathB-net")
        if want_check:
            ok = ok and parsed.get("checks", {}).get(want_check[0]) == want_check[1]
        all_ok = all_ok and ok
        print("[%s] NETGATE %s -> verdict=%s exit=%d (want %s/%d)%s" %
              ("OK" if ok else "BAD", name,
               parsed.get("verdict") if parsed else "?", rc,
               want_verdict, want_exit,
               ("  %s=%s" % (want_check[0], parsed.get("checks", {}).get(want_check[0]))
                if want_check else "")))
        if not ok:
            print(format_summary(parsed) if parsed else buf.getvalue())
        print("")
        return parsed

    ng_app_ok = ng("APP", "0006", "00D5", D1, D2)
    ng_pc_ok = ng("PC", "00D5", "0006", D2, D1)
    ng_cross_files = {
        "app_logcat.log": ng_app_ok + "\n" + opp_app("00D5,0006,0000,0000", 6),
        "mgba_sio.log": ng_pc_ok + "\n" + opp_pc("0006,00D5,0000,0000", 6),
    }
    # 真 CROSSED：NETGATE L0 闭合双交叉 + 跨端 digest 对账 + L2 cross_marker 双交叉
    r_ng_cross = run_netgate_case(
        "真CROSSED(NETGATE闭合+digest对账+L2双交叉)", ng_cross_files,
        "CROSSED", 0, want_check=("netgate_l0_cross", True))
    assert r_ng_cross["checks"]["netgate_digest_ok"] is True
    assert r_ng_cross["checks"]["l2_all_ok"] is True
    assert r_ng_cross["criterion"]["three_question_check"]["Q1_no_peer_cannot_all_green"] is True
    assert r_ng_cross["criterion"]["three_question_check"]["Q2_writer_checker_separated"] is True
    assert r_ng_cross["criterion"]["three_question_check"]["Q3_all_old_negative_gates_kept"] is True
    assert any("HMAC" in n and "不证" in n for n in r_ng_cross["notes"]), \
        "NETGATE 结果必须如实标注 HMAC 局限"

    # SELF_ECHO：NETGATE.rx_sp0 与 L2 对手框都显示本端标记
    run_netgate_case("SELF_ECHO(本端标记)", {
        "app_logcat.log": ng("APP", "00D5", "0006", D1, D2) + "\n"
                          + opp_app("00D5,0009,0412,038F", 6),
        "mgba_sio.log": ng("PC", "0006", "00D5", D2, D1) + "\n"
                        + opp_pc("0006,0009,0412,038F", 6),
    }, "SELF_ECHO", 1)

    # 缺 digest：rx/tx_digest 字段缺失 -> fail-closed UNOBSERVED
    run_netgate_case("缺digest", {
        "app_logcat.log": ng("APP", "0006", "00D5", "", "") + "\n"
                          + opp_app("00D5,0006,0000,0000", 6),
        "mgba_sio.log": ng("PC", "00D5", "0006", "", "") + "\n"
                        + opp_pc("0006,00D5,0000,0000", 6),
    }, "UNOBSERVED", 3, want_check=("netgate_l0_cross", False))

    # 注入标签：命中即拒裁（fail-closed），保留旧否定门
    r_ng_inj = run_netgate_case("注入标签命中(fail-closed)", dict(ng_cross_files,
        **{"NOISE.txt": "[SPENC] species=0006\n"}), "UNOBSERVED", 3)
    assert r_ng_inj["injection_contradiction"] is True, \
        "NETGATE 命中注入标签必须标 injection_contradiction=True"

    # 伪造闭合态：state=RECEIVING 且 tag_ok=0 -> 不可计合格样本
    run_netgate_case("伪造闭合态(state=RECEIVING/tag_ok=0)", {
        "app_logcat.log": ng("APP", "0006", "00D5", D1, D2,
                             state="RECEIVING", tag_ok=0) + "\n"
                          + opp_app("00D5,0006,0000,0000", 6),
        "mgba_sio.log": ng("PC", "00D5", "0006", D2, D1,
                           state="RECEIVING", tag_ok=0) + "\n"
                        + opp_pc("0006,00D5,0000,0000", 6),
    }, "UNOBSERVED", 3)

    # 单端无对端（Q1 守卫）：不可能全绿
    run_netgate_case("单端无对端(Q1守卫)", {
        "app_logcat.log": ng_app_ok + "\n" + opp_app("00D5,0006,0000,0000", 6),
    }, "UNOBSERVED", 3)

    # rom_md5 磁盘钉死：正确值仍 CROSSED；不符则降级
    run_netgate_case("net-rom-md5钉死正确", ng_cross_files, "CROSSED", 0,
                     extra_argv=["--net-rom-md5", ROM_MD5])
    run_netgate_case("net-rom-md5不符降级", ng_cross_files, "UNOBSERVED", 3,
                     extra_argv=["--net-rom-md5", "ffffffffffffffffffffffffffffffff"])

    # 额外负向门（门槛不降佐证）：digest 错配/两向同值/控制消息/模板来源/NETGRAY/rom_md5 不一致/seq 非单调
    def ng_pair(app_line=None, pc_line=None, extra=None):
        files = {
            "app_logcat.log": (app_line or ng_app_ok) + "\n"
                              + opp_app("00D5,0006,0000,0000", 6),
            "mgba_sio.log": (pc_line or ng_pc_ok) + "\n"
                            + opp_pc("0006,00D5,0000,0000", 6),
        }
        if extra:
            files.update(extra)
        return files

    neg_cases = [
        ("digest跨端错配", ng_pair(app_line=ng_app_ok.replace(
            "rx_digest=" + D1, "rx_digest=9999aaaabbbbcccc"))),
        ("两向digest同值(自回显嫌疑)", ng_pair(
            app_line=ng_app_ok.replace("tx_digest=" + D2, "tx_digest=" + D1),
            pc_line=ng_pc_ok.replace("rx_digest=" + D2, "rx_digest=" + D1))),
        ("msg_type=CONTROL拒认", ng_pair(
            app_line=ng_app_ok.replace("msg_type=PARTY", "msg_type=CONTROL"),
            pc_line=ng_pc_ok.replace("msg_type=PARTY", "msg_type=CONTROL"))),
        ("src_tag=template拒认", ng_pair(
            app_line=ng_app_ok.replace("battle_controller_link_opponent.c:903", "template:party"),
            pc_line=ng_pc_ok.replace("battle_controller_link_opponent.c:903", "template:party"))),
        ("NETGRAY强写拒认闭合", ng_pair(
            extra={"GRAY.txt": "[NETGRAY] force gNetPartyRxState=CLOSED\n"})),
        ("rom_md5两端不一致", ng_pair(pc_line=ng_pc_ok.replace(
            ROM_MD5, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))),
        ("seq非单调", {
            "app_logcat.log": ng_app_ok + "\n" + ng("APP", "0006", "00D5", D1, D2, seq=3)
                              + "\n" + opp_app("00D5,0006,0000,0000", 6),
            "mgba_sio.log": ng_pc_ok + "\n" + opp_pc("0006,00D5,0000,0000", 6),
        }),
    ]
    for name, files in neg_cases:
        run_netgate_case(name, files, "UNOBSERVED", 3, want_check=("netgate_l0_cross", False))

    # 向后兼容：默认 sio 模式完全不读 NETGATE，同一 run 仍按 L2-only 降级 UNOBSERVED
    d = tempfile.mkdtemp(prefix="diff_party_netgate_compat_")
    for fn, content in ng_cross_files.items():
        _write(os.path.join(d, fn), content)
    r_compat = check(d)
    ok_compat = (r_compat["verdict"] == "UNOBSERVED" and r_compat["exit_code"] == 3
                 and r_compat["mode"] == "ZERO" and r_compat.get("mode_alias") == MODE_ALIAS_ZERO)
    all_ok = all_ok and ok_compat
    print("[%s] 向后兼容-默认sio不读NETGATE -> verdict=%s exit=%d mode=%s (want UNOBSERVED/3/ZERO)" %
          ("OK" if ok_compat else "BAD", r_compat["verdict"], r_compat["exit_code"], r_compat["mode"]))
    print("")

    # 空目录 -> UNOBSERVED
    d = tempfile.mkdtemp(prefix="diff_party_empty_")
    r_empty = check(d)
    ok = r_empty["verdict"] == "UNOBSERVED" and r_empty["exit_code"] == 3
    all_ok = all_ok and ok
    print("[%s] 空目录 -> verdict=%s exit=%d (want UNOBSERVED/3)" %
          ("OK" if ok else "BAD", r_empty["verdict"], r_empty["exit_code"]))

    print("\nSELF-TEST %s" % ("PASS" if all_ok else "FAIL"))
    return 0 if all_ok else 1


def main(argv=None):
    ap = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("run_dir", nargs="?", help="含两端日志的 run 目录")
    ap.add_argument("--json", action="store_true", help="仅输出机器可读 JSON")
    ap.add_argument("--mode", choices=CLI_MODES, default=MODE_AUTO,
                    help="模式：auto(默认,按注入标签行数自动判定) / "
                         "zero(显式零注入;仍扫注入标签,命中即降级 UNOBSERVED) / "
                         "inject(显式旧注入判据)")
    ap.add_argument("--l0-mode", choices=L0_MODES, default=L0_SIO,
                    help="L0 判据模式：sio(默认，现有 SIO 块闭合判据逐字不变) / "
                         "netgate(pathB-net 等效重锚，只读 ROM [NETGATE] 字段；"
                         "判据可用≠对手真实已证，HMAC 不证真游戏产生)")
    ap.add_argument("--net-rom-md5", default=None,
                    help="仅 netgate 模式：期望的 rom.gba 磁盘实测 md5；"
                         "给定后所有 [NETGATE] rom_md5 必须等于它（未给定时只要求两端一致）")
    ap.add_argument("--self-test", action="store_true",
                    help="用合成日志自测 CROSSED/SELF_ECHO/UNOBSERVED（含 netgate 模式）")
    args = ap.parse_args(argv)

    if args.self_test:
        return self_test()
    if not args.run_dir:
        ap.error("需要 run_dir（或用 --self-test）")

    r = check(args.run_dir, args.mode,
              l0_mode=args.l0_mode, expected_rom_md5=args.net_rom_md5)
    if args.json:
        print(json.dumps(r, ensure_ascii=False, indent=2))
    else:
        print(format_summary(r))
        print("\n--- JSON (机器可读) ---")
        print(json.dumps(r, ensure_ascii=False, indent=2))
    return r["exit_code"]


if __name__ == "__main__":
    sys.exit(main())
