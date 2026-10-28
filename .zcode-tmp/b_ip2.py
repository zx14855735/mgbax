import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'
SCALE = 2340 / 2000.0


def adb(*args):
    subprocess.run([ADB, '-s', SERIAL, 'shell'] + list(args), timeout=30)


def tap(x, y, wait=0.0):
    adb('input', 'tap', str(int(x * SCALE)), str(int(y * SCALE)))
    if wait:
        time.sleep(wait)


def key(code, times=1):
    for _ in range(times):
        adb('input', 'keyevent', str(code))


def text(s):
    adb('input', 'text', s)


# 1. clear the relay field that got the IP
tap(620, 205, 0.6)
key(123)          # MOVE_END
key(67, 12)       # DEL
# 2. focus the lobby IP field and type the host address
tap(620, 760, 0.6)
text('10.0.2.2')
time.sleep(0.3)
# 3. TAB to the port field, clear 6374, type 16374
key(61, 1)        # TAB
key(123, 1)
key(67, 6)
text('16374')
time.sleep(0.5)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\shotB.png', 'wb'), timeout=30)
print('ok')
