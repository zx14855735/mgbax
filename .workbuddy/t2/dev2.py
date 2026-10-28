"""Tiny adb helper for driving the two test emulators."""
import subprocess
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
B = 'emulator-5556'
OUT = r'D:\mgba-android-version\.workbuddy\t2'


def sh(serial, *args, timeout=60):
    return subprocess.run([ADB, '-s', serial, 'shell'] + list(args),
                          capture_output=True, timeout=timeout)


def tap(serial, x, y, wait=0.6):
    sh(serial, 'input', 'tap', str(int(x)), str(int(y)))
    time.sleep(wait)


def key(serial, code, wait=0.5):
    sh(serial, 'input', 'keyevent', str(code))
    time.sleep(wait)


def snap(serial, name):
    png = subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                         capture_output=True, timeout=90).stdout
    import os
    path = os.path.join(OUT, name + '.png')
    with open(path, 'wb') as f:
        f.write(png)
    print('snap', path, len(png))
    return path


def clear_log(serial):
    subprocess.run([ADB, '-s', serial, 'logcat', '-c'], capture_output=True)


def link_log(serial, tail=400):
    raw = subprocess.run([ADB, '-s', serial, 'logcat', '-d', '-v', 'time'],
                         capture_output=True, timeout=90).stdout
    lines = [l for l in raw.decode('utf-8', 'replace').splitlines()
             if 'mGBA' in l or 'GBoyLink' in l]
    return '\n'.join(lines[-tail:])


if __name__ == '__main__':
    import sys
    cmd = sys.argv[1]
    serial = {'a': A, 'b': B}[sys.argv[2]] if len(sys.argv) > 2 and sys.argv[2] in ('a', 'b') else None
    if cmd == 'snap':
        snap(serial, sys.argv[3])
    elif cmd == 'tap':
        tap(serial, int(sys.argv[3]), int(sys.argv[4]))
    elif cmd == 'log':
        print(link_log(serial, int(sys.argv[3]) if len(sys.argv) > 3 else 400))
    elif cmd == 'clog':
        clear_log(serial)
