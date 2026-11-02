#!/usr/bin/env python3
# 验证「房主自动广播中继 + 加入方自动解析」端到端可用（完全对应要写入 APK 的逻辑）
import sys, os, json, ssl, time, socket, base64, struct, urllib.request, urllib.error, threading

API="https://gboy.top/api/api.php"; WS_H="gboy.top"; WS_P=23459
CTX=ssl.create_default_context(); CTX.check_hostname=False; CTX.verify_mode=ssl.CERT_NONE

def _post(b):
    data=json.dumps(b).encode()
    req=urllib.request.Request(API,data=data,headers={"Content-Type":"application/json"})
    try:
        with urllib.request.urlopen(req,context=CTX,timeout=15) as r: raw=r.read().decode("utf-8","replace")
    except urllib.error.HTTPError as e: raw=e.read().decode("utf-8","replace")
    for line in reversed(raw.splitlines()):
        line=line.strip()
        if line.startswith("{"):
            try: return json.loads(line)
            except: pass
    return {"_raw":raw}
def login(e,p): return _post({"action":"login","email_or_username":e,"password":p})
def game_uuid(rom):
    if not rom or not os.path.isfile(rom): return "BPEE,"
    with open(rom,"rb") as f:
        head=f.read(0xB0); f.seek(0); import hashlib; md=hashlib.md5(); md.update(f.read())
    code="".join(chr(b) if 0x20<=b<0x7F else "0" for b in head[0xAC:0xB0])
    return (code if len(code)==4 else "BPEE")+","+md.hexdigest()

class WS:
    def __init__(s,host,port):
        raw=socket.create_connection((host,port),timeout=15); s.s=CTX.wrap_socket(raw,server_hostname=host)
        key=base64.b64encode(os.urandom(16)).decode()
        s.s.sendall(("GET / HTTP/1.1\r\nHost: %s:%d\r\nUpgrade: websocket\r\nConnection: Upgrade\r\nSec-WebSocket-Key: %s\r\nSec-WebSocket-Version: 13\r\n\r\n"%(host,port,key)).encode())
        buf=b""
        while b"\r\n\r\n" not in buf: buf+=s.s.recv(1)
        if "101" not in buf.split(b"\r\n")[0].decode("latin1","replace"): raise IOError("WS失败")
        s.buf=b""
    def send_text(s,text):
        p=text.encode(); m=os.urandom(4); mk=bytes(p[i]^m[i%4] for i in range(len(p)))
        h=bytearray([0x81]); L=len(p)
        if L<126: h.append(0x80|L)
        elif L<65536: h.append(0x80|126); h+=struct.pack(">H",L)
        else: h.append(0x80|127); h+=struct.pack(">Q",L)
        s.s.sendall(bytes(h)+m+mk)
    def recv_text(s,timeout=1.5):
        s.s.settimeout(timeout)
        try:
            while True:
                msg=s._parse()
                if msg is not None: return msg
        except socket.timeout: return None
    def _parse(s):
        while len(s.buf)<2:
            d=s.s.recv(4096)
            if not d: return None
            s.buf+=d
        b0,b1=s.buf[0],s.buf[1]; op=b0&0xF; masked=(b1&0x80)!=0; L=b1&0x7F; off=2
        if L==126:
            while len(s.buf)<off+2: s.buf+=s.s.recv(4096)
            L=struct.unpack(">H",s.buf[off:off+2])[0]; off+=2
        elif L==127:
            while len(s.buf)<off+8: s.buf+=s.s.recv(4096)
            L=struct.unpack(">Q",s.buf[off:off+8])[0]; off+=8
        if masked:
            while len(s.buf)<off+4: s.buf+=s.s.recv(4096)
            m=s.buf[off:off+4]; off+=4
        while len(s.buf)<off+L: s.buf+=s.s.recv(4096)
        data=s.buf[off:off+L]
        if masked: data=bytes(data[i]^m[i%4] for i in range(L))
        s.buf=s.buf[off+L:]
        if op==0x8: return None
        if op in (0x9,0xA): return s._parse()
        return data.decode("utf-8","replace")
    def close(s):
        try: s.s.close()
        except: pass

def send(ws,o): ws.send_text(json.dumps(o,ensure_ascii=False))

