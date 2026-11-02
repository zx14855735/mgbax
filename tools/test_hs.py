#!/usr/bin/env python3
import sys, os, time, threading
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gboy_room as gr
import kcp_relay_test as kt

EMAIL = "zx14855734@gmail.com"
PASS = "14855735"
ROM = r"D:/gen8/rom.gba"

print("== 旧流程：建房(WS 随后关闭) + 单客户端连 KCP 测 HS/HK ==")
rid, addr, port = kt.create_node(EMAIL, PASS, ROM, "hs-diag")
print("room", rid, "node", addr, port)
if not addr or port <= 0:
    print("无节点"); sys.exit(1)

conv = 123456
ch = kt.connect(addr, port, conv)
print("HS/HK 结果: handshakeDone =", ch.handshakeDone.is_set())
print("rx_count =", ch.rx_count)
ch.close()

print("\n== 新流程A：建房后 WS 保持打开(完全空闲, 不收发) + 单客户端连 KCP ==")
wsH, rid2, addr2, port2, tok2 = kt.host_signal(EMAIL, PASS, ROM, "hs-diag2")
print("room", rid2, "node", addr2, port2)
try:
    ch2 = kt.connect(addr2, port2, 654321)
    print("HS/HK 结果(WS开-空闲): handshakeDone =", ch2.handshakeDone.is_set(), "rx=", ch2.rx_count)
    ch2.close()
except Exception as e:
    print("HS 失败(WS开-空闲):", e)
wsH.close()

print("\n== 新流程B：建房后 WS 保持打开(仅 recv 应答 ping) + 单客户端连 KCP ==")
wsH, rid3, addr3, port3, tok3 = kt.host_signal(EMAIL, PASS, ROM, "hs-diag3")
print("room", rid3, "node", addr3, port3)
stop = threading.Event()
threading.Thread(target=kt.ws_keepalive, args=(wsH, stop), daemon=True).start()
try:
    ch3 = kt.connect(addr3, port3, 654321)
    print("HS/HK 结果(WS开-recv): handshakeDone =", ch3.handshakeDone.is_set(), "rx=", ch3.rx_count)
    ch3.close()
except Exception as e:
    print("HS 失败(WS开-recv):", e)
stop.set(); wsH.close()
