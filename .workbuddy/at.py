"""adb 辅助：驱动两个 Android 测试模拟器（A=5554 1200x540, B=5556 2340x1080）。"""
import re
import subprocess
import sys
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
B = 'emulator-5556'
OUT = r'D:\mgba-android-version\.workbuddy'
SIZE = {A: (1200, 540), B: (2340, 1080)}


def sh(serial, *args, timeout=60):
    return subprocess.run([ADB, '-s', serial, 'shell'] + [str(a) for a in args],
                          capture_output=True, timeout=timeout)


def tap(serial, x, y, wait=0.5):
    """按物理像素点击。"""
    sh(serial, 'input', 'tap', int(x), int(y))
    time.sleep(wait)


def rtap(serial, fx, fy, wait=0.5):
    """按屏幕比例点击（0..1），两端屏幕分辨率不同时更好用。"""
    w, h = SIZE[serial]
    tap(serial, fx * w, fy * h, wait)


def swipe(serial, fx1, fy1, fx2, fy2, ms=300, wait=0.6):
    w, h = SIZE[serial]
    sh(serial, 'input', 'swipe', int(fx1 * w), int(fy1 * h),
       int(fx2 * w), int(fy2 * h), ms)
    time.sleep(wait)


def key(serial, code, wait=0.6):
    sh(serial, 'input', 'keyevent', code)
    time.sleep(wait)


def snap(serial, name):
    data = subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                          capture_output=True, timeout=60).stdout
    path = OUT + '\\' + name + '.png'
    with open(path, 'wb') as f:
        f.write(data)
    print('snap', path, len(data))
    return path


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


def find_text(xml, needle):
    for n in nodes(xml):
        if needle in n.get('text', ''):
            return n
    return None


def tap_text(serial, needle, wait=1.0):
    xml = dump(serial)
    n = find_text(xml, needle)
    if not n:
        print(serial, 'NOT FOUND', needle)
        return False
    x, y = center(n)
    print(serial, 'tap', needle, x, y)
    tap(serial, x, y, wait)
    return True


def show(serial):
    xml = dump(serial)
    for n in nodes(xml):
        text = n.get('text', '')
        rid = n.get('resource-id', '').split('/')[-1]
        if text or rid.startswith('btn_'):
            print(f'{rid:20} {text[:50]!r:56} {n.get("bounds")}')
    return xml


def logcat(serial, tag='mGBA:*', lines=60):
    r = sh(serial, 'logcat', '-d', '-s', tag)
    text = r.stdout.decode('utf-8', 'replace')
    return '\n'.join(text.strip().splitlines()[-lines:])


def clear_log(serial):
    sh(serial, 'logcat', '-c')


if __name__ == '__main__':
    cmd = sys.argv[1]
    serial = sys.argv[2]
    if cmd == 'snap':
        snap(serial, sys.argv[3])
    elif cmd == 'show':
        show(serial)
    elif cmd == 'tap':
        rtap(serial, float(sys.argv[3]), float(sys.argv[4]), 1.0)
    elif cmd == 'tap-text':
        tap_text(serial, sys.argv[3])
    elif cmd == 'log':
        print(logcat(serial))
