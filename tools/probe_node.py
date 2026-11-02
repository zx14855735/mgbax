#!/usr/bin/env python3
# 探测 gboy.top：加入方能否自动拿到中继节点（无需手动 NODE2）
# 测试两条路：
#   1) 房主 send_message 广播，加入方能否收到（房间聊天通道）
#   2) 加入方发 get_room_info / room_info / get_room / query_room / room_detail /
#      get_room_settings 等候选 action，服务器是否回带 node_address/node_port
import sys, os, json, ssl, time, socket, base64, struct, urllib.request, urllib.error, threading

API  = "https://gboy.top/api/api.php"
WS_H = "gboy.top"; WS_P = 23459
CTX = ssl.create_default_context(); CTX.check_hostname = False; CTX.verify_mode = ssl.CERT_NONE

def _post(body):
    data = json.dumps(body).encode()
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

def login(email, pw): return _post({"action":"login","email_or_username":email,"password":pw})

def game_uuid(rom):
    if not rom or not os.path.isfile(rom): return "BPEE,"
    with open(rom,"rb") as f:
        head=f.read(0xB0); f.seek(0); md=__import__("hashlib").md5(); md.update(f.read())
    digest=md.hexdigest()
    code="".join(chr(b) if 0x20<=b<0x7F else "0" for b in head[0xAC:0xB0])
    if len(code)!=4: code="BPEE"
    return f"{code},{digest}"

class WS:
    def __init__(self, host, port):
        raw=socket.create_connection((host,port),timeout=15)
        self.s=CTX.wrap_socket(raw,server_hostname=host)
        key=base64.b64encode(os.urandom(16)).decode()
        hs=("GET / HTTP/1.1\r\nHost: %s:%d\r\nUpgrade: websocket\r\nConnection: Upgrade\r\n"
            "Sec-WebSocket-Key: %s\r\nSec-WebSocket-Version: 13\r\n\r\n"%(host,port,key))
        self.s.sendall(hs.encode()); buf=b""
        while b"\r\n\r\n" not in buf: buf+=self.s.recv(1)
        if "101" not in buf.split(b"\r\n")[0].decode("latin1","replace"):
            raise IOError("WS握手失败")
        self.buf=b""
    def send_text(self,text):
        p=text.encode(); mask=os.urandom(4)
        m=bytes(p[i]^mask[i%4] for i in range(len(p)))
        hdr=bytearray([0x81]); L=len(p)
        if L<126: hdr.append(0x80|L)
        elif L<65536: hdr.append(0x80|126); hdr+=struct.pack(">H",L)
        else: hdr.append(0x80|127); hdr+=struct.pack(">Q",L)
        self.s.sendall(bytes(hdr)+mask+m)
    def recv_text(self,timeout=1.5):
        self.s.settimeout(timeout)
        try:
            while True:
                msg=self._parse()
                if msg is not None: return msg
        except socket.timeout: return None
    def _parse(self):
        while len(self.buf)<2:
            d=self.s.recv(4096)
            if not d: return None
            self.buf+=d
        b0,b1=self.buf[0],self.buf[1]; op=b0&0xF; masked=(b1&0x80)!=0; L=b1&0x7F; off=2
        if L==126:
            while len(self.buf)<off+2: self.buf+=self.s.recv(4096)
            L=struct.unpack(">H",self.buf[off:off+2])[0]; off+=2
        elif L==127:
            while len(self.buf)<off+8: self.buf+=self.s.recv(4096)
            L=struct.unpack(">Q",self.buf[off:off+8])[0]; off+=8
        if masked:
            while len(self.buf)<off+4: self.buf+=self.s.recv(4096)
            mask=self.buf[off:off+4]; off+=4
        while len(self.buf)<off+L: self.buf+=self.s.recv(4096)
        data=self.buf[off:off+L]
        if masked: data=bytes(data[i]^mask[i%4] for i in range(L))
        self.buf=self.buf[off+L:]
        if op==0x8: return None
        if op in (0x9,0xA): return self._parse()
        return data.decode("utf-8","replace")
    def close(self):
        try: self.s.close()
        except Exception: pass

