"""对指定房间/节点做双端 KCP 握手验证（房间需已由双方 WS 注册）。

用法: python probe_node_handshake.py <room_id> <address> <port>
"""
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


def main():
    room_id = sys.argv[1]
    addr = sys.argv[2]
    port = int(sys.argv[3])
    uuid = gr.game_uuid(ROM)
    tok_h = gr.login(*HOST)["token"]
    tok_j = gr.login(*JOIN)["token"]
    ws_h = gr.WS(gr.WS_H, gr.WS_P)
    ws_j = gr.WS(gr.WS_H, gr.WS_P)

    # 双方都进房并 ready
    for ws, tok in ((ws_h, tok_h), (ws_j, tok_j)):
        gr._send(ws, {"action": "send_message", "token": tok, "message": "go", "uuid": uuid}); time.sleep(0.8)
        gr._send(ws, {"action": "join_room", "token": tok, "room_id": room_id}); time.sleep(1.0)
        gr._send(ws, {"action": "ready", "token": tok}); time.sleep(0.8)
    print("双方已进房 room=%s node=%s:%d" % (room_id, addr, port))

    state = {}

    def client(tag, conv, delay):
        time.sleep(delay)
        ch = kt.KcpChannel(addr, port, conv)
        time.sleep(0.2)
        try:
            local = ch.sock.getsockname()[1]
        except Exception:
            local = -1
        print("  [%s] 本地端口 %s，发送 HS" % (tag, local))
        end = time.time() + 40
        tries = 0
        while time.time() < end:
            ch._raw_send(kt.HS)
            tries += 1
            for _ in range(30):
                if ch.handshakeDone.is_set():
                    state[tag] = "握手成功（第%d次HS，%.1fs）" % (tries, 40 - (end - time.time()))
                    print("  [%s] ✔ HK 收到！" % tag)
                    return
                time.sleep(0.1)
            if tries % 5 == 0:
                print("  [%s] HS 第%d次仍无回应 (rx=%d)" % (tag, tries, ch.rx_count))
        state[tag] = "40s 无回应"
        state[tag + "_chan"] = ch

    ta = threading.Thread(target=client, args=("房主", 888000001, 0), daemon=True)
    tb = threading.Thread(target=client, args=("加入", 888000002, 4), daemon=True)
    ta.start(); tb.start()
    ta.join(45); tb.join(45)
    print("结果:", {k: v for k, v in state.items() if not k.endswith("_chan")})
    for key in list(state):
        if key.endswith("_chan"):
            state[key].close()
    ws_h.close(); ws_j.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
