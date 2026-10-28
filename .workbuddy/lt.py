"""本次联机测试用的 adb 助手（两个模拟器 A=5554 / B=5556）。"""
import re
import subprocess
import sys
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
B = 'emulator-5556'
OUT = r'D:\mgba-android-version\.workbuddy'


def sh(serial, *args, timeout=60):
    return subprocess.run([ADB, '-s', serial, 'shell'] + [str(a) for a in args],
                          capture_output=True, timeout=timeout)


def raw(*args, timeout=180):
    return subprocess.run([ADB] + [str(a) for a in args], capture_output=True, timeout=timeout)


def tap(serial, x, y, wait=0.45):
    sh(serial, 'input', 'tap', int(x), int(y))
    time.sleep(wait)


def key(serial, code, wait=0.5):
    sh(serial, 'input', 'keyevent', str(code))
    time.sleep(wait)


def text(serial, s, wait=0.4):
    sh(serial, 'input', 'text', s)
    time.sleep(wait)


def dump(serial):
    for _ in range(3):
        try:
            sh(serial, 'uiautomator', 'dump', '/sdcard/ui.xml', timeout=30)
            return sh(serial, 'cat', '/sdcard/ui.xml').stdout.decode('utf-8', 'replace')
        except Exception:
            time.sleep(2)
    return ''


def nodes(xml):
    out = []
    for m in re.finditer(r'<node ([^>]*)/>', xml):
        out.append(dict(re.findall(r'([\w-]+)="([^"]*)"', m.group(1))))
    return out


def center(node):
    m = re.match(r'\[(\d+),(\d+)\]\[(\d+),(\d+)\]', node['bounds'])
    x1, y1, x2, y2 = map(int, m.groups())
    return (x1 + x2) // 2, (y1 + y2) // 2


def find(xml, needle, cls=None):
    for n in nodes(xml):
        if cls and n.get('class', '').split('.')[-1] != cls:
            continue
        if needle in n.get('text', ''):
            return n
    return None


def tap_text(serial, needle, cls=None, wait=1.0):
    xml = dump(serial)
    n = find(xml, needle, cls)
    if not n:
        print(serial, 'NOT FOUND', needle, cls)
        return False
    x, y = center(n)
    tap(serial, x, y, wait)
    print(serial, 'tap', repr(needle), x, y)
    return True


def show(serial, cls=None):
    xml = dump(serial)
    for n in nodes(xml):
        c = n.get('class', '').split('.')[-1]
        if cls and c != cls:
            continue
        t = n.get('text', '')
        if t.strip():
            print(f'  {c:12} {t[:70]!r}')
    return xml


def snap(serial, name):
    data = raw('-s', serial, 'exec-out', 'screencap', '-p', timeout=90).stdout
    path = OUT + '\\' + name + '.png'
    with open(path, 'wb') as f:
        f.write(data)
    print('snap', path, len(data))
    return path


def logcat(serial, tag='mGBA', lines=60, grep=None):
    out = sh(serial, 'logcat', '-d', '-t', '3000', '-s', tag).stdout.decode('utf-8', 'replace')
    ls = out.splitlines()
    if grep:
        ls = [l for l in ls if grep in l]
    print('=' * 10, serial, tag, len(ls), 'lines')
    for l in ls[-lines:]:
        print(l)


def clear(serial):
    sh(serial, 'logcat', '-c')


def main():
    if len(sys.argv) < 2:
        print('usage: lt.py <cmd> <serial-suffix> [args...]')
        return
    cmd = sys.argv[1]
    rest = sys.argv[2:]
    # 支持两种写法：`lt.py raw 5554 ...` 与 `lt.py raw -s emulator-5554 ...`
    serial = None
    if rest and rest[0] == '-s' and len(rest) > 1:
        serial = rest[1]
        rest = rest[2:]
    elif rest:
        serial = A if '5554' in rest[0] else B
        rest = rest[1:]
    if serial not in (A, B):
        serial = A
    if cmd == 'key':
        for c in rest:
            key(serial, c)
    elif cmd == 'tap':
        tap(serial, rest[0], rest[1])
    elif cmd == 'snap':
        snap(serial, rest[0])
    elif cmd == 'log':
        logcat(serial, 'mGBA', int(rest[0]) if rest else 60, rest[1] if len(rest) > 1 else None)
    elif cmd == 'clear':
        clear(serial)
    elif cmd == 'raw':
        p = raw('-s', serial, *rest)
        print(p.stdout.decode('utf-8', 'replace'))
        print(p.stderr.decode('utf-8', 'replace'))
    elif cmd == 'shell':
        p = sh(serial, *rest)
        print(p.stdout.decode('utf-8', 'replace'))
        print(p.stderr.decode('utf-8', 'replace'))
    elif cmd == 'show':
        show(serial)
    else:
        print('unknown', cmd)


if __name__ == '__main__':
    main()
