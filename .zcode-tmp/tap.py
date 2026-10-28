"""Tap screen coords (screencap space) then screenshot.
Usage: python tap.py A 352 25 [outname]"""
import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

serial = SER[sys.argv[1]]
x, y = int(sys.argv[2]), int(sys.argv[3])
name = sys.argv[4] if len(sys.argv) > 4 else (sys.argv[1] + '_tap')
subprocess.run([ADB, '-s', serial, 'shell', 'input', 'tap', str(x), str(y)], timeout=30)
time.sleep(1.5)
path = r'D:\mgba-android-version\.workbuddy' + '\\' + name + '.png'
with open(path, 'wb') as f:
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('tapped', sys.argv[1], x, y, '->', path)
