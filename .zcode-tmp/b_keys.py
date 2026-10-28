import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'
SCALE = 2340 / 2000.0

BTN = {'start': (676, 703), 'a': (1776, 370), 'b': (1640, 666), 'up': (325, 464), 'down': (325, 600), 'left': (260, 530), 'right': (390, 530), 'l': (208, 227), 'r': (1912, 227)}

for arg in sys.argv[1:]:
    name, _, count = arg.partition('x')
    count = int(count) if count else 1
    x, y = BTN[name]
    for _ in range(count):
        subprocess.run([ADB, '-s', SERIAL, 'shell', 'input', 'tap',
                        str(int(x * SCALE)), str(int(y * SCALE))], timeout=30)
        time.sleep(0.35)
subprocess.run([ADB, '-s', SERIAL, 'exec-out', 'screencap', '-p'],
               stdout=open(r'D:\mgba-android-version\.zcode-tmp\b_game.png', 'wb'), timeout=30)
print('ok')
