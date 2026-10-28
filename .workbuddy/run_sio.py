"""跑一次「大厅 + 串口隧道」联机，并抓两端的日志/截图。

用法: python run_sio.py <rom> [run_seconds]
"""
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

ADB = dev.ADB
A, B = dev.A, dev.B
ROM = sys.argv[1] if len(sys.argv) > 1 else 'siotest.gba'
WAIT = int(sys.argv[2]) if len(sys.argv) > 2 else 20

MENU = {A: (481, 410), B: (1019, 820)}
LINK = {A: (752, 33), B: (1517, 60)}
SWIPE = {A: ('600', '420', '600', '80'), B: ('1200', '870', '1200', '170')}


def start_rom(serial):
    dev.sh(serial, 'am', 'force-stop', 'io.mgba.android')
    time.sleep(1)
    dev.sh(serial, 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
           '-a', 'android.intent.action.VIEW',
           '-d', 'file:///sdcard/Android/data/io.mgba.android/files/' + ROM)
    time.sleep(8)


def open_lobby(serial, label):
    dev.tap(serial, *MENU[serial], 0.6)
    dev.tap(serial, *LINK[serial], 1.5)
    for i in range(12):
        xml = dev.dump(serial)
        n = dev.find(xml, label)
        if n:
            x, y = dev.bounds(n)
            dev.tap(serial, x, y, 1.5)
            print(serial, 'tapped', label, 'after', i, 'scrolls', x, y)
            return True
        dev.sh(serial, 'input', 'swipe', *SWIPE[serial], '1500')
        time.sleep(0.8)
    print(serial, 'NOT FOUND', label)
    dev.show(serial)
    return False


def main():
    # A 当主机：把宿主机的 16374..16377 转发到 A 的 6374..6377
    for port in range(16374, 16378):
        dev.sh(A, 'forward', f'tcp:{port}', f'tcp:{port - 10000}')
    for s in (A, B):
        dev.sh(s, 'logcat', '-c')
    start_rom(A)
    start_rom(B)
    if not open_lobby(A, '大厅创建'):
        return
    time.sleep(3)
    if not open_lobby(B, '大厅加入'):
        return
    time.sleep(WAIT)
    dev.snap(A, 'sio_a')
    dev.snap(B, 'sio_b')
    for s, tag in ((A, 'A'), (B, 'B')):
        print('=' * 20, tag)
        print(dev.logcat(s, 400))


if __name__ == '__main__':
    main()
