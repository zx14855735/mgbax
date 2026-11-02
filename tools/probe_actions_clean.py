"""严谨探测：服务器到底认哪个「开局」动作。

做法：每次发候选动作前先把 WebSocket 队列排空，发完只读一条回复；
      回复若是 {"type":"error","error":"未知操作"} 说明动作不存在，否则说明被识别。
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
    "game_started", "set_ready", "ready_to_start", "start_multi", "open_game",
    "room_start", "start_countdown", "countdown", "start_the_game", "host_start",
]


def drain(ws, seconds=1.2):
    out = []
    end = time.time() + seconds
    while time.time() < end:
        t = ws.recv_text(0.5)
        if t:
            out.append(t)
    return out


def main():
    uuid = gr.game_uuid(ROM)
    tok_h = gr.login(*HOST)["token"]
    tok_j = gr.login(*JOIN)["token"]
    ws_h = gr.WS(gr.WS_H, gr.WS_P)
    ws_j = gr.WS(gr.WS_H, gr.WS_P)

    gr._send(ws_h, {"action": "send_message", "token": tok_h, "message": "go", "uuid": uuid}); time.sleep(1.2)
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": "act-%d" % int(time.time())})
    time.sleep(2.0)
    room = None
    for _ in range(8):
        t = ws_h.recv_text(1.0)
        if not t:
            continue
        try:
            o = json.loads(t)
        except Exception:
            continue
        room = room or o.get("room_id")
    print("room=%s" % room)
    if not room:
        return 1
    # 解散旧房、建新房的流程（先 join 再 leave）
    gr._send(ws_h, {"action": "join_room", "token": tok_h, "room_id": room}); time.sleep(1.0)
    gr._send(ws_h, {"action": "leave_room", "token": tok_h}); time.sleep(1.2)
    drain(ws_h, 1.0)
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": "act-%d" % int(time.time())})
    time.sleep(2.2)
    room = None
    for _ in range(8):
        t = ws_h.recv_text(1.0)
        if not t:
            continue
        try:
            o = json.loads(t)
        except Exception:
            continue
        room = room or o.get("room_id")
    print("新 room=%s" % room)

    gr._send(ws_h, {"action": "join_room", "token": tok_h, "room_id": room}); time.sleep(1.0)
    gr._send(ws_h, {"action": "ready", "token": tok_h}); time.sleep(1.0)
    gr._send(ws_h, {"action": "update_room_settings", "token": tok_h, "room_id": room,
                    "multi_game": 1, "is_udp": 1, "sync_modes": 1, "game_speed": 100,
                    "network_buffer": 100}); time.sleep(1.2)

    gr._send(ws_j, {"action": "send_message", "token": tok_j, "message": "go", "uuid": uuid}); time.sleep(0.8)
    gr._send(ws_j, {"action": "join_room", "token": tok_j, "room_id": room}); time.sleep(1.0)
    gr._send(ws_j, {"action": "ready", "token": tok_j}); time.sleep(1.5)
    drain(ws_h, 2.0)
    drain(ws_j, 1.5)

    print("\n== 房主逐个试动作 ==")
    for action in CANDIDATES:
        drain(ws_h, 0.8)
        gr._send(ws_h, {"action": action, "token": tok_h, "room_id": room})
        time.sleep(1.2)
        replies = drain(ws_h, 1.5)
        verdict = "(无回复)"
        for r in replies:
            try:
                o = json.loads(r)
            except Exception:
                verdict = r[:60]
                continue
            if o.get("error"):
                verdict = "❌ %s" % o.get("error")
            else:
                verdict = "✔ %s" % r[:130]
        print("  %-18s -> %s" % (action, verdict))

    ws_h.close()
    ws_j.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