def send(ws,obj): ws.send_text(json.dumps(obj,ensure_ascii=False))
def uid(token): return token  # placeholder

state = {"room_id":None, "host_node":None, "done":threading.Event()}
ROOM_NAME="probe-auto-node"

def host_thread(rom):
    r=login("zx14855734@gmail.com","14855735")
    if not r.get("success"): print("HOST login fail",r); return
    token=r["token"]; ws=WS(WS_H,WS_P)
    try:
        send(ws,{"action":"send_message","token":token,"message":"go","uuid":game_uuid(rom)}); time.sleep(1.2)
        send(ws,{"action":"leave_room","token":token}); time.sleep(1.2)
        send(ws,{"action":"create_game_room","token":token,"room_name":ROOM_NAME}); time.sleep(2.5)
        rid=None
        for _ in range(8):
            t=ws.recv_text(1.3)
            if t and '"room_id"' in t:
                try:
                    rid=json.loads(t).get("room_id"); 
                    if rid: break
                except: pass
        if not rid: print("HOST no room"); return
        state["room_id"]=rid
        print("HOST room_id =",rid)
        send(ws,{"action":"join_room","token":token,"room_id":rid}); time.sleep(1.5)
        send(ws,{"action":"ready","token":token}); time.sleep(1.2)
        send(ws,{"action":"update_room_settings","token":token,"room_id":rid,
                 "multi_game":1,"is_udp":1,"sync_modes":1,"game_speed":100,"network_buffer":100}); time.sleep(1.5)
        # final create to grab node
        send(ws,{"action":"create_game_room","token":token,"room_name":ROOM_NAME}); time.sleep(2.5)
        node=None
        for _ in range(12):
            t=ws.recv_text(1.5)
            print("  HOST<<",t)
            if t and "node_address" in t:
                try:
                    o=json.loads(t); node=(o.get("node_address"),o.get("node_port"))
                except: pass
        if node: state["host_node"]=node; print("HOST node =",node)
        # 测试广播：把节点作为消息发到房间
        time.sleep(3)  # 等加入方就绪
        send(ws,{"action":"send_message","token":token,"message":"NODE:"+json.dumps({"a":node[0],"p":node[1]}),"uuid":game_uuid(rom)})
        time.sleep(6)
    finally:
        ws.close(); state["done"].set()

def join_thread(rom):
    # 等房主建好
    for _ in range(60):
        if state["room_id"]: break
        time.sleep(0.5)
    rid=state["room_id"]
    if not rid: print("JOIN no room"); return
    r=login("525612743@qq.com","14855735")
    if not r.get("success"): print("JOIN login fail",r); return
    token=r["token"]; ws=WS(WS_H,WS_P)
    try:
        send(ws,{"action":"send_message","token":token,"message":"go","uuid":game_uuid(rom)}); time.sleep(1.2)
        send(ws,{"action":"join_room","token":token,"room_id":rid}); time.sleep(1.8)
        send(ws,{"action":"ready","token":token}); time.sleep(1.2)
        print("JOIN listening for broadcasts (host send_message) ...")
        for _ in range(8):
            t=ws.recv_text(1.5)
            print("  JOIN<<(bc)",t)
        # 探测候选 info actions
        candidates=["get_room_info","room_info","get_room","query_room","room_detail",
                    "get_room_detail","get_room_settings","room_state","get_room_state","get_node"]
        for c in candidates:
            send(ws,{"action":c,"token":token,"room_id":rid})
            for _ in range(3):
                t=ws.recv_text(1.2)
                print(f"  JOIN<<[{c}]",t)
                if t and "node_address" in t:
                    print("  >>> NODE FOUND via",c)
    finally:
        ws.close()

if __name__=="__main__":
    rom=r"D:/gen8/rom.gba"
    th=threading.Thread(target=host_thread,args=(rom,),daemon=True); th.start()
    time.sleep(2)
    jt=threading.Thread(target=join_thread,args=(rom,),daemon=True); jt.start()
    th.join(); jt.join()
    print("DONE. host_node=",state["host_node"],"room=",state["room_id"])
