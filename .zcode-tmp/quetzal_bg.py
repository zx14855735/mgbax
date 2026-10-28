"""Unattended Quetzal lobby E2E v2:
- Android UI driven by uiautomator text lookup (no coordinate scaling issues)
- ANR auto-dismiss, per-stage verification with retry
- GBA skin buttons keep fixed display coordinates with measured scale
- Evidence (screenshots + logcat) saved to .zcode-tmp/bg/"""
import os
import re
import struct
import subprocess
import sys
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
EMU = r'D:\Android\Sdk\emulator\emulator.exe'
A, B = 'emulator-5554', 'emulator-5556'
OUT = r'D:\mgba-android-version\.zcode-tmp\bg'
os.makedirs(OUT, exist_ok=True)
LOG = open(os.path.join(OUT, 'run.log'), 'a', encoding='utf-8', buffering=1)


def note(msg):
    LOG.write(f'[{time.strftime("%H:%M:%S")}] {msg}\n')


def sh(serial, *args, timeout=40):
    return subprocess.run([ADB, '-s', serial, 'shell'] + list(args),
                          capture_output=True, timeout=timeout).stdout


def tap(serial, x, y, wait=0.4):
    sh(serial, 'input', 'tap', str(int(x)), str(int(y)))
    time.sleep(wait)


def dump_ui(serial):
    for _ in range(3):
        try:
            sh(serial, 'uiautomator', 'dump', '/sdcard/ui.xml', timeout=25)
            xml = sh(serial, 'cat', '/sdcard/ui.xml').decode('utf-8', errors='replace')
            if '<hierarchy' in xml:
                return xml
        except Exception:
            pass
        time.sleep(2)
    return ''


def find_tap(serial, text, wait=1.0):
    xml = dump_ui(serial)
    for m in re.finditer(r'text="([^"]*)"[^>]*bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', xml):
        if text in m.group(1):
            x = (int(m.group(2)) + int(m.group(4))) // 2
            y = (int(m.group(3)) + int(m.group(5))) // 2
            tap(serial, x, y, wait)
            note(f'{serial} tapped [{text}] at {x},{y}')
            return True
    note(f'{serial} NOT FOUND [{text}]')
    return False


def dismiss_anr(serial):
    if find_tap(serial, 'Wait', wait=3.0):
        note(f'{serial} ANR dismissed')
        return True
    return False


def logcat(serial, tag='mGBA:* GBoyLink:*'):
    out = subprocess.run([ADB, '-s', serial, 'shell', f'logcat -d -s {tag}'],
                         capture_output=True, timeout=30).stdout
    return out.decode('utf-8', errors='replace')


def wait_log(serial, needle, timeout=90):
    deadline = time.time() + timeout
    while time.time() < deadline:
        if needle in logcat(serial):
            return True
        time.sleep(4)
    return False


def png_size(data):
    w, h = struct.unpack('>II', data[16:24])
    return w, h


def snap(serial, name):
    raw = subprocess.run([ADB, '-s', serial, 'exec-out', 'screencap', '-p'],
                         capture_output=True, timeout=30).stdout
    open(os.path.join(OUT, name + '.png'), 'wb').write(raw)
    w, h = png_size(raw)
    note(f'snap {name}: {w}x{h}')
    return w, h


def input_width(serial, fallback):
    # landscape input space width; wm size "Override" is authoritative on A
    out = subprocess.run([ADB, '-s', serial, 'shell', 'wm size'], capture_output=True,
                         timeout=30).stdout.decode(errors='replace')
    m = re.search(r'Override size: (\d+)x(\d+)', out) or re.search(r'Physical size: (\d+)x(\d+)', out)
    w, h = int(m.group(1)), int(m.group(2))
    return max(w, h)  # landscape logical width


def gba_scale(serial, shot_w):
    return input_width(serial, None) / shot_w


def adb_ok(serial):
    out = subprocess.run([ADB, 'devices'], capture_output=True).stdout.decode(errors='replace')
    return f'{serial}\tdevice' in out


def wait_boot(serial, timeout=240):
    deadline = time.time() + timeout
    while time.time() < deadline:
        try:
            if sh(serial, 'getprop', 'sys.boot_completed').strip() == b'1':
                return True
        except Exception:
            pass
        time.sleep(5)
    return False


