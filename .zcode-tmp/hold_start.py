import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'

# hold START ~700ms on both devices at once
procs = []
for serial, x, y, scale in (('emulator-5554', 365, 409, 1.0), ('emulator-5556', 676, 703, 2340 / 2000.0)):
    X, Y = int(x * scale), int(y * scale)
    procs.append(subprocess.Popen([ADB, '-s', serial, 'shell', 'input', 'swipe', str(X), str(Y), str(X), str(Y), '700']))
for p in procs:
    p.wait()
time.sleep(1.5)
for serial, name in (('emulator-5554', 'shotA'), ('emulator-5556', 'shotB')):
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)
print('ok')
