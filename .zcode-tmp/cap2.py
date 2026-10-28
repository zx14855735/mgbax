import subprocess, sys

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
OUT = r'D:\mgba-android-version\.workbuddy'
for s, name in (('emulator-5554', 'a_now3'), ('emulator-5556', 'b_now3')):
    path = OUT + '\\' + name + '.png'
    with open(path, 'wb') as f:
        subprocess.run([ADB, '-s', s, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
    print('saved', path)
