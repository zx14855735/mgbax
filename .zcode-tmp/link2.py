"""Round 2: dismiss save dialog, navigate to 联机 from 保存 cursor, both to 2P, R on A.
Verifies B is actually polling (logcat kicks) before A presses R."""
import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SA, SB = 'emulator-5554', 'emulator-5556'

def key(serial, code, wait=0.55):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
    time.sleep(wait)

def shot(serial, name):
    with open(r'D:\mgba-android-version\.workbuddy' + '\\' + name + '.png', 'wb') as f:
        subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'], stdout=f, timeout=120)

def logcount(serial, needle):
    r = subprocess.run([ADB, '-s', serial, 'logcat', '-d', '-s', 'mGBA:*'], capture_output=True, timeout=60)
    return sum(1 for ln in r.stdout.decode('utf-8', 'replace').splitlines() if needle in ln)

# --- both: dismiss save-completed dialog (B), back to pause menu (cursor at 保存) ---
for s in (SB, SA):
    key(s, 97, 1.0)
    key(s, 97, 1.0)      # second B in case a "saved!" dialog lingers
    for _ in range(2):
        key(s, 20, 0.45)  # 保存 -> 设置 -> 联机
    key(s, 96, 1.0)       # A -> player count

# B first into wait
key(SB, 96, 1.0)          # 2P -> waiting
kicks_b = logcount(SB, 'SIO kick')
print('B kicks so far:', kicks_b, flush=True)

# A into wait
key(SA, 96, 1.2)          # 2P -> "press R"
time.sleep(1.0)
kicks_a = logcount(SA, 'SIO kick')
print('A kicks so far:', kicks_a, flush=True)

# A presses R a few times over ~8s while both poll
for _ in range(3):
    key(SA, 103, 0.6)
    time.sleep(2.0)
shot(SA, 'fa2')
shot(SB, 'fb2')
kicks_b2 = logcount(SB, 'SIO kick')
kicks_a2 = logcount(SA, 'SIO kick')
print('after R: A kicks', kicks_a2, 'B kicks', kicks_b2)
print('shots fa2/fb2')
