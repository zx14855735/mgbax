"""Small adb helper for driving the two test emulators."""
import re
import subprocess
import sys
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
B = 'emulator-5556'
OUT = r'D:\mgba-android-version\.zcode-tmp'


def sh(serial, *args, timeout=40):
    return subprocess.run([ADB, '-s', serial, 'shell'] + list(args),
                          capture_output=True, timeout=timeout)


def tap(serial, x, y, wait=0.4):
    sh(serial, 'input', 'tap', str(int(x)), str(int(y)))
    time.sleep(wait)


def dump(serial):
    for _ in range(3):
        try:
            sh(serial, 'uiautomator', 'dump', '/sdcard/ui.xml', timeout=25)
            return sh(serial, 'cat', '/sdcard/ui.xml').stdout.decode('utf-8', 'replace')
        except Exception:
            pass
        time.sleep(2)
    return ''


def nodes(xml):
    out = []
    for m in re.finditer(r'<node ([^>]*)/>', xml):
        attrs = dict(re.findall(r'([\w-]+)="([^"]*)"', m.group(1)))
        out.append(attrs)
    return out


def find(xml, needle, rid=None):
    for n in nodes(xml):
        if rid and n.get('resource-id', '').split('/')[-1] == rid:
            return n
        if needle and needle in n.get('text', ''):
            return n
    return None


def bounds(n):
    m = re.match(r'\[(\d+),(\d+)\]\[(\d+),(\d+)\]', n['bounds'])
    x1, y1, x2, y2 = map(int, m.groups())
    return (x1 + x2) // 2, (y1 + y2) // 2


def tap_text(serial, text, wait=1.0):
    xml = dump(serial)
    n = find(xml, text)
    if not n:
        print(serial, 'NOT FOUND', text)
        return False
    x, y = bounds(n)
    print(serial, 'tap', text, x, y)
    tap(serial, x, y, wait)
    return True


def tap_id(serial, rid, wait=1.0):
    xml = dump(serial)
    n = find(xml, None, rid)
    if not n:
        print(serial, 'NOT FOUND id', rid)
        return False
    x, y = bounds(n)
    print(serial, 'tap id', rid, x, y)
    tap(serial, x, y, wait)
    return True


def snap(serial, name):
    data = subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                          capture_output=True, timeout=30).stdout
    p = rf'{OUT}\{name}.png'
    open(p, 'wb').write(data)
    print('snap', p, len(data))
    return p


def logcat(serial, tag='mGBA:* GBoyLink:*'):
    out = sh(serial, 'shell', f'logcat -d -s {tag}')
    return out.stdout.decode('utf-8', 'replace')


def show(serial):
    xml = dump(serial)
    for n in nodes(xml):
        text = n.get('text', '')
        rid = n.get('resource-id', '').split('/')[-1]
        if text or rid.startswith('btn_'):
            print(f'{rid:24} {text[:40]!r:44} {n.get("bounds")} vis={n.get("visible-to-user")}')


def show_fast(serial, *pre):
    """Tap keys then dump within one shell call so the menu does not autohide."""
    cmd = '; '.join(list(pre) + ['sleep 0.3', 'uiautomator dump /sdcard/ui.xml'])
    sh(serial, cmd)
    xml = sh(serial, 'cat', '/sdcard/ui.xml').stdout.decode('utf-8', 'replace')
    for n in nodes(xml):
        text = n.get('text', '')
        rid = n.get('resource-id', '').split('/')[-1]
        if text or rid.startswith('btn_'):
            print(f'{rid:24} {text[:40]!r:44} {n.get("bounds")}')


if __name__ == '__main__':
    cmd = sys.argv[1]
    serial = sys.argv[2]
    if cmd == 'tap':
        tap_text(serial, sys.argv[3])
    elif cmd == 'tap-id':
        tap_id(serial, sys.argv[3])
    elif cmd == 'snap':
        snap(serial, sys.argv[3])
    elif cmd == 'dump':
        print(dump(serial))
    elif cmd == 'show':
        show(serial)
    elif cmd == 'showfast':
        show_fast(serial, *sys.argv[3:])
    elif cmd == 'log':
        print(logcat(serial))
