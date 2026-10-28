"""进入 Quetzal 的「联机 → 2P」等待画面，用于验证 SIO 隧道。

用法: python enter2p.py A|B
"""
import subprocess
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

KEY = {'up': 19, 'down': 20, 'left': 21, 'right': 22, 'a': 96, 'b': 97,
       'start': 108, 'select': 109, 'l1': 102, 'r1': 103}


def key(serial, name, gap=0.75):
    subprocess.run([dev.ADB, '-s', serial, 'shell', 'input', 'keyevent', str(KEY.get(name, name))])
    time.sleep(gap)


def snap(serial, name):
    data = subprocess.run([dev.ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                          capture_output=True, timeout=90).stdout
    path = r'D:\mgba-android-version\.workbuddy\p_' + name + '.png'
    open(path, 'wb').write(data)
    print('snap', path, len(data))


def main():
    s = dev.A if sys.argv[1] == 'A' else dev.B
    tag = sys.argv[1]
    # 标题 → 继续游戏
    key(s, 'start', 2.0)
    key(s, 'up', 0.6)
    key(s, 'a', 4.0)
    snap(s, tag + '_cont')
    # 菜单 → 联机 → 2P
    key(s, 'start', 1.5)
    for _ in range(4):
        key(s, 'down', 0.7)
    key(s, 'down', 0.7)
    key(s, 'a', 2.0)
    key(s, 'a', 2.5)
    snap(s, tag + '_2p')


if __name__ == '__main__':
    main()
