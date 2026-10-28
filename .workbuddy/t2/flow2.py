"""Drive both emulators through the GBA cable-club trade flow."""
import re
import subprocess
import time

import dev2 as d

APK = r'D:\mgba-android-version\android\app\build\outputs\apk\debug\app-debug.apk'

# On-screen key centres per device.
A_BTN = (1053, 209)
B_BTN = (2088, 384)
A_START = (357, 410)
B_START = (716, 818)
MENU = {d.A: (481, 410), d.B: (1019, 820)}
LINK = {d.A: (752, 33), d.B: (1517, 60)}
CREATE = {d.A: (431, 410), d.B: (939, 762)}
JOIN = {d.A: (771, 405), d.B: (1551, 762)}


def install():
    for s in (d.A, d.B):
        r = subprocess.run([d.ADB, '-s', s, 'install', '-r', APK],
                           capture_output=True, text=True, timeout=300)
        print(s, r.stdout.strip().splitlines()[-1:])


def launch():
    for s in (d.A, d.B):
        d.sh(s, 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity')
    time.sleep(16)


def load_save():
    d.tap(d.A, *A_START, 1.5)
    d.tap(d.B, *B_START, 1.5)
    for _ in range(3):
        d.tap(d.A, *A_BTN, 1.0)
        d.tap(d.B, *B_BTN, 1.0)
    time.sleep(2)


def open_link_dialog():
    for s in (d.A, d.B):
        d.tap(s, *MENU[s], 0.35)
        d.tap(s, *LINK[s], 1.2)


def host_and_join():
    d.clear_log(d.A)
    d.clear_log(d.B)
    d.tap(d.A, *CREATE[d.A], 2.0)
    d.tap(d.B, *JOIN[d.B], 3.0)
    time.sleep(2)


def texts(serial):
    d.sh(serial, 'uiautomator', 'dump', '/sdcard/ui.xml')
    xml = d.sh(serial, 'cat', '/sdcard/ui.xml').stdout.decode('utf-8', 'replace')
    return [t for t in re.findall(r'text="([^"]*)"', xml) if t.strip()]


def link_lines(serial, tail=25):
    keep = ('Link ', 'SIO ', 'LINK_', 'PEEK')
    return '\n'.join([l for l in d.link_log(serial, 4000).splitlines()
                      if any(k in l for k in keep)][-tail:])


if __name__ == '__main__':
    import sys
    step = sys.argv[1]
    if step == 'boot':
        install()
        launch()
        load_save()
        d.snap(d.A, 'p_boot_a')
        d.snap(d.B, 'p_boot_b')
    elif step == 'link':
        open_link_dialog()
        d.snap(d.A, 'p_dlg_a')
        d.snap(d.B, 'p_dlg_b')
    elif step == 'connect':
        host_and_join()
        print(link_lines(d.A))
        print(link_lines(d.B))
    elif step == 'enter':
        for s, btn in ((d.B, B_BTN), (d.A, A_BTN)):
            for _ in range(4):
                d.tap(s, *btn, 1.2)
            time.sleep(1)
        time.sleep(3)
        d.snap(d.A, 'p_enter_a')
        d.snap(d.B, 'p_enter_b')
    elif step == 'snap':
        d.snap(d.A, sys.argv[2] + '_a')
        d.snap(d.B, sys.argv[2] + '_b')
    elif step == 'confirm':
        d.tap(d.A, *A_BTN, 1.5)
        d.tap(d.B, *B_BTN, 1.5)
        time.sleep(2)
        d.snap(d.A, 'p_confirm_a')
        d.snap(d.B, 'p_confirm_b')
    elif step == 'log':
        print('=== A'); print(link_lines(d.A, int(sys.argv[2]) if len(sys.argv) > 2 else 25))
        print('=== B'); print(link_lines(d.B, int(sys.argv[2]) if len(sys.argv) > 2 else 25))
