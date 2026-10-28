import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SA, SB = 'emulator-5554', 'emulator-5556'

def key(serial, code, wait=0.5):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
    time.sleep(wait)

def shot(serial, name):
    with open(r'D:\mgba-android-version\.workbuddy' + '\\' + name + '.png', 'wb') as f:
        subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)

key(SB, 96, 1.2)        # B -> 2P waiting
key(SA, 103, 0.8)       # A -> R (begin)
time.sleep(2.5)
key(SA, 103, 0.8)       # R again
time.sleep(2.5)
key(SA, 103, 0.8)       # R again
time.sleep(4)
shot(SA, 'fa3')
shot(SB, 'fb3')
print('done fa3/fb3')
