import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

# args: key [hold_ms]  -> press key on BOTH devices at once (hold via swipe)
key = sys.argv[1]
hold = int(sys.argv[2]) if len(sys.argv) > 2 else 0

POS = {
    'a': ((1054, 213, 1.0), (1776, 370, 2340 / 2000.0)),
    'b': ((968, 385, 1.0), (1640, 666, 2340 / 2000.0)),
    'start': ((365, 409, 1.0), (676, 703, 2340 / 2000.0)),
    'select': ((352, 468, 1.0), (648, 802, 2340 / 2000.0)),
    'l': ((59, 143, 1.0), (208, 227, 2340 / 2000.0)),
    'r': ((1141, 143, 1.0), (1912, 227, 2340 / 2000.0)),
}
serials = ('emulator-5554', 'emulator-5556')
procs = []
for serial, (x, y, scale) in zip(serials, POS[key]):
    X, Y = int(x * scale), int(y * scale)
    if hold:
        procs.append(subprocess.Popen([ADB, '-s', serial, 'shell', 'input', 'swipe',
                                       str(X), str(Y), str(X), str(Y), str(hold)]))
    else:
        procs.append(subprocess.Popen([ADB, '-s', serial, 'shell', 'input', 'tap', str(X), str(Y)]))
for p in procs:
    p.wait()
time.sleep(1.5)
for serial, name in zip(serials, ('shotA', 'shotB')):
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)
print('ok', key, hold)
