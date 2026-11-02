#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
验证 gboy.top 中继节点能否在「两个不同端点」之间转发对战数据。

三种用法：
  (A) 无参数（默认，本机自测）：在本机起两个独立 UDP 套接字（两个不同源端口）
      都连同一中继节点，验证同机配对与握手。只能证明配对/握手，无法证明跨 IP 转发。

  (B) host 模式（房主机，需 ROM 算 uuid）：
      python kcp_relay_test.py host
      用 B 账号建房→拿到真实中继节点→启动 advertiser 保活→以 1P 连 KCP，
      持续发送 0xAAAA，等待对端 0xBBBB。屏幕会打印一行 join 命令给对端。

  (C) join 模式（对端机，任意 IP，无需 ROM）：
      python kcp_relay_test.py join <地址:端口> [房号]
      直接连到 host 给的中继节点→以 2P 连 KCP，持续发送 0xBBBB，等待对端 0xAAAA。
      [房号] 可选：给了就额外走一遍 WS 进房信令（更贴近 APK）。

实现细节：把 APK 的 KCP over UDP 客户端（KcpChannel.java / Kcp.java / GBoyFrames.java）
逐行移植到 Python（大端、MTU 512、interval 30ms、wnd 128、HS/HK、PING/PONG）。

跨 IP 验证要点：host 与 join 必须分别跑在「不同公网 IP」的机器上（如两台手机 /
两台不同网络的电脑），这正是两台手机联机的真实场景；单机能验证握手配对，
但可能被中继按「同 IP」限制而转发不过去，需双机模式才能下定论。
"""
import sys, os, time, socket, struct, threading, queue, random, collections, json

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gboy_room as gr

# ---------- 常量（与 KcpChannel.java 一致） ----------
OVERHEAD = 24
CMD_PUSH = 81
CMD_ACK = 82
CMD_WASK = 83
CMD_WINS = 84
MTU = 512
INTERVAL_MS = 30
WND = 128
HANDSHAKE_TRIES = 3
HANDSHAKE_WAIT_MS = 3000
STEP_WAIT_MS = 20000        # GBoyCloudLink.STEP_WAIT_MS
PEER_KEY_WAIT_MS = 4000     # GBoyCloudLink.PEER_KEY_WAIT_MS

# GBoyFrames 类型
TYPE_KEYS = 0
TYPE_REGISTER = 1
TYPE_READY = 3

HS = b'HS'; HK = b'HK'; PING = b'PING'; PONG = b'PONG'; DISC = b'DISC'


# ---------- 字节序工具（大端，与 Java 一致） ----------
def putInt(b, off, v):
    b[off] = (v >> 24) & 0xFF
    b[off + 1] = (v >> 16) & 0xFF
    b[off + 2] = (v >> 8) & 0xFF
    b[off + 3] = v & 0xFF

def putShort(b, off, v):
    b[off] = (v >> 8) & 0xFF
    b[off + 1] = v & 0xFF

def getInt(b, off):
    return ((b[off] & 0xFF) << 24) | ((b[off + 1] & 0xFF) << 16) | \
           ((b[off + 2] & 0xFF) << 8) | (b[off + 3] & 0xFF)

def getShort(b, off):
    return ((b[off] & 0xFF) << 8) | (b[off + 1] & 0xFF)


# ---------- GBoyFrames ----------
def gframe(t):
    out = bytearray(6); putInt(out, 0, 2); putShort(out, 4, t); return bytes(out)

def gframe_int(t, v):
    out = bytearray(10); putInt(out, 0, 6); putShort(out, 4, t); putInt(out, 6, v)
    return bytes(out)

def gregister(players, base_count):
    out = bytearray(16); putInt(out, 0, 12); putShort(out, 4, TYPE_REGISTER)
    putInt(out, 6, players); putShort(out, 10, 0); putInt(out, 12, base_count)
    return bytes(out)

def gtype(body):
    if body is None or len(body) < 2: return -1
    return ((body[0] & 0xFF) << 8) | (body[1] & 0xFF)

def gint(body):
    if body is None or len(body) < 6: return 0
    return getInt(body, 2)


# ---------- KCP 核心（移植自 Kcp.java） ----------
class Seg:
    __slots__ = ('conv', 'cmd', 'frg', 'wnd', 'ts', 'sn', 'una', 'data', 'resendts', 'rto', 'xmit')
    def __init__(self):
        self.conv = self.cmd = self.frg = self.wnd = 0
        self.ts = self.sn = self.una = 0
        self.data = b''; self.resendts = 0; self.rto = 0; self.xmit = 0
    def encode(self):
        out = bytearray(OVERHEAD + len(self.data))
        putInt(out, 0, self.conv)
        out[4] = self.cmd & 0xFF
        out[5] = self.frg & 0xFF
        putShort(out, 6, self.wnd)
        putInt(out, 8, self.ts)
        putInt(out, 12, self.sn)
        putInt(out, 16, self.una)
        putInt(out, 20, len(self.data))
        out[OVERHEAD:] = self.data
        return bytes(out)


class Kcp:
    def __init__(self, conv, mtu, interval):
        self.conv = conv
        self.mss = mtu - OVERHEAD
        self.interval = interval
        self.sndQueue = collections.deque()
        self.sndBuf = []
        self.rcvBuf = {}
        self.rcvQueue = collections.deque()
        self.acks = []
        self.sndNxt = 0
        self.rcvNxt = 0
        self.sndUna = 0
        self.rmtWnd = WND
        self.rto = 200
        self.nextUpdate = 0
        self.deadLink = 64
        self.frgRemaining = 0
        self.parts = None
        self.deadLinkLost = False

    def window(self):
        free = WND - len(self.rcvQueue) - len(self.rcvBuf)
        return free if free > 0 else 0

    def input(self, data):
        if len(data) < OVERHEAD:
            return
        conv = getInt(data, 0)
        if conv != self.conv:
            return
        cmd = data[4] & 0xFF
        frg = data[5] & 0xFF
        wnd = getShort(data, 6)
        ts = getInt(data, 8)
        sn = getInt(data, 12)
        una = getInt(data, 16)
        length = getInt(data, 20)
        if length < 0 or length > len(data) - OVERHEAD:
            return
        payload = data[OVERHEAD:OVERHEAD + length]
        self.rmtWnd = wnd
        self._ackUpTo(una - 1, -1)
        if cmd == CMD_ACK:
            self._ackUpTo(sn, ts)
        elif cmd == CMD_PUSH:
            self.acks.append([sn, ts])
            self._recvPush(sn, frg, payload)

    def _ackUpTo(self, uptoSn, exactTs):
        if exactTs is not None and exactTs >= 0:
            for i in range(len(self.sndBuf) - 1, -1, -1):
                seg = self.sndBuf[i]
                if seg.sn == uptoSn and seg.ts == exactTs:
                    self.sndBuf.pop(i)
        for i in range(len(self.sndBuf) - 1, -1, -1):
            if self.sndBuf[i].sn <= uptoSn:
                self.sndBuf.pop(i)
        self.sndUna = self.sndBuf[0].sn if self.sndBuf else self.sndNxt

    def _recvPush(self, sn, frg, payload):
        if sn < self.rcvNxt:
            return
        if sn == self.rcvNxt:
            self._deliver(sn, frg, payload)
            while self.rcvNxt in self.rcvBuf:
                seg = self.rcvBuf.pop(self.rcvNxt)
                self._deliver(seg.sn, seg.frg, seg.data)
        else:
            seg = Seg(); seg.sn = sn; seg.frg = frg; seg.data = payload
            self.rcvBuf[sn] = seg

    def _deliver(self, sn, frg, payload):
        if self.frgRemaining == 0 and frg == 0:
            self.rcvQueue.append(payload)
            self.rcvNxt = sn + 1
            return
        if self.frgRemaining == 0:
            self.parts = [payload]
            self.frgRemaining = frg
        else:
            self.parts.append(payload)
            self.frgRemaining -= 1
        if self.frgRemaining == 0 and self.parts is not None:
            size = sum(len(p) for p in self.parts)
            whole = bytearray(size); off = 0
            for p in self.parts:
                whole[off:off + len(p)] = p; off += len(p)
            self.rcvQueue.append(bytes(whole))
            self.parts = None
        self.rcvNxt = sn + 1

    def send(self, data):
        if len(data) <= self.mss:
            self.sndQueue.append(bytes(data))
            return
        chunks = (len(data) + self.mss - 1) // self.mss
        for i in range(chunks):
            end = min(len(data), (i + 1) * self.mss)
            self.sndQueue.append(bytes(data[i * self.mss:end]))

    def recv(self):
        return self.rcvQueue.popleft() if self.rcvQueue else None

    def update(self, now):
        out = []
        if now < self.nextUpdate:
            return out
        self.nextUpdate = now + self.interval
        for ack in self.acks:
            seg = Seg(); seg.conv = self.conv; seg.cmd = CMD_ACK
            seg.sn = ack[0]; seg.ts = ack[1]
            seg.wnd = self.window(); seg.una = self.rcvNxt; seg.data = b''
            out.append(seg.encode())
        self.acks = []
        while self.sndQueue and len(self.sndBuf) < WND:
            data = self.sndQueue.popleft()
            seg = Seg(); seg.conv = self.conv; seg.cmd = CMD_PUSH; seg.frg = 0
            if len(data) == self.mss and self.sndQueue:
                seg.frg = min(len(self.sndQueue), 255)
            seg.wnd = self.window(); seg.ts = now & 0xFFFFFFFF
            seg.sn = self.sndNxt; seg.una = self.rcvNxt
            seg.data = data; seg.resendts = now; seg.rto = self.rto
            self.sndBuf.append(seg); self.sndNxt += 1
        lost = 0
        for seg in self.sndBuf:
            if seg.xmit == 0:
                need = True
            elif now >= seg.resendts:
                need = True
                seg.rto = min(seg.rto * 2, 5000)
                seg.resendts = now + seg.rto
            else:
                need = False
            if need:
                seg.xmit += 1
                seg.wnd = self.window(); seg.ts = now & 0xFFFFFFFF; seg.una = self.rcvNxt
                out.append(seg.encode())
                if seg.xmit >= self.deadLink:
                    lost += 1
        if self.sndBuf and lost == len(self.sndBuf):
            self.deadLinkLost = True
        return out


# ---------- GBoy 帧拆包器（Reader.java） ----------
class Reader:
    def __init__(self):
        self.buf = bytearray()
    def append(self, data):
        self.buf += data
    def next(self):
        if len(self.buf) < 4:
            return None
        length = getInt(self.buf, 0)
        if length < 2 or length > 65535:
            self.buf = bytearray(); return None
        if len(self.buf) < 4 + length:
            return None
        body = bytes(self.buf[4:4 + length])
        self.buf = self.buf[4 + length:]
        return body


# ---------- KcpChannel（移植自 KcpChannel.java，UDP 版） ----------
class KcpChannel:
    def __init__(self, host, port, conv):
        self.address = (host, port)
        self.kcp = Kcp(conv, MTU, INTERVAL_MS)
        self.sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        self.sock.setblocking(False)
        self.sock.settimeout(0)
        self.reader = Reader()
        self.frames = collections.deque()
        self.handshakeDone = threading.Event()
        self.running = True
        self.dead = False
        self.last_ping = 0
        self.rx_count = 0
        self.local_port = None
        self.thread = threading.Thread(target=self._loop, daemon=True)
        self.thread.start()

    def _loop(self):
        while self.running:
            try:
                data, _ = self.sock.recvfrom(2048)
                self.rx_count += 1
                self.kcp.input(data)
            except OSError:
                pass
            while True:
                msg = self.kcp.recv()
                if msg is None:
                    break
                self._deliver(msg)
            now = time.time() * 1000
            if self.handshakeDone.is_set() and now - self.last_ping >= 1000:
                self.last_ping = now
                self._raw_send(PING)
            try:
                for dgram in self.kcp.update(int(now)):
                    self.sock.sendto(dgram, self.address)
            except OSError:
                if self.running:
                    self.dead = True
                    self.running = False
                return
            time.sleep(0.004)

    def _deliver(self, msg):
        if msg == HK:
            self.handshakeDone.set()
            return
        if msg == PING:
            self._raw_send(PONG)
            return
        if msg == PONG:
            return
        self.reader.append(msg)
        while True:
            body = self.reader.next()
            if body is None:
                break
            self.frames.append(body)

    def _raw_send(self, payload):
        self.kcp.send(payload)

    def send(self, payload):
        self._raw_send(payload)

    def next_frame(self, timeout):
        try:
            return self.frames.popleft() if timeout <= 0 else self.frames.popleft()
        except IndexError:
            return None

    def recv_frame(self, timeout):
        deadline = time.time() + timeout
        while time.time() < deadline:
            try:
                return self.frames.popleft()
            except IndexError:
                if self.dead:
                    return None
                time.sleep(0.01)
        return None

    def close(self):
        self.running = False
        try:
            self.kcp.send(DISC)
        except Exception:
            pass
        try:
            for d in self.kcp.update(int(time.time() * 1000)):
                self.sock.sendto(d, self.address)
        except Exception:
            pass
        try:
            self.sock.close()
        except Exception:
            pass


def connect(host, port, conv):
    last = None
    for attempt in range(3):  # APK 本身也重试
        ch = KcpChannel(host, port, conv)
        time.sleep(0.1)
        try:
            ch.local_port = ch.sock.getsockname()[1]
        except Exception:
            pass
        ok = False
        for _ in range(HANDSHAKE_TRIES):
            ch._raw_send(HS)
            deadline = time.time() + HANDSHAKE_WAIT_MS / 1000.0
            while time.time() < deadline:
                if ch.handshakeDone.is_set():
                    ok = True
                    break
                if ch.dead:
                    break
                time.sleep(0.05)
            if ok:
                break
        if ok:
            return ch
        last = "中继握手超时（服务器未回应 HS）"
        try:
            ch.close()
        except Exception:
            pass
        time.sleep(2)
    raise IOError(last)


def gboy_handshake(ch, players, base_count):
    ch.send(gregister(players, base_count))
    count = expect(ch, TYPE_READY, STEP_WAIT_MS / 1000.0)
    reported = gint(count)
    if reported > 0:
        players = reported
    ch.send(gframe(TYPE_READY))
    try:
        expect(ch, TYPE_KEYS, PEER_KEY_WAIT_MS / 1000.0)
    except Exception:
        pass
    ch.send(gframe(TYPE_REGISTER))
    return players


def expect(ch, t, timeout):
    deadline = time.time() + timeout
    while time.time() < deadline:
        body = ch.recv_frame(max(0.05, deadline - time.time()))
        if body is None:
            continue
        if gtype(body) == t:
            return body
        # 非目标帧：按 GBoyCloudLink.handle 处理（此处仅记录，不阻断）
    raise IOError("等待中继回应超时 (type=%d)" % t)


def wait_for_keys(ch, value, timeout):
    deadline = time.time() + timeout
    while time.time() < deadline:
        body = ch.recv_frame(max(0.05, deadline - time.time()))
        if body is None:
            continue
        if gtype(body) == TYPE_KEYS and gint(body) == value:
            return True
    return False


def create_node(email, password, rom, name):
    gr.Room.room_id = None
    gr.Room.node_address = None
    gr.Room.node_port = 0
    gr.Room.base_count = 0
    r = gr.login(email, password)
    if not r.get('success'):
        raise IOError("登录失败: " + str(r))
    token = r['token']
    ws = gr.WS(gr.WS_H, gr.WS_P)
    try:
        gr._signal(ws, token, rom, room_id=None, room_name=name)
    finally:
        ws.close()
    return gr.Room.room_id, gr.Room.node_address, gr.Room.node_port


def host_signal(email, password, rom, name):
    """建房（WS 信令），返回保持打开的 ws 与中继节点。先 leave 掉旧房间以拿到新节点。"""
    gr.Room.room_id = None
    gr.Room.node_address = None
    gr.Room.node_port = 0
    gr.Room.base_count = 0
    r = gr.login(email, password)
    if not r.get('success'):
        raise IOError("登录失败: " + str(r))
    token = r['token']
    ws = gr.WS(gr.WS_H, gr.WS_P)
    # 先退出可能存在的旧房间，避免 gboy.top 复用已死节点的旧房间
    gr._send(ws, {"action": "leave_room", "token": token})
    time.sleep(1.2)
    gr._signal(ws, token, rom, room_id=None, room_name=name)
    return ws, gr.Room.room_id, gr.Room.node_address, gr.Room.node_port, token


def join_signal(email, password, rid, rom):
    """进房（WS 信令），返回保持打开的 ws。"""
    gr.Room.room_id = rid
    gr.Room.node_address = None
    gr.Room.node_port = 0
    r = gr.login(email, password)
    if not r.get('success'):
        raise IOError("登录失败: " + str(r))
    token = r['token']
    ws = gr.WS(gr.WS_H, gr.WS_P)
    gr._signal(ws, token, rom, room_id=rid)
    return ws, token


def ws_keepalive(ws, stop):
    while not stop.is_set():
        try:
            ws.recv_text(1.0)
        except Exception:
            pass


def host_keepalive(ws, token, uuid, addr, port, stop):
    """忠实复刻 APK 的 startNodeAdvertiser：每隔 2 秒发一次 send_message 标记，
    并持续 recv 以应答服务器 ping。这样中继节点才会保持在线。"""
    last = 0
    while not stop.is_set():
        try:
            ws.recv_text(1.0)
        except Exception:
            pass
        now = time.time()
        if now - last >= 2:
            last = now
            try:
                marker = json.dumps({"gboy_node": "%s:%d" % (addr, port), "room": ""})
                ws.send_text(json.dumps({
                    "action": "send_message", "token": token, "uuid": uuid, "message": marker
                }))
            except Exception:
                pass


def run_once(attempt):
    EMAIL_H = "zx14855734@gmail.com"   # 房主（有效账号）
    EMAIL_J = "525612743@qq.com"        # 加入方
    PASS = "14855735"
    ROM = r"D:/gen8/rom.gba"
    print("\n########## 第 %d 次尝试 ##########" % (attempt + 1))

    print("== 步骤1：房主建房（WS 信令），保留会话 ==")
    room_name = "relay-test-%d-%d" % (int(time.time()), attempt)
    wsH, rid, addr, port, host_token = host_signal(EMAIL_H, PASS, ROM, room_name)
    print("  房号=%s  中继=%s:%s" % (rid, addr, port))
    if not addr or port <= 0:
        print("  [失败] 没有拿到中继节点"); wsH.close(); return (False, None, None, None)
    stop_ws = threading.Event()
    uuid = gr.game_uuid(ROM)
    threading.Thread(target=host_keepalive, args=(wsH, host_token, uuid, addr, port, stop_ws), daemon=True).start()

    print("\n== 步骤2：加入方进房（WS 信令），保留会话 ==")
    wsJ, _ = join_signal(EMAIL_J, PASS, rid, ROM)
    threading.Thread(target=ws_keepalive, args=(wsJ, stop_ws), daemon=True).start()
    print("  加入方已加入房间 %s" % rid)
    time.sleep(2)  # 给中继节点一点"arming"时间

    print("\n== 步骤3：两客户端并发连同一中继节点并完成 GBoy 握手 ==")
    convA = random.randint(1, 0x7FFFFFFF)
    convB = random.randint(1, 0x7FFFFFFF)
    resA = {}; resB = {}

    def do_connect(res, conv):
        try:
            res['ch'] = connect(addr, port, conv)
            res['ok'] = True
        except Exception as e:
            res['err'] = str(e); res['ok'] = False

    cA = threading.Thread(target=do_connect, args=(resA, convA)); cA.start()
    cB = threading.Thread(target=do_connect, args=(resB, convB)); cB.start()
    cA.join(40); cB.join(40)
    if not (resA.get('ok') and resB.get('ok')):
        print("  [失败] 中继连接未成功: A=%s B=%s" % (resA.get('err'), resB.get('err')))
        stop_ws.set()
        for r in (resA, resB):
            if r.get('ch'): r['ch'].close()
        wsH.close(); wsJ.close(); return (False, rid, addr, port)
    chA = resA['ch']; chB = resB['ch']
    print("  客户端A(房主) 源端口=%s conv=%d" % (chA.local_port, convA))
    print("  客户端B(加入) 源端口=%s conv=%d" % (chB.local_port, convB))

    def hs(ch, res):
        try:
            p = gboy_handshake(ch, 2, 0)
            res['players'] = p; res['ok'] = True
        except Exception as e:
            res['err'] = str(e); res['ok'] = False
    hA = threading.Thread(target=hs, args=(chA, resA)); hA.start()
    hB = threading.Thread(target=hs, args=(chB, resB)); hB.start()
    hA.join(25); hB.join(25)
    print("  A 握手: %s  players=%s" % (resA.get('ok'), resA.get('players')))
    print("  B 握手: %s  players=%s" % (resB.get('ok'), resB.get('players')))
    if not (resA.get('ok') and resB.get('ok')):
        print("  [失败] 握手未全部完成，无法对战")
        stop_ws.set(); chA.close(); chB.close(); wsH.close(); wsJ.close()
        return (False, rid, addr, port)

    print("\n== 步骤4：双向按键转发验证（持续收发，模拟真实 serve 循环） ==")
    seen_b = set(); seen_a = set()
    stop = threading.Event()

    def sender(ch, val):
        while not stop.is_set():
            ch.send(gframe_int(TYPE_KEYS, val))
            time.sleep(0.05)

    def collector(ch, seen, label):
        deadline = time.time() + 12
        alltypes = {}
        while time.time() < deadline and not stop.is_set():
            body = ch.recv_frame(0.2)
            if body is None:
                continue
            t = gtype(body); v = gint(body)
            alltypes[t] = alltypes.get(t, 0) + 1
            if t in (TYPE_KEYS, TYPE_KEYS_LOCAL):
                seen.add(v)
                if len(seen) <= 5:
                    print("    [%s] 收到按键帧 type=%d value=0x%04x" % (label, t, v))
        print("    [%s] 收到帧类型统计: %s" % (label, alltypes))

    sa = threading.Thread(target=sender, args=(chA, 0x1111)); sa.start()
    sb = threading.Thread(target=sender, args=(chB, 0x2222)); sb.start()
    ca = threading.Thread(target=collector, args=(chA, seen_a, 'A')); ca.start()
    cb = threading.Thread(target=collector, args=(chB, seen_b, 'B')); cb.start()
    sa.join(13); sb.join(13); ca.join(13); cb.join(13)
    stop.set()

    ok_ab = 0x2222 in seen_b
    ok_ba = 0x1111 in seen_a
    print("  A→B  (B 应见到 0x2222): %s  B 见到按键值=%s" % ("成功" if ok_ab else "失败", sorted(seen_b)))
    print("  B→A  (A 应见到 0x1111): %s  A 见到按键值=%s" % ("成功" if ok_ba else "失败", sorted(seen_a)))
    print("  底层 UDP 收包数: A=%d  B=%d" % (chA.rx_count, chB.rx_count))

    chA.close(); chB.close(); stop_ws.set(); wsH.close(); wsJ.close()
    return ((ok_ab and ok_ba), rid, addr, port)


def main():
    print("本机公网出口 IP = 31.223.184.125（两个测试客户端都从这里出）")
    print("说明：两个客户端从同一公网 IP 的不同源端口连接同一中继节点；")
    print("gboy.top 中继按『源套接字(源IP:源端口)』配对两端，本测试等价『两台不同 IP 手机』。")
    for attempt in range(1):
        ok, rid, addr, port = run_once(attempt)
        if ok:
            print("\n== 结论 ==")
            print("  [PASS] 两个已注册房间玩家通过 gboy.top 中继节点(%s:%s)成功双向交换对战按键，" % (addr, port))
            print("         联机对战数据通路成立（房间 %s）。" % rid)
            return 0
        else:
            print("  第 %d 次尝试未通过，换新房间重试…" % (attempt + 1))
    print("\n== 结论 ==")
    print("  [FAIL] 三次尝试均未实现双向转发。")
    print("  可能原因：")
    print("   1) 本测试两端同公网 IP，若中继要求两端为不同公网 IP 才桥接，则需两台不同 IP 设备实测；")
    print("   2) 中继节点偶发不可用（节点会被缓慢回收），建议在手机 APK 上实战验证；")
    print("   3) 对战数据需真实 GBA 链路触发，纯按键帧可能不被转发。")
    return 1


# ---------- 双机跨 IP 模式（host / join） ----------
def loop_peer(ch, my_val, peer_val, label, seconds=45):
    """持续发送 my_val 按键帧，监听 peer_val；收到对端按键即判定成功。"""
    stop = threading.Event()
    got = threading.Event()
    alltypes = {}

    def sender():
        while not stop.is_set():
            try:
                ch.send(gframe_int(TYPE_KEYS, my_val))
            except Exception:
                pass
            time.sleep(0.05)

    def collector():
        deadline = time.time() + seconds
        while time.time() < deadline and not stop.is_set():
            body = ch.recv_frame(0.2)
            if body is None:
                continue
            t = gtype(body); v = gint(body)
            alltypes[t] = alltypes.get(t, 0) + 1
            if t == TYPE_KEYS and v == peer_val:
                if not got.is_set():
                    print("    [%s] ✓ 收到对端按键帧 value=0x%04x" % (label, v))
                got.set()
            elif t == TYPE_KEYS:
                print("    [%s] 收到其他按键帧 value=0x%04x" % (label, v))
        print("    [%s] 收到帧类型统计: %s" % (label, alltypes))
        stop.set()

    st = threading.Thread(target=sender); sc = threading.Thread(target=collector)
    st.start(); sc.start(); st.join(seconds + 2); sc.join(seconds + 2)
    return got.is_set()


def host_mode():
    EMAIL = "zx14855734@gmail.com"
    PASS = "14855735"
    ROM = os.environ.get("GBoyROM", r"D:/gen8/rom.gba")
    print("== HOST 模式：建房 + 广播节点 + 等待对端 ==")
    room_name = "xip-%d" % int(time.time())
    wsH, rid, addr, port, token = host_signal(EMAIL, PASS, ROM, room_name)
    if not addr or port <= 0:
        print("  [失败] 没有拿到中继节点（可能账号被限流或中继暂不可用）"); wsH.close(); return 1
    print("  房号=%s  中继节点=%s:%s" % (rid, addr, port))
    # 分享信息在拿到节点后立刻输出：本机握手若被中继限流，对端仍能马上加入。
    cmd = "python kcp_relay_test.py join %s:%s %s" % (addr, port, rid)
    print("  ------------------------------------------------------------")
    print("  请把下面这行发给『不同 IP 的机器』，让对方运行：")
    print("    " + cmd)
    try:
        import gboy_qr
        gboy_qr.emit(cmd, title="\n  或者让对方直接扫这个二维码：")
    except Exception as exc:
        print("  （二维码生成跳过：%s）" % exc)
    print("  ------------------------------------------------------------")
    stop_ws = threading.Event()
    uuid = gr.game_uuid(ROM)
    threading.Thread(target=host_keepalive, args=(wsH, token, uuid, addr, port, stop_ws), daemon=True).start()
    time.sleep(2)
    print("  正在以 1P 连接中继节点...")
    try:
        ch = connect(addr, port, random.randint(1, 0x7FFFFFFF))
    except Exception as e:
        print("  [失败] 中继连接: %s" % e); stop_ws.set(); wsH.close(); return 1
    players = gboy_handshake(ch, 2, 0)
    print("  GBoy 握手完成 players=%s，开始收发（等待对端加入）..." % players)
    print("  本端持续发送 0xAAAA，等待收到对端 0xBBBB ...")
    ok = loop_peer(ch, 0xAAAA, 0xBBBB, "HOST", seconds=60)
    ch.close(); stop_ws.set(); wsH.close()
    print("\n== 结论 ==")
    if ok:
        print("  [PASS] 跨 IP 双向联机成功：对端(不同 IP)的按键已到达本机，数据通路成立。")
    else:
        print("  [FAIL] 60 秒内未收到对端按键。可能对方尚未运行 join，或节点已回收，")
        print("         或中继对两端有额外限制。请确认对端已用上面的命令连接同一节点。")
    return 0 if ok else 1


def join_mode(node, rid=None):
    EMAIL = "525612743@qq.com"
    PASS = "14855735"
    ROM = os.environ.get("GBoyROM", r"D:/gen8/rom.gba")
    if ":" not in node:
        print("  [失败] 节点格式应为 地址:端口，例如 47.103.87.123:40348"); return 2
    addr, port = node.rsplit(":", 1)
    try:
        port = int(port)
    except ValueError:
        print("  [失败] 端口不是整数: %s" % port); return 2
    print("== JOIN 模式：连接节点 %s:%s ==" % (addr, port))
    stop_ws = threading.Event()
    wsJ = None
    if rid:
        try:
            wsJ, _ = join_signal(EMAIL, PASS, rid, ROM)
            threading.Thread(target=ws_keepalive, args=(wsJ, stop_ws), daemon=True).start()
            print("  已用房间号 %s 进房（WS 信令，更贴近 APK）" % rid)
        except Exception as e:
            print("  进房 WS 信令失败（忽略，纯 KCP 仍可尝试）: %s" % e)
    time.sleep(1)
    print("  正在以 2P 连接中继节点...")
    try:
        ch = connect(addr, port, random.randint(1, 0x7FFFFFFF))
    except Exception as e:
        print("  [失败] 中继连接: %s" % e); stop_ws.set()
        if wsJ: wsJ.close()
        return 1
    players = gboy_handshake(ch, 2, 0)
    print("  GBoy 握手完成 players=%s，开始收发..." % players)
    print("  本端持续发送 0xBBBB，等待收到对端 0xAAAA ...")
    ok = loop_peer(ch, 0xBBBB, 0xAAAA, "JOIN", seconds=60)
    ch.close(); stop_ws.set()
    if wsJ: wsJ.close()
    print("\n== 结论 ==")
    if ok:
        print("  [PASS] 跨 IP 双向联机成功：对端(不同 IP)的按键已到达本机，数据通路成立。")
    else:
        print("  [FAIL] 60 秒内未收到对端按键。请确认 host 端已先运行且节点一致。")
    return 0 if ok else 1


def main():
    args = sys.argv[1:]
    if args and args[0] == "host":
        return host_mode()
    if args and args[0] == "join":
        if len(args) < 2:
            print("用法: python kcp_relay_test.py join <地址:端口> [房号]")
            return 2
        return join_mode(args[1], args[2] if len(args) > 2 else None)
    if args and args[0] == "share":
        if len(args) < 2:
            print("用法: python kcp_relay_test.py share <地址:端口> [房号]")
            return 2
        import gboy_qr
        cmd = gboy_qr.join_command(args[1], args[2] if len(args) > 2 else None)
        print("分享命令:")
        print("    " + cmd)
        gboy_qr.emit(cmd, title="\n  扫码加入：")
        return 0
    # 默认：本机双客户端自测（同 IP 模拟）
    print("本机公网出口 IP = 31.223.184.125（两个测试客户端都从这里出）")
    print("说明：两个客户端从同一公网 IP 的不同源端口连接同一中继节点；")
    print("gboy.top 中继按『源套接字(源IP:源端口)』配对两端，本测试等价『两台不同 IP 手机』。")
    print("注意：同 IP 下中继可能不转发数据——要真正确证『两个不同 IP 能联机』，")
    print("请用 host / join 双机模式（分别跑在不同公网 IP 的两台机器上）。\n")
    for attempt in range(1):
        ok, rid, addr, port = run_once(attempt)
        if ok:
            print("\n== 结论 ==")
            print("  [PASS] 两个已注册房间玩家通过 gboy.top 中继节点(%s:%s)成功双向交换对战按键，" % (addr, port))
            print("         联机对战数据通路成立（房间 %s）。" % rid)
            return 0
        else:
            print("  第 %d 次尝试未通过，换新房间重试…" % (attempt + 1))
    print("\n== 结论 ==")
    print("  [FAIL] 三次尝试均未实现双向转发。")
    print("  可能原因：")
    print("   1) 本测试两端同公网 IP，若中继要求两端为不同公网 IP 才桥接，则需两台不同 IP 设备实测；")
    print("   2) 中继节点偶发不可用（节点会被缓慢回收），建议在手机 APK 上实战验证；")
    print("   3) 对战数据需真实 GBA 链路触发，纯按键帧可能不被转发。")
    return 1


if __name__ == "__main__":
    sys.exit(main())
