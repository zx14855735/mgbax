import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5554'

BTN = {'start': (365, 409), 'a': (1054, 213), 'b': (968, 385), 'l': (59, 143), 'r': (1141, 143),
       'up': (127, 250), 'down': (127, 350), 'left': (80, 297), 'right': (175, 297)}

for arg in sys.argv[1:]:
    name, _, count = arg.partition('x')
    count = int(count) if count else 1
    x, y = BTN[name]
    for _ in range(count):
        subprocess.run([ADB, '-s', SERIAL, 'shell', 'input', 'tap', str(x), str(y)], timeout=30)
        time.sleep(0.35)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\a_game.png', 'wb'), timeout=30)
print('ok')
