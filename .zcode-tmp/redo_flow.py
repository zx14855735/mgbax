"""Full redo: reinstall APK, relaunch ROM, rebuild lobby+mirror tunnel,
walk Quetzal title menus in lockstep to the randomizer settings page."""
import subprocess, sys, time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'
B = 'emulator-5556'
BS = 2340 / 2000.0  # B screenshot -> input scale


def sh(serial, *args):
    subprocess.run([ADB, '-s', serial, 'shell'] + list(args), timeout=30)


def tap(serial, x, y, scale=1.0, wait=0.35):
    sh(serial, 'input', 'tap', str(int(x * scale)), str(int(y * scale)))
    time.sleep(wait)


def snap(serial, name):
    subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                   stdout=open(rf'D:\mgba-android-version\.zcode-tmp\{name}.png', 'wb'), timeout=30)


def log(serial, tag='mGBA'):
    out = subprocess.run([ADB, '-s', serial, 'shell', f'logcat -d -s {tag}:* | tail -n 40'],
                         capture_output=True, timeout=30)
    return out.stdout.decode('utf-8', errors='replace')


stage = sys.argv[1] if len(sys.argv) > 1 else 'all'

if stage in ('all', 'install'):
    for s in (A, B):
        subprocess.run([ADB, '-s', s, 'install', '-r',
                        r'android\app\build\outputs\apk\debug\app-debug.apk'],
                       capture_output=True, timeout=300)
        print(s, 'installed')
    for s in (A, B):
        subprocess.run([ADB, '-s', s, 'shell',
                        'am start -n io.mgba.android/.EmulatorActivity -a android.intent.action.VIEW '
                        '-d file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba'], timeout=30)
    print('launched, waiting for title...')
    time.sleep(10)

if stage in ('all', 'lobby'):
    # A: host lobby 6374 (+sio 6375); B: join 10.0.2.2:16374
    tap(A, 352, 25); tap(A, 778, 32, wait=1.2)
    for _ in range(2):
        sh(A, 'input', 'swipe', '600', '400', '600', '130', '400'); time.sleep(0.5)
    tap(A, 432, 291)          # 大厅创建
    time.sleep(1.0)
    tap(B, 672, 41, BS); tap(B, 1297, 55, BS, wait=1.2)
    for _ in range(3):
        sh(B, 'input', 'swipe', str(int(600 * BS)), str(int(400 * BS)),
           str(int(600 * BS)), str(int(130 * BS)), '400'); time.sleep(0.5)
    tap(B, 1323, 461, BS)     # 大厅加入 (fields prefilled 10.0.2.2/16374)
    time.sleep(4)
    # close dialogs
    tap(A, 892, 475)
    tap(B, 1527, 822, BS, wait=1.0)
    print('A:', [l for l in log(A).splitlines() if 'Link' in l][-2:])
    print('B:', [l for l in log(B).splitlines() if 'Link' in l][-2:])

if stage in ('all', 'game'):
    # Quetzal title menus in lockstep
    tap(A, 365, 409); tap(B, 676, 703, BS)          # START on title
    time.sleep(2.0)
    tap(A, 1054, 213); tap(B, 1776, 370, BS)        # A: reveal 开始游戏
    time.sleep(1.0)
    tap(A, 1054, 213); tap(B, 1776, 370, BS)        # A: confirm 开始游戏 (both)
    time.sleep(3.0)
    snap(A, 'flow_a1'); snap(B, 'flow_b1')
    print('--- stage game part1 done; check flow_a1/flow_b1')
