import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

whom = sys.argv[1]
serial = {'A': 'emulator-5554', 'B': 'emulator-5556'}[whom]
n = int(sys.argv[2]) if len(sys.argv) > 2 else 1
for _ in range(n):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', '96'], timeout=30)
    time.sleep(1.2)
print('A sent x', n, 'to', whom)
