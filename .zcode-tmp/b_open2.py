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


def snap(name='shotB'):
    subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)


# fresh app start with ROM
adb('am', 'force-stop', 'io.mgba.android')
time.sleep(1)
cmd = 'am start -n io.mgba.android/.EmulatorActivity -a android.intent.action.VIEW ' \
      '-d file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba'
subprocess.run([ADB, '-s', SERIAL, 'shell', cmd], timeout=30)
time.sleep(5)
tap(672, 41)          # expand menu
time.sleep(0.4)
tap(1297, 55, 1.2)    # 联机
snap('b_dlg1')
print('ok')
