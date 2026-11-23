#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
sio_cmd_sim.py -- STANDALONE deterministic oracle for the gen8 SIO cmd-frame
exchange (cross-device 2P netplay stall).

NO product dependencies. Pure Python 3 standard library.

WHAT THIS MODELS
================
1. gen8  src/link.c  (read from D:/gen8/include/link.h + D:/gen8/src/link.c):
     struct SendQueue  data[CMD_LENGTH=8][QUEUE_CAPACITY=50], pos, count
     struct RecvQueue  data[MAX_LINK_PLAYERS=4][8][50], pos, count
     gLink.sendCmdIndex (sc, +0x16), recvCmdIndex (rc, +0x17)
     DoRecv()          -- link.c:2305-2351
     DoSend()          -- link.c:2353-2388
     SendRecvDone()    -- link.c:2399-2410
     EnqueueSendCmd()  -- link.c:2082-2115
     DequeueRecvCmds() -- link.c:2118-2155
     ProcessRecvCmds() -- link.c:530-649  (only the 0x2222 branch matters)
     InitBlockSend()   -- link.c:951-977
     SerialCB()        -- link.c:2211-2243
     LinkMain1()       -- link.c:1955-2055
     LinkVSync()       -- link.c:2159-2203
     DoHandshake()     -- link.c:2250-2303

2. The emulator's word delivery (from this repo's src/platform/qt/sio_link.c
   + src/platform/mobile/mgba_mobile.c + src/gba/sio.c + link_net.c):
   - a 20-byte `struct Packet` (link_net.c:301-310) carries ONE u16 SIO word
     in its `value` field; one word is delivered per SIO round.
   - GBASIOMultiplayerFinishTransfer() (src/gba/sio.c:371-389) writes that
     word into SIOMLT_RECV[slot] then raises the SIO IRQ -> the ROM's SerialCB
     runs DoRecv/DoSend/SendRecvDone synchronously for that round.
   - the master occupies slot 0, the slave slot 1.  Each side's own word is
     looped back into its own slot; the peer word goes into the other slot.
   - CMDFRAMEALIGN (sio_link.c:2890-2925 / mgba_mobile.c:3406-3450) is a
     one-shot patch that, on seeing a 0x2222/0xBBBB header word, pins the
     receiver's (sc, rc) to (1, 0) in completeMultiTransfer() *before*
     finishMultiTransfer()/SerialCB runs.

KEY FACT PROVED BY THIS SIM (see the generated report SIO-CMD-SIM.md)
    The master writes 0x2222 into its frame's data[0].  For the slave's
    DoRecv() to file that word into recvQueue.data[0][0] -- the only slot
    DequeueRecvCmds() copies into gRecvCmds[0][0], the only slot
    ProcessRecvCmds() inspects -- the slave MUST enter that round with
        sendCmdIndex == 1  and  recvCmdIndex == 0.
    (natural invariant: sc = rc + 1, rc in 0..7;  sc==0 <-> rc==0 checksum round)
    If the slave instead enters with sc==2, rc==1 (one beat ahead), 0x2222 is
    filed into recvQueue.data[0][1] and gRecvCmds[0][0] stays stale forever.

USAGE
    python tools/sio_cmd_sim.py            # all scenarios + tables
    python tools/sio_cmd_sim.py --quiet     # just the PASS/FAIL verdicts
