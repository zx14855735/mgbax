import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'
SCALE = 2340 / 2000.0  # displayed screenshot -> real input space


def adb(*args):
    subprocess.run([ADB, '-s', SERIAL, 'shell'] + list(args), timeout=30)


def tap(x, y, wait=0.0):
    adb('input', 'tap', str(int(x * SCALE)), str(int(y * SCALE)))
    if wait:
        time.sleep(wait)


def swipe(x1, y1, x2, y2, ms):
    adb('input', 'swipe', str(int(x1 * SCALE)), str(int(y1 * SCALE)),
        str(int(x2 * SCALE)), str(int(y2 * SCALE)), str(ms))


def text(s):
    adb('input', 'text', s)


# open link dialog: tap menu toggle then 联机 quickly
tap(672, 41)
time.sleep(0.4)
tap(1297, 55, 1.2)
# scroll the dialog to the GBoy lobby block
swipe(600, 400, 600, 130, 400)
time.sleep(0.4)
swipe(600, 400, 600, 130, 400)
time.sleep(0.6)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\shotB.png', 'wb'), timeout=30)
print('ok')
