"""relay.py 自检：不需要模拟器，用两个 Python 客户端验证 MGBA1 中继协议。

覆盖点：
  1. CREATE -> "MGBA1 ROOM <code> HOST"，JOIN -> "MGBA1 ROOM <code> GUEST"
  2. 双方各收到**恰好一条** "MGBA1 PEER"，不多不少（重复 PEER 会污染 SIO 字节流）
  3. A->B / B->A 双向裸字节镜像，内容逐字节一致
  4. 静默 2 秒后仍能继续传输（防"空闲即断"）
  5. 大块数据（64KB）完整无截断
  6. 连续 16 字节 SIO 小包顺序不乱
  7. 错误语义：NO_ROOM / FULL

用法： python relay_test.py [port]
"""
import os
import random
import socket
import subprocess
import sys
import threading
import time

HERE = os.path.dirname(os.path.abspath(__file__))
PORT = int(sys.argv[1]) if len(sys.argv) > 1 else 8776

results = []


def check(name, ok, detail=""):
    results.append((name, ok, detail))
    print("  %s %s%s" % ("PASS" if ok else "FAIL", name,
                         ("  <- " + detail) if detail and not ok else ""), flush=True)
    return ok


class Peer:
    def __init__(self, sock):
        self.s = sock
        self.buf = b''

    @staticmethod
    def connect(port=PORT, host='127.0.0.1'):
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.settimeout(10)
        s.connect((host, port))
        s.setsockopt(socket.IPPROTO_TCP, socket.TCP_NODELAY, 1)
        return Peer(s)

    def sendline(self, text):
        self.s.sendall((text + "\n").encode('ascii'))

    def readline(self, timeout=10):
        self.s.settimeout(timeout)
        while b'\n' not in self.buf:
            d = self.s.recv(1)
            if not d:
                raise EOFError("对端关闭（缓冲 %r）" % self.buf)
            self.buf += d
        i = self.buf.index(b'\n')
        line = self.buf[:i].rstrip(b'\r')
        self.buf = self.buf[i + 1:]
        return line.decode('ascii', 'replace')

    def send(self, data):
        self.s.sendall(data)

    def recv_exact(self, n, timeout=15):
        self.s.settimeout(timeout)
        while len(self.buf) < n:
            d = self.s.recv(65536)
            if not d:
                raise EOFError("对端关闭，只收到 %d/%d 字节" % (len(self.buf), n))
            self.buf += d
        out, self.buf = self.buf[:n], self.buf[n:]
        return out

    def pending(self):
        """查看是否还有多余字节（用来抓重复 PEER）。"""
        self.s.settimeout(0.6)
        try:
            d = self.s.recv(65536)
            self.buf += d
        except socket.timeout:
            pass
        return self.buf

    def close(self):
        try:
            self.s.close()
        except Exception:
            pass


def wait_port(port, timeout=10):
    end = time.time() + timeout
    while time.time() < end:
        try:
            s = socket.create_connection(('127.0.0.1', port), 0.5)
            s.close()
            return True
        except Exception:
            time.sleep(0.1)
    return False