state={"room":None,"node":None,"done":threading.Event()}
ROM=r"D:/gen8/rom.gba"

def host():
    r=login("zx14855734@gmail.com","14855735")
    if not r.get("success"): print("HOST login fail",r); return
    tok=r["token"]; ws=WS(WS_H,WS_P)
    try:
        send(ws,{"action":"send_message","token":tok,"message":"go","uuid":game_uuid(ROM)}); time.sleep(1.2)
        send(ws,{"action":"leave_room","token":tok}); time.sleep(1.2)
        send(ws,{"action":"create_game_room","token":tok,"room_name":"auto-relay-test"}); time.sleep(2.5)
        rid=None
        for _ in range(8):
            t=ws.recv_text(1.3)
            if t and '"room_id"' in t:
                try:
                    rid=json.loads(t).get("room_id")
                    if rid: break
                except: pass
        if not rid: print("HOST no room"); return
        state["room"]=rid; print("HOST room=",rid)
        send(ws,{"action":"join_room","token":tok,"room_id":rid}); time.sleep(1.5)
        send(ws,{"action":"ready","token":tok}); time.sleep(1.2)
        send(ws,{"action":"update_room_settings","token":tok,"room_id":rid,"multi_game":1,"is_udp":1,"sync_modes":1,"game_speed":100,"network_buffer":100}); time.sleep(1.5)
        send(ws,{"action":"create_game_room","token":tok,"room_name":"auto-relay-test"}); time.sleep(2.5)
        node=None
        for _ in range(12):
            t=ws.recv_text(1.5)
            if t and "node_address" in t:
                try:
                    o=json.loads(t); node=(o.get("node_address"),o.get("node_port"))
                except: pass
        if not node: print("HOST no node"); return
        state["node"]=node; print("HOST node=",node)
        # ---- 对应 APK 的 NodeAdvertiser：循环广播 + 维持 WS 存活 ----
        uuid=game_uuid(ROM); marker={"gboy_node":"%s:%d"%node,"room":rid}; mjson=json.dumps(marker)
        last=0
        end=time.time()+14
        while time.time()<end:
            try: ws.recv_text(1.5)   # 维持存活（处理 ping）
            except: break
            now=time.time()
            if now-last>=2:
                last=now
                send(ws,{"action":"send_message","token":tok,"uuid":uuid,"message":mjson})
        print("HOST advertiser done")
    finally:
        ws.close(); state["done"].set()

def joiner():
    for _ in range(60):
        if state["room"] and state["node"]: break
        time.sleep(0.5)
    rid=state["room"]
    if not rid: print("JOIN no room"); return
    r=login("525612743@qq.com","14855735")
    if not r.get("success"): print("JOIN login fail",r); return
    tok=r["token"]; ws=WS(WS_H,WS_P)
    got=None
    try:
        send(ws,{"action":"send_message","token":tok,"message":"go","uuid":game_uuid(ROM)}); time.sleep(1.2)
        send(ws,{"action":"join_room","token":tok,"room_id":rid}); time.sleep(1.8)
        send(ws,{"action":"ready","token":tok}); time.sleep(1.2)
        # 对应 APK 的 waitForRoom：监听 12s，解析 send_message 的 gboy_node
        end=time.time()+12
        while time.time()<end:
            t=ws.recv_text(1.5)
            if not t: continue
            try: o=json.loads(t)
            except: continue
            if o.get("type")=="send_message":
                msg=o.get("message","")
                if "gboy_node" in msg:
                    try:
                        m=json.loads(msg)
                        n=m.get("gboy_node"); r2=m.get("room","")
                        if n and (not r2 or r2==rid):
                            a,p=n.rsplit(":",1); p=int(p)
                            if p>0: got=(a,p); break
                    except: pass
        print("JOIN got node =",got,"(expected",state["node"],")")
    finally:
        ws.close()
    if got and got==state["node"]:
        print("RESULT: PASS - 加入方自动拿到了与房主一致的中继节点")
    else:
        print("RESULT: FAIL - 未自动获取中继节点")

if __name__=="__main__":
    h=threading.Thread(target=host,daemon=True); h.start(); time.sleep(2)
    j=threading.Thread(target=joiner,daemon=True); j.start()
    h.join(50); j.join(50)
    print("DONE")
