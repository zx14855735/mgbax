"""Open B's link dialog, scroll to GBoy section, tap 大厅加入 by live bounds."""
import subprocess, time, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
B = 'emulator-5556'

def sh(*args, timeout=60):
    subprocess.run([ADB, '-s', B] + list(args), timeout=timeout)

def dump_bounds(label):
    sh('shell', 'uiautomator', 'dump', '/sdcard/ui.xml')
    xml = subprocess.run([ADB, '-s', B, 'shell', 'cat', '/sdcard/ui.xml'],
                         capture_output=True, timeout=60).stdout.decode('utf-8', 'replace')
    for m in re.finditer(r'<node[^>]*>', xml):
        tag = m.group(0)
        t = re.search(r'text="([^"]*)"', tag).group(1)
        if t == label:
            b = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', tag)
            if b:
                x1, y1, x2, y2 = map(int, b.groups())
                return (x1 + x2) // 2, (y1 + y2) // 2
    return None

def tap(x, y, wait=0.8):
    sh('shell', 'input', 'tap', str(x), str(y))
    time.sleep(wait)

tap(782, 47, 0.5)       # ☰ handle
tap(1522, 64, 1.0)      # 联机 item
# scroll to GBoy section
for _ in range(2):
    sh('shell', 'input', 'swipe', '1170', '800', '1170', '240', '350')
    time.sleep(0.8)
pos = dump_bounds('大厅加入')
print('大厅加入 at', pos)
if pos:
    tap(pos[0], pos[1], 1.5)
    # verify
    sh('logcat', '-c')
    time.sleep(1)
    time.sleep(4)
    r = subprocess.run([ADB, '-s', B, 'logcat', '-d', '-s', 'mGBA:*', 'GBoyLink:*'],
                       capture_output=True, timeout=60)
    for ln in r.stdout.decode('utf-8', 'replace').strip().splitlines()[-6:]:
        print(ln)
