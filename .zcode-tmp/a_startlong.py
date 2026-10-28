import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
serial = 'emulator-5554'

def sh(*args, timeout=30):
    subprocess.run([ADB, '-s', serial] + list(args), timeout=timeout)

# long-press START so the game's polling loop definitely samples it
sh('shell', 'input', 'keyevent', '--longevent', '108')
time.sleep(2.5)
sh('shell', 'input', 'keyevent', '--longevent', '108')
time.sleep(3)
with open(r'D:\mgba-android-version\.workbuddy\a_after_start.png', 'wb') as f:
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
with open(r'D:\mgba-android-version\.workbuddy\b_after_start.png', 'wb') as f:
    subprocess.run([ADB, '-s', 'emulator-5556', 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('done')
