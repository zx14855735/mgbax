"""Drive both AVDs with keyevents; usage: python step.py <serial A|B> <key> <count>"""
import subprocess, time, sys

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}
KEY = {'up': 19, 'down': 20, 'left': 21, 'right': 22,
       'a': 96, 'b': 97, 'start': 108, 'select': 109, 'l': 102, 'r': 103}

serial = SER[sys.argv[1]]
code = KEY[sys.argv[2]] if sys.argv[2] in KEY else int(sys.argv[2])
n = int(sys.argv[3]) if len(sys.argv) > 3 else 1
for _ in range(n):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
    time.sleep(0.5)
print('sent', sys.argv[1], sys.argv[2], n)
