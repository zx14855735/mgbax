"""Threaded action scanner for https://gboy.top/api/api.php (JSON body {action:...})."""
import socket, ssl, json, sys, queue, threading, time, os

HOST = 'gboy.top'
lock = threading.Lock()
BAD = '\u9519\u8bef\u3002'   # "错误。"


class Conn:
    def __init__(self, timeout=8):
        ctx = ssl.create_default_context(); ctx.check_hostname = False; ctx.verify_mode = ssl.CERT_NONE
        self.s = ctx.wrap_socket(socket.create_connection((HOST, 443), timeout), server_hostname=HOST)
        self.s.settimeout(timeout)
        self.buf = b''

    def _more(self):
        d = self.s.recv(65536)
        if not d:
            raise IOError('closed')
        self.buf += d

    def post(self, path, body: bytes):
        hdr = (f"POST {path} HTTP/1.1\r\nHost: {HOST}\r\nUser-Agent: okhttp/3.12.0\r\n"
               f"Content-Type: application/json\r\nContent-Length: {len(body)}\r\n"
               f"Connection: keep-alive\r\n\r\n").encode()
        self.s.sendall(hdr + body)
        while b'\r\n\r\n' not in self.buf:
            self._more()
        head, _, self.buf = self.buf.partition(b'\r\n\r\n')
        h = head.decode('latin1').lower()
        chunked = 'chunked' in h
        clen = 0
        for ln in h.split('\r\n'):
            if ln.startswith('content-length:'):
                clen = int(ln.split(':')[1])
        if chunked:
            out = b''
            while True:
                while b'\r\n' not in self.buf:
                    self._more()
                line, _, self.buf = self.buf.partition(b'\r\n')
                n = int(line.split(b';')[0], 16)
                if n == 0:
                    break
                while len(self.buf) < n + 2:
                    self._more()
                out += self.buf[:n]
                self.buf = self.buf[n + 2:]
            return out
        while len(self.buf) < clen:
            self._more()
        out, self.buf = self.buf[:clen], self.buf[clen:]
        return out

    def close(self):
        try: self.s.close()
        except Exception: pass


def worker(q, out, stats):
    c = None
    while True:
        try:
            a = q.get_nowait()
        except queue.Empty:
            return
        rep = None
        for attempt in range(2):
            try:
                if c is None:
                    c = Conn()
                rep = c.post('/api/api.php', json.dumps({'action': a}).encode()).decode('utf-8', 'replace')
                break
            except Exception:
                try: c.close()
                except Exception: pass
                c = None
        with lock:
            stats[0] += 1
            if rep and BAD not in rep:
                line = rep.strip().splitlines()[-1][:200]
                print(f'HIT {a:28s} {line}', flush=True)
                out.write(f'{a}\t{line}\n'); out.flush()


if __name__ == '__main__':
    cands = [l.strip() for l in open(sys.argv[1], encoding='utf-8') if l.strip()]
    if not os.path.exists('api_actions.txt'):
        open('api_actions.txt', 'w').close()
    out = open('api_actions.txt', 'a', encoding='utf-8')
    q = queue.Queue()
    for c in cands:
        q.put(c)
    stats = [0]
    n = int(sys.argv[2]) if len(sys.argv) > 2 else 8
    ths = [threading.Thread(target=worker, args=(q, out, stats), daemon=True) for _ in range(n)]
    t0 = time.time()
    for t in ths: t.start()
    for t in ths: t.join()
    print(f'scanned {stats[0]} in {time.time()-t0:.0f}s', flush=True)
