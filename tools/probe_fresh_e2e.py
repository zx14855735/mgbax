"""端到端验证修正后的建房流程：
  建新房间（先 join 再 leave 解散旧的）-> 拿新节点 -> 两端接入 -> 中继是否回应。

同时观察：中继是否必须两端都在才回 HS。
"""
import json
import os
import sys
import threading
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gboy_room as gr
import kcp_relay_test as kt

ROM = r"D:/gen8/rom.gba"
HOST = ("zx14855734@gmail.com", "14855735")
JOIN = ("525612743@qq.com", "14855735")


def fresh_room(ws, token, uuid):
    """按修正后的顺序拿一个全新的房间 + 新鲜节点。"""
    gr._send(ws, {"action": "send_message", "token": token, "message": "go", "uuid": uuid}); time.sleep(1.2)
    # 1) 先问一次当前房间
    gr._send(ws, {"action": "create_game_room", "token": token, "room_name": "probe-%d" % int(time.time())})
    time.sleep(2.0)
    old_room, old_node = None, None
    for _ in range(8):
        t = ws.recv_text(1.0)
        if not t:
            continue
        try:
            o = json.loads(t)
        except Exception:
            continue
        old_room = old_room or o.get("room_id")
        if o.get("node_address") and o.get("node_port"):
            old_node = (o["node_address"], int(o["node_port"]))
    print("  旧房间=%s 旧节点=%s" % (old_room, old_node))
    # 2) join 进去再 leave，才能让服务器解散房间
    if old_room:
        gr._send(ws, {"action": "join_room", "token": token, "room_id": old_room}); time.sleep(1.2)
    gr._send(ws, {"action": "leave_room", "token": token}); time.sleep(1.5)
    for _ in range(4):
        t = ws.recv_text(0.8)
        if t:
            print("  leave ->", t[:120])
    # 3) 建全新房间
    gr._send(ws, {"action": "create_game_room", "token": token, "room_name": "probe-%d" % int(time.time())})
    time.sleep(2.5)
    room = None
    for _ in range(8):
        t = ws.recv_text(1.0)
        if not t:
            continue
        print("  create ->", t[:200])
        try:
            o = json.loads(t)
        except Exception:
            continue
        room = room or o.get("room_id")
    return room, old_node


def main():
    uuid = gr.game_uuid(ROM)
    tok_h = gr.login(*HOST)["token"]
    tok_j = gr.login(*JOIN)["token"]
    ws_h = gr.WS(gr.WS_H, gr.WS_P)
    ws_j = gr.WS(gr.WS_H, gr.WS_P)

    print("[房主] 解散旧房间并新建：")
    room, _ = fresh_room(ws_h, tok_h, uuid)
    print(">>> 新房间 room=%s" % room)
    if not room:
        return 1

    # 房主进房 + ready + 多人设置
    gr._send(ws_h, {"action": "join_room", "token": tok_h, "room_id": room}); time.sleep(1.2)
    gr._send(ws_h, {"action": "ready", "token": tok_h}); time.sleep(1.0)
    gr._send(ws_h, {"action": "update_room_settings", "token": tok_h, "room_id": room,
                    "multi_game": 1, "is_udp": 1, "sync_modes": 1, "game_speed": 100,
                    "network_buffer": 100}); time.sleep(1.5)
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": "probe-%d" % int(time.time())})
    time.sleep(2.0)
    node = None
    for _ in range(8):
        t = ws_h.recv_text(1.0)
        if not t:
            continue
        try:
            o = json.loads(t)
        except Exception:
            continue
        if o.get("node_address") and o.get("node_port"):
            node = (o["node_address"], int(o["node_port"]))
    print(">>> 新节点 node=%s" % (node,))
    if not node:
        print("没拿到节点")
        return 1

    addr, port = node
    state = {}

    def host_client():
        """房主：连接后每 4 秒重发 HS，最多 70 秒。"""
        ch = kt.KcpChannel(addr, port, 555000001)
        time.sleep(0.2)
        try:
            ch.local_port = ch.sock.getsockname()[1]
        except Exception:
            pass
        end = time.time() + 70
        sent = 0
        while time.time() < end:
            ch._raw_send(kt.HS)
            sent += 1
            for _ in range(20):
                if ch.handshakeDone.is_set():
                    state["A"] = "HS 有回应（第 %d 次发出后，%.1fs）" % (sent, 70 - (end - time.time()))
                    return
                time.sleep(0.1)
            print("  [房主] HS 第%d次无回应..." % sent)
        state["A"] = "70s 内始终无回应"
        state["A_chan"] = ch

    t = threading.Thread(target=host_client, daemon=True)
    t.start()
    time.sleep(6)

    # 加入方：进房 + ready，然后连中继
    gr._send(ws_j, {"action": "send_message", "token": tok_j, "message": "go", "uuid": uuid}); time.sleep(1.0)
    gr._send(ws_j, {"action": "join_room", "token": tok_j, "room_id": room}); time.sleep(1.2)
    gr._send(ws_j, {"action": "ready", "token": tok_j}); time.sleep(1.2)
    print("[加入方] 已进房并 ready，开始连中继")
    chB = kt.KcpChannel(addr, port, 666000002)
    time.sleep(0.2)
    chB._raw_send(kt.HS)
    end = time.time() + 30
    b_ok = False
    while time.time() < end:
        if chB.handshakeDone.is_set():
            b_ok = True
            break
        time.sleep(0.1)
    print("② 加入方 HS:", "有回应" if b_ok else "超时")
    t.join(75)
    print("① 房主 HS:", state.get("A"))
    if chB is not None:
        chB.close()
    chan = state.get("A_chan")
    if chan is not None:
        chan.close()
    ws_h.close()
    ws_j.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
