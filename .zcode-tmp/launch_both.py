import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

# forwards toward A
for local, remote in (('16374', '6374'), ('16375', '6375'), ('16376', '6376')):
    subprocess.run([ADB, 'forward', f'tcp:{local}', f'tcp:{remote}'], capture_output=True, timeout=30)
r = subprocess.run([ADB, 'forward', '--list'], capture_output=True, timeout=30)
print('forwards:', r.stdout.decode().strip())

for k, s in SER.items():
    subprocess.run([ADB, '-s', s, 'shell', 'am', 'start', '-n', 'io.mgba.android/.EmulatorActivity',
                    '-a', 'android.intent.action.VIEW',
                    '-d', 'file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba'],
                   capture_output=True, timeout=60)
    print(k, 'launched')
print('waiting 22s for ROM boot')
time.sleep(22)

from PIL import Image
for k, s in SER.items():
    path = r'D:\mgba-android-version\.workbuddy' + '\\' + k + '_boot.png'
    with open(path, 'wb') as f:
        subprocess.run([ADB, '-s', s, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
    print(k, 'shot', Image.open(path).size)
