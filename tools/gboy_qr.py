#!/usr/bin/env python3
"""分享命令 / 二维码生成。

对端（另一台不同公网 IP 的机器）只要扫一下二维码，或复制那一行命令，
就能加入同一个中继节点开始联机对战。

二维码内容就是一行可直接粘贴执行的 join 命令。
"""
import io
import os
import sys

HERE = os.path.dirname(os.path.abspath(__file__))
QR_FILE = os.path.join(HERE, "lobby_link_qr.png")

# 二维码容量有限，命令保持精简：脚本名 + join + 节点 + 房号
MAX_PAYLOAD = 400


def join_command(node, room_id=None, script="kcp_relay_test.py"):
    """生成对端要执行的那一行命令。"""
    cmd = "python %s join %s" % (script, node)
    if room_id:
        cmd += " " + str(room_id)
    return cmd


def ascii_qr(payload):
    """终端里可直接扫的字符二维码；没装 qrcode 时返回 None。"""
    try:
        import qrcode
    except ImportError:
        return None
    qr = qrcode.QRCode()
    qr.add_data(payload)
    qr.make()
    buf = io.StringIO()
    try:
        qr.print_ascii(out=buf, invert=True)
    except TypeError:
        qr.print_ascii(out=buf)
    return buf.getvalue()


def write_png(payload, path=QR_FILE):
    """写出 PNG 二维码文件；没装 qrcode/Pillow 时返回 None。"""
    try:
        import qrcode
    except ImportError:
        return None
    qr = qrcode.QRCode(border=2, box_size=8)
    qr.add_data(payload)
    qr.make()
    qr.make_image(fill_color="black", back_color="white").save(path)
    return path


def emit(payload, title=None, path=QR_FILE):
    """打印二维码 + 保存 PNG。返回 PNG 路径（失败为 None）。"""
    if len(payload) > MAX_PAYLOAD:
        payload = payload[:MAX_PAYLOAD]
    png = write_png(payload, path)
    art = ascii_qr(payload)
    if art:
        if title:
            print(title)
        print(art)
    if png:
        print("二维码图片已保存: %s" % png)
    else:
        print("（未安装 qrcode 库，无法生成二维码；直接复制上面那行命令即可）")
    return png


if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("用法: python gboy_qr.py <要编码的内容> [输出png路径]")
        sys.exit(1)
    out = sys.argv[2] if len(sys.argv) > 2 else QR_FILE
    emit(sys.argv[1], path=out)
