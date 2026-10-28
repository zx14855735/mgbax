import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SA = 'emulator-5554'

def key(serial, code, wait=0.5):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
    time.sleep(wait)

def shot(serial, name):
    with open(r'D:\mgba-android-version\.workbuddy' + '\\' + name + '.png', 'wb') as f:
        subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)

subprocess.run([ADB, '-s', SA, 'logcat', '-c'], timeout=30)
subprocess.run([ADB, '-s', 'emulator-5556', 'logcat', '-c'], timeout=30)
key(SA, 96, 1.5)     # A -> 2P
time.sleep(1.5)
key(SA, 103, 0.8)    # R
time.sleep(3)
key(SA, 103, 0.8)    # R
time.sleep(5)
shot(SA, 'fa5')
with open(r'D:\mgba-android-version\.workbuddy\fb5.png', 'wb') as f:
    subprocess.run([ADB, '-s', 'emulator-5556', 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)
print('done')
