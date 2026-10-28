"""Tap a quick sequence then screenshot: python tapseq.py A 352,25 751,33 [name]"""
import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

serial = SER[sys.argv[1]]
name = sys.argv[-1] if not ',' in sys.argv[-1] else sys.argv[1] + '_seq'
taps = [a for a in sys.argv[2:] if ',' in a]
for t in taps:
    x, y = t.split(',')
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'tap', x, y], timeout=30)
    time.sleep(0.3)
time.sleep(1.2)
path = r'D:\mgba-android-version\.workbuddy' + '\\' + name + '.png'
with open(path, 'wb') as f:
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('taps', taps, '->', path)
