"""Swipe up inside a dialog to reveal lower content, then screenshot.
Usage: python scroll_dlg.py A [name]"""
import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

serial = SER[sys.argv[1]]
name = sys.argv[2] if len(sys.argv) > 2 else sys.argv[1] + '_scroll'
# A coords are 1200x540; B is 2340x1080
if sys.argv[1] == 'A':
    x1, y1, x2, y2 = 600, 460, 600, 180
else:
    x1, y1, x2, y2 = 1170, 920, 1170, 360
subprocess.run([ADB, '-s', serial, 'shell', 'input', 'swipe', str(x1), str(y1), str(x2), str(y2), '400'], timeout=30)
time.sleep(1.2)
path = r'D:\mgba-android-version\.workbuddy' + '\\' + name + '.png'
with open(path, 'wb') as f:
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('scrolled', sys.argv[1], '->', path)
