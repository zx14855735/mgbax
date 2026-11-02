"""抓取 gboy.top 在「加入方」侧真正下发的消息，看中继节点是怎么送达的。"""
import json
import os
import sys
import threading
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gboy_room as gr

ROM = r"D:/gen8/rom.gba"
HOST = ("zx14855734@gmail.com", "14855735")
JOIN = ("525612743@qq.com", "14855735")


def login(email, pw):
    r = gr.login(email, pw)
    if not r.get("success"):
        raise SystemExit("login failed %s: %s" % (email, r))
    return r["token"]


def main():
    uuid = gr.game_uuid(ROM)
    tok_h = login(*HOST)
    tok_j = login(*JOIN)
    ws_h = gr.WS(gr.WS_H, gr.WS_P)
    ws_j = gr.WS(gr.WS_H, gr.WS_P)

    # ---- 房主：建房 -> 进房 -> ready -> 多人设置 ----
    gr._send(ws_h, {"action": "leave_room", "token": tok_h}); time.sleep(1.0)
    gr._send(ws_h, {"action": "send_message", "token": tok_h, "message": "go", "uuid": uuid}); time.sleep(1.0)
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": "probe-join-%d" % int(time.time())})
    room_id = None
    deadline = time.time() + 8
    while time.time() < deadline and not room_id:
        t = ws_h.recv_text(1.2)
        if t:
            try:
                o = json.loads(t)
            except Exception:
                continue
            if o.get("type") == "create_game_room" or o.get("room_id"):
                room_id = o.get("room_id")
                print("[host] create ->", json.dumps(o, ensure_ascii=False)[:300])
    print("[host] room_id =", room_id)
    if not room_id:
        return 1
    gr._send(ws_h, {"action": "join_room", "token": tok_h, "room_id": room_id}); time.sleep(1.2)
    gr._send(ws_h, {"action": "ready", "token": tok_h}); time.sleep(1.2)
    gr._send(ws_h, {"action": "update_room_settings", "token": tok_h, "room_id": room_id,
                    "multi_game": 1, "is_udp": 1, "sync_modes": 1, "game_speed": 100,
                    "network_buffer": 100}); time.sleep(1.5)
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": "probe-join-%d" % int(time.time())})
    node = None
    deadline = time.time() + 10
    while time.time() < deadline and not node:
        t = ws_h.recv_text(1.2)
        if t:
            print("[host] <<", t[:260])
            try:
                o = json.loads(t)
            except Exception:
                continue
            if o.get("node_address") and o.get("node_port"):
                node = (o["node_address"], int(o["node_port"]))
    print("[host] NODE =", node)

    # ---- 加入方：进房后，把服务器推给它的所有消息全部打印 ----
    def joiner():
        gr._send(ws_j, {"action": "send_message", "token": tok_j, "message": "go", "uuid": uuid})
        time.sleep(1.0)
        gr._send(ws_j, {"action": "join_room", "token": tok_j, "room_id": room_id})
        time.sleep(1.5)
        gr._send(ws_j, {"action": "ready", "token": tok_j})
        end = time.time() + 18
        while time.time() < end:
            t = ws_j.recv_text(1.2)
            if t:
                print("[join] <<", t[:400])

    t = threading.Thread(target=joiner, daemon=True)
    t.start()
    t.join(20)

    # ---- 房主再广播一次我自己的标记，看加入方能否收到 ----
    if node:
        marker = json.dumps({"gboy_node": "%s:%d" % node, "room": room_id}, ensure_ascii=False)
        gr._send(ws_h, {"action": "send_message", "token": tok_h, "message": marker, "uuid": uuid})
        print("[host] broadcast marker:", marker)
        time.sleep(4)

    ws_h.close()
    ws_j.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
