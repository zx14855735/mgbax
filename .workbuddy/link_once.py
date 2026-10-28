"""建立 adb 端口转发并跑一次大厅+串口隧道联机，打印两端日志。

注意：`adb forward` 不能经过 `adb shell`，所以这里直接用 subprocess 调 adb。
"""
import subprocess
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

ADB = dev.ADB
A, B = dev.A, dev.B
MENU = {A: (481, 410), B: (1019, 820)}
LINK = {A: (752, 33), B: (1517, 60)}
SWIPE = {A: ('600', '420', '600', '80'), B: ('1200', '870', '1200', '170')}


def adb(*args):
    return subprocess.run([ADB] + list(args), capture_output=True, timeout=60)


def forwards():
    for port in range(16374, 16378):
        adb('-s', A, 'forward', f'tcp:{port}', f'tcp:{port - 10000}')
    print('forwards:', adb('-s', A, 'forward', '--list').stdout.decode().strip())


def open_dialog(serial):
    dev.tap(serial, *MENU[serial], 0.6)
    dev.tap(serial, *LINK[serial], 1.5)


def tap_item(serial, label):
    for i in range(12):
        xml = dev.dump(serial)
        n = dev.find(xml, label)
        if n:
            x, y = dev.bounds(n)
            dev.tap(serial, x, y, 1.5)
            print(serial, 'tap', label, x, y)
            return True
        dev.sh(serial, 'input', 'swipe', *SWIPE[serial], '1500')
        time.sleep(0.8)
    print(serial, 'NOT FOUND', label)
    dev.show(serial)
    return False


def status(serial):
    xml = dev.dump(serial)
    for n in dev.nodes(xml):
        t = n.get('text', '')
        if any(k in t for k in ('联机', '等待', '已连接', '打通', '通道', '1P', '2P')):
            print(serial, '|', t.replace('\n', ' ')[:120], n.get('bounds'))


def logs(serial, tag):
    out = dev.sh(serial, 'shell', f'logcat -d -t 2000 -s {tag}').stdout.decode('utf-8', 'replace')
    lines = [l for l in out.splitlines() if 'mGBA' in l or 'GBoyLink' in l]
    print('=' * 12, tag, len(lines))
    for l in lines[-40:]:
        print(l)


def main():
    forwards()
    for s in (A, B):
        dev.sh(s, 'logcat', '-c')
    open_dialog(A)
    if not tap_item(A, '大厅创建'):
        return
    time.sleep(2)
    open_dialog(B)
    if not tap_item(B, '大厅加入'):
        return
    time.sleep(8)
    status(A)
    status(B)
    dev.snap(A, 'link_a')
    dev.snap(B, 'link_b')
    logs(A, 'mGBA')
    logs(B, 'mGBA')


if __name__ == '__main__':
    main()
