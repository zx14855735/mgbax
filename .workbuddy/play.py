"""在 quetzal.gba 上做新手流程：连点 A 推进对话，按需截图。

用法:
  python play.py start            两个模拟器装 quetzal 并启动
  python play.py a N              在 A 上连点 A 键 N 次（每次带间隔）
  python play.py snap A name      截图
  python play.py tap A x y        按比例点击
"""
import subprocess
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

ADB = dev.ADB
A, B = dev.A, dev.B
SIZE = {A: (1200, 540), B: (2340, 1080)}
ROM = 'quetzal.gba'


def adb(*args, timeout=120):
    return subprocess.run([ADB] + [str(a) for a in args], capture_output=True, timeout=timeout)


def start(serial):
    adb('-s', serial, 'shell', 'am', 'force-stop', 'io.mgba.android')
    time.sleep(1)
    adb('-s', serial, 'shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
        '-a', 'android.intent.action.VIEW',
        '-d', 'file:///sdcard/Android/data/io.mgba.android/files/' + ROM)
    time.sleep(10)


def press_a(serial, times=1, gap=0.35):
    w, h = SIZE[serial]
    x, y = int(w * 0.88), int(h * 0.36)
    for _ in range(times):
        adb('-s', serial, 'shell', 'input', 'tap', x, y)
        time.sleep(gap)


def tap(serial, fx, fy, wait=0.8):
    w, h = SIZE[serial]
    adb('-s', serial, 'shell', 'input', 'tap', int(w * fx), int(h * fy))
    time.sleep(wait)


def swipe(serial, fx1, fy1, fx2, fy2, ms=400, wait=0.8):
    w, h = SIZE[serial]
    adb('-s', serial, 'shell', 'input', 'swipe', int(w * fx1), int(h * fy1),
        int(w * fx2), int(h * fy2), ms)
    time.sleep(wait)


def snap(serial, name):
    data = subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                          capture_output=True, timeout=90).stdout
    path = r'D:\mgba-android-version\.workbuddy\p_' + name + '.png'
    open(path, 'wb').write(data)
    print('snap', path, len(data))


def main():
    cmd = sys.argv[1]
    if cmd == 'start':
        for s in (A, B):
            start(s)
            snap(s, 'title_' + s[-4:])
    elif cmd == 'a':
        serial = A if sys.argv[2] == 'A' else B
        press_a(serial, int(sys.argv[3]))
    elif cmd == 'snap':
        serial = A if sys.argv[2] == 'A' else B
        snap(serial, sys.argv[3])
    elif cmd == 'tap':
        serial = A if sys.argv[2] == 'A' else B
        tap(serial, float(sys.argv[3]), float(sys.argv[4]))
    elif cmd == 'swipe':
        serial = A if sys.argv[2] == 'A' else B
        swipe(serial, float(sys.argv[3]), float(sys.argv[4]), float(sys.argv[5]), float(sys.argv[6]))


if __name__ == '__main__':
    main()
