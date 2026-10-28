"""Fix the two GBoy fields in place (layout stable, IME hidden), then verify."""
import subprocess, time, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
A = 'emulator-5554'

def sh(*args, timeout=60):
    subprocess.run([ADB, '-s', A] + list(args), timeout=timeout)

def tap(x, y, wait=0.7):
    sh('shell', 'input', 'tap', str(x), str(y))
    time.sleep(wait)

def fill(x, y, value, dels):
    tap(x, y, 0.6)
    sh('shell', 'input', 'keyevent', '123')
    for _ in range(dels):
        sh('shell', 'input', 'keyevent', '67')
        time.sleep(0.08)
    time.sleep(0.2)
    sh('shell', 'input', 'text', value)
    time.sleep(0.4)
    tap(600, 73, 0.8)   # title: drop focus, keep dialog

fill(600, 237, '10.0.2.2', 14)
fill(600, 307, '16375', 8)

sh('shell', 'uiautomator', 'dump', '/sdcard/ui.xml')
xml = subprocess.run([ADB, '-s', A, 'shell', 'cat', '/sdcard/ui.xml'],
                     capture_output=True, timeout=60).stdout.decode('utf-8', 'replace')
for m in re.finditer(r'<node[^>]*>', xml):
    tag = m.group(0)
    t = re.search(r'text="([^"]*)"', tag).group(1)
    cls = re.search(r'class="([^"]*)"', tag).group(1).split('.')[-1]
    if cls in ('EditText', 'Button') and t.strip():
        b = re.search(r'bounds="(\[[^"]*\])"', tag).group(1)
        print(f'{cls:9} {t[:30]!r:34} {b}')
