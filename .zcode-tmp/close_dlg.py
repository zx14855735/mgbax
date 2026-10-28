import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}
CANCEL = {'A': (890, 474), 'B': (1769, 959)}

for k in ('A', 'B'):
    subprocess.run([ADB, '-s', SER[k], 'shell', 'input', 'tap', str(CANCEL[k][0]), str(CANCEL[k][1])], timeout=30)
    time.sleep(0.8)
print('dialogs closed')
# clear logcat for clean SIO observation
for k in ('A', 'B'):
    subprocess.run([ADB, '-s', SER[k], 'logcat', '-c'], timeout=30)
print('logcat cleared')
