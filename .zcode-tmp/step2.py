"""Robust key: --longevent for dpad, normal for A/B/START.
Usage: python step2.py A|B <key> [count]"""
import subprocess, time, sys

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}
KEY = {'up': 19, 'down': 20, 'left': 21, 'right': 22,
       'a': 96, 'b': 97, 'start': 108, 'select': 109, 'l': 102, 'r': 103}
DPAD = {'up', 'down', 'left', 'right'}

serial = SER[sys.argv[1]]
code = KEY[sys.argv[2]] if sys.argv[2] in KEY else int(sys.argv[2])
n = int(sys.argv[3]) if len(sys.argv) > 3 else 1
for _ in range(n):
    if sys.argv[2] in DPAD:
        subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', '--longevent', str(code)], timeout=30)
        time.sleep(0.7)
    else:
        subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
        time.sleep(0.55)
print('sent', sys.argv[1], sys.argv[2], n)
