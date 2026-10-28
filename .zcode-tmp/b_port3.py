import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'
SCALE = 2340 / 2000.0


def adb(*args):
    subprocess.run([ADB, '-s', SERIAL, 'shell'] + list(args), timeout=30)


def tap(x, y, wait=0.7):
    adb('input', 'tap', str(int(x * SCALE)), str(int(y * SCALE)))
    time.sleep(wait)


def snap(name):
    subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)


tap(620, 545)                 # focus port field -> fullscreen extract
for _ in range(12):
    adb('input', 'keyevent', '123')   # MOVE_END
    adb('input', 'keyevent', '67')    # DEL
    time.sleep(0.06)
adb('input', 'text', '16374')
time.sleep(0.3)
adb('input', 'keyevent', '66')
time.sleep(0.6)
snap('b_dlg5')
print('ok')
