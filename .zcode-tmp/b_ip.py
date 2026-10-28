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


def text(s):
    adb('input', 'text', s)


def swipe(x1, y1, x2, y2, ms):
    adb('input', 'swipe', str(int(x1 * SCALE)), str(int(y1 * SCALE)),
        str(int(x2 * SCALE)), str(int(y2 * SCALE)), str(ms))


tap(620, 765, 0.8)          # gboy IP field
text('10.0.2.2')
time.sleep(0.5)
adb('input', 'keyevent', '111')   # ESC to dismiss any suggestions UI
swipe(600, 400, 600, 130, 400)    # scroll: reveal port + join buttons
time.sleep(0.6)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\shotB.png', 'wb'), timeout=30)
print('ok')
