#!/usr/bin/env python3
# GBoy 房间服务器信令工具（等价于 APK 的 GBoyCloudLink 建房/进房逻辑，仅信令层）
#
# 用法：
#   host  <email> <password> [rom.gba] [房间名]   # 建房，返回房号 + 中继节点
#   join  <email> <password> <房号> [rom.gba]      # 按房号进房，抓中继节点
#   uuid  <rom.gba>                                # 仅打印 GAME_CODE,MD5
#
# 说明：本工具只负责"在 gboy.top 建房 / 进房"这部分；对战字节仍由 APK 经中继节点收发。
#       A 与 B 都必须用同一份 rom.gba（同一 GAME_CODE,MD5），gboy.top 才允许进同一房间。
import sys, os, json, ssl, time, socket, base64, hashlib, struct, urllib.request, urllib.error

API  = "https://gboy.top/api/api.php"
WS_H = "gboy.top"
WS_P = 23459

CTX = ssl.create_default_context()
CTX.check_hostname = False
CTX.verify_mode = ssl.CERT_NONE

# ---------- HTTPS 登录 ----------
def _post(body):
    data = json.dumps(body).encode("utf-8")
    req = urllib.request.Request(API, data=data, headers={"Content-Type": "application/json"})
    try:
        with urllib.request.urlopen(req, context=CTX, timeout=15) as r:
            raw = r.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        raw = e.read().decode("utf-8", "replace")
    for line in reversed(raw.splitlines()):
        line = line.strip()
        if line.startswith("{"):
            try: return json.loads(line)
            except Exception: pass
    return {"_raw": raw}

def login(email, password):
    return _post({"action": "login", "email_or_username": email, "password": password})

# ---------- ROM 身份 ----------
def game_uuid(rom):
    if not rom or not os.path.isfile(rom):
        return "BPEE,"
    with open(rom, "rb") as f:
        head = f.read(0xB0)
        md = hashlib.md5()
        f.seek(0); md.update(f.read())
    digest = md.hexdigest()
    code = "".join(chr(b) if 0x20 <= b < 0x7F else "0" for b in head[0xAC:0xB0])
    if len(code) != 4:
        code = "BPEE"
    return f"{code},{digest}"

# ---------- 极简 WebSocket 客户端（TLS + 掩码客户端帧） ----------
class WS:
    def __init__(self, host, port):
        raw = socket.create_connection((host, port), timeout=15)
        self.s = CTX.wrap_socket(raw, server_hostname=host)
        key = base64.b64encode(os.urandom(16)).decode()
        hs = ("GET / HTTP/1.1\r\nHost: %s:%d\r\nUpgrade: websocket\r\n"
              "Connection: Upgrade\r\nSec-WebSocket-Key: %s\r\n"
              "Sec-WebSocket-Version: 13\r\n\r\n" % (host, port, key))
        self.s.sendall(hs.encode())
        buf = b""
        while b"\r\n\r\n" not in buf:
            buf += self.s.recv(1)
        if "101" not in buf.split(b"\r\n")[0].decode("latin1", "replace"):
            raise IOError("WebSocket 握手失败: " + buf.decode("latin1", "replace")[:200])
        self.buf = b""

    def send_text(self, text):
        payload = text.encode("utf-8")
        mask = os.urandom(4)
        masked = bytes(payload[i] ^ mask[i % 4] for i in range(len(payload)))
        hdr = bytearray([0x81])
        L = len(payload)
        if L < 126:
            hdr.append(0x80 | L)
        elif L < 65536:
            hdr.append(0x80 | 126); hdr += struct.pack(">H", L)
        else:
            hdr.append(0x80 | 127); hdr += struct.pack(">Q", L)
        self.s.sendall(bytes(hdr) + mask + masked)

    def recv_text(self, timeout=2.0):
        self.s.settimeout(timeout)
        try:
            while True:
                msg = self._parse()
                if msg is not None:
                    return msg
        except socket.timeout:
            return None

    def _parse(self):
        # 需要至少 2 字节头
        while len(self.buf) < 2:
            d = self.s.recv(4096)
            if not d:
                return None
            self.buf += d
        b0, b1 = self.buf[0], self.buf[1]
        opcode = b0 & 0x0F
        masked = (b1 & 0x80) != 0
        L = b1 & 0x7F
        off = 2
        if L == 126:
            while len(self.buf) < off + 2:
                self.buf += self.s.recv(4096)
            L = struct.unpack(">H", self.buf[off:off+2])[0]; off += 2
        elif L == 127:
            while len(self.buf) < off + 8:
                self.buf += self.s.recv(4096)
            L = struct.unpack(">Q", self.buf[off:off+8])[0]; off += 8
        if masked:
            while len(self.buf) < off + 4:
                self.buf += self.s.recv(4096)
            mask = self.buf[off:off+4]; off += 4
        while len(self.buf) < off + L:
            self.buf += self.s.recv(4096)
        data = self.buf[off:off+L]
        if masked:
            data = bytes(data[i] ^ mask[i % 4] for i in range(L))
        self.buf = self.buf[off+L:]
        if opcode == 0x8:        # close
            return None
        if opcode == 0x9:        # ping -> pong
            self.s.sendall(b"\x8A" + bytes([b1 & 0x7F]) + (b"" if L < 126 else b"") )
            return self._parse()
        if opcode == 0xA:        # pong
            return self._parse()
        return data.decode("utf-8", "replace")

    def close(self):
        try: self.s.close()
        except Exception: pass

