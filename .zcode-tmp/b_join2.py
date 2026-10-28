import subprocess, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'
SCALE = 2340 / 2000.0

subprocess.run([ADB, '-s', SERIAL, 'shell', 'input', 'tap',
                str(int(1323 * SCALE)), str(int(461 * SCALE))], timeout=30)
time.sleep(4)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\b_joined2.png', 'wb'), timeout=30)
print('ok')
