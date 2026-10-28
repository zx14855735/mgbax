import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = sys.argv[1]
MENU = (float(sys.argv[2]), float(sys.argv[3]))
LINK = (float(sys.argv[4]), float(sys.argv[5]))


def adb(*args):
    subprocess.run([ADB, '-s', SERIAL, 'shell'] + list(args), timeout=30)


adb('input', 'tap', str(MENU[0]), str(MENU[1]))
time.sleep(0.35)
adb('input', 'tap', str(LINK[0]), str(LINK[1]))
time.sleep(0.8)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(rf'D:\mgba-android-version\.zcode-tmp\shot{sys.argv[6]}.png', 'wb'), timeout=30)
print('ok')
