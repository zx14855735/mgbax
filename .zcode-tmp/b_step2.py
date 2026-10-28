import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'
SCALE = 2340 / 2000.0


def adb(*args):
    subprocess.run([ADB, '-s', SERIAL, 'shell'] + list(args), timeout=30)


n = int(sys.argv[1])
for i in range(n):
    adb('input', 'swipe', str(int(600 * SCALE)), str(int(400 * SCALE)),
        str(int(600 * SCALE)), str(int(130 * SCALE)), '400')
    time.sleep(0.5)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\b_dlg2.png', 'wb'), timeout=30)
print('ok')
