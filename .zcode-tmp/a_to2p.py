import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
serial = 'emulator-5554'

def key(code, wait=0.9):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
    time.sleep(wait)

def shot(name):
    with open(r'D:\mgba-android-version\.workbuddy' + '\\' + name + '.png', 'wb') as f:
        subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)

key(20, 0.8)   # down: 设置 -> 联机
key(96, 1.5)   # A -> 选择玩家人数
shot('a_pc2')
print('A should be at player count; check a_pc2.png')
