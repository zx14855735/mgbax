import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
serial = 'emulator-5556'

def key(code, wait=0.9):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
    time.sleep(wait)

key(108, 2.0)          # pause menu
for _ in range(4):
    key(20, 0.6)       # down to 联机
key(96, 1.5)           # A -> player count
with open(r'D:\mgba-android-version\.workbuddy\b_pc.png', 'wb') as f:
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('done')