def start_emus():
    env = 'set ANDROID_AVD_HOME=D:\\avd-home\\avd&& set TEMP=D:\\avd-temp&& set TMP=D:\\avd-temp&& '
    for avd, port in (('mgba_test', 5554), ('zx_link_test', 5556)):
        cmd = (f'{env}{EMU} -avd {avd} -no-snapshot -no-boot-anim -no-audio '
               f'-memory 1536 -cores 2 -port {port}')
        subprocess.Popen(['cmd', '/c', cmd], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    note('emulators launched (1536MB each)')


def kill_emus():
    for exe in ('qemu-system-x86_64.exe', 'emulator.exe'):
        subprocess.run(['taskkill', '/F', '/IM', exe], capture_output=True)


def launch_roms():
    for s in (A, B):
        subprocess.run([ADB, '-s', s, 'shell',
                        'am start -n io.mgba.android/.EmulatorActivity -a android.intent.action.VIEW '
                        '-d file:///sdcard/Android/data/io.mgba.android/files/quetzal.gba'],
                       capture_output=True, timeout=30)
    for s in (A, B):
        note(f'{s} rom loaded: {wait_log(s, "Loaded /sdcard", 150)}')
    time.sleep(8)


def lobby_stage():
    # A: host
    for retry in range(2):
        find_tap(A, '☰', wait=0.8)
        find_tap(A, '联机', wait=1.5)
        if not find_tap(A, '大厅创建', wait=1.5):
            find_tap(A, 'CANCEL', wait=1.0)
            continue
        snap(A, 'bg_a_dialog')
        if wait_log(A, 'Link hosting on 6375', 30):
            note('A hosting OK')
            break
        note(f'A hosting retry {retry}')
        find_tap(A, 'CANCEL', wait=1.0)
        dismiss_anr(A)
    # B: join
    joined = False
    for retry in range(2):
        find_tap(B, '☰', wait=0.8)
        find_tap(B, '联机', wait=1.5)
        if not find_tap(B, '大厅加入', wait=1.5):
            find_tap(B, 'CANCEL', wait=1.0)
            continue
        snap(B, 'bg_b_dialog')
        if wait_log(B, 'Link attached as P2', 45):
            note('B joined + tunnel attached')
            joined = True
            break
        note(f'B join retry {retry}')
        find_tap(B, 'CANCEL', wait=1.0)
        dismiss_anr(B)
    wait_log(A, 'Link client accepted', 15)
    snap(A, 'bg_a_lobby'); snap(B, 'bg_b_lobby')
    open(os.path.join(OUT, 'logcat_lobby_A.txt'), 'w', encoding='utf-8').write(logcat(A))
    open(os.path.join(OUT, 'logcat_lobby_B.txt'), 'w', encoding='utf-8').write(logcat(B))
    return joined


def close_dialogs():
    find_tap(A, 'CANCEL', wait=0.8)
    find_tap(B, 'CANCEL', wait=0.8)


def gba_btn(serial, name, sc, wait=0.4):
    A_BTN = {'start': (365, 409), 'a': (1054, 213), 'b': (968, 385), 'l': (59, 143), 'r': (1141, 143),
             'up': (127, 250), 'down': (127, 350), 'left': (80, 297), 'right': (175, 297)}
    B_BTN = {'start': (676, 703), 'a': (1776, 370), 'b': (1640, 666), 'l': (208, 227), 'r': (1912, 227),
             'up': (325, 464), 'down': (325, 600), 'left': (260, 530), 'right': (390, 530)}
    x, y = (A_BTN if serial == A else B_BTN)[name]
    tap(serial, x * sc, y * sc, wait)


def both(name, sa, sb, wait=0.4):
    gba_btn(A, name, sa, wait)
    gba_btn(B, name, sb, wait)


def game_stage(sa, sb):
    both('start', sa, sb, wait=2.5)
    both('a', sa, sb, wait=1.5)
    both('a', sa, sb, wait=4.0)
    snap(A, 'bg_flow1_a'); snap(B, 'bg_flow1_b')
    both('left', sa, sb, wait=0.6)
    both('a', sa, sb, wait=4.0)
    snap(A, 'bg_flow2_a'); snap(B, 'bg_flow2_b')
    open(os.path.join(OUT, 'logcat_flow_A.txt'), 'w', encoding='utf-8').write(logcat(A))
    open(os.path.join(OUT, 'logcat_flow_B.txt'), 'w', encoding='utf-8').write(logcat(B))


def settings_probe(sa, sb):
    # simultaneous held START x3
    for i in range(3):
        procs = []
        for serial, sc in ((A, sa), (B, sb)):
            x, y = ((365, 409) if serial == A else (676, 703))
            X, Y = int(x * sc), int(y * sc)
            procs.append(subprocess.Popen([ADB, '-s', serial, 'shell', 'input', 'swipe',
                                           str(X), str(Y), str(X), str(Y), '700']))
        for p in procs:
            p.wait()
        time.sleep(3)
        snap(A, f'bg_set_a{i}'); snap(B, f'bg_set_b{i}')
    open(os.path.join(OUT, 'logcat_sio_A.txt'), 'w', encoding='utf-8').write(logcat(A))
    open(os.path.join(OUT, 'logcat_sio_B.txt'), 'w', encoding='utf-8').write(logcat(B))


try:
    note('=== background run v2 start ===')
    for attempt in range(1, 4):
        if adb_ok(A) and adb_ok(B):
            break
        kill_emus()
        time.sleep(4)
        start_emus()
        okA, okB = wait_boot(A), wait_boot(B)
        note(f'attempt {attempt}: boot A={okA} B={okB}')
    if not (adb_ok(A) and adb_ok(B)):
        note('FATAL: emulators never came up')
        sys.exit(1)
    dismiss_anr(A); dismiss_anr(B)

    subprocess.run([ADB, '-s', A, 'forward', 'tcp:16374', 'tcp:6374'], timeout=30)
    subprocess.run([ADB, '-s', A, 'forward', 'tcp:16375', 'tcp:6375'], timeout=30)
    subprocess.run([ADB, '-s', A, 'forward', 'tcp:16376', 'tcp:6376'], timeout=30)

    launch_roms()
    dismiss_anr(A); dismiss_anr(B)

    # measure GBA-button scale from a screenshot vs logical input width
    wa, _ = snap(A, 'bg_probe_a')
    wb, _ = snap(B, 'bg_probe_b')
    sa = gba_scale(A, wa)
    sb = gba_scale(B, wb)
    note(f'gba scales A={sa:.4f} B={sb:.4f}')

    if not lobby_stage():
        note('FATAL: lobby stage failed')
        sys.exit(1)
    close_dialogs()
    game_stage(sa, sb)
    settings_probe(sa, sb)
    note('=== background run v2 done (emulators left running) ===')
except Exception as e:
    note(f'FATAL {e!r}')
