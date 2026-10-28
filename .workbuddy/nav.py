"""GBA 导航小工具：硬件按键 + 点击 + 截图，供手动推进 Quetzal 剧情。

用法（在 D:\\mgba-android-version\\.workbuddy 下运行）:
  python nav.py A key 20 3        在 A 上按 3 次 DOWN(20)
  python nav.py A a 5             在 A 上按 5 次 A
  python nav.py A tap 0.88 0.36
  python nav.py A snap m30
  python nav.py A ff              切换快进（走菜单）
"""
import subprocess
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

ADB = dev.ADB
A, B = dev.A, dev.B
SIZE = {A: (1200, 540), B: (2340, 1080)}

KEY = {'up': 19, 'down': 20, 'left': 21, 'right': 22,
       'a': 96,   # BUTTON_A
       'b': 97,   # BUTTON_B
       'start': 108, 'select': 109,
       'l1': 102, 'r1': 103,
       'menu': 82}


def adb(*args, timeout=120):
    return subprocess.run([ADB] + [str(x) for x in args], capture_output=True, timeout=timeout)


def key(serial, code, times=1, gap=0.35):
    for _ in range(times):
        adb('-s', serial, 'shell', 'input', 'keyevent', code)
        time.sleep(gap)


def tapn(serial, fx, fy, times=1, gap=0.35):
    w, h = SIZE[serial]
    x, y = int(w * fx), int(h * fy)
    for _ in range(times):
        adb('-s', serial, 'shell', 'input', 'tap', x, y)
        time.sleep(gap)


DIR = {'up': (0.1065, 0.424), 'down': (0.1065, 0.6327),
       'left': (0.060, 0.528), 'right': (0.153, 0.528)}


def hold(serial, name, ms=800):
    """在虚拟方向键上按住某个方向 ms 毫秒（等价于手柄长按）。"""
    w, h = SIZE[serial]
    fx, fy = DIR[name]
    x, y = int(w * fx), int(h * fy)
    adb('-s', serial, 'shell', 'input', 'swipe', x, y, x, y, int(ms))
    time.sleep(0.25)


def snap(serial, name):
    data = subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                          capture_output=True, timeout=90).stdout
    path = r'D:\mgba-android-version\.workbuddy\p_' + name + '.png'
    open(path, 'wb').write(data)
    print('snap', path, len(data))


def main():
    s = A if sys.argv[1] == 'A' else B
    cmd = sys.argv[2]
    if cmd == 'key':
        name = sys.argv[3]
        key(s, KEY.get(name, name), int(sys.argv[4]) if len(sys.argv) > 4 else 1)
    elif cmd == 'a':
        tapn(s, 0.88, 0.36, int(sys.argv[3]))
    elif cmd == 'b':
        tapn(s, 0.81, 0.69, int(sys.argv[3]))
    elif cmd == 'tap':
        tapn(s, float(sys.argv[3]), float(sys.argv[4]), int(sys.argv[5]) if len(sys.argv) > 5 else 1)
    elif cmd == 'hold':
        hold(s, sys.argv[3], int(sys.argv[4]) if len(sys.argv) > 4 else 800)
    elif cmd == 'snap':
        snap(s, sys.argv[3])


if __name__ == '__main__':
    main()
