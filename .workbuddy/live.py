"""Live GBA driving via the in-app screenshot broadcast (headless-safe).

Usage:
  python live.py A shot name
  python live.py A key 108 [times]
  python live.py A tap 0.5 0.5
  python live.py A text HELLO
"""
import subprocess
import sys
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
B = 'emulator-5556'
SIZE = {A: (1200, 540), B: (2340, 1080)}
OUT = r'D:\mgba-android-version\.workbuddy'

KEY = {'up': 19, 'down': 20, 'left': 21, 'right': 22,
       'a': 96, 'b': 97, 'start': 108, 'select': 109,
       'l': 102, 'r': 103, 'menu': 82, 'back': 4}


def sh(serial, *args, timeout=60):
    return subprocess.run([ADB, '-s', serial, 'shell'] + [str(a) for a in args],
                          capture_output=True, timeout=timeout)


def key(serial, code, times=1, gap=0.25):
    code = KEY.get(code, code)
    for _ in range(times):
        sh(serial, 'input', 'keyevent', code)
        time.sleep(gap)


def tap(serial, fx, fy, wait=0.6):
    w, h = SIZE[serial]
    sh(serial, 'input', 'tap', int(fx * w), int(fy * h))
    time.sleep(wait)


def text(serial, s, wait=0.4):
    sh(serial, 'input', 'text', s)
    time.sleep(wait)


def shot(serial, name, wait=2.0):
    sh(serial, 'am', 'broadcast', '-a', 'io.mgba.android.action.SCREENSHOT')
    time.sleep(wait)
    base = '/sdcard/Android/data/io.mgba.android/files/shots'
    listing = sh(serial, 'ls -t ' + base + '/').stdout.decode('utf-8', 'replace').split()
    newest = listing[0] if listing else None
    if not newest:
        print('shot: no file')
        return None
    path = OUT + '\\' + name + '.png'
    subprocess.run([ADB, '-s', serial, 'pull', base + '/' + newest, path],
                   capture_output=True, timeout=60)
    print('shot', path, newest)
    return path


def log(serial, tag='mGBA:*', tail=20):
    r = sh(serial, 'logcat', '-d', '-s', tag)
    print('\n'.join(r.stdout.decode('utf-8', 'replace').strip().splitlines()[-tail:]))


if __name__ == '__main__':
    serial = sys.argv[1]
    cmd = sys.argv[2]
    if cmd == 'shot':
        shot(serial, sys.argv[3])
    elif cmd == 'key':
        key(serial, sys.argv[3], int(sys.argv[4]) if len(sys.argv) > 4 else 1)
    elif cmd == 'tap':
        tap(serial, float(sys.argv[3]), float(sys.argv[4]))
    elif cmd == 'text':
        text(serial, sys.argv[3])
    elif cmd == 'log':
        log(serial)
