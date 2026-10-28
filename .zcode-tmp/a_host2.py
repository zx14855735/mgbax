import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'


def adb(serial, *args):
    subprocess.run([ADB, '-s', serial, 'shell'] + list(args), timeout=30)


def snap(serial, name):
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)


# A: reopen link dialog, scroll, host lobby
adb('emulator-5554', 'input', 'tap', '352', '25')
time.sleep(0.4)
adb('emulator-5554', 'input', 'tap', '778', '32')
time.sleep(1.2)
for _ in range(2):
    adb('emulator-5554', 'input', 'swipe', '600', '400', '600', '130', '400')
    time.sleep(0.5)
snap('emulator-5554', 'a_rehost')
print('ok')
