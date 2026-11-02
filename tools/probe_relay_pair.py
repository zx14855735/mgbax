"""验证 gboy.top 中继节点是否必须两端都接入才回应 HS/HK。

步骤：
  1. 房主建房（拿节点），加入方进房（WS 注册）；
  2. 先只连房主一个客户端，等 12 秒看 HS 有没有回应；
  3. 再连加入方客户端，看两边的 HS 是否同时被回应。
"""
import os
import socket
import sys
import threading
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gboy_room as gr
import kcp_relay_test as kt

ROM = r"D:/gen8/rom.gba"
HOST = ("zx14855734@gmail.com", "14855735")
JOIN = ("525612743@qq.com", "14855735")


def main():
    uuid = gr.game_uuid(ROM)
    tok_h = gr.login(*HOST)["token"]
    tok_j = gr.login(*JOIN)["token"]
    ws_h = gr.WS(gr.WS_H, gr.WS_P)
    ws_j = gr.WS(gr.WS_H, gr.WS_P)

    gr._send(ws_h, {"action": "leave_room", "token": tok_h}); time.sleep(1.0)
    gr._send(ws_h, {"action": "send_message", "token": tok_h, "message": "go", "uuid": uuid}); time.sleep(1.0)
    name = "probe-two-%d" % int(time.time())
    gr._send(ws_h, {"action": "create_game_room", "token": tok_h, "room_name": name})
    room_id, node = None, None
    end = time.time() + 10
    while time.time() < end and not (room_id and node):
        t = ws_h.recv_text(1.2)
        if not t:
            continue
        try:
            o = gr.json.loads(t)
        except Exception:
            continue
        room_id = room_id or o.get("room_id")
        if o.get("node_address") and o.get("node_port"):
            node = (o["node_address"], int(o["node_port"]))
    print("room=%s node=%s" % (room_id, node))
    if not node:
        print("没拿到节点")
        return 1
    gr._send(ws_h, {"action": "join_room", "token": tok_h, "room_id": room_id}); time.sleep(1.0)
    gr._send(ws_h, {"action": "ready", "token": tok_h}); time.sleep(1.0)
    gr._send(ws_h, {"action": "update_room_settings", "token": tok_h, "room_id": room_id,
                    "multi_game": 1, "is_udp": 1, "sync_modes": 1, "game_speed": 100,
                    "network_buffer": 100}); time.sleep(1.0)

    # 加入方进房（WS 注册）
    gr._send(ws_j, {"action": "send_message", "token": tok_j, "message": "go", "uuid": uuid}); time.sleep(0.8)
    gr._send(ws_j, {"action": "join_room", "token": tok_j, "room_id": room_id}); time.sleep(1.0)
    gr._send(ws_j, {"action": "ready", "token": tok_j}); time.sleep(1.0)

    addr, port = node
    convA = 111000001
    convB = 222000002

    result = {}

    def only_host():
        """只连房主一个客户端，等 HS 回应。"""
        ch = kt.KcpChannel(addr, port, convA)
        time.sleep(0.2)
        try:
            ch.local_port = ch.sock.getsockname()[1]
        except Exception:
            pass
        ch._raw_send(kt.HS)
        end = time.time() + 12
        while time.time() < end:
            if ch.handshakeDone.is_set():
                result["A_hs"] = "有回应 t=%.1f" % (12 - (end - time.time()))
                break
            time.sleep(0.1)
        else:
            result["A_hs"] = "超时(12s内无回应)"
        result["A_chan"] = ch

    t = threading.Thread(target=only_host, daemon=True)
    t.start()
    t.join(15)
    print("① 只有房主接入时，房主 HS:", result.get("A_hs"))

    # 现在加入第二个客户端
    chB = None
    try:
        chB = kt.KcpChannel(addr, port, convB)
        time.sleep(0.2)
        chB._raw_send(kt.HS)
        end = time.time() + 10
        while time.time() < end:
            if chB.handshakeDone.is_set():
                result["B_hs"] = "有回应"
                break
            time.sleep(0.1)
        else:
            result["B_hs"] = "超时"
    except Exception as exc:
        result["B_hs"] = "异常 %s" % exc
    print("② 加入方接入后，加入方 HS:", result.get("B_hs"))

    chA = result.get("A_chan")
    if chA is not None:
        print("   此时房主端 handshakeDone =", chA.handshakeDone.is_set(),
              "（若变成 True 说明第二个客户端接入后，房主的旧会话被补上了回应）")
        chA.close()
    if chB is not None:
        chB.close()
    ws_h.close()
    ws_j.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
