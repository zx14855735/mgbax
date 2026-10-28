"""端到端：安装 APK → 两个模拟器装载 ROM → 大厅创建/加入 → 抓日志。

用法: python e2e.py [rom] [wait_s]
"""
import subprocess
import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

ADB = dev.ADB
A, B = dev.A, dev.B
ROM = sys.argv[1] if len(sys.argv) > 1 else 'siotest.gba'
WAIT = int(sys.argv[2]) if len(sys.argv) > 2 else 15
APK = r'D:\mgba-android-version\android\app\build\outputs\apk\debug\app-debug.apk'
MENU = {A: (481, 410), B: (1019, 820)}
LINK = {A: (752, 33), B: (1517, 60)}
SWIPE = {A: ('600', '420', '600', '80'), B: ('1200', '870', '1200', '170')}


def adb(*args, timeout=180):
    return subprocess.run([ADB] + [str(a) for a in args], capture_output=True, timeout=timeout)


def install():
    for s in (A, B):
        r = adb('-s', s, 'install', '-r', APK)
        print(s, r.stdout.decode().strip()[-40:] or r.stderr.decode().strip()[-80:])


def forwards():
    for port in range(16374, 16378):
        adb('-s', A, 'forward', f'tcp:{port}', f'tcp:{port - 10000}')


def start_rom(serial):
    adb('-s', serial, 'shell', 'am', 'force-stop', 'io.mgba.android')
    time.sleep(1)
    adb('-s', serial, 'shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
        '-a', 'android.intent.action.VIEW',
        '-d', 'file:///sdcard/Android/data/io.mgba.android/files/' + ROM)
    time.sleep(8)


def open_dialog(serial):
    dev.tap(serial, *MENU[serial], 0.6)
    dev.tap(serial, *LINK[serial], 1.5)


def tap_item(serial, label):
    for i in range(12):
        xml = dev.dump(serial)
        n = dev.find(xml, label)
        if n:
            x, y = dev.bounds(n)
            dev.tap(serial, x, y, 1.5)
            print(serial, 'tap', label, x, y)
            return True
        dev.sh(serial, 'input', 'swipe', *SWIPE[serial], '1500')
        time.sleep(0.8)
    print(serial, 'NOT FOUND', label)
    return False


def status(serial):
    xml = dev.dump(serial)
    for n in dev.nodes(xml):
        t = n.get('text', '')
        if '打通' in t or '等待连接' in t or '已连接' in t:
            print(serial, '|', t.replace('\n', ' ')[:110])


def logs(serial, tag, tail=40):
    out = adb('-s', serial, 'shell', 'logcat', '-d', '-t', '4000', '-s', tag).stdout
    text = out.decode('utf-8', 'replace')
    lines = [l for l in text.splitlines() if ' I mGBA' in l or ' E mGBA' in l]
    print('=' * 12, tag, 'lines', len(lines))
    for l in lines[-tail:]:
        print(l)


def main():
    install()
    forwards()
    for s in (A, B):
        adb('-s', s, 'shell', 'logcat', '-c')
    start_rom(A)
    start_rom(B)
    open_dialog(A)
    if not tap_item(A, '大厅创建'):
        return
    time.sleep(2)
    open_dialog(B)
    if not tap_item(B, '大厅加入'):
        return
    time.sleep(WAIT)
    status(A)
    status(B)
    logs(A, 'mGBA')
    logs(B, 'mGBA')


if __name__ == '__main__':
    main()
