import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

for k, s in SER.items():
    subprocess.run([ADB, '-s', s, 'shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
                    '-a', 'android.intent.action.VIEW',
                    '-d', 'file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba'],
                   capture_output=True, timeout=60)
print('both launched, waiting 22s')
time.sleep(22)
from PIL import Image
for k, s in SER.items():
    path = r'D:\mgba-android-version\.workbuddy' + '\\' + k + '_v2.png'
    with open(path, 'wb') as f:
        subprocess.run([ADB, '-s', s, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
    print(k, Image.open(path).size)
