"""Tight sequencing: drive both games into 2P wait and press R on A immediately.
Usage: python fastlink.py"""
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

# --- B: close dialog, re-enter 2P wait ---
key(SB, 97, 1.0)        # B: close abort-able dialog
key(SB, 108, 1.2)       # pause menu
for _ in range(4):
    key(SB, 20, 0.45)   # down x4 -> 联机
key(SB, 96, 1.0)        # A -> player count
key(SB, 96, 1.0)        # A -> 2P waiting
print('B in wait', flush=True)

# --- A: close dialog, re-enter 2P, press R immediately ---
key(SA, 97, 1.0)        # B: close
key(SA, 108, 1.2)       # pause menu
for _ in range(4):
    key(SA, 20, 0.45)
key(SA, 96, 1.0)        # A -> player count
key(SA, 96, 1.2)        # A -> 2P "press R"
key(SA, 103, 0.8)       # R -> begin
print('A pressed R', flush=True)
time.sleep(6)
shot(SA, 'fa')
shot(SB, 'fb')
print('shots saved fa/fb')
