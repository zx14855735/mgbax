"""Walk helper: device-side loop of long keyevents (fewer adb round trips, fewer drops).
Usage: python walk.py A|B <up|down|left|right> <count>   (count = number of 0.45s holds)"""
import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}
KEY = {'up': 19, 'down': 20, 'left': 21, 'right': 22}

serial = SER[sys.argv[1]]
code = KEY[sys.argv[2]]
n = int(sys.argv[3])
seq = ' '.join(str(i) for i in range(1, n + 1))
cmd = f'for i in {seq}; do input keyevent --longevent {code}; done'
t0 = time.time()
subprocess.run([ADB, '-s', serial, 'shell', cmd], timeout=300)
print(f'walked {sys.argv[1]} {sys.argv[2]} x{n} in {time.time()-t0:.1f}s')