def main():
    print("=== 启动 relay.py（端口 %d）===" % PORT, flush=True)
    proc = subprocess.Popen([sys.executable, os.path.join(HERE, 'relay.py'), str(PORT)],
                            stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    if not wait_port(PORT):
        print("relay.py 启动失败")
        proc.kill()
        return 1

    try:
        # ---------- 场景 1：配对 ----------
        print("\n=== 1. 配对 ===", flush=True)
        host = Peer.connect()
        host.sendline("MGBA1 CREATE")
        host_line = host.readline()
        check("CREATE 返回 ROOM ... HOST",
              host_line.startswith("MGBA1 ROOM ") and host_line.endswith(" HOST"), host_line)
        code = host_line[len("MGBA1 ROOM "):-len(" HOST")].strip()
        check("房间号为 6 位", len(code) == 6, code)

        guest = Peer.connect()
        guest.sendline("MGBA1 JOIN " + code)
        guest_line = guest.readline()
        check("JOIN 返回 ROOM ... GUEST",
              guest_line == "MGBA1 ROOM %s GUEST" % code, guest_line)

        got = {}

        def read_peer(p, k):
            try:
                got[k] = p.readline(10)
            except Exception as e:
                got[k] = "EXC:%r" % (e,)

        t1 = threading.Thread(target=read_peer, args=(host, 'host'))
        t2 = threading.Thread(target=read_peer, args=(guest, 'guest'))
        t1.start(); t2.start(); t1.join(12); t2.join(12)
        check("主机收到 PEER", got.get('host') == "MGBA1 PEER", str(got.get('host')))
        check("从机收到 PEER", got.get('guest') == "MGBA1 PEER", str(got.get('guest')))

        # ---------- 场景 2：双向字节 ----------
        print("\n=== 2. 双向裸字节 ===", flush=True)
        rnd = random.Random(20261029)

        p1 = bytes(rnd.randrange(256) for _ in range(16))
        host.send(p1)
        try:
            back = guest.recv_exact(len(p1))
        except Exception as e:
            back = b''
            check("host->guest 首个 16 字节包", False, repr(e))
        else:
            check("host->guest 首个 16 字节包", back == p1,
                  "got %r want %r" % (back, p1))

        p2 = bytes(rnd.randrange(256) for _ in range(16))
        guest.send(p2)
        try:
            back = host.recv_exact(len(p2))
        except Exception as e:
            check("guest->host 首个 16 字节包", False, repr(e))
        else:
            check("guest->host 首个 16 字节包", back == p2,
                  "got %r want %r" % (back, p2))

        # ---------- 场景 3：静默后继续 ----------
        print("\n=== 3. 静默 2 秒后继续 ===", flush=True)
        time.sleep(2.0)
        p3 = bytes(rnd.randrange(256) for _ in range(16))
        try:
            host.send(p3)
            back = guest.recv_exact(len(p3), timeout=5)
        except Exception as e:
            check("静默 2s 后仍可传输", False, repr(e))
        else:
            check("静默 2s 后仍可传输", back == p3, "got %r want %r" % (back, p3))

        # ---------- 场景 4：大块数据 ----------
        print("\n=== 4. 64KB 大块 ===", flush=True)
        big = bytes(rnd.randrange(256) for _ in range(65536))
        try:
            host.send(big)
            back = guest.recv_exact(len(big), timeout=20)
        except Exception as e:
            check("64KB host->guest", False, repr(e))
        else:
            check("64KB host->guest", back == big, "长度 %d/%d" % (len(back), len(big)))

        big2 = big[::-1]
        try:
            guest.send(big2)
            back = host.recv_exact(len(big2), timeout=20)
        except Exception as e:
            check("64KB guest->host", False, repr(e))
        else:
            check("64KB guest->host", back == big2, "长度 %d/%d" % (len(back), len(big2)))

        # ---------- 场景 5：连续小包保序 ----------
        print("\n=== 5. 连续 16 字节包保序 ===", flush=True)
        n = 200
        seq = [bytes([i & 0xff]) * 16 for i in range(n)]
        try:
            host.send(b''.join(seq))
            blob = guest.recv_exact(16 * n, timeout=20)
        except Exception as e:
            check("200 个 SIO 包保序", False, repr(e))
        else:
            ok = all(blob[i * 16:(i + 1) * 16] == seq[i] for i in range(n))
            check("200 个 SIO 包保序", ok)

        # ---------- 场景 6：出错语义 ----------
        print("\n=== 6. 错误语义 ===", flush=True)
        bad = Peer.connect()
        bad.sendline("MGBA1 JOIN ZZZZZZ")
        line = bad.readline()
        check("加入不存在房间 -> NO_ROOM", "NO_ROOM" in line, line)
        bad.close()

        # 原房间已满（guest 已占位）
        full = Peer.connect()
        full.sendline("MGBA1 JOIN " + code)
        line = full.readline()
        check("第三人加入 -> FULL", "FULL" in line, line)
        full.close()

        junk = Peer.connect()
        junk.sendline("HELLO")
        line = junk.readline()
        check("非法指令 -> BAD", "BAD" in line, line)
        junk.close()

        # 清理：断开后中继应释放房间
        host.close()
        guest.close()
        time.sleep(1.0)
        gone = Peer.connect()
        gone.sendline("MGBA1 JOIN " + code)
        line = gone.readline()
        check("断开后房间被释放 -> NO_ROOM", "NO_ROOM" in line, line)
        gone.close()

    finally:
        proc.terminate()
        try:
            out = proc.communicate(timeout=5)[0].decode('utf-8', 'replace')
        except Exception:
            proc.kill()
            out = '(no log)'
        print("\n--- relay.py 日志 ---")
        print(out.strip())

    print("\n=== 汇总 ===")
    passed = sum(1 for _, ok, _ in results if ok)
    total = len(results)
    for name, ok, detail in results:
        if not ok:
            print("  FAIL: %s  %s" % (name, detail))
    print("  %d/%d 通过" % (passed, total))
    return 0 if passed == total else 1


if __name__ == '__main__':
    sys.exit(main())
