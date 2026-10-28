import subprocess, sys

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'


def snap(serial, out):
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=open(out, 'wb'), timeout=30)
    print(out)


for serial, name in (('emulator-5554', 'A'), ('emulator-5556', 'B')):
    snap(serial, rf'D:\mgba-android-version\.zcode-tmp\shot{name}.png')
