import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'
SCALE = 2340 / 2000.0


def adb(*args):
    subprocess.run([ADB, '-s', SERIAL, 'shell'] + list(args), timeout=30)


def tap(x, y, wait=0.6):
    adb('input', 'tap', str(int(x * SCALE)), str(int(y * SCALE)))
    time.sleep(wait)


def key(code, times=1, wait=0.15):
    for _ in range(times):
        adb('input', 'keyevent', str(code))
        time.sleep(wait)


def text(s, wait=0.3):
    adb('input', 'text', s)
    time.sleep(wait)


def snap(name='b_dlg3'):
    subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)


step = sys.argv[1]
if step == 'ip':
    tap(620, 444)
    snap('b_edit_ip')
elif step == 'iptext':
    text('10.0.2.2')
    key(66)          # ENTER / DONE
    time.sleep(0.5)
    snap('b_dlg3')
elif step == 'port':
    tap(620, 551)
    snap('b_edit_port')
elif step == 'porttext':
    key(67, 8)
    text('16374')
    key(66)
    time.sleep(0.5)
    snap('b_dlg4')
elif step == 'join':
    tap(1323, 660, 1.5)
    snap('b_joined')
print('ok', step)
