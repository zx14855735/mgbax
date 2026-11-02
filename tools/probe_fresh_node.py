"""想办法拿到一个「活着」的中继节点：

1. 原始 UDP 探测当前节点是否还有监听；
2. 尝试各种方式强制换新房间/新节点（不同 room_name / force 标记 / 不同 uuid /
   先 join 再 leave 再 create）。
"""
import json
import os
import socket
import struct
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gboy_room as gr

ROM = r"D:/gen8/rom.gba"
HOST = ("zx14855734@gmail.com", "14855735")


def raw_udp_probe(addr, port, label):
    """直接发一个 KCP PUSH("HS")，看有没有任何 UDP 回包。"""
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.settimeout(2.5)
    s.bind(("", 0))
    local = s.getsockname()[1]
    conv = 777000001
    payload = b"HS"
    seg = bytearray(24 + len(payload))
    struct.pack_into(">I", seg, 0, conv)
    seg[4] = 81
    seg[5] = 0
    seg[6] = 0
    seg[7] = 128
    struct.pack_into(">I", seg, 8, int(time.time() * 1000) & 0xFFFFFFFF)
    struct.pack_into(">I", seg, 12, 0)
    struct.pack_into(">I", seg, 16, 0)
    struct.pack_into(">I", seg, 20, len(payload))
    seg[24:] = payload
    print("  UDP 探测 %s:%s (本机端口 %s)" % (addr, port, local))
    for i in range(3):
        s.sendto(bytes(seg), (addr, port))
        try:
            d, a = s.recvfrom(2048)
            print("    ✔ 有回包 from %s len=%d %s" % (a, len(d), d[:16].hex()))
            s.close()
            return True
        except socket.timeout:
            pass
    print("    ✘ 无任何 UDP 回包（节点可能已回收，或 UDP 被拦）")
    s.close()
    return False


def wait_node(ws, seconds=8):
    node = None
    end = time.time() + seconds
    while time.time() < end:
        t = ws.recv_text(1.0)
        if not t:
            continue
        try:
            o = json.loads(t)
        except Exception:
            continue
        if o.get("node_address") and o.get("node_port"):
            node = (o["node_address"], int(o["node_port"]))
            break
    return node


def main():
    uuid = gr.game_uuid(ROM)
    tok = gr.login(*HOST)["token"]
    ws = gr.WS(gr.WS_H, gr.WS_P)
    gr._send(ws, {"action": "send_message", "token": tok, "message": "go", "uuid": uuid}); time.sleep(1.2)

    # --- 0) 当前房间的节点 ---
    gr._send(ws, {"action": "create_game_room", "token": tok, "room_name": "probe-fresh-%d" % int(time.time())})
    time.sleep(2.0)
    room = None
    node = None
    for _ in range(8):
        t = ws.recv_text(1.0)
        if not t:
            continue
        try:
            o = json.loads(t)
        except Exception:
            continue
        room = room or o.get("room_id")
        if o.get("node_address") and o.get("node_port"):
            node = (o["node_address"], int(o["node_port"]))
    print("当前房间 room=%s node=%s" % (room, node))
    if node:
        raw_udp_probe(node[0], node[1], "当前节点")

    # --- 1) 先 join 再 leave 再 create，看能否换新房间 ---
    print("\n[尝试1] join_room -> leave_room -> create_game_room(新名字)")
    gr._send(ws, {"action": "join_room", "token": tok, "room_id": room}); time.sleep(1.2)
    gr._send(ws, {"action": "leave_room", "token": tok}); time.sleep(1.5)
    gr._send(ws, {"action": "create_game_room", "token": tok, "room_name": "probe-new-%d" % int(time.time())})
    time.sleep(2.0)
    for _ in range(6):
        t = ws.recv_text(1.0)
        if t:
            print("   <<", t[:200])
    node2 = wait_node(ws, 4)
    print("   -> node=%s" % (node2,))

    # --- 2) 带 force 标记 create ---
    print("\n[尝试2] create_game_room + force=1")
    gr._send(ws, {"action": "create_game_room", "token": tok,
                  "room_name": "probe-force-%d" % int(time.time()), "force": 1, "new_node": 1})
    time.sleep(2.0)
    for _ in range(5):
        t = ws.recv_text(1.0)
        if t:
            print("   <<", t[:200])

    # --- 3) 换一个 uuid（不同游戏）看看房间是否按游戏区分 ---
    print("\n[尝试3] 换 uuid 再 create")
    gr._send(ws, {"action": "leave_room", "token": tok}); time.sleep(1.0)
    gr._send(ws, {"action": "send_message", "token": tok, "message": "go", "uuid": "ZZZZ,deadbeefdeadbeefdeadbeefdeadbeef"})
    time.sleep(1.2)
    gr._send(ws, {"action": "create_game_room", "token": tok, "room_name": "probe-uuid-%d" % int(time.time())})
    time.sleep(2.0)
    for _ in range(6):
        t = ws.recv_text(1.0)
        if t:
            print("   <<", t[:200])
    node3 = wait_node(ws, 4)
    print("   -> node=%s" % (node3,))
    if node3 and node3 != node:
        raw_udp_probe(node3[0], node3[1], "新节点")

    ws.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