# ---------- 信令 ----------
class Room:
    room_id = None
    node_address = None
    node_port = 0
    base_count = 0

def _consume(room, text):
    try: obj = json.loads(text)
    except Exception: return
    t = obj.get("type", "")
    if t == "create_game_room":
        if obj.get("room_id"): room.room_id = obj["room_id"]
        if obj.get("node_address") and obj.get("node_port", 0) > 0:
            room.node_address = obj["node_address"]; room.node_port = obj["node_port"]
        if obj.get("base_list") is not None:
            room.base_count = len(obj["base_list"])
    elif t in ("player_joined", "room_started", "game_started"):
        if obj.get("node_address") and obj.get("node_port", 0) > 0:
            room.node_address = obj["node_address"]; room.node_port = obj["node_port"]

def _send(ws, obj):
    ws.send_text(json.dumps(obj, ensure_ascii=False))

def _signal(ws, token, rom, room_id=None, room_name="mGBA"):
    uuid = game_uuid(rom)
    _send(ws, {"action": "send_message", "token": token, "message": "go", "uuid": uuid})
    time.sleep(1.2)
    if room_id is None:  # 建房
        _send(ws, {"action": "leave_room", "token": token}); time.sleep(1.2)
        _send(ws, {"action": "create_game_room", "token": token, "room_name": room_name}); time.sleep(2.5)
        deadline = time.time() + 6
        while time.time() < deadline:
            t = ws.recv_text(1.2)
            if t: _consume(Room, t)
            if Room.room_id:
                break
        if not Room.room_id:
            raise IOError("服务器没有返回房号")
        _send(ws, {"action": "join_room", "token": token, "room_id": Room.room_id}); time.sleep(1.5)
        _send(ws, {"action": "ready", "token": token}); time.sleep(1.2)
        _send(ws, {"action": "update_room_settings", "token": token, "room_id": Room.room_id,
                   "multi_game": 1, "is_udp": 1, "sync_modes": 1, "game_speed": 100, "network_buffer": 100})
        time.sleep(1.5)
        if Room.node_address is None or Room.node_port <= 0:
            _send(ws, {"action": "create_game_room", "token": token, "room_name": room_name})
            deadline = time.time() + 15
            while time.time() < deadline:
                t = ws.recv_text(1.5)
                if t: _consume(Room, t)
                if Room.node_address and Room.node_port > 0: break
    else:  # 进房
        _send(ws, {"action": "join_room", "token": token, "room_id": room_id}); time.sleep(1.8)
        _send(ws, {"action": "ready", "token": token}); time.sleep(1.2)
        deadline = time.time() + 8
        while time.time() < deadline:
            t = ws.recv_text(1.5)
            if t: _consume(Room, t)
            if Room.node_address and Room.node_port > 0: break

def cmd_host(email, password, rom, name):
    Room.room_id = Room.node_address = None; Room.node_port = 0; Room.base_count = 0
    r = login(email, password)
    if not r.get("success"):
        print("登录失败:", json.dumps(r, ensure_ascii=False)); return 1
    token = r["token"]
    ws = WS(WS_H, WS_P)
    try:
        _signal(ws, token, rom, room_id=None, room_name=name)
    finally:
        ws.close()
    print("=== 建房成功 ===")
    print("房号 room_id :", Room.room_id)
    print("中继地址      :", Room.node_address)
    print("中继端口      :", Room.node_port)
    print("加入方需在 APK 输入房号:", Room.room_id)
    return 0

def cmd_join(email, password, room_id, rom):
    Room.room_id = room_id; Room.node_address = None; Room.node_port = 0
    r = login(email, password)
    if not r.get("success"):
        print("登录失败:", json.dumps(r, ensure_ascii=False)); return 1
    token = r["token"]
    ws = WS(WS_H, WS_P)
    try:
        _signal(ws, token, rom, room_id=room_id)
    finally:
        ws.close()
    print("=== 进房结果 ===")
    print("房号          :", room_id)
    print("中继地址      :", Room.node_address)
    print("中继端口      :", Room.node_port)
    if Room.node_address is None:
        print("提示: 服务器未把中继节点推给加入方，请用 APK 手动进房或改用 NODE2:地址:端口")
    return 0

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print(__doc__); sys.exit(1)
    a = sys.argv
    if a[1] == "uuid" and len(a) >= 3:
        print(game_uuid(a[2])); sys.exit(0)
    if a[1] == "host" and len(a) >= 4:
        rom = a[4] if len(a) > 4 else None
        name = a[5] if len(a) > 5 else "mGBA"
        sys.exit(cmd_host(a[2], a[3], rom, name))
    if a[1] == "join" and len(a) >= 5:
        rom = a[5] if len(a) > 5 else None
        sys.exit(cmd_join(a[2], a[3], a[4], rom))
    print(__doc__); sys.exit(1)
