"""探测 gboy.top 房间服务器还缺哪一步动作才真正开局（中继开始收数据）。

按正确顺序建新房 -> 加入方进房 -> 逐个尝试候选动作，看服务器回什么。
"""
import json
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gboy_room as gr

ROM = r"D:/gen8/rom.gba"
HOST = ("zx14855734@gmail.com", "14855735")
JOIN = ("525612743@qq.com", "14855735")

CANDIDATES = [
    "start_game", "game_start", "start", "begin_game", "launch_game", "start_room",
    "game_started", "set_ready", "start_play", "play", "enter_game", "start_multiplayer",
]


def drain(ws, seconds, label):
    end = time.time() + seconds
    out = []
    while time.time() < end:
        t = ws.recv_text(1.0)
        if t:
            out.append(t)
            print("   [%s] << %s" % (label, t[:260]))
    return out


def main():
    uuid = gr.game_uuid(ROM)
    tok_h = gr.login(*HOST)["token"]
    tok_j = gr.login(*JOIN)["token"]
    ws_h = gr.WS(gr.WS_H, gr.WS_P)
    ws_j = gr.WS(gr.WS_H, gr.WS_P)

    # 正确顺序：先绑定游戏 -> 离开旧房 -> 建新房
    gr._send(ws_h, {"action": "send_message", "token": tok_h, "message": "go", "uuid": uuid}); time.sleep(1.2)
    gr._send(ws_h, {"action": "leave_room", "token": tok_h}); time.sleep(1.5)
    name = "probe-start-%d" % int(time.time())
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": name}); time.sleep(2.5)
    room_id, node = None, None
    for _ in range(10):
        t = ws_h.recv_text(1.2)
        if not t:
            continue
        print("[host] <<", t[:240])
        try:
            o = json.loads(t)
        except Exception:
            continue
        room_id = room_id or o.get("room_id")
        if o.get("node_address") and o.get("node_port"):
            node = (o["node_address"], int(o["node_port"]))
    print(">>> 新房间 room=%s node=%s" % (room_id, node))
    if not room_id or not node:
        print("建房失败")
        return 1

    gr._send(ws_h, {"action": "join_room", "token": tok_h, "room_id": room_id}); time.sleep(1.2)
    gr._send(ws_h, {"action": "ready", "token": tok_h}); time.sleep(1.0)
    gr._send(ws_h, {"action": "update_room_settings", "token": tok_h, "room_id": room_id,
                    "multi_game": 1, "is_udp": 1, "sync_modes": 1, "game_speed": 100,
                    "network_buffer": 100}); time.sleep(1.2)

    # 加入方
    gr._send(ws_j, {"action": "send_message", "token": tok_j, "message": "go", "uuid": uuid}); time.sleep(1.0)
    gr._send(ws_j, {"action": "join_room", "token": tok_j, "room_id": room_id}); time.sleep(1.2)
    gr._send(ws_j, {"action": "ready", "token": tok_j}); time.sleep(1.5)
    drain(ws_j, 2, "join")

    # 逐个试候选动作
    for action in CANDIDATES:
        payload = {"action": action, "token": tok_h, "room_id": room_id}
        gr._send(ws_h, payload)
        time.sleep(1.2)
        t = ws_h.recv_text(1.2)
        print("[host] %-18s -> %s" % (action, (t or "(无回复)")[:200]))

    # 最后再问一次房间状态，看 node 有没有变
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": name}); time.sleep(2.0)
    drain(ws_h, 3, "host")
    ws_h.close()
    ws_j.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
