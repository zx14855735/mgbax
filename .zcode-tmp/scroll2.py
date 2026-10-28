"""Swipe inside dialog content area A(600,400)->(600,120) / B(1170,800)->(1170,240), then dump texts."""
import subprocess, time, io, sys, re
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

serial = SER[sys.argv[1]]
if sys.argv[1] == 'A':
    x1, y1, x2, y2 = 600, 400, 600, 120
else:
    x1, y1, x2, y2 = 1170, 800, 1170, 240
subprocess.run([ADB, '-s', serial, 'shell', 'input', 'swipe', str(x1), str(y1), str(x2), str(y2), '350'], timeout=30)
time.sleep(1.0)
r = subprocess.run([ADB, '-s', serial, 'shell', 'uiautomator', 'dump', '/sdcard/ui.xml'],
                   capture_output=True, timeout=60)
xml = subprocess.run([ADB, '-s', serial, 'shell', 'cat', '/sdcard/ui.xml'],
                     capture_output=True, timeout=60).stdout.decode('utf-8', 'replace')
for m in re.finditer(r'<node[^>]*>', xml):
    tag = m.group(0)
    text = re.search(r'text="([^"]*)"', tag)
    bounds = re.search(r'bounds="([^"]*)"', tag)
    clickable = 'clickable="true"' in tag
    t = text.group(1) if text else ''
    if t.strip() or clickable:
        print(f'{t[:36]!r:40} click={str(clickable):5} {bounds.group(1) if bounds else ""}')
