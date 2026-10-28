"""异地联机连通性自检：从任意一台机器验证 MGBA1 中继是否可用。

用法：
    python relay_probe.py <host>:<port>

做的事（全部在一台机器上完成，不需要对方配合）：
  1. TCP 连上中继，量三次握手耗时（近似 RTT）。
  2. 开两条连接模拟 1P/2P：CREATE 拿房间号 → JOIN 同一房间 → 双方都应收到 PEER。
  3. 房间打通后双向各发 16 字节（NetLink 的包长），校验对端收到的是同一份字节。
  4. 打印判定结论，并按 RTT 给出「能不能玩」的估计。

判定：全绿说明中继与网络路径没问题，进游戏就能联；红了就看提示定位是
地址填错、端口没放行，还是中继没起。
"""
import socket
import struct
import sys
import time

PAYLOAD = struct.Struct('<IHHHHI')   # 与 link_net.c 的 struct Packet 同长（16 字节）
TIMEOUT = 8.0


def dial(host, port):
    """连上去并返回 (socket, 往返毫秒)。用 connect 耗时近似一个单程。"""
    started = time.time()
    sock = socket.create_connection((host, port), TIMEOUT)
    sock.settimeout(TIMEOUT)
    sock.setsockopt(socket.IPPROTO_TCP, socket.TCP_NODELAY, 1)
    return sock, (time.time() - started) * 1000.0


def read_line(sock):
    buf = b''
    while not buf.endswith(b'\n'):
        chunk = sock.recv(1)
        if not chunk:
            raise IOError('对端断开')
        buf += chunk
    return buf.decode('utf-8', 'replace').strip()


def send_line(sock, text):
    sock.sendall((text + '\n').encode())


def parse_room(line, role):
    prefix = 'MGBA1 ROOM '
    if not line.startswith(prefix):
        raise IOError('期望 ROOM，实际收到 %r' % line)
    return line[len(prefix):len(line) - len(role) - 1].strip()


def expect_peer(line):
    if line != 'MGBA1 PEER':
        raise IOError('期望 PEER，实际收到 %r' % line)


def exchange(a, b, label):
    """a 发一个 NetLink 包，b 应当原样收到。"""
    packet = PAYLOAD.pack(0x314C424D, 5, 7, 2, 1, 0xB9A0)
    a.sendall(packet)
    got = b.recv(len(packet))
    if got != packet:
        raise IOError('%s 内容不一致：%r != %r' % (label, got.hex(), packet.hex()))
    return True


def main():
    if len(sys.argv) < 2:
        print(__doc__)
        return 2
    field = sys.argv[1].strip()
    if ':' in field:
        host, port_text = field.rsplit(':', 1)
        port = int(port_text)
    else:
        host, port = field, 8766
    print('目标中继 %s:%d' % (host, port))

    # 1. 连通性与延迟
    try:
        probe, rtt = dial(host, port)
    except Exception as exc:
        print('  [失败] 连不上：%s' % exc)
        print('  → 检查地址/端口、云主机的安全组或防火墙是否放行、relay.py 是否在跑。')
        return 1
    probe.close()
    print('  [通过] TCP 可连，握手 %.1f ms' % rtt)

    # 2. 配对
    try:
        host_sock, _ = dial(host, port)
        send_line(host_sock, 'MGBA1 CREATE')
        code = parse_room(read_line(host_sock), 'HOST')
        print('  [通过] 建房成功，房间号 %s' % code)

        guest_sock, _ = dial(host, port)
        send_line(guest_sock, 'MGBA1 JOIN ' + code)
        parse_room(read_line(guest_sock), 'GUEST')
        expect_peer(read_line(host_sock))
        expect_peer(read_line(guest_sock))
        print('  [通过] 双方已配对（PEER）')
    except Exception as exc:
        print('  [失败] 配对失败：%s' % exc)
        return 1

    # 3. 双向裸字节
    try:
        exchange(host_sock, guest_sock, '1P→2P')
        exchange(guest_sock, host_sock, '2P→1P')
        print('  [通过] 双向 16 字节镜像转发正常')
    except Exception as exc:
        print('  [失败] 数据转发异常：%s' % exc)
        return 1
    finally:
        host_sock.close()
        guest_sock.close()

    # 4. 结论
    if rtt < 10:
        verdict = '延迟很低，和局域网没差别'
    elif rtt < 40:
        verdict = '延迟可用；如果游戏掉速，把中继换到离双方都近的机房'
    else:
        verdict = '延迟偏高，逐字交换的联机会明显掉速，建议换更近的中继'
    print('\n结论：中继可用。%s（握手 %.1f ms）' % (verdict, rtt))
    return 0


if __name__ == '__main__':
    sys.exit(main())
