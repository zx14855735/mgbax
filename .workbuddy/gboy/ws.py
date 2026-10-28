"""Minimal WebSocket client (RFC6455) over TLS, no deps."""
import socket, ssl, os, base64, struct, hashlib, json, time


class WS:
    def __init__(self, host='gboy.top', port=23459, path='/', timeout=8, headers=None):
        self.host, self.port, self.path = host, port, path
        ctx = ssl.create_default_context()
        ctx.check_hostname = False
        ctx.verify_mode = ssl.CERT_NONE
        s = socket.create_connection((host, port), timeout)
        self.sock = ctx.wrap_socket(s, server_hostname=host)
        self.sock.settimeout(timeout)
        self.buf = b''
        key = base64.b64encode(os.urandom(16)).decode()
        req = (f"GET {path} HTTP/1.1\r\nHost: {host}:{port}\r\n"
               f"Upgrade: websocket\r\nConnection: Upgrade\r\n"
               f"Sec-WebSocket-Key: {key}\r\nSec-WebSocket-Version: 13\r\n")
        for k, v in (headers or {}).items():
            req += f"{k}: {v}\r\n"
        req += "\r\n"
        self.sock.sendall(req.encode())
        # read handshake response
        while b'\r\n\r\n' not in self.buf:
            b = self.sock.recv(4096)
            if not b:
                raise IOError('closed during handshake: %r' % self.buf)
            self.buf += b
        head, _, self.buf = self.buf.partition(b'\r\n\r\n')
        self.handshake = head.decode('latin1')
        if '101' not in self.handshake.split('\r\n')[0]:
            raise IOError('handshake failed: %s' % self.handshake)

    # ---- framing ----
    def send(self, data, opcode=1):
        if isinstance(data, str):
            data = data.encode()
        hdr = bytes([0x80 | opcode])
        n = len(data)
        mask = os.urandom(4)
        if n < 126:
            hdr += bytes([0x80 | n])
        elif n < 65536:
            hdr += bytes([0x80 | 126]) + struct.pack('>H', n)
        else:
            hdr += bytes([0x80 | 127]) + struct.pack('>Q', n)
        hdr += mask
        payload = bytes(b ^ mask[i % 4] for i, b in enumerate(data))
        self.sock.sendall(hdr + payload)

    def _need(self, n):
        while len(self.buf) < n:
            b = self.sock.recv(65536)
            if not b:
                raise IOError('closed')
            self.buf += b

    def recv(self, timeout=None):
        """return (opcode, payload) or None on timeout"""
        if timeout is not None:
            self.sock.settimeout(timeout)
        try:
            self._need(2)
            b0, b1 = self.buf[0], self.buf[1]
            op = b0 & 0x0f
            ln = b1 & 0x7f
            off = 2
            if ln == 126:
                self._need(4)
                ln = struct.unpack('>H', self.buf[2:4])[0]
                off = 4
            elif ln == 127:
                self._need(10)
                ln = struct.unpack('>Q', self.buf[2:10])[0]
                off = 10
            self._need(off + ln)
            payload = self.buf[off:off + ln]
            self.buf = self.buf[off + ln:]
            return op, payload
        except socket.timeout:
            return None

    def close(self):
        try:
            self.send(b'', opcode=8)
            self.sock.close()
        except Exception:
            pass


def fmt(op, p):
    names = {1: 'TEXT', 2: 'BIN', 8: 'CLOSE', 9: 'PING', 10: 'PONG'}
    s = names.get(op, str(op))
    try:
        txt = p.decode('utf-8')
        if txt.isprintable():
            return f'{s} "{txt[:400]}"'
    except Exception:
        pass
    return f'{s} hex={p[:80].hex()} len={len(p)}'


if __name__ == '__main__':
    import sys
    w = WS(path=sys.argv[1] if len(sys.argv) > 1 else '/')
    print('handshake ok')
    time.sleep(0.5)
    r = w.recv(2)
    print('greeting:', fmt(*r) if r else 'none')
    w.close()
