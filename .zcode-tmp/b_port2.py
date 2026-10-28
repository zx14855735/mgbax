import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'


def adb(*args):
    subprocess.run([ADB, '-s', SERIAL, 'shell'] + list(args), timeout=30)


for _ in range(4):
    adb('input', 'keyevent', '67')
    time.sleep(0.1)
adb('input', 'text', '16374')
time.sleep(0.3)
adb('input', 'keyevent', '66')
time.sleep(0.6)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\b_dlg4.png', 'wb'), timeout=30)
print('ok')
