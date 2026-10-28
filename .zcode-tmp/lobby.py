import subprocess, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A, B = 'emulator-5554', 'emulator-5556'
BS = 2340 / 2000.0


def sh(serial, *args):
    subprocess.run([ADB, '-s', serial, 'shell'] + list(args), timeout=30)


def tap(serial, x, y, scale=1.0, wait=0.35):
    sh(serial, 'input', 'tap', str(int(x * scale)), str(int(y * scale)))
    time.sleep(wait)


def swipe(serial, x1, y1, x2, y2, scale=1.0, ms=400, wait=0.5):
    sh(serial, 'input', 'swipe', str(int(x1 * scale)), str(int(y1 * scale)),
       str(int(x2 * scale)), str(int(y2 * scale)), str(ms))
    time.sleep(wait)


def snap(serial, name):
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)


def slog(serial):
    out = subprocess.run([ADB, '-s', serial, 'shell', 'logcat -d -s mGBA:* GBoyLink:* | tail -n 30'],
                         capture_output=True, timeout=30)
    return [l for l in out.stdout.decode('utf-8', errors='replace').splitlines()
            if 'Link' in l or 'SIO' in l or 'GBoy' in l]


# A: open link dialog, scroll to lobby block, 大厅创建
tap(A, 352, 25)
tap(A, 778, 32, wait=1.2)
swipe(A, 600, 400, 600, 130)
swipe(A, 600, 400, 600, 130)
snap(A, 'lg_a_dlg')
tap(A, 432, 291, wait=1.0)
print('A log:', slog(A)[-3:])

# B: open link dialog, scroll, 大厅加入 (fields prefilled)
tap(B, 672, 41, BS)
tap(B, 1297, 55, BS, wait=1.2)
for _ in range(3):
    swipe(B, 600, 400, 600, 130, BS)
snap(B, 'lg_b_dlg')
tap(B, 1323, 461, BS, wait=4.0)
print('B log:', slog(B)[-4:])
