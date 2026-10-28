"""Drive the in-game multiplayer menu.
Usage: python ingame.py B|A  -> title START, main menu A(continue), pause menu, down x4, A, 2P
       python ingame.py B|A partial  -> stop before the final 2P confirm
"""
import subprocess, time, io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

serial = SER[sys.argv[1]]
partial = len(sys.argv) > 2 and sys.argv[2] == 'partial'

def key(code, wait=0.9):
    subprocess.run([ADB, '-s', serial, 'shell', 'input', 'keyevent', str(code)], timeout=30)
    time.sleep(wait)

# title -> main menu
key(108, 2.5)
if partial:
    print('done partial')
    sys.exit(0)
# main menu: 继续游戏 -> A
key(96, 3.0)
# skip any intro dialogs (2 presses of A/B)
for _ in range(3):
    key(96, 1.0)
# pause menu
key(108, 2.0)
# down x4 to 联机
for _ in range(4):
    key(20, 0.6)
# A -> 选择玩家人数
key(96, 1.5)
print('reached player-count screen (or near)')
