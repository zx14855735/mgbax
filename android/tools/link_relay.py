"""mGBA link relay. Both phones connect outbound, then this process pipes their link bytes.

    python tools/link_relay.py 8766

Protocol, one ASCII line each, then raw bytes:
    MGBA1 CREATE
    MGBA1 JOIN CODE
    MGBA1 ROOM CODE HOST|GUEST
    MGBA1 PEER
    MGBA1 ERR NO_ROOM|FULL|TIMEOUT|BAD
"""
import socket
import threading

ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"
ROOMS = {}
LOCK = threading.Lock()


def read_line(conn):
    buf = bytearray()
    while len(buf) < 96:
        b = conn.recv(1)
        if not b:
            return None
        if b == b"\n":
            return buf.decode("ascii", "replace").strip()
        if b != b"\r":
            buf.extend(b)
    return None


def write_line(conn, text):
    conn.sendall((text + "\n").encode("ascii"))


def splice(left, right):
    def pump(src, dst):
        try:
            while True:
                data = src.recv(8192)
                if not data:
                    break
                dst.sendall(data)
        except OSError:
            pass
        try:
            dst.shutdown(socket.SHUT_WR)
        except OSError:
            pass

    a = threading.Thread(target=pump, args=(left, right), daemon=True)
    b = threading.Thread(target=pump, args=(right, left), daemon=True)
    a.start()
    b.start()
    a.join()
    b.join()


def new_code():
    import random
    return "".join(random.choice(ALPHABET) for _ in range(6))


def handle(conn):
    try:
        line = read_line(conn)
        if line == "MGBA1 CREATE":
            host(conn)
        elif line and line.startswith("MGBA1 JOIN "):
            guest(conn, line[len("MGBA1 JOIN "):].strip().upper())
        else:
            write_line(conn, "MGBA1 ERR BAD")
            conn.close()
    except OSError:
        try:
            conn.close()
        except OSError:
            pass


def host(conn):
    code = new_code()
    arrived = threading.Event()
    room = {"host": conn, "guest": None, "arrived": arrived}
    with LOCK:
        ROOMS[code] = room
    try:
        write_line(conn, "MGBA1 ROOM %s HOST" % code)
        if not arrived.wait(15 * 60):
            write_line(conn, "MGBA1 ERR TIMEOUT")
            return
        guest_conn = room["guest"]
        write_line(conn, "MGBA1 PEER")
        write_line(guest_conn, "MGBA1 PEER")
        splice(conn, guest_conn)
    finally:
        with LOCK:
            ROOMS.pop(code, None)
        for sock in (conn, room.get("guest")):
            if sock is not None:
                try:
                    sock.close()
                except OSError:
                    pass


def guest(conn, code):
    with LOCK:
        room = ROOMS.get(code)
        if room is None:
            write_line(conn, "MGBA1 ERR NO_ROOM")
            conn.close()
            return
        if room["guest"] is not None:
            write_line(conn, "MGBA1 ERR FULL")
            conn.close()
            return
        room["guest"] = conn
    write_line(conn, "MGBA1 ROOM %s GUEST" % code)
    room["arrived"].set()


def main():
    import sys
    port = int(sys.argv[1]) if len(sys.argv) > 1 else 8766
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server.bind(("0.0.0.0", port))
    server.listen(16)
    print("link relay on 0.0.0.0:%d" % port)
    while True:
        conn, _addr = server.accept()
        conn.setsockopt(socket.IPPROTO_TCP, socket.TCP_NODELAY, 1)
        threading.Thread(target=handle, args=(conn,), daemon=True).start()


if __name__ == "__main__":
    main()
