"""Driver for the two link-test AVDs.

A = emulator-5554 (1200x540), B = emulator-5556 (2340x1080).
Screenshots come from the app's own SCREENSHOT broadcast because the AVD GL
capture is black.

Usage:
  python drv.py launch A|B
  python drv.py shot A name
  python drv.py key A a 3
  python drv.py tap A 0.5 0.7          (fractions of the screen)
  python drv.py show A
  python drv.py log A
  python drv.py push-state A path.ss1 1
  python drv.py ls A
"""
import re
import subprocess
import sys
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
B = 'emulator-5556'
OUT = r'D:\mgba-android-version\.workbuddy'
APP = 'io.mgba.android'
ROM = '/sdcard/Android/data/io.mgba.android/files/quetzal.gba'
SIZE = {A: (1200, 540), B: (2340, 1080)}
KEY = {'up': 19, 'down': 20, 'left': 21, 'right': 22,
       'a': 96, 'b': 97, 'start': 108, 'select': 109,
       'l': 102, 'r': 103, 'back': 4, 'menu': 82}


def serial_of(tag):
    if tag in (A, B):
        return tag
    return A if tag.upper() == 'A' else B


def sh(serial, *args, timeout=60, stdin=None):
    if stdin is not None:
        return subprocess.run([ADB, '-s', serial, 'shell'] + [str(a) for a in args],
                              stdin=stdin, capture_output=True, timeout=timeout)
    return subprocess.run([ADB, '-s', serial, 'shell'] + [str(a) for a in args],
                          capture_output=True, timeout=timeout)


def launch(serial, rom=ROM):
    sh(serial, 'am', 'force-stop', APP)
    time.sleep(1)
    sh(serial, 'am', 'start', '-n', APP + '/.EmulatorActivity',
       '-a', 'android.intent.action.VIEW', '-d', 'file://' + rom)
    time.sleep(8)


def key(serial, code, times=1, gap=0.35):
    code = KEY.get(str(code), code)
    for _ in range(times):
        sh(serial, 'input', 'keyevent', code)
        time.sleep(gap)


def tap(serial, x, y, wait=0.6):
    sh(serial, 'input', 'tap', int(x), int(y))
    time.sleep(wait)


def rtap(serial, fx, fy, wait=0.6):
    w, h = SIZE[serial]
    tap(serial, fx * w, fy * h, wait)


def swipe(serial, x1, y1, x2, y2, ms=400, wait=0.8):
    sh(serial, 'input', 'swipe', int(x1), int(y1), int(x2), int(y2), ms)
    time.sleep(wait)


def shot(serial, name, wait=2.0):
    sh(serial, 'am', 'broadcast', '-a', APP + '.action.SCREENSHOT')
    time.sleep(wait)
    base = '/sdcard/Android/data/' + APP + '/files/shots'
    listing = sh(serial, 'ls -t ' + base + '/').stdout.decode('utf-8', 'replace').split()
    if not listing:
        print('shot: no file')
        return None
    path = OUT + '\\' + name + '.png'
    subprocess.run([ADB, '-s', serial, 'pull', base + '/' + listing[0], path],
                   capture_output=True, timeout=60)
    print('shot', path, listing[0])
    return path


def dump(serial):
    for _ in range(3):
        try:
            sh(serial, 'uiautomator', 'dump', '/sdcard/ui.xml', timeout=40)
            xml = sh(serial, 'cat', '/sdcard/ui.xml').stdout.decode('utf-8', 'replace')
            if xml.strip():
                return xml
        except Exception:
            pass
        time.sleep(1.5)
    return ''


def nodes(xml):
    out = []
    for m in re.finditer(r'<node ([^>]*?)/>', xml):
        out.append(dict(re.findall(r'([\w-]+)="([^"]*)"', m.group(1))))
    return out


def bounds(node):
    m = re.match(r'\[(\d+),(\d+)\]\[(\d+),(\d+)\]', node.get('bounds', ''))
    if not m:
        return None
    x1, y1, x2, y2 = map(int, m.groups())
    return (x1 + x2) // 2, (y1 + y2) // 2


def find(xml, needle, rid=None):
    for n in nodes(xml):
        if rid and rid in n.get('resource-id', ''):
            return n
        if needle and needle in n.get('text', ''):
            return n
    return None


def show(serial, needles=()):
    xml = dump(serial)
    print('--- visible text', serial)
    for n in nodes(xml):
        t = n.get('text', '')
        rid = n.get('resource-id', '').split('/')[-1]
        if t or rid.startswith('btn_'):
            if needles and not any(s in t or s in rid for s in needles):
                continue
            print(f'{rid:22} {t[:60]!r:64} {n.get("bounds")}')
    return xml


def tap_text(serial, needle, wait=1.0, rid=None):
    xml = dump(serial)
    n = find(xml, needle, rid)
    if not n:
        print(serial, 'NOT FOUND', needle or rid)
        return False
    x, y = bounds(n)
    print(serial, 'tap', needle or rid, x, y, n.get('bounds'))
    tap(serial, x, y, wait)
    return True


def log(serial, tag='mGBA:*', tail=30, extra=()):
    args = ['logcat', '-d', '-s', tag] + list(extra)
    out = sh(serial, *args).stdout.decode('utf-8', 'replace')
    lines = [l for l in out.splitlines() if l.strip()]
    print('\n'.join(lines[-tail:]))


def clearlog(serial):
    sh(serial, 'logcat', '-c')


def push_state(serial, local, slot):
    """Copy a mGBA PNG state into the app's internal states dir as quetzal.ss<slot>."""
    sh(serial, 'run-as', APP, 'mkdir', '-p', 'files/states')
    with open(local, 'rb') as f:
        sh(serial, 'run-as', APP, 'sh', '-c',
           'cat > files/states/quetzal.ss%d' % slot, stdin=f)
    print(serial, 'pushed state slot', slot, 'from', local)


def pull_state(serial, slot, local):
    out = sh(serial, 'run-as', APP, 'cat', 'files/states/quetzal.ss%d' % slot).stdout
    with open(local, 'wb') as f:
        f.write(out)
    print(serial, 'pulled slot', slot, '->', local, len(out), 'bytes')


def ls(serial, path='files'):
    print(sh(serial, 'run-as', APP, 'ls', '-l', path).stdout.decode('utf-8', 'replace'))


def ack(serial, path='files'):
    """adb shell ls (no run-as) with unicode paths joined."""
    print(sh(serial, 'ls', '-l', path).stdout.decode('utf-8', 'replace'))


if __name__ == '__main__':
    cmd = sys.argv[1]
    s = serial_of(sys.argv[2])
    if cmd == 'launch':
        launch(s)
    elif cmd == 'shot':
        shot(s, sys.argv[3])
    elif cmd == 'key':
        key(s, sys.argv[3], int(sys.argv[4]) if len(sys.argv) > 4 else 1)
    elif cmd == 'tap':
        rtap(s, float(sys.argv[3]), float(sys.argv[4]))
    elif cmd == 'show':
        show(s)
    elif cmd == 'log':
        log(s)
    elif cmd == 'push-state':
        push_state(s, sys.argv[3], int(sys.argv[4]))
    elif cmd == 'pull-state':
        pull_state(s, int(sys.argv[3]), sys.argv[4])
    elif cmd == 'ls':
        ls(s, sys.argv[3] if len(sys.argv) > 3 else 'files')
