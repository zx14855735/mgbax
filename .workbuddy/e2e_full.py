"""一次跑完整流程：拉起两个模拟器 → 等设备 online → 跑联机对战 E2E → 落盘日志。

分开跑时模拟器进程会被回收，所以「起模拟器 + 等就绪 + 跑流程」必须放在同一个
任务里，保证它们在同一进程树内存活。
"""
import os
import subprocess
import sys
import time

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
ROOT = r'D:\mgba-android-version'
OUT = os.path.join(ROOT, '.workbuddy')
sys.path.insert(0, OUT)
FLOW = sys.argv[1] if len(sys.argv) > 1 else 'runlink2'


def devices():
    try:
        out = subprocess.run([ADB, 'devices'], capture_output=True, timeout=60).stdout.decode('utf-8', 'replace')
    except Exception:
        return []
    return [l.split('\t')[0] for l in out.splitlines() if '\tdevice' in l]


def main():
    log = open(os.path.join(OUT, 'avds_e2e.log'), 'w')
    subprocess.Popen(['bash', '.workbuddy/start_avds3.sh'], cwd=ROOT, stdout=log, stderr=subprocess.STDOUT)

    ok = False
    for i in range(72):
        time.sleep(5)
        d = devices()
        print('t=%ds devices=%s' % (i * 5, d), flush=True)
        if 'emulator-5554' in d and 'emulator-5556' in d:
            ok = True
            break
    if not ok:
        print('EMULATORS FAILED TO COME UP')
        return 1

    # 等屏幕真正就绪（能截到图），不要一 online 就开跑
    for i in range(30):
        time.sleep(5)
        good = 0
        for s in ('emulator-5554', 'emulator-5556'):
            r = subprocess.run([ADB, '-s', s, 'exec-out', 'screencap', '-p'],
                               capture_output=True, timeout=90)
            if len(r.stdout) > 5000:
                good += 1
        print('t=%ds screens_ok=%d' % (i * 5, good), flush=True)
        if good == 2:
            break

    # 确保 ROM 在位，并从「最后一次打开的 ROM」之外的确定路径启动
    for s in ('emulator-5554', 'emulator-5556'):
        subprocess.run([ADB, '-s', s, 'shell', 'mkdir', '-p',
                        '/sdcard/Android/data/io.mgba.android/files'], capture_output=True, timeout=60)
        for dst in ('/sdcard/Android/data/io.mgba.android/files/rom.gba', '/sdcard/Download/rom.gba'):
            subprocess.run([ADB, '-s', s, 'push', r'D:\gen8\rom.gba', dst],
                           capture_output=True, timeout=300)
        subprocess.run([ADB, '-s', s, 'shell', 'logcat', '-c'], capture_output=True, timeout=60)

    print('=== devices ready, running flow ===', flush=True)

    flow = __import__(FLOW)
    flow.main()

    for s, tag in (('emulator-5554', 'A'), ('emulator-5556', 'B')):
        out = subprocess.run([ADB, '-s', s, 'shell', 'logcat', '-d', '-s', 'mGBA', '-v', 'brief'],
                             capture_output=True, timeout=120).stdout.decode('utf-8', 'replace')
        with open(os.path.join(OUT, 'e2e_' + tag + '.log'), 'w', encoding='utf-8') as f:
            f.write(out)
        print(tag, 'mGBA log lines', len(out.splitlines()), flush=True)
        # 崩溃/ANR 也留一份，避免只在 mGBA tag 里找时漏掉
        crash = subprocess.run([ADB, '-s', s, 'shell', 'logcat', '-d', '-v', 'brief'],
                               capture_output=True, timeout=120).stdout.decode('utf-8', 'replace')
        hits = [l for l in crash.splitlines()
                if 'AndroidRuntime' in l or 'FATAL' in l or 'tombstone' in l or 'am_proc_died' in l]
        with open(os.path.join(OUT, 'e2e_' + tag + '_crash.log'), 'w', encoding='utf-8') as f:
            f.write('\n'.join(hits[-40:]))
        print(tag, 'crash-ish lines', len(hits), flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())