"""

from __future__ import annotations

import argparse
import copy
import hashlib
import json
import random
import sys

# ---------------------------------------------------------------------------
# gen8 constants (link.h)
# ---------------------------------------------------------------------------
CMD_LENGTH = 8
QUEUE_CAPACITY = 50
MAX_LINK_PLAYERS = 4

LINKCMD_SEND_LINK_TYPE = 0x2222
LINKTYPE_SINGLE_BATTLE = 0x2233
LINKCMD_INIT_BLOCK = 0xBBBB
MASTER_HANDSHAKE = 0x8FFF
SLAVE_HANDSHAKE = 0xB9A0

LINK_STATE_START0 = 0
LINK_STATE_START1 = 1
LINK_STATE_HANDSHAKE = 2
LINK_STATE_INIT_TIMER = 3
LINK_STATE_CONN_ESTABLISHED = 4

LINK_MASTER = 8
LINK_SLAVE = 0

LAG_NONE, LAG_MASTER, LAG_SLAVE = 0, 1, 2

# gLink / queue byte offsets, for documentation parity with the C source
from gba_addrs import SIO_GLINK_BASE as GLINK_BASE  # 统一 SIO gLink 基准宏（原值 0x03002AF4）
OFF_STATE = 0x01
OFF_LOCALID = 0x02
OFF_PLAYERCOUNT = 0x03
OFF_SERIALINTR = 0x0D
OFF_SC = 0x16
OFF_RC = 0x17
OFF_SENDQUEUE = 0x18   # -> 0x03002B0C
OFF_RECVQUEUE = 0x33C  # -> 0x03002E30


def hx(v) -> str:
    if v is None:
        return "n/a"
    return "0x%04X" % (v & 0xFFFF)


# ---------------------------------------------------------------------------
# PREDROLLBACK (档1 A方向·预测回滚机制自验证桩)
#   仅仿真 SIO 控制字流 + 预测/回滚/重放机制；mock 只出控制字白名单，
#   绝不产 party 数据字节 / 不写 gEnemyParty / 信任位 / 不产 [NETGATE]/CROSSED。
#   产物标注：非 CROSSED / mock 控制字人工注入 / 门 FAIL/0/9 不变 / diag 未接入。
# ---------------------------------------------------------------------------
# 权威态字段白名单（Gen8Link 全为原生类型；排除 trace 与 provenance）
_STATE_FIELDS = (
    "is_master", "state", "local_id", "player_count",
    "send_pos", "send_count", "recv_pos", "recv_count",
    "sc", "rc", "checksum", "s_checksum_available",
    "s_send_nonzero", "s_recv_nonzero", "s_send_buffer_empty",
    "serial_intr_counter", "received_nothing", "bad_checksum",
    "init_block_send_calls",
)
# 控制字白名单：握手字 + 命令字 + 序号/相位字 + 合法 checksum 类别
_CTRL_WHITELIST = frozenset({
    MASTER_HANDSHAKE, SLAVE_HANDSHAKE,
    LINKCMD_SEND_LINK_TYPE, LINKTYPE_SINGLE_BATTLE, LINKCMD_INIT_BLOCK,
})
# 强制分歧：把真字替换为另一个【合法控制字】，而非异或任意位——
# 保证分歧字本身也通过白名单自检（mock 绝不产出 party 数据负载字）
_PRED_DIVERGE_SUB = {LINKCMD_SEND_LINK_TYPE: LINKCMD_INIT_BLOCK,
                     LINKTYPE_SINGLE_BATTLE: LINKCMD_SEND_LINK_TYPE,
                     LINKCMD_INIT_BLOCK: LINKTYPE_SINGLE_BATTLE}


def state_digest(link) -> str:
    """规范化序列化权威态字段 -> md5；排除 trace/provenance。"""
    obj = {}
    for f in _STATE_FIELDS:
        v = getattr(link, f, None)
        if isinstance(v, bool):
            v = int(v)
        obj[f] = v
    # 队列内容也进摘要（send_data/recv_data/recv_cmds/send_cmd），逐字节可序列化
    obj["send_data"] = link.send_data
    obj["recv_data"] = link.recv_data
    obj["recv_cmds"] = link.recv_cmds
    obj["send_cmd"] = link.send_cmd
    raw = json.dumps(obj, sort_keys=True, separators=(",", ":"))
    return hashlib.md5(raw.encode("ascii")).hexdigest()


def pred_true_word(t: int, seed: int, diverge_at: int | None) -> int:
    """真字流 = master_word（干净、不变异）。diverge_at 只影响【预测字】，
    真字恒为 ROM/对端实际发出的字——保证白名单自检与真实性语义。"""
    return master_word(t) & 0xFFFF


def pred_word(t: int, diverge_at: int | None = None) -> int:
    """预测字：正常轮==master_word；diverge_at 轮故意预测成另一个合法控制字，
    制造字级分歧（预测错误 → 回滚重放），且分歧字仍是合法控制字（红线自检通过）。"""
    w = master_word(t)
    if diverge_at is not None and t == diverge_at:
        w = _PRED_DIVERGE_SUB.get(w, LINKCMD_INIT_BLOCK)
    return w & 0xFFFF


def pred_word_is_control(w: int) -> bool:
    """控制字白名单自检：出现任何 party 数据负载字即桩 FAIL（红线）。"""
    w &= 0xFFFF
    if w in _CTRL_WHITELIST or w == 0:
        return True
    # 合法 checksum 类别：计算式 (0x2222+0x2233)&0xFFFF == 0x4455，
    # 以及任意两个白名单字之和（&0xFFFF）——容纳 checksum 而不误判为数据字
    for a in _CTRL_WHITELIST:
        for b in _CTRL_WHITELIST:
            if w == ((a + b) & 0xFFFF):
                return True
    return False


# ---------------------------------------------------------------------------
# Faithful model of gen8's queues + per-beat state machine
# ---------------------------------------------------------------------------
class Gen8Link:
    """Reproduces, line-for-line, the parts of `struct Link` that matter."""

    def __init__(self, is_master: bool, player_count: int = 2, local_id: int = 0):
        self.is_master = is_master
        self.state = LINK_STATE_CONN_ESTABLISHED
        self.local_id = local_id
        self.player_count = player_count

        # sendQueue.data[word][slot]  (link.h:183)
        self.send_data = [[0] * QUEUE_CAPACITY for _ in range(CMD_LENGTH)]
        self.send_pos = 0
        self.send_count = 0

        # recvQueue.data[player][word][slot]  (link.h:190)
        self.recv_data = [
            [[0] * QUEUE_CAPACITY for _ in range(CMD_LENGTH)]
            for _ in range(MAX_LINK_PLAYERS)
        ]
        self.recv_pos = 0
        self.recv_count = 0

        self.sc = 0                 # sendCmdIndex
        self.rc = 0                 # recvCmdIndex
        self.checksum = 0
        self.s_checksum_available = False
        self.s_send_nonzero = 0
        self.s_recv_nonzero = 0
        self.s_send_buffer_empty = False
        self.serial_intr_counter = 0
        self.received_nothing = False
        self.bad_checksum = False

        # gRecvCmds[5][8] (only players 0..player_count are used)
        self.recv_cmds = [[0] * CMD_LENGTH for _ in range(MAX_LINK_PLAYERS)]
        # gSendCmd[8] / callback state
        self.send_cmd = [0] * CMD_LENGTH
        self.init_block_send_calls = 0
        self.callback = None

        # trace
        self.trace = []

    # ---- DoRecv (link.c:2305) -------------------------------------------
    def do_recv(self, recv_words):
        """recv_words = [w0,w1,w2,w3] as latched from SIOMLT_RECV0..3."""
        if self.sc == 0:
            # checksum beat: the word is compared, never filed into the queue
            if self.s_checksum_available:
                for i in range(self.player_count):
                    if self.checksum != (recv_words[i] & 0xFFFF):
                        self.bad_checksum = True
            self.checksum = 0
            self.s_checksum_available = True
            filed_at = None
        else:
            index = self.recv_pos + self.recv_count
            if index >= QUEUE_CAPACITY:
                index -= QUEUE_CAPACITY
            if self.recv_count < QUEUE_CAPACITY:
                for i in range(self.player_count):
                    w = recv_words[i] & 0xFFFF
                    self.checksum = (self.checksum + w) & 0xFFFF
                    self.s_recv_nonzero |= w
                    # THE critical store: data[player][recvCmdIndex][index]
                    self.recv_data[i][self.rc][index] = w
                filed_at = self.rc
            else:
                filed_at = None  # queueFull (not relevant here)
            self.rc += 1
            if self.rc == CMD_LENGTH and self.s_recv_nonzero:
                self.recv_count += 1
                self.s_recv_nonzero = 0
        return filed_at

    # ---- DoSend (link.c:2353) -------------------------------------------
    def do_send(self):
        if self.sc == CMD_LENGTH:
            word = self.checksum
            if not self.s_send_buffer_empty:
                if self.send_count > 0:
                    self.send_count -= 1
                self.send_pos = (self.send_pos + 1) % QUEUE_CAPACITY
            else:
                self.s_send_buffer_empty = False
        else:
            if not self.s_send_buffer_empty and self.send_count == 0:
                self.s_send_buffer_empty = True
            if self.s_send_buffer_empty:
                word = 0
            else:
                word = self.send_data[self.sc][self.send_pos]
            self.sc += 1
        return word & 0xFFFF

    # ---- SendRecvDone (link.c:2399) -------------------------------------
    def send_recv_done(self):
        if self.rc == CMD_LENGTH:
            self.sc = 0
            self.rc = 0
            return True   # frame closed
        return False

    # ---- SerialCB (link.c:2211) -----------------------------------------
    def serial_cb(self, recv_words):
        before = (self.sc, self.rc)
        filed_at = self.do_recv(recv_words)
        out_word = self.do_send()
        closed = self.send_recv_done()
        self.serial_intr_counter = (self.serial_intr_counter + 1) & 0xFF
        self.trace.append({
            "sc_in": before[0], "rc_in": before[1],
            "recv0": recv_words[0] & 0xFFFF,
            "filed_at": filed_at,
            "sc_out": self.sc, "rc_out": self.rc,
            "closed": closed, "count": self.recv_count,
        })
        return out_word

    # ---- EnqueueSendCmd (link.c:2082) -----------------------------------
    def enqueue_send_cmd(self, cmd):
        """cmd = list of 8 u16; mirrors the `sendCmd` parameter copied in
        by LinkMain1() each game frame."""
        if self.send_count < QUEUE_CAPACITY:
            offset = self.send_pos + self.send_count
            if offset >= QUEUE_CAPACITY:
                offset -= QUEUE_CAPACITY
            for i in range(CMD_LENGTH):
                self.s_send_nonzero |= cmd[i]
                self.send_data[i][offset] = cmd[i] & 0xFFFF
                cmd[i] = 0
        else:
            pass  # gLink.queueFull = QUEUE_FULL_SEND
        if self.s_send_nonzero:
            self.send_count += 1
            self.s_send_nonzero = 0

    # ---- DequeueRecvCmds (link.c:2118) ----------------------------------
    def dequeue_recv_cmds(self):
        if self.recv_count == 0:
            for i in range(self.player_count):
                for j in range(CMD_LENGTH):
                    self.recv_cmds[i][j] = 0
            self.received_nothing = True
            return False
        for i in range(self.player_count):
            for j in range(CMD_LENGTH):
                self.recv_cmds[i][j] = self.recv_data[i][j][self.recv_pos]
        self.recv_count -= 1
        self.recv_pos = (self.recv_pos + 1) % QUEUE_CAPACITY
        self.received_nothing = False
        return True

    # ---- InitBlockSend / ProcessRecvCmds (link.c:951 / 530) -------------
    def init_block_send(self, who):
        self.init_block_send_calls += 1
        self.send_cmd[0] = LINKCMD_INIT_BLOCK
        self.send_cmd[1] = 0x0064   # example block size (0x64 bytes)
        self.send_cmd[2] = who + 0x80
        self.callback = "LinkCB_BlockSendBegin"

    def process_recv_cmds(self):
        for i in range(MAX_LINK_PLAYERS):
            if self.recv_cmds[i][0] == 0:
                continue
            if self.recv_cmds[i][0] == LINKCMD_SEND_LINK_TYPE:
                self.init_block_send(i)

    def link_main1_cycle(self):
        """The CONN_ESTABLISHED path of LinkMain1(): enqueue + dequeue."""
        self.enqueue_send_cmd(self.send_cmd)
        self.dequeue_recv_cmds()

    # ---- helpers for tests ----------------------------------------------
    def slot0_of_frame(self):
        """The word in recvQueue.data[0][0] of the next-to-be-dequeued slot."""
        return self.recv_data[0][0][self.recv_pos]

    def slot1_of_frame(self):
        return self.recv_data[0][1][self.recv_pos]


# ---------------------------------------------------------------------------
# Emulator word delivery model
# ---------------------------------------------------------------------------
def master_word(t: int) -> int:
    """u16 the master puts on the wire at round t.

    Master enters CONN_ESTABLISHED at t=0 with gSendCmd[0]=0x2222,
    gSendCmd[1]=linkType; LinkMain1() enqueues it, then 9 DoSend beats put
    data[0..7] + checksum on the wire.  t<0 and t>=9 are idle (0).
    """
    if 0 <= t < 8:
        return [LINKCMD_SEND_LINK_TYPE, LINKTYPE_SINGLE_BATTLE,
                0, 0, 0, 0, 0, 0][t]
    if t == 8:
        return (LINKCMD_SEND_LINK_TYPE + LINKTYPE_SINGLE_BATTLE) & 0xFFFF
    return 0


def natural_sc_rc(slave_round_in_frame: int):
    """(sc, rc) at entry of a round, given how many rounds into its own frame
    the slave is (0 = first/checksum beat).  Derived from
    DoRecv->DoSend->SendRecvDone in link.c."""
    sc = slave_round_in_frame % CMD_LENGTH
    rc = 0 if sc == 0 else sc - 1
    return sc, rc


def run_slave_scenario(phase_offset: int,
                       align: bool,
                       align_timing: str = "before_recv",
                       align_target: tuple = (1, 0),
                       override_before_recv: tuple = None,
                       extra_rounds: int = 12,
                       verbose: bool = False):
    """Run one deterministic slave-side experiment.

    phase_offset: how many beats the slave's frame leads the master's at t=0.
                  At t=0 (master sends 0x2222) the slave enters with
                  (sc,rc) = natural_sc_rc(phase_offset):
                     offset 0 -> (0,0)   [checksum beat, 0x2222 DISCARDED]
                     offset 1 -> (1,0)   [CORRECT: 0x2222 -> slot 0]
                     offset 2 -> (2,1)   [OBSERVED FAILURE: 0x2222 -> slot 1]
    align:        whether CMDFRAMEALIGN one-shot patch is enabled
    align_timing: 'before_recv' (current code), 'after_recv', or 'none'
    align_target: (sc,rc) to pin the header round to (default (1,0))
    override_before_recv: optional (sc,rc) another emulator writer stomps in
                  AFTER align but BEFORE DoRecv (models a conflicting patch).
    """
    slave = Gen8Link(is_master=False, player_count=2, local_id=1)

    # Prime the slave's phase: it starts its frame `phase_offset` rounds
    # before t=0.  We replay those warmup rounds with master idle (word 0).
    trace_rows = []
    aligned_once = False
    override_done = False
    align_log = []

    header_index = None   # queue slot of the frame that carries the 0x2222
    g00_at_header = None  # gRecvCmds[0][0] right after that frame is dequeued
    frames = []           # (index, slot0, slot1) snapshots at each frame close
    start = -phase_offset
    end = phase_offset + extra_rounds
    for t in range(start, end + 1):
        own = 0  # slave is not sending commands in this experiment
        # SIOMLT_RECV0 = master word (slot 0), SIOMLT_RECV1 = own loopback
        recv_words = [master_word(t), own, 0xFFFF, 0xFFFF]

        # --- emulator index patches for THIS round, in source order ------
        raw_remote = recv_words[0]
        if raw_remote == LINKCMD_SEND_LINK_TYPE and header_index is None:
            # index this word WILL be filed into (if sc!=0 at DoRecv)
            header_index = (slave.recv_pos + slave.recv_count) % QUEUE_CAPACITY
        do_align = (align and raw_remote == LINKCMD_SEND_LINK_TYPE
                    and not aligned_once)
        if do_align and align_timing == "before_recv":
            aligned_once = True
            align_log.append((t, (slave.sc, slave.rc), align_target))
            slave.sc, slave.rc = align_target
        if (override_before_recv is not None
                and raw_remote == LINKCMD_SEND_LINK_TYPE
                and not override_done):
            # e.g. a second writer re-deriving (sc,rc) at the header round
            slave.sc, slave.rc = override_before_recv
            override_done = True
            align_log.append((t, "override", override_before_recv))

        # --- ROM SerialCB: DoRecv -> DoSend -> SendRecvDone ----------------
        row_before = (slave.sc, slave.rc)
        filed_at = slave.do_recv(recv_words)
        _ = slave.do_send()
        closed = slave.send_recv_done()
        slave.serial_intr_counter = (slave.serial_intr_counter + 1) & 0xFF

        if do_align and align_timing == "after_recv":
            aligned_once = True
            align_log.append((t, (row_before[0], row_before[1]), align_target))
            slave.sc, slave.rc = align_target

        trace_rows.append({
            "t": t, "remote": raw_remote & 0xFFFF,
            "sc_in": row_before[0], "rc_in": row_before[1],
            "filed_at": filed_at, "closed": closed,
            "sc_out": slave.sc, "rc_out": slave.rc,
            "count": slave.recv_count,
        })

        # The game's once-per-frame LinkMain1()/LinkMain2() would dequeue +
        # process a completed frame.  Do that as soon as the frame closes.
        if closed:
            committed = (slave.recv_pos + slave.recv_count - 1) % QUEUE_CAPACITY
            is_header = (committed == header_index)
            frames.append({
                "index": committed,
                "slot0": slave.recv_data[0][0][committed],
                "slot1": slave.recv_data[0][1][committed],
                "is_header_frame": is_header,
            })
            slave.dequeue_recv_cmds()
            slave.process_recv_cmds()
            if is_header and g00_at_header is None:
                g00_at_header = slave.recv_cmds[0][0]

    header_frame = next((f for f in frames if f["is_header_frame"]), None)
    header_slot0 = header_frame["slot0"] if header_frame else None
    header_slot1 = header_frame["slot1"] if header_frame else None

    result = {
        "phase_offset": phase_offset,
        "sc_at_header": natural_sc_rc(phase_offset)[0],
        "rc_at_header": natural_sc_rc(phase_offset)[1],
        "align": align,
        "align_timing": align_timing,
        "align_target": align_target,
        "override": override_before_recv,
        "gRecvCmds_0_0": (g00_at_header if g00_at_header is not None
                          else slave.recv_cmds[0][0]),
        "init_block_send": slave.init_block_send_calls,
        "slot0_last_frame": header_slot0,
        "slot1_last_frame": header_slot1,
        "success": ((g00_at_header if g00_at_header is not None
                     else slave.recv_cmds[0][0]) == LINKCMD_SEND_LINK_TYPE
                    and slave.init_block_send_calls > 0),
        "trace": trace_rows,
        "align_log": align_log,
    }
    if verbose:
        print("  t remote sc/rc_in -> filed@  closed  gRecvCmds[0][0]")
        for r in trace_rows:
            print("  %3d %s  %u/%-u  %-7s %-6s %s" % (
                r["t"], hx(r["remote"]), r["sc_in"], r["rc_in"],
                ("slot%d" % r["filed_at"]) if r["filed_at"] is not None else "-",
                str(r["closed"]), hx(result["gRecvCmds_0_0"])))
    return result


# ---------------------------------------------------------------------------
# PREDROLLBACK drivers: oracle / delayed / predictive-rollback
#   复用 Gen8Link.do_recv/do_send/send_recv_done/dequeue/process，严格复现
#   run_slave_scenario 的帧闭合 (:396-408) 与 index patch (:355-372) 时机。
#   所有真字来自 pred_true_word（确定字流 + 可选分歧），slave 不自身发包(own=0)。
# ---------------------------------------------------------------------------
def _pr_receive_beat(link, recv_words):
    """一拍 ROM SerialCB：DoRecv -> DoSend -> SendRecvDone，返回帧是否闭合。
    与 run_slave_scenario:374-379 同构。"""
    link.do_recv(recv_words)
    link.do_send()
    closed = link.send_recv_done()
    link.serial_intr_counter = (link.serial_intr_counter + 1) & 0xFF
    return closed


def run_oracle_baseline(frames_n: int, seed: int):
    """零延迟无预测基线：真字当拍到达。产出权威摘要 D0 / 帧数 F0 / 每帧字流。"""
    link = Gen8Link(is_master=False, player_count=2, local_id=1)
    rng = random.Random(seed)
    rounds = frames_n * (CMD_LENGTH + 1)  # 每帧 9 拍
    word_stream = []
    frame_closes = 0
    for t in range(rounds):
        w = pred_true_word(t, seed, None)
        # 白名单自检：任何非控制字出现即桩 FAIL（红线）
        if not pred_word_is_control(w):
            raise RuntimeError("ORACLE: non-control word %s at t=%d (redline)" % (hx(w), t))
        word_stream.append(w)
        if _pr_receive_beat(link, [w, 0, 0xFFFF, 0xFFFF]):
            frame_closes += 1
            link.dequeue_recv_cmds()
            link.process_recv_cmds()
    return {"digest": state_digest(link), "frames": frame_closes,
            "word_stream": word_stream, "rounds": rounds}


def run_delayed_baseline(frames_n: int, seed: int, delay: int):
    """有延迟无预测基线：第 t 轮真字排到 t+delay 才到达，等待期模拟时钟冻结（停滞轮 S>0）。"""
    link = Gen8Link(is_master=False, player_count=2, local_id=1)
    rng = random.Random(seed)
    rounds = frames_n * (CMD_LENGTH + 1)
    # delivery 映射：t 轮的真字在 t+delay 轮投递
    delayed = {}
    for t in range(rounds):
        delayed.setdefault(t + delay, []).append(pred_true_word(t, seed, None))
    stalled = 0
    frame_closes = 0
    for t in range(rounds):
        words = delayed.get(t)
        if not words:
            stalled += 1
            continue  # 模拟时钟冻结：本拍无字到达，不推进
        w = words[0]
        if not pred_word_is_control(w):
            raise RuntimeError("DELAY: non-control word %s at t=%d (redline)" % (hx(w), t))
        if _pr_receive_beat(link, [w, 0, 0xFFFF, 0xFFFF]):
            frame_closes += 1
            link.dequeue_recv_cmds()
            link.process_recv_cmds()
    # 独立帧闭合计数：link.recv_count 被 dequeue_recv_cmds 递减，健康情形恒 0（潜伏 bug 修复）
    return {"digest": state_digest(link), "frames": frame_closes,
            "stalled": stalled}


def run_predrollback(frames_n: int, seed: int, delay: int, diverge_at: int,
                      replay_budget: int = CMD_LENGTH + 2):
    """预测回滚轨：
      阶段A(投机) 每一轮 t 本地立即用 pred_word(t) 驱动权威态 -> 无停滞、帧正常闭合。
      阶段B(对账) 真字在 t+delay 到达，与当时投机的预测字比对：
        一致 -> 确认该轮；分歧 -> 回滚到分歧轮之前的快照，用【真字流】重放
        分歧轮..当前轮（重放只读真字/confirmed，禁未确认预测字转正）。
      最终权威态 = 全部真字按序驱动的结果，等价于 oracle（D1==D0）。"""
    link = Gen8Link(is_master=False, player_count=2, local_id=1)
    rounds = frames_n * (CMD_LENGTH + 1)

    # 真字流（干净）与每轮的预测字（diverge_at 轮故意预测错）
    true_words = [pred_true_word(t, seed, diverge_at) for t in range(rounds)]
    pred_words = [pred_word(t, diverge_at) for t in range(rounds)]
    for t in range(rounds):
        if not pred_word_is_control(true_words[t]) or not pred_word_is_control(pred_words[t]):
            raise RuntimeError("PRED: non-control word at t=%d (redline)" % t)

    def snap_state():
        d = copy.deepcopy(link.__dict__)
        d.pop("trace", None)  # 排除 trace，防内存累积 + 摘要污染
        return d

    def restore_state(d):
        link.__dict__.clear()
        link.__dict__.update(copy.deepcopy(d))
        link.trace = []

    spec_frame_closes = 0     # 投机阶段实际帧闭合数（A3 真实统计，不再硬编码）
    replayed_total = 0        # 真实重放轮数（A2 预算审计，不再打印窗口大小）

    def beat(w):
        """用字 w 驱动一拍权威态；帧闭合则 dequeue+process。返回是否闭合。"""
        closed = _pr_receive_beat(link, [w, 0, 0xFFFF, 0xFFFF])
        if closed:
            link.dequeue_recv_cmds()
            link.process_recv_cmds()
        return closed

    # ---- 阶段A：本地投机，每轮立即用预测字推进（无停滞）-------------------
    snapshots = {}            # t -> (state_snapshot_before_beat_t)  分歧回滚锚点
    for t in range(rounds):
        if t % (CMD_LENGTH + 1) == 0:  # 每帧首拍存快照（回滚锚点，排除 trace）
            snapshots[t] = snap_state()
        if beat(pred_words[t]):
            spec_frame_closes += 1

    # ---- 阶段B：真字到达对账 + 分歧回滚重放 -------------------------------
    predict_hits = 0
    predict_total = 0
    divergence_injected = 0 if diverge_at is None else 1
    divergence_detected = 0
    rollback_count = 0
    converged_within_budget = 0
    reconciled = False  # 单处分歧：一次回滚重放全历史真字即收敛

    for t in range(rounds):
        predict_total += 1
        if pred_words[t] == true_words[t]:
            predict_hits += 1
            continue  # 一致：投机字即真字，无需修正
        if reconciled:
            continue  # 已收敛，后续分歧不再重复回滚（本桩单处分歧场景）

        # 分歧：回滚到该轮之前的帧快照，用真字从锚点重放到末尾（confirmed 真字）
        divergence_detected += 1
        anchor = max((s for s in snapshots if s <= t), default=None)
        if anchor is None:
            continue
        restore_state(snapshots[anchor])
        rollback_count += 1
        replayed = 0
        for rt in range(anchor, rounds):
            beat(true_words[rt])
            replayed += 1
        replayed_total += replayed
        if replayed == rounds - anchor and replayed <= replay_budget + (t - anchor):
            converged_within_budget += 1
        reconciled = True

    digest = state_digest(link)
    return {
        "digest": digest,
        "frames": spec_frame_closes,  # A3 真实统计的投机帧闭合数（不再硬编码 frames_n）
        "replayed": replayed_total,   # A2 真实重放量（审计用，不再打印窗口大小）
        "stalled": 0,          # 投机推进：本地无停滞
        "predict_hits": predict_hits,
        "predict_total": predict_total,
        "divergence_injected": divergence_injected,
        "divergence_detected": divergence_detected,
        "rollback_count": rollback_count,
        "converged_within_budget": converged_within_budget,
        "success": (
            divergence_detected == divergence_injected
            and rollback_count == divergence_detected
            and converged_within_budget == divergence_detected
        ),
    }


# ---------------------------------------------------------------------------
# Master-side model: state 2 (HANDSHAKE) -> 4 (CONN_ESTABLISHED)
# ---------------------------------------------------------------------------
class MasterHandshake:
    """Faithful subset of LinkMain1/SerialCB/DoHandshake/LinkVSync for state
    transitions 2 -> 3 -> 4, plus the >=9 serial-intr/frame stability rule."""

    def __init__(self):
        self.state = LINK_STATE_START0
        self.should_advance = 0
        self.is_master = LINK_MASTER
        self.local_id = 0
        self.player_count = 0
        self.handshake_as_master = False
        self.s_handshake_player_count = 0
        self.link_field_f = 0
        self.serial_intr_counter = 0
        self.lag = LAG_NONE
        self.hardware_error = False
        self.start_transfers = 0

    # DoHandshake (link.c:2250)
    def do_handshake(self, slots):
        player_count = 0
        min_recv = 0xFFFF
        out_word = (MASTER_HANDSHAKE if self.handshake_as_master
                    else SLAVE_HANDSHAKE)
        temp = list(slots)
        for i in range(4):
            w = temp[i] & 0xFFFF
            if (w & ~0x3) == SLAVE_HANDSHAKE or w == MASTER_HANDSHAKE:
                player_count += 1
                if min_recv > w and w != 0:
                    min_recv = w
            else:
                if w != 0xFFFF:
                    player_count = 0
                break
        self.player_count = player_count
        if (player_count > 1
                and player_count == self.s_handshake_player_count
                and temp[0] == MASTER_HANDSHAKE):
            return True
        self.link_field_f = ((min_recv & 3) + 1) if player_count > 1 else 0
        self.s_handshake_player_count = player_count
        self.handshake_as_master = False   # SerialCB clears it each round
        return False

    # SerialCB HANDSHAKE branch (link.c:2222)
    def serial_cb(self, slots):
        done = self.do_handshake(slots)
        if done:
            if self.is_master:
                self.state = LINK_STATE_INIT_TIMER
                self.serial_intr_counter = 8
            else:
                self.state = LINK_STATE_CONN_ESTABLISHED
        self.serial_intr_counter = (self.serial_intr_counter + 1) & 0xFF

    # LinkMain1 (link.c:1955) -- just the state transitions
    def link_main1(self):
        if self.state == LINK_STATE_START0:
            self.state = LINK_STATE_START1
        elif self.state == LINK_STATE_START1:
            if self.should_advance == 1:
                self.state = LINK_STATE_HANDSHAKE
        elif self.state == LINK_STATE_HANDSHAKE:
            if self.should_advance == 1:
                if self.is_master == LINK_MASTER and self.player_count > 1:
                    self.handshake_as_master = True
            elif self.should_advance == 2:
                self.state = LINK_STATE_START0
        elif self.state == LINK_STATE_INIT_TIMER:
            self.state = LINK_STATE_CONN_ESTABLISHED
        # CONN_ESTABLISHED: enqueue/dequeue (not simulated here)
        self.should_advance = 0

    # LinkVSync (link.c:2159) -- the >=9 rule / LAG_MASTER
    def link_vsync(self):
        if self.is_master and self.state == LINK_STATE_CONN_ESTABLISHED:
            if self.serial_intr_counter < 9:
                self.lag = LAG_MASTER       # CheckErrorStatus -> CloseLink
                return False
            else:
                self.lag = LAG_NONE
                self.serial_intr_counter = 0
                self.start_transfers += 1
                return True
        return False


def simulate_master(intr_to_fire: int, healthy_slots=None):
    """Drive the master with `intr_to_fire` serial interrupts total and report
    whether it can reach CONN_ESTABLISHED and stay there."""
    if healthy_slots is None:
        # slot0 = master handshake (loopback), slot1 = slave handshake,
        # slots 2/3 unconnected -> 0xFFFF.  playerCount == 2 for 2P.
        healthy_slots = [MASTER_HANDSHAKE, SLAVE_HANDSHAKE, 0xFFFF, 0xFFFF]
    m = MasterHandshake()
    steps = []
    # get to HANDSHAKE
    m.link_main1()                       # START0 -> START1
    m.should_advance = 1
    m.link_main1()                       # START1 -> HANDSHAKE
    m.should_advance = 1
    m.link_main1()                       # set handshakeAsMaster
    steps.append(("enter HANDSHAKE", m.state, m.serial_intr_counter))

    for k in range(intr_to_fire):
        m.serial_cb(healthy_slots)
        steps.append(("SerialCB#%d" % (k + 1), m.state,
                      m.serial_intr_counter))
        m.link_main1()                   # INIT_TIMER -> CONN_ESTABLISHED
        steps.append(("LinkMain1", m.state, m.serial_intr_counter))

    established = (m.state == LINK_STATE_CONN_ESTABLISHED)
    vsync_ok = False
    if established:
        vsync_ok = m.link_vsync()
    return {
        "intr": intr_to_fire,
        "state": m.state,
        "pc": m.player_count,
        "sic": m.serial_intr_counter,
        "established": established,
        "vsync_ok": vsync_ok,
        "lag": m.lag,
        "steps": steps,
    }


def simulate_master_frames(per_frame_intr: int, frames: int = 3,
                           healthy_slots=None):
    """Drive the master for `frames` game frames, firing `per_frame_intr`
    SerialCBs per frame.  Returns whether it establishes AND stays healthy."""
    if healthy_slots is None:
        healthy_slots = [MASTER_HANDSHAKE, SLAVE_HANDSHAKE, 0xFFFF, 0xFFFF]
    m = MasterHandshake()
    m.link_main1()                       # START0 -> START1
    m.should_advance = 1
    m.link_main1()                       # START1 -> HANDSHAKE
    m.should_advance = 1
    m.link_main1()                       # set handshakeAsMaster
    log = []
    for f in range(frames):
        for _ in range(per_frame_intr):
            if m.state in (LINK_STATE_HANDSHAKE, LINK_STATE_INIT_TIMER):
                m.serial_cb(healthy_slots)
                m.link_main1()
            elif m.state == LINK_STATE_CONN_ESTABLISHED:
                # CONN_ESTABLISHED SerialCB: DoRecv/DoSend + counter++
                m.serial_intr_counter = (m.serial_intr_counter + 1) & 0xFF
        established = (m.state == LINK_STATE_CONN_ESTABLISHED)
        vsync = m.link_vsync() if established else False
        log.append({"frame": f, "state": m.state, "sic": m.serial_intr_counter,
                    "vsync_ok": vsync, "lag": m.lag})
        if established and not vsync:
            break   # LAG_MASTER -> CheckErrorStatus -> CloseLink
    return {"per_frame": per_frame_intr, "log": log,
            "healthy": (m.state == LINK_STATE_CONN_ESTABLISHED
                        and all(x["vsync_ok"] for x in log
                                if x["state"] == LINK_STATE_CONN_ESTABLISHED))}


# ---------------------------------------------------------------------------
# Scenarios / report
# ---------------------------------------------------------------------------
def banner(title):
    print("\n" + "=" * 78)
    print(title)
    print("=" * 78)


def scenario_reproduce_failure(verbose):
    banner("SCENARIO 1 -- REPRODUCE THE OBSERVED FAILURE (no align, offset=2)")
    r = run_slave_scenario(phase_offset=2, align=False, verbose=verbose)
    print("  slave enters 0x2222 round with sc=%d rc=%d" %
          (r["sc_at_header"], r["rc_at_header"]))
    print("  recvQueue[0][0] (slot0) after frame = %s" %
          hx(r["slot0_last_frame"]))
    print("  recvQueue[0][1] (slot1) after frame = %s" %
          hx(r["slot1_last_frame"]))
    print("  gRecvCmds[0][0] = %s   InitBlockSend calls = %d" %
          (hx(r["gRecvCmds_0_0"]), r["init_block_send"]))
    print("  RESULT: %s" % ("SUCCESS" if r["success"] else
                            "FAIL (matches APPNAVFRAMEALIGN observation)"))
    return r


def scenario_search(verbose):
    banner("SCENARIO 2 -- SEARCH (phase offset x align timing)")
    print("  offset | sc/rc@header | align        | 0x2222 filed@ | gRecvCmds[0][0] | verdict")
    print("  -------+--------------+--------------+---------------+-----------------+--------")
    results = []
    for off in range(0, 5):
        sc, rc = natural_sc_rc(off)
        for label, align, timing in [
            ("OFF", False, "none"),
            ("ON/before", True, "before_recv"),
            ("ON/after", True, "after_recv"),
        ]:
            # find where the 0x2222 word was filed in the trace
            row = next((x for x in run_slave_scenario(
                off, align, timing, verbose=False)["trace"]
                if x["remote"] == LINKCMD_SEND_LINK_TYPE), None)
            filed = ("slot%d" % row["filed_at"]) if row and row["filed_at"] is not None else "-"
            r = run_slave_scenario(off, align, timing)
            results.append((off, sc, rc, label, filed,
                            hx(r["gRecvCmds_0_0"]), r["success"]))
            print("  %6d | %2d/%-2d        | %-12s | %-13s | %-15s | %s" %
                  (off, sc, rc, label, filed, hx(r["gRecvCmds_0_0"]),
                   "PASS" if r["success"] else "FAIL"))
    return results


def scenario_required_values(verbose):
    banner("SCENARIO 3 -- EXACT REQUIRED (sc, rc) AT THE 0x2222 ROUND")
    print("  sc@header rc@header | 0x2222 filed into | ProcessRecvCmds sees 0x2222?")
    print("  -------------------+-------------------+-----------------------------")
    for sc in range(0, 9):
        rc = 0 if sc == 0 else sc - 1   # natural invariant
        # emulate a single round with forced (sc, rc) and a clean frame after
        s = Gen8Link(is_master=False, player_count=2, local_id=1)
        s.sc, s.rc = sc, rc
        filed = s.do_recv([LINKCMD_SEND_LINK_TYPE, 0, 0xFFFF, 0xFFFF])
        # finish the frame so a dequeue would see it
        slot0 = s.recv_data[0][0][s.recv_pos]
        ok = (filed == 0 and slot0 == LINKCMD_SEND_LINK_TYPE)
        print("  %2d        %2d         | %-17s | %s" %
              (sc, rc, ("recvQueue[0][%d]" % filed) if filed is not None
               else "DISCARDED(checksum)",
               "YES  <-- REQUIRED" if ok else "no"))
    print("\n  => REQUIRED:  sendCmdIndex == 1, recvCmdIndex == 0  at the")
    print("     round the master's 0x2222 is delivered to SIOMLT_RECV[0].")
    print("     (sc==0 discards it; sc>=2 files it into slot>=1.)")


def scenario_align_failure(verbose):
    banner("SCENARIO 4 -- WHY A 'FIRED' CMDFRAMEALIGN CAN STILL FAIL")
    print("  The one-shot patch is correct only if (a) it lands on the real header")
    print("  round and (b) its (sc,rc)=(1,0) survives until DoRecv() runs.")
    cases = [
        ("no patch (baseline)", dict(align=False)),
        ("patch(1,0) BEFORE recv", dict(align=True, align_timing="before_recv")),
        ("patch(1,0) AFTER recv", dict(align=True, align_timing="after_recv")),
        ("patch(1,0), then another writer stomps (2,1) before recv",
         dict(align=True, align_timing="before_recv",
              override_before_recv=(2, 1))),
    ]
    for label, kw in cases:
        r = run_slave_scenario(phase_offset=2, verbose=False, **kw)
        print("  %-58s -> slot1=%s gRecvCmds[0][0]=%s %s" %
              (label, hx(r["slot1_last_frame"]), hx(r["gRecvCmds_0_0"]),
               "PASS" if r["success"] else "FAIL"))
    print("\n  Field note: CMDFRAMEALIGN logged once but r00 stayed stale. In this")
    print("  model that is EXACTLY the 'AFTER recv' or 'stomped before recv' case:")
    print("  the log fires, yet DoRecv still sees sc=2/rc=1 and files 0x2222")
    print("  into recvQueue[0][1]. The fix must make (1,0) the value DoRecv sees.")


def scenario_master(verbose):
    banner("SCENARIO 5 -- MASTER SIDE: serialIntrCounter=1 CANNOT LEAVE STATE 2")
    for n in (1, 2, 9):
        r = simulate_master(n)
        print("  serial intr fired = %d: state=%d pc=%d sic=%d established=%s vsync_ok=%s lag=%d" %
              (n, r["state"], r["pc"], r["sic"], r["established"],
               r["vsync_ok"], r["lag"]))
        if verbose:
            for st, s, sic in r["steps"]:
                print("      %-14s state=%d sic=%d" % (st, s, sic))
    print("\n  Steady-state, N serial interrupts PER FRAME:")
    steady = {}
    for n in (1, 8, 9):
        r = simulate_master_frames(n, frames=3)
        steady[n] = r["healthy"]
        frames_str = ", ".join(
            "f%d:st%d,sic%d,vsync=%s" % (x["frame"], x["state"], x["sic"],
                                         "OK" if x["vsync_ok"] else "LAG")
            for x in r["log"])
        print("    N=%d healthy=%-5s  %s" % (n, r["healthy"], frames_str))
    print("\n  => With 1 serial interrupt DoHandshake() runs once: playerCount is")
    print("     computed but sHandshakePlayerCount was 0, so it returns FALSE and")
    print("     state stays 2 (HANDSHAKE). LinkMain1() in state 2 only calls")
    print("     CheckMasterOrSlave(); it does NOT advance to 3/4.")
    print("  => 2 stable handshake intrs get to state 3, then LinkMain1() -> 4.")
    print("  => But LinkVSync() needs serialIntrCounter >= 9 each frame, else")
    print("     LAG_MASTER is set and CheckErrorStatus() tears the link down.")
    print("     So the master needs >=9 serial interrupts PER FRAME.")
    return steady


def main(argv=None):
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--quiet", action="store_true",
                    help="only print scenario verdicts")
    ap.add_argument("--verbose", action="store_true",
                    help="print per-beat traces")
    # PREDROLLBACK：预测回滚机制自验证桩（默认关，零回归）。
    # 产物标注：非 CROSSED / mock 控制字人工注入 / 门 FAIL/0/9 不变 / diag 未接入。
    ap.add_argument("--predrollback", action="store_true",
                    help="run predictive-rollback mechanism self-test (mock control words only)")
    ap.add_argument("--seed", type=int, default=1, help="predrollback deterministic seed")
    ap.add_argument("--delay", type=int, default=2, help="delivery delay in rounds")
    ap.add_argument("--diverge-at", type=int, default=9, help="round to inject a word-level divergence")
    ap.add_argument("--frames", type=int, default=3, help="number of 9-beat frames to simulate")
    ap.add_argument("--replay-budget", type=int, default=40,
                    help="max replay rounds after a divergence (N4 budget; too small => non-converged)")
    args = ap.parse_args(argv)
    verbose = args.verbose and not args.quiet

    print("sio_cmd_sim.py -- deterministic SIO cmd-frame oracle")
    print("gen8 link.c DoRecv/DoSend/DequeueRecvCmds/ProcessRecvCmds + emulator word delivery")

    fail = scenario_reproduce_failure(verbose)
    results = scenario_search(False)
    scenario_required_values(False)
    scenario_align_failure(False)
    scenario_master(verbose)

    banner("FINAL VERDICT")
    ok_no_align = run_slave_scenario(2, align=False)["success"]
    ok_fix = run_slave_scenario(2, align=True,
                                align_timing="before_recv")["success"]
    master_bad = simulate_master(1)["established"]
    print("  current behavior (offset=2, no align) reproduces failure : %s" %
          ("YES" if not ok_no_align else "NO"))
    print("  fix (offset=2, patch sc=1/rc=0 before DoRecv) succeeds    : %s" %
          ("YES" if ok_fix else "NO"))
    print("  master with 1 serial intr cannot reach state 4           : %s" %
          ("YES" if not master_bad else "NO"))
    all_ok = (not ok_no_align) and ok_fix and (not master_bad)
    print("\n  ORACLE SELF-CHECK: %s" % ("PASS" if all_ok else "FAIL"))

    # ---- PREDROLLBACK 机制自验证（仅 --predrollback 开启时并入，默认零回归）----
    if args.predrollback:
        print("\n" + "=" * 78)
        print("PREDROLLBACK MECHANISM SELF-TEST")
        print("  NON-CROSSED / mock control words / gate FAIL/0/9 / diag NOT wired")
        print("=" * 78)
        oracle = run_oracle_baseline(args.frames, args.seed)
        delayed = run_delayed_baseline(args.frames, args.seed, args.delay)
        pred = run_predrollback(args.frames, args.seed, args.delay,
                                args.diverge_at, replay_budget=args.replay_budget)
        # 4 断言
        a1 = pred["digest"] == oracle["digest"]           # 回滚正确性 D1==D0
        a2 = pred["success"]                               # 检出/收敛/预算
        a3 = pred["frames"] == oracle["frames"]            # 不丢帧 F1==F0
        # 藏延迟代理：pred 无停滞 + 延迟基线有停滞 + 基线非饥饿(帧数>0)，关闭 delay>=rounds 盲区
        a4 = (pred["stalled"] == 0 and delayed["stalled"] > 0 and delayed["frames"] > 0)
        print("  oracle   D0=%s  F0=%d  rounds=%d" %
              (oracle["digest"][:12], oracle["frames"], oracle["rounds"]))
        print("  delayed  S =%d  frames=%d (stalled>0 and frames>0 required)" %
              (delayed["stalled"], delayed["frames"]))
        print("  pred     D1=%s  F1=%d  S =%d  hits=%d/%d" %
              (pred["digest"][:12], pred["frames"], pred["stalled"],
               pred["predict_hits"], pred["predict_total"]))
        print("  pred     inject=%d detect=%d rollback=%d converged=%d" %
              (pred["divergence_injected"], pred["divergence_detected"],
               pred["rollback_count"], pred["converged_within_budget"]))
        print("  pred     replay_budget=%d replayed=%d (N4 budget audit, real count)" %
              (args.replay_budget, pred["replayed"]))
        print("  A1 rollback-correct (D1==D0)          : %s" % ("PASS" if a1 else "FAIL"))
        print("  A2 detect==rollback==converged        : %s" % ("PASS" if a2 else "FAIL"))
        print("  A3 no-frame-loss (F1==F0)             : %s" % ("PASS" if a3 else "FAIL"))
        print("  A4 hides-delay (S_pred=0,S_delay>0,delayed_frames>0) : %s" % ("PASS" if a4 else "FAIL"))
        pred_ok = a1 and a2 and a3 and a4
        print("  PREDROLLBACK MECHANISM: %s" % ("PASS (engineering only)" if pred_ok else "FAIL"))
        print("  NOTE: PASS != gate progress != opponent-reality; no CROSSED produced.")
        all_ok = all_ok and pred_ok

    return 0 if all_ok else 1


if __name__ == "__main__":
    sys.exit(main())
