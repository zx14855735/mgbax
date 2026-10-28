"""MGBA1 联机大厅中转服务器（与 Android 端 RemoteLink.RelayHub 协议完全兼容）。

协议：
  客户端 -> 服务器： "MGBA1 CREATE\\n"  /  "MGBA1 JOIN <code>\\n"
  服务器 -> 客户端： "MGBA1 ROOM <code> HOST\\n" / "MGBA1 ROOM <code> GUEST\\n"
                     / "MGBA1 PEER\\n" / "MGBA1 ERR <NO_ROOM|FULL|TIMEOUT|BAD>\\n"
  双方各收到**恰好一条** "MGBA1 PEER" 后，连接转为原始字节流双向镜像
  （NetLink 的 16 字节小包，非换行分隔），此后不再有任何控制行。

用法：
  python relay.py [port]        # 默认 8766
"""
import socket
import sys
import threading

PORT = 8766
ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"
PAIR_TIMEOUT = 900  # 15 分钟，与客户端一致

rooms = {}
rooms_lock = threading.Lock()


def make_code():
    import random
    while True:
        code = ''.join(ALPHABET[random.randrange(len(ALPHABET))] for _ in range(6))
        with rooms_lock:
            if code not in rooms:
                return code


def read_line(sock, buf):
    """从 buf 里取一行（到 \\n 为止）。返回 (line_str|None, new_buf)。"""
    idx = buf.find(b'\n')
    if idx < 0:
        return None, buf
    line = buf[:idx]
    if line.endswith(b'\r'):
        line = line[:-1]
    return line.decode('ascii', 'replace').strip(), buf[idx + 1:]


def pump(src, dst):
    """src -> dst 裸字节镜像。阻塞式 recv，不会因空闲超时误断。"""
    try:
        while True:
            data = src.recv(65536)
            if not data:
                break
            dst.sendall(data)
    except Exception:
        pass
    finally:
        try:
            dst.shutdown(socket.SHUT_WR)
        except Exception:
            pass


def pair(room, code):
    """双方到齐后：各发一条 PEER，然后双向镜像。"""
    host, guest = room["host"], room["guest"]
    try:
        for s in (host, guest):
            try:
                s.settimeout(None)
                s.sendall(b"MGBA1 PEER\n")
            except Exception:
                room["done"].set()
                return
        print("[relay] room %s paired, splicing" % code, flush=True)
        t1 = threading.Thread(target=pump, args=(host, guest), daemon=True)
        t2 = threading.Thread(target=pump, args=(guest, host), daemon=True)
        t1.start()
        t2.start()
        t1.join()
        t2.join()
    finally:
        with rooms_lock:
            rooms.pop(code, None)
        room["done"].set()
        print("[relay] room %s closed" % code, flush=True)


def handle(conn, addr):
    conn.settimeout(60)
    buf = b''
    code = None
    room = None
    try:
        line, buf = read_line(conn, buf)
        while line is None:
            data = conn.recv(4096)
            if not data:
                return
            buf += data
            line, buf = read_line(conn, buf)

        if line == "MGBA1 CREATE":
            code = make_code()
            room = {"host": conn, "guest": None,
                    "guest_arrived": threading.Event(),
                    "done": threading.Event(),
                    "lock": threading.Lock(),
                    "started": False}
            with rooms_lock:
                rooms[code] = room
            conn.sendall(("MGBA1 ROOM %s HOST\n" % code).encode())
            print("[relay] room %s created by %s" % (code, addr[0]), flush=True)

            if not room["guest_arrived"].wait(PAIR_TIMEOUT):
                conn.sendall(b"MGBA1 ERR TIMEOUT\n")
                with rooms_lock:
                    rooms.pop(code, None)
                return
            room["done"].wait(PAIR_TIMEOUT + 60)

        elif line.startswith("MGBA1 JOIN "):
            code = line[len("MGBA1 JOIN "):].strip().upper()
            with rooms_lock:
                room = rooms.get(code)
            if room is None:
                conn.sendall(b"MGBA1 ERR NO_ROOM\n")
                return
            with room["lock"]:
                if room["guest"] is not None:
                    conn.sendall(b"MGBA1 ERR FULL\n")
                    return
                room["guest"] = conn
            conn.sendall(("MGBA1 ROOM %s GUEST\n" % code).encode())
            print("[relay] room %s guest joined from %s" % (code, addr[0]), flush=True)
            room["guest_arrived"].set()

            with room["lock"]:
                if not room["started"]:
                    room["started"] = True
                    threading.Thread(target=pair, args=(room, code), daemon=True).start()
            room["done"].wait(PAIR_TIMEOUT + 60)

        else:
            conn.sendall(b"MGBA1 ERR BAD\n")
    except Exception as e:
        print("[relay] handle error (%s): %r" % (code, e), flush=True)
    finally:
        try:
            conn.close()
        except Exception:
            pass


def main():
    port = PORT
    if len(sys.argv) > 1:
        port = int(sys.argv[1])
    srv = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    srv.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    srv.bind(("0.0.0.0", port))
    srv.listen(16)
    print("[relay] listening on 0.0.0.0:%d" % port, flush=True)
    while True:
        try:
            conn, addr = srv.accept()
        except Exception:
            break
        threading.Thread(target=handle, args=(conn, addr), daemon=True).start()


if __name__ == "__main__":
    main()
